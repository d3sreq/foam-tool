package org.foam.transform.ucm2ucm

import org.eclipse.xtext.EcoreUtil2
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
			
			''', 0)
			
		val expected = #[
			createBlock(createStringWithOffset("UC1", 6), createStringWithOffset("Process Sale", 11)),
			createBlock(createStringWithOffset("Main scenario", 25), createStringWithOffset("1 a \n  b \n2 c.", 40)),
			createBlock(createStringWithOffset("unknown", 56), createStringWithOffset("", 64))
		]
		val actual = parser.parseBlocks(data)
		Assert.assertTrue(EcoreUtil2.equals(expected, actual.toList))
	}
	
	private def createUcIdDef(StringWithOffset id, StringWithOffset desc) {
		ucmTextFac.createUcIdDef => [
			it.id = id
			it.description = desc
		]
	}
	
	@Test
	def void testParsePreceded() {
		val data = createStringWithOffset("UC1 some description, UC2 another description  , UC3, UC4", 0)
		
		val expected = #[
			createUcIdDef(createStringWithOffset("UC1", 0), createStringWithOffset("some description", 4)),
			createUcIdDef(createStringWithOffset("UC2", 22), createStringWithOffset("another description", 26)),
			createUcIdDef(createStringWithOffset("UC3", 49), createStringWithOffset("", 52)),
			createUcIdDef(createStringWithOffset("UC4", 54), createStringWithOffset("", 57))
		]
		
		val actual = parser.parsePreceded(data)
		Assert.assertTrue(EcoreUtil2.equals(expected, actual.toList))
	}
	
	@Test
	def void testParseScenarioDef_mainScenario() {
		val data = createStringWithOffset("1 Hello world!\n2 Hallo\n Welt!", 0)
		
		val expected = ucmTextFac.createScenarioDef => [
			steps += ucmTextFac.createStepDef => [
				it.label = createStringWithOffset("1", 0)
				it.text = createStringWithOffset("Hello world!", 2)
			]
			steps += ucmTextFac.createStepDef => [
				it.label = createStringWithOffset("2", 15)
				it.text = createStringWithOffset("Hallo\n Welt!", 17)
			]
		]
		
		val actual = parser.parseScenarioDef(data)
		Assert.assertTrue(EcoreUtil2.equals(expected, actual))
	}
}