/**
 */
package org.foam.tadl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foam.propositionallogic.VariableDefinition;

import org.foam.tadl.FormulaHolder;
import org.foam.tadl.TadlPackage;
import org.foam.tadl.Template;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.tadl.impl.TemplateImpl#getFormulaHolders <em>Formula Holders</em>}</li>
 *   <li>{@link org.foam.tadl.impl.TemplateImpl#getVariableDefinitions <em>Variable Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateImpl extends MinimalEObjectImpl.Container implements Template
{
	/**
	 * The cached value of the '{@link #getFormulaHolders() <em>Formula Holders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaHolders()
	 * @generated
	 * @ordered
	 */
	protected EList<FormulaHolder> formulaHolders;

	/**
	 * The cached value of the '{@link #getVariableDefinitions() <em>Variable Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDefinition> variableDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateImpl()
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
		return TadlPackage.Literals.TEMPLATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FormulaHolder> getFormulaHolders()
	{
		if (formulaHolders == null)
		{
			formulaHolders = new EObjectContainmentEList<FormulaHolder>(FormulaHolder.class, this, TadlPackage.TEMPLATE__FORMULA_HOLDERS);
		}
		return formulaHolders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDefinition> getVariableDefinitions()
	{
		if (variableDefinitions == null)
		{
			variableDefinitions = new EObjectContainmentEList<VariableDefinition>(VariableDefinition.class, this, TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS);
		}
		return variableDefinitions;
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
			case TadlPackage.TEMPLATE__FORMULA_HOLDERS:
				return ((InternalEList<?>)getFormulaHolders()).basicRemove(otherEnd, msgs);
			case TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS:
				return ((InternalEList<?>)getVariableDefinitions()).basicRemove(otherEnd, msgs);
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
			case TadlPackage.TEMPLATE__FORMULA_HOLDERS:
				return getFormulaHolders();
			case TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS:
				return getVariableDefinitions();
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
			case TadlPackage.TEMPLATE__FORMULA_HOLDERS:
				getFormulaHolders().clear();
				getFormulaHolders().addAll((Collection<? extends FormulaHolder>)newValue);
				return;
			case TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS:
				getVariableDefinitions().clear();
				getVariableDefinitions().addAll((Collection<? extends VariableDefinition>)newValue);
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
			case TadlPackage.TEMPLATE__FORMULA_HOLDERS:
				getFormulaHolders().clear();
				return;
			case TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS:
				getVariableDefinitions().clear();
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
			case TadlPackage.TEMPLATE__FORMULA_HOLDERS:
				return formulaHolders != null && !formulaHolders.isEmpty();
			case TadlPackage.TEMPLATE__VARIABLE_DEFINITIONS:
				return variableDefinitions != null && !variableDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemplateImpl
