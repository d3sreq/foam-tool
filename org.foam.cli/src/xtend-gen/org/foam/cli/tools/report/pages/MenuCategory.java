package org.foam.cli.tools.report.pages;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.cli.tools.report.pages.MenuItem;
import org.foam.transform.utils.sort.NaturalOrderComparator;

/**
 * Represents grouping of the menu items.
 * 
 * @param name 		text above links in menu or <code>null</code> if no text should be present
 * @param menuItems links in menu
 */
@Data
@SuppressWarnings("all")
public class MenuCategory {
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  private final List<MenuItem> _menuItems = Collections.<MenuItem>unmodifiableList(Lists.<MenuItem>newArrayList());
  
  public List<MenuItem> getMenuItems() {
    return this._menuItems;
  }
  
  private final NaturalOrderComparator _naturalOrderComparator = new NaturalOrderComparator();
  
  public NaturalOrderComparator getNaturalOrderComparator() {
    return this._naturalOrderComparator;
  }
  
  public void sort() {
    List<MenuItem> _menuItems = this.getMenuItems();
    final Comparator<MenuItem> _function = new Comparator<MenuItem>() {
      public int compare(final MenuItem a, final MenuItem b) {
        NaturalOrderComparator _naturalOrderComparator = MenuCategory.this.getNaturalOrderComparator();
        CharSequence _label = a.getLabel();
        String _string = _label.toString();
        CharSequence _label_1 = b.getLabel();
        String _string_1 = _label_1.toString();
        return _naturalOrderComparator.compare(_string, _string_1);
      }
    };
    ListExtensions.<MenuItem>sortInplace(_menuItems, _function);
  }
  
  public MenuCategory(final String name) {
    super();
    this._name = name;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
    result = prime * result + ((this._menuItems== null) ? 0 : this._menuItems.hashCode());
    result = prime * result + ((this._naturalOrderComparator== null) ? 0 : this._naturalOrderComparator.hashCode());
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
    MenuCategory other = (MenuCategory) obj;
    if (this._name == null) {
      if (other._name != null)
        return false;
    } else if (!this._name.equals(other._name))
      return false;
    if (this._menuItems == null) {
      if (other._menuItems != null)
        return false;
    } else if (!this._menuItems.equals(other._menuItems))
      return false;
    if (this._naturalOrderComparator == null) {
      if (other._naturalOrderComparator != null)
        return false;
    } else if (!this._naturalOrderComparator.equals(other._naturalOrderComparator))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
