/**
 */
package org.foam.traceability.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.tadl.FormulaHolder;
import org.foam.tadl.Group;

import org.foam.traceability.FormulaIdentificationAnnotation;
import org.foam.traceability.TraceabilityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Identification Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.traceability.impl.FormulaIdentificationAnnotationImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.foam.traceability.impl.FormulaIdentificationAnnotationImpl#getFormulaHolder <em>Formula Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormulaIdentificationAnnotationImpl extends MinimalEObjectImpl.Container implements FormulaIdentificationAnnotation
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
	 * The cached value of the '{@link #getFormulaHolder() <em>Formula Holder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaHolder()
	 * @generated
	 * @ordered
	 */
	protected FormulaHolder formulaHolder;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormulaIdentificationAnnotationImpl()
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
		return TraceabilityPackage.Literals.FORMULA_IDENTIFICATION_ANNOTATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP, oldGroup, group));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP, oldGroup, group));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaHolder getFormulaHolder()
	{
		if (formulaHolder != null && formulaHolder.eIsProxy())
		{
			InternalEObject oldFormulaHolder = (InternalEObject)formulaHolder;
			formulaHolder = (FormulaHolder)eResolveProxy(oldFormulaHolder);
			if (formulaHolder != oldFormulaHolder)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER, oldFormulaHolder, formulaHolder));
			}
		}
		return formulaHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaHolder basicGetFormulaHolder()
	{
		return formulaHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaHolder(FormulaHolder newFormulaHolder)
	{
		FormulaHolder oldFormulaHolder = formulaHolder;
		formulaHolder = newFormulaHolder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER, oldFormulaHolder, formulaHolder));
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
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP:
				if (resolve) return getGroup();
				return basicGetGroup();
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER:
				if (resolve) return getFormulaHolder();
				return basicGetFormulaHolder();
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
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP:
				setGroup((Group)newValue);
				return;
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER:
				setFormulaHolder((FormulaHolder)newValue);
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
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP:
				setGroup((Group)null);
				return;
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER:
				setFormulaHolder((FormulaHolder)null);
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
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__GROUP:
				return group != null;
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER:
				return formulaHolder != null;
		}
		return super.eIsSet(featureID);
	}

} //FormulaIdentificationAnnotationImpl
