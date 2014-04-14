/**
 */
package org.foam.ltl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.foam.propositionallogic.PropositionallogicPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.foam.ltl.LtlFactory
 * @model kind="package"
 * @generated
 */
public interface LtlPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ltl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ltl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ltl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LtlPackage eINSTANCE = org.foam.ltl.impl.LtlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.GloballyImpl <em>Globally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.GloballyImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getGlobally()
	 * @generated
	 */
	int GLOBALLY = 0;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.FutureImpl <em>Future</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.FutureImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getFuture()
	 * @generated
	 */
	int FUTURE = 1;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Future</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Future</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUTURE_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.NextImpl <em>Next</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.NextImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getNext()
	 * @generated
	 */
	int NEXT = 2;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.UntilImpl <em>Until</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.UntilImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getUntil()
	 * @generated
	 */
	int UNTIL = 3;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTIL_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.HistoricallyImpl <em>Historically</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.HistoricallyImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getHistorically()
	 * @generated
	 */
	int HISTORICALLY = 4;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORICALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Historically</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORICALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Historically</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORICALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.OnceImpl <em>Once</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.OnceImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getOnce()
	 * @generated
	 */
	int ONCE = 5;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONCE_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.ReleasesImpl <em>Releases</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.ReleasesImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getReleases()
	 * @generated
	 */
	int RELEASES = 6;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASES__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASES__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Releases</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASES_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Releases</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASES_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.SinceImpl <em>Since</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.SinceImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getSince()
	 * @generated
	 */
	int SINCE = 7;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINCE__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINCE__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Since</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINCE_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Since</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINCE_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ltl.impl.TriggeredImpl <em>Triggered</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ltl.impl.TriggeredImpl
	 * @see org.foam.ltl.impl.LtlPackageImpl#getTriggered()
	 * @generated
	 */
	int TRIGGERED = 8;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Triggered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Triggered</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Globally <em>Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Globally</em>'.
	 * @see org.foam.ltl.Globally
	 * @generated
	 */
	EClass getGlobally();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Future <em>Future</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Future</em>'.
	 * @see org.foam.ltl.Future
	 * @generated
	 */
	EClass getFuture();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Next <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next</em>'.
	 * @see org.foam.ltl.Next
	 * @generated
	 */
	EClass getNext();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Until <em>Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Until</em>'.
	 * @see org.foam.ltl.Until
	 * @generated
	 */
	EClass getUntil();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Historically <em>Historically</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Historically</em>'.
	 * @see org.foam.ltl.Historically
	 * @generated
	 */
	EClass getHistorically();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Once <em>Once</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Once</em>'.
	 * @see org.foam.ltl.Once
	 * @generated
	 */
	EClass getOnce();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Releases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Releases</em>'.
	 * @see org.foam.ltl.Releases
	 * @generated
	 */
	EClass getReleases();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Since <em>Since</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Since</em>'.
	 * @see org.foam.ltl.Since
	 * @generated
	 */
	EClass getSince();

	/**
	 * Returns the meta object for class '{@link org.foam.ltl.Triggered <em>Triggered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triggered</em>'.
	 * @see org.foam.ltl.Triggered
	 * @generated
	 */
	EClass getTriggered();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LtlFactory getLtlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.GloballyImpl <em>Globally</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.GloballyImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getGlobally()
		 * @generated
		 */
		EClass GLOBALLY = eINSTANCE.getGlobally();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.FutureImpl <em>Future</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.FutureImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getFuture()
		 * @generated
		 */
		EClass FUTURE = eINSTANCE.getFuture();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.NextImpl <em>Next</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.NextImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getNext()
		 * @generated
		 */
		EClass NEXT = eINSTANCE.getNext();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.UntilImpl <em>Until</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.UntilImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getUntil()
		 * @generated
		 */
		EClass UNTIL = eINSTANCE.getUntil();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.HistoricallyImpl <em>Historically</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.HistoricallyImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getHistorically()
		 * @generated
		 */
		EClass HISTORICALLY = eINSTANCE.getHistorically();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.OnceImpl <em>Once</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.OnceImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getOnce()
		 * @generated
		 */
		EClass ONCE = eINSTANCE.getOnce();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.ReleasesImpl <em>Releases</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.ReleasesImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getReleases()
		 * @generated
		 */
		EClass RELEASES = eINSTANCE.getReleases();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.SinceImpl <em>Since</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.SinceImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getSince()
		 * @generated
		 */
		EClass SINCE = eINSTANCE.getSince();

		/**
		 * The meta object literal for the '{@link org.foam.ltl.impl.TriggeredImpl <em>Triggered</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ltl.impl.TriggeredImpl
		 * @see org.foam.ltl.impl.LtlPackageImpl#getTriggered()
		 * @generated
		 */
		EClass TRIGGERED = eINSTANCE.getTriggered();

	}

} //LtlPackage
