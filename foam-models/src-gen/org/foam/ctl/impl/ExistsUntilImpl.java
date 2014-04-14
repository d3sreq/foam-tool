/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;

import org.foam.ctl.CtlPackage;
import org.foam.ctl.ExistsUntil;

import org.foam.propositionallogic.impl.BinaryFormulaImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exists Until</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExistsUntilImpl extends BinaryFormulaImpl implements ExistsUntil
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistsUntilImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return CtlPackage.Literals.EXISTS_UNTIL;
	}

} //ExistsUntilImpl
