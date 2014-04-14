/**
 */
package org.foam.traceability.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.traceability.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceabilityFactoryImpl extends EFactoryImpl implements TraceabilityFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TraceabilityFactory init()
	{
		try
		{
			TraceabilityFactory theTraceabilityFactory = (TraceabilityFactory)EPackage.Registry.INSTANCE.getEFactory(TraceabilityPackage.eNS_URI);
			if (theTraceabilityFactory != null)
			{
				return theTraceabilityFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TraceabilityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityFactoryImpl()
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
			case TraceabilityPackage.STEP_MAPPING_ANNOTATION: return createStepMappingAnnotation();
			case TraceabilityPackage.STATE_TYPE_MAPPING_ANNOTATION: return createStateTypeMappingAnnotation();
			case TraceabilityPackage.USE_CASE_MAPPING_ANNOTATION: return createUseCaseMappingAnnotation();
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE_ANNOTATION: return createOverviewTransitionTypeAnnotation();
			case TraceabilityPackage.STATE_MAPPING_ANNOTATION: return createStateMappingAnnotation();
			case TraceabilityPackage.FORMULA_IDENTIFICATION_ANNOTATION: return createFormulaIdentificationAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TraceabilityPackage.STATE_TYPE:
				return createStateTypeFromString(eDataType, initialValue);
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE:
				return createOverviewTransitionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case TraceabilityPackage.STATE_TYPE:
				return convertStateTypeToString(eDataType, instanceValue);
			case TraceabilityPackage.OVERVIEW_TRANSITION_TYPE:
				return convertOverviewTransitionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepMappingAnnotation createStepMappingAnnotation()
	{
		StepMappingAnnotationImpl stepMappingAnnotation = new StepMappingAnnotationImpl();
		return stepMappingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateTypeMappingAnnotation createStateTypeMappingAnnotation()
	{
		StateTypeMappingAnnotationImpl stateTypeMappingAnnotation = new StateTypeMappingAnnotationImpl();
		return stateTypeMappingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseMappingAnnotation createUseCaseMappingAnnotation()
	{
		UseCaseMappingAnnotationImpl useCaseMappingAnnotation = new UseCaseMappingAnnotationImpl();
		return useCaseMappingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewTransitionTypeAnnotation createOverviewTransitionTypeAnnotation()
	{
		OverviewTransitionTypeAnnotationImpl overviewTransitionTypeAnnotation = new OverviewTransitionTypeAnnotationImpl();
		return overviewTransitionTypeAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMappingAnnotation createStateMappingAnnotation()
	{
		StateMappingAnnotationImpl stateMappingAnnotation = new StateMappingAnnotationImpl();
		return stateMappingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormulaIdentificationAnnotation createFormulaIdentificationAnnotation()
	{
		FormulaIdentificationAnnotationImpl formulaIdentificationAnnotation = new FormulaIdentificationAnnotationImpl();
		return formulaIdentificationAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateType createStateTypeFromString(EDataType eDataType, String initialValue)
	{
		StateType result = StateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OverviewTransitionType createOverviewTransitionTypeFromString(EDataType eDataType, String initialValue)
	{
		OverviewTransitionType result = OverviewTransitionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOverviewTransitionTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityPackage getTraceabilityPackage()
	{
		return (TraceabilityPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TraceabilityPackage getPackage()
	{
		return TraceabilityPackage.eINSTANCE;
	}

} //TraceabilityFactoryImpl
