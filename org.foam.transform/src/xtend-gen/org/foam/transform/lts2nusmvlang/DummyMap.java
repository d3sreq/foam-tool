package org.foam.transform.lts2nusmvlang;

import java.util.HashMap;

@SuppressWarnings("all")
public class DummyMap<K extends Object> extends HashMap<K,K> {
  public K get(final Object key) {
    return ((K) key);
  }
}
