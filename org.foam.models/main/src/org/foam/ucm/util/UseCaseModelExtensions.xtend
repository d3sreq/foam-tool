package org.foam.ucm.util

import com.google.common.base.Preconditions
import org.foam.flowannotation.Include
import org.foam.ucm.Scenario
import org.foam.ucm.ScenarioHolder
import org.foam.ucm.Step
import org.foam.ucm.UseCase

import static extension org.foam.bootstrap.IterableExtensions.*

class UseCaseModelExtensions {
	
	@Pure def static allScenarios(UseCase useCase) {
		#[useCase.mainScenario]
		+ useCase.branches.values.map[branches.map[value as Scenario]].flatten
	}

	@Pure def static allSteps(UseCase useCase) {
		useCase.allScenarios.map[steps].flatten
	}
	
	/**
	 * All annotations found in a use case.
	 */
	@Pure def static getStepAnnotations(UseCase useCase) {
		useCase.allScenarios.map[getStepAnnotations].flatten
	}
	
	/**
	 * All annotations found in a single scenario.
	 */
	@Pure def static getStepAnnotations(Scenario scenario) {
		scenario.steps.map[annotations].flatten
	}

	@Pure def static getPreceededTransitively(UseCase useCase) {
		useCase.trasitiveClosureWithoutStart[preceeded]
	}
	
	@Pure def static getIncludedTransitively(UseCase useCase) {
		useCase.trasitiveClosureWithoutStart[included]
	}

	@Pure def static getIncluded(UseCase useCase) {
		useCase.allSteps.map[
			annotations.filter(Include).map[inlinedUseCase]
		].flatten.toSet
	}

	@Pure def static getUseCase(Step step) {
		Preconditions.checkNotNull(step)
		(step.eContainer as Scenario).getUseCase
	}
	
	@Pure def static getUseCase(Scenario scenario) {
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
	
	@Pure def static getScenario(Step step) {
		Preconditions.checkNotNull(step)
		step.eContainer as Scenario
	}
}