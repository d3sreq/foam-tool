package org.foam.transform.utils.nusmv

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.base.Preconditions
import com.google.common.io.Files
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.Map
import java.util.regex.Pattern
import org.foam.transform.utils.logger.LogServiceExtension
import org.osgi.service.log.LogService
import java.util.function.IntFunction

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
	val nusmvExecFile = "/home/vlx/Apps/NuSMV-zchaff-2.5.4-x86_64-unknown-linux-gnu/bin/NuSMV"

	@Activate
	def final void activate(Map<String,Object> props) {
		'''Found NuSMV version «nusmvVersion»'''.info
	}

	val NUSMV_VERSION_PATTERN = Pattern.compile(".*NuSMV (\\S+).*")

	/**
	 * Returns NuSMV version or null in case of an error.
	 */
	def getNusmvVersion() {
		
		val firstLine = runNusmvFile("-h").head
		
		val matcher = NUSMV_VERSION_PATTERN.matcher(firstLine)
		
		if (firstLine == null || ! matcher.matches) {
			return null
		}

		return matcher.group(1)
	}

	def runNusmvCode(CharSequence nusmvCode) {
		val tempFile = File.createTempFile("nusmv-file", "")
		Files::write(nusmvCode, tempFile, Charsets.UTF_8)
		return runNusmvFile(tempFile.absolutePath)
	}
	
	def runNusmvFile(String inputFileName) {
		Preconditions.checkArgument( ! inputFileName.nullOrEmpty, "Invalid input file given as an input for NuSMV" );
		
		val builder = new ProcessBuilder(nusmvExecFile, inputFileName)
		builder.redirectErrorStream(true)
		val process = builder.start
		
		val reader = new BufferedReader(new InputStreamReader(process.inputStream))
		
		val result = reader
			.lines
			.map[replaceAll("WARNING \\*\\*\\*","***")]
			.<String>toArray([<String>newArrayOfSize(it)])
			
		reader.close
		process.destroy
		
		return result
	}

//	/**
//	 * Starts a new NuSMV process and creates an InputStream for sending data to NuSMV.
//	 * This operation requires closeNusmvProcess()
//	 */
//	def openNusmvProcess(String inputFileName) {
//		
//		Preconditions.checkArgument( ! inputFileName.nullOrEmpty, "Invalid input file given as an input for NuSMV" );
//		Preconditions.checkArgument(process == null, "Running multiple NuSMV processes is not allowed");
//		
//		process = Runtime
//			.getRuntime
//			.exec( #[nusmvExecFile, inputFileName] );
//
//		// Printing error messages from NuSMV in a separate thread
//		new Thread([/* require zero parameters */|
//			val reader = new BufferedReader(new InputStreamReader(process.errorStream))
//			reader.lines.forEach[error]
//			reader.close
//		]).start
//		
//		// STDIN of the NuSMV process will be closed
//		process.outputStream.close 
//		return process.inputStream
//	}
//
//	/**
//	 * Closes the InputStream to the running NuSMV process and waits for NuSMV to finish.
//	 */
//	def closeNusmvProcess() {
//		process.inputStream.close //TODO:check memleaks and races
//		process.waitFor
//	}
}