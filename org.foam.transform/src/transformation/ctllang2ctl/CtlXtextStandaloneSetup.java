
package transformation.ctllang2ctl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CtlXtextStandaloneSetup extends CtlXtextStandaloneSetupGenerated{

	public static void doSetup() {
		new CtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

