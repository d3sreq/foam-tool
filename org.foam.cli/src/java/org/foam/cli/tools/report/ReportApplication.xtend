package org.foam.cli.tools.report

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.base.Objects
import com.google.common.base.Preconditions
import com.google.common.io.Files
import java.io.File
import java.util.HashMap
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import joptsimple.OptionParser
import org.foam.annotation.AnnotationPackage
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.cli.tools.report.pages.ErrorPage
import org.foam.cli.tools.report.pages.Menu
import org.foam.cli.tools.report.pages.MenuCategory
import org.foam.cli.tools.report.pages.MenuItem
import org.foam.cli.tools.report.pages.OverviewPage
import org.foam.cli.tools.report.pages.Page
import org.foam.cli.tools.report.pages.TadlTemplatePage
import org.foam.cli.tools.report.pages.UseCasePage
import org.foam.cli.tools.report.utils.FileUtils
import org.foam.cntex.CntexFactory
import org.foam.cntex.Specification
import org.foam.ctl.CtlPackage
import org.foam.dot.DotPackage
import org.foam.dot.Graph
import org.foam.flowannotation.FlowannotationPackage
import org.foam.ltl.LtlPackage
import org.foam.lts.LtsPackage
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.tadl.FormulaHolder
import org.foam.tadl.Group
import org.foam.tadl.TadlPackage
import org.foam.tadl.Template
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex
import org.foam.transform.cntexlang2cntex.CntexStateResolver
import org.foam.transform.cntexlang2cntex.SpecificationResolver
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.lts2dot.Lts2Dot
import org.foam.transform.lts2nusmvlang.Lts2NuSMVLang
import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.foam.transform.ucm2lts.Ucm2LtsFacade
import org.foam.transform.ucm2lts.Ucm2LtsOverviewGraph
import org.foam.transform.ucm2ucm.UcmLang2UcmService
import org.foam.transform.ucm2ucm.flowannotationresolver.FlowAnnotationResolver
import org.foam.transform.ucm2ucm.tadlannotationresolver.TadlAnnotationResolver
import org.foam.transform.utils.graphviz.GraphvizWrapper
import org.foam.transform.utils.logger.LogServiceExtension
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.transform.utils.nusmv.NusmvWrapper
import org.foam.ucm.UcmPackage
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel
import org.foam.verification.VerificationPackage
import org.osgi.framework.FrameworkUtil
import org.osgi.service.log.LogService

import static extension org.foam.cli.tools.report.utils.Utils.*

@Component
class ReportApplication implements IExecutableTool {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	private NusmvWrapper nusmvWrapper
	@Reference def void setNusmvWrapper(NusmvWrapper nusmvWrapper) {
		this.nusmvWrapper = nusmvWrapper
	}

	private GraphvizWrapper graphvizWrapper
	@Reference def void setGraphvizWrapper(GraphvizWrapper graphvizWrapper) {
		this.graphvizWrapper = graphvizWrapper
	}

	private UcmLang2UcmService ucmLang2UcmService
	@Reference def void setUcmLang2Ucm(UcmLang2UcmService serviceRef) {
		this.ucmLang2UcmService = serviceRef
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
		
		'''Checking Graphviz version'''.debug
		val graphvizVersion = graphvizWrapper.graphvizVersion
		'''Graphviz version is «graphvizVersion»'''.info
		
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
		
		val counterExamples = getCounterExamples(useCaseModel)

		'''Merging errors from counter examples'''.debug
		val specifications = counterExamples
			.map[specifications]
			.flatten
			.filter[trace != null]
			.uniqueSpecifications
			
		'''Validating error specifications'''.debug
		specifications.forEach[EmfCommons.basicValidate(it)]
		
		createReport(useCaseModel, templates, specifications, outputDirName)
		
		'''Report generation done.'''.info
	}
	
	override getUsage() '''
	Runs the whole FOAM workflow and generates an HTML report. 
	'''

	def private uniqueSpecifications(Iterable<Specification> specifications) {
		// LinkedHashSet to retain order of specifications
		// repeated executions of report generation should
		// show errors in same order
		val set = new LinkedHashSet<SpecificationWrapper>
		set += specifications.map[new SpecificationWrapper(it)]
		
		set.map[it.specification]
	}
	
	def private createReport(UseCaseModel useCaseModel, Iterable<Template> templates, Iterable<Specification> specifications, String outputDirName) {
		'''Writing the results'''.info
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
		
		// write pages to disk
		'''Writing pages to disk'''.info
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
	
	def private createOverviewPage(UseCaseModel useCaseModel, Menu menu, String outputDirName) {
		// ucm -> lts -> dot
		val automaton = (new Ucm2LtsOverviewGraph).transform(useCaseModel)
		'''Validating overview LTS'''.debug
		EmfCommons.basicValidate(automaton)
		
		// load XMI from bundle
		val overviewGraphTemplate = FrameworkUtil.getBundle(class).getResource("/report/dot/OverviewGraphTemplate.xmi").openStream
		val initGraph = EmfCommons.readModel(overviewGraphTemplate) as Graph
		
		'''Validating init overview DOT graph'''.debug
		EmfCommons.basicValidate(initGraph)
		
		val dotGraph = new Lts2Dot().transformOverview(automaton, initGraph)
		'''Validating overview DOT graph'''.debug
		EmfCommons.basicValidate(dotGraph)
		
		// dot -> svg (with links)
		val image = createImageAndImageMap(dotGraph, outputDirName, "overview")
		
		new OverviewPage(menu, image)
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
		val imageFileName = createImageAndImageMap(dotGraph, outputDirName, useCase.id)
		
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
	
	def private createImageAndImageMap(Graph graph, String outputDirName, String outputFileName) {
		val imageDir = new File(new File(outputDirName), outputFileName)
		imageDir.mkdir
		
		val fullOutputFileWithoutExtension = '''«imageDir»/«outputFileName»'''
		
		// write dot to file
		val dotContent = new Dot2DotLang().transform(graph)
		val dotFileName = '''«fullOutputFileWithoutExtension».dot'''
		Files.write(dotContent, new File(dotFileName), Charsets.UTF_8) 
		
		val imageFileName = '''«outputFileName».svg'''
		val fullImageFileName = '''«fullOutputFileWithoutExtension».svg'''
		
		val dotCommand = newArrayList("dot", 
							"-Tsvg", "-o", fullImageFileName, 
							dotFileName)
		
		'''Creating svg image with dot: "«dotCommand.join(" ")»"'''.info
		graphvizWrapper.runGraphviz(dotCommand)
		
		return imageFileName
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
		useCaseModel.useCases.filter[primary].map[useCase |
			'''transforming «useCase.id» to LTS'''.info
			val automaton = Ucm2LtsFacade.transformSingleUseCase(useCaseModel, useCase)
			
			'''transforming LTS to NuSMV code'''.info
			val List<Pair<FormulaHolder, Group>> holderGroupList = newArrayList
			val code = new Lts2NuSMVLang().transform(automaton, holderGroupList)
			
			'''running NuSMV verification'''.debug
			
			try {
				'''NuSMV version is «nusmvWrapper.nusmvVersion»'''.info
			} catch(Exception e) {
				e.message.error
				"Verification skipped - empty counter example was generated".error
				return CntexFactory.eINSTANCE.createCounterExample
			}
			
			val cntexCode = nusmvWrapper.runNusmvCode(code).join("\n") //TODO: do we really need to convert this to String from an array?
			
			// parse counter example code -> CounterExample
			'''parsing counter example code to CounterExample'''.info
			val counterExample = new CntexLang2Cntex().transform(cntexCode)
			new CntexStateResolver().transform(counterExample, automaton)
			Preconditions.checkState(counterExample.specifications.size == holderGroupList.size)
			new SpecificationResolver().transform(counterExample, holderGroupList)
			counterExample
		]	
	}
	
	def private UseCaseModel ucmlang2Ucm(String inputDirName) {
		'''Reading use case files from the directory "«inputDirName»"'''.info
		val texts = readTexts(inputDirName)
		
		'''Running the transformation'''.debug		
		val useCaseModel = ucmLang2UcmService.transform(texts)

		'''Resolving FLOW annotations'''.debug
		new FlowAnnotationResolver().resolveAnnotations(useCaseModel)
		
		useCaseModel
	}
	
	def private List<Template> tadlLang2Templates(String tadlDirName) {
		val tadlLang2Tadl = new TadlLang2Tadl
		
		'''Reading TADL definitions from file "«tadlDirName»" and parsing'''.info
		val texts = readTexts(tadlDirName)
		 
		val templates = texts.map[tadlLang2Tadl.parse(it)]
		
		'''TADL files resolved'''.debug
		
		return templates
	}
	
	def private resolveTadlAnnotations(UseCaseModel useCaseModel, List<Template> templates) {
		'''Resolving TADL annotations'''.debug
		new TadlAnnotationResolver().resolveAnnotations(useCaseModel, templates)
	}
	
	def private copyWebFiles(String outputDir) {
		'''Copying template web files to output directory «outputDir»'''.info
		FileUtils.bundleCopy("report/web", outputDir)
	}
	
	/**
	 * Gets String content of each file in the given directory
	 */
	def private List<String> readTexts(String inputDir) {
		val dir = new File(inputDir)
		dir.listFiles.map[Files.toString(it, Charsets.UTF_8)]
	}
}

/**
 * Used only to remove duplicated Specification objects with Set.
 * Note that hashCode and equals are simplified - they don't compare/use
 * all fields and don't check all preconditions (e.g. null-ness in equals).
 */
class SpecificationWrapper {
	@Property val Specification specification
	
	new(Specification specification) {
		_specification = specification
	}
	
	override hashCode() {
		Objects.hashCode(specification.textFormula, specification.group)
	}
	
	override equals(Object obj) {
		val otherSpecification = (obj as SpecificationWrapper).specification
		
		// both specification null or references equals
		if (specification == otherSpecification) {
			return true
		}
		
		if (specification.textFormula != otherSpecification.textFormula
			|| specification.group != otherSpecification.group
		) {
			return false
		}
		
		// traces not compared - specifications with same group and formula
		// are considered equal as counterexamples will be probably same
		// (no need to distinguish two different counter examples)
		
		true
	}
		
}