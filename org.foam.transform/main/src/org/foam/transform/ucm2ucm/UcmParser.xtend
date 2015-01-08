package org.foam.transform.ucm2ucm

import com.google.common.base.CharMatcher
import com.google.common.base.Joiner
import java.util.regex.Pattern
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.text.StringWithOffset
import org.foam.text.TextFactory
import org.foam.ucmtext.Block
import org.foam.ucmtext.ScenarioDef
import org.foam.ucmtext.ScenarioType
import org.foam.ucmtext.UcIdDef
import org.foam.ucmtext.UcmtextFactory

import static extension org.foam.bootstrap.IterableExtensions.*

class UcmParser {
	
	private static val ucmTextFac = UcmtextFactory.eINSTANCE
	
	@Pure
	package static def createStringWithOffset(String content, int offset) {
		TextFactory.eINSTANCE.createStringWithOffset => [
			it.content = content
			it.offset = offset
		]
	}
	
	@Pure
	package def Iterable<Block> parseBlocks(StringWithOffset root) {
		val linesWithOffsets = root.splitByLines
		
		// group lines separated by the empty line(s)
		// additional filters are needed to remove empty lines (split adds them
		// to the groups) and to remove empty lines which can occur on the beginning.
		val splitted = linesWithOffsets
			.split[content.trim.empty]
			.map[filter[!content.trim.empty]]
			.filter[!empty]
		
		// create block from each group
		// block starts with head followed by colon and follows the body ended by double newline
		// example:
		// my block header : my block body
		// additional text in the body
		// <- end of the block
		//
		val blockStartPattern = Pattern.compile("(\\S+(\\s+\\S+)*)\\s*:\\s*(.*)")
		val firstNonBlankChar = Pattern.compile("\\S+.*")
		val blocks = splitted.map[
			val firstLine = it.head
			val matcher = blockStartPattern.matcher(firstLine.content)
			if (!matcher.matches) {
				// if block doesn't have the right format it is quietly ignored
				return null
			}
			val header = createStringWithOffset(matcher.group(1), firstLine.offset + matcher.start(1))
			val bodyOffset = if (!matcher.group(3).trim.empty || it.size == 1) {
				// body starts on the line with head
				// block is in the following format:
				//
				// head : start of the block
				// additional lines
				//
				// this case also involves empty body
				firstLine.offset + matcher.start(3) 
			} else {
				// body starts on the next line
				// block is in the following format:
				//
				// head :
				// start of the block
				// additional lines
				//
				val secondLine = it.get(1)
				val nextLineMatcher = firstNonBlankChar.matcher(secondLine.content)
				nextLineMatcher.matches
				secondLine.offset + nextLineMatcher.start
			}
			
			// concatenate lines to one string
			// strip trailing whitespace but preserve the other whitespace
			// to make offset counting possible
			val bodyParts = newArrayList 
			if (!matcher.group(3).trim.empty) {
				bodyParts += matcher.group(3)
			} 
			bodyParts += it.tail.map[it.content]
			val bodyContent = CharMatcher.WHITESPACE.trimTrailingFrom(Joiner.on("\n").join(bodyParts))
			
			val body = createStringWithOffset(bodyContent, bodyOffset)
			//new Block(new Text(header), new Text(body))
			ucmTextFac.createBlock => [
				it.header = header
				it.body = body
			]
		].filterNull
		
		return blocks
	}
	
	package static def createUcIdDef(StringWithOffset id, StringWithOffset desc) {
		ucmTextFac.createUcIdDef => [
			it.id = id
			it.description = desc
		]
	}
	
	val precededPattern = Pattern.compile("(UC\\w+)\\s*([^,]*)")
	
	@Pure
	package def Iterable<UcIdDef> parsePreceded(StringWithOffset text) {
		val matcher = precededPattern.matcher(text.content)
		val result = <UcIdDef>newArrayList
		val initOffset = text.offset
		
		while (matcher.find) {
			val idOffset = matcher.start(1)
			val idContent = matcher.group(1)
			
			val descOffset = matcher.start(2)
			val descContent = matcher.group(2).trim
			
			val id = createStringWithOffset(idContent, initOffset + idOffset)
			val desc = createStringWithOffset(descContent, initOffset + descOffset)
			result += createUcIdDef(id, desc)
		}
		
		result
	}
	
	private def Iterable<StringWithOffset> splitByLines(StringWithOffset text) {
		val initOffset = text.offset
		val lines = text.content.split("\n")
		
		// add offset of each line with it's offset in the whole string
		lines.map[length] // computing sizes
			.fold(newArrayList(initOffset), [list, len | list += list.last + len + 1; list]) // computing offsets; +1 for \n
			.zipWith(lines, [offset, content | createStringWithOffset(content, offset)]) // zipping offset -> line
	}
	
	val stepPattern = Pattern.compile("^(\\d+([a-z]\\d*)*)\\s+(.*)")
	
	/**
	 * Parses {@link ScenarioDef} but doesn't set its <code>Type</code> field.
	 */
	@Pure
	package def ScenarioDef parseScenarioDef(StringWithOffset text) {
		val linesWithOffsets = text.splitByLines
		
		// group lines separated by regex
		// additional filters are needed to remove empty lines (split adds them
		// to the groups) and to remove empty lines which can occur on the beginning.
		val splitted = linesWithOffsets
			.split[stepPattern.matcher(content).matches]
			.filter[!empty]
		
		val steps = splitted.map[
			// get step (or condition) label from the head of each group
			val firstLine = it.head
			val matcher = stepPattern.matcher(firstLine.content)
			matcher.matches
			val labelOffset = firstLine.offset + matcher.start(1)
			val labelContent = matcher.group(1)
			
			// get step "body"
			val bodyOffset = firstLine.offset + matcher.start(3)
			val bodyContent = it.tail.map[content]
				.fold(new StringBuilder(matcher.group(3)), [sb, item | sb.append("\n").append(item)])
				.toString
			
			ucmTextFac.createStepDef => [
				it.label = createStringWithOffset(labelContent, labelOffset)
				it.text = createStringWithOffset(bodyContent, bodyOffset)
				it.annot += parseAnnotations(it.text)
			]
		]

		ucmTextFac.createScenarioDef => [
			it.steps += steps
		]
	}
  
	val annotationPattern = Pattern.compile("(#\\([^)]+\\))")
	
	def package Iterable<StringWithOffset> parseAnnotations(StringWithOffset stringWithOffset) {
		val matcher = annotationPattern.matcher(stringWithOffset.content)
		val result = <StringWithOffset>newArrayList
		val initOffset = stringWithOffset.offset
		
		while (matcher.find) {
			result += createStringWithOffset(matcher.group, initOffset + matcher.start)
		}
		
		result
	}
	
	// TODO - "top-level" parse method will be in separate package which will be exported
	def parse(CharSequence text) {
		val unparsedText = ucmTextFac.createUnparsedUseCaseText => [
			it.text = createStringWithOffset(text.toString, 0)
		]
		
		val blocks = unparsedText.text.parseBlocks
		unparsedText.blocks += blocks
		
		// use case name
		val useCaseNameBlock = blocks.findFirst[header.content.matches("UC\\d+")]
		
		// situation when useCaseNameBlock == null is resolved in subsequent
		// transformation.
		if (useCaseNameBlock != null) {
			useCaseNameBlock.derived = ucmTextFac.createUseCaseNameDef => [
				it.useCase = ucmTextFac.createUcIdDef => [
					it.id = EcoreUtil.copy(useCaseNameBlock.header)
					it.description = EcoreUtil.copy(useCaseNameBlock.body)
				]
			]
		}
		
		// precedence
		val precedingBlock = blocks.findFirst[header.content == "Preceding"]
		if (precedingBlock != null) {
			precedingBlock.derived = ucmTextFac.createPrecedenceDef => [
				it.preceded += precedingBlock.body.parsePreceded
			]
		}
		
		// primary
		val primaryBlock = blocks.findFirst[header.content == "Primary"]
		if (primaryBlock != null) {
			primaryBlock.derived = ucmTextFac.createPrimaryDef => [
				it.value = EcoreUtil.copy(primaryBlock.body)
			]
		}
		
		// main scenario
		val mainScenarioBlock = blocks.findFirst[header.content == "Main scenario"]

		// situation when useCaseNameBlock == null is resolved in subsequent
		// transformation.
		if (mainScenarioBlock != null) {
			mainScenarioBlock.derived = mainScenarioBlock.body.parseScenarioDef => [
				it.type = ScenarioType.MAIN
			]
		}
		
		// extensions
		blocks.filter[header.content == "Extension"].forEach[
			it.derived = body.parseScenarioDef => [
				it.type = ScenarioType.EXTENSION
			]
		]
		
		// variations
		blocks.filter[header.content == "Variation"].forEach[
			it.derived = body.parseScenarioDef => [
				it.type = ScenarioType.VARIATION
			]
		]
		
		unparsedText
	}
	
}

// first type of error - without specific location
// but bound to given text
// - main scenario not found
// - use case name not found
//
// second - bound to location
// - goto to unknown step
// - bad step label 

