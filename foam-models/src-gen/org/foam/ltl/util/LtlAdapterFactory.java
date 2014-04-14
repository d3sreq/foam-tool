/**
 */
package org.foam.ltl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foam.ltl.*;

import org.foam.propositionallogic.BinaryFormula;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.ltl.LtlPackage
 * @generated
 */
public class LtlAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LtlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LtlAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = LtlPackage.eINSTANCE;
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
	protected LtlSwitch<Adapter> modelSwitch =
		new LtlSwitch<Adapter>()
		{
			@Override
			public Adapter caseGlobally(Globally object)
			{
				return createGloballyAdapter();
			}
			@Override
			public Adapter caseFuture(Future object)
			{
				return createFutureAdapter();
			}
			@Override
			public Adapter caseNext(Next object)
			{
				return createNextAdapter();
			}
			@Override
			public Adapter caseUntil(Until object)
			{
				return createUntilAdapter();
			}
			@Override
			public Adapter caseHistorically(Historically object)
			{
				return createHistoricallyAdapter();
			}
			@Override
			public Adapter caseOnce(Once object)
			{
				return createOnceAdapter();
			}
			@Override
			public Adapter caseReleases(Releases object)
			{
				return createReleasesAdapter();
			}
			@Override
			public Adapter caseSince(Since object)
			{
				return createSinceAdapter();
			}
			@Override
			public Adapter caseTriggered(Triggered object)
			{
				return createTriggeredAdapter();
			}
			@Override
			public Adapter caseFormula(Formula object)
			{
				return createFormulaAdapter();
			}
			@Override
			public Adapter caseUnaryFormula(UnaryFormula object)
			{
				return createUnaryFormulaAdapter();
			}
			@Override
			public Adapter caseBinaryFormula(BinaryFormula object)
			{
				return createBinaryFormulaAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Globally <em>Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Globally
	 * @generated
	 */
	public Adapter createGloballyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Future <em>Future</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Future
	 * @generated
	 */
	public Adapter createFutureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Next <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Next
	 * @generated
	 */
	public Adapter createNextAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Until <em>Until</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Until
	 * @generated
	 */
	public Adapter createUntilAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Historically <em>Historically</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Historically
	 * @generated
	 */
	public Adapter createHistoricallyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Once <em>Once</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Once
	 * @generated
	 */
	public Adapter createOnceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Releases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Releases
	 * @generated
	 */
	public Adapter createReleasesAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Since <em>Since</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Since
	 * @generated
	 */
	public Adapter createSinceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ltl.Triggered <em>Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ltl.Triggered
	 * @generated
	 */
	public Adapter createTriggeredAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.Formula <em>Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.Formula
	 * @generated
	 */
	public Adapter createFormulaAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.UnaryFormula <em>Unary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.UnaryFormula
	 * @generated
	 */
	public Adapter createUnaryFormulaAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.BinaryFormula <em>Binary Formula</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.BinaryFormula
	 * @generated
	 */
	public Adapter createBinaryFormulaAdapter()
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

} //LtlAdapterFactory
