package org.foam.transform.lts2dot

import java.util.HashMap
import org.foam.dot.Graph
import org.foam.dot.Node
import org.foam.dot.RecordNode
import org.foam.lts.Automaton
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.transform.lts2dot.processor.state.AddScenarioStateProcessor
import org.foam.transform.lts2dot.processor.state.AddUseCaseStateProcessor
import org.foam.transform.lts2dot.processor.state.CircleWithoutStateTypeProcessor
import org.foam.transform.lts2dot.processor.state.CreateNodeStateProcessor
import org.foam.transform.lts2dot.processor.state.CreateOverviewNodeStateProcessor
import org.foam.transform.lts2dot.processor.state.StateProcessor
import org.foam.transform.lts2dot.processor.state.StyleIncludeNodeStateProcessor
import org.foam.transform.lts2dot.processor.state.color.BlackInitStateProcessor
import org.foam.transform.lts2dot.processor.state.color.GreenSuccessStateProcessor
import org.foam.transform.lts2dot.processor.state.color.RedAbortStateProcessor
import org.foam.transform.lts2dot.processor.state.label.BulletInnerNodeStateProcessor
import org.foam.transform.lts2dot.processor.state.label.XlabelStepStateProcessor
import org.foam.transform.lts2dot.processor.transition.CreateEdgeTransitionProcessor
import org.foam.transform.lts2dot.processor.transition.CreateOverviewEdgeTransitionProcessor
import org.foam.transform.lts2dot.processor.transition.TransitionProcessor
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UseCase

class Lts2Dot {

	def transform(Automaton lts, Graph graph) {

		// init
		val state2Node = new HashMap<State, Node>
		val state2Graph = new HashMap<State, Graph>
		val scenario2Graph = new HashMap<Scenario, Graph>
		val useCase2Graph = new HashMap<UseCase, Graph>
		val step2RecordNode = new HashMap<Step, RecordNode>

		// process states
		val stateProcessorChain = #[
			new AddUseCaseStateProcessor(graph, useCase2Graph),
			new AddScenarioStateProcessor(graph, state2Graph, scenario2Graph, useCase2Graph),
			new CreateNodeStateProcessor(state2Node, step2RecordNode, state2Graph),
			new CircleWithoutStateTypeProcessor(state2Node),
			// graphviz 2.28 on windows has problem with labels added to record nodes, fixed in gv >= 2.30
			new XlabelStepStateProcessor(step2RecordNode),
			new BulletInnerNodeStateProcessor(state2Node),
			new BlackInitStateProcessor(lts.initState, state2Node),
			new GreenSuccessStateProcessor(step2RecordNode),
			new RedAbortStateProcessor(step2RecordNode)
		]
		lts.states.forEach[stateProcessorChain.processState(it)]

		// process transitions
		val transitionProcessorChain = #[
			new CreateEdgeTransitionProcessor(graph, state2Node)
		]

		lts.transitions.forEach[transitionProcessorChain.processTransition(it)]

		graph
	}

	def transformSingleUseCase(Automaton lts, Graph graph) {
		val state2Node = new HashMap<State, Node>
		val state2Graph = new HashMap<State, Graph>
		val scenario2Graph = new HashMap<Scenario, Graph>

		// scenario processor needs this map
		// return dummy map returning always top-level graph
		//		val useCase2Graph = new HashMap<UseCase, Graph>
		val useCase2Graph = new DummyUseCaseMap(graph)
		val step2RecordNode = new HashMap<Step, RecordNode>

		val stateProcessorChain = #[
			// new AddUseCaseStateProcessor(graph, useCase2Graph),
			new AddScenarioStateProcessor(graph, state2Graph, scenario2Graph, useCase2Graph),
			new CreateNodeStateProcessor(state2Node, step2RecordNode, state2Graph),
			// graphviz 2.28 on windows has problem with labels added to record nodes, fixed in gv >= 2.30
			new XlabelStepStateProcessor(step2RecordNode),
			new BulletInnerNodeStateProcessor(state2Node),
			new GreenSuccessStateProcessor(step2RecordNode),
			new RedAbortStateProcessor(step2RecordNode),
			new StyleIncludeNodeStateProcessor(state2Node)
		]

		val transitionProcessorChain = #[
			new CreateEdgeTransitionProcessor(graph, state2Node)
		]

		lts.states.forEach[stateProcessorChain.processState(it)]
		lts.transitions.forEach[transitionProcessorChain.processTransition(it)]

		graph
	}

	@Deprecated
	def transformOverview(Automaton lts, Graph graph) {
		val state2Node = new HashMap<State, Node>

		val stateProcessorChain = #[
			new CreateOverviewNodeStateProcessor(graph, state2Node)
		]

		val transitionProcessorChain = #[
			new CreateOverviewEdgeTransitionProcessor(graph, state2Node)
		]

		lts.states.forEach [stateProcessorChain.processState(it)]
		lts.transitions.forEach [transitionProcessorChain.processTransition(it)]

		graph
	}

	def private void processState(Iterable<? extends StateProcessor> processors, State state) {
		processors.forEach[process(state)]
	}

	def private void processTransition(Iterable<? extends TransitionProcessor> processors, Transition transition) {
		processors.forEach[process(transition)]
	}
}

class DummyUseCaseMap extends HashMap<UseCase, Graph> {

	// maven has problem compiling class when @Data annotation is attached
	// so explicit constructor is used instead
	val Graph graph

	new(Graph graph) {
		this.graph = graph
	}

	override get(Object key) {
		graph
	}

}
