/**
 */
package org.foam.traceability;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.foam.traceability.TraceabilityPackage
 * @generated
 */
public interface TraceabilityFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceabilityFactory eINSTANCE = org.foam.traceability.impl.TraceabilityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Step Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Mapping Annotation</em>'.
	 * @generated
	 */
	StepMappingAnnotation createStepMappingAnnotation();

	/**
	 * Returns a new object of class '<em>State Type Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Type Mapping Annotation</em>'.
	 * @generated
	 */
	StateTypeMappingAnnotation createStateTypeMappingAnnotation();

	/**
	 * Returns a new object of class '<em>Use Case Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Mapping Annotation</em>'.
	 * @generated
	 */
	UseCaseMappingAnnotation createUseCaseMappingAnnotation();

	/**
	 * Returns a new object of class '<em>Overview Transition Type Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Overview Transition Type Annotation</em>'.
	 * @generated
	 */
	OverviewTransitionTypeAnnotation createOverviewTransitionTypeAnnotation();

	/**
	 * Returns a new object of class '<em>State Mapping Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Mapping Annotation</em>'.
	 * @generated
	 */
	StateMappingAnnotation createStateMappingAnnotation();

	/**
	 * Returns a new object of class '<em>Formula Identification Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Formula Identification Annotation</em>'.
	 * @generated
	 */
	FormulaIdentificationAnnotation createFormulaIdentificationAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TraceabilityPackage getTraceabilityPackage();

} //TraceabilityFactory
