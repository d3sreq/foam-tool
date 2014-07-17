package org.foam.transform.junit

import org.foam.dot.DotFactory
import org.foam.dot.Node
import org.foam.dot.SettingsType
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.junit.utils.DotTestUtils
import org.junit.Test

import static org.foam.transform.junit.utils.TestUtils.*

/**
 * Creates graph with separate nodes. This type of graph is currently not used by lts2dot
 * transformation (lts2dot uses record nodes and all edges are in top-level graph).
 */
class SeparateNodesTest {
	
	@Test def void transformGraph() {
		assertLinesEqual(
			expectedResult,
			new Dot2DotLang().transform(inputGraph)
		)
	}

	private extension DotFactory = DotFactory.eINSTANCE
	private extension DotTestUtils = new DotTestUtils

	var Node n0
	var Node n1
	var Node n2
	var Node n3
	var Node n2a
	var Node n2a1 
	
	val inputGraph = createGraph => [

		// assignments
		statements += assignment("rankdir", "LR")
		statements += assignment("size", "6")
		statements += assignment("ranksep", "0.2")
		statements += assignment("nodesep", "0.2")
		statements += assignment("fontcolor", "gray")
		statements += assignment("fontname", "Arial")
		statements += assignment("color", "gray")
		statements += assignment("labeljust", "l")
		
		// node settings
		statements += createSettings => [
			type = SettingsType.NODE
			attributes += "shape" -> "circle"
			attributes += "style" -> "filled"
			attributes += "fixedsize" -> "true"
			attributes += "width" -> "0.24"
			attributes += "label" -> ""
		]
		
		// edge settings
		statements += createSettings => [
			type = SettingsType::EDGE
			attributes += "fontname" -> "Arial"
		]
		
		// main scenario cluster
		statements += createGraph => [
			id = "main"
			statements += assignment("label", "Main success scenario\\l")
			
			// nodes
			statements += n0 = createNode => [id = "0"
				attributes += "fillcolor" -> "black"
			]
			statements += n1 = createNode => [id = "1"]
			statements += n2 = createNode => [id = "2"]
			statements += n3 = createNode => [id = "3"
				attributes += "fillcolor" -> "green"
			]
			
			// edges
			statements += edge(n0, n1) => [
				attributes += "label" -> "1"
				attributes += "URL" -> "#uc1s1"
			]
			statements += edge(n1, n2) => [
				attributes += "label" -> "2"
				attributes +="URL" -> "#uc1s2"
			]
			statements += edge(n2, n3) => [
				attributes += "label" -> "3"
				attributes += "URL" -> "#uc1s3"
			]			
		]
		
		// 2a branch cluster
		statements += createGraph => [
			id = "2a"
			statements += assignment("label", "Extension: 2a.\\lAn input file is not available at the moment of compression\\l")

			// nodes
			statements += n2a = createNode => [id = "2a"]
			statements += n2a1 = createNode => [id = "2a1"]
			
			// edges
			statements += edge(n2, n2a) => [
				attributes += "label" -> "2a"
			]
			statements += edge(n2a, n2a1) => [
				attributes += "label" -> "2a1"
			]			
			statements += edge(n2a1,n1) => [
				attributes += "label" -> "2a2 goto 2"
				attributes += "style" -> "dashed"
			]
		]		
	]
	
	val expectedResult = 
		'''
		digraph mygraph {
			rankdir="LR"
			size="6"
			ranksep="0.2"
			nodesep="0.2"
			fontcolor="gray"
			fontname="Arial"
			color="gray"
			labeljust="l"
			node [
				shape="circle",
				style="filled",
				fixedsize="true",
				width="0.24",
				label=""
			]
			edge [
				fontname="Arial"
			]
			subgraph cluster_main {
				label="Main success scenario\l"
				"0" [fillcolor="black"]
				"1" 
				"2" 
				"3" [fillcolor="green"]
				"0" -> "1" [label="1", URL="#uc1s1"]
				"1" -> "2" [label="2", URL="#uc1s2"]
				"2" -> "3" [label="3", URL="#uc1s3"]
			}
			subgraph cluster_2a {
				label="Extension: 2a.\lAn input file is not available at the moment of compression\l"
				"2a" 
				"2a1" 
				"2" -> "2a" [label="2a"]
				"2a" -> "2a1" [label="2a1"]
				"2a1" -> "1" [label="2a2 goto 2", style="dashed"]
			}
		}
		'''
}