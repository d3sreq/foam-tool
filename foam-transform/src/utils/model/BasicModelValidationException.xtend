package utils.model

import java.lang.RuntimeException
import org.eclipse.emf.common.util.Diagnostic

@Data
class BasicModelValidationException extends RuntimeException {

	val Diagnostic diagnostic
	
	new(Diagnostic diagnostic) {
		_diagnostic = diagnostic
	}
	
	override getMessage() {
		diagnostic.children.map[it.message].join("\n")
	}
	
}