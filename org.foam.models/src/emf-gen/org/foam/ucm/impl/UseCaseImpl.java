/**
 */
package org.foam.ucm.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.foam.ucm.Scenario;
import org.foam.ucm.ScenarioHolder;
import org.foam.ucm.Step;
import org.foam.ucm.UcmPackage;
import org.foam.ucm.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#getMainScenario <em>Main Scenario</em>}</li>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#getBranches <em>Branches</em>}</li>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#getPreceeded <em>Preceeded</em>}</li>
 *   <li>{@link org.foam.ucm.impl.UseCaseImpl#isPrimary <em>Primary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends MinimalEObjectImpl.Container implements UseCase
{
	/**
	 * The cached value of the '{@link #getMainScenario() <em>Main Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainScenario()
	 * @generated
	 * @ordered
	 */
	protected Scenario mainScenario;

	/**
	 * The cached value of the '{@link #getBranches() <em>Branches</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches()
	 * @generated
	 * @ordered
	 */
	protected EMap<Step, ScenarioHolder> branches;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPreceeded() <em>Preceeded</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreceeded()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> preceeded;

	/**
	 * The default value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMARY_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isPrimary() <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimary()
	 * @generated
	 * @ordered
	 */
	protected boolean primary = PRIMARY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl()
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
		return UcmPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario getMainScenario()
	{
		return mainScenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMainScenario(Scenario newMainScenario, NotificationChain msgs)
	{
		Scenario oldMainScenario = mainScenario;
		mainScenario = newMainScenario;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UcmPackage.USE_CASE__MAIN_SCENARIO, oldMainScenario, newMainScenario);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainScenario(Scenario newMainScenario)
	{
		if (newMainScenario != mainScenario)
		{
			NotificationChain msgs = null;
			if (mainScenario != null)
				msgs = ((InternalEObject)mainScenario).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UcmPackage.USE_CASE__MAIN_SCENARIO, null, msgs);
			if (newMainScenario != null)
				msgs = ((InternalEObject)newMainScenario).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UcmPackage.USE_CASE__MAIN_SCENARIO, null, msgs);
			msgs = basicSetMainScenario(newMainScenario, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UcmPackage.USE_CASE__MAIN_SCENARIO, newMainScenario, newMainScenario));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<Step, ScenarioHolder> getBranches()
	{
		if (branches == null)
		{
			branches = new EcoreEMap<Step,ScenarioHolder>(UcmPackage.Literals.STEP_TO_SCENARIO_HOLDER_MAP_ENTRY, StepToScenarioHolderMapEntryImpl.class, this, UcmPackage.USE_CASE__BRANCHES);
		}
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UcmPackage.USE_CASE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UcmPackage.USE_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getPreceeded()
	{
		if (preceeded == null)
		{
			preceeded = new EObjectResolvingEList<UseCase>(UseCase.class, this, UcmPackage.USE_CASE__PRECEEDED);
		}
		return preceeded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrimary()
	{
		return primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(boolean newPrimary)
	{
		boolean oldPrimary = primary;
		primary = newPrimary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UcmPackage.USE_CASE__PRIMARY, oldPrimary, primary));
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
			case UcmPackage.USE_CASE__MAIN_SCENARIO:
				return basicSetMainScenario(null, msgs);
			case UcmPackage.USE_CASE__BRANCHES:
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
			case UcmPackage.USE_CASE__MAIN_SCENARIO:
				return getMainScenario();
			case UcmPackage.USE_CASE__BRANCHES:
				if (coreType) return getBranches();
				else return getBranches().map();
			case UcmPackage.USE_CASE__ID:
				return getId();
			case UcmPackage.USE_CASE__NAME:
				return getName();
			case UcmPackage.USE_CASE__PRECEEDED:
				return getPreceeded();
			case UcmPackage.USE_CASE__PRIMARY:
				return isPrimary();
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
			case UcmPackage.USE_CASE__MAIN_SCENARIO:
				setMainScenario((Scenario)newValue);
				return;
			case UcmPackage.USE_CASE__BRANCHES:
				((EStructuralFeature.Setting)getBranches()).set(newValue);
				return;
			case UcmPackage.USE_CASE__ID:
				setId((String)newValue);
				return;
			case UcmPackage.USE_CASE__NAME:
				setName((String)newValue);
				return;
			case UcmPackage.USE_CASE__PRECEEDED:
				getPreceeded().clear();
				getPreceeded().addAll((Collection<? extends UseCase>)newValue);
				return;
			case UcmPackage.USE_CASE__PRIMARY:
				setPrimary((Boolean)newValue);
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
			case UcmPackage.USE_CASE__MAIN_SCENARIO:
				setMainScenario((Scenario)null);
				return;
			case UcmPackage.USE_CASE__BRANCHES:
				getBranches().clear();
				return;
			case UcmPackage.USE_CASE__ID:
				setId(ID_EDEFAULT);
				return;
			case UcmPackage.USE_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UcmPackage.USE_CASE__PRECEEDED:
				getPreceeded().clear();
				return;
			case UcmPackage.USE_CASE__PRIMARY:
				setPrimary(PRIMARY_EDEFAULT);
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
			case UcmPackage.USE_CASE__MAIN_SCENARIO:
				return mainScenario != null;
			case UcmPackage.USE_CASE__BRANCHES:
				return branches != null && !branches.isEmpty();
			case UcmPackage.USE_CASE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case UcmPackage.USE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UcmPackage.USE_CASE__PRECEEDED:
				return preceeded != null && !preceeded.isEmpty();
			case UcmPackage.USE_CASE__PRIMARY:
				return primary != PRIMARY_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", primary: ");
		result.append(primary);
		result.append(')');
		return result.toString();
	}

} //UseCaseImpl
