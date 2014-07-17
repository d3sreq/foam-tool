package org.foam.transform.ucm2lts;

import java.util.HashMap;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.lts.Automaton;
import org.foam.lts.LtsFactory;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.traceability.OverviewTransitionType;
import org.foam.traceability.OverviewTransitionTypeAnnotation;
import org.foam.traceability.TraceabilityFactory;
import org.foam.traceability.UseCaseMappingAnnotation;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;

@SuppressWarnings("all")
public class Ucm2LtsOverviewGraph {
  private final LtsFactory ltsFac = LtsFactory.eINSTANCE;
  
  private final TraceabilityFactory tracFac = TraceabilityFactory.eINSTANCE;
  
  public Automaton transform(final UseCaseModel ucm) {
    Automaton _xblockexpression = null;
    {
      final Automaton result = this.ltsFac.createAutomaton();
      final HashMap<UseCase, State> useCase2State = new HashMap<UseCase, State>();
      final EList<UseCase> allUseCases = ucm.getUseCases();
      for (final UseCase useCase : allUseCases) {
        {
          State _createState = this.ltsFac.createState();
          final Procedure1<State> _function = new Procedure1<State>() {
            public void apply(final State it) {
              String _id = useCase.getId();
              it.setId(_id);
              EList<Annotation> _annotations = it.getAnnotations();
              UseCaseMappingAnnotation _createUseCaseMappingAnnotation = Ucm2LtsOverviewGraph.this.tracFac.createUseCaseMappingAnnotation();
              final Procedure1<UseCaseMappingAnnotation> _function = new Procedure1<UseCaseMappingAnnotation>() {
                public void apply(final UseCaseMappingAnnotation it) {
                  it.setUseCase(useCase);
                }
              };
              UseCaseMappingAnnotation _doubleArrow = ObjectExtensions.<UseCaseMappingAnnotation>operator_doubleArrow(_createUseCaseMappingAnnotation, _function);
              _annotations.add(_doubleArrow);
            }
          };
          final State state = ObjectExtensions.<State>operator_doubleArrow(_createState, _function);
          EList<State> _states = result.getStates();
          _states.add(state);
          useCase2State.put(useCase, state);
        }
      }
      EList<State> _states = result.getStates();
      State _head = IterableExtensions.<State>head(_states);
      result.setInitState(_head);
      for (final UseCase useCase_1 : allUseCases) {
        {
          EList<UseCase> _preceeded = useCase_1.getPreceeded();
          for (final UseCase preceeded : _preceeded) {
            EList<Transition> _transitions = result.getTransitions();
            Transition _createTransition = this.ltsFac.createTransition();
            final Procedure1<Transition> _function = new Procedure1<Transition>() {
              public void apply(final Transition it) {
                State _get = useCase2State.get(useCase_1);
                it.setStart(_get);
                State _get_1 = useCase2State.get(preceeded);
                it.setEnd(_get_1);
                EList<Annotation> _annotations = it.getAnnotations();
                OverviewTransitionTypeAnnotation _createOverviewTransitionTypeAnnotation = Ucm2LtsOverviewGraph.this.tracFac.createOverviewTransitionTypeAnnotation();
                final Procedure1<OverviewTransitionTypeAnnotation> _function = new Procedure1<OverviewTransitionTypeAnnotation>() {
                  public void apply(final OverviewTransitionTypeAnnotation it) {
                    it.setOverviewTransitionType(OverviewTransitionType.PRECEDENCE);
                  }
                };
                OverviewTransitionTypeAnnotation _doubleArrow = ObjectExtensions.<OverviewTransitionTypeAnnotation>operator_doubleArrow(_createOverviewTransitionTypeAnnotation, _function);
                _annotations.add(_doubleArrow);
              }
            };
            Transition _doubleArrow = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function);
            _transitions.add(_doubleArrow);
          }
          Set<UseCase> _included = UcmUtils.getIncluded(useCase_1);
          for (final UseCase included : _included) {
            EList<Transition> _transitions_1 = result.getTransitions();
            Transition _createTransition_1 = this.ltsFac.createTransition();
            final Procedure1<Transition> _function_1 = new Procedure1<Transition>() {
              public void apply(final Transition it) {
                State _get = useCase2State.get(useCase_1);
                it.setStart(_get);
                State _get_1 = useCase2State.get(included);
                it.setEnd(_get_1);
                EList<Annotation> _annotations = it.getAnnotations();
                OverviewTransitionTypeAnnotation _createOverviewTransitionTypeAnnotation = Ucm2LtsOverviewGraph.this.tracFac.createOverviewTransitionTypeAnnotation();
                final Procedure1<OverviewTransitionTypeAnnotation> _function = new Procedure1<OverviewTransitionTypeAnnotation>() {
                  public void apply(final OverviewTransitionTypeAnnotation it) {
                    it.setOverviewTransitionType(OverviewTransitionType.INCLUDE);
                  }
                };
                OverviewTransitionTypeAnnotation _doubleArrow = ObjectExtensions.<OverviewTransitionTypeAnnotation>operator_doubleArrow(_createOverviewTransitionTypeAnnotation, _function);
                _annotations.add(_doubleArrow);
              }
            };
            Transition _doubleArrow_1 = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition_1, _function_1);
            _transitions_1.add(_doubleArrow_1);
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
