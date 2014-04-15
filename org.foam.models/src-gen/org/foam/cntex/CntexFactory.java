/**
 */
package org.foam.cntex;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.cntex.CntexPackage
 * @generated
 */
public interface CntexFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CntexFactory eINSTANCE = org.foam.cntex.impl.CntexFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Counter Example</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Counter Example</em>'.
	 * @generated
	 */
	CounterExample createCounterExample();

	/**
	 * Returns a new object of class '<em>Cnt Ex State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cnt Ex State</em>'.
	 * @generated
	 */
	CntExState createCntExState();

	/**
	 * Returns a new object of class '<em>Cnt Ex Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cnt Ex Assignment</em>'.
	 * @generated
	 */
	CntExAssignment createCntExAssignment();

	/**
	 * Returns a new object of class '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace</em>'.
	 * @generated
	 */
	Trace createTrace();

	/**
	 * Returns a new object of class '<em>Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specification</em>'.
	 * @generated
	 */
	Specification createSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CntexPackage getCntexPackage();

} //CntexFactory
