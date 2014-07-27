package org.foam.transform.ltsreduction.predicates

import com.google.common.base.Predicate
import org.foam.lts.State
import org.foam.tadl.TemporalAnnotation

class HasTemporalAnnotation implements Predicate<State> {
	
	override apply(State state) {
		state.annotations.exists[it instanceof TemporalAnnotation]
	}	
}