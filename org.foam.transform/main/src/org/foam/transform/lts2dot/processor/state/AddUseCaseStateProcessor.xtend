package org.foam.transform.lts2dot.processor.state

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.DotFactory
import org.foam.dot.Graph
import org.foam.lts.State
import org.foam.ucm.UseCase

import static extension org.foam.lts.util.LtsModelExtensions.*
import static extension org.foam.ucm.util.UseCaseModelExtensions.*

/**
 * Creates subgraph (cluster) for use case and scenario of the given state if this subgraph is
 * not already present in {@code processorData}.
 * 
 * @param mapping in parameter
 * @param resultDot out parameter (graph to which use case graphs are added),
 * 		populated in this processor
 * @param useCase2Graph out parameter, populated in this processor 
 */
@Data
class AddUseCaseStateProcessor implements StateProcessor {

	Graph resultDot
	Map<UseCase, Graph> useCase2Graph	
	
	val dotFactory = DotFactory.eINSTANCE

	override process(State state) {
		addUseCaseSubGraph(state)
	}
	
	def private addUseCaseSubGraph(State state) {
		// create subgraph for each use case
		val step = state.stepFromStepMappingAnnotation
		
		if (step != null) {
			val useCase = step.getUseCase
			if (!useCase2Graph.containsKey(useCase)) {
				val subGraph = dotFactory.createGraph => [
					id = useCase.id
					statements += dotFactory.createAssignment => [
						key = "label"
						value = '''«useCase.id»: «useCase.name»'''
					]
				]
				useCase2Graph.put(useCase, subGraph)
				resultDot.statements += subGraph
			} 
		}
	}
}