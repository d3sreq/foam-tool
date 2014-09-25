package org.foam.transform.utils.graphviz

import static junit.framework.Assert.*
import org.junit.Test
import java.io.IOException

class GraphvizWrapperTest {
	
	extension GraphvizWrapper = new GraphvizWrapper
	
	@Test def void testGraphvizVersion() {
		assertNotNull(graphvizVersion)
		assertTrue( graphvizVersion.startsWith("dot - graphviz version") )
	}
	
	@Test def void testRunGraphviz() {

		// this should succeed without throwing any IOException
		runGraphviz( #["dot", "-V"] )
		
		// this should thrown and exception
		try {
			runGraphviz( #["this-should-fail"] )
			fail
		} catch(IOException e) {
			assertTrue(e.message.startsWith("Cannot run program"))
		}
	}
}