package org.foam.transform.lts2dot.processor.transition

import org.foam.dot.DotFactory
import org.foam.dot.Graph
import org.foam.dot.Node
import java.util.Map
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.traceability.OverviewTransitionType
import org.foam.traceability.OverviewTransitionTypeAnnotation

/**
 * @param resultDot out parameter, populated in this processor
 * @param state2Node in parameter, map has to contain mapping for source
 * 		and target of the edge before {@link process(Transition)} is called!
 */
@Data
class CreateOverviewEdgeTransitionProcessor implements TransitionProcessor {

	private Graph resultDot
	private Map<State, Node> state2Node
	
	private val dotFactory = DotFactory.eINSTANCE
	
	override process(Transition transition) {
		
		val transitionType = transition.annotations.filter(OverviewTransitionTypeAnnotation).head.overviewTransitionType
		
		// transform oba state to dot node and add it into result graph
		val edge = dotFactory.createEdge => [
			source = state2Node.get(transition.start)
			target = state2Node.get(transition.end)
			
			// make include edges dashed
			if (transitionType == OverviewTransitionType.INCLUDE) {
				it.attributes.put("style", "dashed")
				it.attributes.put("arrowhead", "onormal")
			}
		]

		resultDot.statements += edge
		true
	}
	
}