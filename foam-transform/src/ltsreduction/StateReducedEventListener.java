package ltsreduction;

import java.util.EventListener;

public interface StateReducedEventListener extends EventListener {
	
	void stateReduced(StateReducedEvent stateReducedEvent);

}
