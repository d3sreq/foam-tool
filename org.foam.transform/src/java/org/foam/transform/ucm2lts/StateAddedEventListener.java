package org.foam.transform.ucm2lts;

import java.util.EventListener;

public interface StateAddedEventListener extends EventListener {
	
	void stateAdded(StateAddedEvent stateAddedEvent);

}
