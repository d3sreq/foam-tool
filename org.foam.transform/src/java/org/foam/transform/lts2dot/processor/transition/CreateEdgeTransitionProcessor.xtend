package org.foam.transform.lts2dot.processor.transition

import java.util.Map
import org.foam.dot.DotFactory
import org.foam.dot.Edge
import org.foam.dot.Graph
import org.foam.dot.Node
import org.foam.flowannotation.Guard
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.transform.utils.modeling.ModelUtils
import org.foam.ucm.util.UcmUtils
import org.foam.verification.Action

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
		// transform oba state to dot node and add it into result graph
		val edge = dotFactory.createEdge => [
			source = state2Node.get(transition.start)
			target = state2Node.get(transition.end)
			
			// find reference from the transition to the original use-case step
			val step = ModelUtils.getStepFromStepMappingAnnotation(transition.start)
			if(step != null)
				attributes.put("URL", '''#«UcmUtils.getUseCase(step).id»_«step.label»''' )
			
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
		true
	}
	
	def void addTooltip(Edge edge, String tooltipStr) {
		val tooltipAttr = edge.attributes.get("tooltip")
		edge.attributes.put(
			"tooltip",
			'''«IF tooltipAttr != null»«tooltipAttr»; «ENDIF»«tooltipStr»'''
		)
	}
}