package org.foam.cli.tools.report.pages

import java.util.List
import org.eclipse.emf.ecore.EStructuralFeature
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UcmPackage
import org.foam.ucm.UseCase
import org.eclipse.xtend.lib.annotations.Data

@Data
class UseCasePage implements Page {

	val foamCommonAnnotationRenderer = new FoamCommonAnnotationRenderer

	val UseCase useCase
	val Menu menu
	val String useCaseImageFileName // we require that image is located in the same directory as html file
	
	override getId() {
		useCase.id
	}
	
	override content() {
		val css = useCase.printBranchCss
		val printedMenu = menu.printMenu(this)
		val useCaseContent = useCase.printUseCaseContent
		new PageTemplate().printPage(css, printedMenu, useCaseContent) 
	}
	
	def private printUseCaseContent(UseCase useCase) '''
		<div>
			<h1>«useCase.id»: «useCase.name»</h1>
			
			«IF !useCase.primary || !useCase.preceeded.empty»
				<div class="usecase-header-block">
					«IF !useCase.primary»primary: false<br>«ENDIF»
					«IF !useCase.preceeded.empty»preceeded: «useCase.preceeded.preparePreceededList»<br>«ENDIF»
				</div>
			«ENDIF»
			
			<ul class="scenario main">
				«printScenario(useCase.mainScenario)»
			</ul>
			
			«FOR branch : useCase.branches»
				«FOR entry : branch.value.branches»
					«val scenario = entry.value as Scenario»
					<b>«convertStructuralFeature(entry.EStructuralFeature)»</b>: «scenario.label». «scenario.text»
					<ul class="scenario branch«scenario.label»">
						«printScenario(scenario)»
					</ul>
				«ENDFOR»
			«ENDFOR»
««« according to http://www.w3schools.com/svg/svg_inhtml.asp can svg be embedded also
««« with <embed> tag which supports scripting
			<object data="«useCaseImageFileName»" type="image/svg+xml"></object>
		</div>
	'''
	
	def private preparePreceededList(List<UseCase> preceeded) {
		preceeded.map['''<a href="../«it.id»/«it.id».html">«it.id» «it.name»</a>'''].join(", ")
	}
	
	def private convertStructuralFeature(EStructuralFeature structuralFeature) '''
		«IF structuralFeature == UcmPackage$Literals.SCENARIO_HOLDER__EXTENSIONS»
			Extension
		«ELSEIF structuralFeature == UcmPackage$Literals.SCENARIO_HOLDER__VARIATIONS»
			Variation
		«ELSE»
			Unknown
		«ENDIF»
	'''
	
	def private printScenario(Scenario scenario) '''
		«FOR step : scenario.steps»
			<li>«printStep(step)»</li>
		«ENDFOR»
	'''
	
	def private printStep(Step step) '''
		«step.text»
		«FOR annotation : step.annotations BEFORE ' ' SEPARATOR ', '»
			<span class="annot">«foamCommonAnnotationRenderer.render(annotation)»</span>
		«ENDFOR»
	'''
	
	def private printBranchCss(UseCase useCase) '''
		«FOR branch : useCase.branches»
			«FOR entry : branch.value.branches»
				«val scenario = entry.value as Scenario»
				.branch«scenario.label» li:before { content: '«scenario.label»' counter(list1) '.' }
			«ENDFOR»
		«ENDFOR»		
	'''
}