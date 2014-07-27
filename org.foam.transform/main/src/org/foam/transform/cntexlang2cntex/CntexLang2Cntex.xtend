package org.foam.transform.cntexlang2cntex

import com.google.common.base.Preconditions
import java.text.ParseException
import java.util.regex.Pattern
import org.foam.cntex.CntExState
import org.foam.cntex.CntexFactory
import org.foam.cntex.CounterExample
import org.foam.cntex.Specification
import org.foam.cntex.Trace

import static extension org.foam.transform.utils.modeling.IterableExtensions.*

class CntexLang2Cntex {
	
	// prefixes
	static val COMMENT_PREFIX = "***"

	// regular expressions
	static val SPECIFICATION_REGEXP = "-- specification (.*)  is (\\w+)"
	static val TRACE_DESCRIPTION_REGEXP = "Trace Description: (.*)"
	static val TRACE_TYPE_REGEXP = "Trace Type: (.*)"
	static val STATE_REGEXP = "-> State: ((\\d+)\\.(\\d+)) <-"
	static val ASSIGNMENT_REGEXP = "(\\S+) = (\\S+)"
	
	// text visible to user when rendered
	static val LOOP_LINE = "-- Loop starts here"
	static val AS_DEMONSTRATED_LINE = "-- as demonstrated by the following execution sequence"
	
	val cntexFactory = CntexFactory.eINSTANCE
	
	def CounterExample transform(CharSequence text) {
		cntexFactory.createCounterExample => [
			specifications += text.toString
				.split("\n") // each line is a single item in the list
				.map[trim] // trim each line
				.filter[!empty] // ignore empty lines
				.filter[!startsWith(COMMENT_PREFIX)] // ignore comments
				.split[matches(SPECIFICATION_REGEXP)] // split list into chunks (multiple smaller lists)
				.tail // ignore the first chunk which are lines before the first matching SPECIFICATION_REGEXP
				.map[parseSpecification] // parse each chunk to create Specifications
		]
	}
	
	private static val SPEC_PATTERN = Pattern.compile(SPECIFICATION_REGEXP)
	
	def private Specification parseSpecification(Iterable<String> lines) {
		
		val specLine = lines.head
		val matcher = SPEC_PATTERN.matcher(specLine)
		
		if (!matcher.matches) {
			throw new ParseException('''Expected documentation comment but was: «specLine»''', -1)
		}
		
		val isCorrect = matcher.group(2)

		val result = cntexFactory.createSpecification
		result.textFormula = matcher.group(1)
		
		if(isCorrect == "true") {
			// specification analysed as 'true' returns Specification object without trace
			return result
		}
		
		if (isCorrect == "false") {
			val linesWithoutFirst = lines.tail
			linesWithoutFirst.head.checkLineMatches(AS_DEMONSTRATED_LINE)
			
			result.trace = parseTrace(linesWithoutFirst.tail)
			return result
		}
		
		throw new ParseException('''Expected documentation comment ends with 'true'/'false': «specLine»''', -1)
	}
	
	def private checkLineMatches(String line, String regexp) {
		if (!line.matches(regexp)) {
			throw new ParseException('''Expected line matching "«regexp»" but was: «line»''', -1)
		}
	}
	
	/**
	 * Parses the stack trace from NuSMV plain text as a 
	 */
	def private Trace parseTrace(Iterable<String> lines) {

		val checkedLines = lines
			.checkConsumed[matches(TRACE_DESCRIPTION_REGEXP)]
			.checkConsumed[matches(TRACE_TYPE_REGEXP)]
			
		// NOTE: the "loop" delimiters are not removed
		val splitByLoops = checkedLines.split[equals(LOOP_LINE)]

		val statesBeforeLoop = splitByLoops.head
			.split[startsWith("-> State:")]
			.checkConsumed[empty] // there should be nothing before the first State
			.map[parseState]
			.toList

		val statesInLoop = splitByLoops.tail
			.map[checkConsumed[equals(LOOP_LINE)]] // remove the loop delimiter from each block 
			.flatten // merge all loops into a single loop
			.split[startsWith("-> State:")]
			.checkConsumed[empty] // there should be nothing before the first State
			.map[parseState]
			.toList
			
		return cntexFactory.createTrace => [
			states += statesBeforeLoop + statesInLoop
			loopStart = statesInLoop.head
		]
	}
	
	private static val ASSIGN_PATTERN = Pattern.compile(ASSIGNMENT_REGEXP)
	def private CntExState parseState(Iterable<String> lines) {
		cntexFactory.createCntExState => [
			assignments += lines
				.checkConsumed[matches(STATE_REGEXP)]
				.map[
					val m = ASSIGN_PATTERN.matcher(it)
					Preconditions.checkState(m.matches, '''Expected state assignment 'varname = value' but '«it»' encountered.''')
					cntexFactory.createCntExAssignment => [
						variableName = m.group(1)
						value = m.group(2)
					]
				]
		]
	}
}