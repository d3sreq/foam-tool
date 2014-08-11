package org.foam.ucm.impl

import org.foam.ucm.Scenario
import org.foam.ucm.impl.StepImpl

class StepImplCustom extends StepImpl {
	
	override getLabel() {
		val parent = this.eContainer as Scenario 
		val num = parent.steps.indexOf(this) + 1
		parent.label + num
	}
	
}