package org.foam.transform.lts2nusmvlang;

import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Reference;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.foam.lts.Automaton;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.Group;
import org.foam.transform.lts2nusmvlang.Lts2NusmvContext;
import org.foam.transform.utils.logger.LogServiceExtension;
import org.osgi.service.log.LogService;

@Component(provide = Lts2NusmvLangService.class)
@SuppressWarnings("all")
public class Lts2NusmvLangService {
  @Extension
  private LogServiceExtension logServiceExtension;
  
  @Reference
  public void setLogService(final LogService logService) {
    LogServiceExtension _logServiceExtension = new LogServiceExtension(logService);
    this.logServiceExtension = _logServiceExtension;
  }
  
  public String transform(final Automaton automaton) {
    ArrayList<Pair<FormulaHolder, Group>> _newArrayList = CollectionLiterals.<Pair<FormulaHolder, Group>>newArrayList();
    return this.transform(automaton, _newArrayList);
  }
  
  public String transform(final Automaton automaton, final List<Pair<FormulaHolder, Group>> holderGroupList) {
    Lts2NusmvContext _lts2NusmvContext = new Lts2NusmvContext();
    return _lts2NusmvContext.transform(automaton, holderGroupList);
  }
}
