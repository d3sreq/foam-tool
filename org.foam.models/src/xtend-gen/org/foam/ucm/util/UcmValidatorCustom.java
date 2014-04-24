package org.foam.ucm.util;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.flowannotation.Abort;
import org.foam.flowannotation.Goto;
import org.foam.flowannotation.Guard;
import org.foam.ucm.Scenario;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;
import org.foam.ucm.util.UcmValidator;

@SuppressWarnings("all")
public class UcmValidatorCustom extends UcmValidator {
  public boolean validateUseCase_PrecedenceWithoutCycle(final UseCase useCase, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      final Set<UseCase> preceededTransitively = UcmUtils.getPreceededTransitively(useCase);
      boolean _contains = preceededTransitively.contains(useCase);
      if (_contains) {
        this.addDiagnostics(diagnostics, useCase, context, "PrecedenceWithoutCycle");
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateUseCase_IncludeWithoutCycle(final UseCase useCase, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      final Set<UseCase> includedUseCases = UcmUtils.getIncludedTransitively(useCase);
      boolean _contains = includedUseCases.contains(useCase);
      if (_contains) {
        this.addDiagnostics(diagnostics, useCase, context, "IncludeWithoutCycle");
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateUseCase_IncludedIsSubsetOfPreceeded(final UseCase useCase, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      Set<UseCase> _includedTransitively = UcmUtils.getIncludedTransitively(useCase);
      Set<UseCase> _singleton = Collections.<UseCase>singleton(useCase);
      final Iterable<UseCase> includedOrSelf = Iterables.<UseCase>concat(_includedTransitively, _singleton);
      Set<UseCase> _preceededTransitively = UcmUtils.getPreceededTransitively(useCase);
      Set<UseCase> _singleton_1 = Collections.<UseCase>singleton(useCase);
      Iterable<UseCase> _plus = Iterables.<UseCase>concat(_preceededTransitively, _singleton_1);
      final Set<UseCase> preceededOrSelf = IterableExtensions.<UseCase>toSet(_plus);
      for (final UseCase includedUseCase : includedOrSelf) {
        EList<UseCase> _preceeded = includedUseCase.getPreceeded();
        boolean _containsAll = preceededOrSelf.containsAll(_preceeded);
        boolean _not = (!_containsAll);
        if (_not) {
          this.addDiagnostics(diagnostics, useCase, context, "IncludedIsSubsetOfPreceeded");
          return false;
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateUseCase_NoAbortInMainScenario(final UseCase useCase, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      Scenario _mainScenario = useCase.getMainScenario();
      Iterable<Annotation> _stepAnnotations = UcmUtils.getStepAnnotations(_mainScenario);
      final Iterable<Abort> aborts = Iterables.<Abort>filter(_stepAnnotations, Abort.class);
      boolean _isEmpty = IterableExtensions.isEmpty(aborts);
      boolean _not = (!_isEmpty);
      if (_not) {
        this.addDiagnostics(diagnostics, useCase, context, "NoAbortInMainScenario");
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateUseCase_NoGotoInMainScenario(final UseCase useCase, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      Scenario _mainScenario = useCase.getMainScenario();
      Iterable<Annotation> _stepAnnotations = UcmUtils.getStepAnnotations(_mainScenario);
      final Iterable<Goto> gotos = Iterables.<Goto>filter(_stepAnnotations, Goto.class);
      boolean _isEmpty = IterableExtensions.isEmpty(gotos);
      boolean _not = (!_isEmpty);
      if (_not) {
        this.addDiagnostics(diagnostics, useCase, context, "NoGotoInMainScenario");
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateScenario_AbortOnlyAtScenarioEnd(final Scenario scenario, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      EList<Step> _steps = scenario.getSteps();
      final Step lastStep = IterableExtensions.<Step>last(_steps);
      EList<Step> _steps_1 = scenario.getSteps();
      for (final Step step : _steps_1) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          final Iterable<Abort> aborts = Iterables.<Abort>filter(_annotations, Abort.class);
          boolean _and = false;
          boolean _isEmpty = IterableExtensions.isEmpty(aborts);
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and = false;
          } else {
            boolean _notEquals = (!Objects.equal(step, lastStep));
            _and = _notEquals;
          }
          if (_and) {
            this.addDiagnostics(diagnostics, scenario, context, "AbortOnlyAtScenarioEnd");
            return false;
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateScenario_GotoOnlyAtScenarioEnd(final Scenario scenario, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      EList<Step> _steps = scenario.getSteps();
      final Step lastStep = IterableExtensions.<Step>last(_steps);
      EList<Step> _steps_1 = scenario.getSteps();
      for (final Step step : _steps_1) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          final Iterable<Goto> gotos = Iterables.<Goto>filter(_annotations, Goto.class);
          boolean _and = false;
          boolean _isEmpty = IterableExtensions.isEmpty(gotos);
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and = false;
          } else {
            boolean _notEquals = (!Objects.equal(step, lastStep));
            _and = _notEquals;
          }
          if (_and) {
            this.addDiagnostics(diagnostics, scenario, context, "GotoOnlyAtScenarioEnd");
            return false;
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateScenario_OnlyOneOfAbortGotoAtScenarioEnd(final Scenario scenario, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      EList<Step> _steps = scenario.getSteps();
      final Step lastStep = IterableExtensions.<Step>last(_steps);
      EList<Annotation> _annotations = lastStep.getAnnotations();
      final Iterable<Abort> aborts = Iterables.<Abort>filter(_annotations, Abort.class);
      EList<Annotation> _annotations_1 = lastStep.getAnnotations();
      final Iterable<Goto> gotos = Iterables.<Goto>filter(_annotations_1, Goto.class);
      boolean _and = false;
      boolean _isEmpty = IterableExtensions.isEmpty(aborts);
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        boolean _isEmpty_1 = IterableExtensions.isEmpty(gotos);
        boolean _not_1 = (!_isEmpty_1);
        _and = _not_1;
      }
      if (_and) {
        this.addDiagnostics(diagnostics, scenario, context, "OnlyOneOfAbortGotoAtScenarioEnd");
        return false;
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  public boolean validateScenario_GuardOnlyAtScenarioStart(final Scenario scenario, final DiagnosticChain diagnostics, final Map<Object,Object> context) {
    boolean _xblockexpression = false;
    {
      EList<Step> _steps = scenario.getSteps();
      final Step firstStep = IterableExtensions.<Step>head(_steps);
      EList<Step> _steps_1 = scenario.getSteps();
      for (final Step step : _steps_1) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          final Iterable<Guard> guards = Iterables.<Guard>filter(_annotations, Guard.class);
          boolean _and = false;
          boolean _isEmpty = IterableExtensions.isEmpty(guards);
          boolean _not = (!_isEmpty);
          if (!_not) {
            _and = false;
          } else {
            boolean _notEquals = (!Objects.equal(step, firstStep));
            _and = _notEquals;
          }
          if (_and) {
            this.addDiagnostics(diagnostics, scenario, context, "GuardOnlyAtScenarioStart");
            return false;
          }
        }
      }
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  private void addDiagnostics(final DiagnosticChain diagnostics, final EObject eObject, final Map<Object,Object> context, final String errorLabelId) {
    boolean _notEquals = (!Objects.equal(diagnostics, null));
    if (_notEquals) {
      String _objectLabel = EObjectValidator.getObjectLabel(eObject, context);
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(errorLabelId, _objectLabel);
      ArrayList<Object> _newArrayList_1 = CollectionLiterals.<Object>newArrayList(eObject);
      BasicDiagnostic _createDiagnostic = this.createDiagnostic(Diagnostic.ERROR, 
        UcmValidator.DIAGNOSTIC_SOURCE, 
        0, 
        "_UI_GenericConstraint_diagnostic", ((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_newArrayList_1, Object.class)), context);
      diagnostics.add(_createDiagnostic);
    }
  }
}
