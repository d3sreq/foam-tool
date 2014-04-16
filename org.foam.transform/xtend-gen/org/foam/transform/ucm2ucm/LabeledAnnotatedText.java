package org.foam.transform.ucm2ucm;

import org.foam.transform.ucm2ucm.AnnotatedText;

@SuppressWarnings("all")
public class LabeledAnnotatedText {
  private String _label;
  
  public String getLabel() {
    return this._label;
  }
  
  public void setLabel(final String label) {
    this._label = label;
  }
  
  private AnnotatedText _annotatedText;
  
  public AnnotatedText getAnnotatedText() {
    return this._annotatedText;
  }
  
  public void setAnnotatedText(final AnnotatedText annotatedText) {
    this._annotatedText = annotatedText;
  }
}
