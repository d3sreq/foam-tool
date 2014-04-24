/**
 */
package org.foam.ltl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.ltl.Future;
import org.foam.ltl.Globally;
import org.foam.ltl.Historically;
import org.foam.ltl.LtlFactory;
import org.foam.ltl.LtlPackage;
import org.foam.ltl.Next;
import org.foam.ltl.Once;
import org.foam.ltl.Releases;
import org.foam.ltl.Since;
import org.foam.ltl.Triggered;
import org.foam.ltl.Until;

import org.foam.propositionallogic.PropositionallogicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LtlPackageImpl extends EPackageImpl implements LtlPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass globallyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass futureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass untilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass historicallyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass releasesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sinceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggeredEClass = null;

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
	 * @see org.foam.ltl.LtlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LtlPackageImpl()
	{
		super(eNS_URI, LtlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LtlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LtlPackage init()
	{
		if (isInited) return (LtlPackage)EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI);

		// Obtain or create and register package
		LtlPackageImpl theLtlPackage = (LtlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LtlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LtlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PropositionallogicPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLtlPackage.createPackageContents();

		// Initialize created meta-data
		theLtlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLtlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LtlPackage.eNS_URI, theLtlPackage);
		return theLtlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGlobally()
	{
		return globallyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuture()
	{
		return futureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNext()
	{
		return nextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUntil()
	{
		return untilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHistorically()
	{
		return historicallyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnce()
	{
		return onceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReleases()
	{
		return releasesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSince()
	{
		return sinceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggered()
	{
		return triggeredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlFactory getLtlFactory()
	{
		return (LtlFactory)getEFactoryInstance();
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
		globallyEClass = createEClass(GLOBALLY);

		futureEClass = createEClass(FUTURE);

		nextEClass = createEClass(NEXT);

		untilEClass = createEClass(UNTIL);

		historicallyEClass = createEClass(HISTORICALLY);

		onceEClass = createEClass(ONCE);

		releasesEClass = createEClass(RELEASES);

		sinceEClass = createEClass(SINCE);

		triggeredEClass = createEClass(TRIGGERED);
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
		globallyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		futureEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		nextEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		untilEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());
		historicallyEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		onceEClass.getESuperTypes().add(thePropositionallogicPackage.getUnaryFormula());
		releasesEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());
		sinceEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());
		triggeredEClass.getESuperTypes().add(thePropositionallogicPackage.getBinaryFormula());

		// Initialize classes, features, and operations; add parameters
		initEClass(globallyEClass, Globally.class, "Globally", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(futureEClass, Future.class, "Future", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nextEClass, Next.class, "Next", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(untilEClass, Until.class, "Until", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(historicallyEClass, Historically.class, "Historically", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(onceEClass, Once.class, "Once", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(releasesEClass, Releases.class, "Releases", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sinceEClass, Since.class, "Since", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(triggeredEClass, Triggered.class, "Triggered", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //LtlPackageImpl