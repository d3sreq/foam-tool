/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext;

import org.eclipse.emf.ecore.EFactory;

import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.PropositionalLogicXtextFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage
 * @generated
 */
public interface PropositionalLogicXtextFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PropositionalLogicXtextFactory eINSTANCE = PropositionalLogicXtextFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Rule Variable Use</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Variable Use</em>'.
   * @generated
   */
  RuleVariableUse createRuleVariableUse();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  PropositionalLogicXtextPackage getPropositionalLogicXtextPackage();

} //PropositionalLogicXtextFactory
