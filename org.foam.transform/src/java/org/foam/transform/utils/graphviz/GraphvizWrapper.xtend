package org.foam.transform.utils.graphviz

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.List
import org.foam.transform.utils.logger.LogServiceExtension
import org.osgi.service.log.LogService

@Component(provide = GraphvizWrapper)
class GraphvizWrapper {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	def getGraphvizVersion() {
		val process = Runtime.runtime.exec( newArrayList("dot", "-V") as String[] )
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

	def void runGraphviz(List<String> dotCommand) {
		Runtime.runtime.exec(dotCommand as String[]).waitFor
	}
}