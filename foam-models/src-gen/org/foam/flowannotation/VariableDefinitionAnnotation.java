/**
 */
package org.foam.flowannotation;

import org.foam.annotation.Annotation;

import org.foam.propositionallogic.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Definition Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.flowannotation.VariableDefinitionAnnotation#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.flowannotation.FlowannotationPackage#getVariableDefinitionAnnotation()
 * @model
 * @generated
 */
public interface VariableDefinitionAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Variable Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definition</em>' containment reference.
	 * @see #setVariableDefinition(VariableDefinition)
	 * @see org.foam.flowannotation.FlowannotationPackage#getVariableDefinitionAnnotation_VariableDefinition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDefinition getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.foam.flowannotation.VariableDefinitionAnnotation#getVariableDefinition <em>Variable Definition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' containment reference.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(VariableDefinition value);

} // VariableDefinitionAnnotation
