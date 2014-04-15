package org.foam.transform.lts2dot.processor.state;

import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.DotFactory;
import org.foam.dot.Node;
import org.foam.lts.State;
import org.foam.traceability.UseCaseMappingAnnotation;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.ucm.UseCase;

@Data
@SuppressWarnings("all")
public class StyleIncludeNodeStateProcessor implements StateProcessor {
  private final DotFactory _dotFactory = DotFactory.eINSTANCE;
  
  public DotFactory getDotFactory() {
    return this._dotFactory;
  }
  
  private final Map<State,Node> _state2Node;
  
  public Map<State,Node> getState2Node() {
    return this._state2Node;
  }
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      final Iterable<UseCaseMappingAnnotation> useCaseMappingAnnotations = Iterables.<UseCaseMappingAnnotation>filter(_annotations, UseCaseMappingAnnotation.class);
      boolean _isEmpty = IterableExtensions.isEmpty(useCaseMappingAnnotations);
      boolean _not = (!_isEmpty);
      if (_not) {
        final UseCaseMappingAnnotation annotation = IterableExtensions.<UseCaseMappingAnnotation>head(useCaseMappingAnnotations);
        Map<State,Node> _state2Node = this.getState2Node();
        final Node node = _state2Node.get(state);
        final UseCase useCase = annotation.getUseCase();
        final String id = useCase.getId();
        String _name = useCase.getName();
        final String label = ((id + " ") + _name);
        EMap<String,String> _attributes = node.getAttributes();
        _attributes.put("label", label);
        EMap<String,String> _attributes_1 = node.getAttributes();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("../");
        _builder.append(id, "");
        _builder.append("/");
        _builder.append(id, "");
        _builder.append(".html");
        _attributes_1.put("URL", _builder.toString());
        EMap<String,String> _attributes_2 = node.getAttributes();
        _attributes_2.put("target", "_top");
        EMap<String,String> _attributes_3 = node.getAttributes();
        _attributes_3.put("shape", "box");
        EMap<String,String> _attributes_4 = node.getAttributes();
        _attributes_4.put("height", "0.5");
        EMap<String,String> _attributes_5 = node.getAttributes();
        _attributes_5.put("fillcolor", "#fed9a6");
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public StyleIncludeNodeStateProcessor(final Map<State,Node> state2Node) {
    super();
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_dotFactory== null) ? 0 : _dotFactory.hashCode());
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
    StyleIncludeNodeStateProcessor other = (StyleIncludeNodeStateProcessor) obj;
    if (_dotFactory == null) {
      if (other._dotFactory != null)
        return false;
    } else if (!_dotFactory.equals(other._dotFactory))
      return false;
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
