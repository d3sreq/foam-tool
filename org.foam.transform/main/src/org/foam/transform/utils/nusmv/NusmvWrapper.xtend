package org.foam.transform.utils.nusmv

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.CharStreams
import com.google.common.io.Files
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.Map
import java.util.regex.Pattern
import org.apache.log4j.Logger

/**
 * This service handles communication with the NuSMV tool
 * running as a separate process.
 * 
 * @author Viliam Simko
 */
@Component(provide = NusmvWrapper)
class NusmvWrapper {
	
	static extension Logger = Logger.getLogger(NusmvWrapper)

	//TODO:implement multiple ways of obtaining a path to the nusmv executable file
	val nusmvExecFile = "NuSMV"

	@Activate def final void activate(Map<String,Object> props) {
		'''Found NuSMV version: «nusmvVersion»'''.debug
	}

	val NUSMV_VERSION_PATTERN = Pattern.compile(".*NuSMV (\\S+).*")

	/**
	 * Returns NuSMV version or null in case of an error.
	 */
	def private getNusmvVersion() {
		
		val firstLine = runNusmvFile("-h").head ?: ""
		val matcher = NUSMV_VERSION_PATTERN.matcher(firstLine)

		if (! matcher.matches) {
			return null
		}

		return matcher.group(1)
	}

	def runNusmvCode(CharSequence nusmvCode) {
		val tempFile = File.createTempFile("nusmv-file", "")
		Files.write(nusmvCode, tempFile, Charsets.UTF_8)
		return runNusmvFile(tempFile.absolutePath)
	}
	
	/**
	 * Runs the NuSMV executable available on PATH.
	 * @return result from NuSMV or an empty list if NuSMV has crashed
	 */
	def runNusmvFile(String inputFileName) {
		
		Preconditions.checkArgument( ! inputFileName.nullOrEmpty, "Invalid input file given as an input for NuSMV" );
		
		val builder = new ProcessBuilder(nusmvExecFile, inputFileName)
		builder.redirectErrorStream(true)

		try {
			val process = builder.start
			val reader = new InputStreamReader(process.inputStream)
			
			return try {
				CharStreams.readLines(reader).map[replaceAll("WARNING \\*\\*\\*","***")]
			} finally {
				reader.close
				process.destroy
			}

		} catch(IOException e) {
			'''Could not run the NuSMV program. Make sure it is available on your PATH and is executable (e.g. on UNIX: chmod +x NuSMV)'''.error
			return emptyList
		}
		
	}
}