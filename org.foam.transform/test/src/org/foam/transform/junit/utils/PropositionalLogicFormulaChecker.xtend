package org.foam.transform.junit.utils

import org.foam.propositionallogic.BinaryFormula
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.UnaryFormula
import org.foam.propositionallogic.VariableUse
import org.foam.xtext.plogic.propositionalLogicXtext.RuleVariableUse

import static org.junit.Assert.*

class PropositionalLogicFormulaChecker {
    
    def dispatch void check(UnaryFormula expected, UnaryFormula actual) {
    	assertTypeEquals(expected, actual)
    	check(expected.formula, actual.formula)
    }
    
    def dispatch void check(BinaryFormula expected, BinaryFormula actual) {
    	assertTypeEquals(expected, actual)
    	check(expected.left, actual.left)
    	check(expected.right, actual.right)
    }
    
    def dispatch void check(VariableUse expected, VariableUse actual) {
    	assertEquals(expected.variableDefinition.name, actual.variableDefinition.name)
    }
    
    def dispatch void check(RuleVariableUse expected, RuleVariableUse actual) {
    	assertEquals(expected.variable, actual.variable)
    }
    
    def dispatch void check(Formula expected, Formula actual) {
    	assertTypeEquals(expected, actual)
    }
    
    def protected void assertTypeEquals(Formula expected, Formula actual) {
    	val message = String::format("Formula doesn't have expected type. Expected: '%s' but was '%s'", expected.getClass, actual.getClass) 
		assertTrue(message, expected.getClass.isInstance(actual))		 
    }
}