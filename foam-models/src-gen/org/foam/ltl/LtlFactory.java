/**
 */
package org.foam.ltl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.ltl.LtlPackage
 * @generated
 */
public interface LtlFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LtlFactory eINSTANCE = org.foam.ltl.impl.LtlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Globally</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Globally</em>'.
	 * @generated
	 */
	Globally createGlobally();

	/**
	 * Returns a new object of class '<em>Future</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Future</em>'.
	 * @generated
	 */
	Future createFuture();

	/**
	 * Returns a new object of class '<em>Next</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Next</em>'.
	 * @generated
	 */
	Next createNext();

	/**
	 * Returns a new object of class '<em>Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Until</em>'.
	 * @generated
	 */
	Until createUntil();

	/**
	 * Returns a new object of class '<em>Historically</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Historically</em>'.
	 * @generated
	 */
	Historically createHistorically();

	/**
	 * Returns a new object of class '<em>Once</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Once</em>'.
	 * @generated
	 */
	Once createOnce();

	/**
	 * Returns a new object of class '<em>Releases</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Releases</em>'.
	 * @generated
	 */
	Releases createReleases();

	/**
	 * Returns a new object of class '<em>Since</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Since</em>'.
	 * @generated
	 */
	Since createSince();

	/**
	 * Returns a new object of class '<em>Triggered</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Triggered</em>'.
	 * @generated
	 */
	Triggered createTriggered();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LtlPackage getLtlPackage();

} //LtlFactory
