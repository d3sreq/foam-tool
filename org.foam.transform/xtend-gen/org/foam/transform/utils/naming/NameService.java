package org.foam.transform.utils.naming;

@SuppressWarnings("all")
public class NameService {
  private final static String TADL_VARIABLE_PREFIX = "tadl_";
  
  private final static String MARK_VARIABLE_PREFIX = "mark_";
  
  private final static String DONE_VARIABLE_PREFIX = "done_";
  
  private final static String INIT_STATE_ID = "init0";
  
  private final static String FINAL_STATE_ID = "final";
  
  public String createMarkVarName(final String variableName) {
    return (NameService.MARK_VARIABLE_PREFIX + variableName);
  }
  
  public String createDoneStateId(final String useCaseId) {
    return (NameService.DONE_VARIABLE_PREFIX + useCaseId);
  }
  
  public String createInitStateId() {
    return NameService.INIT_STATE_ID;
  }
  
  public String createFinalStateId() {
    return NameService.FINAL_STATE_ID;
  }
  
  public String createTadlVarName(final String qualifier, final String templateVarName) {
    return (((NameService.TADL_VARIABLE_PREFIX + templateVarName) + "_") + qualifier);
  }
}
