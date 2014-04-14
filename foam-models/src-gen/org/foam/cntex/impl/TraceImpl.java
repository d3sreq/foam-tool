/**
 */
package org.foam.cntex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foam.cntex.CntExState;
import org.foam.cntex.CntexPackage;
import org.foam.cntex.Trace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.cntex.impl.TraceImpl#getLoopStart <em>Loop Start</em>}</li>
 *   <li>{@link org.foam.cntex.impl.TraceImpl#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceImpl extends MinimalEObjectImpl.Container implements Trace
{
	/**
	 * The cached value of the '{@link #getLoopStart() <em>Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopStart()
	 * @generated
	 * @ordered
	 */
	protected CntExState loopStart;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<CntExState> states;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceImpl()
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
		return CntexPackage.Literals.TRACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntExState getLoopStart()
	{
		if (loopStart != null && loopStart.eIsProxy())
		{
			InternalEObject oldLoopStart = (InternalEObject)loopStart;
			loopStart = (CntExState)eResolveProxy(oldLoopStart);
			if (loopStart != oldLoopStart)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CntexPackage.TRACE__LOOP_START, oldLoopStart, loopStart));
			}
		}
		return loopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntExState basicGetLoopStart()
	{
		return loopStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopStart(CntExState newLoopStart)
	{
		CntExState oldLoopStart = loopStart;
		loopStart = newLoopStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CntexPackage.TRACE__LOOP_START, oldLoopStart, loopStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CntExState> getStates()
	{
		if (states == null)
		{
			states = new EObjectContainmentEList<CntExState>(CntExState.class, this, CntexPackage.TRACE__STATES);
		}
		return states;
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
			case CntexPackage.TRACE__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
			case CntexPackage.TRACE__LOOP_START:
				if (resolve) return getLoopStart();
				return basicGetLoopStart();
			case CntexPackage.TRACE__STATES:
				return getStates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case CntexPackage.TRACE__LOOP_START:
				setLoopStart((CntExState)newValue);
				return;
			case CntexPackage.TRACE__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends CntExState>)newValue);
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
			case CntexPackage.TRACE__LOOP_START:
				setLoopStart((CntExState)null);
				return;
			case CntexPackage.TRACE__STATES:
				getStates().clear();
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
			case CntexPackage.TRACE__LOOP_START:
				return loopStart != null;
			case CntexPackage.TRACE__STATES:
				return states != null && !states.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TraceImpl
