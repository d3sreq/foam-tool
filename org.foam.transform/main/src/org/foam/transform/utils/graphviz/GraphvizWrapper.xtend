package org.foam.transform.utils.graphviz

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.Files
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.Map
import org.apache.log4j.Logger

@Component(provide = GraphvizWrapper)
class GraphvizWrapper {
	
	static extension Logger = Logger.getLogger(GraphvizWrapper)
	
	@Activate def final void activate(Map<String,Object> props) {
		'''Found GRAPHVIZ version: «graphvizVersion»'''.info
	}

	def getGraphvizVersion() {
		val process = Runtime.runtime.exec( #["dot", "-V"] )
		val procstdout = process.errorStream
		val reader = new BufferedReader(new InputStreamReader(procstdout))
		val version = reader.readLine
		reader.close
		process.destroy
		
		if(version == null || ! version.contains("graphviz version")) {
			'''Graphviz version not found'''.error
			return null
		}

		return version
	}

	def void runGraphviz(Iterable<String> dotCmdArgs) {
		if(debugEnabled) {
			'''Executing: "«dotCmdArgs.join(" ")»"'''.debug
		}
		Runtime.runtime.exec(dotCmdArgs).waitFor
	}
	
	def void createSvg(CharSequence dotContent, String absoluteSvgFileName) {
		
		Preconditions.checkNotNull(dotContent)
		Preconditions.checkNotNull(absoluteSvgFileName)
		
		// create directory structure if needed
		val svgFile = new File(absoluteSvgFileName)
		Preconditions.checkArgument(svgFile.isAbsolute)
		svgFile.parentFile.mkdirs

		Preconditions.checkArgument(svgFile.parentFile.exists)
		Preconditions.checkArgument(svgFile.parentFile.isDirectory)
		
		// TODO: use stdin instead of writing a file to the filesystem
		val dotFileName = '''«absoluteSvgFileName».dot'''
		Files.write(dotContent, new File(dotFileName), Charsets.UTF_8) 
		
		#["dot", "-Tsvg", "-o", absoluteSvgFileName, dotFileName].runGraphviz
		
		'''SVG image "«svgFile.name»" generated'''.info
	}
	
}