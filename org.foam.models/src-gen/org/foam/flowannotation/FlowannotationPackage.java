/**
 */
package org.foam.flowannotation;

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
 * @see org.foam.flowannotation.FlowannotationFactory
 * @model kind="package"
 * @generated
 */
public interface FlowannotationPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "flowannotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "flowannotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "flowannotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlowannotationPackage eINSTANCE = org.foam.flowannotation.impl.FlowannotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.FlowAnnotation <em>Flow Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.FlowAnnotation
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getFlowAnnotation()
	 * @generated
	 */
	int FLOW_ANNOTATION = 0;

	/**
	 * The number of structural features of the '<em>Flow Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Flow Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.AbortImpl <em>Abort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.AbortImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getAbort()
	 * @generated
	 */
	int ABORT = 1;

	/**
	 * The number of structural features of the '<em>Abort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_FEATURE_COUNT = FLOW_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABORT_OPERATION_COUNT = FLOW_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.GotoImpl <em>Goto</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.GotoImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getGoto()
	 * @generated
	 */
	int GOTO = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO__TARGET = FLOW_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_FEATURE_COUNT = FLOW_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Goto</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOTO_OPERATION_COUNT = FLOW_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.GuardImpl <em>Guard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.GuardImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getGuard()
	 * @generated
	 */
	int GUARD = 3;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD__FORMULA = FLOW_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_FEATURE_COUNT = FLOW_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Guard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_OPERATION_COUNT = FLOW_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.IncludeImpl <em>Include</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.IncludeImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getInclude()
	 * @generated
	 */
	int INCLUDE = 4;

	/**
	 * The feature id for the '<em><b>Inlined Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE__INLINED_USE_CASE = FLOW_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_FEATURE_COUNT = FLOW_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Include</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDE_OPERATION_COUNT = FLOW_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.MarkImpl <em>Mark</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.MarkImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getMark()
	 * @generated
	 */
	int MARK = 5;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK__VARIABLE_DEFINITION = FLOW_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mark</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_FEATURE_COUNT = FLOW_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mark</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARK_OPERATION_COUNT = FLOW_ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.flowannotation.impl.VariableDefinitionAnnotationImpl <em>Variable Definition Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.flowannotation.impl.VariableDefinitionAnnotationImpl
	 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getVariableDefinitionAnnotation()
	 * @generated
	 */
	int VARIABLE_DEFINITION_ANNOTATION = 6;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Definition Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Definition Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.FlowAnnotation <em>Flow Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Annotation</em>'.
	 * @see org.foam.flowannotation.FlowAnnotation
	 * @generated
	 */
	EClass getFlowAnnotation();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.Abort <em>Abort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abort</em>'.
	 * @see org.foam.flowannotation.Abort
	 * @generated
	 */
	EClass getAbort();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.Goto <em>Goto</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goto</em>'.
	 * @see org.foam.flowannotation.Goto
	 * @generated
	 */
	EClass getGoto();

	/**
	 * Returns the meta object for the reference '{@link org.foam.flowannotation.Goto#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.foam.flowannotation.Goto#getTarget()
	 * @see #getGoto()
	 * @generated
	 */
	EReference getGoto_Target();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard</em>'.
	 * @see org.foam.flowannotation.Guard
	 * @generated
	 */
	EClass getGuard();

	/**
	 * Returns the meta object for the containment reference '{@link org.foam.flowannotation.Guard#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formula</em>'.
	 * @see org.foam.flowannotation.Guard#getFormula()
	 * @see #getGuard()
	 * @generated
	 */
	EReference getGuard_Formula();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.Include <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Include</em>'.
	 * @see org.foam.flowannotation.Include
	 * @generated
	 */
	EClass getInclude();

	/**
	 * Returns the meta object for the reference '{@link org.foam.flowannotation.Include#getInlinedUseCase <em>Inlined Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inlined Use Case</em>'.
	 * @see org.foam.flowannotation.Include#getInlinedUseCase()
	 * @see #getInclude()
	 * @generated
	 */
	EReference getInclude_InlinedUseCase();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.Mark <em>Mark</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mark</em>'.
	 * @see org.foam.flowannotation.Mark
	 * @generated
	 */
	EClass getMark();

	/**
	 * Returns the meta object for the reference '{@link org.foam.flowannotation.Mark#getVariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Definition</em>'.
	 * @see org.foam.flowannotation.Mark#getVariableDefinition()
	 * @see #getMark()
	 * @generated
	 */
	EReference getMark_VariableDefinition();

	/**
	 * Returns the meta object for class '{@link org.foam.flowannotation.VariableDefinitionAnnotation <em>Variable Definition Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Definition Annotation</em>'.
	 * @see org.foam.flowannotation.VariableDefinitionAnnotation
	 * @generated
	 */
	EClass getVariableDefinitionAnnotation();

	/**
	 * Returns the meta object for the containment reference '{@link org.foam.flowannotation.VariableDefinitionAnnotation#getVariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable Definition</em>'.
	 * @see org.foam.flowannotation.VariableDefinitionAnnotation#getVariableDefinition()
	 * @see #getVariableDefinitionAnnotation()
	 * @generated
	 */
	EReference getVariableDefinitionAnnotation_VariableDefinition();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FlowannotationFactory getFlowannotationFactory();

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
		 * The meta object literal for the '{@link org.foam.flowannotation.FlowAnnotation <em>Flow Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.FlowAnnotation
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getFlowAnnotation()
		 * @generated
		 */
		EClass FLOW_ANNOTATION = eINSTANCE.getFlowAnnotation();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.AbortImpl <em>Abort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.AbortImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getAbort()
		 * @generated
		 */
		EClass ABORT = eINSTANCE.getAbort();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.GotoImpl <em>Goto</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.GotoImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getGoto()
		 * @generated
		 */
		EClass GOTO = eINSTANCE.getGoto();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOTO__TARGET = eINSTANCE.getGoto_Target();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.GuardImpl <em>Guard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.GuardImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getGuard()
		 * @generated
		 */
		EClass GUARD = eINSTANCE.getGuard();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD__FORMULA = eINSTANCE.getGuard_Formula();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.IncludeImpl <em>Include</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.IncludeImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getInclude()
		 * @generated
		 */
		EClass INCLUDE = eINSTANCE.getInclude();

		/**
		 * The meta object literal for the '<em><b>Inlined Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUDE__INLINED_USE_CASE = eINSTANCE.getInclude_InlinedUseCase();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.MarkImpl <em>Mark</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.MarkImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getMark()
		 * @generated
		 */
		EClass MARK = eINSTANCE.getMark();

		/**
		 * The meta object literal for the '<em><b>Variable Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARK__VARIABLE_DEFINITION = eINSTANCE.getMark_VariableDefinition();

		/**
		 * The meta object literal for the '{@link org.foam.flowannotation.impl.VariableDefinitionAnnotationImpl <em>Variable Definition Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.flowannotation.impl.VariableDefinitionAnnotationImpl
		 * @see org.foam.flowannotation.impl.FlowannotationPackageImpl#getVariableDefinitionAnnotation()
		 * @generated
		 */
		EClass VARIABLE_DEFINITION_ANNOTATION = eINSTANCE.getVariableDefinitionAnnotation();

		/**
		 * The meta object literal for the '<em><b>Variable Definition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION = eINSTANCE.getVariableDefinitionAnnotation_VariableDefinition();

	}

} //FlowannotationPackage
