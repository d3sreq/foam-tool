package org.foam.transform.junit.utils

import static org.junit.Assert.*

class TestUtils {
	
	def static assertLinesEqual(CharSequence expected, CharSequence actual) {

		val EOL = "\r?\n"
		
		assertArrayEquals(
			expected.toString.split(EOL),
			actual.toString.split(EOL)
		)
	}

}