/**
 */
package org.foam.ltl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foam.ltl.*;

import org.foam.propositionallogic.BinaryFormula;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.UnaryFormula;

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
 * @see org.foam.ltl.LtlPackage
 * @generated
 */
public class LtlSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LtlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = LtlPackage.eINSTANCE;
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
			case LtlPackage.GLOBALLY:
			{
				Globally globally = (Globally)theEObject;
				T result = caseGlobally(globally);
				if (result == null) result = caseUnaryFormula(globally);
				if (result == null) result = caseFormula(globally);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.FUTURE:
			{
				Future future = (Future)theEObject;
				T result = caseFuture(future);
				if (result == null) result = caseUnaryFormula(future);
				if (result == null) result = caseFormula(future);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.NEXT:
			{
				Next next = (Next)theEObject;
				T result = caseNext(next);
				if (result == null) result = caseUnaryFormula(next);
				if (result == null) result = caseFormula(next);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.UNTIL:
			{
				Until until = (Until)theEObject;
				T result = caseUntil(until);
				if (result == null) result = caseBinaryFormula(until);
				if (result == null) result = caseFormula(until);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.HISTORICALLY:
			{
				Historically historically = (Historically)theEObject;
				T result = caseHistorically(historically);
				if (result == null) result = caseUnaryFormula(historically);
				if (result == null) result = caseFormula(historically);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.ONCE:
			{
				Once once = (Once)theEObject;
				T result = caseOnce(once);
				if (result == null) result = caseUnaryFormula(once);
				if (result == null) result = caseFormula(once);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.RELEASES:
			{
				Releases releases = (Releases)theEObject;
				T result = caseReleases(releases);
				if (result == null) result = caseBinaryFormula(releases);
				if (result == null) result = caseFormula(releases);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.SINCE:
			{
				Since since = (Since)theEObject;
				T result = caseSince(since);
				if (result == null) result = caseBinaryFormula(since);
				if (result == null) result = caseFormula(since);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LtlPackage.TRIGGERED:
			{
				Triggered triggered = (Triggered)theEObject;
				T result = caseTriggered(triggered);
				if (result == null) result = caseBinaryFormula(triggered);
				if (result == null) result = caseFormula(triggered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Globally</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Globally</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGlobally(Globally object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Future</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Future</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuture(Future object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Next</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Next</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNext(Next object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUntil(Until object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Historically</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Historically</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistorically(Historically object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Once</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Once</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOnce(Once object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Releases</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Releases</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReleases(Releases object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Since</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Since</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSince(Since object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Triggered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Triggered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriggered(Triggered object)
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

} //LtlSwitch
