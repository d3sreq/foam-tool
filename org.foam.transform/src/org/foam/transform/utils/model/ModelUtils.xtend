package org.foam.transform.utils.model

import org.foam.lts.State
import org.foam.ucm.Step
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation

class ModelUtils {
	
	def static Step getStepFromStepMappingAnnotation(State state) {
		val annotation = state.annotations.findFirst[it instanceof StepMappingAnnotation] as StepMappingAnnotation
		if (annotation == null) {
			return null
		}
		annotation.step
	}
	
	def static StateType getStateTypeFromStateTypeMappingAnnotation(State state) {
		val annotation = state.annotations.findFirst[it instanceof StateTypeMappingAnnotation] as StateTypeMappingAnnotation
		if (annotation == null) {
			return null
		}
		annotation.stateType
	}
}