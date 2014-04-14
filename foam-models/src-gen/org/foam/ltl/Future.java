/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Future</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= F φ iff ∃j ≥ i. (π, j) |= φ
 * 
 * "Sometimes in the future" (but on every possible path)
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getFuture()
 * @model
 * @generated
 */
public interface Future extends UnaryFormula
{
} // Future
