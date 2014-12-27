package org.foam.transform.junit

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.ctl.CtlFactory
import org.foam.ctl.CtlPackage
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.xtext.ctl.CtlXtextStandaloneSetup
import org.foam.xtext.ctl.parser.antlr.CtlXtextParser
import org.foam.xtext.plogic.propositionalLogicXtext.PropositionalLogicXtextFactory
import org.junit.Assert
import org.junit.Test

class CtlParserTest {
	
	val ctlFac = CtlFactory.eINSTANCE
	val propFac = PropositionallogicFactory.eINSTANCE
	val propXtextFac = PropositionalLogicXtextFactory.eINSTANCE

	val CtlXtextParser ctlParser
	
	new() {
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl formula (propositional logic formula is parsed
		// without errors).
		//
		// Package should be probably registered in GenerateLtlXtext.mwe2 file
		// but wasn't able to figure out how to do it.
		if (!EPackage.Registry.INSTANCE.containsKey(CtlPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(CtlPackage.eNS_URI, CtlPackage.eINSTANCE)
		}

		// TODO - use guice annotations to inject parser instead ?
		val ctlInjector = new CtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration
		ctlParser = ctlInjector.getInstance(CtlXtextParser)
	}
	
	@Test
	def void testPropositionalLogicFormula() {
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
	
	@Test
	def void testCtlOperator() {
		assertFormulaEquals(ctlFac.createAllGlobally => [
			formula = propFac.createTrue	
		], "AG true")
		
		assertFormulaEquals(ctlFac.createAllFinally => [
			formula = propFac.createTrue	
		], "AF true")
		
		assertFormulaEquals(ctlFac.createAllNext => [
			formula = propFac.createTrue	
		], "AX true")
		
		assertFormulaEquals(ctlFac.createExistsGlobally => [
			formula = propFac.createTrue	
		], "EG true")
		
		assertFormulaEquals(ctlFac.createExistsFinally => [
			formula = propFac.createTrue	
		], "EF true")
		
		assertFormulaEquals(ctlFac.createExistsNext => [
			formula = propFac.createTrue	
		], "EX true")
	}
	
	@Test
	def void testCreateUse1() {
		// Branch with use required after create
		assertFormulaEquals(ctlFac.createAllGlobally => [
			formula = propFac.createImplication => [
				left = propXtextFac.createRuleVariableUse => [
					variable = "create"
				]
				right = ctlFac.createExistsFinally => [
					formula = propXtextFac.createRuleVariableUse => [
						variable = "use"
					]
				]
			]
		], "AG(create -> EF(use))")		
	}
	
	@Test
	def void testCreateUse3() {
		// First create then use
		assertFormulaEquals(ctlFac.createAllUntil => [
			left = propFac.createNot => [
				formula = propXtextFac.createRuleVariableUse => [
					variable = "use"
				]
			]
			right = propFac.createOr => [
				left = propXtextFac.createRuleVariableUse => [
					variable = "create"
				]
				right = propFac.createNot => [					
					formula = ctlFac.createExistsFinally => [
						formula = propXtextFac.createRuleVariableUse => [
							variable = "use"
						]
					]
				]
			]
		], "A[!use U create | !EF(use)]")
	}
	
	def private assertFormulaEquals(Formula expectedFormula, String actualFormula) {
		val parseResult = ctlParser.doParse(actualFormula)
		val formula = parseResult.rootASTElement as Formula
		Assert.assertTrue("Parsed and expected formula doesn't match", EcoreUtil.equals(expectedFormula, formula))
	}
}