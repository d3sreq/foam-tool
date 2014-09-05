package org.foam.transform.ucm.overview

import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.junit.Assert
import org.junit.Test
import org.foam.flowannotation.FlowannotationFactory

class UcmOverviewTest {
	
	extension UcmFactory = UcmFactory.eINSTANCE
	extension FlowannotationFactory = FlowannotationFactory.eINSTANCE

	UseCase ucA
	UseCase ucB
	UseCase ucC
	UseCase ucD
	
	val ucm = createUseCaseModel => [

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
	]
	
	val graph = new UcmOverviewCreator().transform(ucm)
	
	@Test def void testUcmOverviewCreator() {
		Assert.assertArrayEquals(#["A", "B", "C", "D"], graph.keySet.sort.toList)
	}
	
	@Test def void testPrecedes() {
		Assert.assertTrue(graph.get("A").precedes.empty)
		Assert.assertArrayEquals(#["A"], graph.get("B").precedes)
		Assert.assertArrayEquals(#["A", "B"], graph.get("C").precedes.sort.toList)
		Assert.assertTrue(graph.get("D").precedes.empty)
	}

	@Test def void testIncludes() {
		Assert.assertTrue(graph.get("A").includes.empty)
		Assert.assertArrayEquals(#["D"], graph.get("B").includes.sort.toList)
		Assert.assertTrue(graph.get("C").includes.empty)
		Assert.assertTrue(graph.get("D").includes.empty)
	}
}