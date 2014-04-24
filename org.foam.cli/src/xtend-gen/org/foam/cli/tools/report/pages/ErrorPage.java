package org.foam.cli.tools.report.pages;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.annotation.Annotation;
import org.foam.cli.tools.report.pages.FoamCommonAnnotationRenderer;
import org.foam.cli.tools.report.pages.Menu;
import org.foam.cli.tools.report.pages.Page;
import org.foam.cli.tools.report.pages.PageTemplate;
import org.foam.cli.tools.report.pages.StepTrace;
import org.foam.cli.tools.report.utils.Utils;
import org.foam.cntex.CntExState;
import org.foam.cntex.Specification;
import org.foam.cntex.Trace;
import org.foam.lts.State;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.Group;
import org.foam.tadl.Template;
import org.foam.tadl.TemporalAnnotation;
import org.foam.traceability.FormulaIdentificationAnnotation;
import org.foam.traceability.StateMappingAnnotation;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.transform.lts2nusmvlang.TADLFormulaRenderer;
import org.foam.ucm.Step;
import org.foam.ucm.UseCase;
import org.foam.ucm.util.UcmUtils;

@Data
@SuppressWarnings("all")
public class ErrorPage implements Page {
  private final Menu _menu;
  
  public Menu getMenu() {
    return this._menu;
  }
  
  private final Specification _specification;
  
  public Specification getSpecification() {
    return this._specification;
  }
  
  private final FormulaHolder _formulaHolder;
  
  public FormulaHolder getFormulaHolder() {
    return this._formulaHolder;
  }
  
  private final Group _group;
  
  public Group getGroup() {
    return this._group;
  }
  
  /**
   * Additional identifier as multiple formulas with same group may produce
   * error traces
   */
  private final String _orderId;
  
  /**
   * Additional identifier as multiple formulas with same group may produce
   * error traces
   */
  public String getOrderId() {
    return this._orderId;
  }
  
  private final TADLFormulaRenderer _renderer = new TADLFormulaRenderer();
  
  public TADLFormulaRenderer getRenderer() {
    return this._renderer;
  }
  
  public ErrorPage(final Menu menu, final Specification specification, final String orderId) {
    this._menu = menu;
    this._specification = specification;
    this._orderId = orderId;
    EList<Annotation> _annotations = specification.getAnnotations();
    final Iterable<FormulaIdentificationAnnotation> annotations = Iterables.<FormulaIdentificationAnnotation>filter(_annotations, FormulaIdentificationAnnotation.class);
    int _size = IterableExtensions.size(annotations);
    boolean _equals = (_size == 1);
    Preconditions.checkState(_equals);
    FormulaIdentificationAnnotation _head = IterableExtensions.<FormulaIdentificationAnnotation>head(annotations);
    FormulaHolder _formulaHolder = _head.getFormulaHolder();
    this._formulaHolder = _formulaHolder;
    FormulaIdentificationAnnotation _head_1 = IterableExtensions.<FormulaIdentificationAnnotation>head(annotations);
    Group _group = _head_1.getGroup();
    this._group = _group;
  }
  
  public String getId() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("error-");
    String _joinedVars = this.joinedVars();
    _builder.append(_joinedVars, "");
    _builder.append("-");
    Group _group = this.getGroup();
    String _qualifier = _group.getQualifier();
    _builder.append(_qualifier, "");
    {
      String _orderId = this.getOrderId();
      boolean _isEmpty = _orderId.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append("-");
        String _orderId_1 = this.getOrderId();
        _builder.append(_orderId_1, "");
      }
    }
    return _builder.toString();
  }
  
  public CharSequence content() {
    CharSequence _xblockexpression = null;
    {
      final String css = "";
      Menu _menu = this.getMenu();
      final CharSequence printedMenu = _menu.printMenu(this);
      final CharSequence templateContent = this.printTemplateContent();
      PageTemplate _pageTemplate = new PageTemplate();
      _xblockexpression = _pageTemplate.printPage(css, printedMenu, templateContent);
    }
    return _xblockexpression;
  }
  
  private CharSequence getTitle() {
    StringConcatenation _builder = new StringConcatenation();
    String _joinedVars = this.joinedVars();
    _builder.append(_joinedVars, "");
    _builder.append(" ");
    Group _group = this.getGroup();
    String _qualifier = _group.getQualifier();
    _builder.append(_qualifier, "");
    {
      String _orderId = this.getOrderId();
      boolean _isEmpty = _orderId.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.append(" ");
        String _orderId_1 = this.getOrderId();
        _builder.append(_orderId_1, "");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public String joinedVars() {
    Group _group = this.getGroup();
    Template _template = _group.getTemplate();
    EList<VariableDefinition> _variableDefinitions = _template.getVariableDefinitions();
    final Function1<VariableDefinition,String> _function = new Function1<VariableDefinition,String>() {
      public String apply(final VariableDefinition it) {
        return it.getName();
      }
    };
    List<String> _map = ListExtensions.<VariableDefinition, String>map(_variableDefinitions, _function);
    return IterableExtensions.join(_map, "-");
  }
  
  private StepTrace trace2StepTrace(final Trace trace) {
    StepTrace _xblockexpression = null;
    {
      final StepTrace stepTrace = new StepTrace();
      boolean markLoop = false;
      Step previousStep = null;
      EList<CntExState> _states = trace.getStates();
      for (final CntExState cntExState : _states) {
        {
          CntExState _loopStart = trace.getLoopStart();
          boolean _equals = Objects.equal(cntExState, _loopStart);
          if (_equals) {
            markLoop = true;
          }
          final Step step = this.getStepForJmpState(cntExState);
          boolean _notEquals = (!Objects.equal(step, null));
          if (_notEquals) {
            boolean _notEquals_1 = (!Objects.equal(step, previousStep));
            if (_notEquals_1) {
              List<Step> _steps = stepTrace.getSteps();
              _steps.add(step);
            }
            if (markLoop) {
              markLoop = false;
              stepTrace.setLoopStart(step);
            }
            previousStep = step;
          }
        }
      }
      Step _loopStart = stepTrace.getLoopStart();
      List<Step> _steps = stepTrace.getSteps();
      Step _last = IterableExtensions.<Step>last(_steps);
      boolean _equals = Objects.equal(_loopStart, _last);
      if (_equals) {
        List<Step> _steps_1 = stepTrace.getSteps();
        List<Step> _steps_2 = stepTrace.getSteps();
        int _size = _steps_2.size();
        int _minus = (_size - 1);
        _steps_1.remove(_minus);
      }
      _xblockexpression = stepTrace;
    }
    return _xblockexpression;
  }
  
  /**
   * @return associated {@link Step} or <code>null<code> if no step is associated or state is not linked to JMP state
   */
  private Step getStepForJmpState(final CntExState cntExState) {
    Step _xblockexpression = null;
    {
      EList<Annotation> _annotations = cntExState.getAnnotations();
      final Iterable<StateMappingAnnotation> stateAnnotations = Iterables.<StateMappingAnnotation>filter(_annotations, StateMappingAnnotation.class);
      int _size = IterableExtensions.size(stateAnnotations);
      boolean _lessEqualsThan = (_size <= 1);
      Preconditions.checkArgument(_lessEqualsThan);
      boolean _isEmpty = IterableExtensions.isEmpty(stateAnnotations);
      if (_isEmpty) {
        return null;
      }
      StateMappingAnnotation _head = IterableExtensions.<StateMappingAnnotation>head(stateAnnotations);
      final State state = _head.getState();
      EList<Annotation> _annotations_1 = state.getAnnotations();
      final Iterable<StateTypeMappingAnnotation> stateTypeAnnotation = Iterables.<StateTypeMappingAnnotation>filter(_annotations_1, StateTypeMappingAnnotation.class);
      int _size_1 = IterableExtensions.size(stateTypeAnnotation);
      boolean _lessEqualsThan_1 = (_size_1 <= 1);
      Preconditions.checkArgument(_lessEqualsThan_1);
      boolean _or = false;
      boolean _isEmpty_1 = IterableExtensions.isEmpty(stateTypeAnnotation);
      if (_isEmpty_1) {
        _or = true;
      } else {
        StateTypeMappingAnnotation _head_1 = IterableExtensions.<StateTypeMappingAnnotation>head(stateTypeAnnotation);
        StateType _stateType = _head_1.getStateType();
        boolean _notEquals = (!Objects.equal(_stateType, StateType.JMP));
        _or = _notEquals;
      }
      if (_or) {
        return null;
      }
      EList<Annotation> _annotations_2 = state.getAnnotations();
      final Iterable<StepMappingAnnotation> stepAnnotations = Iterables.<StepMappingAnnotation>filter(_annotations_2, StepMappingAnnotation.class);
      int _size_2 = IterableExtensions.size(stepAnnotations);
      boolean _lessEqualsThan_2 = (_size_2 <= 1);
      Preconditions.checkArgument(_lessEqualsThan_2);
      boolean _isEmpty_2 = IterableExtensions.isEmpty(stepAnnotations);
      if (_isEmpty_2) {
        return null;
      }
      StepMappingAnnotation _head_2 = IterableExtensions.<StepMappingAnnotation>head(stepAnnotations);
      _xblockexpression = _head_2.getStep();
    }
    return _xblockexpression;
  }
  
  private CharSequence printTemplateContent() {
    CharSequence _xblockexpression = null;
    {
      Specification _specification = this.getSpecification();
      Trace _trace = _specification.getTrace();
      final StepTrace stepTrace = this.trace2StepTrace(_trace);
      final HashMap<Step,Iterable<TemporalAnnotation>> step2TempAnnotations = this.createStep2TempAnnotationMap(stepTrace);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<h1>Error: ");
      CharSequence _title = this.getTitle();
      _builder.append(_title, "\t");
      _builder.append("</h1>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("<p>");
      _builder.newLine();
      _builder.append("\t");
      FormulaHolder _formulaHolder = this.getFormulaHolder();
      String _comment = _formulaHolder.getComment();
      _builder.append(_comment, "\t");
      _builder.append(":");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("<pre>");
      FormulaHolder _formulaHolder_1 = this.getFormulaHolder();
      FormulaType _formulaType = _formulaHolder_1.getFormulaType();
      _builder.append(_formulaType, "\t");
      _builder.append(" ");
      TADLFormulaRenderer _renderer = this.getRenderer();
      FormulaHolder _formulaHolder_2 = this.getFormulaHolder();
      Formula _formula = _formulaHolder_2.getFormula();
      String _evalFormula = _renderer.evalFormula(_formula);
      _builder.append(_evalFormula, "\t");
      _builder.append("</pre>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("</p>");
      _builder.newLine();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("<div>\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<h2>Trace:</h2>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<table class=\"trace\">");
      _builder.newLine();
      {
        List<Step> _steps = stepTrace.getSteps();
        for(final Step step : _steps) {
          _builder.append("\t");
          final UseCase useCase = UcmUtils.getUseCase(step);
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("<tr>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("<td><a href=\"../");
          String _id = useCase.getId();
          _builder.append(_id, "\t\t");
          _builder.append("/");
          String _id_1 = useCase.getId();
          _builder.append(_id_1, "\t\t");
          _builder.append(".html\">");
          String _id_2 = useCase.getId();
          _builder.append(_id_2, "\t\t");
          _builder.append("</a></td>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("<td class=\"tracecell\">");
          String _label = step.getLabel();
          _builder.append(_label, "\t\t");
          _builder.append("</td>");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("<td class=\"tracecell\">");
          Iterable<TemporalAnnotation> _get = step2TempAnnotations.get(step);
          CharSequence _printStep = this.printStep(step, _get);
          _builder.append(_printStep, "\t\t");
          _builder.newLineIfNotEmpty();
          {
            Step _loopStart = stepTrace.getLoopStart();
            boolean _equals = Objects.equal(step, _loopStart);
            if (_equals) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("<span class=\"loop\">&larr; loop starts here</span>");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("</td>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</tr>");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("</table>");
      _builder.newLine();
      _builder.append("</div>");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  @Extension
  private final FoamCommonAnnotationRenderer __foamCommonAnnotationRenderer = new FoamCommonAnnotationRenderer();
  
  public FoamCommonAnnotationRenderer get_foamCommonAnnotationRenderer() {
    return this.__foamCommonAnnotationRenderer;
  }
  
  private CharSequence printStep(final Step step, final Iterable<? extends Annotation> annotations) {
    StringConcatenation _builder = new StringConcatenation();
    String _text = step.getText();
    _builder.append(_text, "");
    _builder.newLineIfNotEmpty();
    {
      boolean _hasElements = false;
      for(final Annotation annotation : annotations) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append(" ", "");
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("<span class=\"annot\">");
        CharSequence _render = this.__foamCommonAnnotationRenderer.render(annotation);
        _builder.append(_render, "");
        _builder.append("</span>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private HashMap<Step,Iterable<TemporalAnnotation>> createStep2TempAnnotationMap(final StepTrace stepTrace) {
    HashMap<Step,Iterable<TemporalAnnotation>> _xblockexpression = null;
    {
      final HashMap<Step,Iterable<TemporalAnnotation>> result = new HashMap<Step, Iterable<TemporalAnnotation>>();
      List<Step> _steps = stepTrace.getSteps();
      for (final Step step : _steps) {
        {
          EList<Annotation> _annotations = step.getAnnotations();
          Iterable<TemporalAnnotation> _filter = Iterables.<TemporalAnnotation>filter(_annotations, TemporalAnnotation.class);
          final Function1<TemporalAnnotation,Boolean> _function = new Function1<TemporalAnnotation,Boolean>() {
            public Boolean apply(final TemporalAnnotation it) {
              Group _group = it.getGroup();
              Specification _specification = ErrorPage.this.getSpecification();
              Group _group_1 = Utils.getGroup(_specification);
              return Boolean.valueOf(Objects.equal(_group, _group_1));
            }
          };
          final Iterable<TemporalAnnotation> tempAnnotations = IterableExtensions.<TemporalAnnotation>filter(_filter, _function);
          result.put(step, tempAnnotations);
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_menu== null) ? 0 : _menu.hashCode());
    result = prime * result + ((_specification== null) ? 0 : _specification.hashCode());
    result = prime * result + ((_formulaHolder== null) ? 0 : _formulaHolder.hashCode());
    result = prime * result + ((_group== null) ? 0 : _group.hashCode());
    result = prime * result + ((_orderId== null) ? 0 : _orderId.hashCode());
    result = prime * result + ((_renderer== null) ? 0 : _renderer.hashCode());
    result = prime * result + ((__foamCommonAnnotationRenderer== null) ? 0 : __foamCommonAnnotationRenderer.hashCode());
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
    ErrorPage other = (ErrorPage) obj;
    if (_menu == null) {
      if (other._menu != null)
        return false;
    } else if (!_menu.equals(other._menu))
      return false;
    if (_specification == null) {
      if (other._specification != null)
        return false;
    } else if (!_specification.equals(other._specification))
      return false;
    if (_formulaHolder == null) {
      if (other._formulaHolder != null)
        return false;
    } else if (!_formulaHolder.equals(other._formulaHolder))
      return false;
    if (_group == null) {
      if (other._group != null)
        return false;
    } else if (!_group.equals(other._group))
      return false;
    if (_orderId == null) {
      if (other._orderId != null)
        return false;
    } else if (!_orderId.equals(other._orderId))
      return false;
    if (_renderer == null) {
      if (other._renderer != null)
        return false;
    } else if (!_renderer.equals(other._renderer))
      return false;
    if (__foamCommonAnnotationRenderer == null) {
      if (other.__foamCommonAnnotationRenderer != null)
        return false;
    } else if (!__foamCommonAnnotationRenderer.equals(other.__foamCommonAnnotationRenderer))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
