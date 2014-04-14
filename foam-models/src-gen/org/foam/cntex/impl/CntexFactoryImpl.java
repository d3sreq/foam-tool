/**
 */
package org.foam.cntex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.cntex.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CntexFactoryImpl extends EFactoryImpl implements CntexFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CntexFactory init()
	{
		try
		{
			CntexFactory theCntexFactory = (CntexFactory)EPackage.Registry.INSTANCE.getEFactory(CntexPackage.eNS_URI);
			if (theCntexFactory != null)
			{
				return theCntexFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CntexFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntexFactoryImpl()
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
			case CntexPackage.COUNTER_EXAMPLE: return createCounterExample();
			case CntexPackage.CNT_EX_STATE: return createCntExState();
			case CntexPackage.CNT_EX_ASSIGNMENT: return createCntExAssignment();
			case CntexPackage.TRACE: return createTrace();
			case CntexPackage.SPECIFICATION: return createSpecification();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CounterExample createCounterExample()
	{
		CounterExampleImpl counterExample = new CounterExampleImpl();
		return counterExample;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntExState createCntExState()
	{
		CntExStateImpl cntExState = new CntExStateImpl();
		return cntExState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntExAssignment createCntExAssignment()
	{
		CntExAssignmentImpl cntExAssignment = new CntExAssignmentImpl();
		return cntExAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Trace createTrace()
	{
		TraceImpl trace = new TraceImpl();
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Specification createSpecification()
	{
		SpecificationImpl specification = new SpecificationImpl();
		return specification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CntexPackage getCntexPackage()
	{
		return (CntexPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CntexPackage getPackage()
	{
		return CntexPackage.eINSTANCE;
	}

} //CntexFactoryImpl
