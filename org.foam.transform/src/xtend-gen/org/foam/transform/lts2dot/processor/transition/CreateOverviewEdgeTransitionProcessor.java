package org.foam.transform.lts2dot.processor.transition;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.dot.DotFactory;
import org.foam.dot.Edge;
import org.foam.dot.Graph;
import org.foam.dot.Node;
import org.foam.dot.Statement;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.traceability.OverviewTransitionType;
import org.foam.traceability.OverviewTransitionTypeAnnotation;
import org.foam.transform.lts2dot.processor.transition.TransitionProcessor;

/**
 * @param resultDot out parameter, populated in this processor
 * @param state2Node in parameter, map has to contain mapping for source
 * 		and target of the edge before {@link process(Transition)} is called!
 */
@Data
@SuppressWarnings("all")
public class CreateOverviewEdgeTransitionProcessor implements TransitionProcessor {
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
  
  public void process(final Transition transition) {
    EList<Annotation> _annotations = transition.getAnnotations();
    Iterable<OverviewTransitionTypeAnnotation> _filter = Iterables.<OverviewTransitionTypeAnnotation>filter(_annotations, OverviewTransitionTypeAnnotation.class);
    OverviewTransitionTypeAnnotation _head = IterableExtensions.<OverviewTransitionTypeAnnotation>head(_filter);
    final OverviewTransitionType transitionType = _head.getOverviewTransitionType();
    DotFactory _dotFactory = this.getDotFactory();
    Edge _createEdge = _dotFactory.createEdge();
    final Procedure1<Edge> _function = new Procedure1<Edge>() {
      public void apply(final Edge it) {
        Map<State, Node> _state2Node = CreateOverviewEdgeTransitionProcessor.this.getState2Node();
        State _start = transition.getStart();
        Node _get = _state2Node.get(_start);
        it.setSource(_get);
        Map<State, Node> _state2Node_1 = CreateOverviewEdgeTransitionProcessor.this.getState2Node();
        State _end = transition.getEnd();
        Node _get_1 = _state2Node_1.get(_end);
        it.setTarget(_get_1);
        boolean _equals = Objects.equal(transitionType, OverviewTransitionType.INCLUDE);
        if (_equals) {
          EMap<String, String> _attributes = it.getAttributes();
          _attributes.put("style", "dashed");
          EMap<String, String> _attributes_1 = it.getAttributes();
          _attributes_1.put("arrowhead", "onormal");
        }
      }
    };
    final Edge edge = ObjectExtensions.<Edge>operator_doubleArrow(_createEdge, _function);
    Graph _resultDot = this.getResultDot();
    EList<Statement> _statements = _resultDot.getStatements();
    _statements.add(edge);
  }
  
  public CreateOverviewEdgeTransitionProcessor(final Graph resultDot, final Map<State, Node> state2Node) {
    super();
    this._resultDot = resultDot;
    this._state2Node = state2Node;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._resultDot== null) ? 0 : this._resultDot.hashCode());
    result = prime * result + ((this._state2Node== null) ? 0 : this._state2Node.hashCode());
    result = prime * result + ((this._dotFactory== null) ? 0 : this._dotFactory.hashCode());
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
    CreateOverviewEdgeTransitionProcessor other = (CreateOverviewEdgeTransitionProcessor) obj;
    if (this._resultDot == null) {
      if (other._resultDot != null)
        return false;
    } else if (!this._resultDot.equals(other._resultDot))
      return false;
    if (this._state2Node == null) {
      if (other._state2Node != null)
        return false;
    } else if (!this._state2Node.equals(other._state2Node))
      return false;
    if (this._dotFactory == null) {
      if (other._dotFactory != null)
        return false;
    } else if (!this._dotFactory.equals(other._dotFactory))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
