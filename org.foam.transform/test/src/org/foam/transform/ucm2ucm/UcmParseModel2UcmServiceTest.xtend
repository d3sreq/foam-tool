package org.foam.transform.ucm2ucm

import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.text.StringWithOffset
import org.foam.text.TextFactory
import org.foam.ucm.UcmFactory
import org.foam.ucmtext.ScenarioType
import org.foam.ucmtext.UcmtextFactory
import org.foam.ucmtexttrac.UcmtexttracFactory
import org.junit.Assert
import org.junit.Test
import org.foam.annotation.AnnotationFactory

class UcmParseModel2UcmServiceTest {
	
	val UcmFactory ucmFac = UcmFactory.eINSTANCE
	val fac = UcmtextFactory.eINSTANCE
	val textFac = TextFactory.eINSTANCE
	val ucmTraceFac = UcmtexttracFactory.eINSTANCE
	val annotationFac = AnnotationFactory.eINSTANCE
	
	val service = new UcmParseModel2UcmService
	
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
	def void singleUseCaseWithoutBranchingTest() {
		val nameDef = fac.createUseCaseNameDef => [
			useCase = fac.createUcIdDef => [
				id = createStringWithOffset("UC1")
				description = createStringWithOffset("Process Sale")
			]
		]
		
		val stepDef1 = fac.createStepDef => [ label = createStringWithOffset("1"); text = createStringWithOffset("a") ]
		val stepDef2 = fac.createStepDef => [ label = createStringWithOffset("2"); text = createStringWithOffset("b") ]
		
		val data = fac.createUnparsedUseCaseText => [
			text = createStringWithOffset("")
			
			blocks += fac.createBlock => [
				derived = nameDef
			]
			
			blocks += fac.createBlock => [
				derived = fac.createScenarioDef => [
					type = ScenarioType.MAIN
					steps += stepDef1
					steps += stepDef2
				]
			]
		]
		
		val step1 = ucmFac.createStep => [ text = "a" ]
		val step2 = ucmFac.createStep => [ text = "b" ]
		
		val uc = ucmFac.createUseCase => [
			id = "UC1"
			name = "Process Sale"
			mainScenario = ucmFac.createScenario => [
				steps += step1
				steps += step2
			]
		]
		
		val expectedUcm = ucmFac.createUseCaseModel => [
			useCases += uc
		]
		
		val expectedTrace = ucmTraceFac.createUcmToUcmtextTrace => [
			names.map.put(uc, nameDef)
			steps.map.put(step1, stepDef1)
			steps.map.put(step2, stepDef2)
		]
		
		val result = service.transform(#[data])
		val actualUcm = result.key
		val actualTrace = result.value
		
		Assert.assertTrue("Actual UseCaseModel doesn't match the actual one", EcoreUtil.equals(expectedUcm, actualUcm))
		Assert.assertTrue("Actual UcmToUcmtextTrace doesn't match the actual one", EcoreUtil.equals(expectedTrace, actualTrace))
	}
	
	@Test
	def void twoUseCasesWithBranchingAndPrecedenceTest() {
		// UC 1
		val uc1NameDef = fac.createUseCaseNameDef => [
			useCase = fac.createUcIdDef => [
				id = createStringWithOffset("UC1")
				description = createStringWithOffset("Process Sale")
			]
		]
		
		val uc1StepDef1 = fac.createStepDef => [ label = createStringWithOffset("1"); text = createStringWithOffset("uc1 step 1") ]
		val uc1StepDef1a = fac.createStepDef => [ label = createStringWithOffset("1a"); text = createStringWithOffset("Alternative flow") ]
		val uc1StepDef1a1 = fac.createStepDef => [ label = createStringWithOffset("1a1"); text = createStringWithOffset("uc1 step 1a1") ]
		
		val uc1branchingScenarioDef = fac.createScenarioDef => [
			type = ScenarioType.VARIATION
			steps += uc1StepDef1a
			steps += uc1StepDef1a1
		]
		
		val uc1primaryDef = fac.createPrimaryDef => [
			value = createStringWithOffset("false")
		]
		
		val uc1UnparsedUseCaseText = fac.createUnparsedUseCaseText => [
			text = createStringWithOffset("")
			
			blocks += fac.createBlock => [
				derived = uc1NameDef
			]
			
			blocks += fac.createBlock => [
				derived = fac.createScenarioDef => [
					type = ScenarioType.MAIN
					steps += uc1StepDef1
				]
			]
			
			blocks += fac.createBlock => [
				derived = uc1branchingScenarioDef
			]
			
			blocks += fac.createBlock => [
				derived = uc1primaryDef
			]
		]
		
		val uc1step1 = ucmFac.createStep => [ text = "uc1 step 1" ]
		val uc1step1a1 = ucmFac.createStep => [ text = "uc1 step 1a1" ]
		
		val uc1BranchingScenario = ucmFac.createScenario => [
			text = "Alternative flow"
			steps += uc1step1a1
		]
		
		val uc1 = ucmFac.createUseCase => [
			id = "UC1"
			name = "Process Sale"
			primary = false
			mainScenario = ucmFac.createScenario => [
				steps += uc1step1
			]
			
			branches.put(uc1step1, 
				ucmFac.createScenarioHolder => [
					variations += uc1BranchingScenario
				]
			)
		]
		
		// UC 2
		val uc2NameDef = fac.createUseCaseNameDef => [
			useCase = fac.createUcIdDef => [
				id = createStringWithOffset("UC2")
				description = createStringWithOffset("Inform customer")
			]
		]
		
		val uc2StepDef1 = fac.createStepDef => [ label = createStringWithOffset("1"); text = createStringWithOffset("uc2 step 1") ]
		
		val uc2PrecedenceDef = fac.createPrecedenceDef => [
			preceded += fac.createUcIdDef => [
				id = createStringWithOffset("UC1")
				description = createStringWithOffset("abcd")
			]
		]
		
		val uc2UnparsedUseCaseText = fac.createUnparsedUseCaseText => [
			text = createStringWithOffset("")
			
			blocks += fac.createBlock => [
				derived = uc2NameDef
			]
			
			blocks += fac.createBlock => [
				derived = fac.createScenarioDef => [
					type = ScenarioType.MAIN
					steps += uc2StepDef1
				]
			]
			
			blocks += fac.createBlock => [
				derived = uc2PrecedenceDef
			]
		]
		
		val uc2step1 = ucmFac.createStep => [ text = "uc2 step 1" ]
		
		val uc2 = ucmFac.createUseCase => [
			id = "UC2"
			name = "Inform customer"
			preceeded += uc1
			mainScenario = ucmFac.createScenario => [
				steps += uc2step1
			]
		]
		
		val expectedUcm = ucmFac.createUseCaseModel => [
			useCases += uc1
			useCases += uc2
		]
		
		val expectedTrace = ucmTraceFac.createUcmToUcmtextTrace => [
			names.map.put(uc1, uc1NameDef)
			names.map.put(uc2, uc2NameDef)
			
			steps.map.put(uc1step1, uc1StepDef1)
			steps.map.put(uc1step1a1, uc1StepDef1a1)
			steps.map.put(uc2step1, uc2StepDef1)
			
			precedenceDef.map.put(uc2, uc2PrecedenceDef)
			
			branchingConditions.map.put(uc1BranchingScenario, uc1StepDef1a)
			
			primaryDef.map.put(uc1, uc1primaryDef)
		]
		
		val data = #[uc1UnparsedUseCaseText, uc2UnparsedUseCaseText]
		
		val result = service.transform(data)
		val actualUcm = result.key
		val actualTrace = result.value
		
		Assert.assertTrue("Actual UseCaseModel doesn't match the actual one", EcoreUtil.equals(expectedUcm, actualUcm))
		Assert.assertTrue("Actual UcmToUcmtextTrace doesn't match the actual one", EcoreUtil.equals(expectedTrace, actualTrace))
	}
	
	@Test
	def void annotationTest() {
		val annot1 = createStringWithOffset("a")
		val annot2 = createStringWithOffset("b:c:d")
		
		val stepDef1 = fac.createStepDef => [
			label = createStringWithOffset("1")
			text = createStringWithOffset("first step")
			annot += #[annot1, annot2]
		]
		
		val data = fac.createUnparsedUseCaseText => [
			blocks += fac.createBlock => [
				derived = fac.createScenarioDef => [
					type = ScenarioType.MAIN
					steps += stepDef1
				]
			]
		]
		
		val annotation1 = annotationFac.createUnknownAnnotation => [
			parts += "a"
		]
		
		val annotation2 = annotationFac.createUnknownAnnotation => [
			parts += #["b", "c", "d"]
		]
		
		val step1 = ucmFac.createStep => [
			text = "first step"
			annotations += #[annotation1, annotation2]
		]
		
		val uc = ucmFac.createUseCase => [
			mainScenario = ucmFac.createScenario => [
				steps += step1
			]
		]
		
		val expectedUcm = ucmFac.createUseCaseModel => [
			useCases += uc
		]
		
		val expectedTrace = ucmTraceFac.createUcmToUcmtextTrace => [
			steps.map.put(step1, stepDef1)
			annotations.map.put(annotation1, annot1)
			annotations.map.put(annotation2, annot2)
		]
		
		val result = service.transform(#[data])
		val actualUcm = result.key
		val actualTrace = result.value
		
		Assert.assertTrue("Actual UseCaseModel doesn't match the actual one", EcoreUtil.equals(expectedUcm, actualUcm))
		Assert.assertTrue("Actual UcmToUcmtextTrace doesn't match the actual one", EcoreUtil.equals(expectedTrace, actualTrace))
	}
}