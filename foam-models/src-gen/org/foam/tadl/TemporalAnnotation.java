/**
 */
package org.foam.tadl;

import org.foam.annotation.Annotation;

import org.foam.propositionallogic.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Temporal Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.tadl.TemporalAnnotation#getGroup <em>Group</em>}</li>
 *   <li>{@link org.foam.tadl.TemporalAnnotation#getVariableDefinition <em>Variable Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.tadl.TadlPackage#getTemporalAnnotation()
 * @model
 * @generated
 */
public interface TemporalAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' reference.
	 * @see #setGroup(Group)
	 * @see org.foam.tadl.TadlPackage#getTemporalAnnotation_Group()
	 * @model required="true"
	 * @generated
	 */
	Group getGroup();

	/**
	 * Sets the value of the '{@link org.foam.tadl.TemporalAnnotation#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(Group value);

	/**
	 * Returns the value of the '<em><b>Variable Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Definition</em>' reference.
	 * @see #setVariableDefinition(VariableDefinition)
	 * @see org.foam.tadl.TadlPackage#getTemporalAnnotation_VariableDefinition()
	 * @model required="true"
	 * @generated
	 */
	VariableDefinition getVariableDefinition();

	/**
	 * Sets the value of the '{@link org.foam.tadl.TemporalAnnotation#getVariableDefinition <em>Variable Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Definition</em>' reference.
	 * @see #getVariableDefinition()
	 * @generated
	 */
	void setVariableDefinition(VariableDefinition value);

} // TemporalAnnotation
