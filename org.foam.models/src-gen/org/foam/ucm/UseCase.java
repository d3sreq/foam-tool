/**
 */
package org.foam.ucm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.ucm.UseCase#getMainScenario <em>Main Scenario</em>}</li>
 *   <li>{@link org.foam.ucm.UseCase#getBranches <em>Branches</em>}</li>
 *   <li>{@link org.foam.ucm.UseCase#getId <em>Id</em>}</li>
 *   <li>{@link org.foam.ucm.UseCase#getName <em>Name</em>}</li>
 *   <li>{@link org.foam.ucm.UseCase#getPreceeded <em>Preceeded</em>}</li>
 *   <li>{@link org.foam.ucm.UseCase#isPrimary <em>Primary</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.ucm.UcmPackage#getUseCase()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='PrecedenceWithoutCycle IncludeWithoutCycle IncludedIsSubsetOfPreceeded NoAbortInMainScenario NoGotoInMainScenario'"
 * @generated
 */
public interface UseCase extends EObject
{
	/**
	 * Returns the value of the '<em><b>Main Scenario</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Scenario</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Scenario</em>' containment reference.
	 * @see #setMainScenario(Scenario)
	 * @see org.foam.ucm.UcmPackage#getUseCase_MainScenario()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Scenario getMainScenario();

	/**
	 * Sets the value of the '{@link org.foam.ucm.UseCase#getMainScenario <em>Main Scenario</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Scenario</em>' containment reference.
	 * @see #getMainScenario()
	 * @generated
	 */
	void setMainScenario(Scenario value);

	/**
	 * Returns the value of the '<em><b>Branches</b></em>' map.
	 * The key is of type {@link org.foam.ucm.Step},
	 * and the value is of type {@link org.foam.ucm.ScenarioHolder},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' map.
	 * @see org.foam.ucm.UcmPackage#getUseCase_Branches()
	 * @model mapType="org.foam.ucm.StepToScenarioHolderMapEntry<org.foam.ucm.Step, org.foam.ucm.ScenarioHolder>"
	 * @generated
	 */
	EMap<Step, ScenarioHolder> getBranches();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.foam.ucm.UcmPackage#getUseCase_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.foam.ucm.UseCase#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.foam.ucm.UcmPackage#getUseCase_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.foam.ucm.UseCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Preceeded</b></em>' reference list.
	 * The list contents are of type {@link org.foam.ucm.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preceeded</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preceeded</em>' reference list.
	 * @see org.foam.ucm.UcmPackage#getUseCase_Preceeded()
	 * @model
	 * @generated
	 */
	EList<UseCase> getPreceeded();

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(boolean)
	 * @see org.foam.ucm.UcmPackage#getUseCase_Primary()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isPrimary();

	/**
	 * Sets the value of the '{@link org.foam.ucm.UseCase#isPrimary <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' attribute.
	 * @see #isPrimary()
	 * @generated
	 */
	void setPrimary(boolean value);

} // UseCase
