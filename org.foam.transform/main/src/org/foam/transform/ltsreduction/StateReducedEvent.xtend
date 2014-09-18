package org.foam.transform.ltsreduction

import org.eclipse.xtend.lib.annotations.Data
import org.foam.lts.State
import org.foam.lts.Transition

@Data
class StateReducedEvent {
	State removedState
	Transition removedToStateTransition
	Transition removedFromStateTransition
	Transition addedTransition
}