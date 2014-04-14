package utils.graphviz

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.List

class GraphvizUtils {
	
	def static String checkGraphvizVersion() {
		val process = Runtime::runtime.exec( newArrayList("dot", "-V") as String[] )
		val procstdout = process.errorStream
		val reader = new BufferedReader(new InputStreamReader(procstdout))
		val version = reader.readLine
		reader.close
		process.destroy
		
		if(version == null || ! version.contains("graphviz version"))
			throw new GraphvizNotFoundException("Grapviz version not found")

		version
	}
	
	def static void runGraphviz(List<String> dotCommand) {
		Runtime::runtime.exec(dotCommand as String[]).waitFor
	}
}

class GraphvizNotFoundException extends RuntimeException {
	new(String message) {
		super(message)
	}
}