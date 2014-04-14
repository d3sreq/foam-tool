/**
 */
package org.foam.traceability.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.traceability.OverviewTransitionType;
import org.foam.traceability.OverviewTransitionTypeAnnotation;
import org.foam.traceability.TraceabilityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overview Transition Type Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.traceability.impl.OverviewTransitionTypeAnnotationImpl#getOverviewTransitionType <em>Overview Transition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OverviewTransitionTypeAnnotationImpl extends MinimalEObjectImpl.Container implements OverviewTransitionTypeAnnotation
{
	/**
	 * The default value of the '{@link #getOverviewTransitionType() <em>Overview Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverviewTransitionType()
	 * @generated
	 * @ordered
	 */
	protected static final OverviewTransitionType OVERVIEW_TRANSITION_TYPE_EDEFAULT = OverviewTransitionType.PRECEDENCE;

	/**
	 * The cached value of the '{@link #getOverviewTransitionType() <em>Overview Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverviewTransitionType()
	 * @generated
	 * @ordered
	 */
	protected OverviewTransitionType overviewTransitionType = OVERVIEW_TRANSITION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OverviewTransitionTypeAnnotationImpl()
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
		return TraceabilityPackage.Literals.OVERVIEW_TRANSITION_TYPE_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewTransitionType getOverviewTransitionType()
	{
		return overviewTransitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverviewTransitionType(OverviewTransitionType newOverviewTransitionType)
	{
		OverviewTransitionType oldOverviewTransitionType = overviewTransitionType;
		overviewTransitionType = newOverviewTransitionType == null ? OVERVIEW_TRANSITION_TYPE_EDEFAULT : newOverviewTransitionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE, oldOverviewTransitionType, overviewTransitionType));
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
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE:
				return getOverviewTransitionType();
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
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE:
				setOverviewTransitionType((OverviewTransitionType)newValue);
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
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE:
				setOverviewTransitionType(OVERVIEW_TRANSITION_TYPE_EDEFAULT);
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
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE:
				return overviewTransitionType != OVERVIEW_TRANSITION_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (overviewTransitionType: ");
		result.append(overviewTransitionType);
		result.append(')');
		return result.toString();
	}

} //OverviewTransitionTypeAnnotationImpl
