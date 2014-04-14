/**
 */
package org.foam.ucm.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.ucm.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UcmFactoryImpl extends EFactoryImpl implements UcmFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UcmFactory init()
	{
		try
		{
			UcmFactory theUcmFactory = (UcmFactory)EPackage.Registry.INSTANCE.getEFactory(UcmPackage.eNS_URI);
			if (theUcmFactory != null)
			{
				return theUcmFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UcmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case UcmPackage.USE_CASE_MODEL: return createUseCaseModel();
			case UcmPackage.USE_CASE: return createUseCase();
			case UcmPackage.STEP_TO_SCENARIO_HOLDER_MAP_ENTRY: return (EObject)createStepToScenarioHolderMapEntry();
			case UcmPackage.SCENARIO: return createScenario();
			case UcmPackage.STEP: return createStep();
			case UcmPackage.SCENARIO_HOLDER: return createScenarioHolder();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseModel createUseCaseModel()
	{
		UseCaseModelImpl useCaseModel = new UseCaseModelImpl();
		return useCaseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase()
	{
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<Step, ScenarioHolder> createStepToScenarioHolderMapEntry()
	{
		StepToScenarioHolderMapEntryImpl stepToScenarioHolderMapEntry = new StepToScenarioHolderMapEntryImpl();
		return stepToScenarioHolderMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario()
	{
		ScenarioImplCustom scenario = new ScenarioImplCustom();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step createStep()
	{
		StepImplCustom step = new StepImplCustom();
		return step;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioHolder createScenarioHolder()
	{
		ScenarioHolderImpl scenarioHolder = new ScenarioHolderImpl();
		return scenarioHolder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmPackage getUcmPackage()
	{
		return (UcmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UcmPackage getPackage()
	{
		return UcmPackage.eINSTANCE;
	}

} //UcmFactoryImpl
