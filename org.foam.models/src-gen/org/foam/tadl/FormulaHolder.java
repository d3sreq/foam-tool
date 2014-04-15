/**
 */
package org.foam.tadl;

import org.eclipse.emf.ecore.EObject;

import org.foam.propositionallogic.Formula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula Holder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.tadl.FormulaHolder#getComment <em>Comment</em>}</li>
 *   <li>{@link org.foam.tadl.FormulaHolder#getFormulaType <em>Formula Type</em>}</li>
 *   <li>{@link org.foam.tadl.FormulaHolder#getFormula <em>Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.tadl.TadlPackage#getFormulaHolder()
 * @model
 * @generated
 */
public interface FormulaHolder extends EObject
{
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.foam.tadl.TadlPackage#getFormulaHolder_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.foam.tadl.FormulaHolder#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Formula Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.foam.tadl.FormulaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula Type</em>' attribute.
	 * @see org.foam.tadl.FormulaType
	 * @see #setFormulaType(FormulaType)
	 * @see org.foam.tadl.TadlPackage#getFormulaHolder_FormulaType()
	 * @model required="true"
	 * @generated
	 */
	FormulaType getFormulaType();

	/**
	 * Sets the value of the '{@link org.foam.tadl.FormulaHolder#getFormulaType <em>Formula Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula Type</em>' attribute.
	 * @see org.foam.tadl.FormulaType
	 * @see #getFormulaType()
	 * @generated
	 */
	void setFormulaType(FormulaType value);

	/**
	 * Returns the value of the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formula</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formula</em>' containment reference.
	 * @see #setFormula(Formula)
	 * @see org.foam.tadl.TadlPackage#getFormulaHolder_Formula()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Formula getFormula();

	/**
	 * Sets the value of the '{@link org.foam.tadl.FormulaHolder#getFormula <em>Formula</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Formula</em>' containment reference.
	 * @see #getFormula()
	 * @generated
	 */
	void setFormula(Formula value);

} // FormulaHolder
