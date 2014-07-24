package org.foam.transform.tadl

import org.foam.ctl.CtlFactory
import org.foam.ltl.LtlFactory
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.FormulaType
import org.foam.tadl.TadlFactory
import org.foam.transform.tadllang2tadl.TadlLang2Tadl
import org.foam.transform.utils.modeling.EmfCommons
import org.junit.Assert
import org.junit.Test

// TODO: refactor the CTL/LTL builder methods into a separate extension class and reuse it in multiple test suits
class TadlTest {
	
	private extension TadlFactory = TadlFactory.eINSTANCE
	private extension CtlFactory = CtlFactory.eINSTANCE
	private extension LtlFactory = LtlFactory.eINSTANCE
	private extension PropositionallogicFactory = PropositionallogicFactory.eINSTANCE

	val varMap = <String, VariableDefinition> newHashMap

	private def VAR(String varName) {
		createVariableUse => [
			variableDefinition = VDEF(varName)
		]
	}
	
	private def VDEF(String varName) {
		val varDef = varMap.get(varName)
		if (varDef == null) {
			val newVarDef = createVariableDefinition => [name = varName]
			varMap.put(varName, varDef)
			return newVarDef
		}
		return varDef
	}
		
	private def CTL(String fcomment, Formula f) {
		createFormulaHolder => [
			comment = fcomment
			formulaType = FormulaType.CTL
			formula = f
		]
	}

	private def LTL(String fcomment, Formula f) {
		createFormulaHolder => [
			comment = fcomment
			formulaType = FormulaType.LTL
			formula = f
		]
	}

	private def AF(Formula f) {createAllFinally => [formula = f]}
	private def EF(Formula f) {createExistsFinally => [formula = f]}
	private def AG(Formula f) {createAllGlobally => [formula = f]}
	private def AX(Formula f) {createAllNext => [formula = f]}
	private def ! (Formula f) {createNot => [formula = f]}
	private def -> (Formula leftf, Formula rightf) {createImplication => [left = leftf; right = rightf]}
	private def G(Formula f) {createGlobally => [formula = f]}
	private def O(Formula f) {createOnce => [formula = f]}
	private def A(Formula leftf, Formula rightf) {createAllUntil => [left = leftf; right = rightf]}
	private def E(Formula leftf, Formula rightf) {createExistsUntil => [left = leftf; right = rightf]}
	private def &&(Formula leftf, Formula rightf) {createAnd => [left = leftf; right = rightf]}
	
	@Test def void testParseCreateUse() {
		
		val expectedTadlTemplate = createTemplate => [
			formulaHolders += CTL('at least one branch with use required after create',
				AG(VAR('create') -> EF(VAR('use')))
			)
			formulaHolders += CTL('only one create',
				AG( VAR('create') -> AX(AG( ! VAR('create'))))
			)
			formulaHolders += LTL('if there is "use" there must have been a "create" before',
				G(VAR('use') -> O(VAR('create')))
			)
			variableDefinitions += #[VDEF('create'), VDEF('use')]
		]

		val parser = new TadlLang2Tadl
		val actualTadlTemplate = parser.parse('''
		## at least one branch with use required after create
		CTL AG(create -> EF(use))
		
		## only one create
		CTL AG(create -> AX(AG(!create)))
		
		## if there is "use" there must have been a "create" before
		LTL G(use -> O(create))
		''')

		Assert.assertEquals(
			EmfCommons.asXmiString(expectedTadlTemplate),
			EmfCommons.asXmiString(actualTadlTemplate)
		)
	}

	@Test def void testParseOpenClose() {
		
		val expectedTadlTemplate = createTemplate => [
			formulaHolders += CTL('after open close is required',
				AG(VAR('open') -> AF(VAR('close')))
			)
			formulaHolders += CTL('no multi-open',
				AG(VAR('open') -> AX(A(!VAR('open'), VAR('close'))))
			)
			formulaHolders += CTL('no multi-close',
				AG(VAR('close') -> AX(!E(!VAR('open'), (VAR('close') && !VAR('open')))))
			)
			formulaHolders += LTL('if there is "close" there must have been a "open" before',
				G(VAR('close') -> O(VAR('open')))
			)
			variableDefinitions += #[VDEF('open'), VDEF('close')]
		]

		val parser = new TadlLang2Tadl
		val actualTadlTemplate = parser.parse('''
		## after open close is required
		CTL AG(open -> AF(close))
		
		## no multi-open
		CTL AG(open -> AX(A[!open U close]))
		
		## no multi-close
		CTL AG(close -> AX(!E[!open U (close & !open)]))
		
		## if there is "close" there must have been a "open" before
		LTL G(close -> O(open))
		''')

		Assert.assertEquals(
			EmfCommons.asXmiString(expectedTadlTemplate),
			EmfCommons.asXmiString(actualTadlTemplate)
		)
	}

}
