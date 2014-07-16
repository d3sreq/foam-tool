package org.foam.transform.lts2dot.processor.state

import org.foam.lts.State

public interface StateProcessor {

	/**
	 * Analyzes given {@code state} and changes data stored in {@code processorData}. 
	 * Function of the concrete implementing class may vary - some classes add DOT constructs
	 * into resulting graph. Another act as filters where by returning {@code false}
	 * prevent call of the consequent {@code StateProcessor}s.
	 * 
	 * @param state analyzed state
	 * @param processorData stores output graph and additional data for analysis
	 */
	def void process(State state)
}
