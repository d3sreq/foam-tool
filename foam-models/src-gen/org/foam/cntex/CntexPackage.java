/**
 */
package org.foam.cntex;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.foam.cntex.CntexFactory
 * @model kind="package"
 * @generated
 */
public interface CntexPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cntex";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "cntex";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cntex";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CntexPackage eINSTANCE = org.foam.cntex.impl.CntexPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.cntex.impl.CounterExampleImpl <em>Counter Example</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.cntex.impl.CounterExampleImpl
	 * @see org.foam.cntex.impl.CntexPackageImpl#getCounterExample()
	 * @generated
	 */
	int COUNTER_EXAMPLE = 0;

	/**
	 * The feature id for the '<em><b>Specifications</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_EXAMPLE__SPECIFICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Counter Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_EXAMPLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Counter Example</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_EXAMPLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.cntex.impl.CntExStateImpl <em>Cnt Ex State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.cntex.impl.CntExStateImpl
	 * @see org.foam.cntex.impl.CntexPackageImpl#getCntExState()
	 * @generated
	 */
	int CNT_EX_STATE = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_STATE__ANNOTATIONS = AnnotationPackage.ANNOTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_STATE__ASSIGNMENTS = AnnotationPackage.ANNOTABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cnt Ex State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_STATE_FEATURE_COUNT = AnnotationPackage.ANNOTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Cnt Ex State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_STATE_OPERATION_COUNT = AnnotationPackage.ANNOTABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.cntex.impl.CntExAssignmentImpl <em>Cnt Ex Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.cntex.impl.CntExAssignmentImpl
	 * @see org.foam.cntex.impl.CntexPackageImpl#getCntExAssignment()
	 * @generated
	 */
	int CNT_EX_ASSIGNMENT = 2;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_ASSIGNMENT__VARIABLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Cnt Ex Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Cnt Ex Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CNT_EX_ASSIGNMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.cntex.impl.TraceImpl <em>Trace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.cntex.impl.TraceImpl
	 * @see org.foam.cntex.impl.CntexPackageImpl#getTrace()
	 * @generated
	 */
	int TRACE = 3;

	/**
	 * The feature id for the '<em><b>Loop Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__LOOP_START = 0;

	/**
	 * The feature id for the '<em><b>States</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE__STATES = 1;

	/**
	 * The number of structural features of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Trace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.cntex.impl.SpecificationImpl <em>Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.cntex.impl.SpecificationImpl
	 * @see org.foam.cntex.impl.CntexPackageImpl#getSpecification()
	 * @generated
	 */
	int SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__ANNOTATIONS = AnnotationPackage.ANNOTABLE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__TRACE = AnnotationPackage.ANNOTABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION__TEXT_FORMULA = AnnotationPackage.ANNOTABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_FEATURE_COUNT = AnnotationPackage.ANNOTABLE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIFICATION_OPERATION_COUNT = AnnotationPackage.ANNOTABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.foam.cntex.CounterExample <em>Counter Example</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counter Example</em>'.
	 * @see org.foam.cntex.CounterExample
	 * @generated
	 */
	EClass getCounterExample();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foam.cntex.CounterExample#getSpecifications <em>Specifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specifications</em>'.
	 * @see org.foam.cntex.CounterExample#getSpecifications()
	 * @see #getCounterExample()
	 * @generated
	 */
	EReference getCounterExample_Specifications();

	/**
	 * Returns the meta object for class '{@link org.foam.cntex.CntExState <em>Cnt Ex State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cnt Ex State</em>'.
	 * @see org.foam.cntex.CntExState
	 * @generated
	 */
	EClass getCntExState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foam.cntex.CntExState#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see org.foam.cntex.CntExState#getAssignments()
	 * @see #getCntExState()
	 * @generated
	 */
	EReference getCntExState_Assignments();

	/**
	 * Returns the meta object for class '{@link org.foam.cntex.CntExAssignment <em>Cnt Ex Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cnt Ex Assignment</em>'.
	 * @see org.foam.cntex.CntExAssignment
	 * @generated
	 */
	EClass getCntExAssignment();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.cntex.CntExAssignment#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see org.foam.cntex.CntExAssignment#getVariableName()
	 * @see #getCntExAssignment()
	 * @generated
	 */
	EAttribute getCntExAssignment_VariableName();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.cntex.CntExAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.foam.cntex.CntExAssignment#getValue()
	 * @see #getCntExAssignment()
	 * @generated
	 */
	EAttribute getCntExAssignment_Value();

	/**
	 * Returns the meta object for class '{@link org.foam.cntex.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace</em>'.
	 * @see org.foam.cntex.Trace
	 * @generated
	 */
	EClass getTrace();

	/**
	 * Returns the meta object for the reference '{@link org.foam.cntex.Trace#getLoopStart <em>Loop Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Start</em>'.
	 * @see org.foam.cntex.Trace#getLoopStart()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_LoopStart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foam.cntex.Trace#getStates <em>States</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>States</em>'.
	 * @see org.foam.cntex.Trace#getStates()
	 * @see #getTrace()
	 * @generated
	 */
	EReference getTrace_States();

	/**
	 * Returns the meta object for class '{@link org.foam.cntex.Specification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specification</em>'.
	 * @see org.foam.cntex.Specification
	 * @generated
	 */
	EClass getSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.foam.cntex.Specification#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Trace</em>'.
	 * @see org.foam.cntex.Specification#getTrace()
	 * @see #getSpecification()
	 * @generated
	 */
	EReference getSpecification_Trace();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.cntex.Specification#getTextFormula <em>Text Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text Formula</em>'.
	 * @see org.foam.cntex.Specification#getTextFormula()
	 * @see #getSpecification()
	 * @generated
	 */
	EAttribute getSpecification_TextFormula();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CntexFactory getCntexFactory();

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
		 * The meta object literal for the '{@link org.foam.cntex.impl.CounterExampleImpl <em>Counter Example</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.cntex.impl.CounterExampleImpl
		 * @see org.foam.cntex.impl.CntexPackageImpl#getCounterExample()
		 * @generated
		 */
		EClass COUNTER_EXAMPLE = eINSTANCE.getCounterExample();

		/**
		 * The meta object literal for the '<em><b>Specifications</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_EXAMPLE__SPECIFICATIONS = eINSTANCE.getCounterExample_Specifications();

		/**
		 * The meta object literal for the '{@link org.foam.cntex.impl.CntExStateImpl <em>Cnt Ex State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.cntex.impl.CntExStateImpl
		 * @see org.foam.cntex.impl.CntexPackageImpl#getCntExState()
		 * @generated
		 */
		EClass CNT_EX_STATE = eINSTANCE.getCntExState();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CNT_EX_STATE__ASSIGNMENTS = eINSTANCE.getCntExState_Assignments();

		/**
		 * The meta object literal for the '{@link org.foam.cntex.impl.CntExAssignmentImpl <em>Cnt Ex Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.cntex.impl.CntExAssignmentImpl
		 * @see org.foam.cntex.impl.CntexPackageImpl#getCntExAssignment()
		 * @generated
		 */
		EClass CNT_EX_ASSIGNMENT = eINSTANCE.getCntExAssignment();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CNT_EX_ASSIGNMENT__VARIABLE_NAME = eINSTANCE.getCntExAssignment_VariableName();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CNT_EX_ASSIGNMENT__VALUE = eINSTANCE.getCntExAssignment_Value();

		/**
		 * The meta object literal for the '{@link org.foam.cntex.impl.TraceImpl <em>Trace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.cntex.impl.TraceImpl
		 * @see org.foam.cntex.impl.CntexPackageImpl#getTrace()
		 * @generated
		 */
		EClass TRACE = eINSTANCE.getTrace();

		/**
		 * The meta object literal for the '<em><b>Loop Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__LOOP_START = eINSTANCE.getTrace_LoopStart();

		/**
		 * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE__STATES = eINSTANCE.getTrace_States();

		/**
		 * The meta object literal for the '{@link org.foam.cntex.impl.SpecificationImpl <em>Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.cntex.impl.SpecificationImpl
		 * @see org.foam.cntex.impl.CntexPackageImpl#getSpecification()
		 * @generated
		 */
		EClass SPECIFICATION = eINSTANCE.getSpecification();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIFICATION__TRACE = eINSTANCE.getSpecification_Trace();

		/**
		 * The meta object literal for the '<em><b>Text Formula</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIFICATION__TEXT_FORMULA = eINSTANCE.getSpecification_TextFormula();

	}

} //CntexPackage
