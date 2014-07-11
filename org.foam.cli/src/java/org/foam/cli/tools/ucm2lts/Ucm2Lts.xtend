package org.foam.cli.tools.ucm2lts

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.base.Preconditions
import joptsimple.OptionParser
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.flowannotation.FlowannotationPackage
import org.foam.lts.Automaton
import org.foam.lts.LtsPackage
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.tadl.TadlPackage
import org.foam.traceability.TraceabilityPackage
import org.foam.transform.ucm2lts.Ucm2LtsFacade
import org.foam.transform.ucm2lts.Ucm2LtsOverviewGraph
import org.foam.transform.utils.logger.LogServiceExtension
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.ucm.UcmPackage
import org.foam.ucm.UseCaseModel
import org.osgi.service.log.LogService

@Component
class Ucm2Lts implements IExecutableTool {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}
	
	override execute(String[] args) {
		val optionParser = new OptionParser
		val inputOption = optionParser.accepts("i", "input file").withRequiredArg.describedAs("input file with use case model")
		val outputOption = optionParser.accepts("o", "output file").withOptionalArg.describedAs("output file with LTS model")
		val singleUseCaseOption = optionParser.accepts("s", "single use case mode").withRequiredArg.describedAs("ID of the use case")
		val singleUseCaseForPageOption = optionParser.accepts("sp", "single use case for page mode").withRequiredArg.describedAs("ID of the use case")
		val overviewOption = optionParser.accepts("w", "overview mode")
		optionParser.acceptsAll(newArrayList("h", "?"), "show help")
		
		val options = optionParser.parse(args)
		
		// get input file name containing case model
		val inputFile = if (options.has(inputOption) && options.hasArgument(inputOption)) {
			inputOption.value(options)
		} else {			
			optionParser.printHelpOn(System::out)
			return
		}

		// get output file name to write LTS into
		val outputFile = if (options.has(outputOption) && options.hasArgument(outputOption)) {
			outputOption.value(options)
		} else {			
			"ltsModel.lts"
		}

		// initialization
		'''Initializing required meta-models'''.info
		
		UcmPackage.eINSTANCE.eClass
		FlowannotationPackage.eINSTANCE.eClass
		TraceabilityPackage.eINSTANCE.eClass
		LtsPackage.eINSTANCE.eClass
		PropositionallogicPackage.eINSTANCE.eClass
		TadlPackage.eINSTANCE.eClass
		EmfCommons.registerAsteriskInExtensionToFactory

		// read input
		'''Reading the input use-case model'''.info
		val useCaseModel = EmfCommons.readModel(inputFile) as UseCaseModel
		
		// validate
		'''Validating input use-case model'''.info
		EmfCommons.basicValidate(useCaseModel)
		
		// transform
		'''Running the transformation'''.info
		val automaton = if (options.has(overviewOption)) {
			transformOverview(useCaseModel)
		} else if (options.has(singleUseCaseOption)) {
			val ucId = if (options.hasArgument(singleUseCaseOption)) {
				singleUseCaseOption.value(options)
			} else {
				optionParser.printHelpOn(System.out)
				return
			}
			
			val uc = Preconditions.checkNotNull(
				useCaseModel.useCases.findFirst[it.id == ucId && it.primary], 
				'''Use case «ucId» not found in primary use cases'''
			)
			
			Ucm2LtsFacade.transformSingleUseCase(useCaseModel, uc)
			
		} else if (options.has(singleUseCaseForPageOption)) {
			val ucId = if (options.hasArgument(singleUseCaseForPageOption)) {
				singleUseCaseForPageOption.value(options)
			} else {
				optionParser.printHelpOn(System::out)
				return
			}
			val uc = Preconditions.checkNotNull(useCaseModel.useCases.findFirst[it.id == ucId && it.primary], 
					'''Use case «ucId» not found in primary use cases''')
			Ucm2LtsFacade.transformSingleUseCaseForPage(uc)
		} else {
			Ucm2LtsFacade.transformAllUseCases(useCaseModel)
		}
		
		// write output
		'''Writing the LTS representation to "«outputFile»"'''.info
		EmfCommons.writeModel(automaton, outputFile)
		
		"done".info
	}

	def private Automaton transformOverview(UseCaseModel useCaseModel) {
		(new Ucm2LtsOverviewGraph).transform(useCaseModel)
	}
	
	override getUsage() '''
	Converts an input use-case model (XMI) into an LTS model (XMI).
	'''
}