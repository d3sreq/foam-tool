package org.foam.transform.lts2dot;

import java.util.HashMap;
import org.foam.dot.Graph;
import org.foam.ucm.UseCase;

@SuppressWarnings("all")
public class DummyUseCaseMap extends HashMap<UseCase, Graph> {
  private final Graph graph;
  
  public DummyUseCaseMap(final Graph graph) {
    this.graph = graph;
  }
  
  public Graph get(final Object key) {
    return this.graph;
  }
}
