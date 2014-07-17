package org.foam.cli.tools.report.utils

import com.google.common.base.Preconditions
import org.foam.cntex.Specification
import org.foam.traceability.FormulaIdentificationAnnotation

//TODO:refactoring needed
class Utils {
	
	def static getGroup(Specification specification) {
		val annot = specification.annotations.filter(FormulaIdentificationAnnotation)
		Preconditions.checkArgument(annot.size == 1)
		annot.head.group
	}
	
	
	
}