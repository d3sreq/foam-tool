/**
 */
package org.foam.flowannotation;

import org.foam.propositionallogic.Formula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.flowannotation.Guard#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.flowannotation.FlowannotationPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends FlowAnnotation
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
	 * @see org.foam.flowannotation.FlowannotationPackage#getGuard_Formula()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link org.foam.flowannotation.Guard#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

} // Guard
