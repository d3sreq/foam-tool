package org.foam.transform.lts2dot.processor.state.color;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.RecordNode;
import org.foam.lts.State;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.model.ModelUtils;
import org.foam.ucm.Scenario;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;

/**
 * @param mapping in parameter
 * @param step2RecordNode in parameter, map has to contain mapping from step
 * 		to record node before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class GreenSuccessStateProcessor implements StateProcessor {
  private final Map<Step,RecordNode> _step2RecordNode;
  
  public Map<Step,RecordNode> getStep2RecordNode() {
    return this._step2RecordNode;
  }
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      final Step step = ModelUtils.getStepFromStepMappingAnnotation(state);
      boolean _notEquals = (!Objects.equal(step, null));
      if (_notEquals) {
        EObject _eContainer = step.eContainer();
        final Scenario scenario = ((Scenario) _eContainer);
        final EObject scenarioParent = scenario.eContainer();
        boolean _and = false;
        if (!(scenarioParent instanceof UseCase)) {
          _and = false;
        } else {
          EList<Step> _steps = scenario.getSteps();
          Step _last = IterableExtensions.<Step>last(_steps);
          boolean _equals = Objects.equal(_last, step);
          _and = _equals;
        }
        if (_and) {
          Map<Step,RecordNode> _step2RecordNode = this.getStep2RecordNode();
          final RecordNode recordNode = _step2RecordNode.get(step);
          EMap<String,String> _attributes = recordNode.getAttributes();
          _attributes.put("fillcolor", "#ccebc5");
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public GreenSuccessStateProcessor(final Map<Step,RecordNode> step2RecordNode) {
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
    GreenSuccessStateProcessor other = (GreenSuccessStateProcessor) obj;
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
