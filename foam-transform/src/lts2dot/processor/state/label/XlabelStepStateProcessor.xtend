package lts2dot.processor.state.label

import org.foam.dot.RecordNode
import java.util.Map
import org.foam.lts.State
import lts2dot.processor.state.StateProcessor
import org.foam.ucm.Step

import static extension utils.model.ModelUtils.*

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
		
		val recordNode = step2RecordNode.get(step)
		if (recordNode == null) {
			return true
		}
		
		recordNode.attributes.put("xlabel", step.label)
		
		true
	}
}