package org.foam.transform.ucm2ucm.tadlannotationresolver;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.annotation.Annotation;
import org.foam.annotation.UnknownAnnotation;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.tadl.Group;
import org.foam.tadl.GroupAnnotation;
import org.foam.tadl.TadlFactory;
import org.foam.tadl.Template;
import org.foam.tadl.TemporalAnnotation;
import org.foam.ucm.UseCase;
import org.foam.ucm.UseCaseModel;
import org.foam.ucm.util.UcmUtils;

@SuppressWarnings("all")
public class TadlAnnotationResolver {
  private final TadlFactory tadlFac = TadlFactory.eINSTANCE;
  
  public void resolveAnnotations(final UseCaseModel useCaseModel, final Collection<Template> templates) {
    final HashMap<String, Template> varDefName2Template = new HashMap<String, Template>();
    final HashMap<String, VariableDefinition> varDefName2VarDef = new HashMap<String, VariableDefinition>();
    for (final Template template : templates) {
      EList<VariableDefinition> _variableDefinitions = template.getVariableDefinitions();
      for (final VariableDefinition varDef : _variableDefinitions) {
        {
          String _name = varDef.getName();
          varDefName2Template.put(_name, template);
          String _name_1 = varDef.getName();
          varDefName2VarDef.put(_name_1, varDef);
        }
      }
    }
    final HashMap<String, Group> qualifier2Group = new HashMap<String, Group>();
    EList<UseCase> _useCases = useCaseModel.getUseCases();
    for (final UseCase useCase : _useCases) {
      {
        final Iterable<Annotation> allUseCaseAnnotations = UcmUtils.getStepAnnotations(useCase);
        final Iterable<UnknownAnnotation> allUnknownAnnotations = Iterables.<UnknownAnnotation>filter(allUseCaseAnnotations, UnknownAnnotation.class);
        for (final UnknownAnnotation annotation : allUnknownAnnotations) {
          {
            final Annotation resolvedAnnotation = this.resolveAnnotation(annotation, varDefName2Template, varDefName2VarDef, qualifier2Group, useCaseModel);
            boolean _notEquals = (!Objects.equal(annotation, resolvedAnnotation));
            if (_notEquals) {
              EcoreUtil.replace(annotation, resolvedAnnotation);
            }
          }
        }
      }
    }
  }
  
  private Annotation resolveAnnotation(final UnknownAnnotation annotation, final Map<String, Template> varDefName2Template, final Map<String, VariableDefinition> varDefName2VarDef, final Map<String, Group> qualifier2Group, final UseCaseModel useCaseModel) {
    EList<String> _parts = annotation.getParts();
    int _size = _parts.size();
    boolean _notEquals = (_size != 2);
    if (_notEquals) {
      return annotation;
    }
    EList<String> _parts_1 = annotation.getParts();
    final String varDefName = _parts_1.get(0);
    EList<String> _parts_2 = annotation.getParts();
    final String qualifier = _parts_2.get(1);
    boolean _containsKey = varDefName2Template.containsKey(varDefName);
    boolean _not = (!_containsKey);
    if (_not) {
      return annotation;
    }
    boolean _containsKey_1 = qualifier2Group.containsKey(qualifier);
    boolean _not_1 = (!_containsKey_1);
    if (_not_1) {
      Group _createGroup = this.tadlFac.createGroup();
      final Procedure1<Group> _function = new Procedure1<Group>() {
        public void apply(final Group it) {
          it.setQualifier(qualifier);
          Template _get = varDefName2Template.get(varDefName);
          it.setTemplate(_get);
        }
      };
      final Group group = ObjectExtensions.<Group>operator_doubleArrow(_createGroup, _function);
      qualifier2Group.put(qualifier, group);
      EList<Annotation> _annotations = useCaseModel.getAnnotations();
      GroupAnnotation _createGroupAnnotation = this.tadlFac.createGroupAnnotation();
      final Procedure1<GroupAnnotation> _function_1 = new Procedure1<GroupAnnotation>() {
        public void apply(final GroupAnnotation it) {
          it.setGroup(group);
        }
      };
      GroupAnnotation _doubleArrow = ObjectExtensions.<GroupAnnotation>operator_doubleArrow(_createGroupAnnotation, _function_1);
      _annotations.add(_doubleArrow);
    }
    final Group group_1 = qualifier2Group.get(qualifier);
    final VariableDefinition varDef = varDefName2VarDef.get(varDefName);
    TemporalAnnotation _createTemporalAnnotation = this.tadlFac.createTemporalAnnotation();
    final Procedure1<TemporalAnnotation> _function_2 = new Procedure1<TemporalAnnotation>() {
      public void apply(final TemporalAnnotation it) {
        it.setVariableDefinition(varDef);
        it.setGroup(group_1);
      }
    };
    return ObjectExtensions.<TemporalAnnotation>operator_doubleArrow(_createTemporalAnnotation, _function_2);
  }
}
