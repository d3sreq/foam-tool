/**
 */
package org.foam.propositionallogic.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foam.propositionallogic.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.foam.propositionallogic.PropositionallogicPackage
 * @generated
 */
public class PropositionallogicSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PropositionallogicPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionallogicSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = PropositionallogicPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case PropositionallogicPackage.VARIABLE_DEFINITION:
			{
				VariableDefinition variableDefinition = (VariableDefinition)theEObject;
				T result = caseVariableDefinition(variableDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.FORMULA:
			{
				Formula formula = (Formula)theEObject;
				T result = caseFormula(formula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.UNARY_FORMULA:
			{
				UnaryFormula unaryFormula = (UnaryFormula)theEObject;
				T result = caseUnaryFormula(unaryFormula);
				if (result == null) result = caseFormula(unaryFormula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.BINARY_FORMULA:
			{
				BinaryFormula binaryFormula = (BinaryFormula)theEObject;
				T result = caseBinaryFormula(binaryFormula);
				if (result == null) result = caseFormula(binaryFormula);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.NOT:
			{
				Not not = (Not)theEObject;
				T result = caseNot(not);
				if (result == null) result = caseUnaryFormula(not);
				if (result == null) result = caseFormula(not);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.AND:
			{
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseBinaryFormula(and);
				if (result == null) result = caseFormula(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.OR:
			{
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseBinaryFormula(or);
				if (result == null) result = caseFormula(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.IMPLICATION:
			{
				Implication implication = (Implication)theEObject;
				T result = caseImplication(implication);
				if (result == null) result = caseBinaryFormula(implication);
				if (result == null) result = caseFormula(implication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.EQUIVALENCE:
			{
				Equivalence equivalence = (Equivalence)theEObject;
				T result = caseEquivalence(equivalence);
				if (result == null) result = caseBinaryFormula(equivalence);
				if (result == null) result = caseFormula(equivalence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.VARIABLE_USE:
			{
				VariableUse variableUse = (VariableUse)theEObject;
				T result = caseVariableUse(variableUse);
				if (result == null) result = caseFormula(variableUse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.TRUE:
			{
				True true_ = (True)theEObject;
				T result = caseTrue(true_);
				if (result == null) result = caseFormula(true_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PropositionallogicPackage.FALSE:
			{
				False false_ = (False)theEObject;
				T result = caseFalse(false_);
				if (result == null) result = caseFormula(false_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDefinition(VariableDefinition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormula(Formula object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Formula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Formula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryFormula(UnaryFormula object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Formula</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Formula</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryFormula(BinaryFormula object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNot(Not object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implication</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplication(Implication object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equivalence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquivalence(Equivalence object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Use</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Use</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableUse(VariableUse object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrue(True object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalse(False object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //PropositionallogicSwitch
