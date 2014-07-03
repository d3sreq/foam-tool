package org.foam.cli.tools.renderlts

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import joptsimple.OptionParser
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.dot.DotPackage
import org.foam.dot.Graph
import org.foam.flowannotation.FlowannotationPackage
import org.foam.lts.Automaton
import org.foam.lts.LtsPackage
import org.foam.tadl.TadlPackage
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.lts2dot.Lts2Dot
import org.foam.transform.utils.graphviz.GraphvizUtils
import org.foam.transform.utils.model.EmfCommons
import org.foam.verification.VerificationPackage
import org.osgi.service.log.LogService

@Component(enabled = false)
@Deprecated
class RenderLTS implements IExecutableTool {
	
	private static val XMI_OverviewGraphTemplate = "org/foam/cli/tools/renderlts/OverviewGraphTemplate.xmi"
	private static val XMI_GraphTemplate = "org/foam/cli/tools/renderlts/GraphTemplate.xmi"
	
	private LogService logService
	@Reference def void setLogService(LogService logService) {
		this.logService = logService
	}
	
	def info(CharSequence message) {
		logService.log(LogService.LOG_INFO, message.toString)
	}
	
	def debug(CharSequence message) {
		logService.log(LogService.LOG_DEBUG, message.toString)
	}
	
	override execute(String[] args) {
		
		// parse options
		val optionParser = new OptionParser
		val inputLtsOption = optionParser.accepts("i", "input file with lts").withRequiredArg.describedAs("lts file")
		val outputOption = optionParser.accepts("o", "output dot file").withRequiredArg.describedAs("dot file")
		val overviewOption = optionParser.accepts("w", "overview option")
		val pdfOption = optionParser.accepts("pdf", "also generate a PDF file")
		val pngOption = optionParser.accepts("png", "also generate a PNG file")
		val cmapxOption = optionParser.accepts("cmapx", "also generate an HTML image map")
		val htmlOption = optionParser.accepts("html", "also generate HTML with PNG + image map")

		val helpOption = optionParser.acceptsAll(#["h", "?"], "show help")
		
		val options = optionParser.parse(args)
		
		if (options.has(helpOption)) {
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
			'''«inputLtsFileName»output.dot'''			
		}
		
		// initialization
		'''Initializing required meta-models'''.info

		DotPackage.eINSTANCE.eClass
		LtsPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
		FlowannotationPackage.eINSTANCE.eClass
		VerificationPackage.eINSTANCE.eClass
		TadlPackage.eINSTANCE.eClass
		EmfCommons.registerAsteriskInExtensionToFactory
		
		// load models from files
		// use same ResourceSet to correctly resolve references between EObjects 
		// loaded from different files
		val resourceSet = new ResourceSetImpl
		
		'''Reading input LTS from file "«inputLtsFileName»"'''.info
		val automaton = EmfCommons.readModel(inputLtsFileName, resourceSet) as Automaton
		
		val isOverview = options.has(overviewOption)
		
		'''Reading configuration graph template from "conf/GraphTemplate.xmi"'''.info
		val initGraph = EmfCommons.readModel(
			if(isOverview) XMI_OverviewGraphTemplate else XMI_GraphTemplate
		) as Graph
		
		// validation
		'''Validating input LTS'''.info
		EmfCommons.basicValidate(automaton)
		
		'''Validating configuration graph template'''.info
		EmfCommons.basicValidate(initGraph)
		
		// transformation
		'''Running the transformation'''.info
		val lts2dot = new Lts2Dot		
		val graph = if (isOverview) {
			lts2dot.transformOverview(automaton, initGraph)
		} else {
			lts2dot.transform(automaton, initGraph)
		}
		
		val dot2Text= new Dot2DotLang
		val text = dot2Text.transform(graph)

		// save output
		'''Writing the result DOT code to "«outputFileName»"'''.info
		Files.write(text, new File(outputFileName), Charsets.UTF_8)

		val dotCommand = #[]
				
		if(options.has(pdfOption))
			dotCommand += #["-Tpdf", "-o", '''«outputFileName».pdf''']

		if(options.has(pngOption) || options.has(htmlOption))
			dotCommand += #["-Tpng", "-o", '''«outputFileName».png''']
		
		if(options.has(cmapxOption) || options.has(htmlOption))
			dotCommand += #["-Tcmapx", "-o", '''«outputFileName».cmapx''']

		if( ! dotCommand.empty ) {
	
			GraphvizUtils.checkGraphvizVersion

			dotCommand.add(0, "dot")
			dotCommand += outputFileName
			
			'''Running Graphviz DOT tool: «dotCommand.join(" ")»'''.info
			Runtime.runtime.exec(dotCommand).waitFor
		}
		
		if(options.has(htmlOption)) {
			
			'''Writing HTML to "«outputFileName».html"'''.info
			
			val imageMapContent = Files.readLines(new File('''«outputFileName».cmapx'''), Charsets.UTF_8).join("\n")
			Files.write('''
				<html>
				<body>
				<img src="«outputFileName».png" ismap="ismap" usemap="#mygraph"/>
				«imageMapContent»
				</body>
				</html>
			''', new File('''«outputFileName».html'''), Charsets.UTF_8)
		}
		
		"done".info
	}
	
	override getUsage() '''
	Converts a Labelled Transition System (LTS) stored in an XMI
	file into input format for the Graphviz DOT tool.
	'''
}