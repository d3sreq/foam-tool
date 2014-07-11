package org.foam.transform.cntexlang2cntex;

import com.google.common.base.Objects;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.cntex.CntExAssignment;
import org.foam.cntex.CntExState;
import org.foam.cntex.CounterExample;
import org.foam.cntex.Specification;
import org.foam.cntex.Trace;
import org.foam.lts.Automaton;
import org.foam.lts.State;
import org.foam.traceability.StateMappingAnnotation;
import org.foam.traceability.TraceabilityFactory;

@SuppressWarnings("all")
public class CntexStateResolver {
  /**
   * Name of the variable in NuSMV counter-example in which ID of the state is stored.
   */
  private final static String STATE_ID = "s";
  
  private final TraceabilityFactory fac = TraceabilityFactory.eINSTANCE;
  
  /**
   * Adds {@link StateMappingAnnotation}s to given counterExample pointing to
   * states from given Automaton.
   */
  public void transform(final CounterExample counterExample, final Automaton automaton) {
    final HashMap<String, State> id2State = new HashMap<String, State>();
    EList<State> _states = automaton.getStates();
    final Procedure1<State> _function = new Procedure1<State>() {
      public void apply(final State it) {
        String _id = it.getId();
        id2State.put(_id, it);
      }
    };
    IterableExtensions.<State>forEach(_states, _function);
    EList<Specification> _specifications = counterExample.getSpecifications();
    for (final Specification specification : _specifications) {
      Trace _trace = specification.getTrace();
      boolean _notEquals = (!Objects.equal(_trace, null));
      if (_notEquals) {
        Trace _trace_1 = specification.getTrace();
        EList<CntExState> _states_1 = _trace_1.getStates();
        for (final CntExState cntExState : _states_1) {
          {
            EList<CntExAssignment> _assignments = cntExState.getAssignments();
            final Function1<CntExAssignment, Boolean> _function_1 = new Function1<CntExAssignment, Boolean>() {
              public Boolean apply(final CntExAssignment it) {
                String _variableName = it.getVariableName();
                return Boolean.valueOf(Objects.equal(_variableName, CntexStateResolver.STATE_ID));
              }
            };
            final CntExAssignment idVar = IterableExtensions.<CntExAssignment>findFirst(_assignments, _function_1);
            boolean _notEquals_1 = (!Objects.equal(idVar, null));
            if (_notEquals_1) {
              String _value = idVar.getValue();
              boolean _containsKey = id2State.containsKey(_value);
              if (_containsKey) {
                EList<Annotation> _annotations = cntExState.getAnnotations();
                StateMappingAnnotation _createStateMappingAnnotation = this.fac.createStateMappingAnnotation();
                final Procedure1<StateMappingAnnotation> _function_2 = new Procedure1<StateMappingAnnotation>() {
                  public void apply(final StateMappingAnnotation it) {
                    String _value = idVar.getValue();
                    State _get = id2State.get(_value);
                    it.setState(_get);
                  }
                };
                StateMappingAnnotation _doubleArrow = ObjectExtensions.<StateMappingAnnotation>operator_doubleArrow(_createStateMappingAnnotation, _function_2);
                _annotations.add(_doubleArrow);
              }
            }
          }
        }
      }
    }
  }
}
