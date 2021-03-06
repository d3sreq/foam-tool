package org.foam.transform.cntexlang2cntex

import org.foam.cntex.CounterExample
import org.foam.cntex.Specification
import org.foam.tadl.FormulaHolder
import org.foam.tadl.FormulaType
import org.foam.tadl.Group
import org.foam.traceability.FormulaIdentificationAnnotation
import org.foam.traceability.TraceabilityFactory

/**
 * Adds {@link FormulaIdentificationAnnotation} to {@link Specification}s
 */
class SpecificationResolver {
	
	val fac = TraceabilityFactory.eINSTANCE
	
	//TODO: make it a pure function
	def void transform(CounterExample counterExample, Iterable<Pair<FormulaHolder, Group>> holderGroupList) {
		// need to reorder formulas in formulaHolders list because CTL formulas are in counter-example
		// before all LTL formulas. Preserve formula order among CTL/LTL !
		val ctlFormulas = holderGroupList.filter[it.key.formulaType == FormulaType.CTL]
		val ltlFormulas = holderGroupList.filter[it.key.formulaType == FormulaType.LTL]
		val reorderedFormulaHolders = (ctlFormulas + ltlFormulas).toList.unmodifiableView
		
		counterExample.specifications.forEach[spec, i |
			spec.annotations += fac.createFormulaIdentificationAnnotation => [
				val pair = reorderedFormulaHolders.get(i)
				formulaHolder = pair.key
				group = pair.value
			]
		]
	}
}