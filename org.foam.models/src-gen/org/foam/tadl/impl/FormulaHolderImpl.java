/**
 */
package org.foam.tadl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.foam.propositionallogic.Formula;

import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.TadlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Holder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.tadl.impl.FormulaHolderImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.foam.tadl.impl.FormulaHolderImpl#getFormulaType <em>Formula Type</em>}</li>
 *   <li>{@link org.foam.tadl.impl.FormulaHolderImpl#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormulaHolderImpl extends MinimalEObjectImpl.Container implements FormulaHolder
{
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormulaType() <em>Formula Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaType()
	 * @generated
	 * @ordered
	 */
	protected static final FormulaType FORMULA_TYPE_EDEFAULT = FormulaType.LTL;

	/**
	 * The cached value of the '{@link #getFormulaType() <em>Formula Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaType()
	 * @generated
	 * @ordered
	 */
	protected FormulaType formulaType = FORMULA_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFormula() <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormula()
	 * @generated
	 * @ordered
	 */
	protected Formula formula;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FormulaHolderImpl()
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
		return TadlPackage.Literals.FORMULA_HOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment)
	{
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TadlPackage.FORMULA_HOLDER__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaType getFormulaType()
	{
		return formulaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaType(FormulaType newFormulaType)
	{
		FormulaType oldFormulaType = formulaType;
		formulaType = newFormulaType == null ? FORMULA_TYPE_EDEFAULT : newFormulaType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TadlPackage.FORMULA_HOLDER__FORMULA_TYPE, oldFormulaType, formulaType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Formula getFormula()
	{
		return formula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormula(Formula newFormula, NotificationChain msgs)
	{
		Formula oldFormula = formula;
		formula = newFormula;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TadlPackage.FORMULA_HOLDER__FORMULA, oldFormula, newFormula);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormula(Formula newFormula)
	{
		if (newFormula != formula)
		{
			NotificationChain msgs = null;
			if (formula != null)
				msgs = ((InternalEObject)formula).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TadlPackage.FORMULA_HOLDER__FORMULA, null, msgs);
			if (newFormula != null)
				msgs = ((InternalEObject)newFormula).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TadlPackage.FORMULA_HOLDER__FORMULA, null, msgs);
			msgs = basicSetFormula(newFormula, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TadlPackage.FORMULA_HOLDER__FORMULA, newFormula, newFormula));
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
			case TadlPackage.FORMULA_HOLDER__FORMULA:
				return basicSetFormula(null, msgs);
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
			case TadlPackage.FORMULA_HOLDER__COMMENT:
				return getComment();
			case TadlPackage.FORMULA_HOLDER__FORMULA_TYPE:
				return getFormulaType();
			case TadlPackage.FORMULA_HOLDER__FORMULA:
				return getFormula();
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
			case TadlPackage.FORMULA_HOLDER__COMMENT:
				setComment((String)newValue);
				return;
			case TadlPackage.FORMULA_HOLDER__FORMULA_TYPE:
				setFormulaType((FormulaType)newValue);
				return;
			case TadlPackage.FORMULA_HOLDER__FORMULA:
				setFormula((Formula)newValue);
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
			case TadlPackage.FORMULA_HOLDER__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case TadlPackage.FORMULA_HOLDER__FORMULA_TYPE:
				setFormulaType(FORMULA_TYPE_EDEFAULT);
				return;
			case TadlPackage.FORMULA_HOLDER__FORMULA:
				setFormula((Formula)null);
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
			case TadlPackage.FORMULA_HOLDER__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case TadlPackage.FORMULA_HOLDER__FORMULA_TYPE:
				return formulaType != FORMULA_TYPE_EDEFAULT;
			case TadlPackage.FORMULA_HOLDER__FORMULA:
				return formula != null;
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
		result.append(" (comment: ");
		result.append(comment);
		result.append(", formulaType: ");
		result.append(formulaType);
		result.append(')');
		return result.toString();
	}

} //FormulaHolderImpl
