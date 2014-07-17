package org.foam.transform.lts2dot.processor.state.label

import org.foam.dot.Node
import java.util.Map
import org.foam.lts.State
import org.foam.transform.lts2dot.processor.state.StateProcessor
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation

/**
 * Adds bullet to JMP states.
 * 
 * @param state2Node in parameter, contains mapping from state to node
 */
@Data
class BulletInnerNodeStateProcessor implements StateProcessor {
	
	private Map<State, Node> state2Node
	
	override process(State state) {
		if (state.hasJmp) {
			state2Node.get(state).attributes.put("label", "&bull;")
		}
	}
	
	def private hasJmp(State state) {
		val stateTypeMappingAnnoatations = state.annotations.filter(StateTypeMappingAnnotation)
		!stateTypeMappingAnnoatations.empty && stateTypeMappingAnnoatations.head.stateType == StateType.JMP
	} 
}