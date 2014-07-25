package org.foam.transform.tadl

import org.foam.ctl.CtlFactory
import org.foam.ltl.LtlFactory
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.tadl.FormulaHolder
import org.foam.tadl.FormulaType
import org.foam.tadl.TadlFactory

class TadlFormulaBuilderExtension {

	private extension TadlFactory = TadlFactory.eINSTANCE
	private extension CtlFactory = CtlFactory.eINSTANCE
	private extension LtlFactory = LtlFactory.eINSTANCE
	private extension PropositionallogicFactory = PropositionallogicFactory.eINSTANCE

	def TADL(FormulaHolder... fh) {
		val t = createTemplate
		t.formulaHolders += fh
		return t
	}

	def VAR(String varName) {
		createVariableUse => [
			variableDefinition = VDEF(varName)
		]
	}
		
	def VDEF(String varName) {
		createVariableDefinition => [name = varName]
	}

	def CTL(String fcomment, Formula f) {
		createFormulaHolder => [
			comment = fcomment
			formulaType = FormulaType.CTL
			formula = f
		]
	}

	def LTL(String fcomment, Formula f) {
		createFormulaHolder => [
			comment = fcomment
			formulaType = FormulaType.LTL
			formula = f
		]
	}

	// CTL
	def AF(Formula f) {createAllFinally => [formula = f]}
	def EF(Formula f) {createExistsFinally => [formula = f]}
	def AG(Formula f) {createAllGlobally => [formula = f]}
	def EG(Formula f) {createExistsGlobally => [formula = f]}
	def AX(Formula f) {createAllNext => [formula = f]}
	def EX(Formula f) {createExistsNext => [formula = f]}
	def A(Formula leftf, Formula rightf) {createAllUntil => [left = leftf; right = rightf]}
	def E(Formula leftf, Formula rightf) {createExistsUntil => [left = leftf; right = rightf]}
	
	// LTL
	def G(Formula f) {createGlobally => [formula = f]}
	def O(Formula f) {createOnce => [formula = f]}
	def F(Formula f) {createFuture => [formula = f]}

	// PROPOSITIONAL LOGIC
	def ! (Formula f) {createNot => [formula = f]}
	def &&(Formula leftf, Formula rightf) {createAnd => [left = leftf; right = rightf]}
	def ||(Formula leftf, Formula rightf) {createOr => [left = leftf; right = rightf]}
	def => (Formula leftf, Formula rightf) {createImplication => [left = leftf; right = rightf]}
	def <=>(Formula leftf, Formula rightf) {createEquivalence => [left = leftf; right = rightf]}

}