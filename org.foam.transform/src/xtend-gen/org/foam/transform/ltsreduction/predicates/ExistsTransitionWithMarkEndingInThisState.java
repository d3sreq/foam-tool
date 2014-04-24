package org.foam.transform.ltsreduction.predicates;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.flowannotation.Mark;
import org.foam.lts.State;
import org.foam.lts.Transition;

/**
 * Evaluates to True if given State is present as end State in any Transition
 * that has Mark annotation attached.
 */
@SuppressWarnings("all")
public class ExistsTransitionWithMarkEndingInThisState implements Predicate<State> {
  private final Set<State> statesWithMarkTransitionEnd;
  
  public ExistsTransitionWithMarkEndingInThisState(final Collection<Transition> transitions) {
    HashSet<State> _hashSet = new HashSet<State>();
    this.statesWithMarkTransitionEnd = _hashSet;
    for (final Transition transition : transitions) {
      EList<Annotation> _annotations = transition.getAnnotations();
      final Function1<Annotation,Boolean> _function = new Function1<Annotation,Boolean>() {
        public Boolean apply(final Annotation it) {
          return Boolean.valueOf((it instanceof Mark));
        }
      };
      Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
      boolean _notEquals = (!Objects.equal(_findFirst, null));
      if (_notEquals) {
        State _end = transition.getEnd();
        this.statesWithMarkTransitionEnd.add(_end);
      }
    }
  }
  
  public boolean apply(final State state) {
    return this.statesWithMarkTransitionEnd.contains(state);
  }
}
