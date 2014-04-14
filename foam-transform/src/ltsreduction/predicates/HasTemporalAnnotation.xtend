package ltsreduction.predicates

import com.google.common.base.Predicate
import org.foam.lts.State
import org.foam.tadl.TemporalAnnotation

class HasTemporalAnnotation implements Predicate<State> {
	
	override apply(State state) {
		state.annotations.findFirst[it instanceof TemporalAnnotation] != null
	}
	
}