package org.foam.transform.utils.modeling

import java.io.InputStream
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

class EmfCommons {
	
	def static void registerAsteriskInExtensionToFactory() {
		// Register the XMI resource factory for the all extensions
		val registry = Resource.Factory.Registry.INSTANCE
		val extensionToFactoryMap = registry.extensionToFactoryMap
		extensionToFactoryMap.put("*", new XMIResourceFactoryImpl)
	}
	
	def static EObject readModel(String fileURI) {
		// Obtain a new resource set
		val resourceSet = new ResourceSetImpl
		
		EmfCommons.readModel(fileURI, resourceSet)
	}
	
	def static EObject readModel(String fileURI, ResourceSet resourceSet) {
		// Get the resource
		val resource = resourceSet.getResource(URI.createURI(fileURI), true)
		// Get the first model element and cast it to the right type, in my
		// example everything is hierarchical included in this first node
		resource.contents.head
	}
	
	def static EObject readModel(InputStream inputStreamWithXmi) {
		// Obtain a new resource set
		val xmiResource = new XMIResourceImpl
		xmiResource.load(inputStreamWithXmi, emptyMap);
		return xmiResource.contents.head
	}
	
	def static void writeModel(EObject model, String fileName) {
		val resourceSet = new ResourceSetImpl
		
		val uri = URI.createURI(fileName)
		val resource = resourceSet.createResource(uri)
		
		resource.contents.add(model)
		
		resource.save(Collections.EMPTY_MAP)
	}
	
	def static void basicValidate(EObject eObject) throws BasicModelValidationException {
		val diagnostic = Diagnostician.INSTANCE.validate(eObject)		
		
		if (diagnostic.severity != Diagnostic.OK) {
			throw new BasicModelValidationException(diagnostic)
		}
	}
}