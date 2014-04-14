/**
 */
package org.foam.cntex;

import org.eclipse.emf.common.util.EList;

import org.foam.annotation.Annotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cnt Ex State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.cntex.CntExState#getAssignments <em>Assignments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.cntex.CntexPackage#getCntExState()
 * @model
 * @generated
 */
public interface CntExState extends Annotable
{
	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.cntex.CntExAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see org.foam.cntex.CntexPackage#getCntExState_Assignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<CntExAssignment> getAssignments();

} // CntExState
