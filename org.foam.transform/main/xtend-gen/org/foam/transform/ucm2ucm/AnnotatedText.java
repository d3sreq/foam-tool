package org.foam.transform.ucm2ucm;

import java.util.List;
import org.foam.annotation.Annotation;

@SuppressWarnings("all")
public class AnnotatedText {
  private String _text;
  
  public String getText() {
    return this._text;
  }
  
  public void setText(final String text) {
    this._text = text;
  }
  
  private List<Annotation> _annotations;
  
  public List<Annotation> getAnnotations() {
    return this._annotations;
  }
  
  public void setAnnotations(final List<Annotation> annotations) {
    this._annotations = annotations;
  }
}
