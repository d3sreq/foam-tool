package org.foam.transform.ucm2ucm

import java.util.Collections
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.text.StringWithOffset
import org.foam.text.TextFactory
import org.foam.ucm.UcmFactory
import org.foam.ucmtext.ScenarioType
import org.foam.ucmtext.UcmtextFactory
import org.foam.ucmtexttrac.UcmtexttracFactory
import org.junit.Assert
import org.junit.Test

class UcmParseModel2UcmServiceTest {
	
	val UcmFactory ucmFac = UcmFactory.eINSTANCE
	val fac = UcmtextFactory.eINSTANCE
	val textFac = TextFactory.eINSTANCE
	val ucmTraceFac = UcmtexttracFactory.eINSTANCE
	
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
	def void firstTest() {
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
			primary = true
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
		
		val result = service.transform(Collections.singleton(data))
		val actualUcm = result.key
		val actualTrace = result.value
		
		Assert.assertTrue("Actual UseCaseModel doesn't match the actual one", EcoreUtil.equals(expectedUcm, actualUcm))
		Assert.assertTrue("Actual UcmToUcmtextTrace doesn't match the actual one", EcoreUtil.equals(expectedTrace, actualTrace))
	}
}