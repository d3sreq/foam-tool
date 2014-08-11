package org.foam.ucm.impl

import java.util.Map
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step

class ScenarioImplCustom extends ScenarioImpl {
	
	override String getLabel() {
		val scenarioParent = this.eContainer
		switch scenarioParent {
			ScenarioHolder: {
				val scenarios = scenarioParent.branches.map[it.value]
				val letter = getLetter(scenarios.indexOf(scenario))
				val step = (scenarioParent.eContainer as Map.Entry<Step,ScenarioHolder>).key
				return '''«step.label»«letter»'''
				
			}
			default: return ""
		} 
	}
	
	override String getText() {
		// overridden becouse main scenario has no "text" associated but
		// EMF constraint is defined so that "text" shouldn't be null.
		EObject scenarioParent = this.eContainer
		if (scenarioParent instanceof ScenarioHolder) {
			return super.text
		} else {
			return ""
		}
	}
	
	def private getLetter(int index) {
		Character.valueOf(('a'.charAt(0) + index) as char).toString
	}
}