package org.foam.transform.ucm2ucm

import com.google.common.base.CharMatcher
import com.google.common.base.Joiner
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Data

import static extension org.foam.bootstrap.IterableExtensions.*

class BlockParser {
	
	public def Iterable<Block> parse(CharSequence text) {		
		val lines = text.toString.split("\n")
		
		// add offset of each line with it's offset in the whole string
		val linesWithOffsets = lines
			.map[length] // computing sizes
			.fold(newArrayList(0), [list, len | list += list.last + len + 1; list]) // computing offsets; +1 for \n
			.zipWith(lines, [offset, content | new StringWithOffset(content, offset)]) // zipping offset -> line
		
		// group lines separated by the empty line(s)
		// additional filters are needed to remove empty lines (split addes them
		// to the groups) and to remove empty lines which can occur on the beginning.
		val splitted = linesWithOffsets
			.split[it.content.trim.empty]
			.map[filter[!it.content.trim.empty]]
			.filter[!it.empty]
		
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
			val header = new StringWithOffset(matcher.group(1), firstLine.offset + matcher.start(1))
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
			
			val body = new StringWithOffset(bodyContent, bodyOffset)
			new Block(header, body)
		].filterNull
		
		return blocks
	}
}

@Data 
class StringWithOffset {
	val String content
	val int offset
}

@Data
class Block {
	val StringWithOffset header
	val StringWithOffset body
}