package org.foam.transform.cntexlang2cntex;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.foam.annotation.Annotation;
import org.foam.cntex.CounterExample;
import org.foam.cntex.Specification;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.Group;
import org.foam.traceability.FormulaIdentificationAnnotation;
import org.foam.traceability.TraceabilityFactory;

/**
 * Adds {@link FormulaIdentificationAnnotation} to {@link Specification}s
 */
@SuppressWarnings("all")
public class SpecificationResolver {
  private final TraceabilityFactory fac = TraceabilityFactory.eINSTANCE;
  
  public void transform(final CounterExample counterExample, final List<Pair<FormulaHolder, Group>> holderGroupList) {
    final Function1<Pair<FormulaHolder, Group>, Boolean> _function = new Function1<Pair<FormulaHolder, Group>, Boolean>() {
      public Boolean apply(final Pair<FormulaHolder, Group> it) {
        FormulaHolder _key = it.getKey();
        FormulaType _formulaType = _key.getFormulaType();
        return Boolean.valueOf(Objects.equal(_formulaType, FormulaType.CTL));
      }
    };
    final Iterable<Pair<FormulaHolder, Group>> ctlFormulas = IterableExtensions.<Pair<FormulaHolder, Group>>filter(holderGroupList, _function);
    final Function1<Pair<FormulaHolder, Group>, Boolean> _function_1 = new Function1<Pair<FormulaHolder, Group>, Boolean>() {
      public Boolean apply(final Pair<FormulaHolder, Group> it) {
        FormulaHolder _key = it.getKey();
        FormulaType _formulaType = _key.getFormulaType();
        return Boolean.valueOf(Objects.equal(_formulaType, FormulaType.LTL));
      }
    };
    final Iterable<Pair<FormulaHolder, Group>> ltlFormulas = IterableExtensions.<Pair<FormulaHolder, Group>>filter(holderGroupList, _function_1);
    Iterable<Pair<FormulaHolder, Group>> _plus = Iterables.<Pair<FormulaHolder, Group>>concat(ctlFormulas, ltlFormulas);
    final List<Pair<FormulaHolder, Group>> reorderedFormulaHolders = IterableExtensions.<Pair<FormulaHolder, Group>>toList(_plus);
    EList<Specification> _specifications = counterExample.getSpecifications();
    final Procedure2<Specification, Integer> _function_2 = new Procedure2<Specification, Integer>() {
      public void apply(final Specification spec, final Integer i) {
        EList<Annotation> _annotations = spec.getAnnotations();
        FormulaIdentificationAnnotation _createFormulaIdentificationAnnotation = SpecificationResolver.this.fac.createFormulaIdentificationAnnotation();
        final Procedure1<FormulaIdentificationAnnotation> _function = new Procedure1<FormulaIdentificationAnnotation>() {
          public void apply(final FormulaIdentificationAnnotation it) {
            final Pair<FormulaHolder, Group> pair = reorderedFormulaHolders.get((i).intValue());
            FormulaHolder _key = pair.getKey();
            it.setFormulaHolder(_key);
            Group _value = pair.getValue();
            it.setGroup(_value);
          }
        };
        FormulaIdentificationAnnotation _doubleArrow = ObjectExtensions.<FormulaIdentificationAnnotation>operator_doubleArrow(_createFormulaIdentificationAnnotation, _function);
        _annotations.add(_doubleArrow);
      }
    };
    IterableExtensions.<Specification>forEach(_specifications, _function_2);
  }
}
