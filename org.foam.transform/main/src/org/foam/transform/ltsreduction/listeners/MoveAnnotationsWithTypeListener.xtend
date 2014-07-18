package org.foam.transform.ltsreduction.listeners

import org.foam.annotation.Annotation
import org.foam.lts.Transition
import org.foam.transform.ltsreduction.StateReducedEvent
import org.foam.transform.ltsreduction.StateReducedEventListener

/**
 * Moves {@link Annotation} having given type (or with subclass of given type) from
 * removed {@link Transition}s to added Transition.
 */
class MoveAnnotationsWithTypeListener implements StateReducedEventListener {
	Class<? extends Annotation> annotationType
	
	new(Class<? extends Annotation> annotationType) {
		this.annotationType = annotationType
	}

	override stateReduced(StateReducedEvent stateReducedEvent) {

		val annotations =
			stateReducedEvent.removedFromStateTransition.annotations
			+ stateReducedEvent.removedToStateTransition.annotations
			
		val annotationsWithType = annotations.filter[annotationType.isAssignableFrom(it.class)]

		// extra list to prevent ConcurentModificationException
		val list = <Annotation> newArrayList
		list += annotationsWithType
		stateReducedEvent.addedTransition.annotations += list
	}
	
}