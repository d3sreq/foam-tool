package org.foam.transform.lts2nusmvlang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.ctl.AllFinally;
import org.foam.ctl.AllGlobally;
import org.foam.ctl.AllNext;
import org.foam.ctl.AllUntil;
import org.foam.ctl.CtlPackage;
import org.foam.ctl.ExistsFinally;
import org.foam.ctl.ExistsGlobally;
import org.foam.ctl.ExistsNext;
import org.foam.ctl.ExistsUntil;
import org.foam.ltl.Future;
import org.foam.ltl.Globally;
import org.foam.ltl.Historically;
import org.foam.ltl.LtlPackage;
import org.foam.ltl.Next;
import org.foam.ltl.Once;
import org.foam.ltl.Releases;
import org.foam.ltl.Since;
import org.foam.ltl.Triggered;
import org.foam.ltl.Until;
import org.foam.propositionallogic.And;
import org.foam.propositionallogic.BinaryFormula;
import org.foam.propositionallogic.Equivalence;
import org.foam.propositionallogic.False;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.Implication;
import org.foam.propositionallogic.Not;
import org.foam.propositionallogic.Or;
import org.foam.propositionallogic.True;
import org.foam.propositionallogic.UnaryFormula;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;
import org.foam.transform.lts2nusmvlang.DummyMap;

@SuppressWarnings("all")
public class TADLFormulaRenderer {
  private final Map<String,String> varNameMapping;
  
  public TADLFormulaRenderer(final Map<String,String> varNameMapping) {
    this.varNameMapping = varNameMapping;
  }
  
  public TADLFormulaRenderer() {
    DummyMap<String> _dummyMap = new DummyMap<String>();
    this.varNameMapping = _dummyMap;
  }
  
  public Iterable<String> collectTemporalOperatorDescriptions(final Iterable<Formula> list) {
    Iterable<String> _xblockexpression = null;
    {
      final HashSet<EClass> collected = new HashSet<EClass>();
      final Procedure1<Formula> _function = new Procedure1<Formula>() {
        public void apply(final Formula it) {
          TADLFormulaRenderer.this.collect(it, collected);
        }
      };
      IterableExtensions.<Formula>forEach(list, _function);
      final Function1<EClass,String> _function_1 = new Function1<EClass,String>() {
        public String apply(final EClass it) {
          return TADLFormulaRenderer.this.operator2Description.get(it);
        }
      };
      Iterable<String> _map = IterableExtensions.<EClass, String>map(collected, _function_1);
      _xblockexpression = IterableExtensions.<String>filterNull(_map);
    }
    return _xblockexpression;
  }
  
  protected void _collect(final UnaryFormula f, final Set<EClass> collected) {
    EClass _eClass = f.eClass();
    collected.add(_eClass);
    Formula _formula = f.getFormula();
    this.collect(_formula, collected);
  }
  
  protected void _collect(final BinaryFormula f, final Set<EClass> collected) {
    EClass _eClass = f.eClass();
    collected.add(_eClass);
    Formula _left = f.getLeft();
    this.collect(_left, collected);
    Formula _right = f.getRight();
    this.collect(_right, collected);
  }
  
  protected void _collect(final Formula f, final Set<EClass> collected) {
  }
  
  private final HashMap<EClass,String> operator2Description = CollectionLiterals.<EClass, String>newHashMap(
    Pair.<EClass, String>of(LtlPackage.Literals.NEXT, "LTL: X(f) = \'Next\', i.e. f holds in the next use-case step."), 
    Pair.<EClass, String>of(LtlPackage.Literals.GLOBALLY, "LTL: G(f) = \'Globally\', i.e. f holds in all steps."), 
    Pair.<EClass, String>of(LtlPackage.Literals.FUTURE, "LTL: F(f) = \'Future\', i.e. there is a step in future where f holds."), 
    Pair.<EClass, String>of(LtlPackage.Literals.UNTIL, "LTL: [f U g] = \'Until\', i.e. at some point g holds while in the meantime f holds."), 
    Pair.<EClass, String>of(LtlPackage.Literals.RELEASES, "LTL: [f R g] = \'Release\', is equivalent to ![ !f U !g ]"), 
    Pair.<EClass, String>of(LtlPackage.Literals.HISTORICALLY, "PLTL: H(f) = \'Historically\', i.e. f holds in all previous steps in the past."), 
    Pair.<EClass, String>of(LtlPackage.Literals.ONCE, "PLTL: O(f) = \'Once\', i.e. f held in at least one step in the past (past also includes current step)."), 
    Pair.<EClass, String>of(LtlPackage.Literals.SINCE, "PLTL: [f S g] = \'Since\', i.e. f held in some step in the past (past also includes current step) and q holds in all following steps."), 
    Pair.<EClass, String>of(LtlPackage.Literals.TRIGGERED, "PLTL: [f T g] = \'Triggered\', i.e. f held in past (past also includes current step) and q holds in all following steps. If f has never been true, then g must hold in all steps from beginning up to current step (included)."), 
    Pair.<EClass, String>of(CtlPackage.Literals.EXISTS_GLOBALLY, "CTL: EG(f) = \'Exists globally\', i.e. exists (infinite) path starting with current step such that f holds in all it\'s steps."), 
    Pair.<EClass, String>of(CtlPackage.Literals.EXISTS_FINALLY, "CTL: EF(f) = \'Exists finally\', i.e. exists path starting with current step containing step where f holds."), 
    Pair.<EClass, String>of(CtlPackage.Literals.EXISTS_NEXT, "CTL: EX(f) = \'Exists next\', i.e. f holds in one of the following steps."), 
    Pair.<EClass, String>of(CtlPackage.Literals.ALL_GLOBALLY, "CTL: AG(f) = \'All globally\', i.e. holds on all paths in all steps."), 
    Pair.<EClass, String>of(CtlPackage.Literals.ALL_FINALLY, "CTL: AF(f) = \'All finally\', i.e. in all paths starting with current step exists a step where f holds."), 
    Pair.<EClass, String>of(CtlPackage.Literals.ALL_NEXT, "CTL: AX(f) = \'All next\', i.e. f holds in all following steps."), 
    Pair.<EClass, String>of(CtlPackage.Literals.ALL_UNTIL, "CTL: A[f U g] = \'All Until\', i.e. on all paths at some point g holds while in the meantime f holds."), 
    Pair.<EClass, String>of(CtlPackage.Literals.EXISTS_UNTIL, "CTL: E[f U g] = \'Exists Until\', i.e. exists path where at some point g holds while in the meantime f holds."));
  
  protected String _evalFormula(final Formula f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("?");
    String _string = f.toString();
    _builder.append(_string, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Not f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("!");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final VariableUse f) {
    StringConcatenation _builder = new StringConcatenation();
    VariableDefinition _variableDefinition = f.getVariableDefinition();
    String _name = _variableDefinition.getName();
    String _get = this.varNameMapping.get(_name);
    _builder.append(_get, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final And f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" & ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Or f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" | ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Implication f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" -> ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Equivalence f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" <-> ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final False f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("FALSE");
    return _builder.toString();
  }
  
  protected String _evalFormula(final True f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("TRUE");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Next f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("X ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Globally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("G ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Future f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("F ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Until f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" U ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Releases f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" R ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Historically f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("H ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Once f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("O ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Since f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" S ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final Triggered f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" T ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append(")");
    return _builder.toString();
  }
  
  protected String _evalFormula(final ExistsGlobally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EG ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final ExistsFinally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EF ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final ExistsNext f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("EX ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final AllGlobally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AG ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final AllFinally f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AF ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final AllNext f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("AX ");
    Formula _formula = f.getFormula();
    String _evalFormula = this.evalFormula(_formula);
    _builder.append(_evalFormula, "");
    return _builder.toString();
  }
  
  protected String _evalFormula(final AllUntil f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("A[");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" U ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  protected String _evalFormula(final ExistsUntil f) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E[");
    Formula _left = f.getLeft();
    String _evalFormula = this.evalFormula(_left);
    _builder.append(_evalFormula, "");
    _builder.append(" U ");
    Formula _right = f.getRight();
    String _evalFormula_1 = this.evalFormula(_right);
    _builder.append(_evalFormula_1, "");
    _builder.append("]");
    return _builder.toString();
  }
  
  public void collect(final Formula f, final Set<EClass> collected) {
    if (f instanceof BinaryFormula) {
      _collect((BinaryFormula)f, collected);
      return;
    } else if (f instanceof UnaryFormula) {
      _collect((UnaryFormula)f, collected);
      return;
    } else if (f != null) {
      _collect(f, collected);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(f, collected).toString());
    }
  }
  
  public String evalFormula(final Formula f) {
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
