package org.foam.transform.lts2dot.processor.state

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.DotFactory
import org.foam.dot.Graph
import org.foam.lts.State
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.UseCase

import static extension org.foam.lts.util.LtsModelExtensions.*
import static extension org.foam.ucm.util.UseCaseModelExtensions.*

/**
 * Creates subgraph (cluster) for use case and scenario of the given state if this subgraph is
 * not already present in {@code processorData}.
 */
@Data
class AddScenarioStateProcessor implements StateProcessor {

	Graph resultDot
	Map<State, Graph> state2Graph
	Map<Scenario, Graph> scenario2Graph
	Map<UseCase, Graph> useCase2Graph

	val dotFactory = DotFactory.eINSTANCE
	val SCENARIO_TEXT_MAXLEN = 30

	override process(State state) {
		addScenarioSubGraph(state)
	}
	
	def private addScenarioSubGraph(State state) {
		// create subgraph for each scenario
		val step = state.stepFromStepMappingAnnotation
		val graphForNode = if (step == null) {
			resultDot
		} else {
			val scenario = step.getScenario
			if (!scenario2Graph.containsKey(scenario)) {
				val subGraph = dotFactory.createGraph => [
					id = '''«scenario.useCase.id»_«scenario.label»''' // assert: id does not contain spaces

					if (!scenario.isMainScenario) {
						statements += dotFactory.createAssignment => [
							val text = if (scenario.text.length < SCENARIO_TEXT_MAXLEN) scenario.text else scenario.text.substring(0, SCENARIO_TEXT_MAXLEN) + "..." 
							
							key = "label"
							value = '''
								«IF scenario.isExtensionBranch»Extension: «scenario.label».\l«ENDIF»
								«IF scenario.isVariationBranch»Variation: «scenario.label».\l«ENDIF»
								«text»
							'''.toString.replaceAll("\\s+", " ")
						]
						statements += dotFactory.createAssignment => [
							key = "bgcolor"
							value = "#f2f2f2" // see http://www.graphviz.org/doc/info/colors.html
						]
						statements += dotFactory.createAssignment => [
							key = "fontcolor"
							value = "gray" // see http://www.graphviz.org/doc/info/colors.html
						]
						
					} else {
						statements += dotFactory.createAssignment => [
							key = "bgcolor"
							//value = "#e5d8bd" // see http://www.graphviz.org/doc/info/colors.html
							value = "#ffffcc" // see http://www.graphviz.org/doc/info/colors.html
						]
						statements += dotFactory.createAssignment => [
							key = "label"
							value = ""
						]
					}
					
					
					// add margin to prevent step label and scenario box overlapping
					statements += dotFactory.createAssignment => [
						key = "margin"
						value = "30"
					]
				]
				scenario2Graph.put(scenario, subGraph)
				// add scenario graph into use case graph
				val uc = step.getUseCase
				val ucGraph = useCase2Graph.get(uc)
				ucGraph.statements += subGraph
			}
			scenario2Graph.get(scenario)
		}
		state2Graph.put(state, graphForNode)
	}
	
	//TODO:could be an extension method for "Scenario"
	@Pure def private static isMainScenario(Scenario scenario) {
		 scenario.eContainer instanceof UseCase
	}
	
	//TODO:could be an extension method for "Scenario"
	@Pure def private static isExtensionBranch(Scenario scenario) {
		val container = scenario.eContainer
		if(! (container instanceof ScenarioHolder) ) {
			return false
		}
		
		val scenHolder = container as ScenarioHolder
		scenHolder.extensions.contains(scenario)
	}

	//TODO:could be an extension method for "Scenario"
	@Pure def private static isVariationBranch(Scenario scenario) {
		val container = scenario.eContainer
		if(! (container instanceof ScenarioHolder) ) {
			return false
		}
		
		val scenHolder = container as ScenarioHolder
		scenHolder.variations.contains(scenario)
	}
}