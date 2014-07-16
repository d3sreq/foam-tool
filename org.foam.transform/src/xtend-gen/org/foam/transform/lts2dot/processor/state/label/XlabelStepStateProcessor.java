package org.foam.transform.lts2dot.processor.state.label;

import java.util.Map;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.RecordNode;
import org.foam.lts.State;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.modeling.ModelUtils;
import org.foam.ucm.Step;

/**
 * @param mapping in parameter
 * @param state2RecordNode in parameter, map has to contain mapping from step
 * 		to record node before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class XlabelStepStateProcessor implements StateProcessor {
  private final Map<Step, RecordNode> _step2RecordNode;
  
  public Map<Step, RecordNode> getStep2RecordNode() {
    return this._step2RecordNode;
  }
  
  public void process(final State state) {
    final Step step = ModelUtils.getStepFromStepMappingAnnotation(state);
    Map<Step, RecordNode> _step2RecordNode = this.getStep2RecordNode();
    RecordNode _get = _step2RecordNode.get(step);
    EMap<String, String> _attributes = null;
    if (_get!=null) {
      _attributes=_get.getAttributes();
    }
    if (_attributes!=null) {
      String _label = step.getLabel();
      _attributes.put("xlabel", _label);
    }
  }
  
  public XlabelStepStateProcessor(final Map<Step, RecordNode> step2RecordNode) {
    super();
    this._step2RecordNode = step2RecordNode;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_step2RecordNode== null) ? 0 : _step2RecordNode.hashCode());
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
    XlabelStepStateProcessor other = (XlabelStepStateProcessor) obj;
    if (_step2RecordNode == null) {
      if (other._step2RecordNode != null)
        return false;
    } else if (!_step2RecordNode.equals(other._step2RecordNode))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
