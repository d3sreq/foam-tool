/**
 */
package org.foam.flowannotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.annotation.AnnotationPackage;

import org.foam.flowannotation.Abort;
import org.foam.flowannotation.FlowAnnotation;
import org.foam.flowannotation.FlowannotationFactory;
import org.foam.flowannotation.FlowannotationPackage;
import org.foam.flowannotation.Goto;
import org.foam.flowannotation.Guard;
import org.foam.flowannotation.Include;
import org.foam.flowannotation.Mark;
import org.foam.flowannotation.VariableDefinitionAnnotation;

import org.foam.propositionallogic.PropositionallogicPackage;

import org.foam.ucm.UcmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowannotationPackageImpl extends EPackageImpl implements FlowannotationPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gotoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass includeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass markEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDefinitionAnnotationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.foam.flowannotation.FlowannotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlowannotationPackageImpl()
	{
		super(eNS_URI, FlowannotationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FlowannotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlowannotationPackage init()
	{
		if (isInited) return (FlowannotationPackage)EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI);

		// Obtain or create and register package
		FlowannotationPackageImpl theFlowannotationPackage = (FlowannotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FlowannotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FlowannotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PropositionallogicPackage.eINSTANCE.eClass();
		UcmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFlowannotationPackage.createPackageContents();

		// Initialize created meta-data
		theFlowannotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlowannotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FlowannotationPackage.eNS_URI, theFlowannotationPackage);
		return theFlowannotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowAnnotation()
	{
		return flowAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbort()
	{
		return abortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoto()
	{
		return gotoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoto_Target()
	{
		return (EReference)gotoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuard()
	{
		return guardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGuard_Formula()
	{
		return (EReference)guardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInclude()
	{
		return includeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclude_InlinedUseCase()
	{
		return (EReference)includeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMark()
	{
		return markEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMark_VariableDefinition()
	{
		return (EReference)markEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDefinitionAnnotation()
	{
		return variableDefinitionAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDefinitionAnnotation_VariableDefinition()
	{
		return (EReference)variableDefinitionAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowannotationFactory getFlowannotationFactory()
	{
		return (FlowannotationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		flowAnnotationEClass = createEClass(FLOW_ANNOTATION);

		abortEClass = createEClass(ABORT);

		gotoEClass = createEClass(GOTO);
		createEReference(gotoEClass, GOTO__TARGET);

		guardEClass = createEClass(GUARD);
		createEReference(guardEClass, GUARD__FORMULA);

		includeEClass = createEClass(INCLUDE);
		createEReference(includeEClass, INCLUDE__INLINED_USE_CASE);

		markEClass = createEClass(MARK);
		createEReference(markEClass, MARK__VARIABLE_DEFINITION);

		variableDefinitionAnnotationEClass = createEClass(VARIABLE_DEFINITION_ANNOTATION);
		createEReference(variableDefinitionAnnotationEClass, VARIABLE_DEFINITION_ANNOTATION__VARIABLE_DEFINITION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AnnotationPackage theAnnotationPackage = (AnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI);
		UcmPackage theUcmPackage = (UcmPackage)EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI);
		PropositionallogicPackage thePropositionallogicPackage = (PropositionallogicPackage)EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		flowAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		abortEClass.getESuperTypes().add(this.getFlowAnnotation());
		gotoEClass.getESuperTypes().add(this.getFlowAnnotation());
		guardEClass.getESuperTypes().add(this.getFlowAnnotation());
		includeEClass.getESuperTypes().add(this.getFlowAnnotation());
		markEClass.getESuperTypes().add(this.getFlowAnnotation());
		variableDefinitionAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());

		// Initialize classes, features, and operations; add parameters
		initEClass(flowAnnotationEClass, FlowAnnotation.class, "FlowAnnotation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abortEClass, Abort.class, "Abort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gotoEClass, Goto.class, "Goto", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoto_Target(), theUcmPackage.getStep(), null, "target", null, 1, 1, Goto.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardEClass, Guard.class, "Guard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuard_Formula(), thePropositionallogicPackage.getFormula(), null, "formula", null, 1, 1, Guard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(includeEClass, Include.class, "Include", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInclude_InlinedUseCase(), theUcmPackage.getUseCase(), null, "inlinedUseCase", null, 1, 1, Include.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(markEClass, Mark.class, "Mark", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMark_VariableDefinition(), thePropositionallogicPackage.getVariableDefinition(), null, "variableDefinition", null, 1, 1, Mark.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDefinitionAnnotationEClass, VariableDefinitionAnnotation.class, "VariableDefinitionAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDefinitionAnnotation_VariableDefinition(), thePropositionallogicPackage.getVariableDefinition(), null, "variableDefinition", null, 1, 1, VariableDefinitionAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //FlowannotationPackageImpl
