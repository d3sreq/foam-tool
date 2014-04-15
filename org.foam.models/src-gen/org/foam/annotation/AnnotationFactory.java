/**
 */
package org.foam.annotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.annotation.AnnotationPackage
 * @generated
 */
public interface AnnotationFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationFactory eINSTANCE = org.foam.annotation.impl.AnnotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Unknown Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unknown Annotation</em>'.
	 * @generated
	 */
	UnknownAnnotation createUnknownAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnnotationPackage getAnnotationPackage();

} //AnnotationFactory
