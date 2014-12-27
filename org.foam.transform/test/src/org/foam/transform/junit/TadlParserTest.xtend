package org.foam.transform.junit

import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.ctl.CtlFactory
import org.foam.ltl.LtlFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.junit.Assert
import org.junit.Test

import static org.junit.Assert.*

class TadlParserTest {
	
	val tadllang2tadl = new TadlLang2Tadl
	
	val propFac = PropositionallogicFactory.eINSTANCE
	val ltlFac = LtlFactory.eINSTANCE
	val ctlFac = CtlFactory.eINSTANCE
	
	@Test def void parseOpenClose() {
		// note: serves only for test purposes. Open-close TADL definition
		// contains two more formulas
		val openClose =	'''
		## after open close is required
		LTL G(open -> F(close))
		## no multi-open
		## is allowed
		CTL AG(open -> AX(A[!open U close]))
		'''
		
		val varDefOpen = propFac.createVariableDefinition => [name = "open"]
		val varDefClose = propFac.createVariableDefinition => [name = "close"]
		val template = tadllang2tadl.parse(openClose)
		
		// check variable definitions
		Assert.assertTrue("Definition list differs from expected", 
			EcoreUtil.equals(newArrayList(varDefOpen, varDefClose), template.variableDefinitions)
		)
		
		// check formulas
		assertEquals("Actual number of formulas is different from expected", 2, template.formulaHolders.size)		
		
		// check formula comments
		assertEquals("after open close is required", template.formulaHolders.get(0).comment)
		assertEquals("no multi-open is allowed", template.formulaHolders.get(1).comment)
		
		val expectedLtlFormula = ltlFac.createGlobally => [
			formula = propFac.createImplication => [
				left = propFac.createVariableUse => [
					variableDefinition = varDefOpen
				]
				right = ltlFac.createFuture => [
					formula = propFac.createVariableUse => [
						variableDefinition = varDefClose
					]
				]
			]
		]
		val actualLtlFormula = template.formulaHolders.get(0).formula
		Assert.assertTrue("expected and actual LTL formula doesn't match", 
			EcoreUtil.equals(expectedLtlFormula, actualLtlFormula)
		)
		
		val expectedCtlFormula = ctlFac.createAllGlobally => [
			formula = propFac.createImplication => [
				left = propFac.createVariableUse => [
					variableDefinition = varDefOpen
				]
				right = ctlFac.createAllNext => [
					formula = ctlFac.createAllUntil => [
						left = propFac.createNot => [
							formula = propFac.createVariableUse => [
								variableDefinition = varDefOpen
							]
						]
						right = propFac.createVariableUse => [
							variableDefinition = varDefClose
						]
					]
				]
			]
		]
		val actualCtlFormula = template.formulaHolders.get(1).formula
		Assert.assertTrue("expected and actual CTL formula doesn't match", 
			EcoreUtil.equals(expectedCtlFormula, actualCtlFormula)
		)
	}
	
}