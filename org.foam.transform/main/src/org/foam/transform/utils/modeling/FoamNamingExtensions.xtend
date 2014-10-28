package org.foam.transform.utils.modeling

/**
 * This extension unifies naming conventions used within FOAM transformations.
 * TODO: is this extension really needed?
 */
class FoamNamingExtensions {
	
	private static val TADL_VARIABLE_PREFIX = "tadl_"
	private static val MARK_VARIABLE_PREFIX = "mark_"
	private static val DONE_VARIABLE_PREFIX = "done_"
	private static val INIT_STATE_ID = "init0" // "init" is a reserved NuSMV keyword 
	private static val FINAL_STATE_ID = "final"
	
	@Pure static def String createTadlVarName(String qualifier, String templateVarName) '''«TADL_VARIABLE_PREFIX»«templateVarName»_«qualifier»'''
	@Pure static def String createMarkVarName(String variableName)	'''«MARK_VARIABLE_PREFIX»«variableName»'''
	@Pure static def String createDoneStateId(String useCaseId) '''«DONE_VARIABLE_PREFIX»«useCaseId»'''
	@Pure static def createInitStateId() {INIT_STATE_ID}
	@Pure static def createFinalStateId() {FINAL_STATE_ID}
}