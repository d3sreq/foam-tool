/**
 */
package org.foam.dot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.dot.Settings#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.dot.DotPackage#getSettings()
 * @model
 * @generated
 */
public interface Settings extends Statement, AttributedItem
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.foam.dot.SettingsType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.foam.dot.SettingsType
	 * @see #setType(SettingsType)
	 * @see org.foam.dot.DotPackage#getSettings_Type()
	 * @model required="true"
	 * @generated
	 */
	SettingsType getType();

	/**
	 * Sets the value of the '{@link org.foam.dot.Settings#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.foam.dot.SettingsType
	 * @see #getType()
	 * @generated
	 */
	void setType(SettingsType value);

} // Settings
