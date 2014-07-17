package org.foam.transform.junit.utils

import org.foam.annotation.Annotation
import org.foam.cntex.CntExState
import org.foam.cntex.CounterExample
import org.foam.cntex.Specification
import org.foam.cntex.Trace
import org.foam.traceability.StateMappingAnnotation

import static org.junit.Assert.*

class CntexChecker {
	
	def assertCounterExampleEquals(CounterExample expected, CounterExample actual) {
		assertEquals(expected.specifications.size, actual.specifications.size)
		expected.specifications.forEach[exp, i |
			assertSpecificationEquals(exp, actual.specifications.get(i))
		]
	}
	
	def assertSpecificationEquals(Specification expected, Specification actual) {
		assertEquals(expected.textFormula, actual.textFormula)
		assertTraceEquals(expected.trace, actual.trace)
	}
	
	def assertTraceEquals(Trace expected, Trace actual) {
		if (expected == null) {
			assertNull(actual)
			return
		}
		assertNotNull(actual)
		
		assertEquals(expected.states.size, actual.states.size)
		expected.states.forEach[exp, i |
			assertStateEquals(exp, actual.states.get(i))
		]
	}
	
	def assertStateEquals(CntExState expected, CntExState actual) {
		assertEquals(expected.annotations.size, actual.annotations.size)
		expected.annotations.forEach[exp, i |
			assertAnnotationEquals(exp, actual.annotations.get(i))
		]
		
		assertEquals(expected.assignments.size, actual.assignments.size)
		expected.assignments.forEach[exp, i |
			assertEquals(exp.variableName, actual.assignments.get(i).variableName)
			assertEquals(exp.value, actual.assignments.get(i).value)
		]
	}
	
	def private dispatch assertAnnotationEquals(Annotation expected, Annotation actual) {
		assertEquals(expected.class, actual.class)
	}
	
	def private dispatch assertAnnotationEquals(StateMappingAnnotation expected, StateMappingAnnotation actual) {
		assertEquals(expected.state.id, actual.state.id)
	}
}