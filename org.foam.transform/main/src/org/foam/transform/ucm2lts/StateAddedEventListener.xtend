package org.foam.transform.ucm2lts

import java.util.EventListener

public interface StateAddedEventListener extends EventListener {
	
	def void stateAdded(StateAddedEvent stateAddedEvent)

}
