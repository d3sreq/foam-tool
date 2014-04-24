/**
 */
package org.foam.ltl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.ltl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LtlFactoryImpl extends EFactoryImpl implements LtlFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LtlFactory init()
	{
		try
		{
			LtlFactory theLtlFactory = (LtlFactory)EPackage.Registry.INSTANCE.getEFactory(LtlPackage.eNS_URI);
			if (theLtlFactory != null)
			{
				return theLtlFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LtlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case LtlPackage.GLOBALLY: return createGlobally();
			case LtlPackage.FUTURE: return createFuture();
			case LtlPackage.NEXT: return createNext();
			case LtlPackage.UNTIL: return createUntil();
			case LtlPackage.HISTORICALLY: return createHistorically();
			case LtlPackage.ONCE: return createOnce();
			case LtlPackage.RELEASES: return createReleases();
			case LtlPackage.SINCE: return createSince();
			case LtlPackage.TRIGGERED: return createTriggered();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Globally createGlobally()
	{
		GloballyImpl globally = new GloballyImpl();
		return globally;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Future createFuture()
	{
		FutureImpl future = new FutureImpl();
		return future;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Next createNext()
	{
		NextImpl next = new NextImpl();
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Until createUntil()
	{
		UntilImpl until = new UntilImpl();
		return until;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Historically createHistorically()
	{
		HistoricallyImpl historically = new HistoricallyImpl();
		return historically;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Once createOnce()
	{
		OnceImpl once = new OnceImpl();
		return once;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Releases createReleases()
	{
		ReleasesImpl releases = new ReleasesImpl();
		return releases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Since createSince()
	{
		SinceImpl since = new SinceImpl();
		return since;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Triggered createTriggered()
	{
		TriggeredImpl triggered = new TriggeredImpl();
		return triggered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlPackage getLtlPackage()
	{
		return (LtlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LtlPackage getPackage()
	{
		return LtlPackage.eINSTANCE;
	}

} //LtlFactoryImpl
