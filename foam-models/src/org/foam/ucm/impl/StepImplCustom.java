package org.foam.ucm.impl;

import org.foam.ucm.impl.xtend.StepImplCustomXtend;

//mwe generator executed from maven needs *Custom class already present
//so this class is written in java and redirects to xtend implementation
public class StepImplCustom extends StepImpl {
	
	@Override
	public String getLabel() {
		return StepImplCustomXtend.getLabel(this);
	}
	
}
