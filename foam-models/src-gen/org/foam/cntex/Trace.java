/**
 */
package org.foam.cntex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.cntex.Trace#getLoopStart <em>Loop Start</em>}</li>
 *   <li>{@link org.foam.cntex.Trace#getStates <em>States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.cntex.CntexPackage#getTrace()
 * @model
 * @generated
 */
public interface Trace extends EObject
{
	/**
	 * Returns the value of the '<em><b>Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Start</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Start</em>' reference.
	 * @see #setLoopStart(CntExState)
	 * @see org.foam.cntex.CntexPackage#getTrace_LoopStart()
	 * @model
	 * @generated
	 */
	CntExState getLoopStart();

	/**
	 * Sets the value of the '{@link org.foam.cntex.Trace#getLoopStart <em>Loop Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Start</em>' reference.
	 * @see #getLoopStart()
	 * @generated
	 */
	void setLoopStart(CntExState value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.cntex.CntExState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.foam.cntex.CntexPackage#getTrace_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<CntExState> getStates();

} // Trace
