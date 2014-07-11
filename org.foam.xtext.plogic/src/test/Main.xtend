package test

import org.foam.propositionallogic.PropositionallogicPackage
import org.eclipse.emf.ecore.EPackage
import org.foam.xtext.plogic.PropositionalLogicXtextStandaloneSetup
import org.foam.xtext.plogic.parser.antlr.PropositionalLogicXtextParser
import org.foam.propositionallogic.Formula

class Main {
	def static void main(String[] args) {
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl or LTL formula (propositional logic formula is parsed
		// without errors).
		//
		// Package should be probably registered in GenerateLtlXtext.mwe2 file
		// but wasn't able to figure out how to do it.
		if (!EPackage.Registry.INSTANCE.containsKey(PropositionallogicPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(PropositionallogicPackage.eNS_URI, PropositionallogicPackage.eINSTANCE)
		}
		
		// TODO - use guice annotations to inject parser instead ?
		val setup = new PropositionalLogicXtextStandaloneSetup
		val propLogicInjector = setup.createInjectorAndDoEMFRegistration
		val propLogicParser = propLogicInjector.getInstance(PropositionalLogicXtextParser)
		
		val result = propLogicParser.doParse("a & b")
		println(result.rootASTElement as Formula)
	}
	
}