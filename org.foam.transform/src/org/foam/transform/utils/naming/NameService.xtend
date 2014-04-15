package org.foam.transform.utils.naming

class NameService {
	private static val TADL_VARIABLE_PREFIX = "tadl_"
	private static val MARK_VARIABLE_PREFIX = "mark_"
	private static val DONE_VARIABLE_PREFIX = "done_"
	private static val INIT_STATE_ID = "init0" // "init" is a reserved NuSMV keyword 
	private static val FINAL_STATE_ID = "final"
	
	def createMarkVarName(String variableName) {
		MARK_VARIABLE_PREFIX + variableName
	}
	
	def createDoneStateId(String useCaseId) {
		DONE_VARIABLE_PREFIX + useCaseId
	}
	
	def createInitStateId() {
		INIT_STATE_ID
	}
	
	def createFinalStateId() {
		FINAL_STATE_ID
	}
	
	def createTadlVarName(String qualifier, String templateVarName) {
		TADL_VARIABLE_PREFIX + templateVarName + "_" + qualifier
	}
}