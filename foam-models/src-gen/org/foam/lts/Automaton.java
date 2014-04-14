/**
 */
package org.foam.lts;

import org.eclipse.emf.common.util.EList;

import org.foam.annotation.Annotable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Automaton</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.foam.lts.Automaton#getStates <em>States</em>}</li>
 *   <li>{@link org.foam.lts.Automaton#getInitState <em>Init State</em>}</li>
 *   <li>{@link org.foam.lts.Automaton#getTransitions <em>Transitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.foam.lts.LtsPackage#getAutomaton()
 * @model
 * @generated
 */
public interface Automaton extends Annotable
{
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.lts.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.foam.lts.LtsPackage#getAutomaton_States()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Init State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init State</em>' reference.
	 * @see #setInitState(State)
	 * @see org.foam.lts.LtsPackage#getAutomaton_InitState()
	 * @model required="true"
	 * @generated
	 */
	State getInitState();

	/**
	 * Sets the value of the '{@link org.foam.lts.Automaton#getInitState <em>Init State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init State</em>' reference.
	 * @see #getInitState()
	 * @generated
	 */
	void setInitState(State value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.foam.lts.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.foam.lts.LtsPackage#getAutomaton_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

} // Automaton
