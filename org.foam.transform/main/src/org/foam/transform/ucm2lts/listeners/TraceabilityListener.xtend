package org.foam.transform.ucm2lts.listeners

import org.foam.lts.State
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation
import org.foam.traceability.TraceabilityFactory
import org.foam.transform.ucm2lts.StateAddedEvent
import org.foam.transform.ucm2lts.StateAddedEventListener

/**
 * Attaches {@link StateTypeMappingAnnotation} and {@link StepMappingAnnotation}
 * (if Step is given in event) into {@link State} passed in event.
 */
class TraceabilityListener implements StateAddedEventListener {
	val traceabilityFac = TraceabilityFactory.eINSTANCE
	
	override stateAdded(StateAddedEvent event) {
		val state = event.targetState
		val step = event.sourceStep
		
		if (event.targetStateType != null) {
			state.annotations += traceabilityFac.createStateTypeMappingAnnotation => [
				stateType = event.targetStateType
			]
		}
		
		if (step != null) {
			state.annotations += traceabilityFac.createStepMappingAnnotation => [
				it.step = step
			]
		}
	}
	
}