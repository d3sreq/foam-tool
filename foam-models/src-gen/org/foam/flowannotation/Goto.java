/**
 */
package org.foam.flowannotation;

import org.foam.ucm.Step;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goto</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.flowannotation.Goto#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.flowannotation.FlowannotationPackage#getGoto()
 * @model
 * @generated
 */
public interface Goto extends FlowAnnotation
{
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Step)
	 * @see org.foam.flowannotation.FlowannotationPackage#getGoto_Target()
	 * @model required="true"
	 * @generated
	 */
	Step getTarget();

	/**
	 * Sets the value of the '{@link org.foam.flowannotation.Goto#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Step value);

} // Goto
