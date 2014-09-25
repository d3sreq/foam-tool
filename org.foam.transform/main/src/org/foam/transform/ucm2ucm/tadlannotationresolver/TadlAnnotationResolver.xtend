package org.foam.transform.ucm2ucm.tadlannotationresolver

import org.foam.annotation.Annotation
import org.foam.annotation.UnknownAnnotation
import java.util.Collection
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.ecore.util.EcoreUtil
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.Group
import org.foam.tadl.TadlFactory
import org.foam.tadl.Template
import org.foam.ucm.UseCaseModel

import static extension org.foam.ucm.util.UcmUtils.*

//TODO: refactoring needed
class TadlAnnotationResolver {
	
	val tadlFac = TadlFactory.eINSTANCE
	
	def void resolveAnnotations(UseCaseModel useCaseModel, Iterable<Template> templates) {
		val varDefName2Template = new HashMap<String, Template>
		val varDefName2VarDef = new HashMap<String, VariableDefinition>
		for (template : templates) {
			for (varDef : template.variableDefinitions) {
				varDefName2Template.put(varDef.name, template)
				varDefName2VarDef.put(varDef.name, varDef)
			}
		}
		
		val qualifier2Group = new HashMap<String, Group>
		
		for (useCase : useCaseModel.useCases) {
			val allUseCaseAnnotations = useCase.stepAnnotations 
			val allUnknownAnnotations = allUseCaseAnnotations.filter(UnknownAnnotation)
			
			for (annotation : allUnknownAnnotations) {
				// replace recognized unknown annotations with flow annotations
				val resolvedAnnotation = resolveAnnotation(annotation, varDefName2Template, varDefName2VarDef, qualifier2Group, useCaseModel)
				
				if (annotation != resolvedAnnotation) {
					EcoreUtil.replace(annotation, resolvedAnnotation)
				}
			}
		}
	}
	
	def private Annotation resolveAnnotation(UnknownAnnotation annotation, 
		Map<String,Template> varDefName2Template, 
		Map<String, VariableDefinition> varDefName2VarDef, 
		Map<String,Group> qualifier2Group,
		UseCaseModel useCaseModel
	) {
		// replaces only annotations with exactly two parts
		if (annotation.parts.size != 2) {
			return annotation
		}
		
		// example: #(create:zoom)
		// - create - variable definition from template
		// - zoom - qualifier from temporal annotation group 
		// variable definition name is unique across all templates
		
		val varDefName = annotation.parts.get(0)
		val qualifier = annotation.parts.get(1)
		
		// leave unrecognized annotation as "unknown" 
		if (!varDefName2Template.containsKey(varDefName)) {
			return annotation
		}
		
		if (!qualifier2Group.containsKey(qualifier)) {
			// create group and add reference to template
			val group = tadlFac.createGroup => [
				it.qualifier = qualifier
				it.template = varDefName2Template.get(varDefName)
			]			
			qualifier2Group.put(qualifier, group)
			
			// add group annotation to use case model
			useCaseModel.annotations += tadlFac.createGroupAnnotation => [
				it.group = group
			]
		}
		
		val group = qualifier2Group.get(qualifier)
		
		// find variable definition in template
		val varDef = varDefName2VarDef.get(varDefName)
		
		// create annotation
		return tadlFac.createTemporalAnnotation => [
			variableDefinition = varDef
			it.group = group
		]
	}
	
}