/**
 */
package org.foam.traceability.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.annotation.AnnotationPackage;

import org.foam.annotation.impl.AnnotationPackageImpl;

import org.foam.cntex.CntexPackage;

import org.foam.cntex.impl.CntexPackageImpl;

import org.foam.ctl.CtlPackage;

import org.foam.ctl.impl.CtlPackageImpl;

import org.foam.dot.DotPackage;

import org.foam.dot.impl.DotPackageImpl;

import org.foam.flowannotation.FlowannotationPackage;

import org.foam.flowannotation.impl.FlowannotationPackageImpl;

import org.foam.ltl.LtlPackage;

import org.foam.ltl.impl.LtlPackageImpl;

import org.foam.lts.LtsPackage;

import org.foam.lts.impl.LtsPackageImpl;

import org.foam.propositionallogic.PropositionallogicPackage;

import org.foam.propositionallogic.impl.PropositionallogicPackageImpl;

import org.foam.tadl.TadlPackage;

import org.foam.tadl.impl.TadlPackageImpl;

import org.foam.traceability.FormulaIdentificationAnnotation;
import org.foam.traceability.OverviewTransitionType;
import org.foam.traceability.OverviewTransitionTypeAnnotation;
import org.foam.traceability.StateMappingAnnotation;
import org.foam.traceability.StateType;
import org.foam.traceability.StateTypeMappingAnnotation;
import org.foam.traceability.StepMappingAnnotation;
import org.foam.traceability.TraceabilityFactory;
import org.foam.traceability.TraceabilityPackage;
import org.foam.traceability.UseCaseMappingAnnotation;

import org.foam.ucm.UcmPackage;

import org.foam.ucm.impl.UcmPackageImpl;

import org.foam.verification.VerificationPackage;

import org.foam.verification.impl.VerificationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TraceabilityPackageImpl extends EPackageImpl implements TraceabilityPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepMappingAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateTypeMappingAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useCaseMappingAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass overviewTransitionTypeAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMappingAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass formulaIdentificationAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum overviewTransitionTypeEEnum = null;

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
	 * @see org.foam.traceability.TraceabilityPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TraceabilityPackageImpl()
	{
		super(eNS_URI, TraceabilityFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TraceabilityPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TraceabilityPackage init()
	{
		if (isInited) return (TraceabilityPackage)EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI);

		// Obtain or create and register package
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TraceabilityPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) : AnnotationPackage.eINSTANCE);
		CntexPackageImpl theCntexPackage = (CntexPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) instanceof CntexPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) : CntexPackage.eINSTANCE);
		CtlPackageImpl theCtlPackage = (CtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) instanceof CtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) : CtlPackage.eINSTANCE);
		DotPackageImpl theDotPackage = (DotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DotPackage.eNS_URI) instanceof DotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DotPackage.eNS_URI) : DotPackage.eINSTANCE);
		FlowannotationPackageImpl theFlowannotationPackage = (FlowannotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) instanceof FlowannotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) : FlowannotationPackage.eINSTANCE);
		LtlPackageImpl theLtlPackage = (LtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) instanceof LtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) : LtlPackage.eINSTANCE);
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		PropositionallogicPackageImpl thePropositionallogicPackage = (PropositionallogicPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) instanceof PropositionallogicPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) : PropositionallogicPackage.eINSTANCE);
		TadlPackageImpl theTadlPackage = (TadlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) instanceof TadlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) : TadlPackage.eINSTANCE);
		UcmPackageImpl theUcmPackage = (UcmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) instanceof UcmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) : UcmPackage.eINSTANCE);
		VerificationPackageImpl theVerificationPackage = (VerificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) instanceof VerificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) : VerificationPackage.eINSTANCE);

		// Create package meta-data objects
		theTraceabilityPackage.createPackageContents();
		theAnnotationPackage.createPackageContents();
		theCntexPackage.createPackageContents();
		theCtlPackage.createPackageContents();
		theDotPackage.createPackageContents();
		theFlowannotationPackage.createPackageContents();
		theLtlPackage.createPackageContents();
		theLtsPackage.createPackageContents();
		thePropositionallogicPackage.createPackageContents();
		theTadlPackage.createPackageContents();
		theUcmPackage.createPackageContents();
		theVerificationPackage.createPackageContents();

		// Initialize created meta-data
		theTraceabilityPackage.initializePackageContents();
		theAnnotationPackage.initializePackageContents();
		theCntexPackage.initializePackageContents();
		theCtlPackage.initializePackageContents();
		theDotPackage.initializePackageContents();
		theFlowannotationPackage.initializePackageContents();
		theLtlPackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		thePropositionallogicPackage.initializePackageContents();
		theTadlPackage.initializePackageContents();
		theUcmPackage.initializePackageContents();
		theVerificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTraceabilityPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TraceabilityPackage.eNS_URI, theTraceabilityPackage);
		return theTraceabilityPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepMappingAnnotation()
	{
		return stepMappingAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStepMappingAnnotation_Step()
	{
		return (EReference)stepMappingAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateTypeMappingAnnotation()
	{
		return stateTypeMappingAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateTypeMappingAnnotation_StateType()
	{
		return (EAttribute)stateTypeMappingAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseCaseMappingAnnotation()
	{
		return useCaseMappingAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseCaseMappingAnnotation_UseCase()
	{
		return (EReference)useCaseMappingAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOverviewTransitionTypeAnnotation()
	{
		return overviewTransitionTypeAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOverviewTransitionTypeAnnotation_OverviewTransitionType()
	{
		return (EAttribute)overviewTransitionTypeAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMappingAnnotation()
	{
		return stateMappingAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMappingAnnotation_State()
	{
		return (EReference)stateMappingAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFormulaIdentificationAnnotation()
	{
		return formulaIdentificationAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormulaIdentificationAnnotation_Group()
	{
		return (EReference)formulaIdentificationAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFormulaIdentificationAnnotation_FormulaHolder()
	{
		return (EReference)formulaIdentificationAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStateType()
	{
		return stateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOverviewTransitionType()
	{
		return overviewTransitionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityFactory getTraceabilityFactory()
	{
		return (TraceabilityFactory)getEFactoryInstance();
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
		stepMappingAnnotationEClass = createEClass(STEP_MAPPING_ANNOTATION);
		createEReference(stepMappingAnnotationEClass, STEP_MAPPING_ANNOTATION__STEP);

		stateTypeMappingAnnotationEClass = createEClass(STATE_TYPE_MAPPING_ANNOTATION);
		createEAttribute(stateTypeMappingAnnotationEClass, STATE_TYPE_MAPPING_ANNOTATION__STATE_TYPE);

		useCaseMappingAnnotationEClass = createEClass(USE_CASE_MAPPING_ANNOTATION);
		createEReference(useCaseMappingAnnotationEClass, USE_CASE_MAPPING_ANNOTATION__USE_CASE);

		overviewTransitionTypeAnnotationEClass = createEClass(OVERVIEW_TRANSITION_TYPE_ANNOTATION);
		createEAttribute(overviewTransitionTypeAnnotationEClass, OVERVIEW_TRANSITION_TYPE_ANNOTATION__OVERVIEW_TRANSITION_TYPE);

		stateMappingAnnotationEClass = createEClass(STATE_MAPPING_ANNOTATION);
		createEReference(stateMappingAnnotationEClass, STATE_MAPPING_ANNOTATION__STATE);

		formulaIdentificationAnnotationEClass = createEClass(FORMULA_IDENTIFICATION_ANNOTATION);
		createEReference(formulaIdentificationAnnotationEClass, FORMULA_IDENTIFICATION_ANNOTATION__GROUP);
		createEReference(formulaIdentificationAnnotationEClass, FORMULA_IDENTIFICATION_ANNOTATION__FORMULA_HOLDER);

		// Create enums
		stateTypeEEnum = createEEnum(STATE_TYPE);
		overviewTransitionTypeEEnum = createEEnum(OVERVIEW_TRANSITION_TYPE);
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
		LtsPackage theLtsPackage = (LtsPackage)EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI);
		TadlPackage theTadlPackage = (TadlPackage)EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		stepMappingAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		stateTypeMappingAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		useCaseMappingAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		overviewTransitionTypeAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		stateMappingAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());
		formulaIdentificationAnnotationEClass.getESuperTypes().add(theAnnotationPackage.getAnnotation());

		// Initialize classes, features, and operations; add parameters
		initEClass(stepMappingAnnotationEClass, StepMappingAnnotation.class, "StepMappingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStepMappingAnnotation_Step(), theUcmPackage.getStep(), null, "step", null, 1, 1, StepMappingAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTypeMappingAnnotationEClass, StateTypeMappingAnnotation.class, "StateTypeMappingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateTypeMappingAnnotation_StateType(), this.getStateType(), "stateType", null, 1, 1, StateTypeMappingAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useCaseMappingAnnotationEClass, UseCaseMappingAnnotation.class, "UseCaseMappingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseCaseMappingAnnotation_UseCase(), theUcmPackage.getUseCase(), null, "useCase", null, 1, 1, UseCaseMappingAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(overviewTransitionTypeAnnotationEClass, OverviewTransitionTypeAnnotation.class, "OverviewTransitionTypeAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOverviewTransitionTypeAnnotation_OverviewTransitionType(), this.getOverviewTransitionType(), "overviewTransitionType", null, 1, 1, OverviewTransitionTypeAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateMappingAnnotationEClass, StateMappingAnnotation.class, "StateMappingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMappingAnnotation_State(), theLtsPackage.getState(), null, "state", null, 1, 1, StateMappingAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(formulaIdentificationAnnotationEClass, FormulaIdentificationAnnotation.class, "FormulaIdentificationAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFormulaIdentificationAnnotation_Group(), theTadlPackage.getGroup(), null, "group", null, 1, 1, FormulaIdentificationAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFormulaIdentificationAnnotation_FormulaHolder(), theTadlPackage.getFormulaHolder(), null, "formulaHolder", null, 1, 1, FormulaIdentificationAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(stateTypeEEnum, StateType.class, "StateType");
		addEEnumLiteral(stateTypeEEnum, StateType.IN);
		addEEnumLiteral(stateTypeEEnum, StateType.VAR);
		addEEnumLiteral(stateTypeEEnum, StateType.JMP);
		addEEnumLiteral(stateTypeEEnum, StateType.EXT);
		addEEnumLiteral(stateTypeEEnum, StateType.OUT);

		initEEnum(overviewTransitionTypeEEnum, OverviewTransitionType.class, "OverviewTransitionType");
		addEEnumLiteral(overviewTransitionTypeEEnum, OverviewTransitionType.PRECEDENCE);
		addEEnumLiteral(overviewTransitionTypeEEnum, OverviewTransitionType.INCLUDE);

		// Create resource
		createResource(eNS_URI);
	}

} //TraceabilityPackageImpl
