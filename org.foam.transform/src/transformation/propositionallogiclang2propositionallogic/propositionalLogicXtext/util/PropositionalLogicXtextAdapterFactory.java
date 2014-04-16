/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.foam.propositionallogic.Formula;

import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage
 * @generated
 */
public class PropositionalLogicXtextAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PropositionalLogicXtextPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropositionalLogicXtextAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = PropositionalLogicXtextPackage.eINSTANCE;
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
	protected PropositionalLogicXtextSwitch<Adapter> modelSwitch = new PropositionalLogicXtextSwitch<Adapter>() {
		@Override
		public Adapter caseRuleVariableUse(RuleVariableUse object) {
			return createRuleVariableUseAdapter();
		}

		@Override
		public Adapter caseFormula(Formula object) {
			return createFormulaAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
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
   * Creates a new adapter for an object of class '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse <em>Rule Variable Use</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse
   * @generated
   */
  public Adapter createRuleVariableUseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link propositionallogic.Formula <em>Formula</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see propositionallogic.Formula
   * @generated
   */
  public Adapter createFormulaAdapter()
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

} //PropositionalLogicXtextAdapterFactory
