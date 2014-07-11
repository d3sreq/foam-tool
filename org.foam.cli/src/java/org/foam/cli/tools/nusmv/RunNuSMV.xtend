package org.foam.cli.tools.nusmv

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.io.BufferedReader
import java.io.InputStreamReader
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.transform.utils.logger.LogServiceExtension
import org.foam.transform.utils.nusmv.NusmvWrapper
import org.osgi.service.log.LogService

@Component
class RunNativeNusmv implements IExecutableTool {
	
	private NusmvWrapper nusmvWrapper
	@Reference def void setNusmvWrapper(NusmvWrapper nusmvWrapper) {
		this.nusmvWrapper = nusmvWrapper
	}

	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	override execute(String[] args) {
		if(args.length != 1)
			throw new IllegalArgumentException("Input file expected as a single argument")

		val nusmvOut = nusmvWrapper.openNusmvProcess(args.head)
		val reader = new BufferedReader(new InputStreamReader(nusmvOut))
		
		var String line
		while((line = reader.readLine()) != null) {
			println(line)
		}
		
		nusmvWrapper.closeNusmvProcess

		"done".info
	}
	
	override getUsage() '''
	Executes the NuSMV model checker directly.
	(using the bundled executable binary file)
	'''
}