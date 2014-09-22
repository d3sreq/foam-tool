package org.foam.transform.junit.utils

import org.foam.flowannotation.Goto
import org.foam.flowannotation.Guard
import org.foam.flowannotation.Include
import org.foam.flowannotation.Mark

// TODO: this should be an extension
class FlowAnnotationChecker extends UcmChecker {
	
	private extension PropositionalLogicFormulaChecker = new PropositionalLogicFormulaChecker
	
	def dispatch void assertAnnotationEquals(Goto expected, Goto actual) {
		assertStepEquals(expected.target, actual.target)
	}
		
	def dispatch void assertAnnotationEquals(Include expected, Include actual) {
		assertUseCaseEquals(expected.inlinedUseCase, actual.inlinedUseCase)
	}
	
	def dispatch void assertAnnotationEquals(Mark expected, Mark actual) {
		assertVariableDefinitionEquals(expected.variableDefinition, actual.variableDefinition)
	}
	
	def dispatch void assertAnnotationEquals(Guard expected, Guard actual) {
		check(expected.formula, actual.formula)
	}
	
}