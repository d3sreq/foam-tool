package org.foam.transform.lts2dot.processor.state.color;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.RecordNode;
import org.foam.flowannotation.Abort;
import org.foam.lts.State;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.model.ModelUtils;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;

/**
 * @param mapping in parameter
 * @param step2RecordNode in parameter, map has to contain mapping from step
 * 		to record node before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class RedAbortStateProcessor implements StateProcessor {
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
        final UseCase useCase = UcmUtils.getUseCase(step);
        boolean _notEquals_1 = (!Objects.equal(useCase, null));
        if (_notEquals_1) {
          final Predicate<Object> isAbort = Predicates.instanceOf(Abort.class);
          EList<Annotation> _annotations = step.getAnnotations();
          final Iterable<Annotation> aborts = IterableExtensions.<Annotation>filter(_annotations, new Function1<Annotation,Boolean>() {
              public Boolean apply(Annotation arg0) {
                return isAbort.apply(arg0);
              }
          });
          boolean _isEmpty = IterableExtensions.isEmpty(aborts);
          boolean _not = (!_isEmpty);
          if (_not) {
            Map<Step,RecordNode> _step2RecordNode = this.getStep2RecordNode();
            final RecordNode recordNode = _step2RecordNode.get(step);
            EMap<String,String> _attributes = recordNode.getAttributes();
            _attributes.put("fillcolor", "#fbb4ae");
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public RedAbortStateProcessor(final Map<Step,RecordNode> step2RecordNode) {
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
    RedAbortStateProcessor other = (RedAbortStateProcessor) obj;
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
