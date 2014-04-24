/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Once</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= O φ iff ∃j ≤ i. (π, j) |= φ
 * 
 * The PLTL operator O (for “Once”) is the temporal dual of F, so Oφ is true iff φ is true at some past time instant (including the present time).
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getOnce()
 * @model
 * @generated
 */
public interface Once extends UnaryFormula
{
} // Once
