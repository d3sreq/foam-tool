package org.foam.transform.junit

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.ltl.LtlFactory
import org.foam.ltl.LtlPackage
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.xtext.ltl.LtlXtextStandaloneSetup
import org.foam.xtext.ltl.parser.antlr.LtlXtextParser
import org.foam.xtext.plogic.propositionalLogicXtext.PropositionalLogicXtextFactory
import org.junit.Assert
import org.junit.Test

class LtlParserTest {

	val propFac = PropositionallogicFactory.eINSTANCE
	val propXtextFac = PropositionalLogicXtextFactory.eINSTANCE
	val ltlFac = LtlFactory.eINSTANCE
	
	private LtlXtextParser ltlParser
	new() {
		
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl or LTL formula (propositional logic formula is parsed
		// without errors).
		if (!EPackage.Registry.INSTANCE.containsKey(LtlPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(LtlPackage.eNS_URI, LtlPackage.eINSTANCE)
		}

		// TODO - use guice annotations to inject parser instead ?
		val ltlInjector = new LtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration
		ltlParser = ltlInjector.getInstance(LtlXtextParser)
	}
	
	@Test def void testPropositionalLogicFormula() {
		// basic check that parser parses also propositional logic formulas
		assertFormulaEquals(propFac.createAnd => [
    		left = propFac.createTrue
    		right = propFac.createFalse
    	], "true & false")
    	
    	assertFormulaEquals(propFac.createEquivalence => [
    		left = propFac.createTrue
    		right = propFac.createFalse
    	], "true <-> false")
	}
	
	@Test def void testLtlOperator() {
		assertFormulaEquals(ltlFac.createGlobally => [
    		formula = propFac.createTrue
    	], "G true")
    	
    	assertFormulaEquals(ltlFac.createFuture => [
    		formula = propFac.createTrue
    	], "F true")
    	
    	assertFormulaEquals(ltlFac.createNext => [
    		formula = propFac.createTrue
    	], "X true")
    	
    	assertFormulaEquals(ltlFac.createUntil => [
    		left = propFac.createTrue
    		right = propFac.createFalse
    	], "true U false")
	}
	
	@Test def void testLtlOpenClose() {
		assertFormulaEquals(ltlFac.createGlobally => [
    		formula = propFac.createImplication => [
    			left = propXtextFac.createRuleVariableUse => [
    				variable = "open"
    			]
    			right = ltlFac.createFuture => [
    				formula = propXtextFac.createRuleVariableUse => [
    					variable = "close"
    				] 
    			]
    		]
    	], "G(open -> F(close))")
	}
	
	@Test def void testUntilPrecedence() {
		assertFormulaEquals(ltlFac.createUntil => [
			left = propXtextFac.createRuleVariableUse => [
				variable = "a"
			]
			right = propFac.createAnd => [
				left = propXtextFac.createRuleVariableUse => [
					variable = "b"
				]
				right = propXtextFac.createRuleVariableUse => [
					variable = "c"
				]  
			]
		], "a U b & c")
	}
	
	@Test def void testNotUntilPrecedence() {
		assertFormulaEquals(ltlFac.createUntil => [
			left = propFac.createNot => [
				formula = propXtextFac.createRuleVariableUse => [
					variable = "emit2"
				]
			]			
			right = propXtextFac.createRuleVariableUse => [
				variable = "consume2"
			]  
		], "!emit2 U consume2")
	}
	
	def private assertFormulaEquals(Formula expectedFormula, String actualFormula) {
		val parseResult = ltlParser.doParse(actualFormula)
		val formula = parseResult.rootASTElement as Formula
		Assert.assertTrue("Parsed and expected formula doesn't match", EcoreUtil.equals(expectedFormula, formula))
	}
}