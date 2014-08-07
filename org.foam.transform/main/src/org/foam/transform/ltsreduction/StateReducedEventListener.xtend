package org.foam.transform.ltsreduction

import java.util.EventListener

public interface StateReducedEventListener extends EventListener {
	
	def void stateReduced(StateReducedEvent stateReducedEvent)
}
