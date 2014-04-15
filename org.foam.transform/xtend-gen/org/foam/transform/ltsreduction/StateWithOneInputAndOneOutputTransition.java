package org.foam.transform.ltsreduction;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.util.Collection;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.lts.LtsPackage;
import org.foam.lts.State;
import org.foam.lts.Transition;

@Data
@SuppressWarnings("all")
public class StateWithOneInputAndOneOutputTransition implements Predicate<State> {
  private final Collection<Transition> _transitions;
  
  public Collection<Transition> getTransitions() {
    return this._transitions;
  }
  
  private Iterable<EStructuralFeature.Setting> filterSettings(final Collection<EStructuralFeature.Setting> settings, final EReference eReference) {
    final Function1<EStructuralFeature.Setting,Boolean> _function = new Function1<EStructuralFeature.Setting,Boolean>() {
      public Boolean apply(final EStructuralFeature.Setting it) {
        EStructuralFeature _eStructuralFeature = it.getEStructuralFeature();
        return Boolean.valueOf(Objects.equal(_eStructuralFeature, eReference));
      }
    };
    return IterableExtensions.<EStructuralFeature.Setting>filter(settings, _function);
  }
  
  public boolean apply(final State state) {
    boolean _xblockexpression = false;
    {
      Collection<Transition> _transitions = this.getTransitions();
      final Collection<EStructuralFeature.Setting> settings = EcoreUtil.UsageCrossReferencer.find(state, _transitions);
      final Iterable<EStructuralFeature.Setting> toState = this.filterSettings(settings, LtsPackage.Literals.TRANSITION__START);
      final Iterable<EStructuralFeature.Setting> fromState = this.filterSettings(settings, LtsPackage.Literals.TRANSITION__END);
      boolean _and = false;
      int _size = IterableExtensions.size(toState);
      boolean _equals = (_size == 1);
      if (!_equals) {
        _and = false;
      } else {
        int _size_1 = IterableExtensions.size(fromState);
        boolean _equals_1 = (_size_1 == 1);
        _and = _equals_1;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  public StateWithOneInputAndOneOutputTransition(final Collection<Transition> transitions) {
    super();
    this._transitions = transitions;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_transitions== null) ? 0 : _transitions.hashCode());
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
    StateWithOneInputAndOneOutputTransition other = (StateWithOneInputAndOneOutputTransition) obj;
    if (_transitions == null) {
      if (other._transitions != null)
        return false;
    } else if (!_transitions.equals(other._transitions))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
