/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Type Mapping Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.StateTypeMappingAnnotation#getStateType <em>State Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getStateTypeMappingAnnotation()
 * @model
 * @generated
 */
public interface StateTypeMappingAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>State Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.foam.traceability.StateType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Type</em>' attribute.
	 * @see org.foam.traceability.StateType
	 * @see #setStateType(StateType)
	 * @see org.foam.traceability.TraceabilityPackage#getStateTypeMappingAnnotation_StateType()
	 * @model required="true"
	 * @generated
	 */
	StateType getStateType();

	/**
	 * Sets the value of the '{@link org.foam.traceability.StateTypeMappingAnnotation#getStateType <em>State Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Type</em>' attribute.
	 * @see org.foam.traceability.StateType
	 * @see #getStateType()
	 * @generated
	 */
	void setStateType(StateType value);

} // StateTypeMappingAnnotation
