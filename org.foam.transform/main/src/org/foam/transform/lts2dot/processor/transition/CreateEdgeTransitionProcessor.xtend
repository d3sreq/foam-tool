package org.foam.transform.lts2dot.processor.transition

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.DotFactory
import org.foam.dot.Edge
import org.foam.dot.Graph
import org.foam.dot.Node
import org.foam.flowannotation.Guard
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.verification.Action

import static extension org.foam.lts.util.LtsModelExtensions.*
import static extension org.foam.ucm.util.UseCaseModelExtensions.*

/**
 * @param resultDot out parameter, populated in this processor
 * @param state2Node in parameter, map has to contain mapping for source
 * 		and target of the edge before {@link process(Transition)} is called!
 */
@Data
class CreateEdgeTransitionProcessor implements TransitionProcessor {

	private Graph resultDot
	private Map<State, Node> state2Node
	
	private val dotFactory = DotFactory.eINSTANCE
	
	override process(Transition transition) {

		if(transition.isWithinSameBox) {
			return // remove transitions pointing to same record node
		}

		// transform OBA state to dot node and add it into result graph
		val edge = dotFactory.createEdge => [
			source = state2Node.get(transition.start)
			target = state2Node.get(transition.end)
			
			// find reference from the transition to the original use-case step
			val step = transition.start.getStepFromStepMappingAnnotation
			if(step != null) {
				attributes.put("URL", '''#«step.getUseCase.id»_«step.label»''' )
			}
			
			for(action : transition.annotations.filter(Action) ) {
				attributes.put("color", "blueviolet")
				attributes.put("fontcolor", "blueviolet")
				addTooltip('''action: «action.variableDefinition.name» := «action.value»''')
			}

			for(guard : transition.annotations.filter(Guard) ) {
				attributes.put("color", "blueviolet")
				attributes.put("fontcolor", "blueviolet")
				addTooltip("guard: " + guard.formula)
			}
		]

		resultDot.statements += edge
	}
	
	/**
	 * Filters out transitions having source and target in same record node.
	 */
	def private boolean isWithinSameBox(Transition transition) {
		
		val startStep = transition.start.stepFromStepMappingAnnotation  
		val endStep = transition.end.stepFromStepMappingAnnotation
		val startStateType = transition.start.stateTypeFromStateTypeMappingAnnotation
		val endStateType = transition.end.stateTypeFromStateTypeMappingAnnotation
		
		// NOTE: abort state has associated step but not state type 
		return startStep.identityEquals(endStep) 
				&& startStep != null 
				&& startStateType != null 
				&& endStateType != null
	}

	def private void addTooltip(Edge edge, String tooltipStr) {
		val tooltipAttr = edge.attributes.get("tooltip")
		edge.attributes.put(
			"tooltip",
			'''«IF tooltipAttr != null»«tooltipAttr»; «ENDIF»«tooltipStr»'''
		)
	}
}