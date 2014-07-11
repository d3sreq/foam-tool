package org.foam.transform.lts2nusmvlang;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.flowannotation.Guard;
import org.foam.flowannotation.Mark;
import org.foam.lts.Automaton;
import org.foam.lts.LtsFactory;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.propositionallogic.False;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.Group;
import org.foam.tadl.Template;
import org.foam.tadl.TemporalAnnotation;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.transform.lts2nusmvlang.NuSMVFormulaRenderer;
import org.foam.transform.lts2nusmvlang.TADLFormulaRenderer;
import org.foam.transform.utils.modeling.NameService;
import org.foam.ucm.Step;
import org.foam.verification.Action;

@SuppressWarnings("all")
public class Lts2NuSMVLang {
  private final static int NUSMV_CODE_WRAP_LENGTH = 120;
  
  private final static int NUSMV_CODE_ABBREVIATE_LENGTH = 60;
  
  private final NameService nameService = new NameService();
  
  private String stateId(final State s) {
    return s.getId();
  }
  
  private final HashMap<State, List<Transition>> mapStateToTransitions = new HashMap<State, List<Transition>>();
  
  private List<Transition> stateTransitions(final State s) {
    return this.mapStateToTransitions.get(s);
  }
  
  private final HashMap<Transition, Guard> trans2guards = new HashMap<Transition, Guard>();
  
  private void _prepareTransitionAnnotationMapping(final Automaton automaton, final Transition transition, final Guard guardAnnot) {
    Formula _formula = guardAnnot.getFormula();
    if ((_formula instanceof False)) {
      EList<Transition> _transitions = automaton.getTransitions();
      _transitions.remove(transition);
      return;
    }
    final State stateX = transition.getStart();
    final State stateY = transition.getEnd();
    State _createState = LtsFactory.eINSTANCE.createState();
    final Procedure1<State> _function = new Procedure1<State>() {
      public void apply(final State it) {
        StringConcatenation _builder = new StringConcatenation();
        String _id = stateX.getId();
        _builder.append(_id, "");
        _builder.append("$-guard-$");
        String _id_1 = stateY.getId();
        _builder.append(_id_1, "");
        it.setId(_builder.toString());
      }
    };
    final State stateG = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
    Transition _createTransition = LtsFactory.eINSTANCE.createTransition();
    final Procedure1<Transition> _function_1 = new Procedure1<Transition>() {
      public void apply(final Transition it) {
        it.setStart(stateX);
        it.setEnd(stateG);
      }
    };
    final Transition newTransition = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function_1);
    transition.setStart(stateG);
    EList<State> _states = automaton.getStates();
    _states.add(stateG);
    EList<Transition> _transitions_1 = automaton.getTransitions();
    _transitions_1.add(newTransition);
    EList<Annotation> _annotations = transition.getAnnotations();
    _annotations.remove(guardAnnot);
    EList<Annotation> _annotations_1 = newTransition.getAnnotations();
    _annotations_1.add(guardAnnot);
    this.trans2guards.put(newTransition, guardAnnot);
  }
  
  private final HashMap<VariableDefinition, List<Transition>> markvar2trans = new HashMap<VariableDefinition, List<Transition>>();
  
  private void _prepareTransitionAnnotationMapping(final Automaton automaton, final Transition transition, final Mark markAnnot) {
    VariableDefinition _variableDefinition = markAnnot.getVariableDefinition();
    boolean _containsKey = this.markvar2trans.containsKey(_variableDefinition);
    boolean _not = (!_containsKey);
    if (_not) {
      VariableDefinition _variableDefinition_1 = markAnnot.getVariableDefinition();
      ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList();
      this.markvar2trans.put(_variableDefinition_1, _newArrayList);
    }
    VariableDefinition _variableDefinition_2 = markAnnot.getVariableDefinition();
    List<Transition> _get = this.markvar2trans.get(_variableDefinition_2);
    _get.add(transition);
  }
  
  private final HashMap<VariableDefinition, List<Pair<Action, Transition>>> actvar2acttrans = new HashMap<VariableDefinition, List<Pair<Action, Transition>>>();
  
  private void _prepareTransitionAnnotationMapping(final Automaton automaton, final Transition transition, final Action actionAnnot) {
    final State stateX = transition.getStart();
    final State stateY = transition.getEnd();
    State _createState = LtsFactory.eINSTANCE.createState();
    final Procedure1<State> _function = new Procedure1<State>() {
      public void apply(final State it) {
        StringConcatenation _builder = new StringConcatenation();
        String _id = stateX.getId();
        _builder.append(_id, "");
        _builder.append("$-act-$");
        String _id_1 = stateY.getId();
        _builder.append(_id_1, "");
        it.setId(_builder.toString());
      }
    };
    final State stateA = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
    Transition _createTransition = LtsFactory.eINSTANCE.createTransition();
    final Procedure1<Transition> _function_1 = new Procedure1<Transition>() {
      public void apply(final Transition it) {
        it.setStart(stateA);
        it.setEnd(stateY);
      }
    };
    final Transition newTransition = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function_1);
    transition.setEnd(stateA);
    EList<State> _states = automaton.getStates();
    _states.add(stateA);
    EList<Transition> _transitions = automaton.getTransitions();
    _transitions.add(newTransition);
    VariableDefinition _variableDefinition = actionAnnot.getVariableDefinition();
    boolean _containsKey = this.actvar2acttrans.containsKey(_variableDefinition);
    boolean _not = (!_containsKey);
    if (_not) {
      VariableDefinition _variableDefinition_1 = actionAnnot.getVariableDefinition();
      ArrayList<Pair<Action, Transition>> _newArrayList = CollectionLiterals.<Pair<Action, Transition>>newArrayList();
      this.actvar2acttrans.put(_variableDefinition_1, _newArrayList);
    }
    VariableDefinition _variableDefinition_2 = actionAnnot.getVariableDefinition();
    List<Pair<Action, Transition>> _get = this.actvar2acttrans.get(_variableDefinition_2);
    Pair<Action, Transition> _mappedTo = Pair.<Action, Transition>of(actionAnnot, transition);
    _get.add(_mappedTo);
  }
  
  private boolean isGuarded(final Transition transition) {
    return this.trans2guards.containsKey(transition);
  }
  
  private String getGuardingFormula(final Transition transition) {
    String _xblockexpression = null;
    {
      final NuSMVFormulaRenderer nuSMVFormulaRenderer = new NuSMVFormulaRenderer();
      Guard _get = this.trans2guards.get(transition);
      Formula _formula = _get.getFormula();
      Object _evalFormula = nuSMVFormulaRenderer.evalFormula(_formula);
      _xblockexpression = _evalFormula.toString();
    }
    return _xblockexpression;
  }
  
  private final HashSet<State> guardLoopFairnessStates = new HashSet<State>();
  
  private void addToFairness(final State s) {
    this.guardLoopFairnessStates.add(s);
  }
  
  private final HashMap<State, Step> state2ucstep = new HashMap<State, Step>();
  
  private Object _prepareStateToAnnotationMapping(final State state, final StepMappingAnnotation annot) {
    Step _step = annot.getStep();
    return this.state2ucstep.put(state, _step);
  }
  
  private final HashMap<State, String> state2type = new HashMap<State, String>();
  
  private Object _prepareStateToAnnotationMapping(final State state, final StateTypeMappingAnnotation annot) {
    StateType _stateType = annot.getStateType();
    String _literal = _stateType.getLiteral();
    return this.state2type.put(state, _literal);
  }
  
  private Object _prepareStateToAnnotationMapping(final State state, final Annotation annot) {
    return null;
  }
  
  private String getUseCaseStepText(final State state) {
    final Step step = this.state2ucstep.get(state);
    boolean _equals = Objects.equal(step, null);
    if (_equals) {
      return null;
    }
    StringConcatenation _builder = new StringConcatenation();
    String _label = step.getLabel();
    _builder.append(_label, "");
    _builder.append(". ");
    String _text = step.getText();
    _builder.append(_text, "");
    return _builder.toString();
  }
  
  private String getType(final State state) {
    return this.state2type.get(state);
  }
  
  public String transform(final Automaton automaton) {
    ArrayList<Pair<FormulaHolder, Group>> _newArrayList = CollectionLiterals.<Pair<FormulaHolder, Group>>newArrayList();
    return this.transform(automaton, _newArrayList);
  }
  
  public String transform(final Automaton automaton, final List<Pair<FormulaHolder, Group>> holderGroupList) {
    State _initState = automaton.getInitState();
    this.stateId(_initState);
    EList<Transition> _transitions = automaton.getTransitions();
    List<Transition> _immutableCopy = ImmutableList.<Transition>copyOf(_transitions);
    for (final Transition trans : _immutableCopy) {
      EList<Annotation> _annotations = trans.getAnnotations();
      List<Annotation> _immutableCopy_1 = ImmutableList.<Annotation>copyOf(_annotations);
      for (final Annotation annot : _immutableCopy_1) {
        this.prepareTransitionAnnotationMapping(automaton, trans, annot);
      }
    }
    EList<State> _states = automaton.getStates();
    for (final State s : _states) {
      {
        ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList();
        this.mapStateToTransitions.put(s, _newArrayList);
        EList<Annotation> _annotations_1 = s.getAnnotations();
        for (final Annotation annot_1 : _annotations_1) {
          this.prepareStateToAnnotationMapping(s, annot_1);
        }
      }
    }
    EList<Transition> _transitions_1 = automaton.getTransitions();
    for (final Transition trans_1 : _transitions_1) {
      State _start = trans_1.getStart();
      List<Transition> _get = this.mapStateToTransitions.get(_start);
      _get.add(trans_1);
    }
    EList<Transition> _transitions_2 = automaton.getTransitions();
    final HashMap<Group, Map<String, List<Transition>>> partTrans = this.partitionTransitions(_transitions_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MODULE main");
    _builder.newLine();
    _builder.newLine();
    _builder.append("-- Variable \"s\" represents all the possible states of the automaton");
    _builder.newLine();
    _builder.append("VAR s : {");
    _builder.newLine();
    _builder.append("\t");
    EList<State> _states_1 = automaton.getStates();
    final Function1<State, String> _function = new Function1<State, String>() {
      public String apply(final State it) {
        return Lts2NuSMVLang.this.stateId(it);
      }
    };
    List<String> _map = ListExtensions.<State, String>map(_states_1, _function);
    String _join = IterableExtensions.join(_map, ", ");
    String _wrap = WordUtils.wrap(_join, Lts2NuSMVLang.NUSMV_CODE_WRAP_LENGTH);
    _builder.append(_wrap, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("-- We need to highlight states relevant for checking temporal formulae.");
    _builder.newLine();
    _builder.append("-- This is necessary due to the translation of TADL -> NuSMV formulae because");
    _builder.newLine();
    _builder.append("-- the granularity of states changed during UCM->LTS transformation.");
    _builder.newLine();
    _builder.append("DEFINE jmp := s in {");
    _builder.newLine();
    _builder.append("\t");
    EList<State> _states_2 = automaton.getStates();
    final Function1<State, Boolean> _function_1 = new Function1<State, Boolean>() {
      public Boolean apply(final State s) {
        boolean _or = false;
        String _literal = StateType.JMP.getLiteral();
        String _type = Lts2NuSMVLang.this.getType(s);
        boolean _equals = _literal.equals(_type);
        if (_equals) {
          _or = true;
        } else {
          List<Transition> _stateTransitions = Lts2NuSMVLang.this.stateTransitions(s);
          final Function1<Transition, Boolean> _function = new Function1<Transition, Boolean>() {
            public Boolean apply(final Transition it) {
              State _end = it.getEnd();
              return Boolean.valueOf(Objects.equal(_end, s));
            }
          };
          boolean _exists = IterableExtensions.<Transition>exists(_stateTransitions, _function);
          _or = _exists;
        }
        return Boolean.valueOf(_or);
      }
    };
    Iterable<State> _filter = IterableExtensions.<State>filter(_states_2, _function_1);
    final Function1<State, String> _function_2 = new Function1<State, String>() {
      public String apply(final State it) {
        return Lts2NuSMVLang.this.stateId(it);
      }
    };
    Iterable<String> _map_1 = IterableExtensions.<State, String>map(_filter, _function_2);
    String _join_1 = IterableExtensions.join(_map_1, ", ");
    String _wrap_1 = WordUtils.wrap(_join_1, Lts2NuSMVLang.NUSMV_CODE_WRAP_LENGTH);
    _builder.append(_wrap_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("ASSIGN -- here come the states and transitions");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("init(s) := ");
    State _initState_1 = automaton.getInitState();
    String _stateId = this.stateId(_initState_1);
    _builder.append(_stateId, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("next(s) := case");
    _builder.newLine();
    {
      EList<State> _states_3 = automaton.getStates();
      for(final State state : _states_3) {
        _builder.append("\t\t");
        _builder.append("s = ");
        String _stateId_1 = this.stateId(state);
        _builder.append(_stateId_1, "\t\t");
        _builder.append(" : {");
        List<Transition> _stateTransitions = this.stateTransitions(state);
        final Function1<Transition, String> _function_3 = new Function1<Transition, String>() {
          public String apply(final Transition it) {
            State _end = it.getEnd();
            return Lts2NuSMVLang.this.stateId(_end);
          }
        };
        List<String> _map_2 = ListExtensions.<Transition, String>map(_stateTransitions, _function_3);
        String _join_2 = IterableExtensions.join(_map_2, ", ");
        _builder.append(_join_2, "\t\t");
        _builder.append("}; -- ");
        String _type = this.getType(state);
        _builder.append(_type, "\t\t");
        _builder.append(" : ");
        String _useCaseStepText = this.getUseCaseStepText(state);
        String _abbreviate = WordUtils.abbreviate(_useCaseStepText, Lts2NuSMVLang.NUSMV_CODE_ABBREVIATE_LENGTH, Lts2NuSMVLang.NUSMV_CODE_ABBREVIATE_LENGTH, "...");
        _builder.append(_abbreviate, "\t\t");
        _builder.newLineIfNotEmpty();
        {
          List<Transition> _stateTransitions_1 = this.stateTransitions(state);
          final Comparator<Transition> _function_4 = new Comparator<Transition>() {
            public int compare(final Transition a, final Transition b) {
              int _xifexpression = (int) 0;
              boolean _isGuarded = Lts2NuSMVLang.this.isGuarded(a);
              if (_isGuarded) {
                _xifexpression = (-1);
              } else {
                _xifexpression = 1;
              }
              return _xifexpression;
            }
          };
          List<Transition> _sortInplace = ListExtensions.<Transition>sortInplace(_stateTransitions_1, _function_4);
          for(final Transition trans_2 : _sortInplace) {
            {
              boolean _isGuarded = this.isGuarded(trans_2);
              if (_isGuarded) {
                {
                  String _guardingFormula = this.getGuardingFormula(trans_2);
                  boolean _equalsIgnoreCase = "FALSE".equalsIgnoreCase(_guardingFormula);
                  if (_equalsIgnoreCase) {
                    _builder.append("\t\t");
                    _builder.append("\t");
                    _builder.append("-- TODO: the following line can be optimized by changing the non-deterministic choice in ");
                    String _stateId_2 = this.stateId(state);
                    _builder.append(_stateId_2, "\t\t\t");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("\t\t");
                _builder.append("\t");
                _builder.append("s = ");
                State _end = trans_2.getEnd();
                String _stateId_3 = this.stateId(_end);
                _builder.append(_stateId_3, "\t\t\t");
                _builder.append(" & !(");
                String _guardingFormula_1 = this.getGuardingFormula(trans_2);
                _builder.append(_guardingFormula_1, "\t\t\t");
                _builder.append(") : ");
                String _stateId_4 = this.stateId(state);
                _builder.append(_stateId_4, "\t\t\t");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                State _start_1 = trans_2.getStart();
                this.addToFairness(_start_1);
                _builder.newLineIfNotEmpty();
                _builder.append("\t\t");
                _builder.append("\t");
                State _end_1 = trans_2.getEnd();
                this.addToFairness(_end_1);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("esac;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("-- ====================== VARIABLES REPRESENTING MARK ANNOTATIONS ON TRANSITIONS ==========");
    _builder.newLine();
    _builder.newLine();
    {
      Set<VariableDefinition> _keySet = this.markvar2trans.keySet();
      for(final VariableDefinition vardef : _keySet) {
        _builder.append("VAR ");
        String _name = vardef.getName();
        _builder.append(_name, "");
        _builder.append(" : boolean;");
        _builder.newLineIfNotEmpty();
        _builder.append("ASSIGN");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("init(");
        String _name_1 = vardef.getName();
        _builder.append(_name_1, "\t");
        _builder.append(") := FALSE;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("next(");
        String _name_2 = vardef.getName();
        _builder.append(_name_2, "\t");
        _builder.append(") := case");
        _builder.newLineIfNotEmpty();
        {
          List<Transition> _get_1 = this.markvar2trans.get(vardef);
          for(final Transition trans_3 : _get_1) {
            _builder.append("\t\t");
            _builder.append("s=");
            State _start_2 = trans_3.getStart();
            String _stateId_5 = this.stateId(_start_2);
            _builder.append(_stateId_5, "\t\t");
            _builder.append(" : TRUE; -- transition (");
            State _start_3 = trans_3.getStart();
            String _stateId_6 = this.stateId(_start_3);
            _builder.append(_stateId_6, "\t\t");
            _builder.append(" -> ");
            State _end_2 = trans_3.getEnd();
            String _stateId_7 = this.stateId(_end_2);
            _builder.append(_stateId_7, "\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("TRUE : ");
        String _name_3 = vardef.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("esac;");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("-- ====================== VARIABLES REPRESENTING ACTIONS ON TRANSITIONS ===================");
    _builder.newLine();
    _builder.newLine();
    {
      Set<VariableDefinition> _keySet_1 = this.actvar2acttrans.keySet();
      for(final VariableDefinition vardef_1 : _keySet_1) {
        _builder.append("VAR ");
        String _name_4 = vardef_1.getName();
        _builder.append(_name_4, "");
        _builder.append(" : boolean;");
        _builder.newLineIfNotEmpty();
        _builder.append("ASSIGN");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("init(");
        String _name_5 = vardef_1.getName();
        _builder.append(_name_5, "\t");
        _builder.append(") := FALSE;");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("next(");
        String _name_6 = vardef_1.getName();
        _builder.append(_name_6, "\t");
        _builder.append(") := case");
        _builder.newLineIfNotEmpty();
        {
          List<Pair<Action, Transition>> _get_2 = this.actvar2acttrans.get(vardef_1);
          for(final Pair<Action, Transition> pair : _get_2) {
            _builder.append("\t\t");
            final Action act = pair.getKey();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            final Transition trans_4 = pair.getValue();
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t");
            _builder.append("s=");
            State _end_3 = trans_4.getEnd();
            String _stateId_8 = this.stateId(_end_3);
            _builder.append(_stateId_8, "\t\t");
            _builder.append(" : ");
            boolean _isValue = act.isValue();
            String _string = Boolean.valueOf(_isValue).toString();
            String _upperCase = _string.toUpperCase();
            _builder.append(_upperCase, "\t\t");
            _builder.append("; -- transition (");
            State _start_4 = trans_4.getStart();
            String _stateId_9 = this.stateId(_start_4);
            _builder.append(_stateId_9, "\t\t");
            _builder.append(" -> ");
            State _end_4 = trans_4.getEnd();
            String _stateId_10 = this.stateId(_end_4);
            _builder.append(_stateId_10, "\t\t");
            _builder.append(")");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t\t");
        _builder.append("TRUE : ");
        String _name_7 = vardef_1.getName();
        _builder.append(_name_7, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("esac;");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("-- =================================== FAIRNESS IN GUARDS ==================================");
    _builder.newLine();
    _builder.newLine();
    _builder.append("-- The execution cannot loop infinitely in any of the following states");
    _builder.newLine();
    _builder.append("FAIRNESS !guardloop;");
    _builder.newLine();
    _builder.append("DEFINE guardloop := s in {");
    _builder.newLine();
    _builder.append("\t");
    final Function1<State, String> _function_5 = new Function1<State, String>() {
      public String apply(final State it) {
        return Lts2NuSMVLang.this.stateId(it);
      }
    };
    Iterable<String> _map_3 = IterableExtensions.<State, String>map(this.guardLoopFairnessStates, _function_5);
    String _join_3 = IterableExtensions.join(_map_3, ", ");
    String _wrap_2 = WordUtils.wrap(_join_3, Lts2NuSMVLang.NUSMV_CODE_WRAP_LENGTH);
    _builder.append(_wrap_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("};");
    _builder.newLine();
    {
      Set<Map.Entry<Group, Map<String, List<Transition>>>> _entrySet = partTrans.entrySet();
      for(final Map.Entry<Group, Map<String, List<Transition>>> groupEntry : _entrySet) {
        final Group group = groupEntry.getKey();
        _builder.newLineIfNotEmpty();
        Map<String, List<Transition>> _value = groupEntry.getValue();
        final Set<String> templateVarNames = _value.keySet();
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("-- ====================== TEMPORAL ANNOTATIONS ");
        String _join_4 = IterableExtensions.join(templateVarNames, ", ");
        _builder.append(_join_4, "");
        _builder.append(" ");
        String _qualifier = group.getQualifier();
        _builder.append(_qualifier, "");
        _builder.append(" ===================");
        _builder.newLineIfNotEmpty();
        {
          for(final String templateVarName : templateVarNames) {
            String _qualifier_1 = group.getQualifier();
            final String nusmvVarName = this.nameService.createTadlVarName(_qualifier_1, templateVarName);
            _builder.newLineIfNotEmpty();
            Map<String, List<Transition>> _value_1 = groupEntry.getValue();
            final List<Transition> transitions = _value_1.get(templateVarName);
            _builder.newLineIfNotEmpty();
            _builder.append("VAR ");
            _builder.append(nusmvVarName, "");
            _builder.append(": boolean;");
            _builder.newLineIfNotEmpty();
            _builder.append("ASSIGN");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("init(");
            _builder.append(nusmvVarName, "\t");
            _builder.append(") := FALSE;");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("next(");
            _builder.append(nusmvVarName, "\t");
            _builder.append(") := case");
            _builder.newLineIfNotEmpty();
            {
              boolean _isEmpty = transitions.isEmpty();
              boolean _not = (!_isEmpty);
              if (_not) {
                _builder.append("\t");
                _builder.append("s in { ");
                final Function1<Transition, String> _function_6 = new Function1<Transition, String>() {
                  public String apply(final Transition it) {
                    State _start = it.getStart();
                    return Lts2NuSMVLang.this.stateId(_start);
                  }
                };
                List<String> _map_4 = ListExtensions.<Transition, String>map(transitions, _function_6);
                String _join_5 = IterableExtensions.join(_map_4, ", ");
                _builder.append(_join_5, "\t");
                _builder.append(" } : TRUE;");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("s in { ");
                final Function1<Transition, String> _function_7 = new Function1<Transition, String>() {
                  public String apply(final Transition it) {
                    State _end = it.getEnd();
                    return Lts2NuSMVLang.this.stateId(_end);
                  }
                };
                List<String> _map_5 = ListExtensions.<Transition, String>map(transitions, _function_7);
                String _join_6 = IterableExtensions.join(_map_5, ", ");
                _builder.append(_join_6, "\t");
                _builder.append(" } : FALSE;");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t\t");
            _builder.append("TRUE: ");
            _builder.append(nusmvVarName, "\t\t");
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("esac;");
            _builder.newLine();
          }
        }
        _builder.newLine();
        String _qualifier_2 = group.getQualifier();
        final HashMap<String, String> map = this.createTemplateVar2NuSMVVarMap(_qualifier_2, templateVarNames);
        _builder.newLineIfNotEmpty();
        final TADLFormulaRenderer tadlRenderer = new TADLFormulaRenderer(map);
        _builder.newLineIfNotEmpty();
        {
          Template _template = group.getTemplate();
          EList<FormulaHolder> _formulaHolders = _template.getFormulaHolders();
          for(final FormulaHolder fh : _formulaHolders) {
            _builder.append("-- Formula: \"");
            String _comment = fh.getComment();
            _builder.append(_comment, "");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
            _builder.append("-- TADL ");
            Formula _formula = fh.getFormula();
            String _evalFormula = tadlRenderer.evalFormula(_formula);
            _builder.append(_evalFormula, "");
            _builder.newLineIfNotEmpty();
            FormulaType _formulaType = fh.getFormulaType();
            String _literal = _formulaType.getLiteral();
            _builder.append(_literal, "");
            _builder.append("SPEC ");
            Formula _formula_1 = fh.getFormula();
            String _evalFormula_1 = tadlRenderer.evalFormula(_formula_1);
            _builder.append(_evalFormula_1, "");
            _builder.newLineIfNotEmpty();
            this.addFormulaHolderAndGroup(fh, group, holderGroupList);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  private void addFormulaHolderAndGroup(final FormulaHolder fh, final Group group, final List<Pair<FormulaHolder, Group>> holderGroupList) {
    Pair<FormulaHolder, Group> _mappedTo = Pair.<FormulaHolder, Group>of(fh, group);
    holderGroupList.add(_mappedTo);
  }
  
  private HashMap<String, String> createTemplateVar2NuSMVVarMap(final String qualifier, final Set<String> varNames) {
    HashMap<String, String> _xblockexpression = null;
    {
      final HashMap<String, String> result = new HashMap<String, String>();
      final Consumer<String> _function = new Consumer<String>() {
        public void accept(final String it) {
          String _createTadlVarName = Lts2NuSMVLang.this.nameService.createTadlVarName(qualifier, it);
          result.put(it, _createTadlVarName);
        }
      };
      varNames.forEach(_function);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private HashMap<Group, Map<String, List<Transition>>> partitionTransitions(final Iterable<Transition> transitions) {
    HashMap<Group, Map<String, List<Transition>>> _xblockexpression = null;
    {
      final HashMap<Group, Map<String, List<Transition>>> result = new HashMap<Group, Map<String, List<Transition>>>();
      for (final Transition transition : transitions) {
        State _start = transition.getStart();
        EList<Annotation> _annotations = _start.getAnnotations();
        Iterable<TemporalAnnotation> _filter = Iterables.<TemporalAnnotation>filter(_annotations, TemporalAnnotation.class);
        for (final TemporalAnnotation tempAnnot : _filter) {
          {
            final Group group = tempAnnot.getGroup();
            boolean _containsKey = result.containsKey(group);
            boolean _not = (!_containsKey);
            if (_not) {
              final HashMap<String, List<Transition>> varNameMap = new HashMap<String, List<Transition>>();
              result.put(group, varNameMap);
              Template _template = group.getTemplate();
              EList<VariableDefinition> _variableDefinitions = _template.getVariableDefinitions();
              final Consumer<VariableDefinition> _function = new Consumer<VariableDefinition>() {
                public void accept(final VariableDefinition it) {
                  String _name = it.getName();
                  ArrayList<Transition> _newArrayList = CollectionLiterals.<Transition>newArrayList();
                  varNameMap.put(_name, _newArrayList);
                }
              };
              _variableDefinitions.forEach(_function);
            }
            final Map<String, List<Transition>> varNameMap_1 = result.get(group);
            VariableDefinition _variableDefinition = tempAnnot.getVariableDefinition();
            final String varName = _variableDefinition.getName();
            final List<Transition> transList = varNameMap_1.get(varName);
            transList.add(transition);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private void prepareTransitionAnnotationMapping(final Automaton automaton, final Transition transition, final Annotation guardAnnot) {
    if (guardAnnot instanceof Guard) {
      _prepareTransitionAnnotationMapping(automaton, transition, (Guard)guardAnnot);
      return;
    } else if (guardAnnot instanceof Mark) {
      _prepareTransitionAnnotationMapping(automaton, transition, (Mark)guardAnnot);
      return;
    } else if (guardAnnot instanceof Action) {
      _prepareTransitionAnnotationMapping(automaton, transition, (Action)guardAnnot);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(automaton, transition, guardAnnot).toString());
    }
  }
  
  private Object prepareStateToAnnotationMapping(final State state, final Annotation annot) {
    if (annot instanceof StateTypeMappingAnnotation) {
      return _prepareStateToAnnotationMapping(state, (StateTypeMappingAnnotation)annot);
    } else if (annot instanceof StepMappingAnnotation) {
      return _prepareStateToAnnotationMapping(state, (StepMappingAnnotation)annot);
    } else if (annot != null) {
      return _prepareStateToAnnotationMapping(state, annot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(state, annot).toString());
    }
  }
}
