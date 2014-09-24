package org.foam.cli.tools.ce2xmi

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import joptsimple.OptionParser
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.cntex.CntexPackage
import org.foam.flowannotation.FlowannotationPackage
import org.foam.lts.Automaton
import org.foam.lts.LtsPackage
import org.foam.tadl.TadlPackage
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.cntexlang2cntex.CntexLang2Cntex
import org.foam.transform.cntexlang2cntex.CntexStateResolver
import org.foam.transform.utils.osgi.LogServiceExtension
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.verification.VerificationPackage
import org.osgi.service.log.LogService

@Component
@Deprecated
class CounterExampleToXmi implements IExecutableTool {

	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	override execute(String[] args) {

		// parse options
		val optionParser = new OptionParser
		val inputCounterExampleOption = optionParser.accepts("i", "input file with NuSMV counter example in XML format").withRequiredArg.describedAs("NuSMV XML counter example")
		val inputLtsOption = optionParser.accepts("a", "input file with LTS automaton").withRequiredArg.describedAs("input LTS")
		val outputOption = optionParser.accepts("o", "output file with FOAM counter example").withRequiredArg.describedAs("foam counter example file")		

		val helpOption = optionParser.acceptsAll(newArrayList("h", "?"), "show help")
		
		val options = optionParser.parse(args)
		
		if (options.has(helpOption)) {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val inputCounterExampleFileName = if (options.has(inputCounterExampleOption) && options.hasArgument(inputCounterExampleOption)) {
			inputCounterExampleOption.value(options)
		} else {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val inputLtsFileName = if (options.has(inputLtsOption) && options.hasArgument(inputLtsOption)) {
			inputLtsOption.value(options)
		} else {
			optionParser.printHelpOn(System.out)
			return
		}
		
		val outputFileName = if (options.has(outputOption) && options.hasArgument(outputOption)) {
			outputOption.value(options)
		} else {			
			optionParser.printHelpOn(System.out)
			return			
		}
		
		// initialization
		'''Initializing required meta-models'''.info
		CntexPackage.eINSTANCE.eClass
		FlowannotationPackage.eINSTANCE.eClass
		LtsPackage.eINSTANCE.eClass
		TadlPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
		VerificationPackage.eINSTANCE.eClass
		EmfCommons.registerAsteriskInExtensionToFactory
		
		'''Reading input NuSMV counter example from file "«inputCounterExampleFileName»"'''.info
		val inputText = Files.toString(new File(inputCounterExampleFileName), Charsets.UTF_8)
		
		'''Reading input LTS from file "«inputLtsFileName»"'''.info
		val automaton = EmfCommons.readModel(inputLtsFileName) as Automaton
		
		// validation
		'''Validating input LTS'''.info
		EmfCommons.basicValidate(automaton)
		
		// transformation
		'''Running the transformation'''.info
		val transformation = new CntexLang2Cntex
		val counterExample = transformation.transform(inputText)
		
		// add links to Automaton
		val resolver = new CntexStateResolver
		resolver.transform(counterExample, automaton)
		
		// save output
		'''Writing the result FOAM countex example to "«outputFileName»"'''.info
		EmfCommons.writeModel(counterExample, outputFileName)
		
		"done".info
	}
	
	override getUsage() '''
	Converts the counter example from NuSMV's internal format XMI.
	'''
	
}