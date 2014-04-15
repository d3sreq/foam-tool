package org.foam.transform.ucm2lts

import com.google.common.base.Predicates
import com.google.common.collect.Sets
import java.util.Collections
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.flowannotation.Guard
import org.foam.lts.Automaton
import org.foam.lts.LtsFactory
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation
import org.foam.transform.ltsreduction.LtsReduction
import org.foam.transform.ltsreduction.listeners.MoveAnnotationsWithTypeListener
import org.foam.transform.ltsreduction.predicates.ExistsTransitionWithMarkEndingInThisState
import org.foam.transform.ltsreduction.predicates.HasStateTypeMappingAnnotation
import org.foam.transform.ltsreduction.predicates.HasTemporalAnnotation
import org.foam.transform.ucm2lts.listeners.TraceabilityListener
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel
import org.foam.verification.Action

import static extension org.foam.ucm.util.UcmUtils.*

/**
 * Simplified API for work with {@link Ucm2Lts}.
 */
class Ucm2LtsFacade {
	
	def static Automaton transformAllUseCases(UseCaseModel useCaseModel) {
		val ucm2lts = createUcm2lts
		val allUseCases = useCaseModel.useCases 
		transformUcmToLts(useCaseModel, allUseCases, useCaseModel.useCases.filter[it.isPrimary], ucm2lts)
	}
	
	def static Automaton transformSingleUseCase( UseCaseModel useCaseModel, UseCase useCase) {
		val ucm2lts = createUcm2lts
		val preceededWithUc = Sets::union(useCase.preceededTransitively, Collections::singleton(useCase))
		// get transitive includes of all preceeded use cases
		val included = preceededWithUc.map[it.includedTransitively].flatten.toSet
		val allUseCases = Sets::union(preceededWithUc, included)		 
		transformUcmToLts(useCaseModel, allUseCases, preceededWithUc, ucm2lts)
	}
	
	def static Automaton transformSingleUseCaseForPage(UseCase useCase) {
		val Map<Pair<State,State>, Transition> transitionMap = newHashMap
		
		val ucm2lts = createUcm2lts
		
		val allUseCases = Collections::singleton(useCase)
		
		val automaton = LtsFactory::eINSTANCE.createAutomaton
		val stepToStateMap = ucm2lts.addStates(automaton, allUseCases, transitionMap)
		
		ucm2lts.connectCommon(automaton, allUseCases, stepToStateMap, transitionMap)
		ucm2lts.handleGoto(automaton, allUseCases, stepToStateMap, transitionMap)
		ucm2lts.addSingleIncludeState(automaton, useCase, stepToStateMap)
		
		reductionForDot(automaton, useCase.mainScenario, useCase.allScenarios)
		
		// init state is not used but must be set so that constraint in Automaton is valid
		automaton.initState = automaton.states.head
		
		automaton
	}
	
	def private static Automaton transformUcmToLts(	UseCaseModel useCaseModel, 
													Iterable<UseCase> allUseCases, 
													Iterable<UseCase> toSchedule, 
													Ucm2Lts ucm2lts
	) {
		val Map<Pair<State,State>, Transition> transitionMap = newHashMap
		
		val automaton = LtsFactory::eINSTANCE.createAutomaton
		
		val stepToStateMap = ucm2lts.addStates(automaton, allUseCases, transitionMap)
		
		ucm2lts.connectCommon(automaton, allUseCases, stepToStateMap, transitionMap)		
		ucm2lts.handleGoto(automaton, allUseCases, stepToStateMap, transitionMap)
		ucm2lts.handleAbort(automaton, allUseCases, stepToStateMap, transitionMap)
		
		ucm2lts.includeResolution(automaton, allUseCases, stepToStateMap, transitionMap)
		ucm2lts.moveMarkAnnotations(automaton, allUseCases, stepToStateMap, transitionMap)
		ucm2lts.addInitState(automaton)
		val doneVars = ucm2lts.scheduleUseCases(automaton, toSchedule, stepToStateMap, transitionMap)
		ucm2lts.addFinalState(automaton, doneVars, transitionMap)
		ucm2lts.addAtomicPropositions(automaton, allUseCases, stepToStateMap)
		
		val allSteps = allUseCases.map[it.allSteps].flatten
		ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType::VAR, stepToStateMap)
		ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType::EXT, stepToStateMap)
		// TODO - use for all OUT steps ?
		ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType::OUT, stepToStateMap)
		
		// TODO - I'm currenty not sure that reduction is correct. It should be carefully thought over
		//  which states can and which cannot be reduced.
		// It is disabled by now since verification with non-reducted LTS doesn't have big performance hit
		// compared to reduced LTS.
//		reduction(automaton)
		automaton
	}
	
	def private static Ucm2Lts createUcm2lts() {
		val ucm2lts = new Ucm2Lts
		// add listener adding annotations for mapping State to Step and State to StateType
		ucm2lts.addStateAddedEventListener(new TraceabilityListener)
		ucm2lts
	}
	
	@Deprecated
	def private static reduction(Automaton automaton) {
		val mapping = createStepStateType2StateMap(automaton)
		
		
		// remove states 
		// - without temporal annotations
		// - if state isn't end state of any transition with Mark annotation
		// - with "reduction candidate" - see createStepStateToRemovePredicate
		val hasTemporal = new HasTemporalAnnotation		
		val existsTransitionWithMarkEndingInThisState = new ExistsTransitionWithMarkEndingInThisState(automaton.transitions)
		val stepStateToRemovePredicate = createStepStateToRemovePredicate(automaton, mapping)
		
		val reductionPredicate = Predicates::and(
			Predicates::not(hasTemporal),
			Predicates::not(existsTransitionWithMarkEndingInThisState),
			stepStateToRemovePredicate
		)
		val ltsReduction = new LtsReduction(reductionPredicate)
		
		// move guards and actions from removed transitions to new transition
		ltsReduction.addStateReducedEventListener(new MoveAnnotationsWithTypeListener(typeof(Guard)))
		ltsReduction.addStateReducedEventListener(new MoveAnnotationsWithTypeListener(typeof(Action)))
		
		ltsReduction.removeUnneededStates(automaton)
	}
	
	def private static reductionForDot(Automaton automaton, Scenario mainScenario, Iterable<Scenario> allScenarios) {
		val mapping = createStepStateType2StateMap(automaton)
		val reductionPredicate = createStepStateToRemovePredicate(automaton, mapping)
		
		val ltsReduction = new LtsReduction(reductionPredicate)
		ltsReduction.removeUnneededStates(automaton)
		
		firstStepReduction(mapping, automaton, mainScenario)
		allScenarios.forEach[lastStepReduction(mapping, automaton, it)]
	}
	
	def private static createStepStateToRemovePredicate(Automaton automaton, Map<Pair<Step, StateType>, State> mapping) {
		val hasAnyStateTypeAnnotation = new HasStateTypeMappingAnnotation
		val isJmp = new HasStateTypeMappingAnnotation(StateType::JMP)
		
		// remove state that
		// - was created from step
		// - is not JMP
		Predicates::and(
			hasAnyStateTypeAnnotation,
			Predicates::not(isJmp)
		)
	}
	
	def private static void firstStepReduction(Map<Pair<Step, StateType>, State> mapping, Automaton automaton, Scenario mainScenario) {
		// try to remove IN state of the first step in main scenario
		// from IN state goes only transition to the other state of the first step 
		val fstStep = mainScenario.steps.head
		val fstState = mapping.get(fstStep -> StateType::IN)
		
		val fstStateTransitions = automaton.transitions.filter[it.start == fstState]
		
		val transitionEnd = fstStateTransitions.head.end
		val transitionEndStep = transitionEnd.annotations.filter(typeof(StepMappingAnnotation)).head.step
		
		if (fstStep == transitionEndStep) {
			// remove fstState
			// remove transitions going from/to removed state
			EcoreUtil::remove(fstStateTransitions.head)
			EcoreUtil::remove(fstState)
		}
	}
	
	/**
	 * Tries to remove StateType.OUT state of the last step in scenario. 
	 * State is removed only if OUT state goes only one incoming transition and
	 * no outgoing transitions.
	 */
	def private static void lastStepReduction(Map<Pair<Step, StateType>, State> mapping, Automaton automaton, Scenario scenario) {
		// try to remove OUT state of the last step in scenario
		// from IN state goes only transition to the other state of the first step 
		val lastStep = scenario.steps.last
		val lastState = mapping.get(lastStep -> StateType::OUT)
		
		val toStateTransitions = automaton.transitions.filter[it.end == lastState]
		val fromStateTransitions = automaton.transitions.filter[it.start == lastState]
		
		if (toStateTransitions.size == 1 && fromStateTransitions.empty) {
			val transitionStartState = toStateTransitions.head.start
			val transitionStartStateStep = transitionStartState.annotations.filter(typeof(StepMappingAnnotation)).head.step
			
			if (lastStep == transitionStartStateStep) {
				// remove transition going to removed state
				EcoreUtil::remove(toStateTransitions.head)
				// remove lastState
				EcoreUtil::remove(lastState)
			}
		}
	}
	
	def private static createStepStateType2StateMap(Automaton automaton) {
		// prepare stepStateType2State map
		val stepStateType2State = new HashMap<Pair<Step, StateType>, State>
		for (state : automaton.states) {
			val stepAnnotation = state.annotations.filter(typeof(StepMappingAnnotation)).head
			if (stepAnnotation != null) {
				val step = stepAnnotation.step
				val stateType = state.annotations.filter(typeof(StateTypeMappingAnnotation)).head.stateType
				stepStateType2State.put(step -> stateType, state)
			}
		}
		stepStateType2State
	}
}