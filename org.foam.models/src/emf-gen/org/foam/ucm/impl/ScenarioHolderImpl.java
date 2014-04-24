/**
 */
package org.foam.ucm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.UcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.ucm.impl.ScenarioHolderImpl#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.foam.ucm.impl.ScenarioHolderImpl#getVariations <em>Variations</em>}</li>
 *   <li>{@link org.foam.ucm.impl.ScenarioHolderImpl#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioHolderImpl extends MinimalEObjectImpl.Container implements ScenarioHolder
{
	/**
	 * The cached value of the '{@link #getBranches() <em>Branches</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap branches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioHolderImpl()
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
		return UcmPackage.Literals.SCENARIO_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getExtensions()
	{
		return getBranches().list(UcmPackage.Literals.SCENARIO_HOLDER__EXTENSIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Scenario> getVariations()
	{
		return getBranches().list(UcmPackage.Literals.SCENARIO_HOLDER__VARIATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getBranches()
	{
		if (branches == null)
		{
			branches = new BasicFeatureMap(this, UcmPackage.SCENARIO_HOLDER__BRANCHES);
		}
		return branches;
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
			case UcmPackage.SCENARIO_HOLDER__EXTENSIONS:
				return ((InternalEList<?>)getExtensions()).basicRemove(otherEnd, msgs);
			case UcmPackage.SCENARIO_HOLDER__VARIATIONS:
				return ((InternalEList<?>)getVariations()).basicRemove(otherEnd, msgs);
			case UcmPackage.SCENARIO_HOLDER__BRANCHES:
				return ((InternalEList<?>)getBranches()).basicRemove(otherEnd, msgs);
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
			case UcmPackage.SCENARIO_HOLDER__EXTENSIONS:
				return getExtensions();
			case UcmPackage.SCENARIO_HOLDER__VARIATIONS:
				return getVariations();
			case UcmPackage.SCENARIO_HOLDER__BRANCHES:
				if (coreType) return getBranches();
				return ((FeatureMap.Internal)getBranches()).getWrapper();
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
			case UcmPackage.SCENARIO_HOLDER__EXTENSIONS:
				getExtensions().clear();
				getExtensions().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UcmPackage.SCENARIO_HOLDER__VARIATIONS:
				getVariations().clear();
				getVariations().addAll((Collection<? extends Scenario>)newValue);
				return;
			case UcmPackage.SCENARIO_HOLDER__BRANCHES:
				((FeatureMap.Internal)getBranches()).set(newValue);
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
			case UcmPackage.SCENARIO_HOLDER__EXTENSIONS:
				getExtensions().clear();
				return;
			case UcmPackage.SCENARIO_HOLDER__VARIATIONS:
				getVariations().clear();
				return;
			case UcmPackage.SCENARIO_HOLDER__BRANCHES:
				getBranches().clear();
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
			case UcmPackage.SCENARIO_HOLDER__EXTENSIONS:
				return !getExtensions().isEmpty();
			case UcmPackage.SCENARIO_HOLDER__VARIATIONS:
				return !getVariations().isEmpty();
			case UcmPackage.SCENARIO_HOLDER__BRANCHES:
				return branches != null && !branches.isEmpty();
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
		result.append(" (branches: ");
		result.append(branches);
		result.append(')');
		return result.toString();
	}

} //ScenarioHolderImpl
