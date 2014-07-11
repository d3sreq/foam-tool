package org.foam.transform.ucm2ucm;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class IdAndName {
  private final String _id;
  
  public String getId() {
    return this._id;
  }
  
  private final String _name;
  
  public String getName() {
    return this._name;
  }
  
  public IdAndName(final String id, final String name) {
    super();
    this._id = id;
    this._name = name;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_id== null) ? 0 : _id.hashCode());
    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
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
    IdAndName other = (IdAndName) obj;
    if (_id == null) {
      if (other._id != null)
        return false;
    } else if (!_id.equals(other._id))
      return false;
    if (_name == null) {
      if (other._name != null)
        return false;
    } else if (!_name.equals(other._name))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
