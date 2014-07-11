package build

import java.io.File
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe.utils.FileCopy
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
import org.eclipse.xtext.generator.serializer.SerializerFragment

class GenerateCtl {
	def static void main(String[] args) {
		
		val grammarURI = "classpath:/org/foam/xtext/ctl/CtlXtext.xtext"
		val projectName = "org.foam.xtext.ctl"
		val runtimeProject = '''../«projectName»'''
		
	    new File("src/org/foam/xtext/ctl/CtlLogicXtextRuntimeModule.java").delete
	    new File("src/org/foam/xtext/ctl/CtlLogicXtextStandaloneSetup.java").delete

		new StandaloneSetup => [
			scanClassPath  = true
			platformUri = '''«runtimeProject»/..'''
			
			addRegisterGeneratedEPackage = "org.foam.ctl.CtlPackage"
//			addRegisterEcoreFile = "platform:/resource/org.foam.models/models/ctl.ecore"
			addRegisterGenModelFile = "platform:/resource/org.foam.models/models/ctl.genmodel"
//			addRegisterGenModelFile = "platform:/resource/org.foam.models/models/propositionallogic.genmodel"
			addRegisterGenModelFile = "platform:/resource/org.foam.xtext.plogic/model/generated/PropositionalLogicXtext.genmodel"
		]
		
		new DirectoryCleaner => [
			directory = '''«runtimeProject»/src-gen'''
			invoke = null
		]
		
		new File("src-gen").mkdir
			
		new DirectoryCleaner => [
	    	directory = '''«runtimeProject»/model/generated'''
			invoke = null
	    ]
	    
	    new DirectoryCleaner => [
	    	directory = '''«runtimeProject»/src/org/foam/xtext/ctl'''
	    	addExclude = "CtlXtext.xtext"
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
//				addFragment = new EMFGeneratorFragment
	
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
	    new File("plugin.xml_gen").delete

	}
	
}