package org.foam.transform.ltsreduction;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.lts.State;
import org.foam.lts.Transition;

@Data
@SuppressWarnings("all")
public class StateReducedEvent {
  private final State _removedState;
  
  public State getRemovedState() {
    return this._removedState;
  }
  
  private final Transition _removedToStateTransition;
  
  public Transition getRemovedToStateTransition() {
    return this._removedToStateTransition;
  }
  
  private final Transition _removedFromStateTransition;
  
  public Transition getRemovedFromStateTransition() {
    return this._removedFromStateTransition;
  }
  
  private final Transition _addedTransition;
  
  public Transition getAddedTransition() {
    return this._addedTransition;
  }
  
  public StateReducedEvent(final State removedState, final Transition removedToStateTransition, final Transition removedFromStateTransition, final Transition addedTransition) {
    super();
    this._removedState = removedState;
    this._removedToStateTransition = removedToStateTransition;
    this._removedFromStateTransition = removedFromStateTransition;
    this._addedTransition = addedTransition;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_removedState== null) ? 0 : _removedState.hashCode());
    result = prime * result + ((_removedToStateTransition== null) ? 0 : _removedToStateTransition.hashCode());
    result = prime * result + ((_removedFromStateTransition== null) ? 0 : _removedFromStateTransition.hashCode());
    result = prime * result + ((_addedTransition== null) ? 0 : _addedTransition.hashCode());
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
    StateReducedEvent other = (StateReducedEvent) obj;
    if (_removedState == null) {
      if (other._removedState != null)
        return false;
    } else if (!_removedState.equals(other._removedState))
      return false;
    if (_removedToStateTransition == null) {
      if (other._removedToStateTransition != null)
        return false;
    } else if (!_removedToStateTransition.equals(other._removedToStateTransition))
      return false;
    if (_removedFromStateTransition == null) {
      if (other._removedFromStateTransition != null)
        return false;
    } else if (!_removedFromStateTransition.equals(other._removedFromStateTransition))
      return false;
    if (_addedTransition == null) {
      if (other._addedTransition != null)
        return false;
    } else if (!_addedTransition.equals(other._addedTransition))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
