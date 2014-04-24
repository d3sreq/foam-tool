/**
 */
package org.foam.propositionallogic;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.propositionallogic.UnaryFormula#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.propositionallogic.PropositionallogicPackage#getUnaryFormula()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface UnaryFormula extends Formula
{
	/**
	 * Returns the value of the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' containment reference.
	 * @see #setFormula(Formula)
	 * @see org.foam.propositionallogic.PropositionallogicPackage#getUnaryFormula_Formula()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link org.foam.propositionallogic.UnaryFormula#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

} // UnaryFormula
