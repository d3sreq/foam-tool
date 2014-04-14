/**
 */
package org.foam.ltl;

import org.foam.propositionallogic.UnaryFormula;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Next</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Semantics: (π, i) |= X φ iff (π, i + 1) |= φ
 * 
 * "In the next state"
 * Important: Use this operator with caution because we add artificial states in NuSMV for non-determinisitc guards and for actions (valuations of variables).
 * <!-- end-model-doc -->
 *
 *
 * @see org.foam.ltl.LtlPackage#getNext()
 * @model
 * @generated
 */
public interface Next extends UnaryFormula
{
} // Next
