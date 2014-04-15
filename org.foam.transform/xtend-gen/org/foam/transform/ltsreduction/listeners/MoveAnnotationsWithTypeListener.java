package org.foam.transform.ltsreduction.listeners;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.lts.Transition;
import org.foam.transform.ltsreduction.StateReducedEvent;
import org.foam.transform.ltsreduction.StateReducedEventListener;

/**
 * Moves {@link Annotation} having given type (or with subclass of given type) from
 * removed {@link Transition}s to added Transition.
 */
@SuppressWarnings("all")
public class MoveAnnotationsWithTypeListener implements StateReducedEventListener {
  private Class<? extends Annotation> annotationType;
  
  public MoveAnnotationsWithTypeListener(final Class<? extends Annotation> annotationType) {
    this.annotationType = annotationType;
  }
  
  public void stateReduced(final StateReducedEvent stateReducedEvent) {
    Transition _removedFromStateTransition = stateReducedEvent.getRemovedFromStateTransition();
    EList<Annotation> _annotations = _removedFromStateTransition.getAnnotations();
    Transition _removedToStateTransition = stateReducedEvent.getRemovedToStateTransition();
    EList<Annotation> _annotations_1 = _removedToStateTransition.getAnnotations();
    final Iterable<Annotation> annotations = Iterables.<Annotation>concat(_annotations, _annotations_1);
    final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
      public Boolean apply(final Annotation it) {
        Class<? extends Annotation> _class = it.getClass();
        return Boolean.valueOf(MoveAnnotationsWithTypeListener.this.annotationType.isAssignableFrom(_class));
      }
    };
    final Iterable<Annotation> annotationsWithType = IterableExtensions.<Annotation>filter(annotations, _function);
    final ArrayList<Annotation> list = new ArrayList<Annotation>();
    Iterables.<Annotation>addAll(list, annotationsWithType);
    Transition _addedTransition = stateReducedEvent.getAddedTransition();
    EList<Annotation> _annotations_2 = _addedTransition.getAnnotations();
    _annotations_2.addAll(list);
  }
}
