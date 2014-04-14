package transformation.lts2nusmvlang

import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.emf.ecore.EClass
import org.foam.ctl.AllFinally
import org.foam.ctl.AllGlobally
import org.foam.ctl.AllNext
import org.foam.ctl.AllUntil
import org.foam.ctl.CtlPackage
import org.foam.ctl.ExistsFinally
import org.foam.ctl.ExistsGlobally
import org.foam.ctl.ExistsNext
import org.foam.ctl.ExistsUntil
import org.foam.ltl.Future
import org.foam.ltl.Globally
import org.foam.ltl.Historically
import org.foam.ltl.LtlPackage
import org.foam.ltl.Next
import org.foam.ltl.Once
import org.foam.ltl.Releases
import org.foam.ltl.Since
import org.foam.ltl.Triggered
import org.foam.ltl.Until
import org.foam.propositionallogic.And
import org.foam.propositionallogic.BinaryFormula
import org.foam.propositionallogic.Equivalence
import org.foam.propositionallogic.False
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.Implication
import org.foam.propositionallogic.Not
import org.foam.propositionallogic.Or
import org.foam.propositionallogic.True
import org.foam.propositionallogic.UnaryFormula
import org.foam.propositionallogic.VariableUse

class TADLFormulaRenderer {
	
	val Map<String, String> varNameMapping
	
	new(Map<String, String> varNameMapping) {
		this.varNameMapping = varNameMapping
	}
	
	new() {
		this.varNameMapping = new DummyMap
	}
	
	def collectTemporalOperatorDescriptions(Iterable<Formula> list) {
		val collected = new HashSet<EClass>
		list.forEach[it.collect(collected)]
		collected.map[operator2Description.get(it)].filterNull
	}
	
	def dispatch void collect(UnaryFormula f, Set<EClass> collected) {
		collected.add(f.eClass)
		f.formula.collect(collected)
	}
	
	def dispatch void collect(BinaryFormula f, Set<EClass> collected) {
		collected.add(f.eClass)
		f.left.collect(collected)
		f.right.collect(collected)
	}
	
	def dispatch void collect(Formula f, Set<EClass> collected) {
		// fallback - do nothing
	}
	
	val operator2Description = newHashMap(
		//LTL Operators
		LtlPackage.Literals::NEXT			-> "LTL: X(f) = 'Next', i.e. f holds in the next use-case step.",
		LtlPackage.Literals::GLOBALLY 		-> "LTL: G(f) = 'Globally', i.e. f holds in all steps.",
		LtlPackage.Literals::FUTURE			-> "LTL: F(f) = 'Future', i.e. there is a step in future where f holds.",
		LtlPackage.Literals::UNTIL 			-> "LTL: [f U g] = 'Until', i.e. at some point g holds while in the meantime f holds.",
		LtlPackage.Literals::RELEASES		-> "LTL: [f R g] = 'Release', is equivalent to ![ !f U !g ]",
	
		//PLTL Operators
		LtlPackage.Literals::HISTORICALLY	-> "PLTL: H(f) = 'Historically', i.e. f holds in all previous steps in the past.",
		LtlPackage.Literals::ONCE 			-> "PLTL: O(f) = 'Once', i.e. f held in at least one step in the past (past also includes current step).",
		LtlPackage.Literals::SINCE 			-> "PLTL: [f S g] = 'Since', i.e. f held in some step in the past (past also includes current step) and q holds in all following steps.",
		LtlPackage.Literals::TRIGGERED		-> "PLTL: [f T g] = 'Triggered', i.e. f held in past (past also includes current step) and q holds in all following steps. If f has never been true, then g must hold in all steps from beginning up to current step (included).",

		//CTL Operators
		CtlPackage.Literals::EXISTS_GLOBALLY	-> "CTL: EG(f) = 'Exists globally', i.e. exists (infinite) path starting with current step such that f holds in all it's steps.",
		CtlPackage.Literals::EXISTS_FINALLY		-> "CTL: EF(f) = 'Exists finally', i.e. exists path starting with current step containing step where f holds.", 
		CtlPackage.Literals::EXISTS_NEXT		-> "CTL: EX(f) = 'Exists next', i.e. f holds in one of the following steps.", 
		CtlPackage.Literals::ALL_GLOBALLY		-> "CTL: AG(f) = 'All globally', i.e. holds on all paths in all steps.", 
		CtlPackage.Literals::ALL_FINALLY		-> "CTL: AF(f) = 'All finally', i.e. in all paths starting with current step exists a step where f holds.", 
		CtlPackage.Literals::ALL_NEXT			-> "CTL: AX(f) = 'All next', i.e. f holds in all following steps.", 
		CtlPackage.Literals::ALL_UNTIL			-> "CTL: A[f U g] = 'All Until', i.e. on all paths at some point g holds while in the meantime f holds.",
		CtlPackage.Literals::EXISTS_UNTIL		-> "CTL: E[f U g] = 'Exists Until', i.e. exists path where at some point g holds while in the meantime f holds."
	)
	
	def dispatch String evalFormula(Formula f)'''?«f.toString»'''
	def dispatch String evalFormula(Not f)'''!«f.formula.evalFormula»'''
	def dispatch String evalFormula(VariableUse f)'''«varNameMapping.get(f.variableDefinition.name)»'''
	def dispatch String evalFormula(And f)'''(«f.left.evalFormula» & «f.right.evalFormula»)'''
	def dispatch String evalFormula(Or f)'''(«f.left.evalFormula» | «f.right.evalFormula»)'''
	def dispatch String evalFormula(Implication f)'''(«f.left.evalFormula» -> «f.right.evalFormula»)'''
	def dispatch String evalFormula(Equivalence f)'''(«f.left.evalFormula» <-> «f.right.evalFormula»)'''
	def dispatch String evalFormula(False f)'''FALSE'''
	def dispatch String evalFormula(True f)'''TRUE'''
	
	// LTL operators
	def dispatch String evalFormula(Next f)'''X «f.formula.evalFormula»'''
	def dispatch String evalFormula(Globally f)'''G «f.formula.evalFormula»'''
	def dispatch String evalFormula(Future f)'''F «f.formula.evalFormula»'''
	def dispatch String evalFormula(Until f)'''(«f.left.evalFormula» U «f.right.evalFormula»)'''
	def dispatch String evalFormula(Releases f)'''(«f.left.evalFormula» R «f.right.evalFormula»)'''

	// PLTL operators
	def dispatch String evalFormula(Historically f)'''H «f.formula.evalFormula»'''
	def dispatch String evalFormula(Once f)'''O «f.formula.evalFormula»'''
	def dispatch String evalFormula(Since f)'''(«f.left.evalFormula» S «f.right.evalFormula»)'''
	def dispatch String evalFormula(Triggered f)'''(«f.left.evalFormula» T «f.right.evalFormula»)'''
	
	// CTL operators
	def dispatch String evalFormula(ExistsGlobally f)'''EG «f.formula.evalFormula»'''
	def dispatch String evalFormula(ExistsFinally f)'''EF «f.formula.evalFormula»'''
	def dispatch String evalFormula(ExistsNext f)'''EX «f.formula.evalFormula»'''
	def dispatch String evalFormula(AllGlobally f)'''AG «f.formula.evalFormula»'''
	def dispatch String evalFormula(AllFinally f)'''AF «f.formula.evalFormula»'''
	def dispatch String evalFormula(AllNext f)'''AX «f.formula.evalFormula»'''
	def dispatch String evalFormula(AllUntil f)'''A[«f.left.evalFormula» U «f.right.evalFormula»]'''
	def dispatch String evalFormula(ExistsUntil f)'''E[«f.left.evalFormula» U «f.right.evalFormula»]'''
}