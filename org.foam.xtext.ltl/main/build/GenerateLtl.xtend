import java.io.File
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe.utils.FileCopy
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.generator.Generator
import org.eclipse.xtext.generator.LanguageConfig
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
import org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
import org.eclipse.xtext.generator.serializer.SerializerFragment

class GenerateLtl {
	def static void main(String[] args) {
		
		val grammarURI = "classpath:/org/foam/xtext/ltl/LtlXtext.xtext"
		val projectName = "org.foam.xtext.ltl"
		val runtimeProject = '''../«projectName»'''
		
		val MAIN_DIR = '''/main'''
		val SRC_DIR = '''«MAIN_DIR»/src'''
		val XTEND_GEN_DIR = '''«MAIN_DIR»/xtend-gen'''
		val XTEXT_GEN_DIR = '''«MAIN_DIR»/xtext-gen'''
		
	    new File('''./«SRC_DIR»/org/foam/xtext/plogic/PropositionalLogicXtextRuntimeModule.java''').delete
	    new File('''./«SRC_DIR»/org/foam/xtext/plogic/PropositionalLogicXtextStandaloneSetup.java''').delete

		new StandaloneSetup => [
			scanClassPath  = true
			platformUri = '''«runtimeProject»/..'''
			
			addRegisterGeneratedEPackage = "org.foam.ltl.LtlPackage"
//			addRegisterEcoreFile = "platform:/resource/org.foam.models/models/ctl.ecore"
			addRegisterGenModelFile = "platform:/resource/org.foam.models/models/ltl.genmodel"
//			addRegisterGenModelFile = "platform:/resource/org.foam.models/models/propositionallogic.genmodel"
			addRegisterGenModelFile = "platform:/resource/org.foam.xtext.plogic/model/generated/PropositionalLogicXtext.genmodel"
		]
		
		new DirectoryCleaner => [
			directory = '''«runtimeProject»/XTEND_GEN_DIR'''
			invoke = null
		]
		
		new File(XTEND_GEN_DIR).mkdir
			
		new DirectoryCleaner => [
	    	directory = '''«runtimeProject»/model/generated'''
			invoke = null
	    ]
	    
	    new DirectoryCleaner => [
	    	directory = '''«runtimeProject»/«SRC_DIR»/org/foam/xtext/ltl'''
	    	addExclude = "LtlXtext.xtext"
			invoke = null
	    ]

		// copy dummy MANIFEST.MF which doesn't import any dependencies 
		new FileCopy => [
			sourceFile = '''«runtimeProject»/META-INF/_MANIFEST.MF'''
			targetFile = '''«runtimeProject»/META-INF/MANIFEST.MF'''
			invoke = null
		]

		new Generator => [
			
			srcPath = SRC_DIR
			srcGenPath = XTEXT_GEN_DIR

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