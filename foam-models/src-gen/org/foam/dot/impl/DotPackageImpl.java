/**
 */
package org.foam.dot.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.foam.annotation.AnnotationPackage;

import org.foam.annotation.impl.AnnotationPackageImpl;

import org.foam.cntex.CntexPackage;

import org.foam.cntex.impl.CntexPackageImpl;

import org.foam.ctl.CtlPackage;

import org.foam.ctl.impl.CtlPackageImpl;

import org.foam.dot.Assignment;
import org.foam.dot.AttributedItem;
import org.foam.dot.DotFactory;
import org.foam.dot.DotPackage;
import org.foam.dot.Edge;
import org.foam.dot.Graph;
import org.foam.dot.Identifiable;
import org.foam.dot.InnerNode;
import org.foam.dot.Node;
import org.foam.dot.RecordNode;
import org.foam.dot.Settings;
import org.foam.dot.SettingsType;
import org.foam.dot.Statement;

import org.foam.flowannotation.FlowannotationPackage;

import org.foam.flowannotation.impl.FlowannotationPackageImpl;

import org.foam.ltl.LtlPackage;

import org.foam.ltl.impl.LtlPackageImpl;

import org.foam.lts.LtsPackage;

import org.foam.lts.impl.LtsPackageImpl;

import org.foam.propositionallogic.PropositionallogicPackage;

import org.foam.propositionallogic.impl.PropositionallogicPackageImpl;

import org.foam.tadl.TadlPackage;

import org.foam.tadl.impl.TadlPackageImpl;

import org.foam.traceability.TraceabilityPackage;

import org.foam.traceability.impl.TraceabilityPackageImpl;

import org.foam.ucm.UcmPackage;

import org.foam.ucm.impl.UcmPackageImpl;

import org.foam.verification.VerificationPackage;

import org.foam.verification.impl.VerificationPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DotPackageImpl extends EPackageImpl implements DotPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToStringMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributedItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass innerNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum settingsTypeEEnum = null;

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
	 * @see org.foam.dot.DotPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DotPackageImpl()
	{
		super(eNS_URI, DotFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DotPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DotPackage init()
	{
		if (isInited) return (DotPackage)EPackage.Registry.INSTANCE.getEPackage(DotPackage.eNS_URI);

		// Obtain or create and register package
		DotPackageImpl theDotPackage = (DotPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DotPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DotPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnnotationPackageImpl theAnnotationPackage = (AnnotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) instanceof AnnotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotationPackage.eNS_URI) : AnnotationPackage.eINSTANCE);
		CntexPackageImpl theCntexPackage = (CntexPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) instanceof CntexPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CntexPackage.eNS_URI) : CntexPackage.eINSTANCE);
		CtlPackageImpl theCtlPackage = (CtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) instanceof CtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CtlPackage.eNS_URI) : CtlPackage.eINSTANCE);
		FlowannotationPackageImpl theFlowannotationPackage = (FlowannotationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) instanceof FlowannotationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FlowannotationPackage.eNS_URI) : FlowannotationPackage.eINSTANCE);
		LtlPackageImpl theLtlPackage = (LtlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) instanceof LtlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtlPackage.eNS_URI) : LtlPackage.eINSTANCE);
		LtsPackageImpl theLtsPackage = (LtsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) instanceof LtsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LtsPackage.eNS_URI) : LtsPackage.eINSTANCE);
		PropositionallogicPackageImpl thePropositionallogicPackage = (PropositionallogicPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) instanceof PropositionallogicPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PropositionallogicPackage.eNS_URI) : PropositionallogicPackage.eINSTANCE);
		TadlPackageImpl theTadlPackage = (TadlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) instanceof TadlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TadlPackage.eNS_URI) : TadlPackage.eINSTANCE);
		TraceabilityPackageImpl theTraceabilityPackage = (TraceabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) instanceof TraceabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TraceabilityPackage.eNS_URI) : TraceabilityPackage.eINSTANCE);
		UcmPackageImpl theUcmPackage = (UcmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) instanceof UcmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UcmPackage.eNS_URI) : UcmPackage.eINSTANCE);
		VerificationPackageImpl theVerificationPackage = (VerificationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) instanceof VerificationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VerificationPackage.eNS_URI) : VerificationPackage.eINSTANCE);

		// Create package meta-data objects
		theDotPackage.createPackageContents();
		theAnnotationPackage.createPackageContents();
		theCntexPackage.createPackageContents();
		theCtlPackage.createPackageContents();
		theFlowannotationPackage.createPackageContents();
		theLtlPackage.createPackageContents();
		theLtsPackage.createPackageContents();
		thePropositionallogicPackage.createPackageContents();
		theTadlPackage.createPackageContents();
		theTraceabilityPackage.createPackageContents();
		theUcmPackage.createPackageContents();
		theVerificationPackage.createPackageContents();

		// Initialize created meta-data
		theDotPackage.initializePackageContents();
		theAnnotationPackage.initializePackageContents();
		theCntexPackage.initializePackageContents();
		theCtlPackage.initializePackageContents();
		theFlowannotationPackage.initializePackageContents();
		theLtlPackage.initializePackageContents();
		theLtsPackage.initializePackageContents();
		thePropositionallogicPackage.initializePackageContents();
		theTadlPackage.initializePackageContents();
		theTraceabilityPackage.initializePackageContents();
		theUcmPackage.initializePackageContents();
		theVerificationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDotPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DotPackage.eNS_URI, theDotPackage);
		return theDotPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraph()
	{
		return graphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraph_Statements()
	{
		return (EReference)graphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode()
	{
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordNode()
	{
		return recordNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordNode_InnerNodes()
	{
		return (EReference)recordNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge()
	{
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Source()
	{
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Target()
	{
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable()
	{
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_Id()
	{
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement()
	{
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettings()
	{
		return settingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_Type()
	{
		return (EAttribute)settingsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToStringMapEntry()
	{
		return stringToStringMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringMapEntry_Key()
	{
		return (EAttribute)stringToStringMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToStringMapEntry_Value()
	{
		return (EAttribute)stringToStringMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributedItem()
	{
		return attributedItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributedItem_Attributes()
	{
		return (EReference)attributedItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInnerNode()
	{
		return innerNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInnerNode_RecordNode()
	{
		return (EReference)innerNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment()
	{
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_Key()
	{
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_Value()
	{
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSettingsType()
	{
		return settingsTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DotFactory getDotFactory()
	{
		return (DotFactory)getEFactoryInstance();
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
		graphEClass = createEClass(GRAPH);
		createEReference(graphEClass, GRAPH__STATEMENTS);

		nodeEClass = createEClass(NODE);

		recordNodeEClass = createEClass(RECORD_NODE);
		createEReference(recordNodeEClass, RECORD_NODE__INNER_NODES);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

		statementEClass = createEClass(STATEMENT);

		settingsEClass = createEClass(SETTINGS);
		createEAttribute(settingsEClass, SETTINGS__TYPE);

		stringToStringMapEntryEClass = createEClass(STRING_TO_STRING_MAP_ENTRY);
		createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__KEY);
		createEAttribute(stringToStringMapEntryEClass, STRING_TO_STRING_MAP_ENTRY__VALUE);

		attributedItemEClass = createEClass(ATTRIBUTED_ITEM);
		createEReference(attributedItemEClass, ATTRIBUTED_ITEM__ATTRIBUTES);

		innerNodeEClass = createEClass(INNER_NODE);
		createEReference(innerNodeEClass, INNER_NODE__RECORD_NODE);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEAttribute(assignmentEClass, ASSIGNMENT__KEY);
		createEAttribute(assignmentEClass, ASSIGNMENT__VALUE);

		// Create enums
		settingsTypeEEnum = createEEnum(SETTINGS_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		graphEClass.getESuperTypes().add(this.getIdentifiable());
		graphEClass.getESuperTypes().add(this.getStatement());
		nodeEClass.getESuperTypes().add(this.getIdentifiable());
		nodeEClass.getESuperTypes().add(this.getStatement());
		nodeEClass.getESuperTypes().add(this.getAttributedItem());
		recordNodeEClass.getESuperTypes().add(this.getNode());
		edgeEClass.getESuperTypes().add(this.getStatement());
		edgeEClass.getESuperTypes().add(this.getAttributedItem());
		settingsEClass.getESuperTypes().add(this.getStatement());
		settingsEClass.getESuperTypes().add(this.getAttributedItem());
		innerNodeEClass.getESuperTypes().add(this.getNode());
		assignmentEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes, features, and operations; add parameters
		initEClass(graphEClass, Graph.class, "Graph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraph_Statements(), this.getStatement(), null, "statements", null, 0, -1, Graph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recordNodeEClass, RecordNode.class, "RecordNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecordNode_InnerNodes(), this.getInnerNode(), this.getInnerNode_RecordNode(), "innerNodes", null, 0, -1, RecordNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Source(), this.getNode(), null, "source", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEdge_Target(), this.getNode(), null, "target", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Id(), ecorePackage.getEString(), "id", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(settingsEClass, Settings.class, "Settings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSettings_Type(), this.getSettingsType(), "type", null, 1, 1, Settings.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToStringMapEntryEClass, Map.Entry.class, "StringToStringMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToStringMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringToStringMapEntry_Value(), ecorePackage.getEString(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributedItemEClass, AttributedItem.class, "AttributedItem", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributedItem_Attributes(), this.getStringToStringMapEntry(), null, "attributes", null, 0, -1, AttributedItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(innerNodeEClass, InnerNode.class, "InnerNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInnerNode_RecordNode(), this.getRecordNode(), this.getRecordNode_InnerNodes(), "recordNode", null, 1, 1, InnerNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssignment_Key(), ecorePackage.getEString(), "key", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_Value(), ecorePackage.getEString(), "value", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(settingsTypeEEnum, SettingsType.class, "SettingsType");
		addEEnumLiteral(settingsTypeEEnum, SettingsType.GRAPH);
		addEEnumLiteral(settingsTypeEEnum, SettingsType.NODE);
		addEEnumLiteral(settingsTypeEEnum, SettingsType.EDGE);

		// Create resource
		createResource(eNS_URI);
	}

} //DotPackageImpl
