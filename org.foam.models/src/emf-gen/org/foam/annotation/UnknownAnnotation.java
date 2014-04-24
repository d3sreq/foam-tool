/**
 */
package org.foam.annotation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unknown Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.annotation.UnknownAnnotation#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.annotation.AnnotationPackage#getUnknownAnnotation()
 * @model
 * @generated
 */
public interface UnknownAnnotation extends Annotation
{
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' attribute list.
	 * @see org.foam.annotation.AnnotationPackage#getUnknownAnnotation_Parts()
	 * @model
	 * @generated
	 */
	EList<String> getParts();

} // UnknownAnnotation
