/**
 */
package org.foam.propositionallogic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.propositionallogic.PropositionallogicPackage;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Use</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.propositionallogic.impl.VariableUseImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableUseImpl extends MinimalEObjectImpl.Container implements VariableUse
{
	/**
	 * The cached value of the '{@link #getVariableDefinition() <em>Variable Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDefinition()
	 * @generated
	 * @ordered
	 */
	protected VariableDefinition variableDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableUseImpl()
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
		return PropositionallogicPackage.Literals.VARIABLE_USE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition getVariableDefinition()
	{
		if (variableDefinition != null && variableDefinition.eIsProxy()) {
			InternalEObject oldVariableDefinition = (InternalEObject)variableDefinition;
			variableDefinition = (VariableDefinition)eResolveProxy(oldVariableDefinition);
			if (variableDefinition != oldVariableDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
			}
		}
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition basicGetVariableDefinition()
	{
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDefinition(VariableDefinition newVariableDefinition)
	{
		VariableDefinition oldVariableDefinition = variableDefinition;
		variableDefinition = newVariableDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION:
				if (resolve) return getVariableDefinition();
				return basicGetVariableDefinition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION:
				setVariableDefinition((VariableDefinition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION:
				setVariableDefinition((VariableDefinition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case PropositionallogicPackage.VARIABLE_USE__VARIABLE_DEFINITION:
				return variableDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableUseImpl
