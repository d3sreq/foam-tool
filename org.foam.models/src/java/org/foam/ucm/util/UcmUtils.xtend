package org.foam.ucm.util

import org.foam.annotation.Annotation
import com.google.common.base.Preconditions
import org.foam.flowannotation.Include
import java.util.Collections
import java.util.HashSet
import java.util.Set
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step
import org.foam.ucm.UseCase

class MyTest {
	
}
class UcmUtils {
	
	def static Iterable<Annotation> getStepAnnotations(UseCase useCase) {
		val holders = useCase.branches.values
		val extScenarioLists = holders.map[it.extensions]
		val varScenarioLists = holders.map[it.variations]
		val allScenarios = (extScenarioLists + varScenarioLists).flatten + Collections::singletonList(useCase.mainScenario)
		allScenarios.map[getStepAnnotations(it)].flatten
	}
	
	def static Iterable<Annotation> getStepAnnotations(Scenario scenario) {
		scenario.steps.map[it.annotations].flatten
	}
	
	def static Iterable<Step> allSteps(UseCase useCase) {
		allScenarios(useCase).map[it.steps].flatten
	}
	
	def static Iterable<Scenario> allScenarios(UseCase useCase) {
		return Collections::singletonList(useCase.mainScenario) 
			+ useCase.branches.values.map[it.branches.map[value as Scenario]].flatten
	}
	
	def static Set<UseCase> getPreceededTransitively(UseCase useCase) {
		Preconditions::checkNotNull(useCase)
		
		val result = new HashSet<UseCase>
		getPreceededRecursively(useCase, result)
		result
	}
	
	def private static void getPreceededRecursively(UseCase useCase, Set<UseCase> result) {
		for (preceededUseCase : useCase.preceeded) {
			if (!result.contains(preceededUseCase)) {
				result += preceededUseCase
				getPreceededRecursively(preceededUseCase, result)
			}
		}
	}
	
	def static Set<UseCase> getIncluded(UseCase useCase) {
		allSteps(useCase).map[
			annotations.filter(typeof(Include)).map[inlinedUseCase]
		].flatten.toSet
	}
	
	def static Set<UseCase> getIncludedTransitively(UseCase useCase) {
		Preconditions::checkNotNull(useCase)
		
		val result = new HashSet<UseCase>
		getIncludedUseCasesRecursively(useCase, result)
		result
	}
	
	def private static void getIncludedUseCasesRecursively(UseCase useCase, Set<UseCase> result) {
		val includedUseCases = getIncluded(useCase)
		
		for (includedUseCase  : includedUseCases) {
			if (!result.contains(includedUseCase)) {
				result += includedUseCase				
				getIncludedUseCasesRecursively(includedUseCase, result)
			}
		}
	}
	
	def static UseCase getUseCase(Step step) {
		Preconditions::checkNotNull(step)
		val scenario = step.eContainer as Scenario
		getUseCase(scenario)
	}
	
	def static UseCase getUseCase(Scenario scenario) {
		Preconditions::checkNotNull(scenario)
		val scenarioParent = scenario.eContainer()
		return switch scenarioParent {
			ScenarioHolder: {
				val entry = scenarioParent.eContainer
				entry.eContainer as UseCase
			}
			default:
				scenarioParent as UseCase
		}
	}
	
	def static Scenario getScenario(Step step) {
		Preconditions::checkNotNull(step)
		step.eContainer as Scenario
	}
}