package org.foam.transform.dot2dotlang;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.dot.Assignment;
import org.foam.dot.AttributedItem;
import org.foam.dot.Edge;
import org.foam.dot.Graph;
import org.foam.dot.InnerNode;
import org.foam.dot.Node;
import org.foam.dot.RecordNode;
import org.foam.dot.Settings;
import org.foam.dot.SettingsType;
import org.foam.dot.Statement;

@SuppressWarnings("all")
public class Dot2DotLang {
  private final static String LABEL_ATTRIBUTE_KEY = "label";
  
  public CharSequence transform(final Graph graph) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("digraph mygraph {");
    _builder.newLine();
    {
      EList<Statement> _statements = graph.getStatements();
      for(final Statement statement : _statements) {
        _builder.append("\t");
        CharSequence _print = this.print(statement);
        _builder.append(_print, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _print(final Graph subgraph) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("subgraph cluster_");
    String _id = subgraph.getId();
    _builder.append(_id, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Statement> _statements = subgraph.getStatements();
      for(final Statement statement : _statements) {
        _builder.append("\t");
        Object _print = this.print(statement);
        _builder.append(_print, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence _print(final Node node) {
    CharSequence _xblockexpression = null;
    {
      if ((node instanceof RecordNode)) {
        final RecordNode recordNode = ((RecordNode) node);
        EList<InnerNode> _innerNodes = recordNode.getInnerNodes();
        final Function1<InnerNode, String> _function = new Function1<InnerNode, String>() {
          public String apply(final InnerNode it) {
            String _xblockexpression = null;
            {
              String _elvis = null;
              EMap<String, String> _attributes = it.getAttributes();
              String _get = _attributes.get(Dot2DotLang.LABEL_ATTRIBUTE_KEY);
              if (_get != null) {
                _elvis = _get;
              } else {
                _elvis = "";
              }
              final String innerNodeLabel = _elvis;
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("<");
              String _id = it.getId();
              _builder.append(_id, "");
              _builder.append(">");
              String _escape = Dot2DotLang.this.escape(innerNodeLabel);
              _builder.append(_escape, "");
              _xblockexpression = _builder.toString();
            }
            return _xblockexpression;
          }
        };
        final String labelValue = IterableExtensions.<InnerNode>join(_innerNodes, "{", "|", "}", _function);
        EMap<String, String> _attributes = recordNode.getAttributes();
        _attributes.put(Dot2DotLang.LABEL_ATTRIBUTE_KEY, labelValue);
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _id = node.getId();
      _builder.append(_id, "");
      _builder.append("\" ");
      String _createAttributeList = this.createAttributeList(node);
      _builder.append(_createAttributeList, "");
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  private CharSequence _print(final Edge edge) {
    StringConcatenation _builder = new StringConcatenation();
    Node _source = edge.getSource();
    CharSequence _edgeNodeId = this.edgeNodeId(_source);
    _builder.append(_edgeNodeId, "");
    _builder.append(" -> ");
    Node _target = edge.getTarget();
    CharSequence _edgeNodeId_1 = this.edgeNodeId(_target);
    _builder.append(_edgeNodeId_1, "");
    _builder.append(" ");
    String _createAttributeList = this.createAttributeList(edge);
    _builder.append(_createAttributeList, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _print(final Assignment assignment) {
    StringConcatenation _builder = new StringConcatenation();
    String _key = assignment.getKey();
    _builder.append(_key, "");
    _builder.append("=\"");
    String _value = assignment.getValue();
    String _escape = this.escape(_value);
    _builder.append(_escape, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence _print(final Settings settings) {
    StringConcatenation _builder = new StringConcatenation();
    SettingsType _type = settings.getType();
    String _literal = _type.getLiteral();
    _builder.append(_literal, "");
    _builder.append(" [");
    _builder.newLineIfNotEmpty();
    {
      EMap<String, String> _attributes = settings.getAttributes();
      boolean _hasElements = false;
      for(final Map.Entry<String, String> attribute : _attributes) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        String _key = attribute.getKey();
        _builder.append(_key, "\t");
        _builder.append("=\"");
        String _value = attribute.getValue();
        String _escape = this.escape(_value);
        _builder.append(_escape, "\t");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  private CharSequence edgeNodeId(final Node node) {
    CharSequence _xifexpression = null;
    if ((node instanceof InnerNode)) {
      CharSequence _xblockexpression = null;
      {
        final InnerNode innerNode = ((InnerNode) node);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        RecordNode _recordNode = innerNode.getRecordNode();
        String _id = _recordNode.getId();
        _builder.append(_id, "");
        _builder.append("\":\"");
        String _id_1 = innerNode.getId();
        _builder.append(_id_1, "");
        _builder.append("\"");
        _xblockexpression = _builder;
      }
      _xifexpression = _xblockexpression;
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _id = node.getId();
      _builder.append(_id, "");
      _builder.append("\"");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  private String createAttributeList(final AttributedItem attributedItem) {
    String _xblockexpression = null;
    {
      EMap<String, String> _attributes = attributedItem.getAttributes();
      boolean _isEmpty = _attributes.isEmpty();
      if (_isEmpty) {
        return "";
      }
      EMap<String, String> _attributes_1 = attributedItem.getAttributes();
      Set<Map.Entry<String, String>> _entrySet = _attributes_1.entrySet();
      final Function1<Map.Entry<String, String>, String> _function = new Function1<Map.Entry<String, String>, String>() {
        public String apply(final Map.Entry<String, String> it) {
          StringConcatenation _builder = new StringConcatenation();
          String _key = it.getKey();
          _builder.append(_key, "");
          _builder.append("=\"");
          String _value = it.getValue();
          String _escape = Dot2DotLang.this.escape(_value);
          _builder.append(_escape, "");
          _builder.append("\"");
          return _builder.toString();
        }
      };
      _xblockexpression = IterableExtensions.<Map.Entry<String, String>>join(_entrySet, "[", ", ", "]", _function);
    }
    return _xblockexpression;
  }
  
  private String escape(final String toEscape) {
    String _xifexpression = null;
    boolean _equals = Objects.equal(toEscape, null);
    if (_equals) {
      _xifexpression = "";
    } else {
      _xifexpression = toEscape.replaceAll("\"", "\\\\\"");
    }
    return _xifexpression;
  }
  
  private CharSequence print(final Statement assignment) {
    if (assignment instanceof Assignment) {
      return _print((Assignment)assignment);
    } else if (assignment instanceof Edge) {
      return _print((Edge)assignment);
    } else if (assignment instanceof Graph) {
      return _print((Graph)assignment);
    } else if (assignment instanceof Node) {
      return _print((Node)assignment);
    } else if (assignment instanceof Settings) {
      return _print((Settings)assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment).toString());
    }
  }
}
