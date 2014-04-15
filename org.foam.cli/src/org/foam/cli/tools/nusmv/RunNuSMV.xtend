package org.foam.cli.tools.nusmv

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import org.foam.cli.launcher.api.IExecutableTool

@Component
class RunNativeNusmv implements IExecutableTool {
	
	private NusmvWrapper nusmvWrapper
	@Reference def void setNusmvWrapper(NusmvWrapper nusmvWrapper) {
		this.nusmvWrapper = nusmvWrapper
	}
	
	override execute(String[] args) {
		if(args.length != 1) {
			println("Input file expected as a single argument.")
			println(usage)
			return
		}

		val inputFileName = args.head
		println('''here we should run the nusmv process using the given input file "«inputFileName»"''')
		
		throw new UnsupportedOperationException("TODO: not yet implemented")
	}
	
	override getUsage() '''
	Executes the NuSMV model checker directly.
	(using the bundled executable binary file)
	'''
}