/**
 */
package transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.foam.propositionallogic.PropositionallogicPackage;

import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextFactory;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PropositionalLogicXtextPackageImpl extends EPackageImpl implements PropositionalLogicXtextPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleVariableUseEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see propositionallogiclang2propositionallogic.propositionalLogicXtext.PropositionalLogicXtextPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PropositionalLogicXtextPackageImpl()
  {
    super(eNS_URI, PropositionalLogicXtextFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link PropositionalLogicXtextPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PropositionalLogicXtextPackage init()
  {
    if (isInited) return (PropositionalLogicXtextPackage)EPackage.Registry.INSTANCE.getEPackage(PropositionalLogicXtextPackage.eNS_URI);

    // Obtain or create and register package
    PropositionalLogicXtextPackageImpl thePropositionalLogicXtextPackage = (PropositionalLogicXtextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PropositionalLogicXtextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PropositionalLogicXtextPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    PropositionallogicPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    thePropositionalLogicXtextPackage.createPackageContents();

    // Initialize created meta-data
    thePropositionalLogicXtextPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePropositionalLogicXtextPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PropositionalLogicXtextPackage.eNS_URI, thePropositionalLogicXtextPackage);
    return thePropositionalLogicXtextPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleVariableUse()
  {
    return ruleVariableUseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleVariableUse_Variable()
  {
    return (EAttribute)ruleVariableUseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PropositionalLogicXtextFactory getPropositionalLogicXtextFactory()
  {
    return (PropositionalLogicXtextFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    ruleVariableUseEClass = createEClass(RULE_VARIABLE_USE);
    createEAttribute(ruleVariableUseEClass, RULE_VARIABLE_USE__VARIABLE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    PropositionallogicPackage thePropositionallogicPackage = (PropositionallogicPackage)EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    ruleVariableUseEClass.getESuperTypes().add(thePropositionallogicPackage.getFormula());

    // Initialize classes and features; add operations and parameters
    initEClass(ruleVariableUseEClass, RuleVariableUse.class, "RuleVariableUse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleVariableUse_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, RuleVariableUse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //PropositionalLogicXtextPackageImpl
