package org.foam.transform.lts2dot.processor.state;

import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.DotFactory;
import org.foam.dot.Graph;
import org.foam.dot.Node;
import org.foam.dot.Statement;
import org.foam.lts.State;
import org.foam.traceability.UseCaseMappingAnnotation;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.ucm.UseCase;

@Data
@SuppressWarnings("all")
public class CreateOverviewNodeStateProcessor implements StateProcessor {
  private final Graph _resultDot;
  
  public Graph getResultDot() {
    return this._resultDot;
  }
  
  private final Map<State, Node> _state2Node;
  
  public Map<State, Node> getState2Node() {
    return this._state2Node;
  }
  
  private final DotFactory _dotFactory = DotFactory.eINSTANCE;
  
  public DotFactory getDotFactory() {
    return this._dotFactory;
  }
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      Iterable<UseCaseMappingAnnotation> _filter = Iterables.<UseCaseMappingAnnotation>filter(_annotations, UseCaseMappingAnnotation.class);
      UseCaseMappingAnnotation _head = IterableExtensions.<UseCaseMappingAnnotation>head(_filter);
      final UseCase useCase = _head.getUseCase();
      DotFactory _dotFactory = this.getDotFactory();
      Node _createNode = _dotFactory.createNode();
      final Procedure1<Node> _function = new Procedure1<Node>() {
        public void apply(final Node it) {
          String _id = useCase.getId();
          it.setId(_id);
          EMap<String, String> _attributes = it.getAttributes();
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("../");
          String _id_1 = it.getId();
          _builder.append(_id_1, "");
          _builder.append("/");
          String _id_2 = it.getId();
          _builder.append(_id_2, "");
          _builder.append(".html");
          _attributes.put("URL", _builder.toString());
          EMap<String, String> _attributes_1 = it.getAttributes();
          String _name = useCase.getName();
          _attributes_1.put("tooltip", _name);
          EMap<String, String> _attributes_2 = it.getAttributes();
          _attributes_2.put("target", "_top");
        }
      };
      final Node node = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function);
      Graph _resultDot = this.getResultDot();
      EList<Statement> _statements = _resultDot.getStatements();
      _statements.add(node);
      Map<State, Node> _state2Node = this.getState2Node();
      _state2Node.put(state, node);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public CreateOverviewNodeStateProcessor(final Graph resultDot, final Map<State, Node> state2Node) {
    super();
    this._resultDot = resultDot;
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_resultDot== null) ? 0 : _resultDot.hashCode());
    result = prime * result + ((_state2Node== null) ? 0 : _state2Node.hashCode());
    result = prime * result + ((_dotFactory== null) ? 0 : _dotFactory.hashCode());
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
    CreateOverviewNodeStateProcessor other = (CreateOverviewNodeStateProcessor) obj;
    if (_resultDot == null) {
      if (other._resultDot != null)
        return false;
    } else if (!_resultDot.equals(other._resultDot))
      return false;
    if (_state2Node == null) {
      if (other._state2Node != null)
        return false;
    } else if (!_state2Node.equals(other._state2Node))
      return false;
    if (_dotFactory == null) {
      if (other._dotFactory != null)
        return false;
    } else if (!_dotFactory.equals(other._dotFactory))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
