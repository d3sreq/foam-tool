package utils.nusmv

import com.google.common.base.Charsets
import com.google.common.io.CharStreams
import com.google.common.io.Files
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.regex.Pattern

class NuSmvUtils {
	
	private static val nusmvVersionPattern = Pattern::compile(".*NuSMV (\\S+).*")
	
	def static String checkNuSmvVersion() {
		val builder = new ProcessBuilder("nusmv", "-h")
		builder.redirectErrorStream(true)
		val process = builder.start
		
		val reader = new BufferedReader(new InputStreamReader(process.inputStream))
		// match NuSMV version
		val line = reader.readLine
		val matcher = nusmvVersionPattern.matcher(line)
		reader.close
		process.destroy
		
		if (line == null || !matcher.matches) {
			throw new NuSmvNotFoundException("NuSMV version not found")
		}

		matcher.group(1)
	}
	
	def static String runNuSMV(CharSequence nusmvCode) {
		val tempFile = File::createTempFile("nusmv-file", "")
		Files::write(nusmvCode, tempFile, Charsets::UTF_8)
		
		val builder = new ProcessBuilder("nusmv", tempFile.absolutePath)
		builder.redirectErrorStream(true)
		val process = builder.start
		
		val reader = new BufferedReader(new InputStreamReader(process.inputStream))
		val result = CharStreams::toString(reader).replaceAll("\nWARNING \\*\\*\\*","***")
		
		reader.close
		process.destroy
		
		result
	}

}

class NuSmvNotFoundException extends RuntimeException {
	new(String message) {
		super(message)
	}
}