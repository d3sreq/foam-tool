package org.foam.cli.tools.report;

import com.google.common.base.Objects;
import org.foam.cli.tools.report.utils.Utils;
import org.foam.cntex.Specification;
import org.foam.tadl.Group;

/**
 * Used only to remove duplicated Specification objects with Set.
 * Note that hashCode and equals are simplified - they don't compare/use
 * all fields and don't check all preconditions (e.g. null-ness in equals).
 */
@SuppressWarnings("all")
public class SpecificationWrapper {
  private final Specification _specification;
  
  public Specification getSpecification() {
    return this._specification;
  }
  
  public SpecificationWrapper(final Specification specification) {
    this._specification = specification;
  }
  
  public int hashCode() {
    Specification _specification = this.getSpecification();
    String _textFormula = _specification.getTextFormula();
    Specification _specification_1 = this.getSpecification();
    Group _group = Utils.getGroup(_specification_1);
    return Objects.hashCode(_textFormula, _group);
  }
  
  public boolean equals(final Object obj) {
    boolean _xblockexpression = false;
    {
      final Specification otherSpecification = ((SpecificationWrapper) obj).getSpecification();
      Specification _specification = this.getSpecification();
      boolean _equals = Objects.equal(_specification, otherSpecification);
      if (_equals) {
        return true;
      }
      boolean _or = false;
      Specification _specification_1 = this.getSpecification();
      String _textFormula = _specification_1.getTextFormula();
      String _textFormula_1 = otherSpecification.getTextFormula();
      boolean _notEquals = (!Objects.equal(_textFormula, _textFormula_1));
      if (_notEquals) {
        _or = true;
      } else {
        Specification _specification_2 = this.getSpecification();
        Group _group = Utils.getGroup(_specification_2);
        Group _group_1 = Utils.getGroup(otherSpecification);
        boolean _notEquals_1 = (!Objects.equal(_group, _group_1));
        _or = _notEquals_1;
      }
      if (_or) {
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
}
