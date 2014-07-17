package org.foam.transform.ltsreduction.predicates;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.lts.State;
import org.foam.tadl.TemporalAnnotation;

@SuppressWarnings("all")
public class HasTemporalAnnotation implements Predicate<State> {
  public boolean apply(final State state) {
    EList<Annotation> _annotations = state.getAnnotations();
    final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
      public Boolean apply(final Annotation it) {
        return Boolean.valueOf((it instanceof TemporalAnnotation));
      }
    };
    Annotation _findFirst = IterableExtensions.<Annotation>findFirst(_annotations, _function);
    return (!Objects.equal(_findFirst, null));
  }
}
