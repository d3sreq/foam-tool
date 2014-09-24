package org.foam.transform.utils.graphviz

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Map
import org.foam.transform.utils.osgi.LogServiceExtension
import org.osgi.service.log.LogService
import java.io.File
import com.google.common.io.Files
import com.google.common.base.Charsets

@Component(provide = GraphvizWrapper)
class GraphvizWrapper {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}
	
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
		Runtime.runtime.exec(dotCmdArgs).waitFor
	}
	
	// TODO: use stdin instead of writing a file to the filesystem
	def void createSvg(CharSequence dotContent, String svgFileName) {
		
		// create directory structure if needed
		new File(svgFileName).parentFile.mkdirs
		
		// write dot to file
		val dotFileName = '''«svgFileName».dot'''
		Files.write(dotContent, new File(dotFileName), Charsets.UTF_8) 
		
		val dotCommand = #["dot", "-Tsvg", "-o", svgFileName, dotFileName]
		
		'''Creating svg image with dot: "«dotCommand.join(" ")»"'''.info
		runGraphviz(dotCommand)
	}
	
}