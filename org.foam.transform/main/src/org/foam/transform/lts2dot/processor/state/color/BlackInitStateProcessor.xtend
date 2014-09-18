package org.foam.transform.lts2dot.processor.state.color

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.Node
import org.foam.lts.State
import org.foam.transform.lts2dot.processor.state.StateProcessor

/**
 * @param mapping in parameter
 * @param state2Node in parameter, map has to contain mapping from state 
 * 		to node before {@link process(State)} is called!
 */
@Data
class BlackInitStateProcessor implements StateProcessor {
	
	State initState
	Map<State, Node> state2Node

	override process(State state) {
		if (state == initState) {
			state2Node.get(state).attributes.put("fillcolor", "black")
		}
	}
	
}