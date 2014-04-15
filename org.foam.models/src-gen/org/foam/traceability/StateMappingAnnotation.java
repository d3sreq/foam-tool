/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

import org.foam.lts.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Mapping Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.StateMappingAnnotation#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getStateMappingAnnotation()
 * @model
 * @generated
 */
public interface StateMappingAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference.
	 * @see #setState(State)
	 * @see org.foam.traceability.TraceabilityPackage#getStateMappingAnnotation_State()
	 * @model required="true"
	 * @generated
	 */
	State getState();

	/**
	 * Sets the value of the '{@link org.foam.traceability.StateMappingAnnotation#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(State value);

} // StateMappingAnnotation
