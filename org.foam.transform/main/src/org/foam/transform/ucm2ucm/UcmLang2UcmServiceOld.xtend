package org.foam.transform.ucm2ucm

import aQute.bnd.annotation.component.Component
import com.google.common.base.Splitter
import com.google.common.collect.HashMultimap
import com.google.common.collect.Lists
import com.google.common.collect.Multimap
import java.text.ParseException
import java.util.HashMap
import java.util.LinkedList
import java.util.List
import java.util.regex.Pattern
import org.apache.log4j.Logger
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.foam.annotation.Annotation
import org.foam.annotation.AnnotationFactory
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel

public enum BranchingType {
	Extension, Variation
}

@Component(provide = UcmLang2UcmServiceOld)
class UcmLang2UcmServiceOld {

	static extension Logger = Logger.getLogger(UcmLang2UcmServiceOld)

	val usecaseFactory = UcmFactory.eINSTANCE
	val annotationFactory = AnnotationFactory.eINSTANCE
	
	static private val PRECEDING_PREFIX = "Preceding:"

	static private val UC_ID_REGEXP = '''(UC\d+)[:.]?'''

	static private val UC_ID_PATTERN = Pattern.compile(UC_ID_REGEXP);
	static private val UC_IDANDNAME_PATTERN = Pattern.compile(UC_ID_REGEXP + "\\s+(.*)")
	static private val PRIMARY_UC_PATTERN = Pattern.compile('''Primary:\s+(\w+)''')
	static private val ANNOTATION_PATTERN = Pattern.compile('''#\(([^)]*)\)''')
	static private val BRANCHING_LABELED_ANNOTATED_TEXT_PATTERN = Pattern.compile('''(\w+):\s+(.*)''')
	static private val LABEL_AND_REST_PATTERN = Pattern.compile('''(\d\w*)[.]?\s+(.*)''')

	def UseCaseModel transform(Iterable<? extends CharSequence> texts) {
		usecaseFactory.createUseCaseModel => [
			
			val precedingMap = HashMultimap.<UseCase, String>create
			
			for (text : texts) {		
				parseUseCase(text, it, precedingMap)
			}
			
			'''Collected use-cases: «useCases.map[id].join(", ")»'''.debug

			resolvePreceding(precedingMap, it)
		]	
	}
	
	def private resolvePreceding(Multimap<UseCase, String> precedingMap, UseCaseModel useCaseModel) {
		'''Resolving precedence relation'''.debug
		val allUseCases = useCaseModel.useCases 
		val id2UseCase = new HashMap<String, UseCase>
		allUseCases.forEach[id2UseCase.put(it.id, it)]
		
		for(entry : precedingMap.entries) {			
			val precedingUseCase = id2UseCase.get(entry.value)
			val useCase = entry.key
			
			useCase.preceeded += precedingUseCase
		}
	}
	
	@Deprecated // TODO: Jirka should implement the new parser for textual representation of a use-case
	def private parseUseCase(CharSequence text, UseCaseModel useCaseModel, Multimap<UseCase, String> precedingMap) {
		val useCase = usecaseFactory.createUseCase
		useCaseModel.useCases += useCase
		
		val splitter = Splitter.on('\n').trimResults
		val lines = Lists.newLinkedList(splitter.split(text))
		
		// ID, name
		val idAndName = lines.parseIdAndName 
		useCase.id = idAndName.id
		useCase.name = idAndName.name
		
		'''Found use-case "«useCase.id»: «useCase.name»"'''.info

		// primary
		useCase.primary = parseIsPrimary(lines)
		
		// preceding
		precedingMap.putAll(useCase, parsePreceding(lines))

		// main scenario		
		useCase.mainScenario = parseScenario(lines, "")
		
		val labelToStep = new HashMap<String, Step>
		useCase.mainScenario.steps.forEach[labelToStep.put(it.label, it)]
		
		// branching
		while (!lines.empty) {
			val branching = parseBranching(lines)
			val prefix = branching.labeledAnnotatedText.label
			
			// prefix "1a1b" - find in current use case step with label
			// "1a1" and make sure that labels after adding match
			if (!prefix.matches("(\\d+[a-z])+")) {
				throw new ParseException('''Unable to parse branching prefix: «prefix»''', -1)
			}
			
			val stepLabel = prefix.substring(0, prefix.length - 1)
			if (!labelToStep.containsKey(stepLabel)) {
				throw new ParseException('''Cannot find step with label «stepLabel»''', -1)
			}
			
			val step = labelToStep.get(stepLabel)
			
			// get scenarioHolder of the branching step
			if (!useCase.branches.keySet.contains(step)) {
				val holder = usecaseFactory.createScenarioHolder
				useCase.branches.put(step, holder)
			}			
			val scenarioHolder = useCase.branches.get(step)
			
			val scenario = parseScenario(lines, prefix)
			scenario.text = branching.labeledAnnotatedText.annotatedText.text
			
			// add scenario to scenarioHolder
			if (branching.branchingType == BranchingType.Extension) {
				scenarioHolder.extensions += scenario
			} else {
				scenarioHolder.variations += scenario
			}
			
			// check label of the added scenario
			if (prefix != scenario.label) {
				throw new ParseException('''Expected prefix: «prefix» but was: «scenario.label»''', -1)
			}
			
			// add steps to map
			scenario.steps.forEach[labelToStep.put(it.label, it)]
		}
	}

	@Deprecated // TODO: side effect on the "lines" parameter
	def private parseIdAndName(LinkedList<String> lines) {
		popEmptyLines(lines)
		val line = lines.pop			
		
		val matcher = UC_IDANDNAME_PATTERN.matcher(line)

		if (!matcher.matches)
			throw new ParseException('''Unable to parse use case name from line: «line»''', -1)
			
		return new IdAndName(matcher.group(1), matcher.group(2))
	}
	
	@Deprecated // TODO: side effect on the "lines" parameter
	def private parseIsPrimary(LinkedList<String> lines) {
		popEmptyLines(lines)
		val line = lines.pop
		
		
		val matcher = UcmLang2UcmServiceOld.PRIMARY_UC_PATTERN.matcher(line)
		
		if (matcher.matches) {
			Boolean.parseBoolean(matcher.group(1))
		} else {
			lines.addFirst(line)
			true
		}
	}
	
	@Deprecated // TODO: side effect on the "lines" parameter
	def private parsePreceding(LinkedList<String> lines) {
		val line = lines.pop
		
		val list = <String> newArrayList
		
		if (line.startsWith(UcmLang2UcmServiceOld.PRECEDING_PREFIX)) {
			val matcher = UC_ID_PATTERN.matcher(line)
			while (matcher.find) {
				list += matcher.group(1)
			}
		} else {
			// return line to queue
			lines.addFirst(line)
		}
		
		list
	}
	
	@Deprecated // TODO: side effect on the "lines" parameter
	def private Scenario parseScenario(LinkedList<String> lines, String prefix) {
		val scenario = usecaseFactory.createScenario
		
		while (!lines.empty) {
			val labelTextAnnotations = parseLabeledAnnotatedText(lines)

			if (labelTextAnnotations == null)
				return scenario
			
			// check step label
			//labelTextAnnotations.label
			val expectedLabel = prefix + (scenario.steps.size + 1)

			if (labelTextAnnotations.label != expectedLabel)
				throw new ParseException('''Bad step label - expected «expectedLabel» at line "«labelTextAnnotations.annotatedText.text»"''', -1)
			
			// add step to scenario
			scenario.steps += usecaseFactory.createStep => [
				text = labelTextAnnotations.annotatedText.text
				annotations.addAll(labelTextAnnotations.annotatedText.annotations)
			]			
		}
		
		scenario
	}
	
	def private AnnotatedText separateTextAndAnnotations(String textWithAnnotations) {
		val matcher = ANNOTATION_PATTERN.matcher(textWithAnnotations)
		
		val hasAnnotations = matcher.find
		
		// get text
		val text = if (hasAnnotations) {
			// strip annotations from text
			textWithAnnotations.substring(0, matcher.start).trim
		} else {
			// has no annotations
			textWithAnnotations
		}
		
		// get annotations
		val List<Annotation> annotations = newArrayList
		if (hasAnnotations) {
			do {
				val content = matcher.group(1)
				val parts = content.split(":")
				
				val ua = annotationFactory.createUnknownAnnotation => [
					it.parts.addAll(parts)
				]
				
				annotations += ua
			} while (matcher.find)
		}
		
		new AnnotatedText => [
			it.annotations = annotations
			it.text = text
		]
	}

	@Deprecated // TODO: side effect on the "lines" parameter
	def private LabeledAnnotatedText parseLabeledAnnotatedText(LinkedList<String> lines) {
		// TODO - recognize continuation of the step by indentation instead of number ?

		val extensionStart = BranchingType.Extension + ":"
		val variationStart = BranchingType.Variation + ":"
		
		var firstLineMatched = false				 
		var result = new LabeledAnnotatedText
		
		while(!lines.empty) {
			popEmptyLines(lines)
			if (lines.empty) {
				return result
			}
			val line = lines.pop
			
			val matcher = UcmLang2UcmServiceOld.LABEL_AND_REST_PATTERN.matcher(line)
			if (!firstLineMatched) {
				if (line.startsWith(extensionStart) || line.startsWith(variationStart)) {
					// start of the branching and no step matched - end of the scenario
					lines.addFirst(line)
					return null
				}
				
				if (!matcher.matches) {
					throw new ParseException('''Line with invalid format: «line»''', -1)
				}
				firstLineMatched = true
				
				result.label = matcher.group(1)
				val textWithAnnotations = matcher.group(2)
				result.annotatedText = separateTextAndAnnotations(textWithAnnotations)
			} else {
				if (matcher.matches || line.startsWith(extensionStart) || line.startsWith(variationStart)) {
					// parsed started of the next step or branch
					lines.addFirst(line) 
					return result
				}
				
				// continuation of previous line - append text and annotations
				val additionalTextWithAnnotations = separateTextAndAnnotations(line)
				result.annotatedText.text = '''«result.annotatedText.text» «additionalTextWithAnnotations.text»'''
				result.annotatedText.annotations += additionalTextWithAnnotations.annotations
			}
		}
		
		result
	}
	
	@Deprecated // TODO: side effect on the "lines" parameter
	def private BranchingLabeledAnnotatedText parseBranching(LinkedList<String> lines) {
		
		popEmptyLines(lines)
		val line = lines.pop
		val matcher = UcmLang2UcmServiceOld.BRANCHING_LABELED_ANNOTATED_TEXT_PATTERN.matcher(line)
		
		if (!matcher.matches) {
			throw new ParseException('''Branching has invalid format: «line»''', -1)
		}
		
		val branchingType = BranchingType.valueOf(matcher.group(1))
		
		// hack - add line without branching type back to queue
		// and parse it with common method
		lines.addFirst(matcher.group(2))
		val brachingTextAndAnnotations = parseLabeledAnnotatedText(lines)
		
		new BranchingLabeledAnnotatedText(branchingType, brachingTextAndAnnotations)
	}
	
	@Deprecated // TODO: side effect on the "lines" parameter
	def private popEmptyLines(LinkedList<String> lines) {
		while(!lines.empty) {
			val line = lines.pop
			if (!line.empty) {
				lines.addFirst(line)
				return
			}
		}
	}
}

@Data class IdAndName {
	String id
	String name
}

@Data class BranchingLabeledAnnotatedText {
	BranchingType branchingType
	LabeledAnnotatedText labeledAnnotatedText
}

class LabeledAnnotatedText {
	@Accessors String label
	@Accessors AnnotatedText annotatedText
}

class AnnotatedText {
	@Accessors String text
	@Accessors List<Annotation> annotations
}
