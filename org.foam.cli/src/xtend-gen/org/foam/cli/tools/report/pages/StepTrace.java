package org.foam.cli.tools.report.pages;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.foam.ucm.Step;

@SuppressWarnings("all")
public class StepTrace {
  private final List<Step> _steps = Collections.<Step>unmodifiableList(Lists.<Step>newArrayList());
  
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
