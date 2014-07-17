package org.foam.cli.tools.report.pages;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.cli.tools.report.pages.Page;

/**
 * Represents single menu item.
 * 
 * @param label 		text used on the link
 * @param relativePath	path to the referenced html page
 */
@Data
@SuppressWarnings("all")
public class MenuItem {
  private final CharSequence _label;
  
  public CharSequence getLabel() {
    return this._label;
  }
  
  private final CharSequence _relativePath;
  
  public CharSequence getRelativePath() {
    return this._relativePath;
  }
  
  private final Page _page;
  
  public Page getPage() {
    return this._page;
  }
  
  public MenuItem(final CharSequence label, final CharSequence relativePath, final Page page) {
    super();
    this._label = label;
    this._relativePath = relativePath;
    this._page = page;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._label== null) ? 0 : this._label.hashCode());
    result = prime * result + ((this._relativePath== null) ? 0 : this._relativePath.hashCode());
    result = prime * result + ((this._page== null) ? 0 : this._page.hashCode());
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
    MenuItem other = (MenuItem) obj;
    if (this._label == null) {
      if (other._label != null)
        return false;
    } else if (!this._label.equals(other._label))
      return false;
    if (this._relativePath == null) {
      if (other._relativePath != null)
        return false;
    } else if (!this._relativePath.equals(other._relativePath))
      return false;
    if (this._page == null) {
      if (other._page != null)
        return false;
    } else if (!this._page.equals(other._page))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
