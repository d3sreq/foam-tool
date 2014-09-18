package org.foam.transform.utils.modeling

import java.io.InputStream
import java.io.StringWriter
import java.util.Collections
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.eclipse.xtend.lib.annotations.Data

@Data
package class BasicModelValidationException extends RuntimeException {

	Diagnostic diagnostic
	
	override getMessage() {
		diagnostic.children.map[message].join("\n")
	}
}

class EmfCommons {

	/**
	 * Register the XMI resource factory for the all extensions
	 */
	def static void registerAsteriskInExtensionToFactory() {
		val registry = Resource.Factory.Registry.INSTANCE
		val extensionToFactoryMap = registry.extensionToFactoryMap
		extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
	}

	def static readModel(String fileURI) {
		EmfCommons.readModel(fileURI, new ResourceSetImpl)
	}

	/**
	 * Get the first model element and cast it to the right type, in my
	 * example everything is hierarchical included in this first node
	 */
	def static readModel(String fileURI, ResourceSet resourceSet) {
		resourceSet.getResource(URI.createURI(fileURI), true).contents.head
	}

	def static readModel(InputStream inputStreamWithXmi) {
		val xmiResource = new XMIResourceImpl
		xmiResource.load(inputStreamWithXmi, emptyMap)
		return xmiResource.contents.head
	}

	def static void writeModel(EObject model, String fileName) {
		val resourceSet = new ResourceSetImpl

		val uri = URI.createURI(fileName)
		val resource = resourceSet.createResource(uri)

		resource.contents.add(model)

		resource.save(Collections.EMPTY_MAP)
	}

	def static asXmiString(EObject model) {
		val xmiResource = new XMIResourceImpl
		xmiResource.contents.add(model)
		
		val writer = new StringWriter
		xmiResource.save(writer, emptyMap)
		return writer.toString
	}	
	

	def static void basicValidate(EObject eObject) {
		val diagnostic = Diagnostician.INSTANCE.validate(eObject)

		if (diagnostic.severity != Diagnostic.OK) {
			//throw new BasicModelValidationException(diagnostic)
		}
	}
}
