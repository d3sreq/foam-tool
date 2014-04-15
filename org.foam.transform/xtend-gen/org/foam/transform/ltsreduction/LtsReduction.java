package org.foam.transform.ltsreduction;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.lts.Automaton;
import org.foam.lts.LtsFactory;
import org.foam.lts.LtsPackage;
import org.foam.lts.State;
import org.foam.lts.Transition;
import org.foam.transform.ltsreduction.StateReducedEvent;
import org.foam.transform.ltsreduction.StateReducedEventListener;
import org.foam.transform.ltsreduction.StateWithOneInputAndOneOutputTransition;

@SuppressWarnings("all")
public class LtsReduction {
  private final Predicate<State> removeStatePredicate;
  
  private final ArrayList<StateReducedEventListener> stateReducedEventListeners = new ArrayList<StateReducedEventListener>();
  
  public LtsReduction(final Predicate<State> removeStatePredicate) {
    this.removeStatePredicate = removeStatePredicate;
  }
  
  public void removeUnneededStates(final Automaton lts) {
    EList<Transition> _transitions = lts.getTransitions();
    StateWithOneInputAndOneOutputTransition _stateWithOneInputAndOneOutputTransition = new StateWithOneInputAndOneOutputTransition(_transitions);
    final Predicate<State> predicate = Predicates.<State>and(this.removeStatePredicate, _stateWithOneInputAndOneOutputTransition);
    EList<State> _states = lts.getStates();
    final Function1<State,Boolean> _function = new Function1<State,Boolean>() {
      public Boolean apply(final State it) {
        return Boolean.valueOf(predicate.apply(it));
      }
    };
    final Iterable<State> filtered = IterableExtensions.<State>filter(_states, _function);
    final ArrayList<State> statesToRemove = new ArrayList<State>();
    Iterables.<State>addAll(statesToRemove, filtered);
    final Procedure1<State> _function_1 = new Procedure1<State>() {
      public void apply(final State it) {
        LtsReduction.this.reduceState(it, lts);
      }
    };
    IterableExtensions.<State>forEach(statesToRemove, _function_1);
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
  
  private void reduceState(final State state, final Automaton automaton) {
    EList<Transition> _transitions = automaton.getTransitions();
    final Collection<EStructuralFeature.Setting> settings = EcoreUtil.UsageCrossReferencer.find(state, _transitions);
    Iterable<EStructuralFeature.Setting> _filterSettings = this.filterSettings(settings, LtsPackage.Literals.TRANSITION__START);
    EStructuralFeature.Setting _head = IterableExtensions.<EStructuralFeature.Setting>head(_filterSettings);
    EObject _eObject = _head.getEObject();
    final Transition fromState = ((Transition) _eObject);
    Iterable<EStructuralFeature.Setting> _filterSettings_1 = this.filterSettings(settings, LtsPackage.Literals.TRANSITION__END);
    EStructuralFeature.Setting _head_1 = IterableExtensions.<EStructuralFeature.Setting>head(_filterSettings_1);
    EObject _eObject_1 = _head_1.getEObject();
    final Transition toState = ((Transition) _eObject_1);
    Transition _createTransition = LtsFactory.eINSTANCE.createTransition();
    final Procedure1<Transition> _function = new Procedure1<Transition>() {
      public void apply(final Transition it) {
        State _start = toState.getStart();
        it.setStart(_start);
        State _end = fromState.getEnd();
        it.setEnd(_end);
      }
    };
    final Transition newTransition = ObjectExtensions.<Transition>operator_doubleArrow(_createTransition, _function);
    EList<Transition> _transitions_1 = automaton.getTransitions();
    _transitions_1.add(newTransition);
    EcoreUtil.remove(toState);
    EcoreUtil.remove(fromState);
    EcoreUtil.remove(state);
    this.notifyStateReduced(state, toState, fromState, newTransition);
  }
  
  protected void notifyStateReduced(final State removedState, final Transition removedToStateTransition, final Transition removedFromStateTransition, final Transition addedTransition) {
    final StateReducedEvent event = new StateReducedEvent(removedState, removedToStateTransition, removedFromStateTransition, addedTransition);
    final Procedure1<StateReducedEventListener> _function = new Procedure1<StateReducedEventListener>() {
      public void apply(final StateReducedEventListener it) {
        it.stateReduced(event);
      }
    };
    IterableExtensions.<StateReducedEventListener>forEach(this.stateReducedEventListeners, _function);
  }
  
  public void addStateReducedEventListener(final StateReducedEventListener stateReducedEventListener) {
    this.stateReducedEventListeners.add(stateReducedEventListener);
  }
  
  public void removeStateReducedEventListener(final StateReducedEventListener stateReducedEventListener) {
    this.stateReducedEventListeners.remove(stateReducedEventListener);
  }
}
