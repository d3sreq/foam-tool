package org.foam.cli.tools.report.pages;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.cli.tools.report.pages.Menu;
import org.foam.cli.tools.report.pages.Page;
import org.foam.cli.tools.report.pages.PageTemplate;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.Template;
import org.foam.transform.lts2nusmvlang.TADLFormulaRenderer;

@Data
@SuppressWarnings("all")
public class TadlTemplatePage implements Page {
  private final Menu _menu;
  
  public Menu getMenu() {
    return this._menu;
  }
  
  private final Template _template;
  
  public Template getTemplate() {
    return this._template;
  }
  
  private final TADLFormulaRenderer _renderer = new TADLFormulaRenderer();
  
  public TADLFormulaRenderer getRenderer() {
    return this._renderer;
  }
  
  public String getId() {
    Template _template = this.getTemplate();
    EList<VariableDefinition> _variableDefinitions = _template.getVariableDefinitions();
    final Function1<VariableDefinition, String> _function = new Function1<VariableDefinition, String>() {
      public String apply(final VariableDefinition it) {
        return it.getName();
      }
    };
    List<String> _map = ListExtensions.<VariableDefinition, String>map(_variableDefinitions, _function);
    return IterableExtensions.join(_map, "-");
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
  
  private CharSequence printTemplateContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<h1>TADL: ");
    String _id = this.getId();
    _builder.append(_id, "\t");
    _builder.append("</h1>");
    _builder.newLineIfNotEmpty();
    {
      Template _template = this.getTemplate();
      EList<FormulaHolder> _formulaHolders = _template.getFormulaHolders();
      for(final FormulaHolder formulaHolder : _formulaHolders) {
        _builder.append("<p>");
        _builder.newLine();
        String _comment = formulaHolder.getComment();
        _builder.append(_comment, "");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("<pre>");
        FormulaType _formulaType = formulaHolder.getFormulaType();
        _builder.append(_formulaType, "");
        _builder.append(" ");
        TADLFormulaRenderer _renderer = this.getRenderer();
        Formula _formula = formulaHolder.getFormula();
        String _evalFormula = _renderer.evalFormula(_formula);
        _builder.append(_evalFormula, "");
        _builder.append("</pre>");
        _builder.newLineIfNotEmpty();
        _builder.append("</p>");
        _builder.newLine();
      }
    }
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("<div style=\"padding-top: 20px\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<h2>Temporal Operators Explained</h2>");
    _builder.newLine();
    {
      TADLFormulaRenderer _renderer_1 = this.getRenderer();
      Template _template_1 = this.getTemplate();
      EList<FormulaHolder> _formulaHolders_1 = _template_1.getFormulaHolders();
      final Function1<FormulaHolder, Formula> _function = new Function1<FormulaHolder, Formula>() {
        public Formula apply(final FormulaHolder it) {
          return it.getFormula();
        }
      };
      List<Formula> _map = ListExtensions.<FormulaHolder, Formula>map(_formulaHolders_1, _function);
      Iterable<String> _collectTemporalOperatorDescriptions = _renderer_1.collectTemporalOperatorDescriptions(_map);
      for(final String op : _collectTemporalOperatorDescriptions) {
        _builder.append("\t");
        _builder.append("<pre>");
        _builder.append(op, "\t");
        _builder.append("</pre>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  public TadlTemplatePage(final Menu menu, final Template template) {
    super();
    this._menu = menu;
    this._template = template;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._menu== null) ? 0 : this._menu.hashCode());
    result = prime * result + ((this._template== null) ? 0 : this._template.hashCode());
    result = prime * result + ((this._renderer== null) ? 0 : this._renderer.hashCode());
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
    TadlTemplatePage other = (TadlTemplatePage) obj;
    if (this._menu == null) {
      if (other._menu != null)
        return false;
    } else if (!this._menu.equals(other._menu))
      return false;
    if (this._template == null) {
      if (other._template != null)
        return false;
    } else if (!this._template.equals(other._template))
      return false;
    if (this._renderer == null) {
      if (other._renderer != null)
        return false;
    } else if (!this._renderer.equals(other._renderer))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
