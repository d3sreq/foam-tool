/**
 */
package org.foam.dot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inner Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.dot.InnerNode#getRecordNode <em>Record Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.dot.DotPackage#getInnerNode()
 * @model
 * @generated
 */
public interface InnerNode extends Node
{
	/**
	 * Returns the value of the '<em><b>Record Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.foam.dot.RecordNode#getInnerNodes <em>Inner Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Node</em>' container reference.
	 * @see #setRecordNode(RecordNode)
	 * @see org.foam.dot.DotPackage#getInnerNode_RecordNode()
	 * @see org.foam.dot.RecordNode#getInnerNodes
	 * @model opposite="innerNodes" required="true" transient="false"
	 * @generated
	 */
	RecordNode getRecordNode();

	/**
	 * Sets the value of the '{@link org.foam.dot.InnerNode#getRecordNode <em>Record Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Node</em>' container reference.
	 * @see #getRecordNode()
	 * @generated
	 */
	void setRecordNode(RecordNode value);

} // InnerNode
