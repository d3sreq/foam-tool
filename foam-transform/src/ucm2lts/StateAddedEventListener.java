package ucm2lts;

import java.util.EventListener;

import ucm2lts.StateAddedEvent;

public interface StateAddedEventListener extends EventListener {
	
	void stateAdded(StateAddedEvent stateAddedEvent);

}
