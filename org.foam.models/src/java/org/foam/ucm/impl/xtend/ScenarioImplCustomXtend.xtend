package org.foam.ucm.impl.xtend

import java.util.Map
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step

class ScenarioImplCustomXtend {
	
	def static String getLabel(Scenario scenario) {
		val scenarioParent = scenario.eContainer()
		switch scenarioParent {
			ScenarioHolder: {
				val scenarios = scenarioParent.branches.map[it.value]
				val letter = getLetter(scenarios.indexOf(scenario))
				val step = (scenarioParent.eContainer as Map.Entry<Step,ScenarioHolder>).key
				return '''«step.label»«letter»'''
				
			}
			default: ""
		} 
	}
	
	def private static getLetter(int index) {
		Character::valueOf(('a'.charAt(0) + index) as char).toString
	}
}