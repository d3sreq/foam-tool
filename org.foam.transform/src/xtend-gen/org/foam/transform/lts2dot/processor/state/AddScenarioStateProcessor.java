package org.foam.transform.lts2dot.processor.state;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.foam.transform.utils.model.ModelUtils;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;

/**
 * Creates subgraph (cluster) for use case and scenario of the given state if this subgraph is
 * not already present in {@code processorData}.
 */
@Data
@SuppressWarnings("all")
public class AddScenarioStateProcessor implements StateProcessor {
  private final Graph _resultDot;
  
  public Graph getResultDot() {
    return this._resultDot;
  }
  
  private final Map<State, Graph> _state2Graph;
  
  public Map<State, Graph> getState2Graph() {
    return this._state2Graph;
  }
  
  private final Map<Scenario, Graph> _scenario2Graph;
  
  public Map<Scenario, Graph> getScenario2Graph() {
    return this._scenario2Graph;
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
      this.addScenarioSubGraph(state);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private Graph addScenarioSubGraph(final State state) {
    Graph _xblockexpression = null;
    {
      final Step step = ModelUtils.getStepFromStepMappingAnnotation(state);
      Graph _xifexpression = null;
      boolean _equals = Objects.equal(step, null);
      if (_equals) {
        _xifexpression = this.getResultDot();
      } else {
        Graph _xblockexpression_1 = null;
        {
          final Scenario scenario = UcmUtils.getScenario(step);
          Map<Scenario, Graph> _scenario2Graph = this.getScenario2Graph();
          boolean _containsKey = _scenario2Graph.containsKey(scenario);
          boolean _not = (!_containsKey);
          if (_not) {
            DotFactory _dotFactory = this.getDotFactory();
            Graph _createGraph = _dotFactory.createGraph();
            final Procedure1<Graph> _function = new Procedure1<Graph>() {
              public void apply(final Graph it) {
                StringConcatenation _builder = new StringConcatenation();
                UseCase _useCase = UcmUtils.getUseCase(scenario);
                String _id = _useCase.getId();
                _builder.append(_id, "");
                _builder.append("_");
                String _label = scenario.getLabel();
                _builder.append(_label, "");
                it.setId(_builder.toString());
                boolean _isMainScenario = AddScenarioStateProcessor.this.isMainScenario(scenario);
                boolean _not = (!_isMainScenario);
                if (_not) {
                  EList<Statement> _statements = it.getStatements();
                  DotFactory _dotFactory = AddScenarioStateProcessor.this.getDotFactory();
                  Assignment _createAssignment = _dotFactory.createAssignment();
                  final Procedure1<Assignment> _function = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("label");
                      StringConcatenation _builder = new StringConcatenation();
                      {
                        boolean _isExtensionBranch = AddScenarioStateProcessor.this.isExtensionBranch(scenario);
                        if (_isExtensionBranch) {
                          _builder.append("Extension: ");
                          String _label = scenario.getLabel();
                          _builder.append(_label, "");
                          _builder.append(".\\l");
                        }
                      }
                      _builder.newLineIfNotEmpty();
                      {
                        boolean _isVariationBranch = AddScenarioStateProcessor.this.isVariationBranch(scenario);
                        if (_isVariationBranch) {
                          _builder.append("Variation: ");
                          String _label_1 = scenario.getLabel();
                          _builder.append(_label_1, "");
                          _builder.append(".\\l");
                        }
                      }
                      _builder.newLineIfNotEmpty();
                      String _text = scenario.getText();
                      _builder.append(_text, "");
                      _builder.newLineIfNotEmpty();
                      String _string = _builder.toString();
                      String _replaceAll = _string.replaceAll("\\s+", " ");
                      it.setValue(_replaceAll);
                    }
                  };
                  Assignment _doubleArrow = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment, _function);
                  _statements.add(_doubleArrow);
                  EList<Statement> _statements_1 = it.getStatements();
                  DotFactory _dotFactory_1 = AddScenarioStateProcessor.this.getDotFactory();
                  Assignment _createAssignment_1 = _dotFactory_1.createAssignment();
                  final Procedure1<Assignment> _function_1 = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("bgcolor");
                      it.setValue("#f2f2f2");
                    }
                  };
                  Assignment _doubleArrow_1 = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment_1, _function_1);
                  _statements_1.add(_doubleArrow_1);
                  EList<Statement> _statements_2 = it.getStatements();
                  DotFactory _dotFactory_2 = AddScenarioStateProcessor.this.getDotFactory();
                  Assignment _createAssignment_2 = _dotFactory_2.createAssignment();
                  final Procedure1<Assignment> _function_2 = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("fontcolor");
                      it.setValue("gray");
                    }
                  };
                  Assignment _doubleArrow_2 = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment_2, _function_2);
                  _statements_2.add(_doubleArrow_2);
                } else {
                  EList<Statement> _statements_3 = it.getStatements();
                  DotFactory _dotFactory_3 = AddScenarioStateProcessor.this.getDotFactory();
                  Assignment _createAssignment_3 = _dotFactory_3.createAssignment();
                  final Procedure1<Assignment> _function_3 = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("bgcolor");
                      it.setValue("#ffffcc");
                    }
                  };
                  Assignment _doubleArrow_3 = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment_3, _function_3);
                  _statements_3.add(_doubleArrow_3);
                  EList<Statement> _statements_4 = it.getStatements();
                  DotFactory _dotFactory_4 = AddScenarioStateProcessor.this.getDotFactory();
                  Assignment _createAssignment_4 = _dotFactory_4.createAssignment();
                  final Procedure1<Assignment> _function_4 = new Procedure1<Assignment>() {
                    public void apply(final Assignment it) {
                      it.setKey("label");
                      it.setValue("");
                    }
                  };
                  Assignment _doubleArrow_4 = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment_4, _function_4);
                  _statements_4.add(_doubleArrow_4);
                }
                EList<Statement> _statements_5 = it.getStatements();
                DotFactory _dotFactory_5 = AddScenarioStateProcessor.this.getDotFactory();
                Assignment _createAssignment_5 = _dotFactory_5.createAssignment();
                final Procedure1<Assignment> _function_5 = new Procedure1<Assignment>() {
                  public void apply(final Assignment it) {
                    it.setKey("margin");
                    it.setValue("30");
                  }
                };
                Assignment _doubleArrow_5 = ObjectExtensions.<Assignment>operator_doubleArrow(_createAssignment_5, _function_5);
                _statements_5.add(_doubleArrow_5);
              }
            };
            final Graph subGraph = ObjectExtensions.<Graph>operator_doubleArrow(_createGraph, _function);
            Map<Scenario, Graph> _scenario2Graph_1 = this.getScenario2Graph();
            _scenario2Graph_1.put(scenario, subGraph);
            final UseCase uc = UcmUtils.getUseCase(step);
            Map<UseCase, Graph> _useCase2Graph = this.getUseCase2Graph();
            final Graph ucGraph = _useCase2Graph.get(uc);
            EList<Statement> _statements = ucGraph.getStatements();
            _statements.add(subGraph);
          }
          Map<Scenario, Graph> _scenario2Graph_2 = this.getScenario2Graph();
          _xblockexpression_1 = _scenario2Graph_2.get(scenario);
        }
        _xifexpression = _xblockexpression_1;
      }
      final Graph graphForNode = _xifexpression;
      Map<State, Graph> _state2Graph = this.getState2Graph();
      _xblockexpression = _state2Graph.put(state, graphForNode);
    }
    return _xblockexpression;
  }
  
  private boolean isMainScenario(final Scenario scenario) {
    EObject _eContainer = scenario.eContainer();
    return (_eContainer instanceof UseCase);
  }
  
  private boolean isExtensionBranch(final Scenario scenario) {
    boolean _xblockexpression = false;
    {
      final EObject container = scenario.eContainer();
      if ((!(container instanceof ScenarioHolder))) {
        return false;
      }
      final ScenarioHolder scenHolder = ((ScenarioHolder) container);
      EList<Scenario> _extensions = scenHolder.getExtensions();
      _xblockexpression = _extensions.contains(scenario);
    }
    return _xblockexpression;
  }
  
  private boolean isVariationBranch(final Scenario scenario) {
    boolean _xblockexpression = false;
    {
      final EObject container = scenario.eContainer();
      if ((!(container instanceof ScenarioHolder))) {
        return false;
      }
      final ScenarioHolder scenHolder = ((ScenarioHolder) container);
      EList<Scenario> _variations = scenHolder.getVariations();
      _xblockexpression = _variations.contains(scenario);
    }
    return _xblockexpression;
  }
  
  public AddScenarioStateProcessor(final Graph resultDot, final Map<State, Graph> state2Graph, final Map<Scenario, Graph> scenario2Graph, final Map<UseCase, Graph> useCase2Graph) {
    super();
    this._resultDot = resultDot;
    this._state2Graph = state2Graph;
    this._scenario2Graph = scenario2Graph;
    this._useCase2Graph = useCase2Graph;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_resultDot== null) ? 0 : _resultDot.hashCode());
    result = prime * result + ((_state2Graph== null) ? 0 : _state2Graph.hashCode());
    result = prime * result + ((_scenario2Graph== null) ? 0 : _scenario2Graph.hashCode());
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
    AddScenarioStateProcessor other = (AddScenarioStateProcessor) obj;
    if (_resultDot == null) {
      if (other._resultDot != null)
        return false;
    } else if (!_resultDot.equals(other._resultDot))
      return false;
    if (_state2Graph == null) {
      if (other._state2Graph != null)
        return false;
    } else if (!_state2Graph.equals(other._state2Graph))
      return false;
    if (_scenario2Graph == null) {
      if (other._scenario2Graph != null)
        return false;
    } else if (!_scenario2Graph.equals(other._scenario2Graph))
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
