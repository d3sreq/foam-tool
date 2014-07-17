package org.foam.transform.lts2dot.processor.state;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.Node;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.modeling.ModelUtils;

/**
 * @param mapping in parameter
 * @param state2Node in parameter, map has to contain mapping from given state
 * 		to node before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class CircleWithoutStateTypeProcessor implements StateProcessor {
  private final Map<State, Node> _state2Node;
  
  public Map<State, Node> getState2Node() {
    return this._state2Node;
  }
  
  public void process(final State state) {
    StateType _stateTypeFromStateTypeMappingAnnotation = ModelUtils.getStateTypeFromStateTypeMappingAnnotation(state);
    boolean _equals = Objects.equal(_stateTypeFromStateTypeMappingAnnotation, null);
    if (_equals) {
      Map<State, Node> _state2Node = this.getState2Node();
      final Node node = _state2Node.get(state);
      EMap<String, String> _attributes = node.getAttributes();
      _attributes.put("shape", "circle");
    }
  }
  
  public CircleWithoutStateTypeProcessor(final Map<State, Node> state2Node) {
    super();
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    CircleWithoutStateTypeProcessor other = (CircleWithoutStateTypeProcessor) obj;
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
