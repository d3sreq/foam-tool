package org.foam.cli.tools.nusmv

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Preconditions
import org.apache.log4j.Logger
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.transform.utils.nusmv.NusmvWrapper

@Component
class RunNativeNusmv implements IExecutableTool {
	
	static extension Logger = Logger.getLogger(RunNativeNusmv)

	private NusmvWrapper nusmvWrapper
	@Reference def void setNusmvWrapper(NusmvWrapper nusmvWrapper) {
		this.nusmvWrapper = nusmvWrapper
	}

	override execute(String[] args) {
		Preconditions.checkArgument(args.length == 1, "Input file expected as a single argument")
		nusmvWrapper.runNusmvFile(args.head).forEach[println(it)]
		"done".info
	}
	
	override getUsage() '''
	Executes the NuSMV model checker directly.
	(using the bundled executable binary file)
	'''
}