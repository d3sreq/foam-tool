package org.foam.transform.ucm2ucm

import java.io.IOException
import java.util.Collections
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.foam.bootstrap.IterableExtensions
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
		
		Assert.assertTrue("Actual UseCaseModel doesn't match the actual one", EcoreUtil.equals(expectedUcm, result.key))
		// annotations, bc, precedence, primary = null
		// names = 1, steps = 2
		
		Assert.assertTrue("1", EcoreUtil.equals(expectedTrace.annotations, result.value.annotations))
		Assert.assertTrue("2", EcoreUtil.equals(expectedTrace.branchingConditions, result.value.branchingConditions))
		Assert.assertTrue("3", EcoreUtil.equals(expectedTrace.names, result.value.names))
		Assert.assertTrue("4", EcoreUtil.equals(expectedTrace.precedenceDef, result.value.precedenceDef))
		Assert.assertTrue("5", EcoreUtil.equals(expectedTrace.primaryDef, result.value.primaryDef))
		Assert.assertTrue("6", EcoreUtil.equals(expectedTrace.steps, result.value.steps))
		
//		result.value.eAllContents.forEach[println(it)]
//		println
//		expectedTrace.eAllContents.forEach[println(it)]
		
//		IterableExtensions
//			.zip(result.value.eAllContents.toList, expectedTrace.eAllContents.toList)
//			.forEach[println(EcoreUtil.equals(key, value))]
	
		val fst = result.key.useCases.head
		val snd = result.value.names.map.head.key
		
//		println(result.key.useCases.head)
//		println(result.value.names.map.head.key)
		println(fst == snd)
		
//		val reg = Resource.Factory.Registry.INSTANCE;
//	    val m = reg.getExtensionToFactoryMap();
//	    m.put("test", new XMIResourceFactoryImpl());
//	
//	    // Obtain a new resource set
//	    val resSet = new ResourceSetImpl();
	
//	    // create a resource
//	    val resourceExpected = resSet.createResource(URI
//	        .createURI("/home/jirka/tmp/expected.test"));
//	    // Get the first model element and cast it to the right type, in my
//	    // example everything is hierarchical included in this first node
//	    resourceExpected.getContents().add(expectedUcm);
//	    resourceExpected.getContents().add(data)
//	    resourceExpected.getContents().add(expectedTrace);
//	
//		
//		
//	    // now save the content.
//	    try {
//	      resourceExpected.save(Collections.EMPTY_MAP);
//	    } catch (IOException e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    }
		
//		val resourceActual = resSet.createResource(URI
//	        .createURI("/home/jirka/tmp/actual.test"));
//		resourceActual.getContents().add(result.key);
//		resourceActual.getContents().add(data)
//		resourceActual.getContents().add(result.value);
//		
//		try {
//	      resourceActual.save(Collections.EMPTY_MAP);
//	    } catch (IOException e) {
//	      // TODO Auto-generated catch block
//	      e.printStackTrace();
//	    }
		
//		println('''result: «result.value.eAllContents.size»''')
//		println('''expected: «expectedTrace.eAllContents.size»''')
		
//		println ("cl1: " + result.value.class)
//		println ("cl2: " + expectedTrace.class)
		
//		Assert.assertTrue("Actual UcmToUcmtextTrace doesn't match the actual one", EcoreUtil.equals(expectedTrace, result.value))

//		Assert.assertTrue("test", EcoreUtil.equals(ucmTraceFac.createUcmToUcmtextTrace, ucmTraceFac.createUcmToUcmtextTrace))
	}
}