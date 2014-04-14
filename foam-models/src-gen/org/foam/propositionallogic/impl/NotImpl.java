/**
 */
package org.foam.propositionallogic.impl;

import org.eclipse.emf.ecore.EClass;

import org.foam.propositionallogic.Not;
import org.foam.propositionallogic.PropositionallogicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NotImpl extends UnaryFormulaImpl implements Not
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotImpl()
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
		return PropositionallogicPackage.Literals.NOT;
	}

} //NotImpl
