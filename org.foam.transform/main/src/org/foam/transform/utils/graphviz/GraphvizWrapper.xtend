package org.foam.transform.utils.graphviz

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Map
import org.foam.transform.utils.logger.LogServiceExtension
import org.osgi.service.log.LogService

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
}