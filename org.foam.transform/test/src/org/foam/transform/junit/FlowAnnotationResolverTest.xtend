package org.foam.transform.junit

import java.util.Collections
import org.foam.annotation.AnnotationFactory
import org.foam.flowannotation.FlowannotationFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.transform.junit.utils.FlowAnnotationChecker
import org.foam.transform.ucm2ucm.flowannotationresolver.FlowAnnotationResolver
import org.foam.ucm.UcmFactory
import org.junit.Test

class FlowAnnotationResolverTest {
	val ucmFac = UcmFactory::eINSTANCE
	val flowFac = FlowannotationFactory::eINSTANCE
	val propFac = PropositionallogicFactory::eINSTANCE
	val annotationFac = AnnotationFactory::eINSTANCE
	val flowAnnotationResolver = new FlowAnnotationResolver
	val flowAnnotationChecker = new FlowAnnotationChecker
	
	@Test
	def resolveAbort() {
		val ucmAbortInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC1"
				name = "Abort test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Use case aborts."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += Collections::singletonList("abort")
						]
					]				
				]
			]
		]
	
		val ucmAbortExpected = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC1"
				name = "Abort test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Use case aborts."
						annotations += flowFac.createAbort
					]
				]
			]
		]
		
		// tests that unknown annotation is replaced with abort annotation
		flowAnnotationResolver.resolveAnnotations(ucmAbortInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmAbortExpected, ucmAbortInput)
	}
	
	
	
	@Test
	def resolveInclude() {
		
		val ucmIncludeInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC3"
				name = "Included use case"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Only step of the included use case"
					]
				]
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC2"
				name = "Include test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step triggers included use case."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += newArrayList("include", "UC3")
						]
					]
				]
			]
		]
		
		val ucmIncludeExpected = ucmFac.createUseCaseModel => [
			val useCase3 = ucmFac.createUseCase => [
				id = "UC3"
				name = "Included use case"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Only step of the included use case"
					]
				]
			]
			useCases += useCase3
			
			useCases += ucmFac.createUseCase => [
				id = "UC2"
				name = "Include test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step triggers included use case."
						annotations += flowFac.createInclude => [
							inlinedUseCase = useCase3
						]
					]
				]			
			]
		]
		
		// tests that unknown annotation is replaced with include annotation
		flowAnnotationResolver.resolveAnnotations(ucmIncludeInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmIncludeExpected, ucmIncludeInput)
	}
	
	@Test
	def resolveGoto() {
		val ucmGotoInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC4"
				name = "Goto test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "First step."
					]
					
					steps += ucmFac.createStep => [
						text = "Continue with step 1."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += newArrayList("goto", "1")
						]
					]
				]
			]
		]
		
		val ucmGotoExpected = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC4"
				name = "Goto test"
				
				mainScenario = ucmFac.createScenario => [
					val step1 = ucmFac.createStep => [
						text = "First step."
					]
					steps += step1
					
					steps += ucmFac.createStep => [
						text = "Continue with step 1."
						annotations += flowFac.createGoto => [
							target = step1
						]
					]
				]
			]
		]
		
		// tests that unknown annotation is replaced with goto annotation
		flowAnnotationResolver.resolveAnnotations(ucmGotoInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmGotoExpected, ucmGotoInput)
	}
	
	@Test
	def resolveMark() {
		val ucmMarkInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC5"
				name = "Mark test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with mark."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += newArrayList("mark", "x")
						]
					]
				]
			]
		]
		
		val ucmMarkExpected = ucmFac.createUseCaseModel => [
			val xVarDef = propFac.createVariableDefinition => [
				name = "mark_x"
			]
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = xVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC5"
				name = "Mark test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with mark."
						annotations += flowFac.createMark => [
							variableDefinition = xVarDef
						]
					]
				]
			]
		]
		
		// tests that unknown annotation is replaced with goto annotation
		flowAnnotationResolver.resolveAnnotations(ucmMarkInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmMarkExpected, ucmMarkInput)
	}
	
	@Test
	def resolveGuard() {
		val ucmGuardInput = ucmFac.createUseCaseModel => [
			val yVarDef = propFac.createVariableDefinition => [
				name = "mark_y"
			]
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = yVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += newArrayList("guard", "x & y")
						]
					]
				]
			]
		]
		
		val ucmGuardExpected = ucmFac.createUseCaseModel => [
			val yVarDef = propFac.createVariableDefinition => [
				name = "mark_y"
			]
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = yVarDef
			]
			
			val xVarDef = propFac.createVariableDefinition => [
				name = "mark_x"
			]
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = xVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += flowFac.createGuard => [
							formula = propFac.createAnd => [
								left = propFac.createVariableUse => [
									variableDefinition = xVarDef
								]
								right = propFac.createVariableUse => [
									variableDefinition = yVarDef
								]
							]
						]
					]
				]
			]
		]
		
		// tests that unknown annotation is replaced with goto annotation
		flowAnnotationResolver.resolveAnnotations(ucmGuardInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmGuardExpected, ucmGuardInput)
	}
	
	@Test
	def resolveGuardWithSingleVariable() {
		val ucmGuardInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += annotationFac.createUnknownAnnotation => [
							parts += newArrayList("guard", "x")
						]
					]
				]
			]
		]
		
		val ucmGuardExpected = ucmFac.createUseCaseModel => [
			val xVarDef = propFac.createVariableDefinition => [
				name = "mark_x"
			]
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = xVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += flowFac.createGuard => [
							formula = propFac.createVariableUse => [
								variableDefinition = xVarDef
							]
						]
					]
				]
			]
		]
		
		// tests that unknown annotation is replaced with goto annotation
		flowAnnotationResolver.resolveAnnotations(ucmGuardInput)
		flowAnnotationChecker.assertUseCaseModelEquals(ucmGuardExpected, ucmGuardInput)
	}
}