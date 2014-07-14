package org.foam.transform.lts2nusmvlang

import java.util.Map
import org.foam.ctl.AllFinally
import org.foam.ctl.AllGlobally
import org.foam.ctl.AllNext
import org.foam.ctl.AllUntil
import org.foam.ctl.ExistsFinally
import org.foam.ctl.ExistsGlobally
import org.foam.ctl.ExistsNext
import org.foam.ctl.ExistsUntil
import org.foam.ltl.Future
import org.foam.ltl.Globally
import org.foam.ltl.Historically
import org.foam.ltl.Next
import org.foam.ltl.Once
import org.foam.ltl.Releases
import org.foam.ltl.Since
import org.foam.ltl.Triggered
import org.foam.ltl.Until
import org.foam.propositionallogic.And
import org.foam.propositionallogic.Equivalence
import org.foam.propositionallogic.False
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.Implication
import org.foam.propositionallogic.Not
import org.foam.propositionallogic.Or
import org.foam.propositionallogic.True
import org.foam.propositionallogic.VariableUse

// TODO:
// TADL formulae must be properly translated to NuSMV formulae.
// Make sure, the semantics of operators X,G,U is equivalent for UCM and LTS
// We will use the special "jmp" variable that is TRUE when the current state has type=JMP
// There is always an exactly one JMP state for each use-case step

class NusmvFormulaRenderer {
	
	val Map<String, String> varNameMapping
	
	new(Map<String, String> varNameMapping) {
		this.varNameMapping = varNameMapping
	}
	
	new() {
		this.varNameMapping = new DummyMap
	}
	
	def dispatch String evalFormula(Formula f)'''?«f.toString»'''
	def dispatch String evalFormula(Not f)'''!«f.formula.evalFormula»'''
	def dispatch String evalFormula(VariableUse f)'''«varNameMapping.get(f.variableDefinition.name)»'''
	def dispatch String evalFormula(And f)'''(«f.left.evalFormula» & «f.right.evalFormula»)'''
	def dispatch String evalFormula(Or f)'''(«f.left.evalFormula» | «f.right.evalFormula»)'''
	def dispatch String evalFormula(Implication f)'''(«f.left.evalFormula» -> «f.right.evalFormula»)'''
	def dispatch String evalFormula(Equivalence f)'''(«f.left.evalFormula» <-> «f.right.evalFormula»)'''
	def dispatch String evalFormula(False f)'''FALSE'''
	def dispatch String evalFormula(True f)'''TRUE'''
	
	def dispatch String evalFormula(Next f)'''[!jmp U (jmp & X «f.formula.evalFormula»)]'''
	def dispatch String evalFormula(Globally f)'''G(jmp -> «f.formula.evalFormula»)'''
	def dispatch String evalFormula(Future f)'''F «f.formula.evalFormula»'''
	def dispatch String evalFormula(Historically f)'''H(jmp -> «f.formula.evalFormula»)'''
	def dispatch String evalFormula(Once f)'''O «f.formula.evalFormula»'''
	def dispatch String evalFormula(Until f)'''((jmp -> «f.left.evalFormula») U «f.right.evalFormula»)'''
	def dispatch String evalFormula(Since f)'''((jmp -> «f.left.evalFormula») S «f.right.evalFormula»)'''
	def dispatch String evalFormula(Triggered f)'''(«f.left.evalFormula» T (jmp -> «f.right.evalFormula»))'''

	// Note: the "Releases" operator in NuSMV is identified by letter "V" rather than "R"
	def dispatch String evalFormula(Releases f)'''(«f.left.evalFormula» V (jmp -> «f.right.evalFormula»))'''
	
	def dispatch String evalFormula(ExistsGlobally f)'''EG(jmp -> «f.formula.evalFormula»)'''
	def dispatch String evalFormula(ExistsFinally f)'''EF «f.formula.evalFormula»'''
	def dispatch String evalFormula(ExistsNext f)'''EX E[ !jmp U (jmp & «f.formula.evalFormula») ]'''
	def dispatch String evalFormula(AllGlobally f)'''AG(jmp -> «f.formula.evalFormula»)'''
	def dispatch String evalFormula(AllFinally f)'''AF «f.formula.evalFormula»'''
	def dispatch String evalFormula(AllNext f)'''AX A[ !jmp U (jmp & «f.formula.evalFormula») ]'''
	def dispatch String evalFormula(AllUntil f)'''A[(jmp -> «f.left.evalFormula») U «f.right.evalFormula»]'''
	def dispatch String evalFormula(ExistsUntil f)'''E[(jmp -> «f.left.evalFormula») U «f.right.evalFormula»]'''

}