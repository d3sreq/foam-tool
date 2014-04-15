/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.BinaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triggered</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= φ T ψ iff ∀j ≤ i. ((π, j) |= ψ or ∃k : j < k ≤ i. (π, k) |= φ)
 * 
 * The PLTL operator T (for “Trigger”) is the temporal dual for R: φTψ = ¬(¬φS¬ψ), exactly as in the future case we have φRψ = ¬(¬φU¬ψ).
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getTriggered()
 * @model
 * @generated
 */
public interface Triggered extends BinaryFormula
{
} // Triggered
