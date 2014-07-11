package org.foam.transform.ucm2lts;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.ucm.Step;

@Data
@SuppressWarnings("all")
public class StateAddedEvent {
  private final Step _sourceStep;
  
  public Step getSourceStep() {
    return this._sourceStep;
  }
  
  private final State _targetState;
  
  public State getTargetState() {
    return this._targetState;
  }
  
  private final StateType _targetStateType;
  
  public StateType getTargetStateType() {
    return this._targetStateType;
  }
  
  public StateAddedEvent(final Step sourceStep, final State targetState, final StateType targetStateType) {
    super();
    this._sourceStep = sourceStep;
    this._targetState = targetState;
    this._targetStateType = targetStateType;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_sourceStep== null) ? 0 : _sourceStep.hashCode());
    result = prime * result + ((_targetState== null) ? 0 : _targetState.hashCode());
    result = prime * result + ((_targetStateType== null) ? 0 : _targetStateType.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StateAddedEvent other = (StateAddedEvent) obj;
    if (_sourceStep == null) {
      if (other._sourceStep != null)
        return false;
    } else if (!_sourceStep.equals(other._sourceStep))
      return false;
    if (_targetState == null) {
      if (other._targetState != null)
        return false;
    } else if (!_targetState.equals(other._targetState))
      return false;
    if (_targetStateType == null) {
      if (other._targetStateType != null)
        return false;
    } else if (!_targetStateType.equals(other._targetStateType))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
