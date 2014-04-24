/**
 */
package org.foam.dot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.foam.dot.DotPackage;
import org.foam.dot.InnerNode;
import org.foam.dot.RecordNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inner Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.dot.impl.InnerNodeImpl#getRecordNode <em>Record Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InnerNodeImpl extends NodeImpl implements InnerNode
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InnerNodeImpl()
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
		return DotPackage.Literals.INNER_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordNode getRecordNode()
	{
		if (eContainerFeatureID() != DotPackage.INNER_NODE__RECORD_NODE) return null;
		return (RecordNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRecordNode(RecordNode newRecordNode, NotificationChain msgs)
	{
		msgs = eBasicSetContainer((InternalEObject)newRecordNode, DotPackage.INNER_NODE__RECORD_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordNode(RecordNode newRecordNode)
	{
		if (newRecordNode != eInternalContainer() || (eContainerFeatureID() != DotPackage.INNER_NODE__RECORD_NODE && newRecordNode != null))
		{
			if (EcoreUtil.isAncestor(this, newRecordNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRecordNode != null)
				msgs = ((InternalEObject)newRecordNode).eInverseAdd(this, DotPackage.RECORD_NODE__INNER_NODES, RecordNode.class, msgs);
			msgs = basicSetRecordNode(newRecordNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DotPackage.INNER_NODE__RECORD_NODE, newRecordNode, newRecordNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case DotPackage.INNER_NODE__RECORD_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRecordNode((RecordNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case DotPackage.INNER_NODE__RECORD_NODE:
				return basicSetRecordNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
	{
		switch (eContainerFeatureID())
		{
			case DotPackage.INNER_NODE__RECORD_NODE:
				return eInternalContainer().eInverseRemove(this, DotPackage.RECORD_NODE__INNER_NODES, RecordNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
			case DotPackage.INNER_NODE__RECORD_NODE:
				return getRecordNode();
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
			case DotPackage.INNER_NODE__RECORD_NODE:
				setRecordNode((RecordNode)newValue);
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
			case DotPackage.INNER_NODE__RECORD_NODE:
				setRecordNode((RecordNode)null);
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
			case DotPackage.INNER_NODE__RECORD_NODE:
				return getRecordNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //InnerNodeImpl
