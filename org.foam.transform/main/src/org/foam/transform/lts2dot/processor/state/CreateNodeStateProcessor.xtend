package org.foam.transform.lts2dot.processor.state

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.DotFactory
import org.foam.dot.Graph
import org.foam.dot.Node
import org.foam.dot.RecordNode
import org.foam.lts.State
import org.foam.traceability.StateType
import org.foam.ucm.Step

import static extension org.foam.transform.utils.modeling.FoamModelExtensions.*
import static extension org.foam.ucm.util.UseCaseModelExtensions.*

/**
 * @param mapping in parameter
 * @param state2Node out parameter, populated in this processor
 * @param step2RecordNode out parameter, populated in this processor
 * @param state2Graph in parameter, map has to contain mapping from given state 
 * 		to graph before {@link process(State)} is called!
 */
@Data
class CreateNodeStateProcessor implements StateProcessor {
	
	Map<State, Node> state2Node
	Map<Step, RecordNode> step2RecordNode
	Map<State, Graph> state2Graph

	val dotFactory = DotFactory.eINSTANCE
	
	/** 
	 *  Increment used to increase width of record node. Width of record node is 
	 *  increased for every inner node present inside record node.
	 */
	static val WIDTH_INCREMENT = 0.5
	static val WIDTH_ATTRIBUTE_MAP_KEY = "width"
	static val TOOLTIP_ATTRIBUTE_MAP_KEY = "tooltip"

	override process(State state) {
		val stateType = state.stateTypeFromStateTypeMappingAnnotation
		if (stateType != null) {
			// stateType annotation attached => state has also step annotation attached 
			val step = state.stepFromStepMappingAnnotation
			addRecordNode(state, stateType, step)
		} else {
			addNonRecordNode(state)
		}
	}
	
	def addNonRecordNode(State state) {
		val node = dotFactory.createNode => [
			id = state.id
		]
		state2Node.put(state, node)
		state2Graph.get(state).statements += node
	}

	def addRecordNode(State state, StateType stateType, Step step) {
		// get/add record node which will serve as container for inner node 
		if (!step2RecordNode.containsKey(step)) {
			val recordNode = dotFactory.createRecordNode => [
				id = '''«step.useCase.id»«step.label»'''
				attributes.put(TOOLTIP_ATTRIBUTE_MAP_KEY, step.text)
				attributes.put(WIDTH_ATTRIBUTE_MAP_KEY, "0.0")
			]
			step2RecordNode.put(step, recordNode)
			state2Graph.get(state).statements += recordNode 
		}
		val recordNode = step2RecordNode.get(step)
		
		// add inner node
		val innerNode = dotFactory.createInnerNode => [
			// inner node is fully qualified by it's ID and ID of it's record node 
			id = stateType.toString
		]
		recordNode.innerNodes += innerNode
		increaseRecordNodeWidth(recordNode)
		
		state2Node.put(state, innerNode)
	}
	
	def private increaseRecordNodeWidth(RecordNode node) {
		val currentWidth = Double.valueOf(node.attributes.get(WIDTH_ATTRIBUTE_MAP_KEY))
		val newWidth = currentWidth + WIDTH_INCREMENT
		node.attributes.put(WIDTH_ATTRIBUTE_MAP_KEY, newWidth.toString)
	}
	
}