package org.foam.transform.lts2nusmvlang;

import java.util.Arrays;
import java.util.Map;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.foam.ctl.AllFinally;
import org.foam.ctl.AllGlobally;
import org.foam.ctl.AllNext;
import org.foam.ctl.AllUntil;
import org.foam.ctl.ExistsFinally;
import org.foam.ctl.ExistsGlobally;
import org.foam.ctl.ExistsNext;
import org.foam.ctl.ExistsUntil;
import org.foam.ltl.Future;
import org.foam.ltl.Globally;
import org.foam.ltl.Historically;
import org.foam.ltl.Next;
import org.foam.ltl.Once;
import org.foam.ltl.Releases;
import org.foam.ltl.Since;
import org.foam.ltl.Triggered;
import org.foam.ltl.Until;
import org.foam.propositionallogic.And;
import org.foam.propositionallogic.Equivalence;
import org.foam.propositionallogic.False;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.Implication;
import org.foam.propositionallogic.Not;
import org.foam.propositionallogic.Or;
import org.foam.propositionallogic.True;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;
import org.foam.transform.lts2nusmvlang.DummyMap;

@SuppressWarnings("all")
public class NuSMVFormulaRenderer {
  private final Map<String,String> varNameMapping;
  
  public NuSMVFormulaRenderer(final Map<String,String> varNameMapping) {
    this.varNameMapping = varNameMapping;
  }
  
  public NuSMVFormulaRenderer() {
    DummyMap<String> _dummyMap = new DummyMap<String>();
    this.varNameMapping = _dummyMap;
  }
  
  protected CharSequence _evalFormula(final Formula f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("?");
    String _string = f.toString();
    _builder.append(_string, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Not f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("!");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final VariableUse f) {
    StringConcatenation _builder = new StringConcatenation();
    VariableDefinition _variableDefinition = f.getVariableDefinition();
    String _name = _variableDefinition.getName();
    String _get = this.varNameMapping.get(_name);
    _builder.append(_get, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final And f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" & ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Or f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" | ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Implication f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" -> ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Equivalence f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" <-> ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final False f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("FALSE");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final True f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TRUE");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Next f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[!jmp U (jmp & X ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(")]");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Globally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("G(jmp -> ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Future f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("F ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Historically f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("H(jmp -> ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Once f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("O ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Until f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((jmp -> ");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(") U ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Since f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((jmp -> ");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(") S ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Triggered f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" T (jmp -> ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("))");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final Releases f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" V (jmp -> ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("))");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final ExistsGlobally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EG(jmp -> ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final ExistsFinally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EF ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final ExistsNext f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EX E[ !jmp U (jmp & ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(") ]");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final AllGlobally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AG(jmp -> ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(")");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final AllFinally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AF ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final AllNext f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AX A[ !jmp U (jmp & ");
    Formula _formula = f.getFormula();
    Object _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    _builder.append(") ]");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final AllUntil f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A[(jmp -> ");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(") U ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("]");
    return _builder;
  }
  
  protected CharSequence _evalFormula(final ExistsUntil f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E[(jmp -> ");
    Formula _left = f.getLeft();
    Object _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(") U ");
    Formula _right = f.getRight();
    Object _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("]");
    return _builder;
  }
  
  public Object evalFormula(final Formula f) {
    if (f instanceof AllFinally) {
      return _evalFormula((AllFinally)f);
    } else if (f instanceof AllGlobally) {
      return _evalFormula((AllGlobally)f);
    } else if (f instanceof AllNext) {
      return _evalFormula((AllNext)f);
    } else if (f instanceof AllUntil) {
      return _evalFormula((AllUntil)f);
    } else if (f instanceof ExistsFinally) {
      return _evalFormula((ExistsFinally)f);
    } else if (f instanceof ExistsGlobally) {
      return _evalFormula((ExistsGlobally)f);
    } else if (f instanceof ExistsNext) {
      return _evalFormula((ExistsNext)f);
    } else if (f instanceof ExistsUntil) {
      return _evalFormula((ExistsUntil)f);
    } else if (f instanceof Future) {
      return _evalFormula((Future)f);
    } else if (f instanceof Globally) {
      return _evalFormula((Globally)f);
    } else if (f instanceof Historically) {
      return _evalFormula((Historically)f);
    } else if (f instanceof Next) {
      return _evalFormula((Next)f);
    } else if (f instanceof Once) {
      return _evalFormula((Once)f);
    } else if (f instanceof Releases) {
      return _evalFormula((Releases)f);
    } else if (f instanceof Since) {
      return _evalFormula((Since)f);
    } else if (f instanceof Triggered) {
      return _evalFormula((Triggered)f);
    } else if (f instanceof Until) {
      return _evalFormula((Until)f);
    } else if (f instanceof And) {
      return _evalFormula((And)f);
    } else if (f instanceof Equivalence) {
      return _evalFormula((Equivalence)f);
    } else if (f instanceof Implication) {
      return _evalFormula((Implication)f);
    } else if (f instanceof Not) {
      return _evalFormula((Not)f);
    } else if (f instanceof Or) {
      return _evalFormula((Or)f);
    } else if (f instanceof False) {
      return _evalFormula((False)f);
    } else if (f instanceof True) {
      return _evalFormula((True)f);
    } else if (f instanceof VariableUse) {
      return _evalFormula((VariableUse)f);
    } else if (f != null) {
      return _evalFormula(f);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(f).toString());
    }
  }
}
