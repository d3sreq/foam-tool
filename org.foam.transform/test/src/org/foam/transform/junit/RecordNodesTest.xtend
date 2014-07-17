package org.foam.transform.junit

import org.foam.dot.DotFactory
import org.foam.dot.InnerNode
import org.foam.dot.Node
import org.foam.dot.SettingsType
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.junit.utils.DotTestUtils
import org.junit.Test

import static org.foam.transform.junit.utils.TestUtils.*

/**
 * Creates graph with record nodes.
 * This type of graph is used by lts2dot transformation.
 */
class RecordNodesTest {

	@Test def void transformGraph() {
		assertLinesEqual(
			expectedResult,
			new Dot2DotLang().transform(inputGraph)
		)
	}

	private extension DotFactory = DotFactory.eINSTANCE
	private extension DotTestUtils = new DotTestUtils

	var Node init
	var InnerNode n1In
	var InnerNode n1Jmp
	var InnerNode n2In
	var InnerNode n2Var
	var InnerNode n3In
	var InnerNode n2a1In
	var InnerNode n2a1Out
	var InnerNode n2a2In

	
	val inputGraph = createGraph => [
		// assignments
		statements += assignment("rankdir", "LR")
		statements += assignment("fontcolor", "gray")
		statements += assignment("fontname", "Arial")
		statements += assignment("margit","20")

		
		// node settings
		statements += createSettings => [
			type = SettingsType.NODE
			attributes += "shape" -> "Mrecord"
			attributes += "style" -> "filled"
			attributes += "label" -> ""
		]
		
		// edge settings
		statements += createSettings => [
			type = SettingsType.EDGE
			attributes += "fontname" -> "Arial"
		]
		
		// uc1
		statements += createGraph => [
			id = "uc1"
			statements += assignment("label", "Select city on map")
			
			// main scenario
			statements += createGraph => [
				id = "main"
				// 1
				statements += createRecordNode => [
					id = "1"
					attributes += "xlabel" -> "1"
					innerNodes += n1In = createInnerNode("IN")
					innerNodes += n1Jmp = createInnerNode("JMP")
				]				
				// 2
				statements += createRecordNode => [
					id = "2"
					attributes += "xlabel" -> "2"
					innerNodes += n2In = createInnerNode("IN")
					innerNodes += n2Var = createInnerNode("VAR")
				]
				// 3
				statements += createRecordNode => [
					id = "3"
					attributes += "xlabel" -> "3"
					attributes += "fillcolor" -> "green"

					innerNodes += n3In = createInnerNode("IN")
				]
			]
			
			// branch 2a
			statements += createGraph => [
				id = "2a"
				statements += assignment("label", "2a No cities available")
				
				// 2a1				
				statements += createRecordNode => [
					id = "2a1"
					attributes += "xlabel" -> "2a1"
					innerNodes += n2a1In = createInnerNode("IN")
					innerNodes += n2a1Out = createInnerNode("OUT")
				]
				// 2a2
				statements += createRecordNode => [
					id = "2a2"
					attributes += "xlabel" -> "2a2"
					attributes += "fillcolor" -> "red"
					
					innerNodes += n2a2In = createInnerNode("IN")
					innerNodes += createInnerNode("OUT")
				]
			]
		]
		
		// "global" init node not contained in use case
		init = createNode => [
			id = "init"
			attributes += "fillcolor" -> "black"
			attributes += "shape" -> "circle"
		]
		statements += init
		
		// edges
		statements += edge(init, n1In)
		statements += edge(n1Jmp, n2In)
		statements += edge(n2Var, n3In)
		statements += edge(n2Var, n2a1In)
		statements += edge(n2a1Out, n2a2In)
	]
	
	val expectedResult = '''
	digraph mygraph {
		rankdir="LR"
		fontcolor="gray"
		fontname="Arial"
		margit="20"
		node [
			shape="Mrecord",
			style="filled",
			label=""
		]
		edge [
			fontname="Arial"
		]
		subgraph cluster_uc1 {
			label="Select city on map"
			subgraph cluster_main {
				"1" [xlabel="1", label="{<IN>|<JMP>}"]
				"2" [xlabel="2", label="{<IN>|<VAR>}"]
				"3" [xlabel="3", fillcolor="green", label="{<IN>}"]
			}
			subgraph cluster_2a {
				label="2a No cities available"
				"2a1" [xlabel="2a1", label="{<IN>|<OUT>}"]
				"2a2" [xlabel="2a2", fillcolor="red", label="{<IN>|<OUT>}"]
			}
		}
		"init" [fillcolor="black", shape="circle"]
		"init" -> "1":"IN" 
		"1":"JMP" -> "2":"IN" 
		"2":"VAR" -> "3":"IN" 
		"2":"VAR" -> "2a1":"IN" 
		"2a1":"OUT" -> "2a2":"IN" 
	}
	'''
}