package org.foam.transform.cntexlang2cntex

import org.foam.cntex.CounterExample
import org.foam.lts.Automaton
import org.foam.traceability.StateMappingAnnotation
import org.foam.traceability.TraceabilityFactory

class CntexStateResolver {
	
	extension TraceabilityFactory = TraceabilityFactory.eINSTANCE

	/**
	 * Name of the variable in NuSMV counter-example in which ID of the state is stored.
	 */
	static val STATE_ID = "s"
	
	/**
	 * Adds {@link StateMappingAnnotation}s to given counterExample pointing to
	 * states from given Automaton.
	 */
	def void transform(CounterExample counterExample, Automaton automaton) {
		
		val id2State = automaton.states.toMap[id]
		
		for (specification : counterExample.specifications) {
			if (specification.trace != null) {
				for (cntExState : specification.trace.states) {

					// get state id
					val idVar = cntExState.assignments.findFirst[variableName == STATE_ID]
					
					// nusmv may generate state without any assignment 
					if (idVar != null) {
						// add annotation with mapping to LTS State
						if (id2State.containsKey(idVar.value)) {
							cntExState.annotations += createStateMappingAnnotation => [
								state = id2State.get(idVar.value)
							]
						}
					}
				}
			}
		}
	}
}