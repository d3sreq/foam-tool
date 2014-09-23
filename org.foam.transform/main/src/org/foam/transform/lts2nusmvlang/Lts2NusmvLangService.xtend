package org.foam.transform.lts2nusmvlang

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.util.HashMap
import java.util.List
import java.util.Set
import org.foam.annotation.Annotation
import org.foam.flowannotation.Guard
import org.foam.flowannotation.Mark
import org.foam.lts.Automaton
import org.foam.lts.LtsFactory
import org.foam.lts.State
import org.foam.lts.Transition
import org.foam.propositionallogic.False
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.FormulaHolder
import org.foam.tadl.Group
import org.foam.tadl.TemporalAnnotation
import org.foam.traceability.StateType
import org.foam.traceability.StateTypeMappingAnnotation
import org.foam.traceability.StepMappingAnnotation
import org.foam.transform.utils.logger.LogServiceExtension
import org.foam.transform.utils.modeling.FoamNamingExtension
import org.foam.ucm.Step
import org.foam.verification.Action
import org.osgi.service.log.LogService

import static extension org.apache.commons.lang.WordUtils.*
import static extension org.foam.transform.utils.modeling.IterableExtensions.*

@Component(provide = Lts2NusmvLangService)
class Lts2NusmvLangService {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}
	
	def transform(Automaton automaton) {
		return transform(automaton, newArrayList)
	}
	
	def transform(Automaton automaton, List<Pair<FormulaHolder, Group>> holderGroupList) {
		return new Lts2NusmvContext().transform(automaton, holderGroupList)
	}
}

package class Lts2NusmvContext {
	
	private extension FoamNamingExtension = new FoamNamingExtension

	private static val NUSMV_CODE_WRAP_LENGTH = 120
	private static val NUSMV_CODE_ABBREVIATE_LENGTH = 60
	
	
	def private stateId(State s) {
		// TODO - check that state.id is valid nusmv identifier ?
		s.id
	}
	
	private val mapStateToTransitions = <State, List<Transition>> newHashMap
	def private stateTransitions(State s) {
		mapStateToTransitions.get(s)
	}

	private val trans2guards = <Transition, Guard> newHashMap
	def private dispatch void prepareTransitionAnnotationMapping(Automaton automaton, Transition transition, Guard guardAnnot) {

		// OPTIMIZATION: remove transitions guarded by "FALSE"
		if(guardAnnot.formula instanceof False) {
			automaton.transitions.remove(transition)
			return
		}
		
		// NuSMV HACK: split transitions containing guards
		// ==============================================================================
		// NuSMV does not support non-deterministic guards
		// We have to simulate them by adding an unguarded non-deterministic decision
		// and then by checking a negated guard which may jumps back.
		// Therefore, we need to split the transition X->Y into X->G (new), G->Y (original)
		
		val stateX = transition.start
		val stateY = transition.end
		val stateG = LtsFactory.eINSTANCE.createState => [
			id =  '''«stateX.id»$-guard-$«stateY.id»'''
		]
		
		// creating new transition
		val newTransition = LtsFactory.eINSTANCE.createTransition => [
			start = stateX
			end = stateG
		]
		transition.start = stateG // rerouting the original
				
		// adding stuff to the automaton
		automaton.states += stateG
		automaton.transitions += newTransition

		// now moving the guard annotation to the new transition
		transition.annotations.remove(guardAnnot)
		newTransition.annotations += guardAnnot
		trans2guards.put(newTransition, guardAnnot)
	}
	
	private val markvar2trans = <VariableDefinition, List<Transition>>newHashMap
	def private dispatch void prepareTransitionAnnotationMapping(Automaton automaton, Transition transition, Mark markAnnot) {
		if(!markvar2trans.containsKey(markAnnot.variableDefinition)) {
			markvar2trans.put(markAnnot.variableDefinition, newArrayList)
		}
		
		markvar2trans.get(markAnnot.variableDefinition) += transition
	}
	
	private val actvar2acttrans = <VariableDefinition, List<Pair<Action,Transition>>> newHashMap
	def private dispatch void prepareTransitionAnnotationMapping(Automaton automaton, Transition transition, Action actionAnnot) {

		// NuSMV HACK: split transitions containing actions
		// ==============================================================================
		// NuSMV does not support variables on transitions. We will emulate them
		// using states. Every transition annotated with an action will be split
		// in half by adding a special state, where the variable change takes place.
		// Therefore, we need to split the transition X->Y into X->A (original), A->Y (new)
				
		val stateX = transition.start
		val stateY = transition.end
		val stateA = LtsFactory.eINSTANCE.createState => [
			id = '''«stateX.id»$-act-$«stateY.id»'''
		]
		
		val newTransition = LtsFactory.eINSTANCE.createTransition => [
			start = stateA
			end = stateY
		]
		transition.end = stateA
		
		automaton.states += stateA
		automaton.transitions += newTransition
		
		// lazy initialization
		if(!actvar2acttrans.containsKey(actionAnnot.variableDefinition)) {
			actvar2acttrans.put(actionAnnot.variableDefinition, newArrayList)
		}
			
		actvar2acttrans.get(actionAnnot.variableDefinition).add(actionAnnot -> transition)
	}
	
	def private isGuarded(Transition transition) {
		trans2guards.containsKey(transition)
	}
	
	def private getGuardingFormula(Transition transition) {
		val nuSmvFormulaRenderer = new NusmvFormulaRenderer
		nuSmvFormulaRenderer.evalFormula(trans2guards.get(transition).formula).toString
	}
	
	private val guardLoopFairnessStates = <State> newHashSet
	def private void addToFairness(State s) {
		guardLoopFairnessStates.add(s)
	}
	
	private val state2ucstep = <State, Step> newHashMap
	def private dispatch prepareStateToAnnotationMapping(State state, StepMappingAnnotation annot) {
		state2ucstep.put(state, annot.step)
	}
	
	private val state2type = <State, String> newHashMap
	def private dispatch prepareStateToAnnotationMapping(State state, StateTypeMappingAnnotation annot) {
		state2type.put(state, annot.stateType.literal)
	}
	
	def private dispatch prepareStateToAnnotationMapping(State state, Annotation annot) {/* this method is here just to enable the dispatch */}
	
	def private getUseCaseStepText(State state) {
		val step = state2ucstep.get(state)
		if(step == null) return null
		
		return '''«step.label». «step.text»'''
	}
	
	def private getType(State state){
		state2type.get(state)
	}
	
	package def transform(Automaton automaton, List<Pair<FormulaHolder, Group>> holderGroupList) {
		
		automaton.initState.stateId

		// iterating over an immutable copy because we will update transitions within the automaton
		for(trans : automaton.transitions.immutableCopy) {
			for( annot : trans.annotations.immutableCopy) {
				automaton.prepareTransitionAnnotationMapping(trans, annot)
			}
		}

		for(s: automaton.states) {
			mapStateToTransitions.put(s, newArrayList)
			
			for(annot : s.annotations) {
				s.prepareStateToAnnotationMapping(annot)
			}
		}
		
		for(trans : automaton.transitions) {
			mapStateToTransitions.get(trans.start).add(trans)
		}
		
		val groupToVarNameMap = automaton.transitions.transToGroupVarName
		val groupVarNameToTransMap = automaton.transitions.transToGroupVarNameTrans
		
		return '''
		MODULE main
		
		-- Variable "s" represents all the possible states of the automaton
		VAR s : {
			«automaton.states.map[stateId].join(", ").wrap(NUSMV_CODE_WRAP_LENGTH)»
		};
		
		-- We need to highlight states relevant for checking temporal formulae.
		-- This is necessary due to the translation of TADL -> NuSMV formulae because
		-- the granularity of states changed during UCM->LTS transformation.
		DEFINE jmp := s in {
			«automaton.states.filter[ s |
				StateType.JMP.literal.equals(s.type) ||	// state type is JMP
				s.stateTransitions.exists[end == s]		// s->s loop (final + abort loops)
			].map[stateId].join(", ").wrap(NUSMV_CODE_WRAP_LENGTH)»
		};
		
		ASSIGN -- here come the states and transitions
			init(s) := «automaton.initState.stateId»;
			next(s) := case
				«FOR state : automaton.states»
				s = «state.stateId» : {«state.stateTransitions.map[end.stateId].join(", ")»}; -- «state.type» : «state.useCaseStepText.abbreviate(NUSMV_CODE_ABBREVIATE_LENGTH, NUSMV_CODE_ABBREVIATE_LENGTH, "...")»
					«FOR trans : state.stateTransitions.sortInplace[a,b| if(a.guarded) -1 else 1]»
						«IF trans.guarded»
							«IF "FALSE".equalsIgnoreCase(trans.guardingFormula)»
							-- TODO: the following line can be optimized by changing the non-deterministic choice in «state.stateId»
							«ENDIF»
							s = «trans.end.stateId» & !(«trans.guardingFormula») : «state.stateId»;
							«trans.start.addToFairness»
							«trans.end.addToFairness»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			esac;
			
		
		-- ====================== VARIABLES REPRESENTING MARK ANNOTATIONS ON TRANSITIONS ==========
		
		«FOR vardef : markvar2trans.keySet»
			VAR «vardef.name» : boolean;
			ASSIGN
				init(«vardef.name») := FALSE;
				next(«vardef.name») := case
					«FOR trans : markvar2trans.get(vardef)»
						s=«trans.start.stateId» : TRUE; -- transition («trans.start.stateId» -> «trans.end.stateId»)
					«ENDFOR»
					TRUE : «vardef.name»;
				esac;
		«ENDFOR»
		
		-- ====================== VARIABLES REPRESENTING ACTIONS ON TRANSITIONS ===================

		«FOR vardef : actvar2acttrans.keySet»
			VAR «vardef.name» : boolean;
			ASSIGN
				init(«vardef.name») := FALSE;
				next(«vardef.name») := case
					«FOR pair : actvar2acttrans.get(vardef)»
						«val act = pair.key»
						«val trans = pair.value»
						s=«trans.end.stateId» : «act.value.toString.toUpperCase»; -- transition («trans.start.stateId» -> «trans.end.stateId»)
					«ENDFOR»
					TRUE : «vardef.name»;
				esac;
		«ENDFOR»
			
		-- =================================== FAIRNESS IN GUARDS ==================================

«««		this block must go after code which contains trans.end.addToFairness
		-- The execution cannot loop infinitely in any of the following states
		FAIRNESS !guardloop;
		DEFINE guardloop := s in {
			«guardLoopFairnessStates.map[stateId].join(", ").wrap(NUSMV_CODE_WRAP_LENGTH)»
		};
««« 	temporal annotations
		«FOR group : groupToVarNameMap.keySet»
			«val templateVarNames = groupToVarNameMap.get(group)»
			
			-- ====================== TEMPORAL ANNOTATIONS «templateVarNames.join(", ")» «group.qualifier» ===================
			«FOR templateVarName : templateVarNames»
				«val nusmvVarName = createTadlVarName(group.qualifier, templateVarName)»
				«val transitions = groupVarNameToTransMap.get(group -> templateVarName)»
				VAR «nusmvVarName»: boolean;
				ASSIGN
					init(«nusmvVarName») := FALSE;
					next(«nusmvVarName») := case
					«IF !transitions.empty»
««« 					sets variable to TRUE in states that have temporal annotation attached (JMP states)
						s in { «transitions.map[start.stateId].join(", ")» } : TRUE;
««« 					sets to FALSE in states after states with attached temp. annoation (EXT states)
						s in { «transitions.map[end.stateId].join(", ")» } : FALSE;
					«ENDIF»
						TRUE: «nusmvVarName»;
					esac;
			«ENDFOR»
			
««« 		CTL/LTS formulas
««« 		create translation map from template variable (e.g. "create") to concrete variable ("create_zoom")
			«val map = createTemplateVar2NuSmvVarMap(group.qualifier, templateVarNames)»
			«val tadlRenderer = new TadlFormulaRenderer(map)»
			«FOR fh : group.template.formulaHolders»
			 	-- Formula: "«fh.comment»"
			 	-- TADL «tadlRenderer.evalFormula(fh.formula)»
			 	«fh.formulaType.literal»SPEC «tadlRenderer.evalFormula(fh.formula)»
			 	«addFormulaHolderAndGroup(fh, group, holderGroupList)»
			«ENDFOR»
		«ENDFOR»
		'''
	}
	
	def private void addFormulaHolderAndGroup(FormulaHolder fh, Group group, List<Pair<FormulaHolder, Group>> holderGroupList) {
	 	holderGroupList += fh -> group
	}
	
	def private createTemplateVar2NuSmvVarMap(String qualifier, Set<String> varNames) {
		val result = <String, String> newHashMap
		varNames.forEach[result.put(it, createTadlVarName(qualifier, it))]
		return result
	}

	/**
	 * Creates a HashMultimap whose key is a TADL group and values are transitions.
	 */
	def private transToGroupVarName(Iterable<Transition> transitions) {
		transitions.map[ transition |
			
			// FIRST: add variable names used in all temporal annotations
			transition.start.annotations
			.filter(TemporalAnnotation) // all temporal annotations of a single transition
			.map[group -> variableDefinition.name]
			
			+ // joining these two lists of pairs
			
			// SECOND: add all variable names from template
			transition.start.annotations
			.filter(TemporalAnnotation) // all temporal annotations of a single transition
			.map[a|
				a.group.template.variableDefinitions.map[a.group -> name]
			].flatten
			
		].flatten
		.toMultimap 
	}
	
	/**
	 * Creates a HashMultimap whose key is a pair of TADL group + vdefname and values are transitions.
	 */
	def private transToGroupVarNameTrans(Iterable<Transition> transitions) {
		transitions.map[ transition |
			// add variable names used in all temporal annotations
			transition.start.annotations
			.filter(TemporalAnnotation) // all temporal annotations of a single transition
			.map[(group -> variableDefinition.name) -> transition]
			
		].flatten
		.toMultimap // grouped by key, values with the same key will be stored in a set
	}
}

// TODO: Is this DummyMap really necessary?
class DummyMap<K> extends HashMap<K, K> {

	override get(Object key) {
		key as K
	}
	
}