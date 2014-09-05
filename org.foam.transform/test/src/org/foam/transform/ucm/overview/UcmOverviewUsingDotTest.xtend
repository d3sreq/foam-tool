package org.foam.transform.ucm.overview

import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.junit.Assert
import org.junit.Test
import org.foam.flowannotation.FlowannotationFactory
import org.foam.transform.ucm.dot.UcmOverviewUsingDot

class UcmOverviewUsingDotTest {
	
	extension UcmFactory = UcmFactory.eINSTANCE
	extension FlowannotationFactory = FlowannotationFactory.eINSTANCE

	UseCase ucA
	UseCase ucB
	UseCase ucC
	UseCase ucD
	
	val ucm = createUseCaseModel => [

		// this use-case is for inclusion only
		useCases += ucD =createUseCase => [
			id = "D"
			mainScenario = createScenario
		]

		useCases += ucA = createUseCase => [
			id = "A"
			mainScenario = createScenario
		]
		
		useCases += ucB =createUseCase => [
			id = "B"
			preceeded += ucA
			mainScenario = createScenario => [
				steps += createStep => [
					annotations += createInclude => [
						inlinedUseCase = ucD
					]
				]
			]
		]
		
		useCases += ucC =createUseCase => [
			id = "C"
			preceeded += ucB
			preceeded += ucA
			mainScenario = createScenario
		]
		
		// generate names for all use-cases
		useCases.forEach[name = '''Name of use-case «id»''']
	]
	
	val service = new UcmOverviewUsingDot => [
		logService = null
		ucmOverviewCreator = new UcmOverviewCreator
	]
	
	@Test def void testTransformation() {
		Assert.assertFalse(service.transform(ucm).toString.empty)
	}
}