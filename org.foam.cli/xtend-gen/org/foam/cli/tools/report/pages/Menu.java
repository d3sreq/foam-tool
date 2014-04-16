package org.foam.cli.tools.report.pages;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.cli.tools.report.pages.MenuCategory;
import org.foam.cli.tools.report.pages.MenuItem;
import org.foam.cli.tools.report.pages.Page;

/**
 * Represents menu.
 */
@Data
@SuppressWarnings("all")
public class Menu {
  private final List<MenuCategory> _categories = new ArrayList<MenuCategory>();
  
  public List<MenuCategory> getCategories() {
    return this._categories;
  }
  
  public CharSequence printMenu(final Page active) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<MenuCategory> _categories = this.getCategories();
      for(final MenuCategory category : _categories) {
        {
          List<MenuItem> _menuItems = category.getMenuItems();
          boolean _isEmpty = _menuItems.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            {
              String _name = category.getName();
              boolean _notEquals = (!Objects.equal(_name, null));
              if (_notEquals) {
                _builder.append("<li class=\"nav-header\">");
                String _name_1 = category.getName();
                _builder.append(_name_1, "");
                _builder.append("</li>");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              List<MenuItem> _menuItems_1 = category.getMenuItems();
              for(final MenuItem menuItem : _menuItems_1) {
                _builder.append("<li");
                {
                  Page _page = menuItem.getPage();
                  boolean _equals = Objects.equal(_page, active);
                  if (_equals) {
                    _builder.append(" class=\"active\"");
                  }
                }
                _builder.append("><a href=\"");
                CharSequence _relativePath = menuItem.getRelativePath();
                _builder.append(_relativePath, "");
                _builder.append("\">");
                CharSequence _label = menuItem.getLabel();
                _builder.append(_label, "");
                _builder.append("</a></li>");
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public Menu() {
    super();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_categories== null) ? 0 : _categories.hashCode());
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
    Menu other = (Menu) obj;
    if (_categories == null) {
      if (other._categories != null)
        return false;
    } else if (!_categories.equals(other._categories))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
