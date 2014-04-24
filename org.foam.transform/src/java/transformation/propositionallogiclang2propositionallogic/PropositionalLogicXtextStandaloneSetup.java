
package transformation.propositionallogiclang2propositionallogic;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PropositionalLogicXtextStandaloneSetup extends PropositionalLogicXtextStandaloneSetupGenerated{

	public static void doSetup() {
		new PropositionalLogicXtextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

