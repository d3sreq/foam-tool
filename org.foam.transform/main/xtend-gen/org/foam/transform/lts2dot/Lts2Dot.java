package org.foam.transform.lts2dot;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.foam.dot.Graph;
import org.foam.dot.Node;
import org.foam.dot.RecordNode;
import org.foam.lts.Automaton;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.transform.lts2dot.DummyUseCaseMap;
import org.foam.transform.lts2dot.processor.state.AddScenarioStateProcessor;
import org.foam.transform.lts2dot.processor.state.AddUseCaseStateProcessor;
import org.foam.transform.lts2dot.processor.state.CircleWithoutStateTypeProcessor;
import org.foam.transform.lts2dot.processor.state.CreateNodeStateProcessor;
import org.foam.transform.lts2dot.processor.state.CreateOverviewNodeStateProcessor;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.lts2dot.processor.state.StyleIncludeNodeStateProcessor;
import org.foam.transform.lts2dot.processor.state.color.BlackInitStateProcessor;
import org.foam.transform.lts2dot.processor.state.color.GreenSuccessStateProcessor;
import org.foam.transform.lts2dot.processor.state.color.RedAbortStateProcessor;
import org.foam.transform.lts2dot.processor.state.label.BulletInnerNodeStateProcessor;
import org.foam.transform.lts2dot.processor.state.label.XlabelStepStateProcessor;
import org.foam.transform.lts2dot.processor.transition.CreateEdgeTransitionProcessor;
import org.foam.transform.lts2dot.processor.transition.CreateOverviewEdgeTransitionProcessor;
import org.foam.transform.lts2dot.processor.transition.TransitionProcessor;
import org.foam.ucm.Scenario;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;

@SuppressWarnings("all")
public class Lts2Dot {
  public Graph transform(final Automaton lts, final Graph graph) {
    Graph _xblockexpression = null;
    {
      final HashMap<State, Node> state2Node = new HashMap<State, Node>();
      final HashMap<State, Graph> state2Graph = new HashMap<State, Graph>();
      final HashMap<Scenario, Graph> scenario2Graph = new HashMap<Scenario, Graph>();
      final HashMap<UseCase, Graph> useCase2Graph = new HashMap<UseCase, Graph>();
      final HashMap<Step, RecordNode> step2RecordNode = new HashMap<Step, RecordNode>();
      AddUseCaseStateProcessor _addUseCaseStateProcessor = new AddUseCaseStateProcessor(graph, useCase2Graph);
      AddScenarioStateProcessor _addScenarioStateProcessor = new AddScenarioStateProcessor(graph, state2Graph, scenario2Graph, useCase2Graph);
      CreateNodeStateProcessor _createNodeStateProcessor = new CreateNodeStateProcessor(state2Node, step2RecordNode, state2Graph);
      CircleWithoutStateTypeProcessor _circleWithoutStateTypeProcessor = new CircleWithoutStateTypeProcessor(state2Node);
      XlabelStepStateProcessor _xlabelStepStateProcessor = new XlabelStepStateProcessor(step2RecordNode);
      BulletInnerNodeStateProcessor _bulletInnerNodeStateProcessor = new BulletInnerNodeStateProcessor(state2Node);
      State _initState = lts.getInitState();
      BlackInitStateProcessor _blackInitStateProcessor = new BlackInitStateProcessor(_initState, state2Node);
      GreenSuccessStateProcessor _greenSuccessStateProcessor = new GreenSuccessStateProcessor(step2RecordNode);
      RedAbortStateProcessor _redAbortStateProcessor = new RedAbortStateProcessor(step2RecordNode);
      final List<? extends StateProcessor> stateProcessorChain = Collections.<StateProcessor>unmodifiableList(Lists.<StateProcessor>newArrayList(_addUseCaseStateProcessor, _addScenarioStateProcessor, _createNodeStateProcessor, _circleWithoutStateTypeProcessor, _xlabelStepStateProcessor, _bulletInnerNodeStateProcessor, _blackInitStateProcessor, _greenSuccessStateProcessor, _redAbortStateProcessor));
      EList<State> _states = lts.getStates();
      final Consumer<State> _function = new Consumer<State>() {
        public void accept(final State it) {
          Lts2Dot.this.processState(stateProcessorChain, it);
        }
      };
      _states.forEach(_function);
      CreateEdgeTransitionProcessor _createEdgeTransitionProcessor = new CreateEdgeTransitionProcessor(graph, state2Node);
      final List<CreateEdgeTransitionProcessor> transitionProcessorChain = Collections.<CreateEdgeTransitionProcessor>unmodifiableList(Lists.<CreateEdgeTransitionProcessor>newArrayList(_createEdgeTransitionProcessor));
      EList<Transition> _transitions = lts.getTransitions();
      final Consumer<Transition> _function_1 = new Consumer<Transition>() {
        public void accept(final Transition it) {
          Lts2Dot.this.processTransition(transitionProcessorChain, it);
        }
      };
      _transitions.forEach(_function_1);
      _xblockexpression = graph;
    }
    return _xblockexpression;
  }
  
  public Graph transformSingleUseCase(final Automaton lts, final Graph graph) {
    Graph _xblockexpression = null;
    {
      final HashMap<State, Node> state2Node = new HashMap<State, Node>();
      final HashMap<State, Graph> state2Graph = new HashMap<State, Graph>();
      final HashMap<Scenario, Graph> scenario2Graph = new HashMap<Scenario, Graph>();
      final DummyUseCaseMap useCase2Graph = new DummyUseCaseMap(graph);
      final HashMap<Step, RecordNode> step2RecordNode = new HashMap<Step, RecordNode>();
      AddScenarioStateProcessor _addScenarioStateProcessor = new AddScenarioStateProcessor(graph, state2Graph, scenario2Graph, useCase2Graph);
      CreateNodeStateProcessor _createNodeStateProcessor = new CreateNodeStateProcessor(state2Node, step2RecordNode, state2Graph);
      XlabelStepStateProcessor _xlabelStepStateProcessor = new XlabelStepStateProcessor(step2RecordNode);
      BulletInnerNodeStateProcessor _bulletInnerNodeStateProcessor = new BulletInnerNodeStateProcessor(state2Node);
      GreenSuccessStateProcessor _greenSuccessStateProcessor = new GreenSuccessStateProcessor(step2RecordNode);
      RedAbortStateProcessor _redAbortStateProcessor = new RedAbortStateProcessor(step2RecordNode);
      StyleIncludeNodeStateProcessor _styleIncludeNodeStateProcessor = new StyleIncludeNodeStateProcessor(state2Node);
      final List<? extends StateProcessor> stateProcessorChain = Collections.<StateProcessor>unmodifiableList(Lists.<StateProcessor>newArrayList(_addScenarioStateProcessor, _createNodeStateProcessor, _xlabelStepStateProcessor, _bulletInnerNodeStateProcessor, _greenSuccessStateProcessor, _redAbortStateProcessor, _styleIncludeNodeStateProcessor));
      CreateEdgeTransitionProcessor _createEdgeTransitionProcessor = new CreateEdgeTransitionProcessor(graph, state2Node);
      final List<CreateEdgeTransitionProcessor> transitionProcessorChain = Collections.<CreateEdgeTransitionProcessor>unmodifiableList(Lists.<CreateEdgeTransitionProcessor>newArrayList(_createEdgeTransitionProcessor));
      EList<State> _states = lts.getStates();
      final Consumer<State> _function = new Consumer<State>() {
        public void accept(final State it) {
          Lts2Dot.this.processState(stateProcessorChain, it);
        }
      };
      _states.forEach(_function);
      EList<Transition> _transitions = lts.getTransitions();
      final Consumer<Transition> _function_1 = new Consumer<Transition>() {
        public void accept(final Transition it) {
          Lts2Dot.this.processTransition(transitionProcessorChain, it);
        }
      };
      _transitions.forEach(_function_1);
      _xblockexpression = graph;
    }
    return _xblockexpression;
  }
  
  public Graph transformOverview(final Automaton lts, final Graph graph) {
    Graph _xblockexpression = null;
    {
      final HashMap<State, Node> state2Node = new HashMap<State, Node>();
      CreateOverviewNodeStateProcessor _createOverviewNodeStateProcessor = new CreateOverviewNodeStateProcessor(graph, state2Node);
      final List<CreateOverviewNodeStateProcessor> stateProcessorChain = Collections.<CreateOverviewNodeStateProcessor>unmodifiableList(Lists.<CreateOverviewNodeStateProcessor>newArrayList(_createOverviewNodeStateProcessor));
      CreateOverviewEdgeTransitionProcessor _createOverviewEdgeTransitionProcessor = new CreateOverviewEdgeTransitionProcessor(graph, state2Node);
      final List<CreateOverviewEdgeTransitionProcessor> transitionProcessorChain = Collections.<CreateOverviewEdgeTransitionProcessor>unmodifiableList(Lists.<CreateOverviewEdgeTransitionProcessor>newArrayList(_createOverviewEdgeTransitionProcessor));
      EList<State> _states = lts.getStates();
      final Consumer<State> _function = new Consumer<State>() {
        public void accept(final State it) {
          Lts2Dot.this.processState(stateProcessorChain, it);
        }
      };
      _states.forEach(_function);
      EList<Transition> _transitions = lts.getTransitions();
      final Consumer<Transition> _function_1 = new Consumer<Transition>() {
        public void accept(final Transition it) {
          Lts2Dot.this.processTransition(transitionProcessorChain, it);
        }
      };
      _transitions.forEach(_function_1);
      _xblockexpression = graph;
    }
    return _xblockexpression;
  }
  
  private void processState(final Iterable<? extends StateProcessor> processors, final State state) {
    final Consumer<StateProcessor> _function = new Consumer<StateProcessor>() {
      public void accept(final StateProcessor it) {
        it.process(state);
      }
    };
    processors.forEach(_function);
  }
  
  private void processTransition(final Iterable<? extends TransitionProcessor> processors, final Transition transition) {
    final Consumer<TransitionProcessor> _function = new Consumer<TransitionProcessor>() {
      public void accept(final TransitionProcessor it) {
        it.process(transition);
      }
    };
    processors.forEach(_function);
  }
}
