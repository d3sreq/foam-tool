package org.foam.transform.lts2dot.processor.state.color

import com.google.common.base.Predicates
import org.foam.dot.RecordNode
import org.foam.flowannotation.Abort
import java.util.Map
import org.foam.lts.State
import org.foam.transform.lts2dot.processor.state.StateProcessor
import org.foam.ucm.Step
import org.foam.ucm.util.UcmUtils

import static extension org.foam.transform.utils.modeling.ModelUtils.*

/**
 * @param mapping in parameter
 * @param step2RecordNode in parameter, map has to contain mapping from step 
 * 		to record node before {@link process(State)} is called!
 */
@Data
class RedAbortStateProcessor implements StateProcessor {

	Map<Step, RecordNode> step2RecordNode

	override process(State state) {
		// make "abort" node red
		val step = state.stepFromStepMappingAnnotation
		if (step != null) {
			val useCase = UcmUtils.getUseCase(step) 
			if (useCase != null) {
				val isAbort = Predicates.instanceOf(Abort)
				val aborts = step.annotations.filter(isAbort)
				
				if (!aborts.empty) {
					// TODO - color OUT state or IN state ?
					val recordNode = step2RecordNode.get(step)
					recordNode.attributes.put("fillcolor", "#fbb4ae")
				}
			}		
		}
	}
	
}