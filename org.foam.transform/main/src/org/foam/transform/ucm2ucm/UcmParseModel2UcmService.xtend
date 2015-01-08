package org.foam.transform.ucm2ucm

import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.util.Tuples
import org.foam.annotation.Annotation
import org.foam.annotation.AnnotationFactory
import org.foam.annotation.UnknownAnnotation
import org.foam.text.StringWithOffset
import org.foam.ucm.Scenario
import org.foam.ucm.Step
import org.foam.ucm.UcmFactory
import org.foam.ucm.UseCase
import org.foam.ucmtext.PrecedenceDef
import org.foam.ucmtext.PrimaryDef
import org.foam.ucmtext.ScenarioDef
import org.foam.ucmtext.ScenarioType
import org.foam.ucmtext.StepDef
import org.foam.ucmtext.UnparsedUseCaseText
import org.foam.ucmtext.UseCaseNameDef
import org.foam.ucmtexttrac.UcmtexttracFactory

import static extension org.foam.bootstrap.IterableExtensions.*

class UcmParseModel2UcmService {
	
	val fac = UcmFactory.eINSTANCE
	val annotFac = AnnotationFactory.eINSTANCE
	val traceFac = UcmtexttracFactory.eINSTANCE
	
	// creates use case model with unresolved step annotations.
	@Pure
	def transform(Iterable<UnparsedUseCaseText> unparsedUseCaseTexts) {
		
		// .toList is needed to materialize the list. Otherwise
		// the subsequent iteration would again apply transformSingleUseCase method
		// to iterable.
		val parseResults = unparsedUseCaseTexts.map[transformSingleUseCase].toList
		
		// construct trace maps
		val trace = traceFac.createUcmToUcmtextTrace => [t |
			parseResults.forEach[t.names.map.put(useCase, nameDef)]
			parseResults.filter[primaryDef != null].forEach[t.primaryDef.map.put(useCase, primaryDef)]
			parseResults.filter[precedenceDef != null].forEach[t.precedenceDef.map.put(useCase, precedenceDef)]
			parseResults.map[steps].flatten.forEach[t.steps.map.put(key, value)]
			parseResults.map[annotations].flatten.forEach[t.annotations.map.put(key, value)]
			parseResults.map[branchingConditions].flatten.forEach[t.branchingConditions.map.put(key, value)]
		]

		// resolve precedence
		val useCases = parseResults.map[useCase].toList
		val useCaseNameMap = useCases.toMap[name]
		trace.precedenceDef.map.forEach[
			key.preceeded += value.preceded.map[useCaseNameMap.get(id.content)] 
		]
		
		val ucm = fac.createUseCaseModel => [
			it.useCases += useCases
		]
		
		ucm -> trace
	}
	
	/**
	 * Transforms textual representation into UseCase object and returns
	 * traceability information from UseCase to textual represenation.
	 * Does not detect errors - validation is supposed to be performed
	 * in subsequent processing.
	 */
	def private UseCaseParseResult transformSingleUseCase(UnparsedUseCaseText unparsedUseCaseText) {
		val useCase = fac.createUseCase
		
		val derived = unparsedUseCaseText.blocks.map[derived]
		
		// use case id and name
		val useCaseNameDef = derived.findFirst[it instanceof UseCaseNameDef] as UseCaseNameDef
		if (useCaseNameDef != null) {
			useCase.id = useCaseNameDef.useCase.id.content
			useCase.name = useCaseNameDef.useCase.description.content
		}
		
		// primary
		val primaryDef = derived.findFirst[it instanceof PrimaryDef] as PrimaryDef
		if (primaryDef != null) {
			useCase.primary = Boolean.parseBoolean(primaryDef.value.content)
		}
		
		// precedence
		val precedenceDef = derived.findFirst[it instanceof PrecedenceDef] as PrecedenceDef
		
		val scenarios = derived.filter(ScenarioDef)
		
		// mapping from label to step used to attach branching scenario to the right step
		val labelToStepMap = <String, Step>newHashMap
		
		val stepMapping = <Pair<Step, StepDef>>newArrayList
		val annotationMapping = <Pair<Annotation, StringWithOffset>>newArrayList
		
		// main scenario
		val mainScenarioDef = scenarios.findFirst[type == ScenarioType.MAIN]
		if (mainScenarioDef != null) {
			val result = mainScenarioDef.steps.transformScenario
			
			useCase.mainScenario = result.first
			stepMapping += result.second
			annotationMapping += result.third
			
			result.second.forEach[labelToStepMap.put(value.label.content, key)]
		}
		
		// extensions and variations
		val triples = scenarios.filter[type == ScenarioType.EXTENSION || type == ScenarioType.VARIATION]
			.map[type -> transformBranchingScenario].toList
		
		val branchingConditionMapping = triples.map[value.first]
		val branchingStepMapping = triples.map[value.second].flatten
		stepMapping += branchingStepMapping
		annotationMapping += triples.map[value.third].flatten
		
		branchingStepMapping.forEach[labelToStepMap.put(value.label.content, key)]
		
		// split branching scenarios according to step labels
		// create scenario holder for each group
		// add branching scenarios to use case
		// triple: condition label, Scenario, branching type
		triples.map[Tuples.create(value.first.value.label.content, value.first.key, key)]
			.groupBy[it.first.branchingStepLabel]
			.forEach[branchingStepLabel, tripleList |
				val branchingStep = labelToStepMap.get(branchingStepLabel)
				
				// add scenario holder
				val holder = fac.createScenarioHolder
				useCase.branches.put(branchingStep, holder)
				
				// add scenarios to scenario holder
				tripleList.sortBy[first].forEach[ t |
					if (t.third == ScenarioType.EXTENSION) {
						holder.extensions
					} else {
						holder.variations
					}.add(t.second)
				]
			]
		
		new UseCaseParseResult(
			useCase,
			useCaseNameDef,
			primaryDef,
			precedenceDef,
			branchingConditionMapping,
			stepMapping,
			annotationMapping
		)
	}
	
	def private branchingStepLabel(String conditionLabel) {
		// strip last letter - e.g. 4a1b -> 4a1
		conditionLabel.substring(0, conditionLabel.length - 1)
	}
	
	@Data
	private static class UseCaseParseResult {
		val UseCase useCase
		val UseCaseNameDef nameDef
		val PrimaryDef primaryDef
		val PrecedenceDef precedenceDef
		val Iterable<Pair<Scenario, StepDef>> branchingConditions
		val Iterable<Pair<Step, StepDef>> steps
		val Iterable<Pair<Annotation, StringWithOffset>> annotations
	}
	
	def private transformBranchingScenario(ScenarioDef scenarioDef) {
		val tuple = scenarioDef.steps.tail.transformScenario
		val condition = scenarioDef.steps.head
		
		if (condition != null) {
			// TODO: transform annotations attached to condition
			tuple.first.text = condition.text.content
		}
		
		Tuples.create(tuple.first -> condition, tuple.second, tuple.third)
	}

	def private transformScenario(Iterable<StepDef> stepDefs) {
		val scenario = fac.createScenario
		
		val mapping = stepDefs.map[stepDef |
			val step = fac.createStep => [
				// TODO: content without annotations (now whole
				// text including annotations is copied).
				text = stepDef.text.content
				annotations += stepDef.annot.map[parseAnnot]
			]
			Tuples.create(step -> stepDef, step.annotations.zip(stepDef.annot))
		].toList
		
		val stepMapping = mapping.map[first]
		scenario.steps += stepMapping.map[key]
		
		val annotMapping = mapping.map[second].flatten
		
		Tuples.create(scenario, stepMapping, annotMapping)
	}
	
	def private UnknownAnnotation parseAnnot(StringWithOffset stringWithOffset) {
		annotFac.createUnknownAnnotation => [
			parts += stringWithOffset.content.split(":")
		]
	}
	
}