/**
 */
package org.foam.flowannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.flowannotation.FlowannotationPackage;
import org.foam.flowannotation.VariableDefinitionAnnotation;

import org.foam.propositionallogic.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Definition Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.flowannotation.impl.VariableDefinitionAnnotationImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDefinitionAnnotationImpl extends MinimalEObjectImpl.Container implements VariableDefinitionAnnotation
{
	/**
	 * The cached value of the '{@link #getVariableDefinition() <em>Variable Definition</em>}' containment reference.
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
	protected VariableDefinitionAnnotationImpl()
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
		return FlowannotationPackage.Literals.VARIABLE_DEFINITION_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition getVariableDefinition()
	{
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableDefinition(VariableDefinition newVariableDefinition, NotificationChain msgs)
	{
		VariableDefinition oldVariableDefinition = variableDefinition;
		variableDefinition = newVariableDefinition;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION, oldVariableDefinition, newVariableDefinition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableDefinition(VariableDefinition newVariableDefinition)
	{
		if (newVariableDefinition != variableDefinition)
		{
			NotificationChain msgs = null;
			if (variableDefinition != null)
				msgs = ((InternalEObject)variableDefinition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION, null, msgs);
			if (newVariableDefinition != null)
				msgs = ((InternalEObject)newVariableDefinition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION, null, msgs);
			msgs = basicSetVariableDefinition(newVariableDefinition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION, newVariableDefinition, newVariableDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION:
				return basicSetVariableDefinition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION:
				return getVariableDefinition();
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
		switch (featureID)
		{
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION:
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
		switch (featureID)
		{
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION:
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
		switch (featureID)
		{
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION:
				return variableDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableDefinitionAnnotationImpl
