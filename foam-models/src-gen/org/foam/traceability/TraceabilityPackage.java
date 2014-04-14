/**
 */
package org.foam.traceability;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.foam.annotation.AnnotationPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.foam.traceability.TraceabilityFactory
 * @model kind="package"
 * @generated
 */
public interface TraceabilityPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "traceability";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "traceability";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "traceability";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceabilityPackage eINSTANCE = org.foam.traceability.impl.TraceabilityPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.StepMappingAnnotationImpl <em>Step Mapping Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.StepMappingAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStepMappingAnnotation()
	 * @generated
	 */
	int STEP_MAPPING_ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_MAPPING_ANNOTATION__STEP = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_MAPPING_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Step Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_MAPPING_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.StateTypeMappingAnnotationImpl <em>State Type Mapping Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.StateTypeMappingAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateTypeMappingAnnotation()
	 * @generated
	 */
	int STATE_TYPE_MAPPING_ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>State Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE_MAPPING_ANNOTATION__STATE_TYPE = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Type Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE_MAPPING_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>State Type Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_TYPE_MAPPING_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.UseCaseMappingAnnotationImpl <em>Use Case Mapping Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.UseCaseMappingAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getUseCaseMappingAnnotation()
	 * @generated
	 */
	int USE_CASE_MAPPING_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAPPING_ANNOTATION__USE_CASE = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Use Case Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAPPING_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Use Case Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_MAPPING_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.OverviewTransitionTypeAnnotationImpl <em>Overview Transition Type Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.OverviewTransitionTypeAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getOverviewTransitionTypeAnnotation()
	 * @generated
	 */
	int OVERVIEW_TRANSITION_TYPE_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Overview Transition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Overview Transition Type Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERVIEW_TRANSITION_TYPE_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Overview Transition Type Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERVIEW_TRANSITION_TYPE_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.StateMappingAnnotationImpl <em>State Mapping Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.StateMappingAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateMappingAnnotation()
	 * @generated
	 */
	int STATE_MAPPING_ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MAPPING_ANNOTATION__STATE = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MAPPING_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>State Mapping Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MAPPING_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.impl.FormulaIdentificationAnnotationImpl <em>Formula Identification Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.impl.FormulaIdentificationAnnotationImpl
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getFormulaIdentificationAnnotation()
	 * @generated
	 */
	int FORMULA_IDENTIFICATION_ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_IDENTIFICATION_ANNOTATION__GROUP = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Formula Holder</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Formula Identification Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_IDENTIFICATION_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Formula Identification Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_IDENTIFICATION_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.traceability.StateType <em>State Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.StateType
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateType()
	 * @generated
	 */
	int STATE_TYPE = 6;

	/**
	 * The meta object id for the '{@link org.foam.traceability.OverviewTransitionType <em>Overview Transition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.traceability.OverviewTransitionType
	 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getOverviewTransitionType()
	 * @generated
	 */
	int OVERVIEW_TRANSITION_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link org.foam.traceability.StepMappingAnnotation <em>Step Mapping Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Mapping Annotation</em>'.
	 * @see org.foam.traceability.StepMappingAnnotation
	 * @generated
	 */
	EClass getStepMappingAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.foam.traceability.StepMappingAnnotation#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Step</em>'.
	 * @see org.foam.traceability.StepMappingAnnotation#getStep()
	 * @see #getStepMappingAnnotation()
	 * @generated
	 */
	EReference getStepMappingAnnotation_Step();

	/**
	 * Returns the meta object for class '{@link org.foam.traceability.StateTypeMappingAnnotation <em>State Type Mapping Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Type Mapping Annotation</em>'.
	 * @see org.foam.traceability.StateTypeMappingAnnotation
	 * @generated
	 */
	EClass getStateTypeMappingAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.traceability.StateTypeMappingAnnotation#getStateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State Type</em>'.
	 * @see org.foam.traceability.StateTypeMappingAnnotation#getStateType()
	 * @see #getStateTypeMappingAnnotation()
	 * @generated
	 */
	EAttribute getStateTypeMappingAnnotation_StateType();

	/**
	 * Returns the meta object for class '{@link org.foam.traceability.UseCaseMappingAnnotation <em>Use Case Mapping Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case Mapping Annotation</em>'.
	 * @see org.foam.traceability.UseCaseMappingAnnotation
	 * @generated
	 */
	EClass getUseCaseMappingAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.foam.traceability.UseCaseMappingAnnotation#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Use Case</em>'.
	 * @see org.foam.traceability.UseCaseMappingAnnotation#getUseCase()
	 * @see #getUseCaseMappingAnnotation()
	 * @generated
	 */
	EReference getUseCaseMappingAnnotation_UseCase();

	/**
	 * Returns the meta object for class '{@link org.foam.traceability.OverviewTransitionTypeAnnotation <em>Overview Transition Type Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Overview Transition Type Annotation</em>'.
	 * @see org.foam.traceability.OverviewTransitionTypeAnnotation
	 * @generated
	 */
	EClass getOverviewTransitionTypeAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.traceability.OverviewTransitionTypeAnnotation#getOverviewTransitionType <em>Overview Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Overview Transition Type</em>'.
	 * @see org.foam.traceability.OverviewTransitionTypeAnnotation#getOverviewTransitionType()
	 * @see #getOverviewTransitionTypeAnnotation()
	 * @generated
	 */
	EAttribute getOverviewTransitionTypeAnnotation_OverviewTransitionType();

	/**
	 * Returns the meta object for class '{@link org.foam.traceability.StateMappingAnnotation <em>State Mapping Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Mapping Annotation</em>'.
	 * @see org.foam.traceability.StateMappingAnnotation
	 * @generated
	 */
	EClass getStateMappingAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.foam.traceability.StateMappingAnnotation#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State</em>'.
	 * @see org.foam.traceability.StateMappingAnnotation#getState()
	 * @see #getStateMappingAnnotation()
	 * @generated
	 */
	EReference getStateMappingAnnotation_State();

	/**
	 * Returns the meta object for class '{@link org.foam.traceability.FormulaIdentificationAnnotation <em>Formula Identification Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula Identification Annotation</em>'.
	 * @see org.foam.traceability.FormulaIdentificationAnnotation
	 * @generated
	 */
	EClass getFormulaIdentificationAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.foam.traceability.FormulaIdentificationAnnotation#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Group</em>'.
	 * @see org.foam.traceability.FormulaIdentificationAnnotation#getGroup()
	 * @see #getFormulaIdentificationAnnotation()
	 * @generated
	 */
	EReference getFormulaIdentificationAnnotation_Group();

	/**
	 * Returns the meta object for the reference '{@link org.foam.traceability.FormulaIdentificationAnnotation#getFormulaHolder <em>Formula Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Formula Holder</em>'.
	 * @see org.foam.traceability.FormulaIdentificationAnnotation#getFormulaHolder()
	 * @see #getFormulaIdentificationAnnotation()
	 * @generated
	 */
	EReference getFormulaIdentificationAnnotation_FormulaHolder();

	/**
	 * Returns the meta object for enum '{@link org.foam.traceability.StateType <em>State Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Type</em>'.
	 * @see org.foam.traceability.StateType
	 * @generated
	 */
	EEnum getStateType();

	/**
	 * Returns the meta object for enum '{@link org.foam.traceability.OverviewTransitionType <em>Overview Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Overview Transition Type</em>'.
	 * @see org.foam.traceability.OverviewTransitionType
	 * @generated
	 */
	EEnum getOverviewTransitionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceabilityFactory getTraceabilityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.StepMappingAnnotationImpl <em>Step Mapping Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.StepMappingAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStepMappingAnnotation()
		 * @generated
		 */
		EClass STEP_MAPPING_ANNOTATION = eINSTANCE.getStepMappingAnnotation();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEP_MAPPING_ANNOTATION__STEP = eINSTANCE.getStepMappingAnnotation_Step();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.StateTypeMappingAnnotationImpl <em>State Type Mapping Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.StateTypeMappingAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateTypeMappingAnnotation()
		 * @generated
		 */
		EClass STATE_TYPE_MAPPING_ANNOTATION = eINSTANCE.getStateTypeMappingAnnotation();

		/**
		 * The meta object literal for the '<em><b>State Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_TYPE_MAPPING_ANNOTATION__STATE_TYPE = eINSTANCE.getStateTypeMappingAnnotation_StateType();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.UseCaseMappingAnnotationImpl <em>Use Case Mapping Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.UseCaseMappingAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getUseCaseMappingAnnotation()
		 * @generated
		 */
		EClass USE_CASE_MAPPING_ANNOTATION = eINSTANCE.getUseCaseMappingAnnotation();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE_MAPPING_ANNOTATION__USE_CASE = eINSTANCE.getUseCaseMappingAnnotation_UseCase();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.OverviewTransitionTypeAnnotationImpl <em>Overview Transition Type Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.OverviewTransitionTypeAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getOverviewTransitionTypeAnnotation()
		 * @generated
		 */
		EClass OVERVIEW_TRANSITION_TYPE_ANNOTATION = eINSTANCE.getOverviewTransitionTypeAnnotation();

		/**
		 * The meta object literal for the '<em><b>Overview Transition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE = eINSTANCE.getOverviewTransitionTypeAnnotation_OverviewTransitionType();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.StateMappingAnnotationImpl <em>State Mapping Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.StateMappingAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateMappingAnnotation()
		 * @generated
		 */
		EClass STATE_MAPPING_ANNOTATION = eINSTANCE.getStateMappingAnnotation();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE_MAPPING_ANNOTATION__STATE = eINSTANCE.getStateMappingAnnotation_State();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.impl.FormulaIdentificationAnnotationImpl <em>Formula Identification Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.impl.FormulaIdentificationAnnotationImpl
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getFormulaIdentificationAnnotation()
		 * @generated
		 */
		EClass FORMULA_IDENTIFICATION_ANNOTATION = eINSTANCE.getFormulaIdentificationAnnotation();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA_IDENTIFICATION_ANNOTATION__GROUP = eINSTANCE.getFormulaIdentificationAnnotation_Group();

		/**
		 * The meta object literal for the '<em><b>Formula Holder</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER = eINSTANCE.getFormulaIdentificationAnnotation_FormulaHolder();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.StateType <em>State Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.StateType
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getStateType()
		 * @generated
		 */
		EEnum STATE_TYPE = eINSTANCE.getStateType();

		/**
		 * The meta object literal for the '{@link org.foam.traceability.OverviewTransitionType <em>Overview Transition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.traceability.OverviewTransitionType
		 * @see org.foam.traceability.impl.TraceabilityPackageImpl#getOverviewTransitionType()
		 * @generated
		 */
		EEnum OVERVIEW_TRANSITION_TYPE = eINSTANCE.getOverviewTransitionType();

	}

} //TraceabilityPackage
