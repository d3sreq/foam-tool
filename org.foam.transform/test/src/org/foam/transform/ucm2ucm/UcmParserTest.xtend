package org.foam.transform.ucm2ucm

import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.text.StringWithOffset
import org.foam.ucmtext.UcmtextFactory
import org.junit.Assert
import org.junit.Test

import static org.foam.transform.ucm2ucm.UcmParser.*

class UcmParserTest {

	val parser = new UcmParser
	val ucmTextFac = UcmtextFactory.eINSTANCE
	
	private def createBlock(StringWithOffset header, StringWithOffset body) {
		ucmTextFac.createBlock => [
			it.header = header
			it.body = body
		]
	}
	
	@Test 
	def void testParseBlocks() {
		val data = createStringWithOffset( 
			'''
			  
			  
			UC1: Process Sale
			
			Main scenario:
			1 a 
			  b 
			2 c.
			
			unknown:
			
			''', 10)
			
		val expected = #[
			createBlock(createStringWithOffset("UC1", 16), createStringWithOffset("Process Sale", 21)),
			createBlock(createStringWithOffset("Main scenario", 35), createStringWithOffset("1 a \n  b \n2 c.", 50)),
			createBlock(createStringWithOffset("unknown", 66), createStringWithOffset("", 74))
		]
		val actual = parser.parseBlocks(data)
		Assert.assertTrue(EcoreUtil.equals(expected, actual.toList))
	}
	
	private def createUcIdDef(StringWithOffset id, StringWithOffset desc) {
		ucmTextFac.createUcIdDef => [
			it.id = id
			it.description = desc
		]
	}
	
	@Test
	def void testParsePreceded() {
		val data = createStringWithOffset("UC1 some description, UC2 another description  , UC3, UC4", 10)
		
		val expected = #[
			createUcIdDef(createStringWithOffset("UC1", 10), createStringWithOffset("some description", 14)),
			createUcIdDef(createStringWithOffset("UC2", 32), createStringWithOffset("another description", 36)),
			createUcIdDef(createStringWithOffset("UC3", 59), createStringWithOffset("", 62)),
			createUcIdDef(createStringWithOffset("UC4", 64), createStringWithOffset("", 67))
		]
		
		val actual = parser.parsePreceded(data)
		Assert.assertTrue(EcoreUtil.equals(expected, actual.toList))
	}
	
	@Test
	def void testParseScenarioDef_mainScenario() {
		val data = createStringWithOffset("1 Hello world!\n2 Hallo\n Welt!", 10)
		
		val expected = ucmTextFac.createScenarioDef => [
			steps += ucmTextFac.createStepDef => [
				it.label = createStringWithOffset("1", 10)
				it.text = createStringWithOffset("Hello world!", 12)
			]
			steps += ucmTextFac.createStepDef => [
				it.label = createStringWithOffset("2", 25)
				it.text = createStringWithOffset("Hallo\n Welt!", 27)
			]
		]
		
		val actual = parser.parseScenarioDef(data)
		Assert.assertTrue(EcoreUtil.equals(expected, actual))
	}
	
	@Test
	def void testParseAnnotations() {
		val data = createStringWithOffset("some text #(first) #(the:second) abc #(the third) text", 10)
		val expected = #[
			createStringWithOffset("#(first)", 20),
			createStringWithOffset("#(the:second)", 29),
			createStringWithOffset("#(the third)", 47)
		]
		val actual = parser.parseAnnotations(data)
		Assert.assertTrue(EcoreUtil.equals(expected, actual.toList))
	}
}