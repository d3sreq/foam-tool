/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.annotation.AnnotationPackage;

import org.foam.annotation.impl.AnnotationPackageImpl;

import org.foam.cntex.CntexPackage;

import org.foam.cntex.impl.CntexPackageImpl;

import org.foam.ctl.AllFinally;
import org.foam.ctl.AllGlobally;
import org.foam.ctl.AllNext;
import org.foam.ctl.AllUntil;
import org.foam.ctl.CtlFactory;
import org.foam.ctl.CtlPackage;
import org.foam.ctl.ExistsFinally;
import org.foam.ctl.ExistsGlobally;
import org.foam.ctl.ExistsNext;
import org.foam.ctl.ExistsUntil;

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
public class CtlPackageImpl extends EPackageImpl implements CtlPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allUntilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsUntilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allGloballyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allFinallyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allNextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsGloballyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsFinallyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass existsNextEClass = null;

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
	 * @see org.foam.ctl.CtlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CtlPackageImpl()
	{
		super(eNS_URI, CtlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CtlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CtlPackage init()
	{
		if (isInited) return (CtlPackage)EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI);

		// Obtain or create and register package
		CtlPackageImpl theCtlPackage = (CtlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CtlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CtlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) : AnnotationPackage.eINSTANCE);
		CntexPackageImpl theCntexPackage = (CntexPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) instanceof CntexPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) : CntexPackage.eINSTANCE);
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
		theCtlPackage.createPackageContents();
		theAnnotationPackage.createPackageContents();
		theCntexPackage.createPackageContents();
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
		theCtlPackage.initializePackageContents();
		theAnnotationPackage.initializePackageContents();
		theCntexPackage.initializePackageContents();
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
		theCtlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CtlPackage.eNS_URI, theCtlPackage);
		return theCtlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllUntil()
	{
		return allUntilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExistsUntil()
	{
		return existsUntilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllGlobally()
	{
		return allGloballyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllFinally()
	{
		return allFinallyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllNext()
	{
		return allNextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExistsGlobally()
	{
		return existsGloballyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExistsFinally()
	{
		return existsFinallyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExistsNext()
	{
		return existsNextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CtlFactory getCtlFactory()
	{
		return (CtlFactory)getEFactoryInstance();
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
		allUntilEClass = createEClass(ALL_UNTIL);

		existsUntilEClass = createEClass(EXISTS_UNTIL);

		allGloballyEClass = createEClass(ALL_GLOBALLY);

		allFinallyEClass = createEClass(ALL_FINALLY);

		allNextEClass = createEClass(ALL_NEXT);

		existsGloballyEClass = createEClass(EXISTS_GLOBALLY);

		existsFinallyEClass = createEClass(EXISTS_FINALLY);

		existsNextEClass = createEClass(EXISTS_NEXT);
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
		PropositionallogicPackage thePropositionallogicPackage = (PropositionallogicPackage)EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		allUntilEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());
		existsUntilEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());
		allGloballyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		allFinallyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		allNextEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		existsGloballyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		existsFinallyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		existsNextEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());

		// Initialize classes, features, and operations; add parameters
		initEClass(allUntilEClass, AllUntil.class, "AllUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(existsUntilEClass, ExistsUntil.class, "ExistsUntil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allGloballyEClass, AllGlobally.class, "AllGlobally", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allFinallyEClass, AllFinally.class, "AllFinally", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(allNextEClass, AllNext.class, "AllNext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(existsGloballyEClass, ExistsGlobally.class, "ExistsGlobally", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(existsFinallyEClass, ExistsFinally.class, "ExistsFinally", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(existsNextEClass, ExistsNext.class, "ExistsNext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CtlPackageImpl
