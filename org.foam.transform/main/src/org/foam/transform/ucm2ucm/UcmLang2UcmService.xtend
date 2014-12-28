package org.foam.transform.ucm2ucm

import aQute.bnd.annotation.component.Component
import java.util.Collection
import org.apache.log4j.Logger
import org.foam.text.StringWithOffset
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCaseModel

@Component(provide = UcmLang2UcmService)
class UcmLang2UcmService {

	static extension Logger = Logger.getLogger(UcmLang2UcmServiceOld)
	
	val usecaseFactory = UcmFactory.eINSTANCE
//	val traceFactory = Traceability_ucm_textFactory.eINSTANCE
//	val blockParser = new BlockParser
	
	def UseCaseModel transform(Iterable<? extends CharSequence> texts) {
//		// container for saved strings with offsets
//		val stringStorage = new BasicEList<StringWithOffset>
//		val traces = traceFactory.createUcmToTextTraces
//		
//		// pairs connecting use case with original blocks
//		val pairs = texts.map[usecaseFactory.createUseCase -> blockParser.parse(it)]
//		
//		// parse use case name
//		val nameToPair = pairs.map[
//			val uc = it.key
//			val blocks = it.value
//			
//			val stringWithOffset = blocks.findName
//			if (stringWithOffset == null) {
//				// TODO - add error
//				return null
//			} else {
//				uc.name = stringWithOffset.content
//				traces.useCaseNames.put(uc, stringWithOffset)
//				stringWithOffset.content -> it
//			}
//		].filterNull
		
		
//		val blocks = texts.map[blockParser.parse(it)]
		
		// get names and store mapping from name to use case 
		// to quickly resolve precedence in next step		
//		val nameToBlocks = blocks.map[
//		]
		
//		val errors = pairs.map[addName(it.key, it.value)].flatten
		
//		usecaseFactory.createUseCaseModel => [
//			it.useCases += pairs.map[key]
//		]

		val useCaseModel = usecaseFactory.createUseCaseModel
		useCaseModel
	}
	
//	private def StringWithOffset findName(Iterable<Block> blocks) {
//		 blocks.findFirst[it.header.content.matches("UC\\d+")]?.header
//	}
	
	// Trace links from ucm model to "block" model:
	// - name: use case -> block
	// - preceding: use case -> block (tricky - in case of error I will have to go trough all the included blocks)
	//   TODO: - block must include additional "sub-blocks"
	// - scenario label: scenario -> string with offset
	// - step label: step -> string with offset
	// - annotation: annotation -> string with offset
	
	// - step label -> step/condition label offset
	// - annotation -> annotation position
	// - use case identifier position
	// - precedes
	//
	// Mapping from list of blocks to URI of the original text 
	// mapping:
	// 
	
	// text {
	//   id block {
	//   
	//   }
	// }
}

class Error {
	
}

class ParseResult {
	val stringsWithOffsets = <StringWithOffset>newArrayList
}

//  