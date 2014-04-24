/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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

import org.foam.propositionallogic.PropositionallogicPackage;

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
		PropositionallogicPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCtlPackage.createPackageContents();

		// Initialize created meta-data
		theCtlPackage.initializePackageContents();

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
