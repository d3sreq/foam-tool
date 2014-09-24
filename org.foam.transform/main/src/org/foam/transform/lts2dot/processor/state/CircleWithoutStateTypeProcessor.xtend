package org.foam.transform.lts2dot.processor.state

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.Node
import org.foam.lts.State

import static extension org.foam.transform.utils.modeling.FoamModelExtensions.*

/**
 * @param mapping in parameter
 * @param state2Node in parameter, map has to contain mapping from given state 
 * 		to node before {@link process(State)} is called!
 */
@Data
class CircleWithoutStateTypeProcessor implements StateProcessor {
	
	Map<State, Node> state2Node
	
	override process(State state) {
		if (state.stateTypeFromStateTypeMappingAnnotation == null) {
			val node = state2Node.get(state)
			node.attributes.put("shape", "circle")
		}
	}
	
}