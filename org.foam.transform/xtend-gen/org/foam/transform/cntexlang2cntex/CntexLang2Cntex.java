package org.foam.transform.cntexlang2cntex;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.foam.cntex.CntExAssignment;
import org.foam.cntex.CntExState;
import org.foam.cntex.CntexFactory;
import org.foam.cntex.CounterExample;
import org.foam.cntex.Specification;
import org.foam.cntex.Trace;

@SuppressWarnings("all")
public class CntexLang2Cntex {
  private final static String SPECIFICATION_REGEXP = "-- specification (.*)  is (\\w+)";
  
  private final static String COMMENT_PREFIX = "***";
  
  private final static String TRACE_DESCRIPTION_REGEXP = "Trace Description: (.*)";
  
  private final static String TRACE_TYPE_REGEXP = "Trace Type: (.*)";
  
  private final static String STATE_REGEXP = "-> State: ((\\d+)\\.(\\d+)) <-";
  
  private final static String ASSIGNMENT_REGEXP = "(\\S+) = (\\S+)";
  
  private final static String LOOP_LINE = "-- Loop starts here";
  
  private final static String AS_DEMONSTRATED_LINE = "-- as demonstrated by the following execution sequence";
  
  private final CntexFactory cntexFactory = CntexFactory.eINSTANCE;
  
  public CounterExample transform(final String text) {
    CounterExample _xblockexpression = null;
    {
      final CounterExample result = this.cntexFactory.createCounterExample();
      Splitter _on = Splitter.on("\n");
      final Splitter splitter = _on.trimResults();
      Iterable<String> _split = splitter.split(text);
      final LinkedList<String> lines = Lists.<String>newLinkedList(_split);
      this.popEmptyOrComments(lines);
      boolean _isEmpty = lines.isEmpty();
      boolean _not = (!_isEmpty);
      boolean _while = _not;
      while (_while) {
        {
          String _peek = lines.peek();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_peek);
          if (_isNullOrEmpty) {
            return result;
          }
          EList<Specification> _specifications = result.getSpecifications();
          Specification _parseSpecification = this.parseSpecification(lines);
          _specifications.add(_parseSpecification);
        }
        boolean _isEmpty_1 = lines.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _while = _not_1;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private Specification parseSpecification(final LinkedList<String> lines) {
    try {
      Specification _xblockexpression = null;
      {
        final Pattern docCommentPattern = Pattern.compile(CntexLang2Cntex.SPECIFICATION_REGEXP);
        String line = lines.pop();
        final Matcher matcher = docCommentPattern.matcher(line);
        boolean _matches = matcher.matches();
        boolean _not = (!_matches);
        if (_not) {
          throw new ParseException(("Expected documentation comment but was: " + line), (-1));
        }
        final Specification result = this.cntexFactory.createSpecification();
        final String isCorrect = matcher.group(2);
        boolean _and = false;
        boolean _notEquals = (!Objects.equal(isCorrect, "true"));
        if (!_notEquals) {
          _and = false;
        } else {
          boolean _notEquals_1 = (!Objects.equal(isCorrect, "false"));
          _and = _notEquals_1;
        }
        if (_and) {
          throw new ParseException(("Expected documentation comment ends with \'true\'/\'false\': " + line), (-1));
        }
        boolean _equals = Objects.equal(isCorrect, "false");
        if (_equals) {
          String _pop = lines.pop();
          this.checkLineMatches(_pop, CntexLang2Cntex.AS_DEMONSTRATED_LINE);
          Trace _parseTrace = this.parseTrace(lines);
          result.setTrace(_parseTrace);
        }
        String _group = matcher.group(1);
        result.setTextFormula(_group);
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void checkLineMatches(final String line, final String regexp) {
    try {
      boolean _matches = line.matches(regexp);
      boolean _not = (!_matches);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Expected line matching \"");
        _builder.append(regexp, "");
        _builder.append("\" but was: ");
        _builder.append(line, "");
        throw new ParseException(_builder.toString(), (-1));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private Trace parseTrace(final LinkedList<String> lines) {
    try {
      Trace _xblockexpression = null;
      {
        final Trace result = this.cntexFactory.createTrace();
        String _pop = lines.pop();
        this.checkLineMatches(_pop, CntexLang2Cntex.TRACE_DESCRIPTION_REGEXP);
        String _pop_1 = lines.pop();
        this.checkLineMatches(_pop_1, CntexLang2Cntex.TRACE_TYPE_REGEXP);
        boolean nextStateIsLoopStart = false;
        boolean firstLoopProcessed = false;
        boolean _isEmpty = lines.isEmpty();
        boolean _not = (!_isEmpty);
        boolean _while = _not;
        while (_while) {
          {
            final String line = lines.pop();
            boolean _equals = Objects.equal(line, CntexLang2Cntex.LOOP_LINE);
            if (_equals) {
              nextStateIsLoopStart = true;
            } else {
              boolean _matches = line.matches(CntexLang2Cntex.SPECIFICATION_REGEXP);
              if (_matches) {
                lines.addFirst(line);
                return result;
              } else {
                boolean _matches_1 = line.matches(CntexLang2Cntex.STATE_REGEXP);
                if (_matches_1) {
                  lines.addFirst(line);
                  final CntExState state = this.parseState(lines);
                  EList<CntExState> _states = result.getStates();
                  _states.add(state);
                  if (nextStateIsLoopStart) {
                    nextStateIsLoopStart = false;
                    if ((!firstLoopProcessed)) {
                      result.setLoopStart(state);
                      firstLoopProcessed = true;
                    }
                  }
                } else {
                  boolean _isEmpty_1 = line.isEmpty();
                  if (_isEmpty_1) {
                    return result;
                  } else {
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("Unexpected line while parsing trace: \"");
                    _builder.append(line, "");
                    _builder.append("\"");
                    throw new ParseException(_builder.toString(), (-1));
                  }
                }
              }
            }
          }
          boolean _isEmpty_1 = lines.isEmpty();
          boolean _not_1 = (!_isEmpty_1);
          _while = _not_1;
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private CntExState parseState(final LinkedList<String> lines) {
    CntExState _xblockexpression = null;
    {
      final Pattern assignmentPattern = Pattern.compile(CntexLang2Cntex.ASSIGNMENT_REGEXP);
      final CntExState result = this.cntexFactory.createCntExState();
      String _pop = lines.pop();
      this.checkLineMatches(_pop, CntexLang2Cntex.STATE_REGEXP);
      boolean _isEmpty = lines.isEmpty();
      boolean _not = (!_isEmpty);
      boolean _while = _not;
      while (_while) {
        {
          final String line = lines.pop();
          final Matcher matcher = assignmentPattern.matcher(line);
          boolean _matches = matcher.matches();
          boolean _not_1 = (!_matches);
          if (_not_1) {
            lines.addFirst(line);
            return result;
          } else {
            EList<CntExAssignment> _assignments = result.getAssignments();
            CntExAssignment _createCntExAssignment = this.cntexFactory.createCntExAssignment();
            final Procedure1<CntExAssignment> _function = new Procedure1<CntExAssignment>() {
              public void apply(final CntExAssignment it) {
                String _group = matcher.group(1);
                it.setVariableName(_group);
                String _group_1 = matcher.group(2);
                it.setValue(_group_1);
              }
            };
            CntExAssignment _doubleArrow = ObjectExtensions.<CntExAssignment>operator_doubleArrow(_createCntExAssignment, _function);
            _assignments.add(_doubleArrow);
          }
        }
        boolean _isEmpty_1 = lines.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        _while = _not_1;
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private void popEmptyOrComments(final LinkedList<String> lines) {
    boolean _isEmpty = lines.isEmpty();
    boolean _not = (!_isEmpty);
    boolean _while = _not;
    while (_while) {
      {
        final String line = lines.pop();
        boolean _and = false;
        boolean _isEmpty_1 = line.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (!_not_1) {
          _and = false;
        } else {
          boolean _startsWith = line.startsWith(CntexLang2Cntex.COMMENT_PREFIX);
          boolean _not_2 = (!_startsWith);
          _and = _not_2;
        }
        if (_and) {
          lines.addFirst(line);
          return;
        }
      }
      boolean _isEmpty_1 = lines.isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      _while = _not_1;
    }
  }
}
