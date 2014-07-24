package org.foam.models.junit

import org.foam.flowannotation.FlowannotationFactory
import org.junit.Test
import org.foam.ucm.UcmFactory
import static extension org.foam.ucm.util.UcmUtils.*
import static org.junit.Assert.*

class UcmUtilsTest {
	val ucmFac = UcmFactory::eINSTANCE
	val flowFac = FlowannotationFactory::eINSTANCE
	
	val uc1 = ucmFac.createUseCase => [
		id = "UC1"
		mainScenario = ucmFac.createScenario
	]
	
	val uc2 = ucmFac.createUseCase => [
		id = "UC2"
		preceeded += uc1
		mainScenario = ucmFac.createScenario
	]
	
	val uc3 = ucmFac.createUseCase => [
		id = "UC3"
		mainScenario = ucmFac.createScenario
	]
	
	val uc4 = ucmFac.createUseCase => [
		id = "UC4"
		mainScenario = ucmFac.createScenario => [
			steps += ucmFac.createStep => [
				annotations += flowFac.createInclude => [
					inlinedUseCase = uc3
				]
			]
		]
	]
	
	val uc5 = ucmFac.createUseCase => [
		id = "UC5"
		preceeded += newArrayList(uc2, uc4)
		mainScenario = ucmFac.createScenario
	]
	
	@Test
	def void getPreceecedUseCasesTest() {
		val actual = uc5.preceededTransitively
		val actualList = actual.toList.sortBy[id]
		
		assertArrayEquals(newArrayList(uc1, uc2, uc4), actualList)
	}
	
	@Test
	def void getIncludedUseCasesTest() {
		val actual = uc4.includedTransitively
		val actualList = actual.toList.sortBy[id]
		
		assertArrayEquals(newArrayList(uc3), actualList)
	}
}