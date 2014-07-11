package org.foam.transform.ucm2ucm;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.foam.transform.ucm2ucm.BranchingType;
import org.foam.transform.ucm2ucm.LabeledAnnotatedText;

@Data
@SuppressWarnings("all")
public class BranchingLabeledAnnotatedText {
  private final BranchingType _branchingType;
  
  public BranchingType getBranchingType() {
    return this._branchingType;
  }
  
  private final LabeledAnnotatedText _labeledAnnotatedText;
  
  public LabeledAnnotatedText getLabeledAnnotatedText() {
    return this._labeledAnnotatedText;
  }
  
  public BranchingLabeledAnnotatedText(final BranchingType branchingType, final LabeledAnnotatedText labeledAnnotatedText) {
    super();
    this._branchingType = branchingType;
    this._labeledAnnotatedText = labeledAnnotatedText;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_branchingType== null) ? 0 : _branchingType.hashCode());
    result = prime * result + ((_labeledAnnotatedText== null) ? 0 : _labeledAnnotatedText.hashCode());
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
    BranchingLabeledAnnotatedText other = (BranchingLabeledAnnotatedText) obj;
    if (_branchingType == null) {
      if (other._branchingType != null)
        return false;
    } else if (!_branchingType.equals(other._branchingType))
      return false;
    if (_labeledAnnotatedText == null) {
      if (other._labeledAnnotatedText != null)
        return false;
    } else if (!_labeledAnnotatedText.equals(other._labeledAnnotatedText))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
