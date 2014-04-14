/**
 */
package org.foam.ucm;

import org.eclipse.emf.common.util.EList;

import org.foam.annotation.Annotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.ucm.UseCaseModel#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.ucm.UcmPackage#getUseCaseModel()
 * @model
 * @generated
 */
public interface UseCaseModel extends Annotable
{
	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.ucm.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' containment reference list.
	 * @see org.foam.ucm.UcmPackage#getUseCaseModel_UseCases()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // UseCaseModel
