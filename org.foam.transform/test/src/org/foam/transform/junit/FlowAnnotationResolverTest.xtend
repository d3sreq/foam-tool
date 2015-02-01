package org.foam.transform.junit

import java.util.Collections
import org.foam.annotation.AnnotationFactory
import org.foam.flowannotation.FlowannotationFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.transform.ucm2ucm.flowannotationresolver.FlowAnnotationResolver
import org.foam.ucm.UcmFactory
import org.foam.xtext.plogic.PropositionalLogicXtextStandaloneSetup
import org.junit.Assert
import org.junit.Test
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.ucmtexttrac.UcmtexttracFactory
import org.foam.text.TextFactory
import org.foam.text.StringWithOffset

class FlowAnnotationResolverTest {
	val ucmFac = UcmFactory.eINSTANCE
	val flowFac = FlowannotationFactory.eINSTANCE
	val propFac = PropositionallogicFactory.eINSTANCE
	val annotationFac = AnnotationFactory.eINSTANCE
	val ucmTraceFac = UcmtexttracFactory.eINSTANCE
	val textFac = TextFactory.eINSTANCE
	
	val flowAnnotationResolver = new FlowAnnotationResolver
	
	// constructor is needed only for headless unit-testing
	new() {PropositionalLogicXtextStandaloneSetup.doSetup}

	/**
	 * Creates StringWithOffset with dummy offset value.
	 */
	def private StringWithOffset createStringWithOffset(String text) {
		textFac.createStringWithOffset => [
			offset = 0
			content = text
		]
	}

	@Test
	def resolveAbort() {
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += Collections.singletonList("abort")
		]
		
		val abortString = createStringWithOffset("abort")
		
		val ucmInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC1"
				name = "Abort test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Use case aborts."
						annotations += unresolvedAnnotation
					]				
				]
			]
		]
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, abortString)
	
		val abortAnnotation = flowFac.createAbort
	
		val ucmExpected = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC1"
				name = "Abort test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Use case aborts."
						annotations += abortAnnotation
					]
				]
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(abortAnnotation, abortString)
		
		// tests that unknown annotation is replaced with abort annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}
	
	
	
	@Test
	def resolveInclude() {
		
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += #["include", "UC3"]
		]
		
		val ucmInput = ucmFac.createUseCaseModel => [
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
						annotations += unresolvedAnnotation
					]
				]
			]
		]
		
		val includeString = createStringWithOffset("xxx")
		
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, includeString)
		
		val useCase3 = ucmFac.createUseCase => [
			id = "UC3"
			name = "Included use case"
			
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "Only step of the included use case"
				]
			]
		]
		
		val includeAnnotation = flowFac.createInclude => [
			inlinedUseCase = useCase3
		]
		
		val ucmExpected = ucmFac.createUseCaseModel => [
			
			useCases += useCase3
			
			useCases += ucmFac.createUseCase => [
				id = "UC2"
				name = "Include test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step triggers included use case."
						annotations += includeAnnotation
					]
				]			
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(includeAnnotation, includeString)
		
		// tests that unknown annotation is replaced with include annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}

	@Test
	def resolveGoto() {
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += #["goto", "1"]
		]
		
		val ucmInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC4"
				name = "Goto test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "First step."
					]
					
					steps += ucmFac.createStep => [
						text = "Continue with step 1."
						annotations += unresolvedAnnotation
					]
				]
			]
		]
		
		val gotoString = createStringWithOffset("xxx")
		
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, gotoString)
		
		val step1 = ucmFac.createStep => [ text = "First step." ]
		val gotoAnnotation = flowFac.createGoto => [ target = step1 ]
		
		val ucmExpected = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC4"
				name = "Goto test"
				
				mainScenario = ucmFac.createScenario => [
					steps += step1
					steps += ucmFac.createStep => [
						text = "Continue with step 1."
						annotations += gotoAnnotation
					]
				]
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(gotoAnnotation, gotoString)
		
		// tests that unknown annotation is replaced with goto annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}

	@Test
	def resolveMark() {
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += #["mark", "x"]
		]
		
		val ucmInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC5"
				name = "Mark test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with mark."
						annotations += unresolvedAnnotation
					]
				]
			]
		]
		
		val markString = createStringWithOffset("xxx")
		
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, markString)
		
		val xVarDef = propFac.createVariableDefinition => [
			name = "mark_x"
		]
		
		val markAnnotation = flowFac.createMark => [
			variableDefinition = xVarDef
		]
		
		val ucmExpected = ucmFac.createUseCaseModel => [
			
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = xVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC5"
				name = "Mark test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with mark."
						annotations += markAnnotation
					]
				]
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(markAnnotation, markString)
		
		// tests that unknown annotation is replaced with mark annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}

	@Test
	def resolveGuard() {
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += #["guard", "x & y"]
		]

		val ucmInput = ucmFac.createUseCaseModel => [
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
						annotations += unresolvedAnnotation
					]
				]
			]
		]
		
		val guardString = createStringWithOffset("xxx")
		
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, guardString)
		
		val xVarDef = propFac.createVariableDefinition => [
			name = "mark_x"
		]
		
		val yVarDef = propFac.createVariableDefinition => [
			name = "mark_y"
		]
		
		val guardAnnotation = flowFac.createGuard => [
			formula = propFac.createAnd => [
				left = propFac.createVariableUse => [
					variableDefinition = xVarDef
				]
				right = propFac.createVariableUse => [
					variableDefinition = yVarDef
				]
			]
		]
		
		val ucmExpected = ucmFac.createUseCaseModel => [
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = yVarDef
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
						annotations += guardAnnotation
					]
				]
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(guardAnnotation, guardString)
		
		// tests that unknown annotation is replaced with guard annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}

	@Test
	def resolveGuardWithSingleVariable() {
		val unresolvedAnnotation = annotationFac.createUnknownAnnotation => [
			parts += #["guard", "x"]
		]
		
		val ucmInput = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += unresolvedAnnotation
					]
				]
			]
		]
		
		val guardString = createStringWithOffset("xxx")
		
		val traceInput = ucmTraceFac.createUcmToUcmtextTrace
		traceInput.annotations.map.put(unresolvedAnnotation, guardString)
		
		val xVarDef = propFac.createVariableDefinition => [
			name = "mark_x"
		]
		
		val guardAnnotation = flowFac.createGuard => [
			formula = propFac.createVariableUse => [
				variableDefinition = xVarDef
			]
		]
		
		val ucmExpected = ucmFac.createUseCaseModel => [
			annotations += flowFac.createVariableDefinitionAnnotation => [
				variableDefinition = xVarDef
			]
			
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Guard test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "Step with guard."
						annotations += guardAnnotation
					]
				]
			]
		]
		
		val traceExpected = ucmTraceFac.createUcmToUcmtextTrace
		traceExpected.annotations.map.put(guardAnnotation, guardString)
		
		// tests that unknown annotation is replaced with guard annotation
		flowAnnotationResolver.resolveAnnotations(ucmInput, traceInput)
		Assert.assertTrue("Expected and actual use case model doesn't match", 
			EcoreUtil.equals(ucmExpected, ucmInput)
		)
		
		Assert.assertTrue("Expected and actual trace model doesn't match", 
			EcoreUtil.equals(traceExpected, traceInput)
		)
	}
}