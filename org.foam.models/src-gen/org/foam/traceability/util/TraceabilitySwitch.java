/**
 */
package org.foam.traceability.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.foam.annotation.Annotation;

import org.foam.traceability.*;

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
 * @see org.foam.traceability.TraceabilityPackage
 * @generated
 */
public class TraceabilitySwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TraceabilityPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilitySwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = TraceabilityPackage.eINSTANCE;
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
			case TraceabilityPackage.STEP_MAPPING_ANNOTATION:
			{
				StepMappingAnnotation stepMappingAnnotation = (StepMappingAnnotation)theEObject;
				T result = caseStepMappingAnnotation(stepMappingAnnotation);
				if (result == null) result = caseAnnotation(stepMappingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TraceabilityPackage.STATE_TYPE_MAPPING_ANNOTATION:
			{
				StateTypeMappingAnnotation stateTypeMappingAnnotation = (StateTypeMappingAnnotation)theEObject;
				T result = caseStateTypeMappingAnnotation(stateTypeMappingAnnotation);
				if (result == null) result = caseAnnotation(stateTypeMappingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TraceabilityPackage.USE_CASE_MAPPING_ANNOTATION:
			{
				UseCaseMappingAnnotation useCaseMappingAnnotation = (UseCaseMappingAnnotation)theEObject;
				T result = caseUseCaseMappingAnnotation(useCaseMappingAnnotation);
				if (result == null) result = caseAnnotation(useCaseMappingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION:
			{
				OverviewTransitionTypeAnnotation overviewTransitionTypeAnnotation = (OverviewTransitionTypeAnnotation)theEObject;
				T result = caseOverviewTransitionTypeAnnotation(overviewTransitionTypeAnnotation);
				if (result == null) result = caseAnnotation(overviewTransitionTypeAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TraceabilityPackage.STATE_MAPPING_ANNOTATION:
			{
				StateMappingAnnotation stateMappingAnnotation = (StateMappingAnnotation)theEObject;
				T result = caseStateMappingAnnotation(stateMappingAnnotation);
				if (result == null) result = caseAnnotation(stateMappingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION:
			{
				FormulaIdentificationAnnotation formulaIdentificationAnnotation = (FormulaIdentificationAnnotation)theEObject;
				T result = caseFormulaIdentificationAnnotation(formulaIdentificationAnnotation);
				if (result == null) result = caseAnnotation(formulaIdentificationAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Mapping Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepMappingAnnotation(StepMappingAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Type Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Type Mapping Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateTypeMappingAnnotation(StateTypeMappingAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Case Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Case Mapping Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseCaseMappingAnnotation(UseCaseMappingAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overview Transition Type Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overview Transition Type Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverviewTransitionTypeAnnotation(OverviewTransitionTypeAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Mapping Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMappingAnnotation(StateMappingAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Formula Identification Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Formula Identification Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFormulaIdentificationAnnotation(FormulaIdentificationAnnotation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object)
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

} //TraceabilitySwitch
