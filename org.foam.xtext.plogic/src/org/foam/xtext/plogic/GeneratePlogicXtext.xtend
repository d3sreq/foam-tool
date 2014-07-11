package org.foam.xtext.plogic

import java.io.File
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe.utils.FileCopy
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.ecore.EMFGeneratorFragment
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
import org.eclipse.xtext.generator.serializer.SerializerFragment

class GeneratePlogicXtext {
	def static void main(String[] args) {
		
		val grammarURI = "classpath:/org/foam/xtext/plogic/PropositionalLogicXtext.xtext"
		val projectName = "org.foam.xtext.plogic"
		val runtimeProject = '''../«projectName»'''
		
	    new File("src/org/foam/xtext/plogic/PropositionalLogicXtextRuntimeModule.java").delete
	    new File("src/org/foam/xtext/plogic/PropositionalLogicXtextStandaloneSetup.java").delete

		new StandaloneSetup => [
			scanClassPath  = true
			platformUri = '''«runtimeProject»/..'''
			
			addRegisterGeneratedEPackage = "org.foam.propositionallogic.PropositionallogicPackage"
			addRegisterEcoreFile = "platform:/resource/org.foam.models/models/propositionallogic.ecore"
			addRegisterGenModelFile = "platform:/resource/org.foam.models/models/propositionallogic.genmodel"
		]
		
		new DirectoryCleaner => [
			directory = '''«runtimeProject»/src-gen'''
			invoke = null
		]
			
		new DirectoryCleaner => [
	    	directory = '''«runtimeProject»/model/generated'''
			invoke = null
	    ]

		// copy dummy MANIFEST.MF which doesn't import any dependencies 
		new FileCopy => [
			sourceFile = '''«runtimeProject»/META-INF/_MANIFEST.MF'''
			targetFile = '''«runtimeProject»/META-INF/MANIFEST.MF'''
			invoke = null
		]

		new Generator => [
			pathRtProject = runtimeProject
			projectNameRt = projectName
			encoding = "UTF-8"
			
			addLanguage = new LanguageConfig() => [
				uri = grammarURI
	
				// Java API to access grammar elements (required by several other fragments)
				addFragment = new GrammarAccessFragment
								
				// generates Java API for the generated EPackages
				addFragment = new EMFGeneratorFragment
	
				// the Antlr parser
				addFragment = new XtextAntlrGeneratorFragment
				
				// serializer 2.0
				addFragment = new SerializerFragment => [
	    			generateStub = false
	    		]
			]
			
			preInvoke; invoke(null); postInvoke
		]

		
		// copy dummy MANIFEST.MF over generated one, this step is not needed
		// but prevents error in eclipse 
		new FileCopy => [
			sourceFile = '''«runtimeProject»/META-INF/_MANIFEST.MF'''
			targetFile = '''«runtimeProject»/META-INF/MANIFEST.MF'''
			invoke = null
		]
		
	    new File("plugin.xml").delete

	}
	
}