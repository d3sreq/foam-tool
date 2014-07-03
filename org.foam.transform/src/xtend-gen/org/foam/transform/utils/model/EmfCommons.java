package org.foam.transform.utils.model;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.foam.transform.utils.model.BasicModelValidationException;

@SuppressWarnings("all")
public class EmfCommons {
  public static void registerAsteriskInExtensionToFactory() {
    final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
    final Map<String, Object> extensionToFactoryMap = registry.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    extensionToFactoryMap.put("*", _xMIResourceFactoryImpl);
  }
  
  public static EObject readModel(final String fileURI) {
    EObject _xblockexpression = null;
    {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      _xblockexpression = EmfCommons.readModel(fileURI, resourceSet);
    }
    return _xblockexpression;
  }
  
  public static EObject readModel(final String fileURI, final ResourceSet resourceSet) {
    EObject _xblockexpression = null;
    {
      URI _createURI = URI.createURI(fileURI);
      final Resource resource = resourceSet.getResource(_createURI, true);
      EList<EObject> _contents = resource.getContents();
      _xblockexpression = IterableExtensions.<EObject>head(_contents);
    }
    return _xblockexpression;
  }
  
  public static EObject readModel(final InputStream inputStreamWithXmi) {
    try {
      final XMIResourceImpl xmiResource = new XMIResourceImpl();
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      xmiResource.load(inputStreamWithXmi, _emptyMap);
      EList<EObject> _contents = xmiResource.getContents();
      return IterableExtensions.<EObject>head(_contents);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void writeModel(final EObject model, final String fileName) {
    try {
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      final URI uri = URI.createURI(fileName);
      final Resource resource = resourceSet.createResource(uri);
      EList<EObject> _contents = resource.getContents();
      _contents.add(model);
      resource.save(Collections.EMPTY_MAP);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void basicValidate(final EObject eObject) throws BasicModelValidationException {
    final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject);
    int _severity = diagnostic.getSeverity();
    boolean _notEquals = (_severity != Diagnostic.OK);
    if (_notEquals) {
      throw new BasicModelValidationException(diagnostic);
    }
  }
}
