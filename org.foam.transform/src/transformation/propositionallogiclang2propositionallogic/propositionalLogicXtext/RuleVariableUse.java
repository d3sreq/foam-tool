/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext;

import org.foam.propositionallogic.Formula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Variable Use</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage#getRuleVariableUse()
 * @model
 * @generated
 */
public interface RuleVariableUse extends Formula
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage#getRuleVariableUse_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

} // RuleVariableUse
