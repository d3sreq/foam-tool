package org.foam.cli.tools.report.pages;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.annotation.Annotation;
import org.foam.annotation.UnknownAnnotation;
import org.foam.flowannotation.Abort;
import org.foam.flowannotation.Goto;
import org.foam.flowannotation.Guard;
import org.foam.flowannotation.Include;
import org.foam.flowannotation.Mark;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.tadl.Group;
import org.foam.tadl.TemporalAnnotation;
import org.foam.transform.lts2nusmvlang.TADLFormulaRenderer;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;

@SuppressWarnings("all")
public class FoamCommonAnnotationRenderer {
  @Extension
  private TADLFormulaRenderer _tADLFormulaRenderer = new TADLFormulaRenderer();
  
  protected CharSequence _render(final Annotation annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("?");
    _builder.append(annot, "");
    return _builder;
  }
  
  protected CharSequence _render(final UnknownAnnotation annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<span style=\"color:violet\">#");
    EList<String> _parts = annot.getParts();
    String _join = IterableExtensions.join(_parts, ":");
    _builder.append(_join, "");
    _builder.append("</span>");
    return _builder;
  }
  
  protected CharSequence _render(final Abort annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#abort");
    return _builder;
  }
  
  protected CharSequence _render(final Include annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#include:<a href=\"../");
    UseCase _inlinedUseCase = annot.getInlinedUseCase();
    String _id = _inlinedUseCase.getId();
    _builder.append(_id, "");
    _builder.append("/");
    UseCase _inlinedUseCase_1 = annot.getInlinedUseCase();
    String _id_1 = _inlinedUseCase_1.getId();
    _builder.append(_id_1, "");
    _builder.append(".html\">");
    UseCase _inlinedUseCase_2 = annot.getInlinedUseCase();
    String _id_2 = _inlinedUseCase_2.getId();
    _builder.append(_id_2, "");
    _builder.append("</a>");
    return _builder;
  }
  
  protected CharSequence _render(final Goto annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#goto:");
    Step _target = annot.getTarget();
    String _label = _target.getLabel();
    _builder.append(_label, "");
    return _builder;
  }
  
  protected CharSequence _render(final Mark annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#mark:");
    VariableDefinition _variableDefinition = annot.getVariableDefinition();
    String _name = _variableDefinition.getName();
    _builder.append(_name, "");
    return _builder;
  }
  
  protected CharSequence _render(final Guard annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#guard:");
    Formula _formula = annot.getFormula();
    String _evalFormula = this._tADLFormulaRenderer.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _render(final TemporalAnnotation annot) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#");
    VariableDefinition _variableDefinition = annot.getVariableDefinition();
    String _name = _variableDefinition.getName();
    _builder.append(_name, "");
    _builder.append(":");
    Group _group = annot.getGroup();
    String _qualifier = _group.getQualifier();
    _builder.append(_qualifier, "");
    return _builder;
  }
  
  public CharSequence render(final Annotation annot) {
    if (annot instanceof Abort) {
      return _render((Abort)annot);
    } else if (annot instanceof Goto) {
      return _render((Goto)annot);
    } else if (annot instanceof Guard) {
      return _render((Guard)annot);
    } else if (annot instanceof Include) {
      return _render((Include)annot);
    } else if (annot instanceof Mark) {
      return _render((Mark)annot);
    } else if (annot instanceof UnknownAnnotation) {
      return _render((UnknownAnnotation)annot);
    } else if (annot instanceof TemporalAnnotation) {
      return _render((TemporalAnnotation)annot);
    } else if (annot != null) {
      return _render(annot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(annot).toString());
    }
  }
}
