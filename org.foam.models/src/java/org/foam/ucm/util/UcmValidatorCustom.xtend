package org.foam.ucm.util

import java.util.Collections
import java.util.Map
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EObject
import org.foam.flowannotation.Abort
import org.foam.flowannotation.Goto
import org.foam.flowannotation.Guard
import org.foam.ucm.Scenario
import org.foam.ucm.UseCase

import static extension org.foam.ucm.util.UcmUtils.*

public class UcmValidatorCustom extends UcmValidator {
	
	override boolean validateUseCase_PrecedenceWithoutCycle(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val preceededTransitively = useCase.preceededTransitively
		
		if (preceededTransitively.contains(useCase)) {
			addDiagnostics(diagnostics, useCase, context, "PrecedenceWithoutCycle")
			return false
		}
		true
	}
	
	override boolean validateUseCase_IncludeWithoutCycle(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val includedUseCases = useCase.includedTransitively
		
		if (includedUseCases.contains(useCase)) {		
			addDiagnostics(diagnostics, useCase, context, "IncludeWithoutCycle")
			return false
		}
		true
	}
	
	override boolean validateUseCase_IncludedIsSubsetOfPreceeded(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// when validating use case:
		// for each use case in set of all transitively included use cases 
		// must hold that set of their preceeded (not transitively) use cases
		// must be subset of the preceeded use cases of the validated use case
		//
		// e.g. this example is illegal:
		// 208 ->P 1   (1 must run before 208)
		// 1   ->I 208 (1 includes 208)
		// 208 ->P X   (X must run before 208)
		// - 208 is preceeded by 1 and X but validated use case 1 is not preceeded
		//   by X.  
		
		val includedOrSelf = useCase.includedTransitively + Collections.singleton(useCase)
		val preceededOrSelf = (useCase.preceededTransitively + Collections.singleton(useCase)).toSet
		
		for (includedUseCase : includedOrSelf) {
			if (!preceededOrSelf.containsAll(includedUseCase.preceeded)) {				
				addDiagnostics(diagnostics, useCase, context, "IncludedIsSubsetOfPreceeded")
				return false
			}
		}
		true
	}
	
	override boolean validateUseCase_NoAbortInMainScenario(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val aborts = useCase.mainScenario.stepAnnotations.filter(Abort)
		
		if (!aborts.empty) {
			addDiagnostics(diagnostics, useCase, context, "NoAbortInMainScenario")
			return false
		}
		true
	}
	
	override boolean validateUseCase_NoGotoInMainScenario(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val gotos = useCase.mainScenario.stepAnnotations.filter(Goto)
		
		if (!gotos.empty) {
			addDiagnostics(diagnostics, useCase, context, "NoGotoInMainScenario")
			return false
		}
		true
	}
	
	override boolean validateScenario_AbortOnlyAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val lastStep = scenario.steps.last
		
		for (step : scenario.steps) {
			val aborts = step.annotations.filter(Abort)			
			if (!aborts.empty && step != lastStep) {
				addDiagnostics(diagnostics, scenario, context, "AbortOnlyAtScenarioEnd")
				return false
			}
		}
		 
		true
	}
	
	override boolean validateScenario_GotoOnlyAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val lastStep = scenario.steps.last
		
		for (step : scenario.steps) {
			val gotos = step.annotations.filter(Goto)
			if (!gotos.empty && step != lastStep) {
				addDiagnostics(diagnostics, scenario, context, "GotoOnlyAtScenarioEnd")
				return false
			}
		}
		 
		true
	}
	
	override boolean validateScenario_OnlyOneOfAbortGotoAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val lastStep = scenario.steps.last
		
		val aborts = lastStep.annotations.filter(Abort)
		val gotos = lastStep.annotations.filter(Goto)
		if (!aborts.empty && !gotos.empty) {
			addDiagnostics(diagnostics, scenario, context, "OnlyOneOfAbortGotoAtScenarioEnd")
			return false
		}
		
		 true
	}
	
	override boolean validateScenario_GuardOnlyAtScenarioStart(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		val firstStep = scenario.steps.head
		
		for (step : scenario.steps) {
			val guards = step.annotations.filter(Guard)
			if (!guards.empty && step != firstStep) {
				addDiagnostics(diagnostics, scenario, context, "GuardOnlyAtScenarioStart")
				return false
			}
		}
		
		true
	}
	
	def private void addDiagnostics(DiagnosticChain diagnostics, EObject eObject, Map<Object, Object> context, String errorLabelId) {
		if (diagnostics != null) {
			diagnostics.add
				(createDiagnostic
					(Diagnostic.ERROR,
					 DIAGNOSTIC_SOURCE,
					 0,
					 "_UI_GenericConstraint_diagnostic",
					 newArrayList(errorLabelId, getObjectLabel(eObject, context)),
					 newArrayList(eObject),
					 context))
		}
	}

} //UcmValidator
