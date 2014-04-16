package org.foam.cli.tools.report.pages;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.cli.tools.report.pages.Menu;
import org.foam.cli.tools.report.pages.Page;
import org.foam.cli.tools.report.pages.PageTemplate;

@Data
@SuppressWarnings("all")
public class OverviewPage implements Page {
  private final Menu _menu;
  
  public Menu getMenu() {
    return this._menu;
  }
  
  private final String _overviewImageLocation;
  
  public String getOverviewImageLocation() {
    return this._overviewImageLocation;
  }
  
  private CharSequence getContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<div>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<h1>Overview</h1>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<object data=\"");
    String _overviewImageLocation = this.getOverviewImageLocation();
    _builder.append(_overviewImageLocation, "\t");
    _builder.append("\" type=\"image/svg+xml\"></object>\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("</div>");
    _builder.newLine();
    return _builder;
  }
  
  private final String _css = "";
  
  public String getCss() {
    return this._css;
  }
  
  public CharSequence content() {
    CharSequence _xblockexpression = null;
    {
      Menu _menu = this.getMenu();
      final CharSequence printedMenu = _menu.printMenu(this);
      PageTemplate _pageTemplate = new PageTemplate();
      String _css = this.getCss();
      CharSequence _content = this.getContent();
      _xblockexpression = _pageTemplate.printPage(_css, printedMenu, _content);
    }
    return _xblockexpression;
  }
  
  public String getId() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("overview");
    return _builder.toString();
  }
  
  public OverviewPage(final Menu menu, final String overviewImageLocation) {
    super();
    this._menu = menu;
    this._overviewImageLocation = overviewImageLocation;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_menu== null) ? 0 : _menu.hashCode());
    result = prime * result + ((_overviewImageLocation== null) ? 0 : _overviewImageLocation.hashCode());
    result = prime * result + ((_css== null) ? 0 : _css.hashCode());
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
    OverviewPage other = (OverviewPage) obj;
    if (_menu == null) {
      if (other._menu != null)
        return false;
    } else if (!_menu.equals(other._menu))
      return false;
    if (_overviewImageLocation == null) {
      if (other._overviewImageLocation != null)
        return false;
    } else if (!_overviewImageLocation.equals(other._overviewImageLocation))
      return false;
    if (_css == null) {
      if (other._css != null)
        return false;
    } else if (!_css.equals(other._css))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
