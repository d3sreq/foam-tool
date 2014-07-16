package org.foam.transform.lts2dot.processor.state.color;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.Node;
import org.foam.lts.State;
import org.foam.transform.lts2dot.processor.state.StateProcessor;

/**
 * @param mapping in parameter
 * @param state2Node in parameter, map has to contain mapping from state
 * 		to node before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class BlackInitStateProcessor implements StateProcessor {
  private final State _initState;
  
  public State getInitState() {
    return this._initState;
  }
  
  private final Map<State, Node> _state2Node;
  
  public Map<State, Node> getState2Node() {
    return this._state2Node;
  }
  
  public void process(final State state) {
    State _initState = this.getInitState();
    boolean _equals = Objects.equal(state, _initState);
    if (_equals) {
      Map<State, Node> _state2Node = this.getState2Node();
      Node _get = _state2Node.get(state);
      EMap<String, String> _attributes = _get.getAttributes();
      _attributes.put("fillcolor", "black");
    }
  }
  
  public BlackInitStateProcessor(final State initState, final Map<State, Node> state2Node) {
    super();
    this._initState = initState;
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._initState== null) ? 0 : this._initState.hashCode());
    result = prime * result + ((this._state2Node== null) ? 0 : this._state2Node.hashCode());
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
    BlackInitStateProcessor other = (BlackInitStateProcessor) obj;
    if (this._initState == null) {
      if (other._initState != null)
        return false;
    } else if (!this._initState.equals(other._initState))
      return false;
    if (this._state2Node == null) {
      if (other._state2Node != null)
        return false;
    } else if (!this._state2Node.equals(other._state2Node))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
