package org.foam.transform.utils.nusmv

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.CharStreams
import com.google.common.io.Files
import java.io.File
import java.io.InputStreamReader
import java.util.Map
import java.util.regex.Pattern
import org.foam.transform.utils.osgi.LogServiceExtension
import org.osgi.service.log.LogService

/**
 * This service handles communication with the NuSMV tool
 * running as a separate process.
 * 
 * @author Viliam Simko
 */
@Component(provide = NusmvWrapper)
class NusmvWrapper {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	//TODO:implement multiple ways of obtaining a path to the nusmv executable file
	val nusmvExecFile = "NuSMV"

	@Activate def final void activate(Map<String,Object> props) {
		'''Found NuSMV version: «nusmvVersion»'''.info
	}

	val NUSMV_VERSION_PATTERN = Pattern.compile(".*NuSMV (\\S+).*")

	/**
	 * Returns NuSMV version or null in case of an error.
	 */
	def private getNusmvVersion() {
		
		val firstLine = runNusmvFile("-h").head
		
		val matcher = NUSMV_VERSION_PATTERN.matcher(firstLine)
		
		if (firstLine == null || ! matcher.matches) {
			return null
		}

		return matcher.group(1)
	}

	def runNusmvCode(CharSequence nusmvCode) {
		val tempFile = File.createTempFile("nusmv-file", "")
		Files.write(nusmvCode, tempFile, Charsets.UTF_8)
		return runNusmvFile(tempFile.absolutePath)
	}
	
	def runNusmvFile(String inputFileName) {
		Preconditions.checkArgument( ! inputFileName.nullOrEmpty, "Invalid input file given as an input for NuSMV" );
		
		val builder = new ProcessBuilder(nusmvExecFile, inputFileName)
		builder.redirectErrorStream(true)
		val process = builder.start

		val reader = new InputStreamReader(process.inputStream)
		val result = CharStreams.readLines(reader)
						.map[replaceAll("WARNING \\*\\*\\*","***")]
		process.destroy
		
		return result
	}
}