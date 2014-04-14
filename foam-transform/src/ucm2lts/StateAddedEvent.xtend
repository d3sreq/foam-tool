package ucm2lts

import org.foam.lts.State
import org.foam.traceability.StateType
import org.foam.ucm.Step

@Data 
class StateAddedEvent {
	Step sourceStep
	State targetState
	StateType targetStateType
}