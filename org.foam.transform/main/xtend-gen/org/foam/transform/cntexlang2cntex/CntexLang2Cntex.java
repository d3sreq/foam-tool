package org.foam.transform.cntexlang2cntex;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  public CounterExample transform(final CharSequence text) {
    CounterExample _createCounterExample = this.cntexFactory.createCounterExample();
    final Procedure1<CounterExample> _function = new Procedure1<CounterExample>() {
      public void apply(final CounterExample it) {
        EList<Specification> _specifications = it.getSpecifications();
        String _string = text.toString();
        String[] _split = _string.split("\n");
        final Function1<String, String> _function = new Function1<String, String>() {
          public String apply(final String it) {
            return it.trim();
          }
        };
        List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
        final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
          public Boolean apply(final String it) {
            boolean _isEmpty = it.isEmpty();
            return Boolean.valueOf((!_isEmpty));
          }
        };
        Iterable<String> _filter = IterableExtensions.<String>filter(_map, _function_1);
        final Function1<String, Boolean> _function_2 = new Function1<String, Boolean>() {
          public Boolean apply(final String it) {
            boolean _startsWith = it.startsWith(CntexLang2Cntex.COMMENT_PREFIX);
            return Boolean.valueOf((!_startsWith));
          }
        };
        Iterable<String> _filter_1 = IterableExtensions.<String>filter(_filter, _function_2);
        final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
          public Boolean apply(final String it) {
            return Boolean.valueOf(it.matches(CntexLang2Cntex.SPECIFICATION_REGEXP));
          }
        };
        Iterable<? extends Iterable<String>> _split_1 = org.foam.transform.utils.modeling.IterableExtensions.<String>split(_filter_1, _function_3);
        Iterable<? extends Iterable<String>> _tail = IterableExtensions.tail(_split_1);
        final Function1<Iterable<String>, Specification> _function_4 = new Function1<Iterable<String>, Specification>() {
          public Specification apply(final Iterable<String> it) {
            return CntexLang2Cntex.this.parseSpecification(it);
          }
        };
        Iterable<Specification> _map_1 = IterableExtensions.map(_tail, _function_4);
        Iterables.<Specification>addAll(_specifications, _map_1);
      }
    };
    return ObjectExtensions.<CounterExample>operator_doubleArrow(_createCounterExample, _function);
  }
  
  private final static Pattern SPEC_PATTERN = Pattern.compile(CntexLang2Cntex.SPECIFICATION_REGEXP);
  
  private Specification parseSpecification(final Iterable<String> lines) {
    try {
      final String specLine = IterableExtensions.<String>head(lines);
      final Matcher matcher = CntexLang2Cntex.SPEC_PATTERN.matcher(specLine);
      boolean _matches = matcher.matches();
      boolean _not = (!_matches);
      if (_not) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Expected documentation comment but was: ");
        _builder.append(specLine, "");
        throw new ParseException(_builder.toString(), (-1));
      }
      final String isCorrect = matcher.group(2);
      final Specification result = this.cntexFactory.createSpecification();
      String _group = matcher.group(1);
      result.setTextFormula(_group);
      boolean _equals = Objects.equal(isCorrect, "true");
      if (_equals) {
        return result;
      }
      boolean _equals_1 = Objects.equal(isCorrect, "false");
      if (_equals_1) {
        final Iterable<String> linesWithoutFirst = IterableExtensions.<String>tail(lines);
        String _head = IterableExtensions.<String>head(linesWithoutFirst);
        this.checkLineMatches(_head, CntexLang2Cntex.AS_DEMONSTRATED_LINE);
        Iterable<String> _tail = IterableExtensions.<String>tail(linesWithoutFirst);
        Trace _parseTrace = this.parseTrace(_tail);
        result.setTrace(_parseTrace);
        return result;
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Expected documentation comment ends with \'true\'/\'false\': ");
      _builder_1.append(specLine, "");
      throw new ParseException(_builder_1.toString(), (-1));
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
  
  /**
   * Parses the stack trace from NuSMV plain text as a
   */
  private Trace parseTrace(final Iterable<String> lines) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.matches(CntexLang2Cntex.TRACE_DESCRIPTION_REGEXP));
      }
    };
    Iterable<String> _checkConsumed = org.foam.transform.utils.modeling.IterableExtensions.<String>checkConsumed(lines, _function);
    final Function1<String, Boolean> _function_1 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.matches(CntexLang2Cntex.TRACE_TYPE_REGEXP));
      }
    };
    final Iterable<String> checkedLines = org.foam.transform.utils.modeling.IterableExtensions.<String>checkConsumed(_checkConsumed, _function_1);
    final Function1<String, Boolean> _function_2 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.equals(CntexLang2Cntex.LOOP_LINE));
      }
    };
    final Iterable<? extends Iterable<String>> splitByLoops = org.foam.transform.utils.modeling.IterableExtensions.<String>split(checkedLines, _function_2);
    Iterable<String> _head = IterableExtensions.head(splitByLoops);
    final Function1<String, Boolean> _function_3 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("-> State:"));
      }
    };
    Iterable<? extends Iterable<String>> _split = org.foam.transform.utils.modeling.IterableExtensions.<String>split(_head, _function_3);
    final Function1<Iterable<String>, Boolean> _function_4 = new Function1<Iterable<String>, Boolean>() {
      public Boolean apply(final Iterable<String> it) {
        return Boolean.valueOf(IterableExtensions.isEmpty(it));
      }
    };
    Iterable<? extends Iterable<String>> _checkConsumed_1 = org.foam.transform.utils.modeling.IterableExtensions.checkConsumed(_split, _function_4);
    final Function1<Iterable<String>, CntExState> _function_5 = new Function1<Iterable<String>, CntExState>() {
      public CntExState apply(final Iterable<String> it) {
        return CntexLang2Cntex.this.parseState(it);
      }
    };
    Iterable<CntExState> _map = IterableExtensions.map(_checkConsumed_1, _function_5);
    final List<CntExState> statesBeforeLoop = IterableExtensions.<CntExState>toList(_map);
    Iterable<? extends Iterable<String>> _tail = IterableExtensions.tail(splitByLoops);
    final Function1<Iterable<String>, Iterable<String>> _function_6 = new Function1<Iterable<String>, Iterable<String>>() {
      public Iterable<String> apply(final Iterable<String> it) {
        final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
          public Boolean apply(final String it) {
            return Boolean.valueOf(it.equals(CntexLang2Cntex.LOOP_LINE));
          }
        };
        return org.foam.transform.utils.modeling.IterableExtensions.<String>checkConsumed(it, _function);
      }
    };
    Iterable<Iterable<String>> _map_1 = IterableExtensions.map(_tail, _function_6);
    Iterable<String> _flatten = Iterables.<String>concat(_map_1);
    final Function1<String, Boolean> _function_7 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("-> State:"));
      }
    };
    Iterable<? extends Iterable<String>> _split_1 = org.foam.transform.utils.modeling.IterableExtensions.<String>split(_flatten, _function_7);
    final Function1<Iterable<String>, Boolean> _function_8 = new Function1<Iterable<String>, Boolean>() {
      public Boolean apply(final Iterable<String> it) {
        return Boolean.valueOf(IterableExtensions.isEmpty(it));
      }
    };
    Iterable<? extends Iterable<String>> _checkConsumed_2 = org.foam.transform.utils.modeling.IterableExtensions.checkConsumed(_split_1, _function_8);
    final Function1<Iterable<String>, CntExState> _function_9 = new Function1<Iterable<String>, CntExState>() {
      public CntExState apply(final Iterable<String> it) {
        return CntexLang2Cntex.this.parseState(it);
      }
    };
    Iterable<CntExState> _map_2 = IterableExtensions.map(_checkConsumed_2, _function_9);
    final List<CntExState> statesInLoop = IterableExtensions.<CntExState>toList(_map_2);
    Trace _createTrace = this.cntexFactory.createTrace();
    final Procedure1<Trace> _function_10 = new Procedure1<Trace>() {
      public void apply(final Trace it) {
        EList<CntExState> _states = it.getStates();
        Iterable<CntExState> _plus = Iterables.<CntExState>concat(statesBeforeLoop, statesInLoop);
        Iterables.<CntExState>addAll(_states, _plus);
        CntExState _head = IterableExtensions.<CntExState>head(statesInLoop);
        it.setLoopStart(_head);
      }
    };
    return ObjectExtensions.<Trace>operator_doubleArrow(_createTrace, _function_10);
  }
  
  private final static Pattern ASSIGN_PATTERN = Pattern.compile(CntexLang2Cntex.ASSIGNMENT_REGEXP);
  
  private CntExState parseState(final Iterable<String> lines) {
    CntExState _createCntExState = this.cntexFactory.createCntExState();
    final Procedure1<CntExState> _function = new Procedure1<CntExState>() {
      public void apply(final CntExState it) {
        EList<CntExAssignment> _assignments = it.getAssignments();
        final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
          public Boolean apply(final String it) {
            return Boolean.valueOf(it.matches(CntexLang2Cntex.STATE_REGEXP));
          }
        };
        Iterable<String> _checkConsumed = org.foam.transform.utils.modeling.IterableExtensions.<String>checkConsumed(lines, _function);
        final Function1<String, CntExAssignment> _function_1 = new Function1<String, CntExAssignment>() {
          public CntExAssignment apply(final String it) {
            CntExAssignment _xblockexpression = null;
            {
              final Matcher m = CntexLang2Cntex.ASSIGN_PATTERN.matcher(it);
              boolean _matches = m.matches();
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Expected state assignment \'varname = value\' but \'");
              _builder.append(it, "");
              _builder.append("\' encountered.");
              Preconditions.checkState(_matches, _builder);
              CntExAssignment _createCntExAssignment = CntexLang2Cntex.this.cntexFactory.createCntExAssignment();
              final Procedure1<CntExAssignment> _function = new Procedure1<CntExAssignment>() {
                public void apply(final CntExAssignment it) {
                  String _group = m.group(1);
                  it.setVariableName(_group);
                  String _group_1 = m.group(2);
                  it.setValue(_group_1);
                }
              };
              _xblockexpression = ObjectExtensions.<CntExAssignment>operator_doubleArrow(_createCntExAssignment, _function);
            }
            return _xblockexpression;
          }
        };
        Iterable<CntExAssignment> _map = IterableExtensions.<String, CntExAssignment>map(_checkConsumed, _function_1);
        Iterables.<CntExAssignment>addAll(_assignments, _map);
      }
    };
    return ObjectExtensions.<CntExState>operator_doubleArrow(_createCntExState, _function);
  }
}
