/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextFactory;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropositionalLogicXtextFactoryImpl extends EFactoryImpl implements PropositionalLogicXtextFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static PropositionalLogicXtextFactory init()
  {
    try
    {
      PropositionalLogicXtextFactory thePropositionalLogicXtextFactory = (PropositionalLogicXtextFactory)EPackage.Registry.INSTANCE.getEFactory(PropositionalLogicXtextPackage.eNS_URI);
      if (thePropositionalLogicXtextFactory != null)
      {
        return thePropositionalLogicXtextFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new PropositionalLogicXtextFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropositionalLogicXtextFactoryImpl()
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
      case PropositionalLogicXtextPackage.RULE_VARIABLE_USE: return createRuleVariableUse();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleVariableUse createRuleVariableUse()
  {
    RuleVariableUseImpl ruleVariableUse = new RuleVariableUseImpl();
    return ruleVariableUse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropositionalLogicXtextPackage getPropositionalLogicXtextPackage()
  {
    return (PropositionalLogicXtextPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static PropositionalLogicXtextPackage getPackage()
  {
    return PropositionalLogicXtextPackage.eINSTANCE;
  }

} //PropositionalLogicXtextFactoryImpl
