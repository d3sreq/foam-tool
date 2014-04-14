package org.foam.ucm.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.foam.annotation.Annotation;
import org.foam.flowannotation.Include;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;

@SuppressWarnings("all")
public class UcmUtils {
  public static Iterable<Annotation> getStepAnnotations(final UseCase useCase) {
    Iterable<Annotation> _xblockexpression = null;
    {
      EMap<Step,ScenarioHolder> _branches = useCase.getBranches();
      final Collection<ScenarioHolder> holders = _branches.values();
      final Function1<ScenarioHolder,EList<Scenario>> _function = new Function1<ScenarioHolder,EList<Scenario>>() {
        public EList<Scenario> apply(final ScenarioHolder it) {
          return it.getExtensions();
        }
      };
      final Iterable<EList<Scenario>> extScenarioLists = IterableExtensions.<ScenarioHolder, EList<Scenario>>map(holders, _function);
      final Function1<ScenarioHolder,EList<Scenario>> _function_1 = new Function1<ScenarioHolder,EList<Scenario>>() {
        public EList<Scenario> apply(final ScenarioHolder it) {
          return it.getVariations();
        }
      };
      final Iterable<EList<Scenario>> varScenarioLists = IterableExtensions.<ScenarioHolder, EList<Scenario>>map(holders, _function_1);
      Iterable<EList<Scenario>> _plus = Iterables.<EList<Scenario>>concat(extScenarioLists, varScenarioLists);
      Iterable<Scenario> _flatten = Iterables.<Scenario>concat(_plus);
      Scenario _mainScenario = useCase.getMainScenario();
      List<Scenario> _singletonList = Collections.<Scenario>singletonList(_mainScenario);
      final Iterable<Scenario> allScenarios = Iterables.<Scenario>concat(_flatten, _singletonList);
      final Function1<Scenario,Iterable<Annotation>> _function_2 = new Function1<Scenario,Iterable<Annotation>>() {
        public Iterable<Annotation> apply(final Scenario it) {
          return UcmUtils.getStepAnnotations(it);
        }
      };
      Iterable<Iterable<Annotation>> _map = IterableExtensions.<Scenario, Iterable<Annotation>>map(allScenarios, _function_2);
      _xblockexpression = Iterables.<Annotation>concat(_map);
    }
    return _xblockexpression;
  }
  
  public static Iterable<Annotation> getStepAnnotations(final Scenario scenario) {
    EList<Step> _steps = scenario.getSteps();
    final Function1<Step,EList<Annotation>> _function = new Function1<Step,EList<Annotation>>() {
      public EList<Annotation> apply(final Step it) {
        return it.getAnnotations();
      }
    };
    List<EList<Annotation>> _map = ListExtensions.<Step, EList<Annotation>>map(_steps, _function);
    return Iterables.<Annotation>concat(_map);
  }
  
  public static Iterable<Step> allSteps(final UseCase useCase) {
    Iterable<Scenario> _allScenarios = UcmUtils.allScenarios(useCase);
    final Function1<Scenario,EList<Step>> _function = new Function1<Scenario,EList<Step>>() {
      public EList<Step> apply(final Scenario it) {
        return it.getSteps();
      }
    };
    Iterable<EList<Step>> _map = IterableExtensions.<Scenario, EList<Step>>map(_allScenarios, _function);
    return Iterables.<Step>concat(_map);
  }
  
  public static Iterable<Scenario> allScenarios(final UseCase useCase) {
    Scenario _mainScenario = useCase.getMainScenario();
    List<Scenario> _singletonList = Collections.<Scenario>singletonList(_mainScenario);
    EMap<Step,ScenarioHolder> _branches = useCase.getBranches();
    Collection<ScenarioHolder> _values = _branches.values();
    final Function1<ScenarioHolder,List<Scenario>> _function = new Function1<ScenarioHolder,List<Scenario>>() {
      public List<Scenario> apply(final ScenarioHolder it) {
        FeatureMap _branches = it.getBranches();
        final Function1<FeatureMap.Entry,Scenario> _function = new Function1<FeatureMap.Entry,Scenario>() {
          public Scenario apply(final FeatureMap.Entry it) {
            Object _value = it.getValue();
            return ((Scenario) _value);
          }
        };
        return ListExtensions.<FeatureMap.Entry, Scenario>map(_branches, _function);
      }
    };
    Iterable<List<Scenario>> _map = IterableExtensions.<ScenarioHolder, List<Scenario>>map(_values, _function);
    Iterable<Scenario> _flatten = Iterables.<Scenario>concat(_map);
    return Iterables.<Scenario>concat(_singletonList, _flatten);
  }
  
  public static Set<UseCase> getPreceededTransitively(final UseCase useCase) {
    HashSet<UseCase> _xblockexpression = null;
    {
      Preconditions.<UseCase>checkNotNull(useCase);
      final HashSet<UseCase> result = new HashSet<UseCase>();
      UcmUtils.getPreceededRecursively(useCase, result);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private static void getPreceededRecursively(final UseCase useCase, final Set<UseCase> result) {
    EList<UseCase> _preceeded = useCase.getPreceeded();
    for (final UseCase preceededUseCase : _preceeded) {
      boolean _contains = result.contains(preceededUseCase);
      boolean _not = (!_contains);
      if (_not) {
        result.add(preceededUseCase);
        UcmUtils.getPreceededRecursively(preceededUseCase, result);
      }
    }
  }
  
  public static Set<UseCase> getIncluded(final UseCase useCase) {
    Iterable<Step> _allSteps = UcmUtils.allSteps(useCase);
    final Function1<Step,Iterable<UseCase>> _function = new Function1<Step,Iterable<UseCase>>() {
      public Iterable<UseCase> apply(final Step it) {
        EList<Annotation> _annotations = it.getAnnotations();
        Iterable<Include> _filter = Iterables.<Include>filter(_annotations, Include.class);
        final Function1<Include,UseCase> _function = new Function1<Include,UseCase>() {
          public UseCase apply(final Include it) {
            return it.getInlinedUseCase();
          }
        };
        return IterableExtensions.<Include, UseCase>map(_filter, _function);
      }
    };
    Iterable<Iterable<UseCase>> _map = IterableExtensions.<Step, Iterable<UseCase>>map(_allSteps, _function);
    Iterable<UseCase> _flatten = Iterables.<UseCase>concat(_map);
    return IterableExtensions.<UseCase>toSet(_flatten);
  }
  
  public static Set<UseCase> getIncludedTransitively(final UseCase useCase) {
    HashSet<UseCase> _xblockexpression = null;
    {
      Preconditions.<UseCase>checkNotNull(useCase);
      final HashSet<UseCase> result = new HashSet<UseCase>();
      UcmUtils.getIncludedUseCasesRecursively(useCase, result);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private static void getIncludedUseCasesRecursively(final UseCase useCase, final Set<UseCase> result) {
    final Set<UseCase> includedUseCases = UcmUtils.getIncluded(useCase);
    for (final UseCase includedUseCase : includedUseCases) {
      boolean _contains = result.contains(includedUseCase);
      boolean _not = (!_contains);
      if (_not) {
        result.add(includedUseCase);
        UcmUtils.getIncludedUseCasesRecursively(includedUseCase, result);
      }
    }
  }
  
  public static UseCase getUseCase(final Step step) {
    UseCase _xblockexpression = null;
    {
      Preconditions.<Step>checkNotNull(step);
      EObject _eContainer = step.eContainer();
      final Scenario scenario = ((Scenario) _eContainer);
      _xblockexpression = UcmUtils.getUseCase(scenario);
    }
    return _xblockexpression;
  }
  
  public static UseCase getUseCase(final Scenario scenario) {
    Preconditions.<Scenario>checkNotNull(scenario);
    final EObject scenarioParent = scenario.eContainer();
    UseCase _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (scenarioParent instanceof ScenarioHolder) {
        _matched=true;
        UseCase _xblockexpression = null;
        {
          final EObject entry = ((ScenarioHolder)scenarioParent).eContainer();
          EObject _eContainer = entry.eContainer();
          _xblockexpression = ((UseCase) _eContainer);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = ((UseCase) scenarioParent);
    }
    return _switchResult;
  }
  
  public static Scenario getScenario(final Step step) {
    Scenario _xblockexpression = null;
    {
      Preconditions.<Step>checkNotNull(step);
      EObject _eContainer = step.eContainer();
      _xblockexpression = ((Scenario) _eContainer);
    }
    return _xblockexpression;
  }
}
