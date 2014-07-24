package org.foam.transform.tadl

import java.util.Collections
import org.foam.annotation.AnnotationFactory
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.FormulaType
import org.foam.tadl.TadlFactory
import org.foam.transform.ucm2ucm.tadlannotationresolver.TadlAnnotationResolver
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCaseModel
import org.junit.Test

class TadlAnnotationResolverTest {
	
	val tadlAnnotationResolver = new TadlAnnotationResolver
	val ucmFac = UcmFactory.eINSTANCE
	val tadlFac = TadlFactory.eINSTANCE
	val logicFac = PropositionallogicFactory.eINSTANCE
	val annotationFac = AnnotationFactory.eINSTANCE
	val checker = new TadlAnnotationChecker
	
	var VariableDefinition createDef
	var VariableDefinition useDef
	
	val templateCreateUse = tadlFac.createTemplate => [
		createDef = logicFac.createVariableDefinition => [
			name = "create"
		]
		useDef = logicFac.createVariableDefinition => [
			name = "use"
		] 
		variableDefinitions += newArrayList(createDef, useDef)
		
		// dummy formulas
		formulaHolders += #[
			tadlFac.createFormulaHolder => [
				formulaType = FormulaType.CTL
				formula = logicFac.createTrue
			],
			tadlFac.createFormulaHolder => [
				formulaType = FormulaType.CTL
				formula = logicFac.createFalse
			]
		]
	]
	
	/**
	 * Creates use case model skeleton. Used to get rid
	 * of boilerplate code.
	 */
	def private UseCaseModel createSimpleUcm() {
		return ucmFac.createUseCaseModel => [
			useCases += ucmFac.createUseCase => [
				id = "UC1"
				name = "Tadl resolve test"
				
				mainScenario = ucmFac.createScenario => [
					steps += ucmFac.createStep => [
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
			
			step1.annotations += annotationFac.createUnknownAnnotation => [
				parts += newArrayList("create", "zoom")
			]
		] 
		
		val expectedUcm = createSimpleUcm => [
			val uc1 = useCases.head
			val step1 = uc1.mainScenario.steps.head
			val group = tadlFac.createGroup => [
				qualifier = "zoom"
				template = templateCreateUse
			]
			
			annotations += tadlFac.createGroupAnnotation => [
				it.group = group
			]
			
			step1.annotations += tadlFac.createTemporalAnnotation => [
				variableDefinition = createDef
				it.group = group
			]
		]
		
		tadlAnnotationResolver.resolveAnnotations(inputUcm, Collections.singletonList(templateCreateUse))
		checker.assertUseCaseModelEquals(expectedUcm, inputUcm)
	}
	
	@Test def void retainUnknown() {
		val inputUcm = createSimpleUcm => [
			val uc1 = useCases.head
			val step1 = uc1.mainScenario.steps.head
			
			step1.annotations += annotationFac.createUnknownAnnotation => [
				// not resolved becouse has 3 parts (must have 2)
				parts += newArrayList("create", "zoom", "third")
			]
			step1.annotations += annotationFac.createUnknownAnnotation => [
				// not found in template
				parts += newArrayList("unknown_annotation")
			]
		]
		
		tadlAnnotationResolver.resolveAnnotations(inputUcm, Collections.singletonList(templateCreateUse))
		checker.assertUseCaseModelEquals(inputUcm, inputUcm)
	} 
}