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
	
	def private dispatch print(Graph subgraph) '''
		subgraph cluster_«subgraph.id» {
			«FOR statement : subgraph.statements»
				«statement.print»
			«ENDFOR»
		}
	'''
	
	def private dispatch print(Node node) {
		// for record node add label with its inner nodes 
		if (node instanceof RecordNode) {
			val recordNode = node as RecordNode
			val labelValue = recordNode.innerNodes.join("{", "|", "}", [
				val innerNodeLabel = it.attributes.get(LABEL_ATTRIBUTE_KEY) ?: ""
				'''<«it.id»>«innerNodeLabel.escape»'''
			])
			
			recordNode.attributes.put(LABEL_ATTRIBUTE_KEY, labelValue)
		}
		
		'''"«node.id»" «node.createAttributeList»'''
	}
	
	def private dispatch print(Edge edge) '''
		«edge.source.edgeNodeId» -> «edge.target.edgeNodeId» «edge.createAttributeList»
	'''
	
	def private edgeNodeId(Node node) {
		if (node instanceof InnerNode) {
			val innerNode = node as InnerNode
			'''"«innerNode.recordNode.id»":"«innerNode.id»"'''
		} else {
			'''"«node.id»"'''
		}
	}
	
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
	
	def private createAttributeList(AttributedItem attributedItem) {
		if (attributedItem.attributes.empty) {
			return ""
		}
		
		attributedItem.attributes.entrySet.join("[", ", ", "]", [
			'''«it.key»="«it.value.escape»"'''
		])
	}
	
	def private String escape(String toEscape) {
		if (toEscape == null) {
			""
		} else {
			toEscape.replaceAll('"', '\\\\"')
		}
	}
}