/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.foam.propositionallogic.PropositionallogicPackage;

import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.PropositionalLogicXtextPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextFactory
 * @model kind="package"
 * @generated
 */
public interface PropositionalLogicXtextPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "propositionalLogicXtext";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "propositionalLogicXtext";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "propositionalLogicXtext";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PropositionalLogicXtextPackage eINSTANCE = PropositionalLogicXtextPackageImpl.init();

  /**
   * The meta object id for the '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.RuleVariableUseImpl <em>Rule Variable Use</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.RuleVariableUseImpl
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.PropositionalLogicXtextPackageImpl#getRuleVariableUse()
   * @generated
   */
  int RULE_VARIABLE_USE = 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_VARIABLE_USE__VARIABLE = PropositionallogicPackage.FORMULA_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule Variable Use</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_VARIABLE_USE_FEATURE_COUNT = PropositionallogicPackage.FORMULA_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse <em>Rule Variable Use</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Variable Use</em>'.
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse
   * @generated
   */
  EClass getRuleVariableUse();

  /**
   * Returns the meta object for the attribute '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable</em>'.
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse#getVariable()
   * @see #getRuleVariableUse()
   * @generated
   */
  EAttribute getRuleVariableUse_Variable();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PropositionalLogicXtextFactory getPropositionalLogicXtextFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.RuleVariableUseImpl <em>Rule Variable Use</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.RuleVariableUseImpl
     * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.impl.PropositionalLogicXtextPackageImpl#getRuleVariableUse()
     * @generated
     */
    EClass RULE_VARIABLE_USE = eINSTANCE.getRuleVariableUse();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_VARIABLE_USE__VARIABLE = eINSTANCE.getRuleVariableUse_Variable();

  }

} //PropositionalLogicXtextPackage
