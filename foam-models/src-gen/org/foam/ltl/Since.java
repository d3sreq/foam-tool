/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.BinaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Since</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= φ S ψ iff ∃j ≤ i. ((π, j) |= ψ and ∀k : j < k ≤ i. (π, k) |= φ)
 * 
 * The PLTL operator S (for "Since") is a temporal dual of U (until), so that φSψ is true iff ψ holds somewhere in the past and φ is true from then up to now.
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getSince()
 * @model
 * @generated
 */
public interface Since extends BinaryFormula
{
} // Since
