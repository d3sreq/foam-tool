package org.foam.transform.utils.naming;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class NameService {
  private final static String TADL_VARIABLE_PREFIX = "tadl_";
  
  private final static String MARK_VARIABLE_PREFIX = "mark_";
  
  private final static String DONE_VARIABLE_PREFIX = "done_";
  
  private final static String INIT_STATE_ID = "init0";
  
  private final static String FINAL_STATE_ID = "final";
  
  public String createTadlVarName(final String qualifier, final String templateVarName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(NameService.TADL_VARIABLE_PREFIX, "");
    _builder.append(templateVarName, "");
    _builder.append("_");
    _builder.append(qualifier, "");
    return _builder.toString();
  }
  
  public String createMarkVarName(final String variableName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(NameService.MARK_VARIABLE_PREFIX, "");
    _builder.append(variableName, "");
    return _builder.toString();
  }
  
  public String createDoneStateId(final String useCaseId) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(NameService.DONE_VARIABLE_PREFIX, "");
    _builder.append(useCaseId, "");
    return _builder.toString();
  }
  
  public String createInitStateId() {
    return NameService.INIT_STATE_ID;
  }
  
  public String createFinalStateId() {
    return NameService.FINAL_STATE_ID;
  }
}
