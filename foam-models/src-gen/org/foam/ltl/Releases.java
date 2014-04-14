/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.BinaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Releases</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= φ R ψ iff ∀j ≥ i. ((π, j) |= ψ or ∃k : i ≤ k < j. (π, k) |= φ)
 * 
 * The R operator can be rewritten using the U operator as follows:
 * φRψ = ¬(¬φU¬ψ)
 * 
 * Note: In NuSMV, the letter "V" is used instead of "R" for this operator.
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getReleases()
 * @model
 * @generated
 */
public interface Releases extends BinaryFormula
{
} // Releases
