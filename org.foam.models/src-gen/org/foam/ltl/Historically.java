/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Historically</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= H φ iff ∀j ≤ i. (π, j) |= φ
 * 
 * The PLTL operator H (for “Historically”) is the past-time version of G (always in the future), so that Hφ is true iff φ is always true in the past.
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getHistorically()
 * @model
 * @generated
 */
public interface Historically extends UnaryFormula
{
} // Historically
