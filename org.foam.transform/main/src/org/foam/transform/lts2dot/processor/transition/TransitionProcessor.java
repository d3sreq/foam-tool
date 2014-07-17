package org.foam.transform.lts2dot.processor.transition;

import org.foam.lts.Transition;

public interface TransitionProcessor {

	/**
	 * Analyzes given {@code transition} and changes data stored in {@code processorData}. 
	 * Function of the concrete implementing class may vary - some classes add DOT constructs
	 * into resulting graph. Another act as filters where by returning {@code false}
	 * prevent call of the consequent {@code TransitionProcessor}s.
	 * 
	 * @param transition analyzed transition
	 * @param processorData stores output graph and additional data for analysis
	 */
	void process(Transition transition);
}
