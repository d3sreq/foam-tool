package org.foam.transform.ucm2ucm

import java.util.Collections
import java.util.List
import java.util.Map
import org.foam.annotation.AnnotationFactory
import org.foam.annotation.UnknownAnnotation
import org.foam.text.StringWithOffset
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.foam.ucmtext.Block
import org.foam.ucmtext.PrimaryDef
import org.foam.ucmtext.ScenarioDef
import org.foam.ucmtext.ScenarioType
import org.foam.ucmtext.StepDef
import org.foam.ucmtext.UnparsedUseCaseText
import org.foam.ucmtexttrac.UcmtexttracFactory
import org.foam.ucmtext.PrecedenceDef
import org.foam.ucmtext.SemanticBlock
import org.foam.ucmtext.UseCaseNameDef

class UcmParseModel2UcmService {
	
	val fac = UcmFactory.eINSTANCE
	val annotFac = AnnotationFactory.eINSTANCE
	val traceFac = UcmtexttracFactory.eINSTANCE
	
	@Pure
	def transform(Iterable<UnparsedUseCaseText> unparsedUseCaseTexts) {
		val useCaseMapping = unparsedUseCaseTexts.map[fac.createUseCase -> it]
			.toList
		
		val scenarioMapping = unparsedUseCaseTexts.map[findScenarios]
			.flatten
			.map[fac.createScenario -> it]
			.toList
		
		val stepMapping = scenarioMapping.map[value]
			.map[steps]
			.flatten
			.map[createAndFillStep -> it]
			.toList
		
		val annotationMapping = stepMapping.map[value]
			.map[annot]
			.flatten
			.map[createAndFillAnnotation -> it]
			.toList
		
		val unparsedUseCaseTextToUseCase = <UnparsedUseCaseText, UseCase>newHashMap
		useCaseMapping.forEach[unparsedUseCaseTextToUseCase.put(value, key)]
		
		addMainScenarioToUseCases(scenarioMapping, unparsedUseCaseTextToUseCase)
		addBranchingScenariosToUseCases(scenarioMapping, stepMapping, unparsedUseCaseTextToUseCase)
		addStepsToScenarios(scenarioMapping, stepMapping)
		addAnnotationsToSteps(stepMapping, annotationMapping)
		addPrimary(useCaseMapping)
		addPrecedence(useCaseMapping)
		addNameAndId(useCaseMapping)
		
		val ucm = fac.createUseCaseModel => [
			useCases += useCaseMapping.map[key]
		]
		
		val branchingConditionMapping = scenarioMapping.filter[value.isBranchingScenario]
			.map[key -> value.steps.head]
		
		val trace = traceFac.createUcmToUcmtextTrace => [ t |
			annotationMapping.forEach[t.annotations.map.put(key, value)]
			branchingConditionMapping.forEach[t.branchingConditions.map.put(key, value)]
			t.names.map.putAll(useCaseMapping.getMapping(UseCaseNameDef))
			t.precedenceDef.map.putAll(useCaseMapping.getMapping(PrecedenceDef))
			t.primaryDef.map.putAll(useCaseMapping.getMapping(PrimaryDef))
			stepMapping.forEach[t.steps.map.put(key, value)]
		]
		
		ucm -> trace
	}
	
	def private <T extends SemanticBlock> Map<UseCase, T> getMapping(List<Pair<UseCase, UnparsedUseCaseText>> useCaseMapping, Class<T> type) {
		val map = <UseCase, T>newHashMap
		useCaseMapping.map[key -> value.findSemanticBlock(type)]
			.filter[value != null]
			.forEach[map.put(key, value)]
		map
	} 
	
	def private <T extends SemanticBlock> findSemanticBlock(UnparsedUseCaseText unparsedUseCaseText, Class<T> type) {
		unparsedUseCaseText.blocks
			.map[derived]
			.filter(type)
			.head
	}
	
	def private addMainScenarioToUseCases(List<Pair<Scenario, ScenarioDef>> scenarioMapping, Map<UnparsedUseCaseText, UseCase> unparsedUseCaseTextToUseCase) {
		scenarioMapping.filter[value.type == ScenarioType.MAIN].forEach[
			val scenario = key
			val scenarioDef = value
			val unparsedUseCaseText = scenarioDef.unparsedUseCaseText
			val useCase = unparsedUseCaseTextToUseCase.get(unparsedUseCaseText)
			useCase.mainScenario = scenario
		]
	} 
	
	def private addBranchingScenariosToUseCases(List<Pair<Scenario, ScenarioDef>> scenarioMapping, List<Pair<Step, StepDef>> stepMapping, Map<UnparsedUseCaseText, UseCase> unparsedUseCaseTextToUseCase) {
		val stepMap = <UseCase, Map<String, Step>>newHashMap
		stepMapping.groupBy[value.unparsedUseCaseText]
			.forEach[unparsedUseCaseText, pairs|
				val useCase = unparsedUseCaseTextToUseCase.get(unparsedUseCaseText)
				val labelToStep = <String, Step>newHashMap
				pairs.forEach[labelToStep.put(value.label.content, key)]
				stepMap.put(useCase, labelToStep) 
			]
		
		scenarioMapping.filter[value.isBranchingScenario]			
			.groupBy[value.unparsedUseCaseText] // group by use case
			.entrySet
			.forEach[
				val useCase = unparsedUseCaseTextToUseCase.get(key)
				val labelToStep = stepMap.get(useCase)
				
				value.groupBy[value.branchingStepLabel] // group by branching step
					.entrySet
					.forEach[
						val branchingStep = labelToStep.get(key)
						// scenario holder - each step with branching has exactly one
						val holder = fac.createScenarioHolder
						
						// sort values - e.g. 4a must precede 4b 
						value.sortBy[value.branchingConditionLabel]  
							.forEach[
								val scenario = key
								val scenarioDef = value
								if (scenarioDef.type == ScenarioType.EXTENSION) {
									holder.extensions
								} else {
									holder.variations
								}.add(scenario)
							]
						
						useCase.branches.put(branchingStep, holder)
					]
			]
	}
	
	def private addStepsToScenarios(List<Pair<Scenario, ScenarioDef>> scenarioMapping, List<Pair<Step, StepDef>> stepMapping) {
		val scenarioDefToScenario = <ScenarioDef, Scenario>newHashMap
		scenarioMapping.forEach[scenarioDefToScenario.put(value, key)]
		stepMapping.forEach[
			val step = key
			val stepDef = value
			val scenarioDef = stepDef.eContainer as ScenarioDef
			val scenario = scenarioDefToScenario.get(scenarioDef)
			scenario.steps += step
		]
	}
	
	def private addAnnotationsToSteps(List<Pair<Step, StepDef>> stepMapping, List<Pair<UnknownAnnotation, StringWithOffset>> annotationMapping) {
		val stepDefToStep = <StepDef, Step>newHashMap
		stepMapping.forEach[stepDefToStep.put(value, key)]
		annotationMapping.forEach[
			val annotation = key
			val stringWithOffset = value
			val stepDef = stringWithOffset.eContainer as StepDef
			val step = stepDefToStep.get(stepDef)
			step.annotations += annotation
		]
	}
	
	def private addPrimary(List<Pair<UseCase, UnparsedUseCaseText>> useCaseMapping) {
		useCaseMapping.forEach[
			val useCase = key
			val unparsedUseCaseText = value
			val primaryDef = unparsedUseCaseText.findSemanticBlock(PrimaryDef)
			if (primaryDef != null) {
				val isPrimary = Boolean.parseBoolean(primaryDef.value.content)
				useCase.primary = isPrimary
			}
		]
	}
	
	def private addNameAndId(List<Pair<UseCase, UnparsedUseCaseText>> useCaseMapping) {
		useCaseMapping.forEach[
			val useCase = key
			val unparsedUseCaseText = value
			val nameDef = unparsedUseCaseText.findSemanticBlock(UseCaseNameDef)
			if (nameDef != null) {
				useCase.id = nameDef.useCase.id.content
				useCase.name = nameDef.useCase.description.content
			}
		]
	}
	
	def private addPrecedence(List<Pair<UseCase, UnparsedUseCaseText>> useCaseMapping) {
		val useCaseIdToUseCase = useCaseMapping.map[key].toMap[id]
		useCaseMapping.forEach[
			val useCase = key
			val unparsedUseCaseText = value
			
			val precedenceDef = unparsedUseCaseText.findSemanticBlock(PrecedenceDef)
			if (precedenceDef != null) {
				 val preceeded = precedenceDef.preceded
					.map[useCaseIdToUseCase.get(id)]
				useCase.preceeded += preceeded
			}
		]
	}
	
	def private getUnparsedUseCaseText(StepDef stepDef) {
		(stepDef.eContainer as ScenarioDef).unparsedUseCaseText
	}
	
	def private getUnparsedUseCaseText(ScenarioDef scenarioDef) {
		(scenarioDef.eContainer as Block).eContainer as UnparsedUseCaseText
	}
	
	def private findScenarios(UnparsedUseCaseText unparsedUseCaseText) {
		val scenarios = unparsedUseCaseText.blocks
			.map[derived]
			.filter(ScenarioDef)
		
		// find only first main scenario
		val mainScenario = scenarios.findFirst[type == ScenarioType.MAIN]
		val branchingScenarios = scenarios.filter[isBranchingScenario]	
		
		if (mainScenario == null) {
			return branchingScenarios
		} 
		return Collections.singleton(mainScenario) + branchingScenarios
	}
	
	def private createAndFillStep(StepDef stepDef) {
		fac.createStep => [
			text = stepDef.text.content
		]
	}
	
	def private isBranchingScenario(ScenarioDef scenarioDef) {
		scenarioDef.type == ScenarioType.EXTENSION || scenarioDef.type == ScenarioType.VARIATION
	}
	
	def private branchingConditionLabel(ScenarioDef scenarioDef) {
		scenarioDef.steps.head.label.content
	}
	
	def private branchingStepLabel(ScenarioDef scenarioDef) {
		scenarioDef.branchingConditionLabel.branchingStepLabel
	}
	
	def private branchingStepLabel(String conditionLabel) {
		// strip last letter - e.g. 4a1b -> 4a1
		conditionLabel.substring(0, conditionLabel.length - 1)
	}
	
	def private UnknownAnnotation createAndFillAnnotation(StringWithOffset stringWithOffset) {
		annotFac.createUnknownAnnotation => [
			parts += stringWithOffset.content.split(":")
		]
	}
	
}