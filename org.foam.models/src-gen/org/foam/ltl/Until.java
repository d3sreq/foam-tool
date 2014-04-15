/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.BinaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Until</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= φ U ψ iff ∃j ≥ i. ((π, j) |= ψ and ∀k : i ≤ k < j. (π, k) |= φ)
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getUntil()
 * @model
 * @generated
 */
public interface Until extends BinaryFormula
{
} // Until
