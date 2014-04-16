package org.foam.cli.tools.report.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.cntex.Specification;
import org.foam.tadl.Group;
import org.foam.traceability.FormulaIdentificationAnnotation;

@SuppressWarnings("all")
public class Utils {
  public static Group getGroup(final Specification specification) {
    Group _xblockexpression = null;
    {
      EList<Annotation> _annotations = specification.getAnnotations();
      final Iterable<FormulaIdentificationAnnotation> annot = Iterables.<FormulaIdentificationAnnotation>filter(_annotations, FormulaIdentificationAnnotation.class);
      int _size = IterableExtensions.size(annot);
      boolean _equals = (_size == 1);
      Preconditions.checkArgument(_equals);
      FormulaIdentificationAnnotation _head = IterableExtensions.<FormulaIdentificationAnnotation>head(annot);
      _xblockexpression = _head.getGroup();
    }
    return _xblockexpression;
  }
}
