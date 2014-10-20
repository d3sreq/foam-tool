package org.foam.transform.utils.graphviz

import static junit.framework.Assert.*
import org.junit.Test
import java.io.IOException
import org.junit.Ignore

// Tests added to ignore - running them at compile time makes little sense
// as they only discover whether build server has or has not graphviz
// installed.
//
// They should be executed at test environment.
@Ignore
class GraphvizWrapperTest {
	
	extension GraphvizWrapper = new GraphvizWrapper
	
	@Test def void testGraphvizVersion() {
		assertNotNull(graphvizVersion)
		assertTrue( graphvizVersion.startsWith("dot - graphviz version") )
	}
	
	@Test def void testRunGraphviz() {

		// this should succeed without throwing any IOException
		#["-V"].runGraphviz
		
		// this should thrown and exception
		try {
			runGraphviz(#["this-should-fail"])
			fail
		} catch(IOException e) {
			assertTrue(e.message.startsWith("Cannot run program"))
		}
	}
}