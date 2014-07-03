/**
 */
package org.foam.propositionallogic.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.foam.propositionallogic.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropositionallogicFactoryImpl extends EFactoryImpl implements PropositionallogicFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PropositionallogicFactory init()
	{
		try {
			PropositionallogicFactory thePropositionallogicFactory = (PropositionallogicFactory)EPackage.Registry.INSTANCE.getEFactory(PropositionallogicPackage.eNS_URI);
			if (thePropositionallogicFactory != null) {
				return thePropositionallogicFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PropositionallogicFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionallogicFactoryImpl()
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
		switch (eClass.getClassifierID()) {
			case PropositionallogicPackage.VARIABLE_DEFINITION: return createVariableDefinition();
			case PropositionallogicPackage.NOT: return createNot();
			case PropositionallogicPackage.AND: return createAnd();
			case PropositionallogicPackage.OR: return createOr();
			case PropositionallogicPackage.IMPLICATION: return createImplication();
			case PropositionallogicPackage.EQUIVALENCE: return createEquivalence();
			case PropositionallogicPackage.VARIABLE_USE: return createVariableUse();
			case PropositionallogicPackage.TRUE: return createTrue();
			case PropositionallogicPackage.FALSE: return createFalse();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDefinition createVariableDefinition()
	{
		VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
		return variableDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Not createNot()
	{
		NotImpl not = new NotImpl();
		return not;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd()
	{
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr()
	{
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implication createImplication()
	{
		ImplicationImpl implication = new ImplicationImpl();
		return implication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equivalence createEquivalence()
	{
		EquivalenceImpl equivalence = new EquivalenceImpl();
		return equivalence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableUse createVariableUse()
	{
		VariableUseImpl variableUse = new VariableUseImpl();
		return variableUse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public True createTrue()
	{
		TrueImpl true_ = new TrueImpl();
		return true_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public False createFalse()
	{
		FalseImpl false_ = new FalseImpl();
		return false_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropositionallogicPackage getPropositionallogicPackage()
	{
		return (PropositionallogicPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PropositionallogicPackage getPackage()
	{
		return PropositionallogicPackage.eINSTANCE;
	}

} //PropositionallogicFactoryImpl
