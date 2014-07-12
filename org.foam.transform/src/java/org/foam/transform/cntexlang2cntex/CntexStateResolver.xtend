package org.foam.transform.cntexlang2cntex

import org.foam.cntex.CounterExample
import org.foam.lts.Automaton
import org.foam.lts.State
import java.util.HashMap
import org.foam.traceability.TraceabilityFactory
import org.foam.traceability.StateMappingAnnotation

class CntexStateResolver {
	
	/**
	 * Name of the variable in NuSMV counter-example in which ID of the state is stored.
	 */
	static val STATE_ID = "s"
	
	val fac = TraceabilityFactory.eINSTANCE
	
	/**
	 * Adds {@link StateMappingAnnotation}s to given counterExample pointing to
	 * states from given Automaton.
	 */
	def void transform(CounterExample counterExample, Automaton automaton) {
		val id2State = new HashMap<String, State>
		automaton.states.forEach[id2State.put(it.id, it)]
		
		for (specification : counterExample.specifications) {
			if (specification.trace != null) {
				for (cntExState : specification.trace.states) {
					// get state id
					val idVar = cntExState.assignments.findFirst[it.variableName == STATE_ID]
					
					// nusmv may generate state without any assignment 
					if (idVar != null) {
						// add annotation with mapping to LTS State
						if (id2State.containsKey(idVar.value)) {
							cntExState.annotations += fac.createStateMappingAnnotation => [
								state = id2State.get(idVar.value)
							]
						}
					}
				}
			}
		}
	}
}