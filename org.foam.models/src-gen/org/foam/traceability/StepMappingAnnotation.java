/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

import org.foam.ucm.Step;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step Mapping Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.StepMappingAnnotation#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getStepMappingAnnotation()
 * @model
 * @generated
 */
public interface StepMappingAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' reference.
	 * @see #setStep(Step)
	 * @see org.foam.traceability.TraceabilityPackage#getStepMappingAnnotation_Step()
	 * @model required="true"
	 * @generated
	 */
	Step getStep();

	/**
	 * Sets the value of the '{@link org.foam.traceability.StepMappingAnnotation#getStep <em>Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' reference.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(Step value);

} // StepMappingAnnotation
