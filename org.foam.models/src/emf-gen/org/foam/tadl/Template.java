/**
 */
package org.foam.tadl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.foam.propositionallogic.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.tadl.Template#getFormulaHolders <em>Formula Holders</em>}</li>
 *   <li>{@link org.foam.tadl.Template#getVariableDefinitions <em>Variable Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.tadl.TadlPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject
{
	/**
	 * Returns the value of the '<em><b>Formula Holders</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.tadl.FormulaHolder}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula Holders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula Holders</em>' containment reference list.
	 * @see org.foam.tadl.TadlPackage#getTemplate_FormulaHolders()
	 * @model containment="true"
	 * @generated
	 */
	EList<FormulaHolder> getFormulaHolders();

	/**
	 * Returns the value of the '<em><b>Variable Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.propositionallogic.VariableDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definitions</em>' containment reference list.
	 * @see org.foam.tadl.TadlPackage#getTemplate_VariableDefinitions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableDefinition> getVariableDefinitions();

} // Template
