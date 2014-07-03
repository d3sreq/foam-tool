package org.foam.transform.utils.model;

import java.util.List;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class BasicModelValidationException extends RuntimeException {
  private final Diagnostic _diagnostic;
  
  public Diagnostic getDiagnostic() {
    return this._diagnostic;
  }
  
  public BasicModelValidationException(final Diagnostic diagnostic) {
    this._diagnostic = diagnostic;
  }
  
  public String getMessage() {
    Diagnostic _diagnostic = this.getDiagnostic();
    List<Diagnostic> _children = _diagnostic.getChildren();
    final Function1<Diagnostic, String> _function = new Function1<Diagnostic, String>() {
      public String apply(final Diagnostic it) {
        return it.getMessage();
      }
    };
    List<String> _map = ListExtensions.<Diagnostic, String>map(_children, _function);
    return IterableExtensions.join(_map, "\n");
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((_diagnostic== null) ? 0 : _diagnostic.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    if (!super.equals(obj))
      return false;
    BasicModelValidationException other = (BasicModelValidationException) obj;
    if (_diagnostic == null) {
      if (other._diagnostic != null)
        return false;
    } else if (!_diagnostic.equals(other._diagnostic))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
