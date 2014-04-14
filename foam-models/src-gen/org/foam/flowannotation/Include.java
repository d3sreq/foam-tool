/**
 */
package org.foam.flowannotation;

import org.foam.ucm.UseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.flowannotation.Include#getInlinedUseCase <em>Inlined Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.flowannotation.FlowannotationPackage#getInclude()
 * @model
 * @generated
 */
public interface Include extends FlowAnnotation
{
	/**
	 * Returns the value of the '<em><b>Inlined Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inlined Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inlined Use Case</em>' reference.
	 * @see #setInlinedUseCase(UseCase)
	 * @see org.foam.flowannotation.FlowannotationPackage#getInclude_InlinedUseCase()
	 * @model required="true"
	 * @generated
	 */
	UseCase getInlinedUseCase();

	/**
	 * Sets the value of the '{@link org.foam.flowannotation.Include#getInlinedUseCase <em>Inlined Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inlined Use Case</em>' reference.
	 * @see #getInlinedUseCase()
	 * @generated
	 */
	void setInlinedUseCase(UseCase value);

} // Include
