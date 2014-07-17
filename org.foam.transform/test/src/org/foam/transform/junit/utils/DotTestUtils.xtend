package org.foam.transform.junit.utils

import org.eclipse.emf.common.util.EMap
import org.foam.dot.DotFactory
import org.foam.dot.Node

class DotTestUtils {

	private extension DotFactory = DotFactory.eINSTANCE

	def createInnerNode(String id) {
		return createInnerNode => [
			it.id = id
		]
	}
	
	def <K,V> += (EMap<K, V> map, Pair<K, V> p) {
		map.put(p.key, p.value)
	}
	
	def assignment(String k, String v) {
		createAssignment => [
			key = k
			value = v
		]
	}
	
	def edge(Node src, Node dst) {
		createEdge => [
			source = src
			target = dst
		]
	}
}