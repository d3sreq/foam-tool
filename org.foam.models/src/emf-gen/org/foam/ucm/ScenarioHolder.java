/**
 */
package org.foam.ucm;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.ucm.ScenarioHolder#getExtensions <em>Extensions</em>}</li>
 *   <li>{@link org.foam.ucm.ScenarioHolder#getVariations <em>Variations</em>}</li>
 *   <li>{@link org.foam.ucm.ScenarioHolder#getBranches <em>Branches</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.ucm.UcmPackage#getScenarioHolder()
 * @model
 * @generated
 */
public interface ScenarioHolder extends EObject
{
	/**
	 * Returns the value of the '<em><b>Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.ucm.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extensions</em>' containment reference list.
	 * @see org.foam.ucm.UcmPackage#getScenarioHolder_Extensions()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#branches'"
	 * @generated
	 */
	EList<Scenario> getExtensions();

	/**
	 * Returns the value of the '<em><b>Variations</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.ucm.Scenario}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variations</em>' containment reference list.
	 * @see org.foam.ucm.UcmPackage#getScenarioHolder_Variations()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="group='#branches'"
	 * @generated
	 */
	EList<Scenario> getVariations();

	/**
	 * Returns the value of the '<em><b>Branches</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' attribute list.
	 * @see org.foam.ucm.UcmPackage#getScenarioHolder_Branches()
	 * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group'"
	 * @generated
	 */
	FeatureMap getBranches();

} // ScenarioHolder
