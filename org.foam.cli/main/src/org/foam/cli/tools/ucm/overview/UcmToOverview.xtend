package org.foam.cli.tools.ucm.overview

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Preconditions
import java.io.StringWriter
import joptsimple.OptionParser
import org.apache.log4j.Logger
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.transform.ucm.overview.dot.UcmOverviewUsingDot
import org.foam.transform.utils.graphviz.GraphvizWrapper
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.ucm.UseCaseModel

@Component
class UcmToOverview implements IExecutableTool {
	
	static extension Logger = Logger.getLogger(UcmToOverview)

	private UcmOverviewUsingDot ucmOverviewUsingDot
	@Reference def void setUcmOverviewCreator(UcmOverviewUsingDot ucmOverviewUsingDot) {
		this.ucmOverviewUsingDot = ucmOverviewUsingDot
	}
	
	private GraphvizWrapper graphvizWrapper
	@Reference def void setGraphvizWrapper(GraphvizWrapper graphvizWrapper) {
		this.graphvizWrapper = graphvizWrapper
	}

	val optionParser = new OptionParser => [
		acceptsAll(#["h", "?"], "show help")
	]
	
	val inputOption = optionParser.accepts("i", "input file").withRequiredArg.describedAs("input file with use case model")
	val outputOption = optionParser.accepts("o", "output file").withOptionalArg.describedAs("output file where the generated SVG file be stored")
	
	override getUsage() {
		val buf = new StringWriter
		buf.append("Converts an input use-case model (XMI) into an LTS model (XMI).\n")
		buf.append("Options:\n")
		optionParser.printHelpOn(buf)
		return buf.toString
	}
	
	override execute(String[] args) {
		
		val options = optionParser.parse(args)
		
		Preconditions.checkArgument(options.has(inputOption))
		Preconditions.checkArgument(options.hasArgument(inputOption))

		// get input file name containing case model
		val inputFile = inputOption.value(options)

		// get output file name to write LTS into
		val outputFile = if (options.has(outputOption) && options.hasArgument(outputOption)) {
			outputOption.value(options)
		} else {
			"output.svg"
		}

		'''Reading the input use-case model'''.info
		val useCaseModel = EmfCommons.readModel(inputFile) as UseCaseModel
		
		'''Validating input use-case model'''.info
		EmfCommons.basicValidate(useCaseModel)

		'''Transformation UCM -> DOT'''.info
		val dotContents = ucmOverviewUsingDot.transform(useCaseModel)

		// write output
		'''Writing SVG file to "«outputFile»"'''.info
		graphvizWrapper.createSvg(dotContents, outputFile)
		
		"done".info
	}
	
}