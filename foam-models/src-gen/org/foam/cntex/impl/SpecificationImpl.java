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

import org.foam.annotation.Annotation;

import org.foam.cntex.CntexPackage;
import org.foam.cntex.Specification;
import org.foam.cntex.Trace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.cntex.impl.SpecificationImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.foam.cntex.impl.SpecificationImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.foam.cntex.impl.SpecificationImpl#getTextFormula <em>Text Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationImpl extends MinimalEObjectImpl.Container implements Specification
{
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected Trace trace;

	/**
	 * The default value of the '{@link #getTextFormula() <em>Text Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormula()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_FORMULA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextFormula() <em>Text Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormula()
	 * @generated
	 * @ordered
	 */
	protected String textFormula = TEXT_FORMULA_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificationImpl()
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
		return CntexPackage.Literals.SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations()
	{
		if (annotations == null)
		{
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, CntexPackage.SPECIFICATION__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace getTrace()
	{
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrace(Trace newTrace, NotificationChain msgs)
	{
		Trace oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CntexPackage.SPECIFICATION__TRACE, oldTrace, newTrace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrace(Trace newTrace)
	{
		if (newTrace != trace)
		{
			NotificationChain msgs = null;
			if (trace != null)
				msgs = ((InternalEObject)trace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CntexPackage.SPECIFICATION__TRACE, null, msgs);
			if (newTrace != null)
				msgs = ((InternalEObject)newTrace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CntexPackage.SPECIFICATION__TRACE, null, msgs);
			msgs = basicSetTrace(newTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CntexPackage.SPECIFICATION__TRACE, newTrace, newTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextFormula()
	{
		return textFormula;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextFormula(String newTextFormula)
	{
		String oldTextFormula = textFormula;
		textFormula = newTextFormula;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CntexPackage.SPECIFICATION__TEXT_FORMULA, oldTextFormula, textFormula));
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
			case CntexPackage.SPECIFICATION__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case CntexPackage.SPECIFICATION__TRACE:
				return basicSetTrace(null, msgs);
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
			case CntexPackage.SPECIFICATION__ANNOTATIONS:
				return getAnnotations();
			case CntexPackage.SPECIFICATION__TRACE:
				return getTrace();
			case CntexPackage.SPECIFICATION__TEXT_FORMULA:
				return getTextFormula();
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
			case CntexPackage.SPECIFICATION__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case CntexPackage.SPECIFICATION__TRACE:
				setTrace((Trace)newValue);
				return;
			case CntexPackage.SPECIFICATION__TEXT_FORMULA:
				setTextFormula((String)newValue);
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
			case CntexPackage.SPECIFICATION__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case CntexPackage.SPECIFICATION__TRACE:
				setTrace((Trace)null);
				return;
			case CntexPackage.SPECIFICATION__TEXT_FORMULA:
				setTextFormula(TEXT_FORMULA_EDEFAULT);
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
			case CntexPackage.SPECIFICATION__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case CntexPackage.SPECIFICATION__TRACE:
				return trace != null;
			case CntexPackage.SPECIFICATION__TEXT_FORMULA:
				return TEXT_FORMULA_EDEFAULT == null ? textFormula != null : !TEXT_FORMULA_EDEFAULT.equals(textFormula);
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
		result.append(" (textFormula: ");
		result.append(textFormula);
		result.append(')');
		return result.toString();
	}

} //SpecificationImpl
