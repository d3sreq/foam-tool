package org.foam.transform.tadl

import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.annotation.AnnotationFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.FormulaType
import org.foam.tadl.TadlFactory
import org.foam.transform.ucm2ucm.tadlannotationresolver.TadlAnnotationResolver
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCaseModel
import org.junit.Assert
import org.junit.Test

class TadlAnnotationResolverTest {

	extension UcmFactory = UcmFactory.eINSTANCE
	extension TadlFactory = TadlFactory.eINSTANCE
	extension PropositionallogicFactory = PropositionallogicFactory.eINSTANCE
	extension AnnotationFactory = AnnotationFactory.eINSTANCE
	
	val tadlAnnotationResolver = new TadlAnnotationResolver
	
	val VariableDefinition createDef = createVariableDefinition => [name = "create"]
	val VariableDefinition useDef = createVariableDefinition => [name = "use"]
	
	val templateCreateUse = createTemplate => [

		variableDefinitions += #[createDef, useDef]
		
		// dummy formulas
		formulaHolders += #[
			createFormulaHolder => [
				formulaType = FormulaType.CTL
				formula = createTrue
			],
			createFormulaHolder => [
				formulaType = FormulaType.CTL
				formula = createFalse
			]
		]
	]
	
	/**
	 * Creates use case model skeleton. Used to get rid
	 * of boilerplate code.
	 */
	def private UseCaseModel createSimpleUcm() {
		return createUseCaseModel => [
			useCases += createUseCase => [
				id = "UC1"
				name = "Tadl resolve test"
				
				mainScenario = createScenario => [
					steps += createStep => [
						text = "Use case step 1."
					]
				]
			]
		]
	}	
	
	@Test def void resolveCreate() {
		val inputUcm = createSimpleUcm => [
			val uc1 = useCases.head
			val step1 = uc1.mainScenario.steps.head
			
			step1.annotations += createUnknownAnnotation => [
				parts += #["create", "zoom"]
			]
		] 
		
		val expectedUcm = createSimpleUcm => [
			val uc1 = useCases.head
			val step1 = uc1.mainScenario.steps.head
			val group = createGroup => [
				qualifier = "zoom"
				template = templateCreateUse
			]
			
			annotations += createGroupAnnotation => [
				it.group = group
			]
			
			step1.annotations += createTemporalAnnotation => [
				variableDefinition = createDef
				it.group = group
			]
		]
		
		tadlAnnotationResolver.resolveAnnotations(inputUcm, #[templateCreateUse])
		Assert.assertTrue("Expected and actual use case doesn't match",
			EcoreUtil.equals(expectedUcm, inputUcm)
		)
	}
	
	@Test def void retainUnknown() {
		val inputUcm = createSimpleUcm => [
			val uc1 = useCases.head
			val step1 = uc1.mainScenario.steps.head
			
			step1.annotations += createUnknownAnnotation => [
				// not resolved because has 3 parts (must have 2)
				parts += #["create", "zoom", "third"]
			]
			step1.annotations += createUnknownAnnotation => [
				// not found in template
				parts += "unknown_annotation"
			]
		]
		
		val unresolved = EcoreUtil.copy(inputUcm)
		
		tadlAnnotationResolver.resolveAnnotations(inputUcm, #[templateCreateUse])
		Assert.assertTrue("Expected and actual use case doesn't match",
			EcoreUtil.equals(inputUcm, unresolved)
		)
	} 
}