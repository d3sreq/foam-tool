/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;

import org.foam.ctl.CtlPackage;
import org.foam.ctl.ExistsGlobally;

import org.foam.propositionallogic.impl.UnaryFormulaImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exists Globally</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExistsGloballyImpl extends UnaryFormulaImpl implements ExistsGlobally
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistsGloballyImpl()
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
		return CtlPackage.Literals.EXISTS_GLOBALLY;
	}

} //ExistsGloballyImpl
