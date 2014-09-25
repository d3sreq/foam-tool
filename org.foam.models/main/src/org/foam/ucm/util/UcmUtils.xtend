package org.foam.ucm.util

import com.google.common.base.Preconditions
import java.util.Set
import org.foam.flowannotation.Include
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step
import org.foam.ucm.UseCase

// TODO: rename to UcmUtilExtension
class UcmUtils {
	
	@Pure def static getStepAnnotations(UseCase useCase) {
		val holders = useCase.branches.values
		val extScenarioLists = holders.map[extensions]
		val varScenarioLists = holders.map[variations]
		val allScenarios = #[useCase.mainScenario] + (extScenarioLists + varScenarioLists).flatten
		allScenarios.map[getStepAnnotations].flatten
	}
	
	@Pure def static getStepAnnotations(Scenario scenario) {
		scenario.steps.map[annotations].flatten
	}
	
	@Pure def static allSteps(UseCase useCase) {
		useCase.allScenarios.map[steps].flatten
	}
	
	@Pure def static allScenarios(UseCase useCase) {
		#[useCase.mainScenario]
		+ useCase.branches.values.map[branches.map[value as Scenario]].flatten
	}
	
	@Pure def static Set<UseCase> getPreceededTransitively(UseCase useCase) {
		Preconditions.checkNotNull(useCase)
		
		val result = <UseCase> newHashSet
		getPreceededRecursively(useCase, result)
		result
	}
	
	// TODO: try to make this function pure
	def private static void getPreceededRecursively(UseCase useCase, Set<UseCase> result) {
		for (preceededUseCase : useCase.preceeded) {
			if (!result.contains(preceededUseCase)) {
				result += preceededUseCase
				getPreceededRecursively(preceededUseCase, result)
			}
		}
	}
	
	@Pure def static getIncluded(UseCase useCase) {
		useCase.allSteps.map[
			annotations.filter(Include).map[inlinedUseCase]
		].flatten.toSet
	}
	
	@Pure def static getIncludedTransitively(UseCase useCase) {
		Preconditions.checkNotNull(useCase)
		
		val result = <UseCase> newHashSet
		getIncludedUseCasesRecursively(useCase, result)
		return result
	}
	
	// TODO: try to make this function pure
	def private static void getIncludedUseCasesRecursively(UseCase useCase, Set<UseCase> result) {
		for (includedUseCase  : useCase.getIncluded) {
			if (!result.contains(includedUseCase)) {
				result += includedUseCase				
				getIncludedUseCasesRecursively(includedUseCase, result)
			}
		}
	}
	
	@Pure def static UseCase getUseCase(Step step) {
		Preconditions.checkNotNull(step)
		(step.eContainer as Scenario).getUseCase
	}
	
	@Pure def static UseCase getUseCase(Scenario scenario) {
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
	
	@Pure def static Scenario getScenario(Step step) {
		Preconditions.checkNotNull(step)
		step.eContainer as Scenario
	}
}