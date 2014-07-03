package org.foam.transform.utils.model;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

@SuppressWarnings("all")
public class MappingExtensions {
  /**
   * Emulates Multimap.put method.
   */
  public static <T extends Object, V extends Object> boolean putToMultimap(final EMap<T, EList<V>> multimap, final T key, final V value) {
    boolean _xblockexpression = false;
    {
      boolean _contains = multimap.contains(key);
      boolean _not = (!_contains);
      if (_not) {
        BasicEList<V> _basicEList = new BasicEList<V>();
        multimap.put(key, _basicEList);
      }
      EList<V> _get = multimap.get(key);
      _xblockexpression = _get.add(value);
    }
    return _xblockexpression;
  }
}
