package org.foam.cli.tools.report.pages

import com.google.common.base.Preconditions
import java.util.HashMap
import java.util.List
import org.foam.annotation.Annotation
import org.foam.cntex.CntExState
import org.foam.cntex.Specification
import org.foam.cntex.Trace
import org.foam.tadl.FormulaHolder
import org.foam.tadl.Group
import org.foam.tadl.TemporalAnnotation
import org.foam.traceability.FormulaIdentificationAnnotation
import org.foam.traceability.StateMappingAnnotation
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation
import org.foam.transform.lts2nusmvlang.TADLFormulaRenderer
import org.foam.ucm.Step
import org.foam.ucm.util.UcmUtils

import static extension org.foam.cli.tools.report.utils.Utils.*

class StepTrace {
	@Property val List<Step> steps = #[]
	@Property var Step loopStart = null
}

@Data
class ErrorPage implements Page {

	Menu menu
	Specification specification
	FormulaHolder formulaHolder
	Group group

	/**
	 * Additional identifier as multiple formulas with same group may produce
	 * error traces
	 */
	@Property String orderId
	
	val renderer = new TADLFormulaRenderer
	
	new(Menu menu, Specification specification, String orderId) {

		this._menu = menu
		this._specification = specification
		this._orderId = orderId
		
		// retrieve FormulaHolder and qualifier from annotation
		val annotations = specification.annotations.filter(FormulaIdentificationAnnotation)
		Preconditions.checkState(annotations.size == 1)
		
		_formulaHolder = annotations.head.formulaHolder
		_group = annotations.head.group
	}
	
	override getId() '''error-«joinedVars»-«group.qualifier»«IF !orderId.empty»-«orderId»«ENDIF»''' 
	
	override content() {
		val css = ""
		val printedMenu = menu.printMenu(this)
		val templateContent = printTemplateContent
		new PageTemplate().printPage(css, printedMenu, templateContent) 
	}
	
	def private getTitle()'''
		«joinedVars» «group.qualifier»«IF !orderId.empty» «orderId»«ENDIF»
	'''
	
	def joinedVars() {
		group.template.variableDefinitions.map[name].join("-")
	}
	
	def private trace2StepTrace(Trace trace) {

		val stepTrace = new StepTrace()
		var markLoop = false
		
		// used to add step only once - trace contains
		// consecutive LTS states from same step
		var Step previousStep = null
		
		for (cntExState : trace.states) {
			if (cntExState == trace.loopStart) {
				// mark step as start of loop
				// NOTE: actual cntExState may not have any step 
				// associated - in that case first following step 
				// is marked as loop start  
				markLoop = true
			}
			
			val step = cntExState.stepForJmpState
			if (step != null) {
				if (step != previousStep) {
					stepTrace.steps += step
				}
				
				if (markLoop) {
					markLoop = false
					stepTrace.loopStart = step
				}
				previousStep = step
			}
		}
		
		// remove last step if it is same as loop start step
		if (stepTrace.loopStart == stepTrace.steps.last) {
			stepTrace.steps.remove(stepTrace.steps.size - 1)
		}
		
		stepTrace
	}
	
	/**
	 * @return associated {@link Step} or <code>null<code> if no step is associated or state is not linked to JMP state 
	 */
	def private getStepForJmpState(CntExState cntExState) {
		val stateAnnotations = cntExState.annotations.filter(StateMappingAnnotation)
		Preconditions.checkArgument(stateAnnotations.size <= 1)
		if (stateAnnotations.empty) {
			return null
		}
		
		// get only step that belong to JMP state
		val state = stateAnnotations.head.state
		val stateTypeAnnotation = state.annotations.filter(StateTypeMappingAnnotation)
		Preconditions.checkArgument(stateTypeAnnotation.size <= 1)
		if (stateTypeAnnotation.empty || stateTypeAnnotation.head.stateType != StateType.JMP) {
			return null
		}
		
		val stepAnnotations = state.annotations.filter(StepMappingAnnotation)
		Preconditions.checkArgument(stepAnnotations.size <= 1)
		if (stepAnnotations.empty) {
			return null
		}
		
		stepAnnotations.head.step 
	}
	
	def private printTemplateContent() {
		val stepTrace = specification.trace.trace2StepTrace
		val step2TempAnnotations = createStep2TempAnnotationMap(stepTrace)
		
		'''
		<div>
			<h1>Error: «getTitle»</h1>
			<p>
			«formulaHolder.comment»:
			<pre>«formulaHolder.formulaType» «renderer.evalFormula(formulaHolder.formula)»</pre>
			</p>
««« TODO - formula <pre>«formulaHolder.get»</pre>
		</div>
		<div>	
			<h2>Trace:</h2>
			<table class="trace">
			«FOR step : stepTrace.steps»
				«val useCase = UcmUtils.getUseCase(step)»
				<tr>
					<td><a href="../«useCase.id»/«useCase.id».html">«useCase.id»</a></td>
					<td class="tracecell">«step.label»</td>
					<td class="tracecell">«step.printStep(step2TempAnnotations.get(step))»
					«IF step == stepTrace.loopStart»
						<span class="loop">&larr; loop starts here</span>
					«ENDIF»
					</td>
				</tr>
			«ENDFOR»
			</table>
		</div>
		'''
	}
	
	extension FoamCommonAnnotationRenderer = new FoamCommonAnnotationRenderer
	
	def private printStep(Step step, Iterable<? extends Annotation> annotations) '''
		«step.text»
		«FOR annotation : annotations BEFORE ' ' SEPARATOR ', '»
			<span class="annot">«annotation.render»</span>
		«ENDFOR»
	'''
	
	def private createStep2TempAnnotationMap(StepTrace stepTrace) {
		val result = new HashMap<Step, Iterable<TemporalAnnotation>>
		
		for (step: stepTrace.steps) {
			val tempAnnotations = step.annotations.filter(TemporalAnnotation).filter[group == specification.group]
			// temp. annotation with proper qualifier
			result.put(step, tempAnnotations)
		}
		
		result
	}
}