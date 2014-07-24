package org.foam.transform.tadl

import org.foam.tadl.Group
import org.foam.tadl.GroupAnnotation
import org.foam.tadl.TemporalAnnotation
import org.foam.transform.junit.utils.UcmChecker

import static org.junit.Assert.*

class TadlAnnotationChecker extends UcmChecker {
	
	def dispatch void assertAnnotationEquals(TemporalAnnotation expected, TemporalAnnotation actual) {
		// variable def. is resolved to same object contained in template
		assertTrue(expected.variableDefinition.identityEquals(actual.variableDefinition))		
		assertGroupEquals(expected.group, actual.group)
	}
	
	def dispatch void assertAnnotationEquals(GroupAnnotation expected, GroupAnnotation actual) {
		assertGroupEquals(expected.group, actual.group)
	}
	
	def assertGroupEquals(Group expected, Group actual) {
		// template is resolved to same object
		assertTrue(expected.template.identityEquals(actual.template))
		assertEquals(expected.qualifier, actual.qualifier)
	}	 
	
}