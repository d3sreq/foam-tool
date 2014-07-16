package org.foam.transform.ucm2lts;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.flowannotation.Abort;
import org.foam.flowannotation.FlowannotationFactory;
import org.foam.flowannotation.Goto;
import org.foam.flowannotation.Guard;
import org.foam.flowannotation.Include;
import org.foam.flowannotation.Mark;
import org.foam.flowannotation.VariableDefinitionAnnotation;
import org.foam.lts.Automaton;
import org.foam.lts.LtsFactory;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.propositionallogic.And;
import org.foam.propositionallogic.False;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.Not;
import org.foam.propositionallogic.PropositionallogicFactory;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;
import org.foam.tadl.TemporalAnnotation;
import org.foam.traceability.StateType;
import org.foam.traceability.TraceabilityFactory;
import org.foam.traceability.UseCaseMappingAnnotation;
import org.foam.transform.ucm2lts.StateAddedEvent;
import org.foam.transform.ucm2lts.StateAddedEventListener;
import org.foam.transform.utils.modeling.FoamNamingExtension;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;
import org.foam.verification.Action;
import org.foam.verification.VerificationFactory;

/**
 * Performs transformation from {@link UseCaseModel} to {@link Automaton}.
 * Transformation is based on paper Formal Verification of Annotated Use-Cases (FOAM Method)
 * from Viliam Simko, Petr Hnetynka, Tomas Bures and Frantisek Plasil
 * 
 * <p><b>Warning</b> - notifier add/remove is <b>not thread safe</b>
 */
@SuppressWarnings("all")
public class Ucm2Lts {
  private final static Logger logger = Logger.getLogger(Ucm2Lts.class.getCanonicalName());
  
  @Extension
  private FoamNamingExtension _foamNamingExtension = new FoamNamingExtension();
  
  private final LtsFactory ltsFactory = LtsFactory.eINSTANCE;
  
  private final FlowannotationFactory flowannotationFactory = FlowannotationFactory.eINSTANCE;
  
  private final PropositionallogicFactory propositionalLogicFactory = PropositionallogicFactory.eINSTANCE;
  
  private final VerificationFactory verificationFactory = VerificationFactory.eINSTANCE;
  
  private final TraceabilityFactory tracFactory = TraceabilityFactory.eINSTANCE;
  
  private final ArrayList<StateAddedEventListener> stateAddedEventListeners = CollectionLiterals.<StateAddedEventListener>newArrayList();
  
  /**
   * Copies {@link Mark} annotations from steps of the given use cases
   * to the corresponding JMP->EXT transition in the given {@link Automaton}.
   */
  public void moveMarkAnnotations(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
      for (final Step step : _allSteps) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          Iterable<Mark> _filter = Iterables.<Mark>filter(_annotations, Mark.class);
          final List<Mark> marks = IterableExtensions.<Mark>toList(_filter);
          boolean _isEmpty = marks.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            final Collection<Mark> copies = EcoreUtil.<Mark>copyAll(marks);
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.JMP);
            final State jmpState = stepToStateMap.get(_mappedTo);
            Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(step, StateType.EXT);
            final State extState = stepToStateMap.get(_mappedTo_1);
            Pair<State, State> _mappedTo_2 = Pair.<State, State>of(jmpState, extState);
            Transition _get = transitionMap.get(_mappedTo_2);
            EList<Annotation> _annotations_1 = _get.getAnnotations();
            Iterables.<Annotation>addAll(_annotations_1, copies);
          }
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
  public HashMap<Pair<Step, StateType>, State> addStates(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<State, State>, Transition> transitionMap) {
    HashMap<Pair<Step, StateType>, State> _xblockexpression = null;
    {
      Preconditions.<Automaton>checkNotNull(resultAutomaton);
      Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
      Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
      final HashMap<Pair<Step, StateType>, State> result = new HashMap<Pair<Step, StateType>, State>();
      for (final UseCase useCase : useCases) {
        Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
        for (final Step step : _allSteps) {
          {
            State previousState = null;
            for (final StateType stateType : StateType.VALUES) {
              {
                State _createState = this.ltsFactory.createState();
                final Procedure1<State> _function = new Procedure1<State>() {
                  public void apply(final State it) {
                    StringConcatenation _builder = new StringConcatenation();
                    String _id = useCase.getId();
                    _builder.append(_id, "");
                    _builder.append("_");
                    String _label = step.getLabel();
                    _builder.append(_label, "");
                    _builder.append("_");
                    String _literal = stateType.getLiteral();
                    _builder.append(_literal, "");
                    it.setId(_builder.toString());
                  }
                };
                final State state = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
                EList<State> _states = resultAutomaton.getStates();
                _states.add(state);
                this.notifyStateAdded(step, state, stateType);
                boolean _notEquals = (!Objects.equal(previousState, null));
                if (_notEquals) {
                  this.addTransition(previousState, state, resultAutomaton, transitionMap);
                }
                Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, stateType);
                result.put(_mappedTo, state);
                previousState = state;
              }
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  protected void notifyStateAdded(final Step sourceStep, final State targetState, final StateType stateType) {
    final StateAddedEvent event = new StateAddedEvent(sourceStep, targetState, stateType);
    final Consumer<StateAddedEventListener> _function = new Consumer<StateAddedEventListener>() {
      public void accept(final StateAddedEventListener it) {
        it.stateAdded(event);
      }
    };
    this.stateAddedEventListeners.forEach(_function);
  }
  
  protected Transition addTransition(final State startState, final State endState, final Automaton automaton, final Map<Pair<State, State>, Transition> transitionMap) {
    Transition _xblockexpression = null;
    {
      Transition _createTransition = this.ltsFactory.createTransition();
      final Procedure1<Transition> _function = new Procedure1<Transition>() {
        public void apply(final Transition it) {
          it.setStart(startState);
          it.setEnd(endState);
        }
      };
      final Transition transition = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function);
      EList<Transition> _transitions = automaton.getTransitions();
      _transitions.add(transition);
      Pair<State, State> _mappedTo = Pair.<State, State>of(startState, endState);
      transitionMap.put(_mappedTo, transition);
      _xblockexpression = transition;
    }
    return _xblockexpression;
  }
  
  public void connectCommon(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    this.connectScenarioSteps(resultAutomaton, useCases, stepToStateMap, transitionMap);
    this.connectBranchesToParents(resultAutomaton, useCases, StateType.VAR, stepToStateMap, transitionMap);
    this.connectBranchesToParents(resultAutomaton, useCases, StateType.EXT, stepToStateMap, transitionMap);
    this.connectContinuationFromScenarios(resultAutomaton, useCases, stepToStateMap, transitionMap);
  }
  
  /**
   * Connects OUT state created from one step to the IN state created from the following step.
   * 
   * @param resultAutomaton {@link Automaton} transitions are added into
   * @param useCases use cases whose steps are used for IN and OUT {@link State}s lookup
   * @param stepToStateMap helper mapping for {@link State} lookup
   * @param transitionMap helper mapping for {@link Transition} lookup
   */
  public void connectScenarioSteps(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      Iterable<Scenario> _allScenarios = UcmUtils.allScenarios(useCase);
      for (final Scenario scenario : _allScenarios) {
        {
          Step previousStep = null;
          EList<Step> _steps = scenario.getSteps();
          for (final Step step : _steps) {
            {
              boolean _notEquals = (!Objects.equal(previousStep, null));
              if (_notEquals) {
                Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(previousStep, StateType.OUT);
                final State start = stepToStateMap.get(_mappedTo);
                Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(step, StateType.IN);
                final State end = stepToStateMap.get(_mappedTo_1);
                this.addTransition(start, end, resultAutomaton, transitionMap);
              }
              previousStep = step;
            }
          }
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
  public void connectBranchesToParents(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final StateType extOrVar, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      EMap<Step, ScenarioHolder> _branches = useCase.getBranches();
      for (final Map.Entry<Step, ScenarioHolder> entry : _branches) {
        {
          EList<Scenario> _xifexpression = null;
          boolean _equals = Objects.equal(extOrVar, StateType.VAR);
          if (_equals) {
            ScenarioHolder _value = entry.getValue();
            _xifexpression = _value.getVariations();
          } else {
            ScenarioHolder _value_1 = entry.getValue();
            _xifexpression = _value_1.getExtensions();
          }
          EList<Scenario> branches = _xifexpression;
          for (final Scenario branch : branches) {
            {
              EList<Step> _steps = branch.getSteps();
              final Step firstStep = IterableExtensions.<Step>head(_steps);
              final Step parentStep = entry.getKey();
              Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(firstStep, StateType.IN);
              final State extOrVarStateIn = stepToStateMap.get(_mappedTo);
              Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(parentStep, extOrVar);
              final State branchStateExtOrVar = stepToStateMap.get(_mappedTo_1);
              final Transition transition = this.addTransition(branchStateExtOrVar, extOrVarStateIn, resultAutomaton, transitionMap);
              EList<Annotation> _annotations = firstStep.getAnnotations();
              Iterable<Guard> _filter = Iterables.<Guard>filter(_annotations, Guard.class);
              List<Guard> _list = IterableExtensions.<Guard>toList(_filter);
              final Collection<Guard> guards = EcoreUtil.<Guard>copyAll(_list);
              EList<Annotation> _annotations_1 = transition.getAnnotations();
              Iterables.<Annotation>addAll(_annotations_1, guards);
            }
          }
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
  public void connectContinuationFromScenarios(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    final Predicate<Object> isAbort = Predicates.instanceOf(Abort.class);
    final Predicate<Object> isGoto = Predicates.instanceOf(Goto.class);
    Predicate<Object> _or = Predicates.<Object>or(isAbort, isGoto);
    final Predicate<Object> isNeitherGotoOrAbort = Predicates.<Object>not(_or);
    for (final UseCase useCase : useCases) {
      EMap<Step, ScenarioHolder> _branches = useCase.getBranches();
      for (final Map.Entry<Step, ScenarioHolder> entry : _branches) {
        ScenarioHolder _value = entry.getValue();
        FeatureMap _branches_1 = _value.getBranches();
        final Function1<FeatureMap.Entry, Scenario> _function = new Function1<FeatureMap.Entry, Scenario>() {
          public Scenario apply(final FeatureMap.Entry it) {
            Object _value = it.getValue();
            return ((Scenario) _value);
          }
        };
        List<Scenario> _map = ListExtensions.<FeatureMap.Entry, Scenario>map(_branches_1, _function);
        for (final Scenario scenario : _map) {
          {
            EList<Step> _steps = scenario.getSteps();
            final Step lastStep = IterableExtensions.<Step>last(_steps);
            Preconditions.<Step>checkNotNull(lastStep);
            EList<Annotation> _annotations = lastStep.getAnnotations();
            boolean _forall = IterableExtensions.<Annotation>forall(_annotations, new Function1<Annotation, Boolean>() {
                public Boolean apply(Annotation p) {
                  return isNeitherGotoOrAbort.apply(p);
                }
            });
            if (_forall) {
              Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(lastStep, StateType.OUT);
              final State lastStepOutState = stepToStateMap.get(_mappedTo);
              Step _key = entry.getKey();
              Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(_key, StateType.OUT);
              final State parentOutState = stepToStateMap.get(_mappedTo_1);
              this.addTransition(lastStepOutState, parentOutState, resultAutomaton, transitionMap);
            }
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
  public void handleGoto(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
      for (final Step step : _allSteps) {
        EList<Annotation> _annotations = step.getAnnotations();
        Iterable<Goto> _filter = Iterables.<Goto>filter(_annotations, Goto.class);
        for (final Goto goto_ : _filter) {
          {
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.OUT);
            final State stepOutState = stepToStateMap.get(_mappedTo);
            Step _target = goto_.getTarget();
            Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(_target, StateType.JMP);
            final State targetJumpState = stepToStateMap.get(_mappedTo_1);
            this.addTransition(stepOutState, targetJumpState, resultAutomaton, transitionMap);
          }
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
  public void handleAbort(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
      for (final Step step : _allSteps) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          final Iterable<Abort> aborts = Iterables.<Abort>filter(_annotations, Abort.class);
          boolean _isEmpty = IterableExtensions.isEmpty(aborts);
          boolean _not = (!_isEmpty);
          if (_not) {
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.OUT);
            final State stepOutState = stepToStateMap.get(_mappedTo);
            this.addTransition(stepOutState, stepOutState, resultAutomaton, transitionMap);
          }
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
  public void includeResolution(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    for (final UseCase useCase : useCases) {
      Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
      for (final Step step : _allSteps) {
        EList<Annotation> _annotations = step.getAnnotations();
        Iterable<Include> _filter = Iterables.<Include>filter(_annotations, Include.class);
        for (final Include include : _filter) {
          {
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.JMP);
            final State stepJmpState = stepToStateMap.get(_mappedTo);
            Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(step, StateType.EXT);
            final State stepExtState = stepToStateMap.get(_mappedTo_1);
            Pair<State, State> _mappedTo_2 = Pair.<State, State>of(stepJmpState, stepExtState);
            final Transition transitionJmp1Ext1 = transitionMap.get(_mappedTo_2);
            EList<Annotation> _annotations_1 = transitionJmp1Ext1.getAnnotations();
            Guard _createGuard = this.flowannotationFactory.createGuard();
            final Procedure1<Guard> _function = new Procedure1<Guard>() {
              public void apply(final Guard it) {
                False _createFalse = Ucm2Lts.this.propositionalLogicFactory.createFalse();
                it.setFormula(_createFalse);
              }
            };
            Guard _doubleArrow = ObjectExtensions.<Guard>operator_doubleArrow(_createGuard, _function);
            _annotations_1.add(_doubleArrow);
            UseCase _inlinedUseCase = include.getInlinedUseCase();
            Scenario _mainScenario = _inlinedUseCase.getMainScenario();
            final EList<Step> includedUseCaseSteps = _mainScenario.getSteps();
            final Step firstStep = IterableExtensions.<Step>head(includedUseCaseSteps);
            Pair<Step, StateType> _mappedTo_3 = Pair.<Step, StateType>of(firstStep, StateType.IN);
            final State firstInState = stepToStateMap.get(_mappedTo_3);
            final Transition transitionJmp1In2 = this.addTransition(stepJmpState, firstInState, resultAutomaton, transitionMap);
            final VariableDefinition varDef = this.propositionalLogicFactory.createVariableDefinition();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("incl_");
            UseCase _inlinedUseCase_1 = include.getInlinedUseCase();
            String _id = _inlinedUseCase_1.getId();
            _builder.append(_id, "");
            _builder.append("_from_");
            String _id_1 = useCase.getId();
            _builder.append(_id_1, "");
            _builder.append("_step_");
            String _label = step.getLabel();
            _builder.append(_label, "");
            varDef.setName(_builder.toString());
            EList<Annotation> _annotations_2 = resultAutomaton.getAnnotations();
            VariableDefinitionAnnotation _createVariableDefinitionAnnotation = this.flowannotationFactory.createVariableDefinitionAnnotation();
            final Procedure1<VariableDefinitionAnnotation> _function_1 = new Procedure1<VariableDefinitionAnnotation>() {
              public void apply(final VariableDefinitionAnnotation it) {
                it.setVariableDefinition(varDef);
              }
            };
            VariableDefinitionAnnotation _doubleArrow_1 = ObjectExtensions.<VariableDefinitionAnnotation>operator_doubleArrow(_createVariableDefinitionAnnotation, _function_1);
            _annotations_2.add(_doubleArrow_1);
            EList<Annotation> _annotations_3 = transitionJmp1In2.getAnnotations();
            Action _createAction = this.verificationFactory.createAction();
            final Procedure1<Action> _function_2 = new Procedure1<Action>() {
              public void apply(final Action it) {
                it.setVariableDefinition(varDef);
                it.setValue(true);
              }
            };
            Action _doubleArrow_2 = ObjectExtensions.<Action>operator_doubleArrow(_createAction, _function_2);
            _annotations_3.add(_doubleArrow_2);
            final ArrayList<State> returnStates = new ArrayList<State>();
            final Step lastStepOfMainScenario = IterableExtensions.<Step>last(includedUseCaseSteps);
            EList<Annotation> _annotations_4 = lastStepOfMainScenario.getAnnotations();
            final Function1<Annotation, Boolean> _function_3 = new Function1<Annotation, Boolean>() {
              public Boolean apply(final Annotation it) {
                return Boolean.valueOf((it instanceof Goto));
              }
            };
            boolean _exists = IterableExtensions.<Annotation>exists(_annotations_4, _function_3);
            boolean _not = (!_exists);
            if (_not) {
              Pair<Step, StateType> _mappedTo_4 = Pair.<Step, StateType>of(lastStepOfMainScenario, StateType.OUT);
              State _get = stepToStateMap.get(_mappedTo_4);
              returnStates.add(_get);
            } else {
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("The included use-case ");
              UseCase _inlinedUseCase_2 = include.getInlinedUseCase();
              String _id_2 = _inlinedUseCase_2.getId();
              _builder_1.append(_id_2, "");
              _builder_1.append(" contains \"goto\" annotation, therefore we won\'t add a \"return\" transition to ");
              String _id_3 = useCase.getId();
              _builder_1.append(_id_3, "");
              Ucm2Lts.logger.debug(_builder_1);
            }
            UseCase _inlinedUseCase_3 = include.getInlinedUseCase();
            Iterable<Step> _allSteps_1 = UcmUtils.allSteps(_inlinedUseCase_3);
            final Function1<Step, Boolean> _function_4 = new Function1<Step, Boolean>() {
              public Boolean apply(final Step it) {
                EList<Annotation> _annotations = it.getAnnotations();
                final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
                  public Boolean apply(final Annotation it) {
                    return Boolean.valueOf((it instanceof Abort));
                  }
                };
                return Boolean.valueOf(IterableExtensions.<Annotation>exists(_annotations, _function));
              }
            };
            Iterable<Step> _filter_1 = IterableExtensions.<Step>filter(_allSteps_1, _function_4);
            final Consumer<Step> _function_5 = new Consumer<Step>() {
              public void accept(final Step it) {
                StringConcatenation _builder = new StringConcatenation();
                _builder.append("Found a step with ABORT annotation: ");
                String _label = it.getLabel();
                _builder.append(_label, "");
                _builder.append(" in use-case ");
                UseCase _inlinedUseCase = include.getInlinedUseCase();
                String _id = _inlinedUseCase.getId();
                _builder.append(_id, "");
                Ucm2Lts.logger.debug(_builder);
                Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(it, StateType.OUT);
                State _get = stepToStateMap.get(_mappedTo);
                returnStates.add(_get);
              }
            };
            _filter_1.forEach(_function_5);
            for (final State returnState : returnStates) {
              {
                StringConcatenation _builder_2 = new StringConcatenation();
                _builder_2.append("Adding \"return\" transition: ");
                String _id_4 = returnState.getId();
                _builder_2.append(_id_4, "");
                _builder_2.append("->");
                String _id_5 = stepExtState.getId();
                _builder_2.append(_id_5, "");
                Ucm2Lts.logger.debug(_builder_2);
                final Transition returnTransition = this.addTransition(returnState, stepExtState, resultAutomaton, transitionMap);
                EList<Annotation> _annotations_5 = returnTransition.getAnnotations();
                Action _createAction_1 = this.verificationFactory.createAction();
                final Procedure1<Action> _function_6 = new Procedure1<Action>() {
                  public void apply(final Action it) {
                    it.setVariableDefinition(varDef);
                    it.setValue(false);
                  }
                };
                Action _doubleArrow_3 = ObjectExtensions.<Action>operator_doubleArrow(_createAction_1, _function_6);
                _annotations_5.add(_doubleArrow_3);
                EList<Annotation> _annotations_6 = returnTransition.getAnnotations();
                Guard _createGuard_1 = this.flowannotationFactory.createGuard();
                final Procedure1<Guard> _function_7 = new Procedure1<Guard>() {
                  public void apply(final Guard it) {
                    VariableUse _createVariableUse = Ucm2Lts.this.propositionalLogicFactory.createVariableUse();
                    final Procedure1<VariableUse> _function = new Procedure1<VariableUse>() {
                      public void apply(final VariableUse it) {
                        it.setVariableDefinition(varDef);
                      }
                    };
                    VariableUse _doubleArrow = ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function);
                    it.setFormula(_doubleArrow);
                  }
                };
                Guard _doubleArrow_4 = ObjectExtensions.<Guard>operator_doubleArrow(_createGuard_1, _function_7);
                _annotations_6.add(_doubleArrow_4);
              }
            }
          }
        }
      }
    }
  }
  
  public void debug(final Logger logger, final String string) {
    logger.log(Level.DEBUG, string);
  }
  
  /**
   * @param resultAutomaton Automaton to add init state into
   */
  public void addInitState(final Automaton resultAutomaton) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    State _createState = this.ltsFactory.createState();
    final Procedure1<State> _function = new Procedure1<State>() {
      public void apply(final State it) {
        String _createInitStateId = Ucm2Lts.this._foamNamingExtension.createInitStateId();
        it.setId(_createInitStateId);
      }
    };
    final State init = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
    EList<State> _states = resultAutomaton.getStates();
    _states.add(init);
    resultAutomaton.setInitState(init);
    this.notifyStateAdded(null, init, null);
  }
  
  public HashMap<UseCase, VariableDefinition> scheduleUseCases(final Automaton resultAutomaton, final Iterable<UseCase> useCases, final Map<Pair<Step, StateType>, State> stepToStateMap, final Map<Pair<State, State>, Transition> transitionMap) {
    Preconditions.<Automaton>checkNotNull(resultAutomaton);
    Preconditions.<Iterable<UseCase>>checkNotNull(useCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
    final HashMap<UseCase, VariableDefinition> doneVars = new HashMap<UseCase, VariableDefinition>();
    for (final UseCase uc : useCases) {
      {
        VariableDefinition _createVariableDefinition = this.propositionalLogicFactory.createVariableDefinition();
        final Procedure1<VariableDefinition> _function = new Procedure1<VariableDefinition>() {
          public void apply(final VariableDefinition it) {
            String _id = uc.getId();
            String _createDoneStateId = Ucm2Lts.this._foamNamingExtension.createDoneStateId(_id);
            it.setName(_createDoneStateId);
          }
        };
        final VariableDefinition varDef = ObjectExtensions.<VariableDefinition>operator_doubleArrow(_createVariableDefinition, _function);
        doneVars.put(uc, varDef);
        EList<Annotation> _annotations = resultAutomaton.getAnnotations();
        VariableDefinitionAnnotation _createVariableDefinitionAnnotation = this.flowannotationFactory.createVariableDefinitionAnnotation();
        final Procedure1<VariableDefinitionAnnotation> _function_1 = new Procedure1<VariableDefinitionAnnotation>() {
          public void apply(final VariableDefinitionAnnotation it) {
            it.setVariableDefinition(varDef);
          }
        };
        VariableDefinitionAnnotation _doubleArrow = ObjectExtensions.<VariableDefinitionAnnotation>operator_doubleArrow(_createVariableDefinitionAnnotation, _function_1);
        _annotations.add(_doubleArrow);
      }
    }
    for (final UseCase useCase : useCases) {
      {
        Scenario _mainScenario = useCase.getMainScenario();
        final EList<Step> steps = _mainScenario.getSteps();
        Step _head = IterableExtensions.<Step>head(steps);
        Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(_head, StateType.IN);
        final State firstIn = stepToStateMap.get(_mappedTo);
        State _initState = resultAutomaton.getInitState();
        final Transition transition = this.addTransition(_initState, firstIn, resultAutomaton, transitionMap);
        EList<Annotation> _annotations = transition.getAnnotations();
        Guard _createInitGuard = this.createInitGuard(useCase, doneVars);
        _annotations.add(_createInitGuard);
        Step _head_1 = IterableExtensions.<Step>head(steps);
        Pair<Step, StateType> _mappedTo_1 = Pair.<Step, StateType>of(_head_1, StateType.VAR);
        final State firstVar = stepToStateMap.get(_mappedTo_1);
        Pair<State, State> _mappedTo_2 = Pair.<State, State>of(firstIn, firstVar);
        final Transition inToVarTransition = transitionMap.get(_mappedTo_2);
        EList<Annotation> _annotations_1 = inToVarTransition.getAnnotations();
        Action _createAction = this.verificationFactory.createAction();
        final Procedure1<Action> _function = new Procedure1<Action>() {
          public void apply(final Action it) {
            VariableDefinition _get = doneVars.get(useCase);
            it.setVariableDefinition(_get);
            it.setValue(true);
          }
        };
        Action _doubleArrow = ObjectExtensions.<Action>operator_doubleArrow(_createAction, _function);
        _annotations_1.add(_doubleArrow);
        Step _last = IterableExtensions.<Step>last(steps);
        Pair<Step, StateType> _mappedTo_3 = Pair.<Step, StateType>of(_last, StateType.OUT);
        final State lastOut = stepToStateMap.get(_mappedTo_3);
        State _initState_1 = resultAutomaton.getInitState();
        this.addTransition(lastOut, _initState_1, resultAutomaton, transitionMap);
      }
    }
    return doneVars;
  }
  
  public Transition addFinalState(final Automaton resultLts, final Map<UseCase, VariableDefinition> doneVars, final Map<Pair<State, State>, Transition> transitionMap) {
    Transition _xblockexpression = null;
    {
      Preconditions.<Automaton>checkNotNull(resultLts);
      Preconditions.<Map<UseCase, VariableDefinition>>checkNotNull(doneVars);
      Preconditions.<Map<Pair<State, State>, Transition>>checkNotNull(transitionMap);
      State _createState = this.ltsFactory.createState();
      final Procedure1<State> _function = new Procedure1<State>() {
        public void apply(final State it) {
          String _createFinalStateId = Ucm2Lts.this._foamNamingExtension.createFinalStateId();
          it.setId(_createFinalStateId);
        }
      };
      final State finalState = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
      EList<State> _states = resultLts.getStates();
      _states.add(finalState);
      this.notifyStateAdded(null, finalState, null);
      State _initState = resultLts.getInitState();
      final Transition transition = this.addTransition(_initState, finalState, resultLts, transitionMap);
      Collection<VariableDefinition> _values = doneVars.values();
      final Function1<VariableDefinition, VariableUse> _function_1 = new Function1<VariableDefinition, VariableUse>() {
        public VariableUse apply(final VariableDefinition varDef) {
          VariableUse _createVariableUse = Ucm2Lts.this.propositionalLogicFactory.createVariableUse();
          final Procedure1<VariableUse> _function = new Procedure1<VariableUse>() {
            public void apply(final VariableUse it) {
              it.setVariableDefinition(varDef);
            }
          };
          return ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function);
        }
      };
      final Iterable<VariableUse> doneVarsUse = IterableExtensions.<VariableDefinition, VariableUse>map(_values, _function_1);
      EList<Annotation> _annotations = transition.getAnnotations();
      Guard _createGuard = this.flowannotationFactory.createGuard();
      final Procedure1<Guard> _function_2 = new Procedure1<Guard>() {
        public void apply(final Guard it) {
          Formula _createConjunction = Ucm2Lts.this.createConjunction(doneVarsUse);
          it.setFormula(_createConjunction);
        }
      };
      Guard _doubleArrow = ObjectExtensions.<Guard>operator_doubleArrow(_createGuard, _function_2);
      _annotations.add(_doubleArrow);
      _xblockexpression = this.addTransition(finalState, finalState, resultLts, transitionMap);
    }
    return _xblockexpression;
  }
  
  private Guard createInitGuard(final UseCase useCase, final Map<UseCase, VariableDefinition> doneVars) {
    final ArrayList<Formula> parts = new ArrayList<Formula>();
    Not _createNot = this.propositionalLogicFactory.createNot();
    final Procedure1<Not> _function = new Procedure1<Not>() {
      public void apply(final Not it) {
        VariableUse _createVariableUse = Ucm2Lts.this.propositionalLogicFactory.createVariableUse();
        final Procedure1<VariableUse> _function = new Procedure1<VariableUse>() {
          public void apply(final VariableUse it) {
            VariableDefinition _get = doneVars.get(useCase);
            it.setVariableDefinition(_get);
          }
        };
        VariableUse _doubleArrow = ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function);
        it.setFormula(_doubleArrow);
      }
    };
    Not _doubleArrow = ObjectExtensions.<Not>operator_doubleArrow(_createNot, _function);
    parts.add(_doubleArrow);
    EList<UseCase> _preceeded = useCase.getPreceeded();
    final Function1<UseCase, VariableUse> _function_1 = new Function1<UseCase, VariableUse>() {
      public VariableUse apply(final UseCase uc) {
        VariableUse _createVariableUse = Ucm2Lts.this.propositionalLogicFactory.createVariableUse();
        final Procedure1<VariableUse> _function = new Procedure1<VariableUse>() {
          public void apply(final VariableUse it) {
            final VariableDefinition varDef = doneVars.get(uc);
            it.setVariableDefinition(varDef);
          }
        };
        return ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function);
      }
    };
    List<Formula> _map = ListExtensions.<UseCase, Formula>map(_preceeded, _function_1);
    Iterables.<Formula>addAll(parts, _map);
    Guard _createGuard = this.flowannotationFactory.createGuard();
    final Procedure1<Guard> _function_2 = new Procedure1<Guard>() {
      public void apply(final Guard it) {
        Formula _createConjunction = Ucm2Lts.this.createConjunction(parts);
        it.setFormula(_createConjunction);
      }
    };
    return ObjectExtensions.<Guard>operator_doubleArrow(_createGuard, _function_2);
  }
  
  /**
   * Creates copies of the {@link Formula}s given in parameter and joins
   * them with {@link And} formula objects.
   */
  protected Formula createConjunction(final Iterable<? extends Formula> parts) {
    boolean _isEmpty = IterableExtensions.isEmpty(parts);
    if (_isEmpty) {
      return this.propositionalLogicFactory.createTrue();
    }
    List<? extends Formula> _list = IterableExtensions.toList(parts);
    final Collection<? extends Formula> partsCopies = EcoreUtil.copyAll(_list);
    Formula result = IterableExtensions.head(partsCopies);
    Iterable<? extends Formula> _tail = IterableExtensions.tail(partsCopies);
    for (final Formula rightPart : _tail) {
      {
        final Formula leftPart = result;
        And _createAnd = this.propositionalLogicFactory.createAnd();
        final Procedure1<And> _function = new Procedure1<And>() {
          public void apply(final And it) {
            it.setLeft(leftPart);
            it.setRight(rightPart);
          }
        };
        And _doubleArrow = ObjectExtensions.<And>operator_doubleArrow(_createAnd, _function);
        result = _doubleArrow;
      }
    }
    return result;
  }
  
  public void addAtomicPropositions(final Automaton resultOba, final Iterable<UseCase> allUseCases, final Map<Pair<Step, StateType>, State> stepToStateMap) {
    Preconditions.<Automaton>checkNotNull(resultOba);
    Preconditions.<Iterable<UseCase>>checkNotNull(allUseCases);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    for (final UseCase useCase : allUseCases) {
      {
        Iterable<Annotation> _stepAnnotations = UcmUtils.getStepAnnotations(useCase);
        final Iterable<TemporalAnnotation> tempAnnotations = Iterables.<TemporalAnnotation>filter(_stepAnnotations, TemporalAnnotation.class);
        for (final TemporalAnnotation tempAnnotation : tempAnnotations) {
          {
            EObject _eContainer = tempAnnotation.eContainer();
            final Step step = ((Step) _eContainer);
            Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.JMP);
            final State jmpState = stepToStateMap.get(_mappedTo);
            EList<Annotation> _annotations = jmpState.getAnnotations();
            TemporalAnnotation _copy = EcoreUtil.<TemporalAnnotation>copy(tempAnnotation);
            _annotations.add(_copy);
          }
        }
      }
    }
  }
  
  public void addGuardsToUnguardedSteps(final Automaton resultOba, final Iterable<Step> steps, final StateType stateType, final Map<Pair<Step, StateType>, State> stepToStateMap) {
    Preconditions.<Automaton>checkNotNull(resultOba);
    Preconditions.<Iterable<Step>>checkNotNull(steps);
    Preconditions.<StateType>checkNotNull(stateType);
    Preconditions.<Map<Pair<Step, StateType>, State>>checkNotNull(stepToStateMap);
    for (final Step step : steps) {
      {
        Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, stateType);
        final State branchState = stepToStateMap.get(_mappedTo);
        EList<Transition> _transitions = resultOba.getTransitions();
        final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
          public Boolean apply(final Transition it) {
            State _start = it.getStart();
            return Boolean.valueOf(Objects.equal(_start, branchState));
          }
        };
        final Iterable<Transition> branchTransitions = IterableExtensions.<Transition>filter(_transitions, _function);
        final Function1<Transition, Iterable<Guard>> _function_1 = new Function1<Transition, Iterable<Guard>>() {
          public Iterable<Guard> apply(final Transition it) {
            EList<Annotation> _annotations = it.getAnnotations();
            return Iterables.<Guard>filter(_annotations, Guard.class);
          }
        };
        Iterable<Iterable<Guard>> _map = IterableExtensions.<Transition, Iterable<Guard>>map(branchTransitions, _function_1);
        final Iterable<Guard> guards = Iterables.<Guard>concat(_map);
        boolean _isEmpty = IterableExtensions.isEmpty(guards);
        boolean _not = (!_isEmpty);
        if (_not) {
          for (final Transition transition : branchTransitions) {
            {
              EList<Annotation> _annotations = transition.getAnnotations();
              final Iterable<Guard> transitionGuards = Iterables.<Guard>filter(_annotations, Guard.class);
              boolean _isEmpty_1 = IterableExtensions.isEmpty(transitionGuards);
              if (_isEmpty_1) {
                EList<Annotation> _annotations_1 = transition.getAnnotations();
                Guard _createGuard = this.flowannotationFactory.createGuard();
                final Procedure1<Guard> _function_2 = new Procedure1<Guard>() {
                  public void apply(final Guard it) {
                    Not _createNot = Ucm2Lts.this.propositionalLogicFactory.createNot();
                    final Procedure1<Not> _function = new Procedure1<Not>() {
                      public void apply(final Not it) {
                        final Function1<Guard, Formula> _function = new Function1<Guard, Formula>() {
                          public Formula apply(final Guard it) {
                            return it.getFormula();
                          }
                        };
                        Iterable<Formula> _map = IterableExtensions.<Guard, Formula>map(guards, _function);
                        final List<Formula> formulas = IterableExtensions.<Formula>toList(_map);
                        Formula _createConjunction = Ucm2Lts.this.createConjunction(formulas);
                        it.setFormula(_createConjunction);
                      }
                    };
                    Not _doubleArrow = ObjectExtensions.<Not>operator_doubleArrow(_createNot, _function);
                    it.setFormula(_doubleArrow);
                  }
                };
                Guard _doubleArrow = ObjectExtensions.<Guard>operator_doubleArrow(_createGuard, _function_2);
                _annotations_1.add(_doubleArrow);
              }
            }
          }
        }
      }
    }
  }
  
  public void addStateAddedEventListener(final StateAddedEventListener stateAddedEventListener) {
    Preconditions.<StateAddedEventListener>checkNotNull(stateAddedEventListener);
    this.stateAddedEventListeners.add(stateAddedEventListener);
  }
  
  public void removeStateAddedEventListener(final StateAddedEventListener stateAddedEventListener) {
    Preconditions.<StateAddedEventListener>checkNotNull(stateAddedEventListener);
    this.stateAddedEventListeners.remove(stateAddedEventListener);
  }
  
  public void addSingleIncludeState(final Automaton automaton, final UseCase useCase, final Map<Pair<Step, StateType>, State> stepToStateMap) {
    final HashMap<UseCase, State> includedUseCase2State = new HashMap<UseCase, State>();
    Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
    for (final Step step : _allSteps) {
      {
        EList<Annotation> _annotations = step.getAnnotations();
        final Iterable<Include> includeAnnotations = Iterables.<Include>filter(_annotations, Include.class);
        boolean _isEmpty = IterableExtensions.isEmpty(includeAnnotations);
        boolean _not = (!_isEmpty);
        if (_not) {
          Include _head = IterableExtensions.<Include>head(includeAnnotations);
          final UseCase includedUseCase = _head.getInlinedUseCase();
          State _xifexpression = null;
          boolean _containsKey = includedUseCase2State.containsKey(includedUseCase);
          if (_containsKey) {
            _xifexpression = includedUseCase2State.get(includedUseCase);
          } else {
            State _xblockexpression = null;
            {
              State _createState = this.ltsFactory.createState();
              final Procedure1<State> _function = new Procedure1<State>() {
                public void apply(final State it) {
                  String _id = includedUseCase.getId();
                  it.setId(_id);
                  EList<Annotation> _annotations = it.getAnnotations();
                  UseCaseMappingAnnotation _createUseCaseMappingAnnotation = Ucm2Lts.this.tracFactory.createUseCaseMappingAnnotation();
                  final Procedure1<UseCaseMappingAnnotation> _function = new Procedure1<UseCaseMappingAnnotation>() {
                    public void apply(final UseCaseMappingAnnotation it) {
                      it.setUseCase(includedUseCase);
                    }
                  };
                  UseCaseMappingAnnotation _doubleArrow = ObjectExtensions.<UseCaseMappingAnnotation>operator_doubleArrow(_createUseCaseMappingAnnotation, _function);
                  _annotations.add(_doubleArrow);
                }
              };
              final State state = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
              includedUseCase2State.put(includedUseCase, state);
              EList<State> _states = automaton.getStates();
              _states.add(state);
              _xblockexpression = state;
            }
            _xifexpression = _xblockexpression;
          }
          final State includeState = _xifexpression;
          EList<Transition> _transitions = automaton.getTransitions();
          Transition _createTransition = this.ltsFactory.createTransition();
          final Procedure1<Transition> _function = new Procedure1<Transition>() {
            public void apply(final Transition it) {
              Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.JMP);
              State _get = stepToStateMap.get(_mappedTo);
              it.setStart(_get);
              it.setEnd(includeState);
            }
          };
          Transition _doubleArrow = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function);
          _transitions.add(_doubleArrow);
          EList<Transition> _transitions_1 = automaton.getTransitions();
          Transition _createTransition_1 = this.ltsFactory.createTransition();
          final Procedure1<Transition> _function_1 = new Procedure1<Transition>() {
            public void apply(final Transition it) {
              it.setStart(includeState);
              Pair<Step, StateType> _mappedTo = Pair.<Step, StateType>of(step, StateType.EXT);
              State _get = stepToStateMap.get(_mappedTo);
              it.setEnd(_get);
            }
          };
          Transition _doubleArrow_1 = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition_1, _function_1);
          _transitions_1.add(_doubleArrow_1);
        }
      }
    }
  }
}
