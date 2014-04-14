/**
 */
package org.foam.ctl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foam.ctl.*;

import org.foam.propositionallogic.BinaryFormula;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.ctl.CtlPackage
 * @generated
 */
public class CtlAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CtlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CtlAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = CtlPackage.eINSTANCE;
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
	protected CtlSwitch<Adapter> modelSwitch =
		new CtlSwitch<Adapter>()
		{
			@Override
			public Adapter caseAllUntil(AllUntil object)
			{
				return createAllUntilAdapter();
			}
			@Override
			public Adapter caseExistsUntil(ExistsUntil object)
			{
				return createExistsUntilAdapter();
			}
			@Override
			public Adapter caseAllGlobally(AllGlobally object)
			{
				return createAllGloballyAdapter();
			}
			@Override
			public Adapter caseAllFinally(AllFinally object)
			{
				return createAllFinallyAdapter();
			}
			@Override
			public Adapter caseAllNext(AllNext object)
			{
				return createAllNextAdapter();
			}
			@Override
			public Adapter caseExistsGlobally(ExistsGlobally object)
			{
				return createExistsGloballyAdapter();
			}
			@Override
			public Adapter caseExistsFinally(ExistsFinally object)
			{
				return createExistsFinallyAdapter();
			}
			@Override
			public Adapter caseExistsNext(ExistsNext object)
			{
				return createExistsNextAdapter();
			}
			@Override
			public Adapter caseFormula(Formula object)
			{
				return createFormulaAdapter();
			}
			@Override
			public Adapter caseBinaryFormula(BinaryFormula object)
			{
				return createBinaryFormulaAdapter();
			}
			@Override
			public Adapter caseUnaryFormula(UnaryFormula object)
			{
				return createUnaryFormulaAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.AllUntil <em>All Until</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.AllUntil
	 * @generated
	 */
	public Adapter createAllUntilAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.ExistsUntil <em>Exists Until</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.ExistsUntil
	 * @generated
	 */
	public Adapter createExistsUntilAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.AllGlobally <em>All Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.AllGlobally
	 * @generated
	 */
	public Adapter createAllGloballyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.AllFinally <em>All Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.AllFinally
	 * @generated
	 */
	public Adapter createAllFinallyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.AllNext <em>All Next</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.AllNext
	 * @generated
	 */
	public Adapter createAllNextAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.ExistsGlobally <em>Exists Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.ExistsGlobally
	 * @generated
	 */
	public Adapter createExistsGloballyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.ExistsFinally <em>Exists Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.ExistsFinally
	 * @generated
	 */
	public Adapter createExistsFinallyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.ctl.ExistsNext <em>Exists Next</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.ctl.ExistsNext
	 * @generated
	 */
	public Adapter createExistsNextAdapter()
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

} //CtlAdapterFactory
