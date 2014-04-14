/**
 */
package org.foam.cntex;

import org.foam.annotation.Annotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.cntex.Specification#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.foam.cntex.Specification#getTextFormula <em>Text Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.cntex.CntexPackage#getSpecification()
 * @model
 * @generated
 */
public interface Specification extends Annotable
{
	/**
	 * Returns the value of the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace</em>' containment reference.
	 * @see #setTrace(Trace)
	 * @see org.foam.cntex.CntexPackage#getSpecification_Trace()
	 * @model containment="true"
	 * @generated
	 */
	Trace getTrace();

	/**
	 * Sets the value of the '{@link org.foam.cntex.Specification#getTrace <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace</em>' containment reference.
	 * @see #getTrace()
	 * @generated
	 */
	void setTrace(Trace value);

	/**
	 * Returns the value of the '<em><b>Text Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Formula</em>' attribute.
	 * @see #setTextFormula(String)
	 * @see org.foam.cntex.CntexPackage#getSpecification_TextFormula()
	 * @model required="true"
	 * @generated
	 */
	String getTextFormula();

	/**
	 * Sets the value of the '{@link org.foam.cntex.Specification#getTextFormula <em>Text Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Formula</em>' attribute.
	 * @see #getTextFormula()
	 * @generated
	 */
	void setTextFormula(String value);

} // Specification
