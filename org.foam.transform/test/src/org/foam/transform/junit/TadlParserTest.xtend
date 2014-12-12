package org.foam.transform.junit

import java.util.List
import org.foam.ctl.CtlFactory
import org.foam.ltl.LtlFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.transform.junit.utils.PropositionalLogicFormulaChecker
import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.junit.Test

import static org.junit.Assert.*

class TadlParserTest {
	
	private extension PropositionalLogicFormulaChecker = new PropositionalLogicFormulaChecker
	
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
		assertVariableDefinitionsEquals(newArrayList(varDefOpen, varDefClose), template.variableDefinitions)
		
		// check formulas
		assertEquals("Actual number of formulas is different from expected", 2, template.formulaHolders.size)		
		
		// check formula comments
		assertEquals("after open close is required", template.formulaHolders.get(0).comment)
		assertEquals("no multi-open is allowed", template.formulaHolders.get(1).comment)
		
		check(ltlFac.createGlobally => [
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
		], template.formulaHolders.get(0).formula)
		
		check(ctlFac.createAllGlobally => [
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
		], template.formulaHolders.get(1).formula)
	}

	def assertVariableDefinitionsEquals(List<VariableDefinition> expected, List<VariableDefinition> actual) {
		assertEquals("Actual number of variable definitions is different from expected.", expected.size, actual.size)
		for (i : (0 .. expected.size - 1)) {
			assertEquals(expected.get(i).name, actual.get(i).name)
		}
	}
	
}