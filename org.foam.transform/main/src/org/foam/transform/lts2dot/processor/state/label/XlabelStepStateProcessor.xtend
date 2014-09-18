package org.foam.transform.lts2dot.processor.state.label

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.RecordNode
import org.foam.lts.State
import org.foam.transform.lts2dot.processor.state.StateProcessor
import org.foam.ucm.Step

import static extension org.foam.transform.utils.modeling.ModelUtils.*

/**
 * @param mapping in parameter
 * @param state2RecordNode in parameter, map has to contain mapping from step 
 * 		to record node before {@link process(State)} is called!
 */
@Data
class XlabelStepStateProcessor implements StateProcessor {

	Map<Step, RecordNode> step2RecordNode

	override process(State state) {
		
		val step = state.stepFromStepMappingAnnotation

		step2RecordNode.get(step)
		?.attributes                // silently ignore if null
		?.put("xlabel", step.label) // silently ignore if null
	}
}
