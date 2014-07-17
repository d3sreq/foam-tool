package org.foam.cli.tools.report.pages;

import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.foam.ucm.Step;

@SuppressWarnings("all")
public class StepTrace {
  private final List<Step> _steps = CollectionLiterals.<Step>newArrayList();
  
  public List<Step> getSteps() {
    return this._steps;
  }
  
  private Step _loopStart = null;
  
  public Step getLoopStart() {
    return this._loopStart;
  }
  
  public void setLoopStart(final Step loopStart) {
    this._loopStart = loopStart;
  }
}
