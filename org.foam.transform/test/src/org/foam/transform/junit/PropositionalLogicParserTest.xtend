package org.foam.transform.junit

import org.eclipse.emf.ecore.EPackage
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.transform.junit.utils.PropositionalLogicFormulaChecker
import org.foam.xtext.plogic.PropositionalLogicXtextStandaloneSetup
import org.foam.xtext.plogic.parser.antlr.PropositionalLogicXtextParser
import org.foam.xtext.plogic.propositionalLogicXtext.PropositionalLogicXtextFactory
import org.junit.Test

class PropositionalLogicParserTest {

	private extension PropositionalLogicFormulaChecker = new PropositionalLogicFormulaChecker
	
	val propFac = PropositionallogicFactory.eINSTANCE
	val propXtextFac = PropositionalLogicXtextFactory.eINSTANCE
	
	private PropositionalLogicXtextParser propositionalLogicParser
	new() {
		
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl or LTL formula (propositional logic formula is parsed
		// without errors).
		if (!EPackage.Registry.INSTANCE.containsKey(PropositionallogicPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(PropositionallogicPackage.eNS_URI, PropositionallogicPackage.eINSTANCE)
		}

		// TODO - use guice annotations to inject parser instead ?
		val propositionalLogicInjector = new PropositionalLogicXtextStandaloneSetup().createInjectorAndDoEMFRegistration
		propositionalLogicParser = propositionalLogicInjector.getInstance(PropositionalLogicXtextParser)
	}
	
	@Test def void parseNotAndPrecedence() {
		assertFormulaEquals(propFac.createAnd => [
			left = propFac.createNot => [
				formula = propXtextFac.createRuleVariableUse => [
					variable = "emit2"
				]
			]			
			right = propXtextFac.createRuleVariableUse => [
				variable = "consume2"
			]  
		], "!emit2 & consume2")
	}

	def private assertFormulaEquals(Formula expectedFormula, String actualFormula) {
		val parseResult = propositionalLogicParser.doParse(actualFormula)
		val formula = parseResult.rootASTElement as Formula
		check(expectedFormula, formula)
	}
}