package org.foam.build

import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe2.ecore.EcoreGenerator
import java.io.File

class GenerateFoamModels {
	static val SRC_JAVA	= "src/java"
	static val SRC_XTEND= "src/xtend-gen"
	static val SRC_EMF	= "src/emf-gen"
	static val MODELS	= "platform:/resource/org.foam.models/models"

	def static void main(String[] args) {
		new StandaloneSetup => [
			scanClassPath = true
			platformUri = ".."
		]
		
		new DirectoryCleaner => [
			directory = SRC_EMF
			invoke(null)
		]
		
		for(genmodel : #[
			"annotation",
			"cntex",
			"ctl",
			"ltl",
			"dot",
			"flowannotation",
			"lts",
			"propositionallogic",
			"tadl",
			"traceability",
			"ucm",
			"verification"
		]) {
			new EcoreGenerator => [
				genModel = '''«MODELS»/«genmodel».genmodel'''
				addSrcPath(SRC_JAVA)
				addSrcPath(SRC_XTEND)
				generateEdit = false
				generateEditor = false
				invoke(null)
			]
		}
		
		new File("plugin.xml").delete
		new File("plugin.properties").delete
	}
	
}