/*
* generated by Xtext
*/
package ltllang2ltl.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

public class AbstractLtlXtextJavaValidator extends propositionallogiclang2propositionallogic.validation.PropositionalLogicXtextJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(EPackage.Registry.INSTANCE.getEPackage("propositionallogic"));
	    result.add(EPackage.Registry.INSTANCE.getEPackage("ltl"));
		return result;
	}

}