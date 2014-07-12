package org.foam.transform.ucm2lts;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.foam.annotation.Annotation;
import org.foam.lts.Automaton;
import org.foam.lts.LtsFactory;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.transform.ltsreduction.LtsReduction;
import org.foam.transform.ltsreduction.predicates.HasStateTypeMappingAnnotation;
import org.foam.transform.ucm2lts.Ucm2Lts;
import org.foam.transform.ucm2lts.listeners.TraceabilityListener;
import org.foam.ucm.Scenario;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;

/**
 * Simplified API for work with {@link Ucm2Lts}.
 */
@SuppressWarnings("all")
public class Ucm2LtsFacade {
  public static Automaton transformAllUseCases(final UseCaseModel useCaseModel) {
    Automaton _xblockexpression = null;
    {
      final Ucm2Lts ucm2lts = Ucm2LtsFacade.createUcm2lts();
      final EList<UseCase> allUseCases = useCaseModel.getUseCases();
      EList<UseCase> _useCases = useCaseModel.getUseCases();
      final Function1<UseCase, Boolean> _function = new Function1<UseCase, Boolean>() {
        public Boolean apply(final UseCase it) {
          return Boolean.valueOf(it.isPrimary());
        }
      };
      Iterable<UseCase> _filter = IterableExtensions.<UseCase>filter(_useCases, _function);
      _xblockexpression = Ucm2LtsFacade.transformUcmToLts(useCaseModel, allUseCases, _filter, ucm2lts);
    }
    return _xblockexpression;
  }
  
  public static Automaton transformSingleUseCase(final UseCaseModel useCaseModel, final UseCase useCase) {
    Automaton _xblockexpression = null;
    {
      final Ucm2Lts ucm2lts = Ucm2LtsFacade.createUcm2lts();
      Set<UseCase> _preceededTransitively = UcmUtils.getPreceededTransitively(useCase);
      Set<UseCase> _singleton = Collections.<UseCase>singleton(useCase);
      final Sets.SetView<UseCase> preceededWithUc = Sets.<UseCase>union(_preceededTransitively, _singleton);
      final Function1<UseCase, Set<UseCase>> _function = new Function1<UseCase, Set<UseCase>>() {
        public Set<UseCase> apply(final UseCase it) {
          return UcmUtils.getIncludedTransitively(it);
        }
      };
      Iterable<Set<UseCase>> _map = IterableExtensions.<UseCase, Set<UseCase>>map(preceededWithUc, _function);
      Iterable<UseCase> _flatten = Iterables.<UseCase>concat(_map);
      final Set<UseCase> included = IterableExtensions.<UseCase>toSet(_flatten);
      final Sets.SetView<UseCase> allUseCases = Sets.<UseCase>union(preceededWithUc, included);
      _xblockexpression = Ucm2LtsFacade.transformUcmToLts(useCaseModel, allUseCases, preceededWithUc, ucm2lts);
    }
    return _xblockexpression;
  }
  
  public static Automaton transformSingleUseCaseForPage(final UseCase useCase) {
    Automaton _xblockexpression = null;
    {
      final Map<Pair<State, State>, Transition> transitionMap = CollectionLiterals.<Pair<State, State>, Transition>newHashMap();
      final Ucm2Lts ucm2lts = Ucm2LtsFacade.createUcm2lts();
      final Set<UseCase> allUseCases = Collections.<UseCase>singleton(useCase);
      final Automaton automaton = LtsFactory.eINSTANCE.createAutomaton();
      final HashMap<Pair<Step, StateType>, State> stepToStateMap = ucm2lts.addStates(automaton, allUseCases, transitionMap);
      ucm2lts.connectCommon(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.handleGoto(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.addSingleIncludeState(automaton, useCase, stepToStateMap);
      Scenario _mainScenario = useCase.getMainScenario();
      Iterable<Scenario> _allScenarios = UcmUtils.allScenarios(useCase);
      Ucm2LtsFacade.reductionForDot(automaton, _mainScenario, _allScenarios);
      EList<State> _states = automaton.getStates();
      State _head = IterableExtensions.<State>head(_states);
      automaton.setInitState(_head);
      _xblockexpression = automaton;
    }
    return _xblockexpression;
  }
  
  private static Automaton transformUcmToLts(final UseCaseModel useCaseModel, final Iterable<UseCase> allUseCases, final Iterable<UseCase> toSchedule, final Ucm2Lts ucm2lts) {
    Automaton _xblockexpression = null;
    {
      final Map<Pair<State, State>, Transition> transitionMap = CollectionLiterals.<Pair<State, State>, Transition>newHashMap();
      final Automaton automaton = LtsFactory.eINSTANCE.createAutomaton();
      final HashMap<Pair<Step, StateType>, State> stepToStateMap = ucm2lts.addStates(automaton, allUseCases, transitionMap);
      ucm2lts.connectCommon(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.handleGoto(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.handleAbort(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.includeResolution(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.moveMarkAnnotations(automaton, allUseCases, stepToStateMap, transitionMap);
      ucm2lts.addInitState(automaton);
      final HashMap<UseCase, VariableDefinition> doneVars = ucm2lts.scheduleUseCases(automaton, toSchedule, stepToStateMap, transitionMap);
      ucm2lts.addFinalState(automaton, doneVars, transitionMap);
      ucm2lts.addAtomicPropositions(automaton, allUseCases, stepToStateMap);
      final Function1<UseCase, Iterable<Step>> _function = new Function1<UseCase, Iterable<Step>>() {
        public Iterable<Step> apply(final UseCase it) {
          return UcmUtils.allSteps(it);
        }
      };
      Iterable<Iterable<Step>> _map = IterableExtensions.<UseCase, Iterable<Step>>map(allUseCases, _function);
      final Iterable<Step> allSteps = Iterables.<Step>concat(_map);
      ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType.VAR, stepToStateMap);
      ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType.EXT, stepToStateMap);
      ucm2lts.addGuardsToUnguardedSteps(automaton, allSteps, StateType.OUT, stepToStateMap);
      _xblockexpression = automaton;
    }
    return _xblockexpression;
  }
  
  private static Ucm2Lts createUcm2lts() {
    Ucm2Lts _xblockexpression = null;
    {
      final Ucm2Lts ucm2lts = new Ucm2Lts();
      TraceabilityListener _traceabilityListener = new TraceabilityListener();
      ucm2lts.addStateAddedEventListener(_traceabilityListener);
      _xblockexpression = ucm2lts;
    }
    return _xblockexpression;
  }
  
  private static void reductionForDot(final Automaton automaton, final Scenario mainScenario, final Iterable<Scenario> allScenarios) {
    final HashMap<Pair<Step, StateType>, State> mapping = Ucm2LtsFacade.createStepStateType2StateMap(automaton);
    final Predicate<State> reductionPredicate = Ucm2LtsFacade.createStepStateToRemovePredicate(automaton, mapping);
    final LtsReduction ltsReduction = new LtsReduction(reductionPredicate);
    ltsReduction.removeUnneededStates(automaton);
    Ucm2LtsFacade.firstStepReduction(mapping, automaton, mainScenario);
    final Consumer<Scenario> _function = new Consumer<Scenario>() {
      public void accept(final Scenario it) {
        Ucm2LtsFacade.lastStepReduction(mapping, automaton, it);
      }
    };
    allScenarios.forEach(_function);
  }
  
  private static Predicate<State> createStepStateToRemovePredicate(final Automaton automaton, final Map<Pair<Step, StateType>, State> mapping) {
    Predicate<State> _xblockexpression = null;
    {
      final HasStateTypeMappingAnnotation hasAnyStateTypeAnnotation = new HasStateTypeMappingAnnotation();
      final HasStateTypeMappingAnnotation isJmp = new HasStateTypeMappingAnnotation(StateType.JMP);
      Predicate<State> _not = Predicates.<State>not(isJmp);
      _xblockexpression = Predicates.<State>and(hasAnyStateTypeAnnotation, _not);
    }
    return _xblockexpression;
  }
  
  private static void firstStepReduction(final Map<Pair<Step, StateType>, State> mapping, final Automaton automaton, final Scenario mainScenario) {
    EList<Step> _steps = mainScenario.getSteps();
    final Step fstStep = IterableExtensions.<Step>head(_steps);
    Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(fstStep, StateType.IN);
    final State fstState = mapping.get(_mappedTo);
    EList<Transition> _transitions = automaton.getTransitions();
    final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition it) {
        State _start = it.getStart();
        return Boolean.valueOf(Objects.equal(_start, fstState));
      }
    };
    final Iterable<Transition> fstStateTransitions = IterableExtensions.<Transition>filter(_transitions, _function);
    Transition _head = IterableExtensions.<Transition>head(fstStateTransitions);
    final State transitionEnd = _head.getEnd();
    EList<Annotation> _annotations = transitionEnd.getAnnotations();
    Iterable<StepMappingAnnotation> _filter = Iterables.<StepMappingAnnotation>filter(_annotations, StepMappingAnnotation.class);
    StepMappingAnnotation _head_1 = IterableExtensions.<StepMappingAnnotation>head(_filter);
    final Step transitionEndStep = _head_1.getStep();
    boolean _equals = Objects.equal(fstStep, transitionEndStep);
    if (_equals) {
      Transition _head_2 = IterableExtensions.<Transition>head(fstStateTransitions);
      EcoreUtil.remove(_head_2);
      EcoreUtil.remove(fstState);
    }
  }
  
  /**
   * Tries to remove StateType.OUT state of the last step in scenario.
   * State is removed only if OUT state goes only one incoming transition and
   * no outgoing transitions.
   */
  private static void lastStepReduction(final Map<Pair<Step, StateType>, State> mapping, final Automaton automaton, final Scenario scenario) {
    EList<Step> _steps = scenario.getSteps();
    final Step lastStep = IterableExtensions.<Step>last(_steps);
    Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(lastStep, StateType.OUT);
    final State lastState = mapping.get(_mappedTo);
    EList<Transition> _transitions = automaton.getTransitions();
    final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition it) {
        State _end = it.getEnd();
        return Boolean.valueOf(Objects.equal(_end, lastState));
      }
    };
    final Iterable<Transition> toStateTransitions = IterableExtensions.<Transition>filter(_transitions, _function);
    EList<Transition> _transitions_1 = automaton.getTransitions();
    final Function1<Transition, Boolean> _function_1 = new Function1<Transition, Boolean>() {
      public Boolean apply(final Transition it) {
        State _start = it.getStart();
        return Boolean.valueOf(Objects.equal(_start, lastState));
      }
    };
    final Iterable<Transition> fromStateTransitions = IterableExtensions.<Transition>filter(_transitions_1, _function_1);
    boolean _and = false;
    int _size = IterableExtensions.size(toStateTransitions);
    boolean _equals = (_size == 1);
    if (!_equals) {
      _and = false;
    } else {
      boolean _isEmpty = IterableExtensions.isEmpty(fromStateTransitions);
      _and = _isEmpty;
    }
    if (_and) {
      Transition _head = IterableExtensions.<Transition>head(toStateTransitions);
      final State transitionStartState = _head.getStart();
      EList<Annotation> _annotations = transitionStartState.getAnnotations();
      Iterable<StepMappingAnnotation> _filter = Iterables.<StepMappingAnnotation>filter(_annotations, StepMappingAnnotation.class);
      StepMappingAnnotation _head_1 = IterableExtensions.<StepMappingAnnotation>head(_filter);
      final Step transitionStartStateStep = _head_1.getStep();
      boolean _equals_1 = Objects.equal(lastStep, transitionStartStateStep);
      if (_equals_1) {
        Transition _head_2 = IterableExtensions.<Transition>head(toStateTransitions);
        EcoreUtil.remove(_head_2);
        EcoreUtil.remove(lastState);
      }
    }
  }
  
  private static HashMap<Pair<Step, StateType>, State> createStepStateType2StateMap(final Automaton automaton) {
    HashMap<Pair<Step, StateType>, State> _xblockexpression = null;
    {
      final HashMap<Pair<Step, StateType>, State> stepStateType2State = CollectionLiterals.<Pair<Step, StateType>, State>newHashMap();
      EList<State> _states = automaton.getStates();
      for (final State state : _states) {
        {
          EList<Annotation> _annotations = state.getAnnotations();
          Iterable<StepMappingAnnotation> _filter = Iterables.<StepMappingAnnotation>filter(_annotations, StepMappingAnnotation.class);
          final StepMappingAnnotation stepAnnotation = IterableExtensions.<StepMappingAnnotation>head(_filter);
          boolean _notEquals = (!Objects.equal(stepAnnotation, null));
          if (_notEquals) {
            final Step step = stepAnnotation.getStep();
            EList<Annotation> _annotations_1 = state.getAnnotations();
            Iterable<StateTypeMappingAnnotation> _filter_1 = Iterables.<StateTypeMappingAnnotation>filter(_annotations_1, StateTypeMappingAnnotation.class);
            StateTypeMappingAnnotation _head = IterableExtensions.<StateTypeMappingAnnotation>head(_filter_1);
            final StateType stateType = _head.getStateType();
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, stateType);
            stepStateType2State.put(_mappedTo, state);
          }
        }
      }
      _xblockexpression = stepStateType2State;
    }
    return _xblockexpression;
  }
}
