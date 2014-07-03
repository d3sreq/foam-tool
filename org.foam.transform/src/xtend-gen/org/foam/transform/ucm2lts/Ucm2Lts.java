package org.foam.transform.ucm2lts;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
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
import org.foam.propositionallogic.PropositionallogicFactory;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.traceability.StateType;
import org.foam.traceability.TraceabilityFactory;
import org.foam.transform.ucm2lts.StateAddedEventListener;
import org.foam.transform.utils.naming.NameService;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;
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
  
  private final LtsFactory ltsFactory = LtsFactory.eINSTANCE;
  
  private final FlowannotationFactory flowannotationFactory = FlowannotationFactory.eINSTANCE;
  
  private final PropositionallogicFactory propositionalLogicFactory = PropositionallogicFactory.eINSTANCE;
  
  private final VerificationFactory verificationFactory = VerificationFactory.eINSTANCE;
  
  private final TraceabilityFactory tracFactory = TraceabilityFactory.eINSTANCE;
  
  private final NameService nameService = new NameService();
  
  private final ArrayList<StateAddedEventListener> stateAddedEventListeners = new ArrayList<StateAddedEventListener>();
  
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method notifyStateAdded is undefined for the type Ucm2Lts"
      + "\nThe method addTransition is undefined for the type Ucm2Lts");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addTransition is undefined for the type Ucm2Lts");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addTransition is undefined for the type Ucm2Lts"
      + "\nannotations cannot be resolved"
      + "\n+= cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addTransition is undefined for the type Ucm2Lts");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addTransition is undefined for the type Ucm2Lts");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method addTransition is undefined for the type Ucm2Lts");
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
    throw new Error("Unresolved compilation problems:"
      + "\nmissing \'}\' at \'if\'"
      + "\nThe method addTransition is undefined for the type Ucm2Lts"
      + "\nThe method or field lastStepOfMainScenario is undefined for the type Ucm2Lts"
      + "\nThe method or field lastStepOfMainScenario is undefined for the type Ucm2Lts"
      + "\nThe method debug is undefined for the type Ucm2Lts"
      + "\nThe method or field include is undefined for the type Ucm2Lts"
      + "\nThe method or field annotations is undefined for the type Ucm2Lts"
      + "\nThe method debug is undefined for the type Ucm2Lts"
      + "\nThe method label is undefined for the type Ucm2Lts"
      + "\nThe method or field include is undefined for the type Ucm2Lts"
      + "\nThe method or field returnStates is undefined for the type Ucm2Lts"
      + "\nThe method or field returnStates is undefined for the type Ucm2Lts"
      + "\nThe method debug is undefined for the type Ucm2Lts"
      + "\nThe method or field stepExtState is undefined for the type Ucm2Lts"
      + "\nThe method addTransition is undefined for the type Ucm2Lts"
      + "\nThe method or field stepExtState is undefined for the type Ucm2Lts"
      + "\nThe method or field varDef is undefined for the type Ucm2Lts"
      + "\nThe method or field varDef is undefined for the type Ucm2Lts"
      + "\nannotations cannot be resolved"
      + "\n+= cannot be resolved"
      + "\nannotations cannot be resolved"
      + "\nexists cannot be resolved"
      + "\n! cannot be resolved"
      + "\n-> cannot be resolved"
      + "\ninlinedUseCase cannot be resolved"
      + "\nallSteps cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nexists cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\ninlinedUseCase cannot be resolved"
      + "\nid cannot be resolved"
      + "\n+= cannot be resolved"
      + "\nid cannot be resolved"
      + "\nid cannot be resolved"
      + "\nannotations cannot be resolved"
      + "\n+= cannot be resolved"
      + "\nannotations cannot be resolved"
      + "\n+= cannot be resolved");
  }
}
