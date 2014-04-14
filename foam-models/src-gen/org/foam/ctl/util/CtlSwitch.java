/**
 */
package org.foam.ctl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foam.ctl.*;

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
 * @see org.foam.ctl.CtlPackage
 * @generated
 */
public class CtlSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CtlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CtlSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = CtlPackage.eINSTANCE;
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
			case CtlPackage.ALL_UNTIL:
			{
				AllUntil allUntil = (AllUntil)theEObject;
				T result = caseAllUntil(allUntil);
				if (result == null) result = caseBinaryFormula(allUntil);
				if (result == null) result = caseFormula(allUntil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.EXISTS_UNTIL:
			{
				ExistsUntil existsUntil = (ExistsUntil)theEObject;
				T result = caseExistsUntil(existsUntil);
				if (result == null) result = caseBinaryFormula(existsUntil);
				if (result == null) result = caseFormula(existsUntil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.ALL_GLOBALLY:
			{
				AllGlobally allGlobally = (AllGlobally)theEObject;
				T result = caseAllGlobally(allGlobally);
				if (result == null) result = caseUnaryFormula(allGlobally);
				if (result == null) result = caseFormula(allGlobally);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.ALL_FINALLY:
			{
				AllFinally allFinally = (AllFinally)theEObject;
				T result = caseAllFinally(allFinally);
				if (result == null) result = caseUnaryFormula(allFinally);
				if (result == null) result = caseFormula(allFinally);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.ALL_NEXT:
			{
				AllNext allNext = (AllNext)theEObject;
				T result = caseAllNext(allNext);
				if (result == null) result = caseUnaryFormula(allNext);
				if (result == null) result = caseFormula(allNext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.EXISTS_GLOBALLY:
			{
				ExistsGlobally existsGlobally = (ExistsGlobally)theEObject;
				T result = caseExistsGlobally(existsGlobally);
				if (result == null) result = caseUnaryFormula(existsGlobally);
				if (result == null) result = caseFormula(existsGlobally);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.EXISTS_FINALLY:
			{
				ExistsFinally existsFinally = (ExistsFinally)theEObject;
				T result = caseExistsFinally(existsFinally);
				if (result == null) result = caseUnaryFormula(existsFinally);
				if (result == null) result = caseFormula(existsFinally);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CtlPackage.EXISTS_NEXT:
			{
				ExistsNext existsNext = (ExistsNext)theEObject;
				T result = caseExistsNext(existsNext);
				if (result == null) result = caseUnaryFormula(existsNext);
				if (result == null) result = caseFormula(existsNext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllUntil(AllUntil object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Until</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Until</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsUntil(ExistsUntil object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Globally</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Globally</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllGlobally(AllGlobally object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Finally</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Finally</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllFinally(AllFinally object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Next</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Next</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllNext(AllNext object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Globally</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Globally</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsGlobally(ExistsGlobally object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Finally</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Finally</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsFinally(ExistsFinally object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exists Next</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exists Next</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistsNext(ExistsNext object)
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

} //CtlSwitch
