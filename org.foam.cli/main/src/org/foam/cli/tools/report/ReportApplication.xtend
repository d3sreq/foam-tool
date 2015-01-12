package org.foam.cli.tools.report

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.Files
import java.io.File
import java.util.HashMap
import java.util.List
import java.util.Map
import joptsimple.OptionParser
import org.apache.log4j.Logger
import org.foam.annotation.AnnotationPackage
import org.foam.bootstrap.FileUtils
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.cli.tools.report.pages.ErrorPage
import org.foam.cli.tools.report.pages.Menu
import org.foam.cli.tools.report.pages.MenuCategory
import org.foam.cli.tools.report.pages.MenuItem
import org.foam.cli.tools.report.pages.OverviewPage
import org.foam.cli.tools.report.pages.Page
import org.foam.cli.tools.report.pages.TadlTemplatePage
import org.foam.cli.tools.report.pages.UseCasePage
import org.foam.cntex.Specification
import org.foam.ctl.CtlPackage
import org.foam.dot.DotPackage
import org.foam.dot.Graph
import org.foam.flowannotation.FlowannotationPackage
import org.foam.ltl.LtlPackage
import org.foam.lts.LtsPackage
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.tadl.Group
import org.foam.tadl.TadlPackage
import org.foam.tadl.Template
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex
import org.foam.transform.cntexlang2cntex.CntexStateResolver
import org.foam.transform.cntexlang2cntex.SpecificationResolver
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.lts2dot.Lts2Dot
import org.foam.transform.lts2nusmvlang.Lts2NusmvLangService
import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.foam.transform.ucm.overview.dot.UcmOverviewUsingDot
import org.foam.transform.ucm2lts.Ucm2LtsFacade
import org.foam.transform.ucm2ucm.UcmParseModel2UcmService
import org.foam.transform.ucm2ucm.UcmParser
import org.foam.transform.ucm2ucm.flowannotationresolver.FlowAnnotationResolver
import org.foam.transform.ucm2ucm.tadlannotationresolver.TadlAnnotationResolver
import org.foam.transform.utils.graphviz.GraphvizWrapper
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.transform.utils.nusmv.NusmvWrapper
import org.foam.ucm.UcmPackage
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel
import org.foam.verification.VerificationPackage
import org.osgi.framework.FrameworkUtil

import static extension org.foam.cntex.util.CntexModelExtensions.*

@Component(provide=#[ReportApplication, IExecutableTool])
class ReportApplication implements IExecutableTool {
	
	static extension Logger = Logger.getLogger(ReportApplication)

	private NusmvWrapper nusmvWrapper
	@Reference def void setNusmvWrapper(NusmvWrapper nusmvWrapper) {
		this.nusmvWrapper = nusmvWrapper
	}

	private GraphvizWrapper graphvizWrapper
	@Reference def void setGraphvizWrapper(GraphvizWrapper graphvizWrapper) {
		this.graphvizWrapper = graphvizWrapper
	}

	private UcmParser ucmParser
	@Reference def void setUcmParser(UcmParser ucmParser) {
		this.ucmParser = ucmParser
	}
	
	private UcmParseModel2UcmService ucmParseModel2UcmService
	@Reference def void setUcmParseModel2UcmService(UcmParseModel2UcmService ucmParseModel2UcmService) {
		this.ucmParseModel2UcmService = ucmParseModel2UcmService
	}
	
	private Lts2NusmvLangService lts2NusmvLangService
	@Reference def void setLts2NusmvLangService(Lts2NusmvLangService serviceRef) {
		this.lts2NusmvLangService = serviceRef
	}

	private UcmOverviewUsingDot ucmOverviewUsingDot
	@Reference def void setUcmOverviewCreator(UcmOverviewUsingDot ucmOverviewUsingDot) {
		this.ucmOverviewUsingDot = ucmOverviewUsingDot
	}

	override execute(String[] args) {

		// parse options
		val optionParser = new OptionParser
		val inputOption = optionParser.accepts("i", "input dir").withRequiredArg.describedAs("directory with textual use cases")
		val tadlOption = optionParser.accepts("t", "tadl input dir").withRequiredArg.describedAs("directory with textual tadl definitions")
		val outputOption = optionParser.accepts("o", "output dir").withOptionalArg.describedAs("output directory for html report")
		optionParser.acceptsAll(newArrayList("h", "?"), "show help")
		
		val options = optionParser.parse(args)
		
		val inputDirName = if (options.has(inputOption) && options.hasArgument(inputOption)) {
			inputOption.value(options)
		} else {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val tadlDirName = if (options.has(tadlOption) && options.hasArgument(tadlOption)) {
			tadlOption.value(options)
		} else {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val outputDirName = if (options.has(outputOption) && options.hasArgument(outputOption)) {
			outputOption.value(options)
		} else {
			"report"
		}
		
		'''Model factories initialization'''.debug
		init()
		
		// transformations
		val useCaseModel = ucmlang2Ucm(inputDirName)
		'''Validating input UseCaseModel (with resolved flow annotations)'''.debug
		EmfCommons.basicValidate(useCaseModel)
		
		val templates = tadlLang2Templates(tadlDirName)
		'''Validating input TADL templates'''.debug
		templates.forEach[EmfCommons.basicValidate(it)]
		
		resolveTadlAnnotations(useCaseModel, templates)
		'''Validating UseCaseModel with resolved TADL annotations'''.debug
		EmfCommons.basicValidate(useCaseModel)
		
		val counterExamples = useCaseModel.counterExamples

		'''Merging errors from counter examples'''.debug
		val specifications = counterExamples
			.map[specifications]
			.flatten
			.filter[trace != null]
			.uniqueSpecifications
		
		
		//specifications.forEach[
		//	println("---------------------------------")
		//	println(it)
		//	it.trace.states.forEach[println(it.assignments.map['''«variableName» -> «value»'''].join(", "))]
		//]
			
		'''Validating error specifications'''.debug
		specifications.forEach[EmfCommons.basicValidate(it)]
		
		createReport(useCaseModel, templates, specifications, outputDirName)
		
		'''Report generation done.'''.info
	}
	
	override getUsage() '''
	Runs the whole FOAM workflow and generates an HTML report. 
	'''

	def private createReport(UseCaseModel useCaseModel, Iterable<Template> templates, Iterable<Specification> specifications, String outputDirName) {
		'''Writing the results'''.debug
		copyWebFiles(outputDirName)
		
		// prepare menu
		val menu = new Menu
		
		// overview
		val overviewCategory = new MenuCategory(null)
		menu.categories += overviewCategory
		val OverviewPage overviewPage = createOverviewPage(useCaseModel, menu, outputDirName)
		overviewCategory.menuItems += new MenuItem("Overview", "../overview/overview.html", overviewPage)

		// primary use cases
		val primaryUseCasesCategory = new MenuCategory("Primary use cases")
		menu.categories += primaryUseCasesCategory		
		val primaryUseCases = useCaseModel.useCases.filter[it.primary]
		val primaryUseCasesPages = primaryUseCases.map[it.createUseCasePage(menu, outputDirName)]
		primaryUseCasesCategory.menuItems += primaryUseCasesPages.map[it.createUseCaseMenuItem(menu)]
		primaryUseCasesCategory.sort
		
		// non-primary use cases
		val nonPrimaryUseCasesCategory = new MenuCategory("Non-primary use cases")
		menu.categories += nonPrimaryUseCasesCategory		
		val nonPrimaryUseCases = useCaseModel.useCases.filter[!it.primary]
		val nonPrimaryUseCasesPages = nonPrimaryUseCases.map[it.createUseCasePage(menu, outputDirName)]
		nonPrimaryUseCasesCategory.menuItems += nonPrimaryUseCasesPages.map[it.createUseCaseMenuItem(menu)]
		nonPrimaryUseCasesCategory.sort
		
		// TADL definitions
		val tadlCategory = new MenuCategory("TADL definitions")
		menu.categories += tadlCategory
		val tadlPages = templates.map[it.createTadlTemplatePage(menu)]
		tadlCategory.menuItems += tadlPages.map[it.createTadlPageMenuItem(menu)]
		tadlCategory.sort
		
		// errors
		val errorsCategory = new MenuCategory("Errors")
		menu.categories += errorsCategory
		val group2Specification = partitionByGroup(specifications)
		val errorPages = specifications.map[it.createErrorPage(menu, group2Specification)]
		errorsCategory.menuItems += errorPages.map[it.createErrorPageMenuItem(menu)]
		errorsCategory.sort
		
		'''Writing pages to disk'''.debug
		menu.categories.map[it.menuItems].flatten.forEach[it.page.writePage(outputDirName)]
	}
	
	def private partitionByGroup(Iterable<Specification> specifications) {
		val result = new HashMap<Group, List<Specification>>
		
		for (specification : specifications) {
			val Group group = specification.group
			if (!result.containsKey(group)) {
				result.put(group, newArrayList)
			}
			
			result.get(group).add(specification)
		}
		
		result
	}
	
	def private getErrorPageOrderId(Specification specification, Map<Group, List<Specification>> partitionByGroup) {
		val list = partitionByGroup.get(specification.group)
		if (list.size == 1) {
			// only specification with given group - no need for additional qualifier 
			return ""
		} else {
			return (list.indexOf(specification) + 1).toString
		}
	}
	
	def private createOverviewPage(UseCaseModel ucm, Menu menu, String outputDirName) {
		
		val dotCode = ucmOverviewUsingDot.transform(ucm)
		val svgFileName = '''overview.svg'''
		val fullPathToSvg = '''«outputDirName»/overview/«svgFileName»'''
		graphvizWrapper.createSvg(dotCode, fullPathToSvg)
		
		new OverviewPage(menu, svgFileName)
	}
	
	def private createUseCasePage(UseCase useCase, Menu menu, String outputDirName) {
		// ucm -> lts -> dot
		val automaton = Ucm2LtsFacade.transformSingleUseCaseForPage(useCase)
		'''Validating «useCase.id» LTS'''.debug
		EmfCommons.basicValidate(automaton)
		
		// TODO - optimize - read init graph only once and then copy it
		// load XMI from bundle
		val graphTemplate = FrameworkUtil.getBundle(class).getResource("/report/dot/GraphTemplate.xmi").openStream
		val initGraph = EmfCommons.readModel(graphTemplate) as Graph

		'''Validating init DOT graph'''.debug
		EmfCommons.basicValidate(initGraph)
		
		val dotGraph = new Lts2Dot().transformSingleUseCase(automaton, initGraph)
		'''Validating DOT graph'''.debug
		EmfCommons.basicValidate(dotGraph)
		
		// dot -> svg (with links)
		val dotContent = new Dot2DotLang().transform(dotGraph)
		val imageFileName = '''«useCase.id».svg'''
		val fullPathToImage = '''«outputDirName»/«useCase.id»/«imageFileName»'''
		graphvizWrapper.createSvg(dotContent, fullPathToImage)
		
		new UseCasePage(useCase, menu, imageFileName)
	}
	
	def private createTadlTemplatePage(Template template, Menu menu) {
		new TadlTemplatePage(menu, template)
	}
	
	def private createErrorPage(Specification specification, Menu menu, Map<Group, List<Specification>> group2Specifications) {
		val orderId = getErrorPageOrderId(specification, group2Specifications)
		new ErrorPage(menu, specification, orderId)
	}
	
	def private createErrorPageMenuItem(ErrorPage errorPage, Menu menu) {
		val id = errorPage.id
		val orderId = errorPage.orderId
		val qualifier = errorPage.group.qualifier
		val menuText = '''«errorPage.joinedVars» «qualifier»«IF !orderId.empty» «orderId»«ENDIF»'''
		new MenuItem(menuText, '''../«id»/«id».html''', errorPage)
	}
	
	def private createUseCaseMenuItem(UseCasePage useCasePage, Menu menu) {
		val id = useCasePage.useCase.id
		new MenuItem('''«id» «useCasePage.useCase.name»''', '''../«id»/«id».html''', useCasePage)
	}
	
	def private createTadlPageMenuItem(TadlTemplatePage tadlTemplatePage, Menu menu) {
		val id = tadlTemplatePage.id
		new MenuItem(id, '''../«id»/«id».html''', tadlTemplatePage)
	}
	
	def private writePage(Page page, String outputDirName) {
		val pageDir = new File(new File(outputDirName), page.id)
		pageDir.mkdir
		
		val pageFile = new File(pageDir, '''«page.id».html''')
		Files.write(page.content, pageFile, Charsets.UTF_8)
	}
	
	def private void init() {
		'''Initializing required meta-models'''.debug		
		AnnotationPackage.eINSTANCE.eClass
		DotPackage.eINSTANCE.eClass
		PropositionallogicPackage.eINSTANCE.eClass
		LtlPackage.eINSTANCE.eClass
		CtlPackage.eINSTANCE.eClass
		LtsPackage.eINSTANCE.eClass
		TadlPackage.eINSTANCE.eClass
		FlowannotationPackage.eINSTANCE.eClass
		UcmPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
		VerificationPackage.eINSTANCE.eClass
		EmfCommons.registerAsteriskInExtensionToFactory
	}
	
	def private getCounterExamples(UseCaseModel useCaseModel) {
		useCaseModel
			.useCases
			.filter[primary]
			.map[ useCase |
	
				'''transforming «useCase.id» to LTS'''.debug
				val automaton = Ucm2LtsFacade.transformSingleUseCase(useCaseModel, useCase)
				
				'''transforming LTS to NuSMV code'''.debug
				val code = lts2NusmvLangService.transform(automaton)
				val holderGroupList = lts2NusmvLangService.getHolderGroupList(automaton) 
				
				'''running NuSMV verification'''.debug
				val cntexCode = nusmvWrapper.runNusmvCode(code).join("\n") //TODO: do we really need to convert this to String from an array?
				
				'''parsing counter example code to CounterExample'''.debug
				val counterExample = new CntexLang2Cntex().transform(cntexCode)
				new CntexStateResolver().transform(counterExample, automaton)
				
				Preconditions.checkState(counterExample.specifications.size == holderGroupList.size)
				new SpecificationResolver().transform(counterExample, holderGroupList)
				
				return counterExample
			]
	}
	
	def private UseCaseModel ucmlang2Ucm(String inputDirName) {
		'''Reading use case files from the directory "«inputDirName»"'''.info
		val texts = readTexts(inputDirName)

		'''Parsing use cases'''.debug
		val parsedTexts = texts.map[ucmParser.parse(it)]
		val resultPair = ucmParseModel2UcmService.transform(parsedTexts)

		'''Resolving FLOW annotations'''.debug
		new FlowAnnotationResolver().resolveAnnotations(resultPair.key, resultPair.value)
		
		// TODO - use also trace information
		resultPair.key
	}
	
	def private Iterable<Template> tadlLang2Templates(String tadlDirName) {
		val tadlLang2Tadl = new TadlLang2Tadl
		
		'''Reading TADL definitions from directory "«tadlDirName»"'''.info
		val texts = readTexts(tadlDirName)
		
		'''Running the transformation'''.debug
		val templates = texts.map[tadlLang2Tadl.parse(it)]
		
		'''TADL files resolved'''.debug
		
		return templates
	}
	
	def private resolveTadlAnnotations(UseCaseModel useCaseModel, Iterable<Template> templates) {
		'''Resolving TADL annotations'''.debug
		new TadlAnnotationResolver().resolveAnnotations(useCaseModel, templates)
	}
	
	def private copyWebFiles(String outputDir) {
		'''Copying template web files to output directory «outputDir»'''.debug
		FileUtils.bundleCopy(ReportApplication, "report/web", outputDir)
	}
	
	/**
	 * Gets String content of each file in the given directory
	 */
	def private Iterable<String> readTexts(String inputDir) {

		Preconditions.checkNotNull( inputDir )
		Preconditions.checkArgument( ! inputDir.empty )
		
		val dir = new File(inputDir)
		Preconditions.checkState(dir.exists)
		Preconditions.checkState(dir.isDirectory)
		
		dir.listFiles.map[Files.toString(it, Charsets.UTF_8)]
	}

	/**
	 * We want to retain the order of specifications.
	 * Repeated executions of report generation should
	 * show errors in the same order.
	 */
	@Pure
	def private uniqueSpecifications(Iterable<Specification> specifications) {
		specifications.map[group.qualifier -> it].toSet.map[value]
		//TODO: check that this newly created method works the same way as uniqueSpecifications_usingWrapper()
	}

//	@Deprecated
//	def private uniqueSpecifications_usingWrapper(Iterable<Specification> specifications) {
//		// LinkedHashSet to retain order of specifications
//		// repeated executions of report generation should
//		// show errors in the same order
//		val set = <SpecificationWrapper> newLinkedHashSet
//		set += specifications.map[new SpecificationWrapper(it)]
//		
//		set.map[it.specification]
//	}
//
//	/**
//	 * Used only to remove duplicated Specification objects with Set.
//	 * Note that hashCode and equals are simplified - they don't compare/use
//	 * all fields and don't check all preconditions (e.g. null-ness in equals).
//	 */
//	@Deprecated
//	@Data private static class SpecificationWrapper {
//		
//		Specification specification
//		
//		@Pure
//		override hashCode() {
//			Objects.hashCode(specification.textFormula, specification.group)
//		}
//		
//		@Pure
//		override equals(Object obj) {
//			val otherSpecification = (obj as SpecificationWrapper).getSpecification
//			
//			// both specifications null or references equals
//			if (specification === otherSpecification) {
//				return true
//			}
//			
//			if (specification.textFormula != otherSpecification.textFormula
//				|| specification.group != otherSpecification.group
//			) {
//				return false
//			}
//			
//			// traces not compared - specifications with same group and formula
//			// are considered equal as counterexamples will be probably same
//			// (no need to distinguish two different counter examples)
//			
//			true
//		}
//			
//	}
}