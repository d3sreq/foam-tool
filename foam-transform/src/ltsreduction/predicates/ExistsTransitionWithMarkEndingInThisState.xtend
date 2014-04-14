package ltsreduction.predicates

import com.google.common.base.Predicate
import org.foam.flowannotation.Mark
import java.util.Collection
import java.util.HashSet
import java.util.Set
import org.foam.lts.State
import org.foam.lts.Transition

/**
 * Evaluates to True if given State is present as end State in any Transition
 * that has Mark annotation attached.
 */
class ExistsTransitionWithMarkEndingInThisState implements Predicate<State> {
	
	val Set<State> statesWithMarkTransitionEnd
	
	new(Collection<Transition> transitions) {
		statesWithMarkTransitionEnd = new HashSet<State>
		for (transition : transitions) {
			if (transition.annotations.findFirst[it instanceof Mark] != null) {
				statesWithMarkTransitionEnd += transition.end
			}
		}
	}
	
	override apply(State state) {
		statesWithMarkTransitionEnd.contains(state)
	}
	
}