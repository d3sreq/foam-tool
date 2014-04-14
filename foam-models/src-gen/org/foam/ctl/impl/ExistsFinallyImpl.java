/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;

import org.foam.ctl.CtlPackage;
import org.foam.ctl.ExistsFinally;

import org.foam.propositionallogic.impl.UnaryFormulaImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exists Finally</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExistsFinallyImpl extends UnaryFormulaImpl implements ExistsFinally
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExistsFinallyImpl()
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
		return CtlPackage.Literals.EXISTS_FINALLY;
	}

} //ExistsFinallyImpl
