/**
 */
package org.foam.tadl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.propositionallogic.VariableDefinition;

import org.foam.tadl.Group;
import org.foam.tadl.TadlPackage;
import org.foam.tadl.TemporalAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Temporal Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.tadl.impl.TemporalAnnotationImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.foam.tadl.impl.TemporalAnnotationImpl#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemporalAnnotationImpl extends MinimalEObjectImpl.Container implements TemporalAnnotation
{
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected Group group;

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
	protected TemporalAnnotationImpl()
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
		return TadlPackage.Literals.TEMPORAL_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group getGroup()
	{
		if (group != null && group.eIsProxy())
		{
			InternalEObject oldGroup = (InternalEObject)group;
			group = (Group)eResolveProxy(oldGroup);
			if (group != oldGroup)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TadlPackage.TEMPORAL_ANNOTATION__GROUP, oldGroup, group));
			}
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group basicGetGroup()
	{
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(Group newGroup)
	{
		Group oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TadlPackage.TEMPORAL_ANNOTATION__GROUP, oldGroup, group));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition getVariableDefinition()
	{
		if (variableDefinition != null && variableDefinition.eIsProxy())
		{
			InternalEObject oldVariableDefinition = (InternalEObject)variableDefinition;
			variableDefinition = (VariableDefinition)eResolveProxy(oldVariableDefinition);
			if (variableDefinition != oldVariableDefinition)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION, oldVariableDefinition, variableDefinition));
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
			case TadlPackage.TEMPORAL_ANNOTATION__GROUP:
				if (resolve) return getGroup();
				return basicGetGroup();
			case TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION:
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
		switch (featureID)
		{
			case TadlPackage.TEMPORAL_ANNOTATION__GROUP:
				setGroup((Group)newValue);
				return;
			case TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION:
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
			case TadlPackage.TEMPORAL_ANNOTATION__GROUP:
				setGroup((Group)null);
				return;
			case TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION:
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
			case TadlPackage.TEMPORAL_ANNOTATION__GROUP:
				return group != null;
			case TadlPackage.TEMPORAL_ANNOTATION__VARIABLE_DEFINITION:
				return variableDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //TemporalAnnotationImpl
