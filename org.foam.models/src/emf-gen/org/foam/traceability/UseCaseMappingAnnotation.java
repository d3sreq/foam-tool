/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

import org.foam.ucm.UseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Mapping Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.UseCaseMappingAnnotation#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getUseCaseMappingAnnotation()
 * @model
 * @generated
 */
public interface UseCaseMappingAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' reference.
	 * @see #setUseCase(UseCase)
	 * @see org.foam.traceability.TraceabilityPackage#getUseCaseMappingAnnotation_UseCase()
	 * @model required="true"
	 * @generated
	 */
	UseCase getUseCase();

	/**
	 * Sets the value of the '{@link org.foam.traceability.UseCaseMappingAnnotation#getUseCase <em>Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case</em>' reference.
	 * @see #getUseCase()
	 * @generated
	 */
	void setUseCase(UseCase value);

} // UseCaseMappingAnnotation
