package org.foam.ucm.impl.xtend;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;

@SuppressWarnings("all")
public class ScenarioImplCustomXtend {
  public static String getLabel(final Scenario scenario) {
    String _xblockexpression = null;
    {
      final EObject scenarioParent = scenario.eContainer();
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (scenarioParent instanceof ScenarioHolder) {
          _matched=true;
          FeatureMap _branches = ((ScenarioHolder)scenarioParent).getBranches();
          final Function1<FeatureMap.Entry, Object> _function = new Function1<FeatureMap.Entry, Object>() {
            public Object apply(final FeatureMap.Entry it) {
              return it.getValue();
            }
          };
          final List<Object> scenarios = ListExtensions.<FeatureMap.Entry, Object>map(_branches, _function);
          int _indexOf = scenarios.indexOf(scenario);
          final String letter = ScenarioImplCustomXtend.getLetter(_indexOf);
          EObject _eContainer = ((ScenarioHolder)scenarioParent).eContainer();
          final Step step = ((Map.Entry<Step, ScenarioHolder>) _eContainer).getKey();
          StringConcatenation _builder = new StringConcatenation();
          String _label = step.getLabel();
          _builder.append(_label, "");
          _builder.append(letter, "");
          return _builder.toString();
        }
      }
      if (!_matched) {
        _switchResult = "";
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  private static String getLetter(final int index) {
    char _charAt = "a".charAt(0);
    int _plus = (_charAt + index);
    Character _valueOf = Character.valueOf(((char) _plus));
    return _valueOf.toString();
  }
}
