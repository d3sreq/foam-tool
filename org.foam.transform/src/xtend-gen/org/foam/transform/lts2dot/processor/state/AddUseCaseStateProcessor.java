package org.foam.transform.lts2dot.processor.state;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.Assignment;
import org.foam.dot.DotFactory;
import org.foam.dot.Graph;
import org.foam.dot.Statement;
import org.foam.lts.State;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.modeling.ModelUtils;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;

/**
 * Creates subgraph (cluster) for use case and scenario of the given state if this subgraph is
 * not already present in {@code processorData}.
 * 
 * @param mapping in parameter
 * @param resultDot out parameter (graph to which use case graphs are added),
 * 		populated in this processor
 * @param useCase2Graph out parameter, populated in this processor
 */
@Data
@SuppressWarnings("all")
public class AddUseCaseStateProcessor implements StateProcessor {
  private final Graph _resultDot;
  
  public Graph getResultDot() {
    return this._resultDot;
  }
  
  private final Map<UseCase, Graph> _useCase2Graph;
  
  public Map<UseCase, Graph> getUseCase2Graph() {
    return this._useCase2Graph;
  }
  
  private final DotFactory _dotFactory = DotFactory.eINSTANCE;
  
  public DotFactory getDotFactory() {
    return this._dotFactory;
  }
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      this.addUseCaseSubGraph(state);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private boolean addUseCaseSubGraph(final State state) {
    boolean _xblockexpression = false;
    {
      final Step step = ModelUtils.getStepFromStepMappingAnnotation(state);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(step, null));
      if (_notEquals) {
        boolean _xblockexpression_1 = false;
        {
          final UseCase useCase = UcmUtils.getUseCase(step);
          boolean _xifexpression_1 = false;
          Map<UseCase, Graph> _useCase2Graph = this.getUseCase2Graph();
          boolean _containsKey = _useCase2Graph.containsKey(useCase);
          boolean _not = (!_containsKey);
          if (_not) {
            boolean _xblockexpression_2 = false;
            {
              DotFactory _dotFactory = this.getDotFactory();
              Graph _createGraph = _dotFactory.createGraph();
              final Procedure1<Graph> _function = new Procedure1<Graph>() {
                public void apply(final Graph it) {
                  String _id = useCase.getId();
                  it.setId(_id);
                  EList<Statement> _statements = it.getStatements();
                  DotFactory _dotFactory = AddUseCaseStateProcessor.this.getDotFactory();
                  Assignment _createAssignment = _dotFactory.createAssignment();
                  final Procedure1<Assignment> _function = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("label");
                      StringConcatenation _builder = new StringConcatenation();
                      String _id = useCase.getId();
                      _builder.append(_id, "");
                      _builder.append(": ");
                      String _name = useCase.getName();
                      _builder.append(_name, "");
                      it.setValue(_builder.toString());
                    }
                  };
                  Assignment _doubleArrow = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment, _function);
                  _statements.add(_doubleArrow);
                }
              };
              final Graph subGraph = ObjectExtensions.<Graph>operator_doubleArrow(_createGraph, _function);
              Map<UseCase, Graph> _useCase2Graph_1 = this.getUseCase2Graph();
              _useCase2Graph_1.put(useCase, subGraph);
              Graph _resultDot = this.getResultDot();
              EList<Statement> _statements = _resultDot.getStatements();
              _xblockexpression_2 = _statements.add(subGraph);
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AddUseCaseStateProcessor(final Graph resultDot, final Map<UseCase, Graph> useCase2Graph) {
    super();
    this._resultDot = resultDot;
    this._useCase2Graph = useCase2Graph;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_resultDot== null) ? 0 : _resultDot.hashCode());
    result = prime * result + ((_useCase2Graph== null) ? 0 : _useCase2Graph.hashCode());
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
    AddUseCaseStateProcessor other = (AddUseCaseStateProcessor) obj;
    if (_resultDot == null) {
      if (other._resultDot != null)
        return false;
    } else if (!_resultDot.equals(other._resultDot))
      return false;
    if (_useCase2Graph == null) {
      if (other._useCase2Graph != null)
        return false;
    } else if (!_useCase2Graph.equals(other._useCase2Graph))
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
