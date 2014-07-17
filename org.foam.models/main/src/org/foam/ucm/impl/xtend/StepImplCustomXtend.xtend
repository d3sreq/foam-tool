package org.foam.ucm.impl.xtend

import org.foam.ucm.Scenario
import org.foam.ucm.Step

class StepImplCustomXtend {
	
	def static getLabel(Step step) {
		val parent = step.eContainer as Scenario 
		val num = parent.steps.indexOf(step) + 1
		parent.label + num
	}
	
}