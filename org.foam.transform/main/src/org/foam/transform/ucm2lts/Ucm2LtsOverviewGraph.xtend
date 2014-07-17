package org.foam.transform.ucm2lts

import java.util.HashMap
import org.foam.lts.Automaton
import org.foam.lts.LtsFactory
import org.foam.lts.State
import org.foam.traceability.OverviewTransitionType
import org.foam.traceability.TraceabilityFactory
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel

import static extension org.foam.ucm.util.UcmUtils.*

class Ucm2LtsOverviewGraph {
	val ltsFac = LtsFactory.eINSTANCE
	val tracFac = TraceabilityFactory.eINSTANCE
	
	def Automaton transform(UseCaseModel ucm) {
		val result = ltsFac.createAutomaton
		
		val useCase2State = new HashMap<UseCase, State>
		val allUseCases = ucm.useCases
		
		// add use cases - states
		for (useCase : allUseCases) {
			val state = ltsFac.createState => [
				id = useCase.id
				
				annotations += tracFac.createUseCaseMappingAnnotation => [
					it.useCase = useCase
				]
			]
			result.states += state
			useCase2State.put(useCase, state)
		}
		
		// set init state of the LTS - not used but needs to be set
		// to satisfy model constraints
		result.initState = result.states.head 
		
		// add transitions
		for (useCase : allUseCases) {
			// add precedence
			for (preceeded : useCase.preceeded) {
				result.transitions += ltsFac.createTransition => [
					start = useCase2State.get(useCase)
					end = useCase2State.get(preceeded)
					annotations += tracFac.createOverviewTransitionTypeAnnotation => [
						overviewTransitionType = OverviewTransitionType.PRECEDENCE
					]
				]
			}
			
			// add includes
			for (included : useCase.included) {
				result.transitions += ltsFac.createTransition => [
					start = useCase2State.get(useCase)
					end = useCase2State.get(included)
					annotations += tracFac.createOverviewTransitionTypeAnnotation => [
						overviewTransitionType = OverviewTransitionType.INCLUDE
					]					
				]
			}
		}
		
		result
	}
	
}