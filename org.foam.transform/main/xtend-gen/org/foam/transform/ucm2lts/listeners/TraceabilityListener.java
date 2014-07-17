package org.foam.transform.ucm2lts.listeners;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.traceability.TraceabilityFactory;
import org.foam.transform.ucm2lts.StateAddedEvent;
import org.foam.transform.ucm2lts.StateAddedEventListener;
import org.foam.ucm.Step;

/**
 * Attaches {@link StateTypeMappingAnnotation} and {@link StepMappingAnnotation}
 * (if Step is given in event) into {@link State} passed in event.
 */
@SuppressWarnings("all")
public class TraceabilityListener implements StateAddedEventListener {
  private final TraceabilityFactory traceabilityFac = TraceabilityFactory.eINSTANCE;
  
  public void stateAdded(final StateAddedEvent event) {
    final State state = event.getTargetState();
    final Step step = event.getSourceStep();
    StateType _targetStateType = event.getTargetStateType();
    boolean _notEquals = (!Objects.equal(_targetStateType, null));
    if (_notEquals) {
      EList<Annotation> _annotations = state.getAnnotations();
      StateTypeMappingAnnotation _createStateTypeMappingAnnotation = this.traceabilityFac.createStateTypeMappingAnnotation();
      final Procedure1<StateTypeMappingAnnotation> _function = new Procedure1<StateTypeMappingAnnotation>() {
        public void apply(final StateTypeMappingAnnotation it) {
          StateType _targetStateType = event.getTargetStateType();
          it.setStateType(_targetStateType);
        }
      };
      StateTypeMappingAnnotation _doubleArrow = ObjectExtensions.<StateTypeMappingAnnotation>operator_doubleArrow(_createStateTypeMappingAnnotation, _function);
      _annotations.add(_doubleArrow);
    }
    boolean _notEquals_1 = (!Objects.equal(step, null));
    if (_notEquals_1) {
      EList<Annotation> _annotations_1 = state.getAnnotations();
      StepMappingAnnotation _createStepMappingAnnotation = this.traceabilityFac.createStepMappingAnnotation();
      final Procedure1<StepMappingAnnotation> _function_1 = new Procedure1<StepMappingAnnotation>() {
        public void apply(final StepMappingAnnotation it) {
          it.setStep(step);
        }
      };
      StepMappingAnnotation _doubleArrow_1 = ObjectExtensions.<StepMappingAnnotation>operator_doubleArrow(_createStepMappingAnnotation, _function_1);
      _annotations_1.add(_doubleArrow_1);
    }
  }
}
