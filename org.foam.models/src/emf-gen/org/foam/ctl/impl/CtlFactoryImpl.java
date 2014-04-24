/**
 */
package org.foam.ctl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.ctl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CtlFactoryImpl extends EFactoryImpl implements CtlFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CtlFactory init()
	{
		try
		{
			CtlFactory theCtlFactory = (CtlFactory)EPackage.Registry.INSTANCE.getEFactory(CtlPackage.eNS_URI);
			if (theCtlFactory != null)
			{
				return theCtlFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CtlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CtlFactoryImpl()
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
			case CtlPackage.ALL_UNTIL: return createAllUntil();
			case CtlPackage.EXISTS_UNTIL: return createExistsUntil();
			case CtlPackage.ALL_GLOBALLY: return createAllGlobally();
			case CtlPackage.ALL_FINALLY: return createAllFinally();
			case CtlPackage.ALL_NEXT: return createAllNext();
			case CtlPackage.EXISTS_GLOBALLY: return createExistsGlobally();
			case CtlPackage.EXISTS_FINALLY: return createExistsFinally();
			case CtlPackage.EXISTS_NEXT: return createExistsNext();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllUntil createAllUntil()
	{
		AllUntilImpl allUntil = new AllUntilImpl();
		return allUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsUntil createExistsUntil()
	{
		ExistsUntilImpl existsUntil = new ExistsUntilImpl();
		return existsUntil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllGlobally createAllGlobally()
	{
		AllGloballyImpl allGlobally = new AllGloballyImpl();
		return allGlobally;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllFinally createAllFinally()
	{
		AllFinallyImpl allFinally = new AllFinallyImpl();
		return allFinally;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllNext createAllNext()
	{
		AllNextImpl allNext = new AllNextImpl();
		return allNext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsGlobally createExistsGlobally()
	{
		ExistsGloballyImpl existsGlobally = new ExistsGloballyImpl();
		return existsGlobally;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsFinally createExistsFinally()
	{
		ExistsFinallyImpl existsFinally = new ExistsFinallyImpl();
		return existsFinally;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistsNext createExistsNext()
	{
		ExistsNextImpl existsNext = new ExistsNextImpl();
		return existsNext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CtlPackage getCtlPackage()
	{
		return (CtlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CtlPackage getPackage()
	{
		return CtlPackage.eINSTANCE;
	}

} //CtlFactoryImpl
