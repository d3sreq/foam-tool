package org.foam.cntex.util

import com.google.common.base.Preconditions
import org.foam.cntex.Specification
import org.foam.traceability.FormulaIdentificationAnnotation

class CntexModelExtensions {
	def static getGroup(Specification specification) {
		val annot = specification.annotations.filter(FormulaIdentificationAnnotation)
		Preconditions.checkArgument(annot.size == 1)
		annot.head.group
	}
}
