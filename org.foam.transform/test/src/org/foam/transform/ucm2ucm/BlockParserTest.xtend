package org.foam.transform.ucm2ucm

import org.junit.Assert
import org.junit.Test

class BlockParserTest {

	val parser = new BlockParser
	
	@Test def void testNormal() {
		val data = '''
		  
		  
		UC1: Process Sale
		
		Main scenario:
		1 a 
		  b 
		2 c.
		
		unknown:
		
		'''
		
		val expected = #[
			new Block(new StringWithOffset("UC1", 6), new StringWithOffset("Process Sale", 11)),
			new Block(new StringWithOffset("Main scenario", 25), new StringWithOffset("1 a \n  b \n2 c.", 40)),
			new Block(new StringWithOffset("unknown", 56), new StringWithOffset("", 64))
		]
		
		val actual = parser.parse(data)
		
		Assert.assertArrayEquals(expected, actual)
	}
	
}