package org.foam.transform.cntexlang2cntex

import org.foam.cntex.CntExState
import org.foam.cntex.CntexFactory
import org.foam.cntex.CounterExample
import org.foam.cntex.Specification
import org.foam.cntex.Trace
import com.google.common.base.Splitter
import com.google.common.collect.Lists
import java.text.ParseException
import java.util.LinkedList
import java.util.regex.Pattern

class CntexLang2Cntex {
	
	static val SPECIFICATION_REGEXP = "-- specification (.*)  is (\\w+)"
	static val COMMENT_PREFIX = "***"
	static val TRACE_DESCRIPTION_REGEXP = "Trace Description: (.*)"
	static val TRACE_TYPE_REGEXP = "Trace Type: (.*)"
	static val STATE_REGEXP = "-> State: ((\\d+)\\.(\\d+)) <-"
	static val ASSIGNMENT_REGEXP = "(\\S+) = (\\S+)"
	static val LOOP_LINE = "-- Loop starts here"
	static val AS_DEMONSTRATED_LINE = "-- as demonstrated by the following execution sequence"
	
	val cntexFactory = CntexFactory::eINSTANCE
	
	def CounterExample transform(String text) {
		val result = cntexFactory.createCounterExample
		
		val splitter = Splitter::on('\n').trimResults
		val lines = Lists::newLinkedList(splitter.split(text))
		
		popEmptyOrComments(lines)
		
		while (!lines.empty) {
			// empty line at end of file
			if (lines.peek.nullOrEmpty) {
				return result
			}
			result.specifications += parseSpecification(lines)
		}
		
		result
	}
	
	def private Specification parseSpecification(LinkedList<String> lines) {
		val docCommentPattern = Pattern::compile(SPECIFICATION_REGEXP)
		
		var line = lines.pop
		val matcher = docCommentPattern.matcher(line)
		
		if (!matcher.matches) {
			throw new ParseException('''Expected documentation comment but was: «line»''', -1)
		}
		
		val result = cntexFactory.createSpecification
		
		val isCorrect = matcher.group(2)
		if (isCorrect != "true" && isCorrect != "false") {
			throw new ParseException('''Expected documentation comment ends with 'true'/'false': «line»''', -1)
		}
		
		if (isCorrect == "false") {
			// skip lines
			checkLineMatches(lines.pop, AS_DEMONSTRATED_LINE)
			result.trace = parseTrace(lines)			
		}
		result.textFormula = matcher.group(1)
		
		// specification analysed as 'true' returns Specification object without trace
		result
	}
	
	def private checkLineMatches(String line, String regexp) {
		if (!line.matches(regexp)) {
			throw new ParseException('''Expected line matching "«regexp»" but was: «line»''', -1)
		}
	}
	
	def private Trace parseTrace(LinkedList<String> lines) {
		val result = cntexFactory.createTrace
		
		// skip lines
		checkLineMatches(lines.pop, TRACE_DESCRIPTION_REGEXP)
		checkLineMatches(lines.pop, TRACE_TYPE_REGEXP)
		
		var nextStateIsLoopStart = false
		var firstLoopProcessed = false
		
		while (!lines.empty) {
			val line = lines.pop
			
			if (line == LOOP_LINE) {
				nextStateIsLoopStart = true

			} else if (line.matches(SPECIFICATION_REGEXP)){
				// start of next specification
				lines.addFirst(line)
				return result

			} else if (line.matches(STATE_REGEXP)) {
				// parse state
				lines.addFirst(line)
				
				val state = parseState(lines)
				result.states += state				
				if (nextStateIsLoopStart) {
					nextStateIsLoopStart = false
					
					// set only first loop - ignore nested loops
					if (!firstLoopProcessed) {
						result.loopStart = state
						firstLoopProcessed = true
					}
				}
				
			} else if (line.empty) {
				// end of file
				return result
			} else {
				throw new ParseException('''Unexpected line while parsing trace: "«line»"''', -1)
			}
		}		
		
		result
	}
	
	def private CntExState parseState(LinkedList<String> lines) {
		val assignmentPattern = Pattern::compile(ASSIGNMENT_REGEXP)
		
		val result = cntexFactory.createCntExState
		
		// skip line
		checkLineMatches(lines.pop, STATE_REGEXP)
		
		// parse assignments
		while (!lines.empty) {
			val line = lines.pop
			
			val matcher = assignmentPattern.matcher(line)
			if (!matcher.matches) {
				// start of next state or next specification
				lines.addFirst(line)
				return result
			} else {
				result.assignments += cntexFactory.createCntExAssignment => [
					variableName = matcher.group(1)
					value = matcher.group(2)
				]
			}
		}
		
		result
	}
	
	def private popEmptyOrComments(LinkedList<String> lines) {
		while (!lines.empty) {
			val line = lines.pop			
			if (!line.empty && !line.startsWith(COMMENT_PREFIX)) {
				lines.addFirst(line)
				return
			}
		}
	}
	
}