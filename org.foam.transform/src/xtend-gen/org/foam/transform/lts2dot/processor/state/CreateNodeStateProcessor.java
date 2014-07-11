package org.foam.transform.lts2dot.processor.state;

import com.google.common.base.Objects;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.dot.DotFactory;
import org.foam.dot.Graph;
import org.foam.dot.InnerNode;
import org.foam.dot.Node;
import org.foam.dot.RecordNode;
import org.foam.dot.Statement;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.transform.lts2dot.processor.state.StateProcessor;
import org.foam.transform.utils.model.ModelUtils;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;

/**
 * @param mapping in parameter
 * @param state2Node out parameter, populated in this processor
 * @param step2RecordNode out parameter, populated in this processor
 * @param state2Graph in parameter, map has to contain mapping from given state
 * 		to graph before {@link process(State)} is called!
 */
@Data
@SuppressWarnings("all")
public class CreateNodeStateProcessor implements StateProcessor {
  private final Map<State, Node> _state2Node;
  
  public Map<State, Node> getState2Node() {
    return this._state2Node;
  }
  
  private final Map<Step, RecordNode> _step2RecordNode;
  
  public Map<Step, RecordNode> getStep2RecordNode() {
    return this._step2RecordNode;
  }
  
  private final Map<State, Graph> _state2Graph;
  
  public Map<State, Graph> getState2Graph() {
    return this._state2Graph;
  }
  
  private final DotFactory _dotFactory = DotFactory.eINSTANCE;
  
  public DotFactory getDotFactory() {
    return this._dotFactory;
  }
  
  /**
   * Increment used to increase width of record node. Width of record node is
   *  increased for every inner node present inside record node.
   */
  private static double WIDTH_INCREMENT = 0.5;
  
  private static String WIDTH_ATTRIBUTE_MAP_KEY = "width";
  
  private static String TOOLTIP_ATTRIBUTE_MAP_KEY = "tooltip";
  
  public boolean process(final State state) {
    boolean _xblockexpression = false;
    {
      final StateType stateType = ModelUtils.getStateTypeFromStateTypeMappingAnnotation(state);
      boolean _notEquals = (!Objects.equal(stateType, null));
      if (_notEquals) {
        final Step step = ModelUtils.getStepFromStepMappingAnnotation(state);
        this.addRecordNode(state, stateType, step);
      } else {
        this.addNonRecordNode(state);
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean addNonRecordNode(final State state) {
    boolean _xblockexpression = false;
    {
      DotFactory _dotFactory = this.getDotFactory();
      Node _createNode = _dotFactory.createNode();
      final Procedure1<Node> _function = new Procedure1<Node>() {
        public void apply(final Node it) {
          String _id = state.getId();
          it.setId(_id);
        }
      };
      final Node node = ObjectExtensions.<Node>operator_doubleArrow(_createNode, _function);
      Map<State, Node> _state2Node = this.getState2Node();
      _state2Node.put(state, node);
      Map<State, Graph> _state2Graph = this.getState2Graph();
      Graph _get = _state2Graph.get(state);
      EList<Statement> _statements = _get.getStatements();
      _xblockexpression = _statements.add(node);
    }
    return _xblockexpression;
  }
  
  public Node addRecordNode(final State state, final StateType stateType, final Step step) {
    Node _xblockexpression = null;
    {
      Map<Step, RecordNode> _step2RecordNode = this.getStep2RecordNode();
      boolean _containsKey = _step2RecordNode.containsKey(step);
      boolean _not = (!_containsKey);
      if (_not) {
        DotFactory _dotFactory = this.getDotFactory();
        RecordNode _createRecordNode = _dotFactory.createRecordNode();
        final Procedure1<RecordNode> _function = new Procedure1<RecordNode>() {
          public void apply(final RecordNode it) {
            StringConcatenation _builder = new StringConcatenation();
            UseCase _useCase = UcmUtils.getUseCase(step);
            String _id = _useCase.getId();
            _builder.append(_id, "");
            String _label = step.getLabel();
            _builder.append(_label, "");
            it.setId(_builder.toString());
            EMap<String, String> _attributes = it.getAttributes();
            String _text = step.getText();
            _attributes.put(CreateNodeStateProcessor.TOOLTIP_ATTRIBUTE_MAP_KEY, _text);
            EMap<String, String> _attributes_1 = it.getAttributes();
            _attributes_1.put(CreateNodeStateProcessor.WIDTH_ATTRIBUTE_MAP_KEY, "0.0");
          }
        };
        final RecordNode recordNode = ObjectExtensions.<RecordNode>operator_doubleArrow(_createRecordNode, _function);
        Map<Step, RecordNode> _step2RecordNode_1 = this.getStep2RecordNode();
        _step2RecordNode_1.put(step, recordNode);
        Map<State, Graph> _state2Graph = this.getState2Graph();
        Graph _get = _state2Graph.get(state);
        EList<Statement> _statements = _get.getStatements();
        _statements.add(recordNode);
      }
      Map<Step, RecordNode> _step2RecordNode_2 = this.getStep2RecordNode();
      final RecordNode recordNode_1 = _step2RecordNode_2.get(step);
      DotFactory _dotFactory_1 = this.getDotFactory();
      InnerNode _createInnerNode = _dotFactory_1.createInnerNode();
      final Procedure1<InnerNode> _function_1 = new Procedure1<InnerNode>() {
        public void apply(final InnerNode it) {
          String _string = stateType.toString();
          it.setId(_string);
        }
      };
      final InnerNode innerNode = ObjectExtensions.<InnerNode>operator_doubleArrow(_createInnerNode, _function_1);
      EList<InnerNode> _innerNodes = recordNode_1.getInnerNodes();
      _innerNodes.add(innerNode);
      this.increaseRecordNodeWidth(recordNode_1);
      Map<State, Node> _state2Node = this.getState2Node();
      _xblockexpression = _state2Node.put(state, innerNode);
    }
    return _xblockexpression;
  }
  
  private String increaseRecordNodeWidth(final RecordNode node) {
    String _xblockexpression = null;
    {
      EMap<String, String> _attributes = node.getAttributes();
      String _get = _attributes.get(CreateNodeStateProcessor.WIDTH_ATTRIBUTE_MAP_KEY);
      final Double currentWidth = Double.valueOf(_get);
      final double newWidth = ((currentWidth).doubleValue() + CreateNodeStateProcessor.WIDTH_INCREMENT);
      EMap<String, String> _attributes_1 = node.getAttributes();
      String _string = Double.valueOf(newWidth).toString();
      _xblockexpression = _attributes_1.put(CreateNodeStateProcessor.WIDTH_ATTRIBUTE_MAP_KEY, _string);
    }
    return _xblockexpression;
  }
  
  public CreateNodeStateProcessor(final Map<State, Node> state2Node, final Map<Step, RecordNode> step2RecordNode, final Map<State, Graph> state2Graph) {
    super();
    this._state2Node = state2Node;
    this._step2RecordNode = step2RecordNode;
    this._state2Graph = state2Graph;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._state2Node== null) ? 0 : this._state2Node.hashCode());
    result = prime * result + ((this._step2RecordNode== null) ? 0 : this._step2RecordNode.hashCode());
    result = prime * result + ((this._state2Graph== null) ? 0 : this._state2Graph.hashCode());
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
    CreateNodeStateProcessor other = (CreateNodeStateProcessor) obj;
    if (this._state2Node == null) {
      if (other._state2Node != null)
        return false;
    } else if (!this._state2Node.equals(other._state2Node))
      return false;
    if (this._step2RecordNode == null) {
      if (other._step2RecordNode != null)
        return false;
    } else if (!this._step2RecordNode.equals(other._step2RecordNode))
      return false;
    if (this._state2Graph == null) {
      if (other._state2Graph != null)
        return false;
    } else if (!this._state2Graph.equals(other._state2Graph))
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
