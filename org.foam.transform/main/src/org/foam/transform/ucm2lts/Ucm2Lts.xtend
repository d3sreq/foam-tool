package org.foam.transform.ucm2lts

import com.google.common.base.Preconditions
import com.google.common.base.Predicates
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.flowannotation.Abort
import org.foam.flowannotation.FlowannotationFactory
import org.foam.flowannotation.Goto
import org.foam.flowannotation.Guard
import org.foam.flowannotation.Include
import org.foam.flowannotation.Mark
import org.foam.flowannotation.VariableDefinitionAnnotation
import org.foam.lts.Automaton
import org.foam.lts.LtsFactory
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.propositionallogic.And
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.TemporalAnnotation
import org.foam.traceability.StateType
import org.foam.traceability.TraceabilityFactory
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel
import org.foam.verification.Action
import org.foam.verification.VerificationFactory

import static org.foam.transform.utils.modeling.FoamNamingExtensions.*

import static extension org.foam.ucm.util.UseCaseModelExtensions.*

/**
 * Performs transformation from {@link UseCaseModel} to {@link Automaton}.
 * <p><b>Warning</b> - notifier add/remove is <b>not thread safe</b>
 * 
 * <hr/>
 * <b>NOTE:</b> The transformation is based on the following paper:
 * <p>
 * Šimko V., Hauzar D., Hnětynka P., Bureš T., Plášil F.: <b>Formal Verification
 * of Annotated Textual Use-Cases</b>, The Computer Journal, September 2014
 * <a href="http://dx.doi.org/10.1093/comjnl/bxu068">doi:10.1093/comjnl/bxu068</a>
 * </p>
 *
 */
class Ucm2Lts {

	static extension Logger = Logger.getLogger(Ucm2Lts)
		
	val ltsFactory = LtsFactory.eINSTANCE
	val flowannotationFactory = FlowannotationFactory.eINSTANCE
	val propositionalLogicFactory = PropositionallogicFactory.eINSTANCE
	val verificationFactory = VerificationFactory.eINSTANCE
	val tracFactory = TraceabilityFactory.eINSTANCE
	val stateAddedEventListeners = <StateAddedEventListener> newArrayList

	/**
	 * Copies {@link Mark} annotations from steps of the given use cases 
	 * to the corresponding JMP->EXT transition in the given {@link Automaton}.
	 */
	def void moveMarkAnnotations(	Automaton							resultAutomaton,
									Iterable<UseCase> 					useCases,
									Map<Pair<Step, StateType>, State> 	stepToStateMap,
									Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (step : useCase.allSteps) {
				val marks = step.annotations.filter(Mark).toList
				
				if (!marks.empty) {
					val copies = EcoreUtil.copyAll(marks)
					
					val jmpState = stepToStateMap.get(step -> StateType.JMP)
					val extState = stepToStateMap.get(step -> StateType.EXT)
					
					transitionMap.get(jmpState -> extState).annotations += copies
				}
			}
		}
	}

	/**
	 * Adds IN, VAR, JMP, EXT and OUT state for each step of use case contained in useCases parameter
	 * and connects them with transitions. 
	 * 
	 * @param resultAutomaton {@link Automaton} states are added into
	 * @param useCases use cases whose steps are transformed to {@link State}s
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 * @return helper mapping for {@link State} lookup
	 */
	def addStates(Automaton resultAutomaton, Iterable<UseCase> useCases, Map<Pair<State,State>, Transition> transitionMap) {

		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(transitionMap)
		 
		val result = <Pair<Step, StateType>, State> newHashMap

		for (useCase : useCases) {
			for (step : useCase.allSteps) {
				// add states and transitions
				var State previousState = null
								
				for (stateType : StateType.VALUES) {
					val state = ltsFactory.createState => [
						id = '''«useCase.id»_«step.label»_«stateType.literal»'''
					]
					
					resultAutomaton.states += state
					notifyStateAdded(step, state, stateType)
					if (previousState != null) {
						addTransition(previousState, state, resultAutomaton, transitionMap)
					}
					result.put(step -> stateType, state)

					previousState = state
				}
			}
		}

		result
	}

	def protected void notifyStateAdded(Step sourceStep, State targetState, StateType stateType) {		
		val event = new StateAddedEvent(sourceStep, targetState, stateType)
		stateAddedEventListeners.forEach[ stateAdded(event) ]
	}

	def protected Transition addTransition(	State startState, 
											State endState, 
											Automaton automaton, 
											Map<Pair<State,State>, 
											Transition> transitionMap
	) {
		val transition = ltsFactory.createTransition => [
			start = startState
			end = endState
		]
		automaton.transitions += transition
		transitionMap.put(startState -> endState, transition)
		transition
	}

	def void connectCommon(	Automaton resultAutomaton, 
							Iterable<UseCase> useCases,
							Map<Pair<Step, StateType>, State> stepToStateMap,
							Map<Pair<State,State>, Transition> transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		connectScenarioSteps(resultAutomaton, useCases, stepToStateMap, transitionMap)
		connectBranchesToParents(resultAutomaton, useCases, StateType.VAR, stepToStateMap, transitionMap)
		connectBranchesToParents(resultAutomaton, useCases, StateType.EXT, stepToStateMap, transitionMap)
		connectContinuationFromScenarios(resultAutomaton, useCases, stepToStateMap, transitionMap)
	}
	
	/**
	 * Connects OUT state created from one step to the IN state created from the following step.
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param useCases use cases whose steps are used for IN and OUT {@link State}s lookup
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def void connectScenarioSteps(	Automaton							resultAutomaton,
									Iterable<UseCase> 					useCases,
									Map<Pair<Step, StateType>, State> 	stepToStateMap,
									Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (scenario : useCase.allScenarios) {
				var Step previousStep = null
				for (step : scenario.steps) {
					if (previousStep != null) {
						val start = stepToStateMap.get(previousStep -> StateType.OUT)
						val end = stepToStateMap.get(step -> StateType.IN)
						addTransition(start, end, resultAutomaton, transitionMap)
					}
					previousStep = step;
				}
			}
		}
	}
	
	/**
	 * Adds {@link Transition} from IN State of the branch scenario (extension or variation) to EXT or
	 * VAR State of it's parent. 
	 * <p>
	 * Also copies {@link Guard} added to the first branching step to the created Transition.  
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param useCases use cases whose steps are used for IN and EXT or VAR {@link State} lookup
	 * @param extOrVar whether extensions or variations should be connected to their parents
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def void connectBranchesToParents(	Automaton							resultAutomaton,
										Iterable<UseCase>					useCases,
										StateType							extOrVar,
										Map<Pair<Step, StateType>, State>	stepToStateMap,
										Map<Pair<State,State>, Transition> 	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (entry : useCase.branches) {
				// get scenarios from branches (variations and extensions)
				var branches = if (extOrVar == StateType.VAR) entry.value.variations else entry.value.extensions
				for (branch : branches) {
					val firstStep = branch.steps.head
					val parentStep = entry.key
					
					val extOrVarStateIn = stepToStateMap.get(firstStep -> StateType.IN)
					val branchStateExtOrVar = stepToStateMap.get(parentStep -> extOrVar)
					
					val transition = addTransition(branchStateExtOrVar, extOrVarStateIn, resultAutomaton, transitionMap)
					
					// add guards to transition in lts
					val guards = EcoreUtil.copyAll(firstStep.annotations.filter(Guard).toList)
					transition.annotations += guards
				}
			}
		}
		
	}

	/**
	 * Adds {@link Transition} from OUT State of branching scenario to OUT State
	 * of it's parent. 
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param allUseCases use cases whose steps are used for OUT {@link State} lookup
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def void connectContinuationFromScenarios(	Automaton							resultAutomaton,
												Iterable<UseCase>					useCases,
												Map<Pair<Step, StateType>, State>	stepToStateMap,
												Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		val isAbort = Predicates.instanceOf(Abort) 
		val isGoto = Predicates.instanceOf(Goto)
		val isNeitherGotoOrAbort = Predicates.not(Predicates.or(isAbort, isGoto))
		
		for (useCase : useCases) {
			for (entry : useCase.branches) {
				for (scenario : entry.value.branches.map[value as Scenario]) {
					val lastStep = scenario.steps.last
					Preconditions.checkNotNull(lastStep)

					// last step cannot contain abort or goto to connect back to parent's OUT state					
					if (lastStep.annotations.forall(isNeitherGotoOrAbort)) {
						// connect last step OUT to parent OUT
						val lastStepOutState = stepToStateMap.get(lastStep -> StateType.OUT)
						val parentOutState = stepToStateMap.get(entry.key -> StateType.OUT)
						
						addTransition(lastStepOutState, parentOutState, resultAutomaton, transitionMap)
					}
				}
			}
		}
	}

	/**
	 * Adds {@link Transition} from OUT State whose Step has attached {@link Goto} annotation
	 * to JMP State of the Goto's target step.
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param useCases use cases whose steps are used for OUT and JMP {@link State} lookup
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def handleGoto(	Automaton							resultAutomaton,
					Iterable<UseCase>					useCases, 
					Map<Pair<Step, StateType>, State>	stepToStateMap, 
					Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (step : useCase.allSteps) {
				// TODO - this will add multiple gotos if multiple gotos are
				// attached to single step
				// throw exception instead ?
				for (goto : step.annotations.filter(Goto)) {
					val stepOutState = stepToStateMap.get(step -> StateType.OUT)
					val targetJumpState = stepToStateMap.get(goto.target -> StateType.JMP)
					
					addTransition(stepOutState, targetJumpState, resultAutomaton, transitionMap)
				}
			}
		}
	}
	
	/**
	 * For each {@link Step} with {@link Abort} annotation attached adds an abort-loop.
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param useCases use cases whose steps are used for OUT and JMP {@link State} lookup
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def handleAbort(	Automaton							resultAutomaton,
						Iterable<UseCase>					useCases, 
						Map<Pair<Step, StateType>, State>	stepToStateMap,
						Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (step : useCase.allSteps) {
				val aborts = step.annotations.filter(Abort)
				// TODO - check that only one abort is attached ? 
				if (!aborts.empty) {
					val stepOutState = stepToStateMap.get(step -> StateType.OUT)
					// abort loop, see also includeResolution
					addTransition(stepOutState, stepOutState, resultAutomaton, transitionMap)
					// Note: From now on, we don't need a special abort-loop state because
					// we add special states in the LTS->NuSMV transformation for each guard.
				}
			}
		}
	}
	
	/**
	 * Adds Transition from JMP state of the calling Step (Step to which {@link Include} annotation
	 * is attached to the IN state of the called UseCase.<br/>
	 * Another Transition is attached from OUT State of last Step of the called UseCase to the EXT
	 * State of the calling Step (assuming that OUT state doesn't contain loop).<br/>
	 * <p>
	 * For each Include annotation {@link Action} annotation is added to created Transition
	 * setting variable to True (represents "calling" of the use case). Same variable is
	 * set to False in Action added to Transition going from EXT to OUT State (represents "return"
	 * from called use case).
	 * {@link VariableDefinition} of this variable is contained in {@link VariableDefinitionAnnotation}
	 * attached to the Automaton given in parameter. 
	 * <p>
	 * For every step with {@link Include} annotation attached disables transition from JMP to
	 * EXT state by attaching {@link Guard} with False formula.  
	 * 
	 * @param resultAutomaton {@link Automaton} transitions are added into
	 * @param useCases use cases whose steps are used for OUT and EXT {@link State} lookup
	 * @param stepToStateMap helper mapping for {@link State} lookup
	 * @param transitionMap helper mapping for {@link Transition} lookup
	 */
	def includeResolution(	Automaton							resultAutomaton,
							Iterable<UseCase>					useCases, 
							Map<Pair<Step, StateType>, State>	stepToStateMap,
							Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		for (useCase : useCases) {
			for (step : useCase.allSteps) {
				// TODO - this will add multiple includes if multiple includes
				// are attached to single step
				// throw exception instead ?
				for (include : step.annotations.filter(Include)) {
					
					// disable execution from step x JMP to x EXT
					// according to the FOAM paper, this is achieved by adding a FALSE guard instead of removing the transition
					val stepJmpState = stepToStateMap.get(step -> StateType.JMP)
					val stepExtState = stepToStateMap.get(step -> StateType.EXT)
					val transitionJmp1Ext1 = transitionMap.get(stepJmpState -> stepExtState)
					transitionJmp1Ext1.annotations += flowannotationFactory.createGuard => [
						formula = propositionalLogicFactory.createFalse // the FALSE guard
					]

					// connect x JMP to y1 IN
					val includedUseCaseSteps = include.inlinedUseCase.mainScenario.steps
					val firstStep = includedUseCaseSteps.head
					val firstInState = stepToStateMap.get(firstStep -> StateType.IN)
					val transitionJmp1In2 = addTransition(stepJmpState, firstInState, resultAutomaton, transitionMap)

					// add action setting variable incl_x,c to true
					// according to the paper: "if a use-case c has been called directly from a step x of a use-case u.
					val varDef = propositionalLogicFactory.createVariableDefinition
					// a name is needed e.g. in the generated NuSMV code
					varDef.name = '''incl_«include.inlinedUseCase.id»_from_«useCase.id»_step_«step.label»'''
					
					resultAutomaton.annotations += flowannotationFactory.createVariableDefinitionAnnotation => [
						variableDefinition = varDef
					]
					
					transitionJmp1In2.annotations += verificationFactory.createAction => [
						variableDefinition = varDef
						value = true
					]
					
					// Adding "return" transitions from:
					// (i)  the last state of the main scenario, if it does not end by looping (i.e. there is
					//      no "goto" flow annotation in the last step of the use-case)
					// (ii) all states that contain the abort loop because if an included use-case aborts
					//      the execution should continue in the original use-case

					// here, we collect all the return states
					val returnStates = <State>newArrayList

					// covers the (i) case:
					val lastStepOfMainScenario = includedUseCaseSteps.last
					
					if( ! lastStepOfMainScenario.annotations.exists[it instanceof Goto]) {
						returnStates += stepToStateMap.get(lastStepOfMainScenario -> StateType.OUT)
					} else {
						debug('''The included use-case «include.inlinedUseCase.id» contains "goto" annotation, therefore we won't add a "return" transition to «useCase.id»''')
					}
					
					// covers the (ii) case:
					include.inlinedUseCase.allSteps.filter[annotations.exists[it instanceof Abort]].forEach[
						debug('''Found a step with ABORT annotation: «it.label» in use-case «include.inlinedUseCase.id»''')
						returnStates += stepToStateMap.get(it -> StateType.OUT)
					]
										
					// now adding the return transitions from the collected return states:
					for( returnState: returnStates) {
						
						debug('''Adding "return" transition: «returnState.id»->«stepExtState.id»''')
						val returnTransition = addTransition(returnState, stepExtState, resultAutomaton, transitionMap)
						
						// adding an action to the return transition that sets the "incl" variable to FALSE
						returnTransition.annotations += verificationFactory.createAction => [
							variableDefinition = varDef
							value = false
						]
						
						// adding a guard on the return transition to make it relevant only when the use-case
						// was included and not executed directly
						returnTransition.annotations += flowannotationFactory.createGuard => [
							formula = propositionalLogicFactory.createVariableUse => [
								variableDefinition = varDef
							]
						]					
					}
				}
			}
		}
	}
	
	/**
	 * @param resultAutomaton Automaton to add init state into
	 */
	def addInitState(Automaton resultAutomaton) {
		Preconditions.checkNotNull(resultAutomaton)
		
		// add init state
		val init = ltsFactory.createState => [
			id = createInitStateId
		]
		resultAutomaton.states += init
		resultAutomaton.initState = init
		notifyStateAdded(null, init, null)
	}

	def scheduleUseCases(	Automaton							resultAutomaton,
							Iterable<UseCase>					useCases, 
							Map<Pair<Step, StateType>, State>	stepToStateMap,
							Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultAutomaton)
		Preconditions.checkNotNull(useCases)
		Preconditions.checkNotNull(stepToStateMap)
		Preconditions.checkNotNull(transitionMap)
		
		// add variables done_u
		val doneVars = <UseCase, VariableDefinition> newHashMap
		for (uc : useCases) {
			val varDef = propositionalLogicFactory.createVariableDefinition => [
				name = createDoneStateId(uc.id)
			]
			doneVars.put(uc, varDef)
			
			resultAutomaton.annotations += flowannotationFactory.createVariableDefinitionAnnotation => [
				variableDefinition = varDef
			]
		}

		for (useCase : useCases) {
			// connect init to x_1 IN
			val steps = useCase.mainScenario.steps
			val firstIn = stepToStateMap.get(steps.head -> StateType.IN)
			val transition = addTransition(resultAutomaton.initState, firstIn, resultAutomaton, transitionMap)

			// add precedence guard over done variables
			transition.annotations += createInitGuard(useCase, doneVars)

			// add action setting done_u (exec_u in the paper) to true to transition x_1 IN -> x_1 VAR
			val firstVar = stepToStateMap.get(steps.head -> StateType.VAR)
			val inToVarTransition = transitionMap.get(firstIn -> firstVar)
			inToVarTransition.annotations += verificationFactory.createAction => [
				variableDefinition = doneVars.get(useCase)
				value = true
			]

			// connect to x_n OUT to init
			val lastOut = stepToStateMap.get(steps.last -> StateType.OUT)
			addTransition(lastOut, resultAutomaton.initState, resultAutomaton, transitionMap)
		}

		return doneVars
	}
	
	def addFinalState(	Automaton							resultLts,
						Map<UseCase, VariableDefinition>	doneVars,
						Map<Pair<State,State>, Transition>	transitionMap
	) {
		Preconditions.checkNotNull(resultLts)
		Preconditions.checkNotNull(doneVars)
		Preconditions.checkNotNull(transitionMap)
		
		// add final state
		val finalState = ltsFactory.createState => [
			id = createFinalStateId
		]
		resultLts.states += finalState
		notifyStateAdded(null, finalState, null)

		// add transition from init to final		
		val transition = addTransition(resultLts.initState, finalState, resultLts, transitionMap)
		val doneVarsUse = doneVars.values.map[varDef |
			propositionalLogicFactory.createVariableUse => [
				variableDefinition = varDef
			]
		]

		transition.annotations += flowannotationFactory.createGuard => [
			formula = createConjunction(doneVarsUse)
		]
		
		// add loop in final state
		addTransition(finalState, finalState, resultLts, transitionMap)
		// Note: From now on, we don't need a special final2 state for looping because
		// we add special states in the LTS->NuSMV transformation for each guard. 
	}
	
	def private createInitGuard(UseCase useCase, Map<UseCase,VariableDefinition> doneVars) {
		val parts = <Formula> newArrayList
		// create "(NOT done_u)"
		parts += propositionalLogicFactory.createNot => [
			formula = propositionalLogicFactory.createVariableUse => [
				variableDefinition = doneVars.get(useCase)
			]
		]
		
		parts += useCase.preceeded.map[uc |
			propositionalLogicFactory.createVariableUse => [
				val varDef = doneVars.get(uc)
				variableDefinition = varDef
			]
		]
		return flowannotationFactory.createGuard => [
			formula = createConjunction(parts)
		]
	}
	
	/**
	 * Creates copies of the {@link Formula}s given in parameter and joins
	 * them with {@link And} formula objects.
	 */
	def protected Formula createConjunction(Iterable<? extends Formula> parts) { 
		if (parts.empty) {
			return propositionalLogicFactory.createTrue
		}
		
		val partsCopies = EcoreUtil.copyAll(parts.toList)
		
		var result = partsCopies.head
		for (rightPart : partsCopies.tail) {
			val leftPart = result
			result = propositionalLogicFactory.createAnd => [
				left = leftPart
				right = rightPart 
			]
		}
		return result
	}

	def addAtomicPropositions(	Automaton resultOba, 
								Iterable<UseCase> allUseCases,
								Map<Pair<Step, StateType>, State> stepToStateMap
	) {
		Preconditions.checkNotNull(resultOba)
		Preconditions.checkNotNull(allUseCases)
		Preconditions.checkNotNull(stepToStateMap)
									
		for (useCase : allUseCases) {
			// add temporal annotations from use case step to JMP state in lts
			val tempAnnotations = useCase.stepAnnotations.filter(TemporalAnnotation)
			for (tempAnnotation : tempAnnotations) {
				val step = tempAnnotation.eContainer as Step
				val jmpState = stepToStateMap.get(step -> StateType.JMP)
				jmpState.annotations += EcoreUtil.copy(tempAnnotation)
			}
		}
	}
	
	def void addGuardsToUnguardedSteps(	Automaton resultOba, 
										Iterable<Step> steps, 
										StateType stateType,
										Map<Pair<Step, StateType>, State> stepToStateMap
	) {
		Preconditions.checkNotNull(resultOba)
		Preconditions.checkNotNull(steps)
		Preconditions.checkNotNull(stateType)
		Preconditions.checkNotNull(stepToStateMap)
		
		for (step : steps) {
			val branchState = stepToStateMap.get(step -> stateType)
			// get all guards associated with transitions from state branchState
			val branchTransitions = resultOba.transitions.filter[it.start == branchState]
			
			// get union of guarding formulae on variations/extensions
			val guards = branchTransitions.map[annotations.filter(Guard)].flatten
			
			if (!guards.empty) {
				
				// add guard to unguarded transitions
				for (transition : branchTransitions) {
					val transitionGuards = transition.annotations.filter(Guard)
					
					if (transitionGuards.empty) {
						transition.annotations += flowannotationFactory.createGuard => [ 
							formula = propositionalLogicFactory.createNot => [
								val formulas = guards.map[it.formula].toList
								formula = createConjunction(formulas)
							]
						]
					}
				}
			}
			
		}
	}
	
	def void addStateAddedEventListener(StateAddedEventListener stateAddedEventListener) {
		Preconditions.checkNotNull(stateAddedEventListener)
		stateAddedEventListeners += stateAddedEventListener
	}
	
	def void removeStateAddedEventListener(StateAddedEventListener stateAddedEventListener) {
		Preconditions.checkNotNull(stateAddedEventListener)
		stateAddedEventListeners.remove(stateAddedEventListener)
	}

	def void addSingleIncludeState(	Automaton automaton, 
									UseCase useCase,
									Map<Pair<Step, StateType>, State> stepToStateMap
	) {
		// in case that one use case is included in several places
		// we want the state representing use case to be included only once 
		val includedUseCase2State = <UseCase, State> newHashMap 
		
		for (step : useCase.allSteps) {
			
			val includeAnnotations = step.annotations.filter(Include)
			if (!includeAnnotations.empty) {
				// TODO - at most one include should be attached
			 	val includedUseCase = includeAnnotations.head.inlinedUseCase
			 	
			 	// get state representing included use case
			 	val includeState = if (includedUseCase2State.containsKey(includedUseCase)) {
			 		includedUseCase2State.get(includedUseCase)
			 	} else {			 		
			 		val state = ltsFactory.createState => [
			 			id = includedUseCase.id
			 			annotations += tracFactory.createUseCaseMappingAnnotation => [
			 				it.useCase = includedUseCase
			 			]
			 		]
			 		includedUseCase2State.put(includedUseCase, state)
			 		automaton.states += state
			 		state			 		
			 	}
			 	
			 	// add transitions
			 	// calling:JMP -> incl
			 	automaton.transitions += ltsFactory.createTransition => [
			 		start = stepToStateMap.get(step -> StateType.JMP)
			 		end = includeState
			 	]
			 	// incl -> calling:EXT
			 	automaton.transitions += ltsFactory.createTransition => [
			 		start = includeState
			 		end = stepToStateMap.get(step -> StateType.EXT)
			 	]
			}
			
		}
	}

}