/*
* generated by Xtext
*/
package org.foam.xtext.plogic.ui.labeling;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
public class PropositionalLogicXtextLabelProvider extends org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider {

	@Inject
	public PropositionalLogicXtextLabelProvider(org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:
	
//	String text(Greeting ele) {
//		return "A greeting to " + ele.getName();
//	}
//
//	String image(Greeting ele) {
//		return "Greeting.gif";
//	}
}
