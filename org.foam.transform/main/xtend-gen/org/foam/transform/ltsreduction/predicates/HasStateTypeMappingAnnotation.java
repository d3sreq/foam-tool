package org.foam.transform.ltsreduction.predicates;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.lts.State;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;

/**
 * Evaluates to True if given State has {@link StateTypeMappingAnnotation} attached
 * with same {@link StateType} as given in constructor.
 */
@SuppressWarnings("all")
public class HasStateTypeMappingAnnotation implements Predicate<State> {
  private final Collection<StateType> stateTypesToRetain;
  
  public HasStateTypeMappingAnnotation(final Collection<StateType> stateTypesToRetain) {
    this.stateTypesToRetain = stateTypesToRetain;
  }
  
  public HasStateTypeMappingAnnotation(final StateType stateTypeToRetain) {
    this(Collections.<StateType>singleton(stateTypeToRetain));
  }
  
  public HasStateTypeMappingAnnotation() {
    this(IterableExtensions.<StateType>toList(((Iterable<StateType>)Conversions.doWrapArray(StateType.values()))));
  }
  
  public boolean apply(final State state) {
    boolean _xblockexpression = false;
    {
      EList<Annotation> _annotations = state.getAnnotations();
      final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
        public Boolean apply(final Annotation it) {
          return Boolean.valueOf((it instanceof StateTypeMappingAnnotation));
        }
      };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
      final StateTypeMappingAnnotation annotation = ((StateTypeMappingAnnotation) _findFirst);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(annotation, null));
      if (!_notEquals) {
        _and = false;
      } else {
        StateType _stateType = annotation.getStateType();
        boolean _contains = this.stateTypesToRetain.contains(_stateType);
        _and = _contains;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
}
