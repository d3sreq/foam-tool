package org.foam.models.junit

import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.util.Diagnostician
import org.foam.flowannotation.FlowannotationFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.ucm.UcmFactory
import org.foam.ucm.UcmPackage
import org.foam.ucm.util.UcmValidatorCustom
import org.junit.BeforeClass
import org.junit.Test

import static org.junit.Assert.*

class UcmValidatorCustomTest {
	
	@BeforeClass
	def static void init() {
		EValidator.Registry::INSTANCE.put(UcmPackage::eINSTANCE, new UcmValidatorCustom)
	}
	
	val ucmFac = UcmFactory::eINSTANCE
	val flowFac = FlowannotationFactory::eINSTANCE
	val logicFac = PropositionallogicFactory::eINSTANCE
	
	@Test
	def void testPrecedenceWithoutCycleSingleUseCase() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"
			]
			useCases += uc1
			
			uc1.preceeded += uc1
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "PrecedenceWithoutCycle")
	}
	
	@Test
	def void testPrecedenceWithoutCycleTwoUseCases() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"
			]			
			val uc2 = createSimpleUseCase => [
				id = "UC2"
			]
			useCases += newArrayList(uc1, uc2)
			
			uc1.preceeded += uc2
			uc2.preceeded += uc1
		]
		
		val constraintName = "PrecedenceWithoutCycle"
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertEquals(Diagnostic::ERROR, diagnostic.severity)
		assertEquals(2, diagnostic.children.size)
		assertTrue(diagnostic.children.head.message.contains(constraintName))
		assertTrue(diagnostic.children.get(1).message.contains(constraintName))
	}
	
	@Test
	def void testIncludeWithoutCycle() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"				
			]			
			val uc2 = createSimpleUseCase => [
				id = "UC2"
			]
			
			uc1.mainScenario.steps.head.annotations += flowFac.createInclude => [
				inlinedUseCase = uc2
			]			
			uc2.mainScenario.steps.head.annotations += flowFac.createInclude => [
				inlinedUseCase = uc1
			]
			
			useCases += newArrayList(uc1, uc2)
		]
		
		val constraintName = "IncludeWithoutCycle"
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertEquals(Diagnostic::ERROR, diagnostic.severity)
		assertEquals(2, diagnostic.children.size)
		assertTrue(diagnostic.children.head.message.contains(constraintName))
		assertTrue(diagnostic.children.get(1).message.contains(constraintName))
	}
	
	@Test
	def void testIncludedIsSubsetOfPreceeded() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"				
			]			
			val uc2 = createSimpleUseCase => [
				id = "UC2"
			]
			val uc3 = createSimpleUseCase => [
				id = "UC3"
			]
			
			// uc1 and uc3 must run before uc2
			uc2.preceeded += newArrayList(uc1, uc3)
			
			// uc2 is included in uc1
			uc1.mainScenario.steps.head.annotations += flowFac.createInclude => [
				inlinedUseCase = uc2
			]
			
			// problem will arise when validating uc1 - it has only set (uc1) in
			// preceededOrSelf but it's include uc2 has (uc1, uc3) in preceededOrSelf			
			
			useCases += newArrayList(uc1, uc2, uc3)
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "IncludedIsSubsetOfPreceeded")
	}
	
	@Test
	def void testNoAbortInMainScenario() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"
			]			
			useCases += uc1
			
			uc1.mainScenario.steps.head.annotations += flowFac.createAbort			
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "NoAbortInMainScenario")
	}
	
	@Test
	def void testNoGotoInMainScenario() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			val uc1 = createSimpleUseCase => [
				id = "UC1"
			]			
			useCases += uc1
			
			val firstStep = uc1.mainScenario.steps.head
			firstStep.annotations += flowFac.createGoto => [
				target = firstStep
			]
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "NoGotoInMainScenario")
	}
	
	@Test
	def void testGotoOnlyAtScenarioEnd() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			useCases += createSimpleUseCase => [
				id = "UC1"
				val firstStep = mainScenario.steps.head
				branches.put(firstStep, ucmFac.createScenarioHolder => [
					extensions += ucmFac.createScenario => [
						text = "some extension condition"
						steps += ucmFac.createStep => [
							text = "branch step 1"
							annotations += flowFac.createGoto => [
								target = firstStep
							] 
						]
						steps += ucmFac.createStep => [
							text = "branch step 2"
						]
					]
				])
			]
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "GotoOnlyAtScenarioEnd")
	}
	
	@Test
	def void testOnlyOneOfAbortGotoAtScenarioEnd() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			useCases += createSimpleUseCase => [
				id = "UC1"
				val firstStep = mainScenario.steps.head
				branches.put(firstStep, ucmFac.createScenarioHolder => [
					extensions += ucmFac.createScenario => [
						text = "some extension condition"
						steps += ucmFac.createStep => [
							text = "branch step 1"
							annotations += flowFac.createGoto => [
								target = firstStep
							]
							annotations += flowFac.createAbort
						]
					]
				])
			]
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "OnlyOneOfAbortGotoAtScenarioEnd")
	}
	
	@Test
	def void testGuardOnlyAtScenarioStart() {
		val useCaseModel = ucmFac.createUseCaseModel => [
			useCases += createSimpleUseCase => [
				id = "UC1"
				val firstStep = mainScenario.steps.head
				branches.put(firstStep, ucmFac.createScenarioHolder => [
					extensions += ucmFac.createScenario => [
						text = "some extension condition"
						steps += ucmFac.createStep => [
							text = "branch step 1"
						]
						steps += ucmFac.createStep => [
							text = "branch step 2"
							annotations += flowFac.createGuard => [
								formula = logicFac.createTrue
							]
						]
					]
				])
			]
		]
		
		val diagnostic = Diagnostician::INSTANCE.validate(useCaseModel)
		assertOnlyDiagnosticError(diagnostic, "GuardOnlyAtScenarioStart")
	}
	
	
	def private assertOnlyDiagnosticError(Diagnostic diagnostic, String constraintName) {
		assertEquals(Diagnostic::ERROR, diagnostic.severity)
		assertEquals(1, diagnostic.children.size)
		assertTrue(diagnostic.children.head.message.contains(constraintName))
	}
	
	def private createSimpleUseCase() {
		ucmFac.createUseCase => [
			name = "UC name"
			
			mainScenario = ucmFac.createScenario => [				
				steps += ucmFac.createStep => [
					text = "step1"
				]
			]
		]
	}
}