package org.foam.transform.dot2dotlang

import org.foam.dot.Assignment
import org.foam.dot.AttributedItem
import org.foam.dot.Edge
import org.foam.dot.Graph
import org.foam.dot.InnerNode
import org.foam.dot.Node
import org.foam.dot.RecordNode
import org.foam.dot.Settings

class Dot2DotLang {
	
	static val LABEL_ATTRIBUTE_KEY = "label"
	
	def transform(Graph graph) '''	
		digraph mygraph {
			«FOR statement : graph.statements»
				«statement.print»
			«ENDFOR»
		}
	'''
	
	def private dispatch CharSequence print(Graph subgraph) '''
		subgraph cluster_«subgraph.id» {
			«FOR statement : subgraph.statements»
				«statement.print»
			«ENDFOR»
		}
	'''
	
	/**
	 * For record node add label with its inner nodes.
	 */
	def private dispatch print(RecordNode node) {
		val labelValue = node.innerNodes.join(
			"{", // before
			"|", // separator
			"}", // after
			[
				val innerNodeLabel = it.attributes.get(LABEL_ATTRIBUTE_KEY) ?: ""
				'''<«it.id»>«innerNodeLabel.escape»'''
			])
		
		node.attributes.put(LABEL_ATTRIBUTE_KEY, labelValue)
		return '''"«node.id»" «node.createAttributeList»'''
	}

	def private dispatch print(Node node) {
		'''"«node.id»" «node.createAttributeList»'''
	}
	
	def private dispatch print(Edge edge) '''
		«edge.source.edgeNodeId» -> «edge.target.edgeNodeId» «edge.createAttributeList»
	'''

	def private dispatch print(Assignment assignment) '''
		«assignment.key»="«assignment.value.escape»"
	'''
	
	def private dispatch print(Settings settings) '''
		«settings.type.literal» [
			«FOR attribute : settings.attributes SEPARATOR ","»
				«attribute.key»="«attribute.value.escape»"
			«ENDFOR»
		]
	'''

	@Pure def private static String escape(String strToEscape)
		'''«strToEscape?.replaceAll('"', '\\\\"')»'''

	@Pure def private static dispatch edgeNodeId(Node node) '''"«node.id»"'''
	@Pure def private static dispatch edgeNodeId(InnerNode node) '''"«node.recordNode.id»":"«node.id»"'''
	
	@Pure def private static createAttributeList(AttributedItem attributedItem) {
		if (attributedItem.attributes.empty) ""
		else attributedItem.attributes.entrySet.join(
			"[",  // before
			", ", // separator
			"]",  // after
			['''«key»="«value.escape»"''']
		)
	}
}