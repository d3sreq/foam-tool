/**
 */
package org.foam.verification;

import org.foam.annotation.Annotation;

import org.foam.propositionallogic.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.verification.Action#isValue <em>Value</em>}</li>
 *   <li>{@link org.foam.verification.Action#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.verification.VerificationPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see org.foam.verification.VerificationPackage#getAction_Value()
	 * @model required="true"
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '{@link org.foam.verification.Action#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definition</em>' reference.
	 * @see #setVariableDefinition(VariableDefinition)
	 * @see org.foam.verification.VerificationPackage#getAction_VariableDefinition()
	 * @model required="true"
	 * @generated
	 */
	VariableDefinition getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.foam.verification.Action#getVariableDefinition <em>Variable Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' reference.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(VariableDefinition value);

} // Action
