package org.foam.transform.junit

import java.util.Collections
import org.foam.annotation.AnnotationFactory
import org.foam.transform.junit.utils.UcmChecker
import org.foam.transform.ucm2ucm.UcmLang2UcmService
import org.foam.ucm.Step
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.junit.Test

class UcmLang2UcmTest {
	
	val ucmFac = UcmFactory.eINSTANCE
	val annotationFac = AnnotationFactory.eINSTANCE
	val ucmLang2Ucm = new UcmLang2UcmService
	val ucmChecker = new UcmChecker
	
	val uc1 = '''
		UC1 Select city on map

		1 The user opens the map web page
		2 The system generates a map with 
		  available cities.
		
		Variation: 2a No cities available
		2a1 System displays an empty map with message.
		'''
	
	var Step uc1Step2
	var UseCase useCase1
	val ucmSimple = ucmFac.createUseCaseModel => [
		useCase1 = ucmFac.createUseCase => [
			id = "UC1"
			name = "Select city on map"
			
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "The user opens the map web page"
				]
				uc1Step2 = ucmFac.createStep => [
					text = "The system generates a map with available cities."
				]
				steps += uc1Step2
			]
			
			branches.put(uc1Step2, ucmFac.createScenarioHolder => [
				variations += ucmFac.createScenario => [
					text = "No cities available"
					steps += ucmFac.createStep => [
						text = "System displays an empty map with message."
					]
				]
			])
		]
		useCases += useCase1
	]

	@Test def parseSimpleUseCase() {
		// tests that use case ID, name, main scenario and variation is parsed correctly
		// tests that step divided to multiple lines is joined as expected
		val actualModel = ucmLang2Ucm.transform(Collections.singletonList(uc1))
		ucmChecker.assertUseCaseModelEquals(ucmSimple, actualModel)
	}
	
	val uc4 = '''
		UC4 Non-primary use case
		Primary: false
		
		1 The user opens the map web page
	'''
	
	val ucmNonPrimary = ucmFac.createUseCaseModel => [
		useCases += ucmFac.createUseCase => [
			id = "UC4"
			name = "Non-primary use case"
			primary = false
			
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "The user opens the map web page"
				]
			]
		]
	]
	
	@Test def parseNonPrimaryUseCase() {
		// tests that parsed use case is added to non-primary use cases
		val actualModel = ucmLang2Ucm.transform(Collections.singletonList(uc4))
		ucmChecker.assertUseCaseModelEquals(ucmNonPrimary, actualModel)
	}
	
	val uc5 = '''
		UC5 Branching use case

		1 First step
		
		Variation: 1a First variation.
		1a1 Some text.
		
		Variation: 1a1a First branching of the variation
		1a1a1 One
		1a1a2 Two
		
		Extension: 1a1b Second branching of the variation
		1a1b1 Three
	'''
	
	var Step uc5Step1
	var Step uc5Step1a1	
	val ucmBranching = ucmFac.createUseCaseModel => [
		useCases += ucmFac.createUseCase => [
			id = "UC5"
			name = "Branching use case"
			
			mainScenario = ucmFac.createScenario => [
				uc5Step1 = ucmFac.createStep => [
					text = "First step"
				]
				steps += uc5Step1
			]
			
			branches.put(uc5Step1, ucmFac.createScenarioHolder => [
				variations += ucmFac.createScenario => [
					text = "First variation."
					uc5Step1a1 = ucmFac.createStep => [
						text = "Some text."
					]
					steps += uc5Step1a1
				]
			])
			
			branches.put(uc5Step1a1, ucmFac.createScenarioHolder => [
				variations += ucmFac.createScenario => [
					text = "First branching of the variation"
					steps += ucmFac.createStep => [
						text = "One"
					]
					steps += ucmFac.createStep => [
						text = "Two"
					]
				]
				extensions += ucmFac.createScenario => [
					text = "Second branching of the variation"
					steps += ucmFac.createStep => [
						text = "Three"
					]
				]
			])
		]
	]
	
	
	@Test
	def parseBranching() {
		// tests parsing of the use case with more complicated branching 
		val actualModel = ucmLang2Ucm.transform(Collections.singletonList(uc5))
		ucmChecker.assertUseCaseModelEquals(ucmBranching, actualModel)
	}
	
	val uc7 = '''
		UC7 First prec. use case
		
		1 First step
	'''
	
	val uc2 = '''
		UC2 Generate city
		
		Preceding: UC7 xxxx

		1 First step
	'''
	
	val uc3 = '''
		UC3 Generate map
		
		Preceding: UC7, UC2 gen. city

		1 First step		
	'''
	
	var UseCase useCase7
	var UseCase useCase2
	var UseCase useCase3
	val ucmPreceding = ucmFac.createUseCaseModel => [
		useCase7 = ucmFac.createUseCase => [
			id = "UC7"
			name = "First prec. use case"
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "First step"
				]
			]
		]
		useCases += useCase7
		
		useCase2 = ucmFac.createUseCase => [
			id = "UC2"
			name = "Generate city"
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "First step"
				]
			]
			preceeded += useCase7
		]
		useCases += useCase2
		
		useCase3 = ucmFac.createUseCase => [
			id = "UC3"
			name = "Generate map"			
			mainScenario = ucmFac.createScenario => [
				steps += ucmFac.createStep => [
					text = "First step"
				]
			]
			preceeded += useCase7
			preceeded += useCase2
		]
		useCases += useCase3
	]
	
	@Test def parsePreceding() {
		// tests that preceding use cases were parsed and resolved correctly
		val actual = ucmLang2Ucm.transform(#[uc7, uc2, uc3])
		ucmChecker.assertUseCaseModelEquals(ucmPreceding, actual)
	}
	
	@Test def parseAnnotations() {
		val uc6 = '''
			UC6 Generate map
			
			1 First step #(first)
			2 Second 
			  step #(second:paramSecond1), #(third:paramThird1:paramThird2)
		'''
		
		val ucmAnnotations = ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC6"
				name = "Generate map"
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
						text = "First step"
						annotations += annotationFac.createUnknownAnnotation => [
							parts += "first"
						]
					]
					steps += ucmFac.createStep => [
						text = "Second step"
						annotations += annotationFac.createUnknownAnnotation => [
							parts += #["second", "paramSecond1"]
						]
						annotations += annotationFac.createUnknownAnnotation => [
							parts += #["third", "paramThird1", "paramThird2"]
						]
					]
				]
			]
		]
		
		// tests that annotations are parsed as UnknownAnnotation objects		
		// NOTE: UnknownAnnotation objects are replaced with flow or tadl annotations
		//       at later stage (not tested here).
		val actualModel = ucmLang2Ucm.transform(#[uc6])
		ucmChecker.assertUseCaseModelEquals(ucmAnnotations, actualModel)
	}
	
}
