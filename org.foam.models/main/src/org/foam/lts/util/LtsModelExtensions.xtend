package org.foam.lts.util

import org.foam.lts.State
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation

class LtsModelExtensions {
	
	def static getStepFromStepMappingAnnotation(State state) {
		state.annotations
		.filter(StepMappingAnnotation)
		.head  // find the first StepMappingAnnotation
		?.step // return the Step instance if found or null otherwise
	}
	
	def static getStateTypeFromStateTypeMappingAnnotation(State state) {
		state.annotations
		.filter(StateTypeMappingAnnotation)
		.head       // find the first StateTypeMappingAnnotation
		?.stateType // return StateType instance if found or null otherwise
	}
	
}