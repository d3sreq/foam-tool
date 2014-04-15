/**
 */
package org.foam.flowannotation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.flowannotation.FlowannotationPackage;
import org.foam.flowannotation.Include;

import org.foam.ucm.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.flowannotation.impl.IncludeImpl#getInlinedUseCase <em>Inlined Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncludeImpl extends MinimalEObjectImpl.Container implements Include
{
	/**
	 * The cached value of the '{@link #getInlinedUseCase() <em>Inlined Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInlinedUseCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase inlinedUseCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncludeImpl()
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
		return FlowannotationPackage.Literals.INCLUDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getInlinedUseCase()
	{
		if (inlinedUseCase != null && inlinedUseCase.eIsProxy())
		{
			InternalEObject oldInlinedUseCase = (InternalEObject)inlinedUseCase;
			inlinedUseCase = (UseCase)eResolveProxy(oldInlinedUseCase);
			if (inlinedUseCase != oldInlinedUseCase)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FlowannotationPackage.INCLUDE__INLINED_USE_CASE, oldInlinedUseCase, inlinedUseCase));
			}
		}
		return inlinedUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetInlinedUseCase()
	{
		return inlinedUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInlinedUseCase(UseCase newInlinedUseCase)
	{
		UseCase oldInlinedUseCase = inlinedUseCase;
		inlinedUseCase = newInlinedUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FlowannotationPackage.INCLUDE__INLINED_USE_CASE, oldInlinedUseCase, inlinedUseCase));
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
			case FlowannotationPackage.INCLUDE__INLINED_USE_CASE:
				if (resolve) return getInlinedUseCase();
				return basicGetInlinedUseCase();
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
			case FlowannotationPackage.INCLUDE__INLINED_USE_CASE:
				setInlinedUseCase((UseCase)newValue);
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
			case FlowannotationPackage.INCLUDE__INLINED_USE_CASE:
				setInlinedUseCase((UseCase)null);
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
			case FlowannotationPackage.INCLUDE__INLINED_USE_CASE:
				return inlinedUseCase != null;
		}
		return super.eIsSet(featureID);
	}

} //IncludeImpl
