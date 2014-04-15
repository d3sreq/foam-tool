package org.foam.transform.ltsreduction

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import java.util.ArrayList
import java.util.Collection
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature.Setting
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.lts.Automaton
import org.foam.lts.LtsFactory
import org.foam.lts.LtsPackage
import org.foam.lts.State
import org.foam.lts.Transition

class LtsReduction {
	
	val Predicate<State> removeStatePredicate
	val stateReducedEventListeners = new ArrayList<StateReducedEventListener>
	
	new(Predicate<State> removeStatePredicate) {
		this.removeStatePredicate = removeStatePredicate
	}
	
	def removeUnneededStates(Automaton lts) {
		val predicate = Predicates::and(removeStatePredicate, new StateWithOneInputAndOneOutputTransition(lts.transitions))		
		val filtered = lts.states.filter[predicate.apply(it)]
		// extra list is needed to prevent ConcurrentModificationException
		val statesToRemove = new ArrayList<State>
		statesToRemove.addAll(filtered)
		statesToRemove.forEach[reduceState(it, lts)]
	}
	
	def private filterSettings(Collection<Setting> settings, EReference eReference) {
		settings.filter[it.EStructuralFeature == eReference]
	} 
	
	def private reduceState(State state, Automaton automaton) {
		// get transitions containing state which will be removed
		// assumes that only one transition is going into this state and from this state
		val settings = EcoreUtil.UsageCrossReferencer::find(state, automaton.transitions)
		val fromState = settings.filterSettings(LtsPackage.Literals::TRANSITION__START).head.EObject as Transition
		val toState = settings.filterSettings(LtsPackage.Literals::TRANSITION__END).head.EObject as Transition
		
		// add transition bypassing removed state
		val newTransition = LtsFactory::eINSTANCE.createTransition => [
			start = toState.start
			end = fromState.end
		]
		automaton.transitions += newTransition

		// remove transitions going from/to removed state
		EcoreUtil::remove(toState)
		EcoreUtil::remove(fromState)
		
		// remove state from Automaton
		EcoreUtil::remove(state)
		
		notifyStateReduced(state, toState, fromState, newTransition)
	}
	
	def protected void notifyStateReduced(State removedState, Transition removedToStateTransition, Transition removedFromStateTransition, Transition addedTransition) {
		val event = new StateReducedEvent(removedState, removedToStateTransition, removedFromStateTransition, addedTransition)
		stateReducedEventListeners.forEach[it.stateReduced(event)]
	}
	
	def void addStateReducedEventListener(StateReducedEventListener stateReducedEventListener) {
		stateReducedEventListeners += stateReducedEventListener
	}
	
	def void removeStateReducedEventListener(StateReducedEventListener stateReducedEventListener) {
		stateReducedEventListeners.remove(stateReducedEventListener)
	}
	
}

@Data
class StateWithOneInputAndOneOutputTransition implements Predicate<State> {
	
	val Collection<Transition> transitions
	
	def private filterSettings(Collection<Setting> settings, EReference eReference) {
		settings.filter[it.EStructuralFeature == eReference]
	} 
	
	override apply(State state) {
		val settings = EcoreUtil.UsageCrossReferencer::find(state, transitions)
		
		val toState = settings.filterSettings(LtsPackage.Literals::TRANSITION__START)
		val fromState = settings.filterSettings(LtsPackage.Literals::TRANSITION__END)
		
		toState.size == 1 && fromState.size == 1
	}
	
}