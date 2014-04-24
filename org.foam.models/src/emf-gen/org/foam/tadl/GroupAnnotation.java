/**
 */
package org.foam.tadl;

import org.foam.annotation.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.tadl.GroupAnnotation#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.tadl.TadlPackage#getGroupAnnotation()
 * @model
 * @generated
 */
public interface GroupAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' containment reference.
	 * @see #setGroup(Group)
	 * @see org.foam.tadl.TadlPackage#getGroupAnnotation_Group()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Group getGroup();

	/**
	 * Sets the value of the '{@link org.foam.tadl.GroupAnnotation#getGroup <em>Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' containment reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(Group value);

} // GroupAnnotation
