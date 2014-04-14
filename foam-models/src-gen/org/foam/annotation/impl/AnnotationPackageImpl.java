/**
 */
package org.foam.annotation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.annotation.Annotable;
import org.foam.annotation.Annotation;
import org.foam.annotation.AnnotationFactory;
import org.foam.annotation.AnnotationPackage;
import org.foam.annotation.UnknownAnnotation;

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

import org.foam.traceability.TraceabilityPackage;

import org.foam.traceability.impl.TraceabilityPackageImpl;

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
public class AnnotationPackageImpl extends EPackageImpl implements AnnotationPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unknownAnnotationEClass = null;

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
	 * @see org.foam.annotation.AnnotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnnotationPackageImpl()
	{
		super(eNS_URI, AnnotationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AnnotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnnotationPackage init()
	{
		if (isInited) return (AnnotationPackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI);

		// Obtain or create and register package
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnnotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CntexPackageImpl theCntexPackage = (CntexPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) instanceof CntexPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) : CntexPackage.eINSTANCE);
		CtlPackageImpl theCtlPackage = (CtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) instanceof CtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) : CtlPackage.eINSTANCE);
		DotPackageImpl theDotPackage = (DotPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DotPackage.eNS_URI) instanceof DotPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DotPackage.eNS_URI) : DotPackage.eINSTANCE);
		FlowannotationPackageImpl theFlowannotationPackage = (FlowannotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) instanceof FlowannotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) : FlowannotationPackage.eINSTANCE);
		LtlPackageImpl theLtlPackage = (LtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) instanceof LtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) : LtlPackage.eINSTANCE);
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		PropositionallogicPackageImpl thePropositionallogicPackage = (PropositionallogicPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) instanceof PropositionallogicPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) : PropositionallogicPackage.eINSTANCE);
		TadlPackageImpl theTadlPackage = (TadlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) instanceof TadlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) : TadlPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		UcmPackageImpl theUcmPackage = (UcmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) instanceof UcmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) : UcmPackage.eINSTANCE);
		VerificationPackageImpl theVerificationPackage = (VerificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) instanceof VerificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) : VerificationPackage.eINSTANCE);

		// Create package meta-data objects
		theAnnotationPackage.createPackageContents();
		theCntexPackage.createPackageContents();
		theCtlPackage.createPackageContents();
		theDotPackage.createPackageContents();
		theFlowannotationPackage.createPackageContents();
		theLtlPackage.createPackageContents();
		theLtsPackage.createPackageContents();
		thePropositionallogicPackage.createPackageContents();
		theTadlPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theUcmPackage.createPackageContents();
		theVerificationPackage.createPackageContents();

		// Initialize created meta-data
		theAnnotationPackage.initializePackageContents();
		theCntexPackage.initializePackageContents();
		theCtlPackage.initializePackageContents();
		theDotPackage.initializePackageContents();
		theFlowannotationPackage.initializePackageContents();
		theLtlPackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		thePropositionallogicPackage.initializePackageContents();
		theTadlPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theUcmPackage.initializePackageContents();
		theVerificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnnotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnnotationPackage.eNS_URI, theAnnotationPackage);
		return theAnnotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotable()
	{
		return annotableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotable_Annotations()
	{
		return (EReference)annotableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation()
	{
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnknownAnnotation()
	{
		return unknownAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnknownAnnotation_Parts()
	{
		return (EAttribute)unknownAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationFactory getAnnotationFactory()
	{
		return (AnnotationFactory)getEFactoryInstance();
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
		annotableEClass = createEClass(ANNOTABLE);
		createEReference(annotableEClass, ANNOTABLE__ANNOTATIONS);

		annotationEClass = createEClass(ANNOTATION);

		unknownAnnotationEClass = createEClass(UNKNOWN_ANNOTATION);
		createEAttribute(unknownAnnotationEClass, UNKNOWN_ANNOTATION__PARTS);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		unknownAnnotationEClass.getESuperTypes().add(this.getAnnotation());

		// Initialize classes, features, and operations; add parameters
		initEClass(annotableEClass, Annotable.class, "Annotable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotable_Annotations(), this.getAnnotation(), null, "annotations", null, 0, -1, Annotable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationEClass, Annotation.class, "Annotation", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unknownAnnotationEClass, UnknownAnnotation.class, "UnknownAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnknownAnnotation_Parts(), ecorePackage.getEString(), "parts", null, 0, -1, UnknownAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AnnotationPackageImpl
