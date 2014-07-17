package build

import java.io.File
import org.eclipse.emf.mwe.utils.DirectoryCleaner
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.emf.mwe2.ecore.EcoreGenerator

class GenerateFoamModels {

	static val SRC_JAVA		= "main/src"
	static val SRC_XTEND	= "main/xtend-gen"
	static val SRC_EMF		= "main/emf-gen"
	static val MODELSDIR	= "models"
	static val MODELS		= "platform:/resource/org.foam.models/" + MODELSDIR

	def static void main(String[] args) {
		
		new StandaloneSetup => [
			scanClassPath = true
			platformUri = ".."
		]

		new DirectoryCleaner => [
			directory = SRC_EMF
			invoke(null)
		]
		
		val genmodelNames = new File(MODELSDIR)
			.listFiles
			.map[name]
			.filter[endsWith(".genmodel")]

		for(genmodel : genmodelNames) {
			new EcoreGenerator => [
				genModel = '''«MODELS»/«genmodel»'''
				addSrcPath(SRC_JAVA)
				addSrcPath(SRC_XTEND)
				generateEdit = false
				generateEditor = false
				invoke(null)
			]
		}
		
		new File("plugin.xml").delete
		new File("plugin.properties").delete
		
		println("done. don't forget to refresh the workspace")
	}
	
}