/**
 */
package org.foam.propositionallogic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.propositionallogic.VariableUse#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.propositionallogic.PropositionallogicPackage#getVariableUse()
 * @model
 * @generated
 */
public interface VariableUse extends Formula
{
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
	 * @see org.foam.propositionallogic.PropositionallogicPackage#getVariableUse_VariableDefinition()
	 * @model required="true"
	 * @generated
	 */
	VariableDefinition getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.foam.propositionallogic.VariableUse#getVariableDefinition <em>Variable Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' reference.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(VariableDefinition value);

} // VariableUse
