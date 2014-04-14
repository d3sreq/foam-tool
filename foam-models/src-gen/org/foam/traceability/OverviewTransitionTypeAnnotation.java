/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overview Transition Type Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.OverviewTransitionTypeAnnotation#getOverviewTransitionType <em>Overview Transition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getOverviewTransitionTypeAnnotation()
 * @model
 * @generated
 */
public interface OverviewTransitionTypeAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Overview Transition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.foam.traceability.OverviewTransitionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overview Transition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overview Transition Type</em>' attribute.
	 * @see org.foam.traceability.OverviewTransitionType
	 * @see #setOverviewTransitionType(OverviewTransitionType)
	 * @see org.foam.traceability.TraceabilityPackage#getOverviewTransitionTypeAnnotation_OverviewTransitionType()
	 * @model required="true"
	 * @generated
	 */
	OverviewTransitionType getOverviewTransitionType();

	/**
	 * Sets the value of the '{@link org.foam.traceability.OverviewTransitionTypeAnnotation#getOverviewTransitionType <em>Overview Transition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overview Transition Type</em>' attribute.
	 * @see org.foam.traceability.OverviewTransitionType
	 * @see #getOverviewTransitionType()
	 * @generated
	 */
	void setOverviewTransitionType(OverviewTransitionType value);

} // OverviewTransitionTypeAnnotation
