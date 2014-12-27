package org.foam.transform.utils.graphviz

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.Files
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.Map
import org.apache.log4j.Logger

@Component(provide = GraphvizWrapper)
class GraphvizWrapper {
	
	static extension Logger = Logger.getLogger(GraphvizWrapper)
	
	@Activate def final void activate(Map<String,Object> props) {
		'''Found GRAPHVIZ version: «graphvizVersion»'''.debug
	}

	/**
	 * @return not null
	 */
	def getGraphvizVersion() {
		val process = Runtime.runtime.exec( #["dot", "-V"] )
		val procstdout = process.errorStream
		val reader = new BufferedReader(new InputStreamReader(procstdout))
		val version = reader.readLine
		reader.close
		process.destroy
		
		if(version == null || ! version.contains("graphviz version")) {
			'''Graphviz version not found'''.error
			return "none"
		}

		return version
	}

	/**
	 * Executes the dot tool available on system PATH.
	 * 
	 * <p/>
	 * <b>Note:</b> the tool name "dot" is automatically used as a command to be executed.
	 * Only the arguments should be passed to this method.
	 * 
	 * @param dotCmdArgs A list of arguments for the dot tool
	 * 
	 */
	def void runGraphviz(Iterable<String> dotCmdArgs) {
		
		Preconditions.checkArgument(! dotCmdArgs.empty)
		Preconditions.checkArgument(
			dotCmdArgs.filter[equals("dot")].empty,
			"the string 'dot' is not allowed as an argument"
		)
		
		val String[] wholeCommand = #["dot"] + dotCmdArgs 
		if(debugEnabled) {
			'''Executing command: «wholeCommand.join(" ")»'''.debug
		}
		val returnCode = Runtime.runtime.exec( wholeCommand ).waitFor
		if(returnCode != 0) {
			val errorMessage = "Cannot run program. Error code " + returnCode 
			errorMessage.debug
			throw new IOException(errorMessage);
		}
	}
	
	/**
	 * Takes code written in DOT language and generated an SVG file
	 * using the binary "dot" executable available on system PATH.
	 * This function also creates all necessary directories for the
	 * generated SVG image.
	 */
	def void createSvg(CharSequence dotContent, String svgFileName) {
		
		Preconditions.checkNotNull(dotContent)
		Preconditions.checkNotNull(svgFileName)
		
		// create directory structure if needed
		val svgFile = new File(svgFileName)
		svgFile.parentFile.mkdirs

		Preconditions.checkArgument(svgFile.parentFile.exists)
		Preconditions.checkArgument(svgFile.parentFile.isDirectory)
		
		// TODO: use stdin instead of writing a file to the filesystem
		val dotFileName = '''«svgFileName».dot'''
		Files.write(dotContent, new File(dotFileName), Charsets.UTF_8) 
		
		#["-Tsvg", "-o", svgFileName, dotFileName].runGraphviz
		
		'''SVG image "«svgFile.name»" generated'''.info
	}
	
}