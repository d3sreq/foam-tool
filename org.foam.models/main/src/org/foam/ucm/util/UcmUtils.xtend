package org.foam.ucm.util

import java.util.Set
import org.foam.flowannotation.Include
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step
import org.foam.ucm.UseCase
import com.google.common.base.Preconditions

class UcmUtils {
	
	def static getStepAnnotations(UseCase useCase) {
		val holders = useCase.branches.values
		val extScenarioLists = holders.map[extensions]
		val varScenarioLists = holders.map[variations]
		val allScenarios = #[useCase.mainScenario] + (extScenarioLists + varScenarioLists).flatten
		allScenarios.map[getStepAnnotations].flatten
	}
	
	def static getStepAnnotations(Scenario scenario) {
		scenario.steps.map[annotations].flatten
	}
	
	def static allSteps(UseCase useCase) {
		useCase.allScenarios.map[steps].flatten
	}
	
	def static allScenarios(UseCase useCase) {
		#[useCase.mainScenario]
		+ useCase.branches.values.map[branches.map[value as Scenario]].flatten
	}
	
	def static Set<UseCase> getPreceededTransitively(UseCase useCase) {
		Preconditions.checkNotNull(useCase)
		
		val result = <UseCase> newHashSet
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
	
	def static getIncluded(UseCase useCase) {
		useCase.allSteps.map[
			annotations.filter(Include).map[inlinedUseCase]
		].flatten.toSet
	}
	
	def static getIncludedTransitively(UseCase useCase) {
		Preconditions.checkNotNull(useCase)
		
		val result = <UseCase> newHashSet
		getIncludedUseCasesRecursively(useCase, result)
		result
	}
	
	def private static void getIncludedUseCasesRecursively(UseCase useCase, Set<UseCase> result) {
		for (includedUseCase  : useCase.getIncluded) {
			if (!result.contains(includedUseCase)) {
				result += includedUseCase				
				getIncludedUseCasesRecursively(includedUseCase, result)
			}
		}
	}
	
	def static UseCase getUseCase(Step step) {
		Preconditions.checkNotNull(step)
		(step.eContainer as Scenario).getUseCase
	}
	
	def static UseCase getUseCase(Scenario scenario) {
		Preconditions.checkNotNull(scenario)
		val scenarioParent = scenario.eContainer
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
		Preconditions.checkNotNull(step)
		step.eContainer as Scenario
	}
}