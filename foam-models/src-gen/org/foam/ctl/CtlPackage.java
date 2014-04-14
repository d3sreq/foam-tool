/**
 */
package org.foam.ctl;

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
 * @see org.foam.ctl.CtlFactory
 * @model kind="package"
 * @generated
 */
public interface CtlPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ctl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "ctl";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ctl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CtlPackage eINSTANCE = org.foam.ctl.impl.CtlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.AllUntilImpl <em>All Until</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.AllUntilImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getAllUntil()
	 * @generated
	 */
	int ALL_UNTIL = 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_UNTIL__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_UNTIL__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>All Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_UNTIL_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>All Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_UNTIL_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.ExistsUntilImpl <em>Exists Until</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.ExistsUntilImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsUntil()
	 * @generated
	 */
	int EXISTS_UNTIL = 1;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_UNTIL__LEFT = PropositionallogicPackage.BINARY_FORMULA__LEFT;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_UNTIL__RIGHT = PropositionallogicPackage.BINARY_FORMULA__RIGHT;

	/**
	 * The number of structural features of the '<em>Exists Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_UNTIL_FEATURE_COUNT = PropositionallogicPackage.BINARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exists Until</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_UNTIL_OPERATION_COUNT = PropositionallogicPackage.BINARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.AllGloballyImpl <em>All Globally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.AllGloballyImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getAllGlobally()
	 * @generated
	 */
	int ALL_GLOBALLY = 2;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_GLOBALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>All Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_GLOBALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>All Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_GLOBALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.AllFinallyImpl <em>All Finally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.AllFinallyImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getAllFinally()
	 * @generated
	 */
	int ALL_FINALLY = 3;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FINALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>All Finally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FINALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>All Finally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FINALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.AllNextImpl <em>All Next</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.AllNextImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getAllNext()
	 * @generated
	 */
	int ALL_NEXT = 4;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_NEXT__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>All Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_NEXT_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>All Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_NEXT_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.ExistsGloballyImpl <em>Exists Globally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.ExistsGloballyImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsGlobally()
	 * @generated
	 */
	int EXISTS_GLOBALLY = 5;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_GLOBALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Exists Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_GLOBALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exists Globally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_GLOBALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.ExistsFinallyImpl <em>Exists Finally</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.ExistsFinallyImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsFinally()
	 * @generated
	 */
	int EXISTS_FINALLY = 6;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_FINALLY__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Exists Finally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_FINALLY_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exists Finally</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_FINALLY_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.foam.ctl.impl.ExistsNextImpl <em>Exists Next</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.foam.ctl.impl.ExistsNextImpl
	 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsNext()
	 * @generated
	 */
	int EXISTS_NEXT = 7;

	/**
	 * The feature id for the '<em><b>Formula</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_NEXT__FORMULA = PropositionallogicPackage.UNARY_FORMULA__FORMULA;

	/**
	 * The number of structural features of the '<em>Exists Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_NEXT_FEATURE_COUNT = PropositionallogicPackage.UNARY_FORMULA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Exists Next</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXISTS_NEXT_OPERATION_COUNT = PropositionallogicPackage.UNARY_FORMULA_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.foam.ctl.AllUntil <em>All Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Until</em>'.
	 * @see org.foam.ctl.AllUntil
	 * @generated
	 */
	EClass getAllUntil();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.ExistsUntil <em>Exists Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Until</em>'.
	 * @see org.foam.ctl.ExistsUntil
	 * @generated
	 */
	EClass getExistsUntil();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.AllGlobally <em>All Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Globally</em>'.
	 * @see org.foam.ctl.AllGlobally
	 * @generated
	 */
	EClass getAllGlobally();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.AllFinally <em>All Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Finally</em>'.
	 * @see org.foam.ctl.AllFinally
	 * @generated
	 */
	EClass getAllFinally();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.AllNext <em>All Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All Next</em>'.
	 * @see org.foam.ctl.AllNext
	 * @generated
	 */
	EClass getAllNext();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.ExistsGlobally <em>Exists Globally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Globally</em>'.
	 * @see org.foam.ctl.ExistsGlobally
	 * @generated
	 */
	EClass getExistsGlobally();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.ExistsFinally <em>Exists Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Finally</em>'.
	 * @see org.foam.ctl.ExistsFinally
	 * @generated
	 */
	EClass getExistsFinally();

	/**
	 * Returns the meta object for class '{@link org.foam.ctl.ExistsNext <em>Exists Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exists Next</em>'.
	 * @see org.foam.ctl.ExistsNext
	 * @generated
	 */
	EClass getExistsNext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CtlFactory getCtlFactory();

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
		 * The meta object literal for the '{@link org.foam.ctl.impl.AllUntilImpl <em>All Until</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.AllUntilImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getAllUntil()
		 * @generated
		 */
		EClass ALL_UNTIL = eINSTANCE.getAllUntil();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.ExistsUntilImpl <em>Exists Until</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.ExistsUntilImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsUntil()
		 * @generated
		 */
		EClass EXISTS_UNTIL = eINSTANCE.getExistsUntil();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.AllGloballyImpl <em>All Globally</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.AllGloballyImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getAllGlobally()
		 * @generated
		 */
		EClass ALL_GLOBALLY = eINSTANCE.getAllGlobally();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.AllFinallyImpl <em>All Finally</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.AllFinallyImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getAllFinally()
		 * @generated
		 */
		EClass ALL_FINALLY = eINSTANCE.getAllFinally();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.AllNextImpl <em>All Next</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.AllNextImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getAllNext()
		 * @generated
		 */
		EClass ALL_NEXT = eINSTANCE.getAllNext();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.ExistsGloballyImpl <em>Exists Globally</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.ExistsGloballyImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsGlobally()
		 * @generated
		 */
		EClass EXISTS_GLOBALLY = eINSTANCE.getExistsGlobally();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.ExistsFinallyImpl <em>Exists Finally</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.ExistsFinallyImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsFinally()
		 * @generated
		 */
		EClass EXISTS_FINALLY = eINSTANCE.getExistsFinally();

		/**
		 * The meta object literal for the '{@link org.foam.ctl.impl.ExistsNextImpl <em>Exists Next</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.foam.ctl.impl.ExistsNextImpl
		 * @see org.foam.ctl.impl.CtlPackageImpl#getExistsNext()
		 * @generated
		 */
		EClass EXISTS_NEXT = eINSTANCE.getExistsNext();

	}

} //CtlPackage
