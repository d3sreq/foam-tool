package org.foam.transform.ucm2ucm.flowannotationresolver

import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.EcoreUtil2
import org.foam.annotation.UnknownAnnotation
import org.foam.flowannotation.FlowannotationFactory
import org.foam.flowannotation.VariableDefinitionAnnotation
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.PropositionallogicPackage
import org.foam.propositionallogic.VariableDefinition
import org.foam.ucm.Step
import org.foam.ucm.UseCase
import org.foam.ucm.UseCaseModel
import org.foam.xtext.plogic.PropositionalLogicXtextStandaloneSetup
import org.foam.xtext.plogic.parser.antlr.PropositionalLogicXtextParser
import org.foam.xtext.plogic.propositionalLogicXtext.RuleVariableUse

import static extension org.foam.ucm.util.UcmUtils.*

class FlowAnnotationResolver {
	private static val MARK_PREFIX = "mark_"
	
	val flowannotationFactory = FlowannotationFactory.eINSTANCE
	val propLogicFactory = PropositionallogicFactory.eINSTANCE
	
	val PropositionalLogicXtextParser propLogicParser
	
	new() {
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl or LTL formula (propositional logic formula is parsed
		// without errors).
		//
		// Package should be probably registered in GenerateLtlXtext.mwe2 file
		// but wasn't able to figure out how to do it.
		if (!EPackage.Registry.INSTANCE.containsKey(PropositionallogicPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(PropositionallogicPackage.eNS_URI, PropositionallogicPackage.eINSTANCE)
		}
		
		// TODO - use guice annotations to inject parser instead ?
		val setup = new PropositionalLogicXtextStandaloneSetup
		val propLogicInjector = setup.createInjectorAndDoEMFRegistration
		propLogicParser = propLogicInjector.getInstance(PropositionalLogicXtextParser)
	}
	
	def resolveAnnotations(UseCaseModel useCaseModel) {
		val id2Uc = new HashMap<String, UseCase>
		val allUseCases = useCaseModel.useCases
		allUseCases.forEach[id2Uc.put(it.id, it)]
		
		for (useCase : allUseCases) {
			val id2Step = useCase.id2Step
			
			val allUseCaseAnnotations = useCase.stepAnnotations 
			val allUnknownAnnotations = allUseCaseAnnotations.filter(UnknownAnnotation)
			
			for (annotation : allUnknownAnnotations) {
				// replace recognized unknown annotations with flow annotations
				val resolvedAnnotation = resolveAnnotation(annotation, id2Uc, id2Step, useCaseModel)
				
				if (annotation != resolvedAnnotation) {
					EcoreUtil2.replace(annotation, resolvedAnnotation)
				}
			}
		}
	}
	
	def private resolveAnnotation(UnknownAnnotation annotation, HashMap<String,UseCase> id2Uc, Map<String,Step> id2Step, UseCaseModel useCaseModel) {
		val varName2VarDef = getVarName2VarDef(useCaseModel)		
		return switch (annotation.parts.head) {
			case "abort": {
				flowannotationFactory.createAbort
			}
			case "include": {
 				flowannotationFactory.createInclude => [
 					val ucId = annotation.parts.get(1)
 					inlinedUseCase = id2Uc.get(ucId)
 				]
			}
			case "goto": {
				flowannotationFactory.createGoto => [
					val targetId = annotation.parts.get(1)
					target = id2Step.get(targetId)
				]
			}
			case "guard": {
				val guard = flowannotationFactory.createGuard => [
					val formulaText = annotation.parts.get(1)
					formula = getFormula(formulaText)
				]
				resolveVariables(guard, varName2VarDef, useCaseModel)
				guard
			}
			case "mark": {
				flowannotationFactory.createMark => [
					val varName = annotation.parts.get(1)
					// TODO - add only once ?
					variableDefinition = findOrAddVariableDefinition('''«MARK_PREFIX»«varName»''', varName2VarDef, useCaseModel)
				]
			}
			default: annotation
		}
	}
	
	def private Formula getFormula(String text) {
		val parseResult = propLogicParser.doParse(text)
		// TODO - error handling
		return parseResult.rootASTElement as Formula
	}
	
	// TODO - factor out this method and same method from TADL resolver ?
	def private void resolveVariables(EObject container, Map<String,VariableDefinition> varName2VarDef, UseCaseModel useCaseModel) {
		val ruleVars = EcoreUtil2.getAllContentsOfType(container, RuleVariableUse)
		
		for (ruleVar : ruleVars) {
			// replace RuleVariableUse with VariableUse
			val varName = '''«MARK_PREFIX»«ruleVar.variable»'''
			
			if (!varName2VarDef.containsKey(varName)) {
				val varDef = propLogicFactory.createVariableDefinition => [
					name = varName
				]
				varName2VarDef.put(varName, varDef)
				useCaseModel.annotations += flowannotationFactory.createVariableDefinitionAnnotation => [
					variableDefinition = varDef
				]
			}
			
			val varUse = propLogicFactory.createVariableUse => [
				variableDefinition = varName2VarDef.get(varName)
			]
			
			EcoreUtil2.replace(ruleVar, varUse)
		}
	}
	
	def private Map<String, VariableDefinition> getVarName2VarDef(UseCaseModel useCaseModel) {
		val varName2VarDef = new HashMap<String, VariableDefinition>
		val varDefs = useCaseModel.annotations.filter(VariableDefinitionAnnotation).map[variableDefinition]
		varDefs.forEach[varName2VarDef.put(it.name, it)]
		varName2VarDef
	}
	
	def private VariableDefinition findOrAddVariableDefinition(String variableName, Map<String, VariableDefinition> varName2VarDef, UseCaseModel useCaseModel) {
		if (!varName2VarDef.containsKey(variableName)) {
			val varDef = propLogicFactory.createVariableDefinition => [
				name = variableName
			]
			useCaseModel.annotations += flowannotationFactory.createVariableDefinitionAnnotation => [
				variableDefinition = varDef
			]
			varName2VarDef.put(variableName, varDef)
		}
		varName2VarDef.get(variableName)
	}

	
	def private Map<String, Step> getId2Step(UseCase useCase) {
		val result = new HashMap<String, Step>
		
		useCase.mainScenario.steps.forEach[result.put(it.label, it)] 
		for (holder : useCase.branches.values) {
			val scenarios = holder.extensions + holder.variations
			val steps = scenarios.map[it.steps].flatten
			steps.forEach[result.put(it.label, it)]
		}
		
		result
	}	
		
}