package org.foam.cli.tools.lts2nusmv

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.io.PrintWriter
import joptsimple.OptionParser
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.ctl.CtlPackage
import org.foam.flowannotation.FlowannotationPackage
import org.foam.ltl.LtlPackage
import org.foam.lts.Automaton
import org.foam.lts.LtsPackage
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.tadl.TadlPackage
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.utils.osgi.LogServiceExtension
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.verification.VerificationPackage
import org.osgi.service.log.LogService
import org.foam.transform.lts2nusmvlang.Lts2NusmvLangService

@Component
@Deprecated
class LtsToNusmv implements IExecutableTool {

	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	private Lts2NusmvLangService lts2NuSMVLangService
	@Reference def void setLts2NuSMVLangService(Lts2NusmvLangService serviceRef) {
		this.lts2NuSMVLangService = serviceRef
	}

	override execute(String[] args) {
		
		// parse options
		val optionParser = new OptionParser
		val inputOption = optionParser.accepts("i", "input lts file").withRequiredArg.describedAs("input file with LTS model")
		val outputOption = optionParser.accepts("o", "output nusmv file").withOptionalArg.describedAs("output file with NuSMV code")
		optionParser.acceptsAll(#["h", "?"], "show help")
		
		val options = optionParser.parse(args)
		
		val inputFileName = if (options.has(inputOption) && options.hasArgument(inputOption)) {
			inputOption.value(options)
		} else {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val outputFileName = if (options.has(outputOption) && options.hasArgument(outputOption)) {
			outputOption.value(options)
		} else '''«inputFileName».nusmv'''
		
		// initialization
		'''Initializing required meta-models'''.info

		LtsPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
		FlowannotationPackage.eINSTANCE.eClass
		VerificationPackage.eINSTANCE.eClass
		TadlPackage.eINSTANCE.eClass
		LtlPackage.eINSTANCE.eClass
		CtlPackage.eINSTANCE.eClass
		PropositionallogicPackage.eINSTANCE.eClass
		EmfCommons.registerAsteriskInExtensionToFactory

		// read lts model
		'''Reading the input LTS model from "«inputFileName»"'''.info
		val automaton = EmfCommons.readModel(inputFileName) as Automaton
		
		'''Validating input LTS model'''.info
		EmfCommons.basicValidate(automaton)

		'''Running the transformation'''.info
		val result = lts2NuSMVLangService.transform(automaton)
		
		// write nusmv code to output stream 
		'''Writing the result NuSMV code to "«outputFileName»"'''.info
		val pw = new PrintWriter(outputFileName)
		pw.print(result)
		pw.close
		
		"done".info
	}
	
	override getUsage() '''
	Converts Labelled Transition System (LTS) stored
	in an XMI file into input for the NuSMV model checker.
	'''
}