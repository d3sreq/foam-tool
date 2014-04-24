package org.foam.transform.ucm2ucm.flowannotationresolver;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.annotation.UnknownAnnotation;
import org.foam.flowannotation.FlowannotationFactory;
import org.foam.flowannotation.Goto;
import org.foam.flowannotation.Guard;
import org.foam.flowannotation.Include;
import org.foam.flowannotation.Mark;
import org.foam.flowannotation.VariableDefinitionAnnotation;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.PropositionallogicFactory;
import org.foam.propositionallogic.PropositionallogicPackage;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;
import transformation.propositionallogiclang2propositionallogic.PropositionalLogicXtextStandaloneSetup;
import transformation.propositionallogiclang2propositionallogic.parser.antlr.PropositionalLogicXtextParser;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse;

@SuppressWarnings("all")
public class FlowAnnotationResolver {
  private final static String MARK_PREFIX = "mark_";
  
  private final FlowannotationFactory flowannotationFactory = FlowannotationFactory.eINSTANCE;
  
  private final PropositionallogicFactory propLogicFactory = PropositionallogicFactory.eINSTANCE;
  
  private final PropositionalLogicXtextParser propLogicParser;
  
  public FlowAnnotationResolver() {
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(PropositionallogicPackage.eNS_URI);
    boolean _not = (!_containsKey);
    if (_not) {
      EPackage.Registry.INSTANCE.put(PropositionallogicPackage.eNS_URI, PropositionallogicPackage.eINSTANCE);
    }
    PropositionalLogicXtextStandaloneSetup _propositionalLogicXtextStandaloneSetup = new PropositionalLogicXtextStandaloneSetup();
    final Injector propLogicInjector = _propositionalLogicXtextStandaloneSetup.createInjectorAndDoEMFRegistration();
    PropositionalLogicXtextParser _instance = propLogicInjector.<PropositionalLogicXtextParser>getInstance(PropositionalLogicXtextParser.class);
    this.propLogicParser = _instance;
  }
  
  public void resolveAnnotations(final UseCaseModel useCaseModel) {
    final HashMap<String,UseCase> id2Uc = new HashMap<String, UseCase>();
    final EList<UseCase> allUseCases = useCaseModel.getUseCases();
    final Procedure1<UseCase> _function = new Procedure1<UseCase>() {
      public void apply(final UseCase it) {
        String _id = it.getId();
        id2Uc.put(_id, it);
      }
    };
    IterableExtensions.<UseCase>forEach(allUseCases, _function);
    for (final UseCase useCase : allUseCases) {
      {
        final Map<String,Step> id2Step = this.getId2Step(useCase);
        final Iterable<Annotation> allUseCaseAnnotations = UcmUtils.getStepAnnotations(useCase);
        final Iterable<UnknownAnnotation> allUnknownAnnotations = Iterables.<UnknownAnnotation>filter(allUseCaseAnnotations, UnknownAnnotation.class);
        for (final UnknownAnnotation annotation : allUnknownAnnotations) {
          {
            final Annotation resolvedAnnotation = this.resolveAnnotation(annotation, id2Uc, id2Step, useCaseModel);
            boolean _notEquals = (!Objects.equal(annotation, resolvedAnnotation));
            if (_notEquals) {
              EcoreUtil2.replace(annotation, resolvedAnnotation);
            }
          }
        }
      }
    }
  }
  
  private Annotation resolveAnnotation(final UnknownAnnotation annotation, final HashMap<String,UseCase> id2Uc, final Map<String,Step> id2Step, final UseCaseModel useCaseModel) {
    final Map<String,VariableDefinition> varName2VarDef = this.getVarName2VarDef(useCaseModel);
    Annotation _switchResult = null;
    EList<String> _parts = annotation.getParts();
    String _head = IterableExtensions.<String>head(_parts);
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_head,"abort")) {
        _matched=true;
        _switchResult = this.flowannotationFactory.createAbort();
      }
    }
    if (!_matched) {
      if (Objects.equal(_head,"include")) {
        _matched=true;
        Include _createInclude = this.flowannotationFactory.createInclude();
        final Procedure1<Include> _function = new Procedure1<Include>() {
          public void apply(final Include it) {
            EList<String> _parts = annotation.getParts();
            final String ucId = _parts.get(1);
            UseCase _get = id2Uc.get(ucId);
            it.setInlinedUseCase(_get);
          }
        };
        _switchResult = ObjectExtensions.<Include>operator_doubleArrow(_createInclude, _function);
      }
    }
    if (!_matched) {
      if (Objects.equal(_head,"goto")) {
        _matched=true;
        Goto _createGoto = this.flowannotationFactory.createGoto();
        final Procedure1<Goto> _function_1 = new Procedure1<Goto>() {
          public void apply(final Goto it) {
            EList<String> _parts = annotation.getParts();
            final String targetId = _parts.get(1);
            Step _get = id2Step.get(targetId);
            it.setTarget(_get);
          }
        };
        _switchResult = ObjectExtensions.<Goto>operator_doubleArrow(_createGoto, _function_1);
      }
    }
    if (!_matched) {
      if (Objects.equal(_head,"guard")) {
        _matched=true;
        Guard _xblockexpression = null;
        {
          Guard _createGuard = this.flowannotationFactory.createGuard();
          final Procedure1<Guard> _function_2 = new Procedure1<Guard>() {
            public void apply(final Guard it) {
              EList<String> _parts = annotation.getParts();
              final String formulaText = _parts.get(1);
              Formula _formula = FlowAnnotationResolver.this.getFormula(formulaText);
              it.setFormula(_formula);
            }
          };
          final Guard guard = ObjectExtensions.<Guard>operator_doubleArrow(_createGuard, _function_2);
          this.resolveVariables(guard, varName2VarDef, useCaseModel);
          _xblockexpression = guard;
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_head,"mark")) {
        _matched=true;
        Mark _createMark = this.flowannotationFactory.createMark();
        final Procedure1<Mark> _function_2 = new Procedure1<Mark>() {
          public void apply(final Mark it) {
            EList<String> _parts = annotation.getParts();
            final String varName = _parts.get(1);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(FlowAnnotationResolver.MARK_PREFIX, "");
            _builder.append(varName, "");
            VariableDefinition _findOrAddVariableDefinition = FlowAnnotationResolver.this.findOrAddVariableDefinition(_builder.toString(), varName2VarDef, useCaseModel);
            it.setVariableDefinition(_findOrAddVariableDefinition);
          }
        };
        _switchResult = ObjectExtensions.<Mark>operator_doubleArrow(_createMark, _function_2);
      }
    }
    if (!_matched) {
      _switchResult = annotation;
    }
    return _switchResult;
  }
  
  private Formula getFormula(final String text) {
    final IParseResult parseResult = this.propLogicParser.doParse(text);
    EObject _rootASTElement = parseResult.getRootASTElement();
    return ((Formula) _rootASTElement);
  }
  
  private void resolveVariables(final EObject container, final Map<String,VariableDefinition> varName2VarDef, final UseCaseModel useCaseModel) {
    final List<RuleVariableUse> ruleVars = EcoreUtil2.<RuleVariableUse>getAllContentsOfType(container, RuleVariableUse.class);
    for (final RuleVariableUse ruleVar : ruleVars) {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(FlowAnnotationResolver.MARK_PREFIX, "");
        String _variable = ruleVar.getVariable();
        _builder.append(_variable, "");
        final String varName = _builder.toString();
        boolean _containsKey = varName2VarDef.containsKey(varName);
        boolean _not = (!_containsKey);
        if (_not) {
          VariableDefinition _createVariableDefinition = this.propLogicFactory.createVariableDefinition();
          final Procedure1<VariableDefinition> _function = new Procedure1<VariableDefinition>() {
            public void apply(final VariableDefinition it) {
              it.setName(varName);
            }
          };
          final VariableDefinition varDef = ObjectExtensions.<VariableDefinition>operator_doubleArrow(_createVariableDefinition, _function);
          varName2VarDef.put(varName, varDef);
          EList<Annotation> _annotations = useCaseModel.getAnnotations();
          VariableDefinitionAnnotation _createVariableDefinitionAnnotation = this.flowannotationFactory.createVariableDefinitionAnnotation();
          final Procedure1<VariableDefinitionAnnotation> _function_1 = new Procedure1<VariableDefinitionAnnotation>() {
            public void apply(final VariableDefinitionAnnotation it) {
              it.setVariableDefinition(varDef);
            }
          };
          VariableDefinitionAnnotation _doubleArrow = ObjectExtensions.<VariableDefinitionAnnotation>operator_doubleArrow(_createVariableDefinitionAnnotation, _function_1);
          _annotations.add(_doubleArrow);
        }
        VariableUse _createVariableUse = this.propLogicFactory.createVariableUse();
        final Procedure1<VariableUse> _function_2 = new Procedure1<VariableUse>() {
          public void apply(final VariableUse it) {
            VariableDefinition _get = varName2VarDef.get(varName);
            it.setVariableDefinition(_get);
          }
        };
        final VariableUse varUse = ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function_2);
        EcoreUtil2.replace(ruleVar, varUse);
      }
    }
  }
  
  private Map<String,VariableDefinition> getVarName2VarDef(final UseCaseModel useCaseModel) {
    HashMap<String,VariableDefinition> _xblockexpression = null;
    {
      final HashMap<String,VariableDefinition> varName2VarDef = new HashMap<String, VariableDefinition>();
      EList<Annotation> _annotations = useCaseModel.getAnnotations();
      Iterable<VariableDefinitionAnnotation> _filter = Iterables.<VariableDefinitionAnnotation>filter(_annotations, VariableDefinitionAnnotation.class);
      final Function1<VariableDefinitionAnnotation,VariableDefinition> _function = new Function1<VariableDefinitionAnnotation,VariableDefinition>() {
        public VariableDefinition apply(final VariableDefinitionAnnotation it) {
          return it.getVariableDefinition();
        }
      };
      final Iterable<VariableDefinition> varDefs = IterableExtensions.<VariableDefinitionAnnotation, VariableDefinition>map(_filter, _function);
      final Procedure1<VariableDefinition> _function_1 = new Procedure1<VariableDefinition>() {
        public void apply(final VariableDefinition it) {
          String _name = it.getName();
          varName2VarDef.put(_name, it);
        }
      };
      IterableExtensions.<VariableDefinition>forEach(varDefs, _function_1);
      _xblockexpression = varName2VarDef;
    }
    return _xblockexpression;
  }
  
  private VariableDefinition findOrAddVariableDefinition(final String variableName, final Map<String,VariableDefinition> varName2VarDef, final UseCaseModel useCaseModel) {
    VariableDefinition _xblockexpression = null;
    {
      boolean _containsKey = varName2VarDef.containsKey(variableName);
      boolean _not = (!_containsKey);
      if (_not) {
        VariableDefinition _createVariableDefinition = this.propLogicFactory.createVariableDefinition();
        final Procedure1<VariableDefinition> _function = new Procedure1<VariableDefinition>() {
          public void apply(final VariableDefinition it) {
            it.setName(variableName);
          }
        };
        final VariableDefinition varDef = ObjectExtensions.<VariableDefinition>operator_doubleArrow(_createVariableDefinition, _function);
        EList<Annotation> _annotations = useCaseModel.getAnnotations();
        VariableDefinitionAnnotation _createVariableDefinitionAnnotation = this.flowannotationFactory.createVariableDefinitionAnnotation();
        final Procedure1<VariableDefinitionAnnotation> _function_1 = new Procedure1<VariableDefinitionAnnotation>() {
          public void apply(final VariableDefinitionAnnotation it) {
            it.setVariableDefinition(varDef);
          }
        };
        VariableDefinitionAnnotation _doubleArrow = ObjectExtensions.<VariableDefinitionAnnotation>operator_doubleArrow(_createVariableDefinitionAnnotation, _function_1);
        _annotations.add(_doubleArrow);
        varName2VarDef.put(variableName, varDef);
      }
      _xblockexpression = varName2VarDef.get(variableName);
    }
    return _xblockexpression;
  }
  
  private Map<String,Step> getId2Step(final UseCase useCase) {
    HashMap<String,Step> _xblockexpression = null;
    {
      final HashMap<String,Step> result = new HashMap<String, Step>();
      Scenario _mainScenario = useCase.getMainScenario();
      EList<Step> _steps = _mainScenario.getSteps();
      final Procedure1<Step> _function = new Procedure1<Step>() {
        public void apply(final Step it) {
          String _label = it.getLabel();
          result.put(_label, it);
        }
      };
      IterableExtensions.<Step>forEach(_steps, _function);
      EMap<Step,ScenarioHolder> _branches = useCase.getBranches();
      Collection<ScenarioHolder> _values = _branches.values();
      for (final ScenarioHolder holder : _values) {
        {
          EList<Scenario> _extensions = holder.getExtensions();
          EList<Scenario> _variations = holder.getVariations();
          final Iterable<Scenario> scenarios = Iterables.<Scenario>concat(_extensions, _variations);
          final Function1<Scenario,EList<Step>> _function_1 = new Function1<Scenario,EList<Step>>() {
            public EList<Step> apply(final Scenario it) {
              return it.getSteps();
            }
          };
          Iterable<EList<Step>> _map = IterableExtensions.<Scenario, EList<Step>>map(scenarios, _function_1);
          final Iterable<Step> steps = Iterables.<Step>concat(_map);
          final Procedure1<Step> _function_2 = new Procedure1<Step>() {
            public void apply(final Step it) {
              String _label = it.getLabel();
              result.put(_label, it);
            }
          };
          IterableExtensions.<Step>forEach(steps, _function_2);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
}
