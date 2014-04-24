/**
 */
package org.foam.traceability;

import org.foam.annotation.Annotation;

import org.foam.tadl.FormulaHolder;
import org.foam.tadl.Group;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula Identification Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.traceability.FormulaIdentificationAnnotation#getGroup <em>Group</em>}</li>
 *   <li>{@link org.foam.traceability.FormulaIdentificationAnnotation#getFormulaHolder <em>Formula Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.traceability.TraceabilityPackage#getFormulaIdentificationAnnotation()
 * @model
 * @generated
 */
public interface FormulaIdentificationAnnotation extends Annotation
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
	 * @see org.foam.traceability.TraceabilityPackage#getFormulaIdentificationAnnotation_Group()
	 * @model required="true"
	 * @generated
	 */
	Group getGroup();

	/**
	 * Sets the value of the '{@link org.foam.traceability.FormulaIdentificationAnnotation#getGroup <em>Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(Group value);

	/**
	 * Returns the value of the '<em><b>Formula Holder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula Holder</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula Holder</em>' reference.
	 * @see #setFormulaHolder(FormulaHolder)
	 * @see org.foam.traceability.TraceabilityPackage#getFormulaIdentificationAnnotation_FormulaHolder()
	 * @model required="true"
	 * @generated
	 */
	FormulaHolder getFormulaHolder();

	/**
	 * Sets the value of the '{@link org.foam.traceability.FormulaIdentificationAnnotation#getFormulaHolder <em>Formula Holder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula Holder</em>' reference.
	 * @see #getFormulaHolder()
	 * @generated
	 */
	void setFormulaHolder(FormulaHolder value);

} // FormulaIdentificationAnnotation
