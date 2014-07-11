package org.foam.transform.lts2dot.processor.transition;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.traceability.StateType;
import org.foam.transform.lts2dot.processor.transition.TransitionProcessor;
import org.foam.transform.utils.modeling.ModelUtils;
import org.foam.ucm.Step;

/**
 * Filters out transitions having source and target in same record node
 * 
 * @param mapping in parameter
 */
@Data
@SuppressWarnings("all")
public class RemoveRecordNodeEdgeTransitionProcessor implements TransitionProcessor {
  public boolean process(final Transition transition) {
    boolean _xblockexpression = false;
    {
      State _start = transition.getStart();
      final Step startStep = ModelUtils.getStepFromStepMappingAnnotation(_start);
      State _end = transition.getEnd();
      final Step endStep = ModelUtils.getStepFromStepMappingAnnotation(_end);
      State _start_1 = transition.getStart();
      final StateType startStateType = ModelUtils.getStateTypeFromStateTypeMappingAnnotation(_start_1);
      State _end_1 = transition.getEnd();
      final StateType endStateType = ModelUtils.getStateTypeFromStateTypeMappingAnnotation(_end_1);
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      boolean _identityEquals = (startStep == endStep);
      if (!_identityEquals) {
        _and_2 = false;
      } else {
        boolean _notEquals = (!Objects.equal(startStep, null));
        _and_2 = _notEquals;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(startStateType, null));
        _and_1 = _notEquals_1;
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _notEquals_2 = (!Objects.equal(endStateType, null));
        _and = _notEquals_2;
      }
      final boolean isTransitionWithinSameRecordNode = _and;
      _xblockexpression = (!isTransitionWithinSameRecordNode);
    }
    return _xblockexpression;
  }
  
  public RemoveRecordNodeEdgeTransitionProcessor() {
    super();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    RemoveRecordNodeEdgeTransitionProcessor other = (RemoveRecordNodeEdgeTransitionProcessor) obj;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
