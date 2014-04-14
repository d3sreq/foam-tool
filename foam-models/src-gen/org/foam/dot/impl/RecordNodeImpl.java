/**
 */
package org.foam.dot.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foam.dot.DotPackage;
import org.foam.dot.InnerNode;
import org.foam.dot.RecordNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.dot.impl.RecordNodeImpl#getInnerNodes <em>Inner Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RecordNodeImpl extends NodeImpl implements RecordNode
{
	/**
	 * The cached value of the '{@link #getInnerNodes() <em>Inner Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<InnerNode> innerNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordNodeImpl()
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
		return DotPackage.Literals.RECORD_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InnerNode> getInnerNodes()
	{
		if (innerNodes == null)
		{
			innerNodes = new EObjectContainmentWithInverseEList<InnerNode>(InnerNode.class, this, DotPackage.RECORD_NODE__INNER_NODES, DotPackage.INNER_NODE__RECORD_NODE);
		}
		return innerNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case DotPackage.RECORD_NODE__INNER_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInnerNodes()).basicAdd(otherEnd, msgs);
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
			case DotPackage.RECORD_NODE__INNER_NODES:
				return ((InternalEList<?>)getInnerNodes()).basicRemove(otherEnd, msgs);
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
			case DotPackage.RECORD_NODE__INNER_NODES:
				return getInnerNodes();
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
			case DotPackage.RECORD_NODE__INNER_NODES:
				getInnerNodes().clear();
				getInnerNodes().addAll((Collection<? extends InnerNode>)newValue);
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
			case DotPackage.RECORD_NODE__INNER_NODES:
				getInnerNodes().clear();
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
			case DotPackage.RECORD_NODE__INNER_NODES:
				return innerNodes != null && !innerNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RecordNodeImpl
