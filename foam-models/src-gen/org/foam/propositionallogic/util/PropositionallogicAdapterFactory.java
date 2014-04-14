/**
 */
package org.foam.propositionallogic.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.foam.propositionallogic.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.propositionallogic.PropositionallogicPackage
 * @generated
 */
public class PropositionallogicAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PropositionallogicPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionallogicAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = PropositionallogicPackage.eINSTANCE;
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
	protected PropositionallogicSwitch<Adapter> modelSwitch =
		new PropositionallogicSwitch<Adapter>()
		{
			@Override
			public Adapter caseVariableDefinition(VariableDefinition object)
			{
				return createVariableDefinitionAdapter();
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
			public Adapter caseNot(Not object)
			{
				return createNotAdapter();
			}
			@Override
			public Adapter caseAnd(And object)
			{
				return createAndAdapter();
			}
			@Override
			public Adapter caseOr(Or object)
			{
				return createOrAdapter();
			}
			@Override
			public Adapter caseImplication(Implication object)
			{
				return createImplicationAdapter();
			}
			@Override
			public Adapter caseEquivalence(Equivalence object)
			{
				return createEquivalenceAdapter();
			}
			@Override
			public Adapter caseVariableUse(VariableUse object)
			{
				return createVariableUseAdapter();
			}
			@Override
			public Adapter caseTrue(True object)
			{
				return createTrueAdapter();
			}
			@Override
			public Adapter caseFalse(False object)
			{
				return createFalseAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.VariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.VariableDefinition
	 * @generated
	 */
	public Adapter createVariableDefinitionAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.Not <em>Not</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.Not
	 * @generated
	 */
	public Adapter createNotAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.And
	 * @generated
	 */
	public Adapter createAndAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.Or
	 * @generated
	 */
	public Adapter createOrAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.Implication <em>Implication</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.Implication
	 * @generated
	 */
	public Adapter createImplicationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.Equivalence <em>Equivalence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.Equivalence
	 * @generated
	 */
	public Adapter createEquivalenceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.VariableUse <em>Variable Use</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.VariableUse
	 * @generated
	 */
	public Adapter createVariableUseAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.True <em>True</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.True
	 * @generated
	 */
	public Adapter createTrueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.foam.propositionallogic.False <em>False</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.foam.propositionallogic.False
	 * @generated
	 */
	public Adapter createFalseAdapter()
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

} //PropositionallogicAdapterFactory
