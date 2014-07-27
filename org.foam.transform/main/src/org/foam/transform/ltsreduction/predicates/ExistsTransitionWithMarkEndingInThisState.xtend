package org.foam.transform.ltsreduction.predicates

import com.google.common.base.Predicate
import java.util.Collection
import java.util.Set
import org.foam.flowannotation.Mark
import org.foam.lts.State
import org.foam.lts.Transition

/**
 * Evaluates to True if given State is present as end State in any Transition
 * that has Mark annotation attached.
 */
class ExistsTransitionWithMarkEndingInThisState implements Predicate<State> {
	
	val Set<State> statesWithMarkTransitionEnd
	
	new(Collection<Transition> transitions) {
		
		statesWithMarkTransitionEnd =
			transitions
			.filter[ annotations.exists[it instanceof Mark] ] // only transitions with Mark annotation
			.map[end] // end state of a transition
			.toSet
	}
	
	override apply(State state) {
		statesWithMarkTransitionEnd.contains(state)
	}
}