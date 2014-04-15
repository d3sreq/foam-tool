package org.foam.ucm.impl.xtend;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.foam.ucm.Scenario;
import org.foam.ucm.Step;

@SuppressWarnings("all")
public class StepImplCustomXtend {
  public static String getLabel(final Step step) {
    String _xblockexpression = null;
    {
      EObject _eContainer = step.eContainer();
      final Scenario parent = ((Scenario) _eContainer);
      EList<Step> _steps = parent.getSteps();
      int _indexOf = _steps.indexOf(step);
      final int num = (_indexOf + 1);
      String _label = parent.getLabel();
      _xblockexpression = (_label + Integer.valueOf(num));
    }
    return _xblockexpression;
  }
}
