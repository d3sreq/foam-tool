/*
* generated by Xtext
*/
package org.foam.xtext.ltl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class LtlXtextStandaloneSetup extends LtlXtextStandaloneSetupGenerated{

	public static void doSetup() {
		new LtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

