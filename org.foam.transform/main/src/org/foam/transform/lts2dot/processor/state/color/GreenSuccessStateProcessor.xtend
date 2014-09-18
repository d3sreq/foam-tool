package org.foam.transform.lts2dot.processor.state.color

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.RecordNode
import org.foam.lts.State
import org.foam.transform.lts2dot.processor.state.StateProcessor
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UseCase

import static extension org.foam.transform.utils.modeling.ModelUtils.*

/**
 * @param mapping in parameter
 * @param step2RecordNode in parameter, map has to contain mapping from step 
 * 		to record node before {@link process(State)} is called!
 */
@Data
class GreenSuccessStateProcessor implements StateProcessor {
	
	Map<Step, RecordNode> step2RecordNode

	override process(State state) {
		val step = state.stepFromStepMappingAnnotation
		if (step != null) {
			val scenario = step.eContainer as Scenario
			val scenarioParent = scenario.eContainer
			if (scenarioParent instanceof UseCase && scenario.steps.last == step) {
				val recordNode = step2RecordNode.get(step)
				recordNode.attributes.put("fillcolor", "#ccebc5")
			}
		}
	}
	
}