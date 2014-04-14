/**
 */
package org.foam.ctl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.ctl.CtlPackage
 * @generated
 */
public interface CtlFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CtlFactory eINSTANCE = org.foam.ctl.impl.CtlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>All Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Until</em>'.
	 * @generated
	 */
	AllUntil createAllUntil();

	/**
	 * Returns a new object of class '<em>Exists Until</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists Until</em>'.
	 * @generated
	 */
	ExistsUntil createExistsUntil();

	/**
	 * Returns a new object of class '<em>All Globally</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Globally</em>'.
	 * @generated
	 */
	AllGlobally createAllGlobally();

	/**
	 * Returns a new object of class '<em>All Finally</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Finally</em>'.
	 * @generated
	 */
	AllFinally createAllFinally();

	/**
	 * Returns a new object of class '<em>All Next</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Next</em>'.
	 * @generated
	 */
	AllNext createAllNext();

	/**
	 * Returns a new object of class '<em>Exists Globally</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists Globally</em>'.
	 * @generated
	 */
	ExistsGlobally createExistsGlobally();

	/**
	 * Returns a new object of class '<em>Exists Finally</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists Finally</em>'.
	 * @generated
	 */
	ExistsFinally createExistsFinally();

	/**
	 * Returns a new object of class '<em>Exists Next</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exists Next</em>'.
	 * @generated
	 */
	ExistsNext createExistsNext();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CtlPackage getCtlPackage();

} //CtlFactory
