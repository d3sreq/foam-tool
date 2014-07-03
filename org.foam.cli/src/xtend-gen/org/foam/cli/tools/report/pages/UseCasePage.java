package org.foam.cli.tools.report.pages;

import com.google.common.base.Objects;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
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
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UcmPackage;
import org.foam.ucm.UseCase;

@Data
@SuppressWarnings("all")
public class UseCasePage implements Page {
  @Extension
  private final FoamCommonAnnotationRenderer __foamCommonAnnotationRenderer = new FoamCommonAnnotationRenderer();
  
  public FoamCommonAnnotationRenderer get_foamCommonAnnotationRenderer() {
    return this.__foamCommonAnnotationRenderer;
  }
  
  private final UseCase _useCase;
  
  public UseCase getUseCase() {
    return this._useCase;
  }
  
  private final Menu _menu;
  
  public Menu getMenu() {
    return this._menu;
  }
  
  private final String _useCaseImageLocation;
  
  public String getUseCaseImageLocation() {
    return this._useCaseImageLocation;
  }
  
  public String getId() {
    UseCase _useCase = this.getUseCase();
    return _useCase.getId();
  }
  
  public CharSequence content() {
    CharSequence _xblockexpression = null;
    {
      UseCase _useCase = this.getUseCase();
      final CharSequence css = this.printBranchCss(_useCase);
      Menu _menu = this.getMenu();
      final CharSequence printedMenu = _menu.printMenu(this);
      UseCase _useCase_1 = this.getUseCase();
      final CharSequence useCaseContent = this.printUseCaseContent(_useCase_1);
      PageTemplate _pageTemplate = new PageTemplate();
      _xblockexpression = _pageTemplate.printPage(css, printedMenu, useCaseContent);
    }
    return _xblockexpression;
  }
  
  private CharSequence printUseCaseContent(final UseCase useCase) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<h1>");
    String _id = useCase.getId();
    _builder.append(_id, "\t");
    _builder.append(": ");
    String _name = useCase.getName();
    _builder.append(_name, "\t");
    _builder.append("</h1>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      boolean _or = false;
      boolean _isPrimary = useCase.isPrimary();
      boolean _not = (!_isPrimary);
      if (_not) {
        _or = true;
      } else {
        EList<UseCase> _preceeded = useCase.getPreceeded();
        boolean _isEmpty = _preceeded.isEmpty();
        boolean _not_1 = (!_isEmpty);
        _or = _not_1;
      }
      if (_or) {
        _builder.append("\t");
        _builder.append("<div class=\"usecase-header-block\">");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        {
          boolean _isPrimary_1 = useCase.isPrimary();
          boolean _not_2 = (!_isPrimary_1);
          if (_not_2) {
            _builder.append("primary: false<br>");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          EList<UseCase> _preceeded_1 = useCase.getPreceeded();
          boolean _isEmpty_1 = _preceeded_1.isEmpty();
          boolean _not_3 = (!_isEmpty_1);
          if (_not_3) {
            _builder.append("preceeded: ");
            EList<UseCase> _preceeded_2 = useCase.getPreceeded();
            String _preparePreceededList = this.preparePreceededList(_preceeded_2);
            _builder.append(_preparePreceededList, "\t\t");
            _builder.append("<br>");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</div>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<ul class=\"scenario main\">");
    _builder.newLine();
    _builder.append("\t\t");
    Scenario _mainScenario = useCase.getMainScenario();
    CharSequence _printScenario = this.printScenario(_mainScenario);
    _builder.append(_printScenario, "\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</ul>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EMap<Step, ScenarioHolder> _branches = useCase.getBranches();
      for(final Map.Entry<Step, ScenarioHolder> branch : _branches) {
        {
          ScenarioHolder _value = branch.getValue();
          FeatureMap _branches_1 = _value.getBranches();
          for(final FeatureMap.Entry entry : _branches_1) {
            _builder.append("\t");
            Object _value_1 = entry.getValue();
            final Scenario scenario = ((Scenario) _value_1);
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<b>");
            EStructuralFeature _eStructuralFeature = entry.getEStructuralFeature();
            CharSequence _convertStructuralFeature = this.convertStructuralFeature(_eStructuralFeature);
            _builder.append(_convertStructuralFeature, "\t");
            _builder.append("</b>: ");
            String _label = scenario.getLabel();
            _builder.append(_label, "\t");
            _builder.append(". ");
            String _text = scenario.getText();
            _builder.append(_text, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("<ul class=\"scenario branch");
            String _label_1 = scenario.getLabel();
            _builder.append(_label_1, "\t");
            _builder.append("\">");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            CharSequence _printScenario_1 = this.printScenario(scenario);
            _builder.append(_printScenario_1, "\t\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("</ul>");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("<object data=\"");
    String _useCaseImageLocation = this.getUseCaseImageLocation();
    _builder.append(_useCaseImageLocation, "\t");
    _builder.append("\" type=\"image/svg+xml\"></object>");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  private String preparePreceededList(final List<UseCase> preceeded) {
    final Function1<UseCase, String> _function = new Function1<UseCase, String>() {
      public String apply(final UseCase it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<a href=\"../");
        String _id = it.getId();
        _builder.append(_id, "");
        _builder.append("/");
        String _id_1 = it.getId();
        _builder.append(_id_1, "");
        _builder.append(".html\">");
        String _id_2 = it.getId();
        _builder.append(_id_2, "");
        _builder.append(" ");
        String _name = it.getName();
        _builder.append(_name, "");
        _builder.append("</a>");
        return _builder.toString();
      }
    };
    List<String> _map = ListExtensions.<UseCase, String>map(preceeded, _function);
    return IterableExtensions.join(_map, ", ");
  }
  
  private CharSequence convertStructuralFeature(final EStructuralFeature structuralFeature) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _equals = Objects.equal(structuralFeature, UcmPackage.Literals.SCENARIO_HOLDER__EXTENSIONS);
      if (_equals) {
        _builder.append("Extension");
        _builder.newLine();
      } else {
        boolean _equals_1 = Objects.equal(structuralFeature, UcmPackage.Literals.SCENARIO_HOLDER__VARIATIONS);
        if (_equals_1) {
          _builder.append("Variation");
          _builder.newLine();
        } else {
          _builder.append("Unknown");
          _builder.newLine();
        }
      }
    }
    return _builder;
  }
  
  private CharSequence printScenario(final Scenario scenario) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Step> _steps = scenario.getSteps();
      for(final Step step : _steps) {
        _builder.append("<li>");
        CharSequence _printStep = this.printStep(step);
        _builder.append(_printStep, "");
        _builder.append("</li>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  private CharSequence printStep(final Step step) {
    StringConcatenation _builder = new StringConcatenation();
    String _text = step.getText();
    _builder.append(_text, "");
    _builder.newLineIfNotEmpty();
    {
      EList<Annotation> _annotations = step.getAnnotations();
      boolean _hasElements = false;
      for(final Annotation annotation : _annotations) {
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
  
  private CharSequence printBranchCss(final UseCase useCase) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EMap<Step, ScenarioHolder> _branches = useCase.getBranches();
      for(final Map.Entry<Step, ScenarioHolder> branch : _branches) {
        {
          ScenarioHolder _value = branch.getValue();
          FeatureMap _branches_1 = _value.getBranches();
          for(final FeatureMap.Entry entry : _branches_1) {
            Object _value_1 = entry.getValue();
            final Scenario scenario = ((Scenario) _value_1);
            _builder.newLineIfNotEmpty();
            _builder.append(".branch");
            String _label = scenario.getLabel();
            _builder.append(_label, "");
            _builder.append(" li:before { content: \'");
            String _label_1 = scenario.getLabel();
            _builder.append(_label_1, "");
            _builder.append("\' counter(list1) \'.\' }");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder;
  }
  
  public UseCasePage(final UseCase useCase, final Menu menu, final String useCaseImageLocation) {
    super();
    this._useCase = useCase;
    this._menu = menu;
    this._useCaseImageLocation = useCaseImageLocation;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((__foamCommonAnnotationRenderer== null) ? 0 : __foamCommonAnnotationRenderer.hashCode());
    result = prime * result + ((_useCase== null) ? 0 : _useCase.hashCode());
    result = prime * result + ((_menu== null) ? 0 : _menu.hashCode());
    result = prime * result + ((_useCaseImageLocation== null) ? 0 : _useCaseImageLocation.hashCode());
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
    UseCasePage other = (UseCasePage) obj;
    if (__foamCommonAnnotationRenderer == null) {
      if (other.__foamCommonAnnotationRenderer != null)
        return false;
    } else if (!__foamCommonAnnotationRenderer.equals(other.__foamCommonAnnotationRenderer))
      return false;
    if (_useCase == null) {
      if (other._useCase != null)
        return false;
    } else if (!_useCase.equals(other._useCase))
      return false;
    if (_menu == null) {
      if (other._menu != null)
        return false;
    } else if (!_menu.equals(other._menu))
      return false;
    if (_useCaseImageLocation == null) {
      if (other._useCaseImageLocation != null)
        return false;
    } else if (!_useCaseImageLocation.equals(other._useCaseImageLocation))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
