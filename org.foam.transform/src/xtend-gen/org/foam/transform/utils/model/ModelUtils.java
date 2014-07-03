package org.foam.transform.utils.model;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.ucm.Step;

@SuppressWarnings("all")
public class ModelUtils {
  public static Step getStepFromStepMappingAnnotation(final State state) {
    Step _xblockexpression = null;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
        public Boolean apply(final Annotation it) {
          return Boolean.valueOf((it instanceof StepMappingAnnotation));
        }
      };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
      final StepMappingAnnotation annotation = ((StepMappingAnnotation) _findFirst);
      boolean _equals = Objects.equal(annotation, null);
      if (_equals) {
        return null;
      }
      _xblockexpression = annotation.getStep();
    }
    return _xblockexpression;
  }
  
  public static StateType getStateTypeFromStateTypeMappingAnnotation(final State state) {
    StateType _xblockexpression = null;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
        public Boolean apply(final Annotation it) {
          return Boolean.valueOf((it instanceof StateTypeMappingAnnotation));
        }
      };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
      final StateTypeMappingAnnotation annotation = ((StateTypeMappingAnnotation) _findFirst);
      boolean _equals = Objects.equal(annotation, null);
      if (_equals) {
        return null;
      }
      _xblockexpression = annotation.getStateType();
    }
    return _xblockexpression;
  }
}
