/**
 */
package org.foam.tadl;

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
 * @see org.foam.tadl.TadlFactory
 * @model kind="package"
 * @generated
 */
public interface TadlPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tadl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "tadl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tadl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TadlPackage eINSTANCE = org.foam.tadl.impl.TadlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.tadl.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.impl.TemplateImpl
	 * @see org.foam.tadl.impl.TadlPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Formula Holders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__FORMULA_HOLDERS = 0;

	/**
	 * The feature id for the '<em><b>Variable Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__VARIABLE_DEFINITIONS = 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.tadl.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.impl.GroupImpl
	 * @see org.foam.tadl.impl.TadlPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 1;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__QUALIFIER = 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__TEMPLATE = 1;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.tadl.impl.TemporalAnnotationImpl <em>Temporal Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.impl.TemporalAnnotationImpl
	 * @see org.foam.tadl.impl.TadlPackageImpl#getTemporalAnnotation()
	 * @generated
	 */
	int TEMPORAL_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION__GROUP = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION__VARIABLE_DEFINITION = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Temporal Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Temporal Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPORAL_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.tadl.impl.GroupAnnotationImpl <em>Group Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.impl.GroupAnnotationImpl
	 * @see org.foam.tadl.impl.TadlPackageImpl#getGroupAnnotation()
	 * @generated
	 */
	int GROUP_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_ANNOTATION__GROUP = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Group Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_ANNOTATION_FEATURE_COUNT = AnnotationPackage.ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Group Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_ANNOTATION_OPERATION_COUNT = AnnotationPackage.ANNOTATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.tadl.impl.FormulaHolderImpl <em>Formula Holder</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.impl.FormulaHolderImpl
	 * @see org.foam.tadl.impl.TadlPackageImpl#getFormulaHolder()
	 * @generated
	 */
	int FORMULA_HOLDER = 4;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_HOLDER__COMMENT = 0;

	/**
	 * The feature id for the '<em><b>Formula Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_HOLDER__FORMULA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_HOLDER__FORMULA = 2;

	/**
	 * The number of structural features of the '<em>Formula Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_HOLDER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Formula Holder</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORMULA_HOLDER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.foam.tadl.FormulaType <em>Formula Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.tadl.FormulaType
	 * @see org.foam.tadl.impl.TadlPackageImpl#getFormulaType()
	 * @generated
	 */
	int FORMULA_TYPE = 5;


	/**
	 * Returns the meta object for class '{@link org.foam.tadl.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.foam.tadl.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foam.tadl.Template#getFormulaHolders <em>Formula Holders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Formula Holders</em>'.
	 * @see org.foam.tadl.Template#getFormulaHolders()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_FormulaHolders();

	/**
	 * Returns the meta object for the containment reference list '{@link org.foam.tadl.Template#getVariableDefinitions <em>Variable Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Definitions</em>'.
	 * @see org.foam.tadl.Template#getVariableDefinitions()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_VariableDefinitions();

	/**
	 * Returns the meta object for class '{@link org.foam.tadl.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.foam.tadl.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.tadl.Group#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifier</em>'.
	 * @see org.foam.tadl.Group#getQualifier()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Qualifier();

	/**
	 * Returns the meta object for the reference '{@link org.foam.tadl.Group#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Template</em>'.
	 * @see org.foam.tadl.Group#getTemplate()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Template();

	/**
	 * Returns the meta object for class '{@link org.foam.tadl.TemporalAnnotation <em>Temporal Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Temporal Annotation</em>'.
	 * @see org.foam.tadl.TemporalAnnotation
	 * @generated
	 */
	EClass getTemporalAnnotation();

	/**
	 * Returns the meta object for the reference '{@link org.foam.tadl.TemporalAnnotation#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Group</em>'.
	 * @see org.foam.tadl.TemporalAnnotation#getGroup()
	 * @see #getTemporalAnnotation()
	 * @generated
	 */
	EReference getTemporalAnnotation_Group();

	/**
	 * Returns the meta object for the reference '{@link org.foam.tadl.TemporalAnnotation#getVariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Definition</em>'.
	 * @see org.foam.tadl.TemporalAnnotation#getVariableDefinition()
	 * @see #getTemporalAnnotation()
	 * @generated
	 */
	EReference getTemporalAnnotation_VariableDefinition();

	/**
	 * Returns the meta object for class '{@link org.foam.tadl.GroupAnnotation <em>Group Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Annotation</em>'.
	 * @see org.foam.tadl.GroupAnnotation
	 * @generated
	 */
	EClass getGroupAnnotation();

	/**
	 * Returns the meta object for the containment reference '{@link org.foam.tadl.GroupAnnotation#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Group</em>'.
	 * @see org.foam.tadl.GroupAnnotation#getGroup()
	 * @see #getGroupAnnotation()
	 * @generated
	 */
	EReference getGroupAnnotation_Group();

	/**
	 * Returns the meta object for class '{@link org.foam.tadl.FormulaHolder <em>Formula Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Formula Holder</em>'.
	 * @see org.foam.tadl.FormulaHolder
	 * @generated
	 */
	EClass getFormulaHolder();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.tadl.FormulaHolder#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.foam.tadl.FormulaHolder#getComment()
	 * @see #getFormulaHolder()
	 * @generated
	 */
	EAttribute getFormulaHolder_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.foam.tadl.FormulaHolder#getFormulaType <em>Formula Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula Type</em>'.
	 * @see org.foam.tadl.FormulaHolder#getFormulaType()
	 * @see #getFormulaHolder()
	 * @generated
	 */
	EAttribute getFormulaHolder_FormulaType();

	/**
	 * Returns the meta object for the containment reference '{@link org.foam.tadl.FormulaHolder#getFormula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Formula</em>'.
	 * @see org.foam.tadl.FormulaHolder#getFormula()
	 * @see #getFormulaHolder()
	 * @generated
	 */
	EReference getFormulaHolder_Formula();

	/**
	 * Returns the meta object for enum '{@link org.foam.tadl.FormulaType <em>Formula Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Formula Type</em>'.
	 * @see org.foam.tadl.FormulaType
	 * @generated
	 */
	EEnum getFormulaType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TadlFactory getTadlFactory();

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
		 * The meta object literal for the '{@link org.foam.tadl.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.impl.TemplateImpl
		 * @see org.foam.tadl.impl.TadlPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Formula Holders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__FORMULA_HOLDERS = eINSTANCE.getTemplate_FormulaHolders();

		/**
		 * The meta object literal for the '<em><b>Variable Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__VARIABLE_DEFINITIONS = eINSTANCE.getTemplate_VariableDefinitions();

		/**
		 * The meta object literal for the '{@link org.foam.tadl.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.impl.GroupImpl
		 * @see org.foam.tadl.impl.TadlPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__QUALIFIER = eINSTANCE.getGroup_Qualifier();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__TEMPLATE = eINSTANCE.getGroup_Template();

		/**
		 * The meta object literal for the '{@link org.foam.tadl.impl.TemporalAnnotationImpl <em>Temporal Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.impl.TemporalAnnotationImpl
		 * @see org.foam.tadl.impl.TadlPackageImpl#getTemporalAnnotation()
		 * @generated
		 */
		EClass TEMPORAL_ANNOTATION = eINSTANCE.getTemporalAnnotation();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORAL_ANNOTATION__GROUP = eINSTANCE.getTemporalAnnotation_Group();

		/**
		 * The meta object literal for the '<em><b>Variable Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPORAL_ANNOTATION__VARIABLE_DEFINITION = eINSTANCE.getTemporalAnnotation_VariableDefinition();

		/**
		 * The meta object literal for the '{@link org.foam.tadl.impl.GroupAnnotationImpl <em>Group Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.impl.GroupAnnotationImpl
		 * @see org.foam.tadl.impl.TadlPackageImpl#getGroupAnnotation()
		 * @generated
		 */
		EClass GROUP_ANNOTATION = eINSTANCE.getGroupAnnotation();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_ANNOTATION__GROUP = eINSTANCE.getGroupAnnotation_Group();

		/**
		 * The meta object literal for the '{@link org.foam.tadl.impl.FormulaHolderImpl <em>Formula Holder</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.impl.FormulaHolderImpl
		 * @see org.foam.tadl.impl.TadlPackageImpl#getFormulaHolder()
		 * @generated
		 */
		EClass FORMULA_HOLDER = eINSTANCE.getFormulaHolder();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULA_HOLDER__COMMENT = eINSTANCE.getFormulaHolder_Comment();

		/**
		 * The meta object literal for the '<em><b>Formula Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORMULA_HOLDER__FORMULA_TYPE = eINSTANCE.getFormulaHolder_FormulaType();

		/**
		 * The meta object literal for the '<em><b>Formula</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORMULA_HOLDER__FORMULA = eINSTANCE.getFormulaHolder_Formula();

		/**
		 * The meta object literal for the '{@link org.foam.tadl.FormulaType <em>Formula Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.tadl.FormulaType
		 * @see org.foam.tadl.impl.TadlPackageImpl#getFormulaType()
		 * @generated
		 */
		EEnum FORMULA_TYPE = eINSTANCE.getFormulaType();

	}

} //TadlPackage
