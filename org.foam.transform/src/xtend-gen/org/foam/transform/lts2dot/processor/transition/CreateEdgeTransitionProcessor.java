package org.foam.transform.lts2dot.processor.transition;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.DotFactory;
import org.foam.dot.Edge;
import org.foam.dot.Graph;
import org.foam.dot.Node;
import org.foam.dot.Statement;
import org.foam.flowannotation.Guard;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.transform.lts2dot.processor.transition.TransitionProcessor;
import org.foam.transform.utils.modeling.ModelUtils;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;
import org.foam.verification.Action;

/**
 * @param resultDot out parameter, populated in this processor
 * @param state2Node in parameter, map has to contain mapping for source
 * 		and target of the edge before {@link process(Transition)} is called!
 */
@Data
@SuppressWarnings("all")
public class CreateEdgeTransitionProcessor implements TransitionProcessor {
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
  
  public boolean process(final Transition transition) {
    boolean _xblockexpression = false;
    {
      DotFactory _dotFactory = this.getDotFactory();
      Edge _createEdge = _dotFactory.createEdge();
      final Procedure1<Edge> _function = new Procedure1<Edge>() {
        public void apply(final Edge it) {
          Map<State, Node> _state2Node = CreateEdgeTransitionProcessor.this.getState2Node();
          State _start = transition.getStart();
          Node _get = _state2Node.get(_start);
          it.setSource(_get);
          Map<State, Node> _state2Node_1 = CreateEdgeTransitionProcessor.this.getState2Node();
          State _end = transition.getEnd();
          Node _get_1 = _state2Node_1.get(_end);
          it.setTarget(_get_1);
          State _start_1 = transition.getStart();
          final Step step = ModelUtils.getStepFromStepMappingAnnotation(_start_1);
          boolean _notEquals = (!Objects.equal(step, null));
          if (_notEquals) {
            EMap<String, String> _attributes = it.getAttributes();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("#");
            UseCase _useCase = UcmUtils.getUseCase(step);
            String _id = _useCase.getId();
            _builder.append(_id, "");
            _builder.append("_");
            String _label = step.getLabel();
            _builder.append(_label, "");
            _attributes.put("URL", _builder.toString());
          }
          EList<Annotation> _annotations = transition.getAnnotations();
          Iterable<Action> _filter = Iterables.<Action>filter(_annotations, Action.class);
          for (final Action action : _filter) {
            {
              EMap<String, String> _attributes_1 = it.getAttributes();
              _attributes_1.put("color", "blueviolet");
              EMap<String, String> _attributes_2 = it.getAttributes();
              _attributes_2.put("fontcolor", "blueviolet");
              StringConcatenation _builder_1 = new StringConcatenation();
              _builder_1.append("action: ");
              VariableDefinition _variableDefinition = action.getVariableDefinition();
              String _name = _variableDefinition.getName();
              _builder_1.append(_name, "");
              _builder_1.append(" := ");
              boolean _isValue = action.isValue();
              _builder_1.append(_isValue, "");
              CreateEdgeTransitionProcessor.this.addTooltip(it, _builder_1.toString());
            }
          }
          EList<Annotation> _annotations_1 = transition.getAnnotations();
          Iterable<Guard> _filter_1 = Iterables.<Guard>filter(_annotations_1, Guard.class);
          for (final Guard guard : _filter_1) {
            {
              EMap<String, String> _attributes_1 = it.getAttributes();
              _attributes_1.put("color", "blueviolet");
              EMap<String, String> _attributes_2 = it.getAttributes();
              _attributes_2.put("fontcolor", "blueviolet");
              Formula _formula = guard.getFormula();
              String _plus = ("guard: " + _formula);
              CreateEdgeTransitionProcessor.this.addTooltip(it, _plus);
            }
          }
        }
      };
      final Edge edge = ObjectExtensions.<Edge>operator_doubleArrow(_createEdge, _function);
      Graph _resultDot = this.getResultDot();
      EList<Statement> _statements = _resultDot.getStatements();
      _statements.add(edge);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public void addTooltip(final Edge edge, final String tooltipStr) {
    EMap<String, String> _attributes = edge.getAttributes();
    final String tooltipAttr = _attributes.get("tooltip");
    EMap<String, String> _attributes_1 = edge.getAttributes();
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equal(tooltipAttr, null));
      if (_notEquals) {
        _builder.append(tooltipAttr, "");
        _builder.append("; ");
      }
    }
    _builder.append(tooltipStr, "");
    _attributes_1.put(
      "tooltip", _builder.toString());
  }
  
  public CreateEdgeTransitionProcessor(final Graph resultDot, final Map<State, Node> state2Node) {
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
    CreateEdgeTransitionProcessor other = (CreateEdgeTransitionProcessor) obj;
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
