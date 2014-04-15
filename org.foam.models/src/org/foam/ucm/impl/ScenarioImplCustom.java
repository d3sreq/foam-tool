package org.foam.ucm.impl;

import org.eclipse.emf.ecore.EObject;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.impl.xtend.ScenarioImplCustomXtend;

// mwe generator executed from maven needs *Custom class already present
// so this class is written in java and redirects to xtend implementation  
public class ScenarioImplCustom extends ScenarioImpl {
	
	@Override
	public String getLabel() {
		return ScenarioImplCustomXtend.getLabel(this);
	}
	
	@Override
	public String getText() {
		// overridden becouse main scenario has no "text" associated but
		// EMF constraint is defined so that "text" shouldn't be null.
		EObject scenarioParent = this.eContainer();
		if (scenarioParent instanceof ScenarioHolder) {
			return super.getText();
		} else {
			return "";
		}
	}
	
}
