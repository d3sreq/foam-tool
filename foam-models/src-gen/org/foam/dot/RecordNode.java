/**
 */
package org.foam.dot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.dot.RecordNode#getInnerNodes <em>Inner Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.dot.DotPackage#getRecordNode()
 * @model
 * @generated
 */
public interface RecordNode extends Node
{
	/**
	 * Returns the value of the '<em><b>Inner Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.dot.InnerNode}.
	 * It is bidirectional and its opposite is '{@link org.foam.dot.InnerNode#getRecordNode <em>Record Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * InnerNodes cannot be instances of the RecordNode class - nesting isn't allowed.
	 * Id of the inner node must have port set - e.g. "step1:OUT".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inner Nodes</em>' containment reference list.
	 * @see org.foam.dot.DotPackage#getRecordNode_InnerNodes()
	 * @see org.foam.dot.InnerNode#getRecordNode
	 * @model opposite="recordNode" containment="true" ordered="false"
	 * @generated
	 */
	EList<InnerNode> getInnerNodes();

} // RecordNode
