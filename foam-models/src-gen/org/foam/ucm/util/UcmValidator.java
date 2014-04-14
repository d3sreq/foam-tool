/**
 */
package org.foam.ucm.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.foam.ucm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.foam.ucm.UcmPackage
 * @generated
 */
public class UcmValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UcmValidator INSTANCE = new UcmValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.foam.ucm";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return UcmPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case UcmPackage.USE_CASE_MODEL:
				return validateUseCaseModel((UseCaseModel)value, diagnostics, context);
			case UcmPackage.USE_CASE:
				return validateUseCase((UseCase)value, diagnostics, context);
			case UcmPackage.STEP_TO_SCENARIO_HOLDER_MAP_ENTRY:
				return validateStepToScenarioHolderMapEntry((Map.Entry<?, ?>)value, diagnostics, context);
			case UcmPackage.SCENARIO:
				return validateScenario((Scenario)value, diagnostics, context);
			case UcmPackage.STEP:
				return validateStep((Step)value, diagnostics, context);
			case UcmPackage.SCENARIO_HOLDER:
				return validateScenarioHolder((ScenarioHolder)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCaseModel(UseCaseModel useCaseModel, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(useCaseModel, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(useCase, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCase_PrecedenceWithoutCycle(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCase_IncludeWithoutCycle(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCase_IncludedIsSubsetOfPreceeded(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCase_NoAbortInMainScenario(useCase, diagnostics, context);
		if (result || diagnostics != null) result &= validateUseCase_NoGotoInMainScenario(useCase, diagnostics, context);
		return result;
	}

	/**
	 * Validates the PrecedenceWithoutCycle constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_PrecedenceWithoutCycle(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "PrecedenceWithoutCycle", getObjectLabel(useCase, context) },
						 new Object[] { useCase },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the IncludeWithoutCycle constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_IncludeWithoutCycle(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "IncludeWithoutCycle", getObjectLabel(useCase, context) },
						 new Object[] { useCase },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the IncludedIsSubsetOfPreceeded constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_IncludedIsSubsetOfPreceeded(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "IncludedIsSubsetOfPreceeded", getObjectLabel(useCase, context) },
						 new Object[] { useCase },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the NoAbortInMainScenario constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_NoAbortInMainScenario(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "NoAbortInMainScenario", getObjectLabel(useCase, context) },
						 new Object[] { useCase },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the NoGotoInMainScenario constraint of '<em>Use Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUseCase_NoGotoInMainScenario(UseCase useCase, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "NoGotoInMainScenario", getObjectLabel(useCase, context) },
						 new Object[] { useCase },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStepToScenarioHolderMapEntry(Map.Entry<?, ?> stepToScenarioHolderMapEntry, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint((EObject)stepToScenarioHolderMapEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(scenario, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateScenario_AbortOnlyAtScenarioEnd(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateScenario_GotoOnlyAtScenarioEnd(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateScenario_OnlyOneOfAbortGotoAtScenarioEnd(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateScenario_GuardOnlyAtScenarioStart(scenario, diagnostics, context);
		return result;
	}

	/**
	 * Validates the AbortOnlyAtScenarioEnd constraint of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario_AbortOnlyAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "AbortOnlyAtScenarioEnd", getObjectLabel(scenario, context) },
						 new Object[] { scenario },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the GotoOnlyAtScenarioEnd constraint of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario_GotoOnlyAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "GotoOnlyAtScenarioEnd", getObjectLabel(scenario, context) },
						 new Object[] { scenario },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the OnlyOneOfAbortGotoAtScenarioEnd constraint of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario_OnlyOneOfAbortGotoAtScenarioEnd(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "OnlyOneOfAbortGotoAtScenarioEnd", getObjectLabel(scenario, context) },
						 new Object[] { scenario },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the GuardOnlyAtScenarioStart constraint of '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario_GuardOnlyAtScenarioStart(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false)
		{
			if (diagnostics != null)
			{
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "GuardOnlyAtScenarioStart", getObjectLabel(scenario, context) },
						 new Object[] { scenario },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStep(Step step, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(step, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenarioHolder(ScenarioHolder scenarioHolder, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(scenarioHolder, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //UcmValidator
