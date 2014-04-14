/**
 */
package org.foam.ucm.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foam.annotation.Annotable;

import org.foam.ucm.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.ucm.UcmPackage
 * @generated
 */
public class UcmAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UcmPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UcmAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = UcmPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UcmSwitch<Adapter> modelSwitch =
		new UcmSwitch<Adapter>()
		{
			@Override
			public Adapter caseUseCaseModel(UseCaseModel object)
			{
				return createUseCaseModelAdapter();
			}
			@Override
			public Adapter caseUseCase(UseCase object)
			{
				return createUseCaseAdapter();
			}
			@Override
			public Adapter caseStepToScenarioHolderMapEntry(Map.Entry<Step, ScenarioHolder> object)
			{
				return createStepToScenarioHolderMapEntryAdapter();
			}
			@Override
			public Adapter caseScenario(Scenario object)
			{
				return createScenarioAdapter();
			}
			@Override
			public Adapter caseStep(Step object)
			{
				return createStepAdapter();
			}
			@Override
			public Adapter caseScenarioHolder(ScenarioHolder object)
			{
				return createScenarioHolderAdapter();
			}
			@Override
			public Adapter caseAnnotable(Annotable object)
			{
				return createAnnotableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ucm.UseCaseModel <em>Use Case Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ucm.UseCaseModel
	 * @generated
	 */
	public Adapter createUseCaseModelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ucm.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ucm.UseCase
	 * @generated
	 */
	public Adapter createUseCaseAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>Step To Scenario Holder Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStepToScenarioHolderMapEntryAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ucm.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ucm.Scenario
	 * @generated
	 */
	public Adapter createScenarioAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ucm.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ucm.Step
	 * @generated
	 */
	public Adapter createStepAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ucm.ScenarioHolder <em>Scenario Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ucm.ScenarioHolder
	 * @generated
	 */
	public Adapter createScenarioHolderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.annotation.Annotable <em>Annotable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.annotation.Annotable
	 * @generated
	 */
	public Adapter createAnnotableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //UcmAdapterFactory
