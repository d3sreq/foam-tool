package org.foam.transform.utils.modeling

import com.google.common.base.Preconditions
import org.foam.cntex.Specification
import org.foam.lts.State
import org.foam.traceability.FormulaIdentificationAnnotation
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation

class FoamModelExtensions {
	
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
	
	def static getGroup(Specification specification) {
		val annot = specification.annotations.filter(FormulaIdentificationAnnotation)
		Preconditions.checkArgument(annot.size == 1)
		annot.head.group
	}
	
}