package org.foam.transform.lts2dot.processor.transition

import org.foam.lts.Transition
import org.eclipse.xtend.lib.Data

import static extension org.foam.transform.utils.modeling.ModelUtils.*

/**
 * Filters out transitions having source and target in same record node
 * 
 * @param mapping in parameter
 */
@Data
class RemoveRecordNodeEdgeTransitionProcessor implements TransitionProcessor {
	
	override process(Transition transition) {
		// remove transitions pointing to same record node
		val startStep = transition.start.stepFromStepMappingAnnotation  
		val endStep = transition.end.stepFromStepMappingAnnotation
		val startStateType = transition.start.stateTypeFromStateTypeMappingAnnotation
		val endStateType = transition.end.stateTypeFromStateTypeMappingAnnotation
		
		// NOTE: abort state has associated step but not state type 
		val isTransitionWithinSameRecordNode = startStep.identityEquals(endStep) 
				&& startStep != null 
				&& startStateType != null 
				&& endStateType != null
		
		!isTransitionWithinSameRecordNode
	}
	
}