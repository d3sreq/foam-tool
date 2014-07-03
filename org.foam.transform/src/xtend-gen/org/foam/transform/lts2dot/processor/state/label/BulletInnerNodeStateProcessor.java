package org.foam.transform.lts2dot.processor.state.label;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.Node;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.transform.lts2dot.processor.state.StateProcessor;

/**
 * Adds bullet to JMP states.
 * 
 * @param state2Node in parameter, contains mapping from state to node
 */
@Data
@SuppressWarnings("all")
public class BulletInnerNodeStateProcessor implements StateProcessor {
  private final Map<State, Node> _state2Node;
  
  public Map<State, Node> getState2Node() {
    return this._state2Node;
  }
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      boolean _hasJmp = this.hasJmp(state);
      if (_hasJmp) {
        Map<State, Node> _state2Node = this.getState2Node();
        Node _get = _state2Node.get(state);
        EMap<String, String> _attributes = _get.getAttributes();
        _attributes.put("label", "&bull;");
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private boolean hasJmp(final State state) {
    boolean _xblockexpression = false;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      final Iterable<StateTypeMappingAnnotation> stateTypeMappingAnnoatations = Iterables.<StateTypeMappingAnnotation>filter(_annotations, StateTypeMappingAnnotation.class);
      boolean _and = false;
      boolean _isEmpty = IterableExtensions.isEmpty(stateTypeMappingAnnoatations);
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        StateTypeMappingAnnotation _head = IterableExtensions.<StateTypeMappingAnnotation>head(stateTypeMappingAnnoatations);
        StateType _stateType = _head.getStateType();
        boolean _equals = Objects.equal(_stateType, StateType.JMP);
        _and = _equals;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  public BulletInnerNodeStateProcessor(final Map<State, Node> state2Node) {
    super();
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_state2Node== null) ? 0 : _state2Node.hashCode());
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
    BulletInnerNodeStateProcessor other = (BulletInnerNodeStateProcessor) obj;
    if (_state2Node == null) {
      if (other._state2Node != null)
        return false;
    } else if (!_state2Node.equals(other._state2Node))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
