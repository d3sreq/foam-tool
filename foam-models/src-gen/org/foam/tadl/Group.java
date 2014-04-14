/**
 */
package org.foam.tadl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.tadl.Group#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.foam.tadl.Group#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.tadl.TadlPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends EObject
{
	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #setQualifier(String)
	 * @see org.foam.tadl.TadlPackage#getGroup_Qualifier()
	 * @model unique="false" id="true" required="true"
	 * @generated
	 */
	String getQualifier();

	/**
	 * Sets the value of the '{@link org.foam.tadl.Group#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(Template)
	 * @see org.foam.tadl.TadlPackage#getGroup_Template()
	 * @model required="true"
	 * @generated
	 */
	Template getTemplate();

	/**
	 * Sets the value of the '{@link org.foam.tadl.Group#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(Template value);

} // Group
