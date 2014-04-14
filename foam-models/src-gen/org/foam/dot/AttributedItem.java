/**
 */
package org.foam.dot;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributed Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.dot.AttributedItem#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.dot.DotPackage#getAttributedItem()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AttributedItem extends EObject
{
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' map.
	 * @see org.foam.dot.DotPackage#getAttributedItem_Attributes()
	 * @model mapType="org.foam.dot.StringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>"
	 * @generated
	 */
	EMap<String, String> getAttributes();

} // AttributedItem
