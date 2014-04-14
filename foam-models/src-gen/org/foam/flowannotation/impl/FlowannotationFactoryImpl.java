/**
 */
package org.foam.flowannotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.flowannotation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowannotationFactoryImpl extends EFactoryImpl implements FlowannotationFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FlowannotationFactory init()
	{
		try
		{
			FlowannotationFactory theFlowannotationFactory = (FlowannotationFactory)EPackage.Registry.INSTANCE.getEFactory(FlowannotationPackage.eNS_URI);
			if (theFlowannotationFactory != null)
			{
				return theFlowannotationFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FlowannotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowannotationFactoryImpl()
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
			case FlowannotationPackage.ABORT: return createAbort();
			case FlowannotationPackage.GOTO: return createGoto();
			case FlowannotationPackage.GUARD: return createGuard();
			case FlowannotationPackage.INCLUDE: return createInclude();
			case FlowannotationPackage.MARK: return createMark();
			case FlowannotationPackage.VARIABLE_DEFINITION_ANNOTATION: return createVariableDefinitionAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Abort createAbort()
	{
		AbortImpl abort = new AbortImpl();
		return abort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goto createGoto()
	{
		GotoImpl goto_ = new GotoImpl();
		return goto_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Guard createGuard()
	{
		GuardImpl guard = new GuardImpl();
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Include createInclude()
	{
		IncludeImpl include = new IncludeImpl();
		return include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mark createMark()
	{
		MarkImpl mark = new MarkImpl();
		return mark;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinitionAnnotation createVariableDefinitionAnnotation()
	{
		VariableDefinitionAnnotationImpl variableDefinitionAnnotation = new VariableDefinitionAnnotationImpl();
		return variableDefinitionAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowannotationPackage getFlowannotationPackage()
	{
		return (FlowannotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FlowannotationPackage getPackage()
	{
		return FlowannotationPackage.eINSTANCE;
	}

} //FlowannotationFactoryImpl
