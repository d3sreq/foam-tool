package org.foam.transform.tadllang2tadl;

import com.google.common.base.Splitter;
import com.google.inject.Injector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.ctl.CtlPackage;
import org.foam.ltl.LtlPackage;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.PropositionallogicFactory;
import org.foam.propositionallogic.VariableDefinition;
import org.foam.propositionallogic.VariableUse;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.TadlFactory;
import org.foam.tadl.Template;
import transformation.ctllang2ctl.CtlXtextStandaloneSetup;
import transformation.ctllang2ctl.parser.antlr.CtlXtextParser;
import transformation.ltllang2ltl.LtlXtextStandaloneSetup;
import transformation.ltllang2ltl.parser.antlr.LtlXtextParser;
import transformation.propositionallogiclang2propositionallogic.propositionalLogicXtext.RuleVariableUse;

@SuppressWarnings("all")
public class TadlLang2Tadl {
  private final CtlXtextParser ctlParser;
  
  private final LtlXtextParser ltlParser;
  
  private final TadlFactory tadlFactory = TadlFactory.eINSTANCE;
  
  private final PropositionallogicFactory propFactory = PropositionallogicFactory.eINSTANCE;
  
  private final String FORMULA_COMMENT_REGEXP = "##\\s*(.+)";
  
  private final String FORMULA_REGEXP = "(\\w+) (.+)";
  
  public TadlLang2Tadl() {
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(CtlPackage.eNS_URI);
    boolean _not = (!_containsKey);
    if (_not) {
      EPackage.Registry.INSTANCE.put(CtlPackage.eNS_URI, CtlPackage.eINSTANCE);
    }
    boolean _containsKey_1 = EPackage.Registry.INSTANCE.containsKey(LtlPackage.eNS_URI);
    boolean _not_1 = (!_containsKey_1);
    if (_not_1) {
      EPackage.Registry.INSTANCE.put(LtlPackage.eNS_URI, LtlPackage.eINSTANCE);
    }
    CtlXtextStandaloneSetup _ctlXtextStandaloneSetup = new CtlXtextStandaloneSetup();
    final Injector ctlInjector = _ctlXtextStandaloneSetup.createInjectorAndDoEMFRegistration();
    CtlXtextParser _instance = ctlInjector.<CtlXtextParser>getInstance(CtlXtextParser.class);
    this.ctlParser = _instance;
    LtlXtextStandaloneSetup _ltlXtextStandaloneSetup = new LtlXtextStandaloneSetup();
    final Injector ltlInjector = _ltlXtextStandaloneSetup.createInjectorAndDoEMFRegistration();
    LtlXtextParser _instance_1 = ltlInjector.<LtlXtextParser>getInstance(LtlXtextParser.class);
    this.ltlParser = _instance_1;
  }
  
  public Template parse(final CharSequence input) {
    Template _xblockexpression = null;
    {
      final Template result = this.parseFormulas(input);
      this.resolveVariables(result);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private Template parseFormulas(final CharSequence input) {
    Template _xblockexpression = null;
    {
      final Template result = this.tadlFactory.createTemplate();
      Splitter _on = Splitter.on("\n");
      final Splitter splitter = _on.trimResults();
      final Pattern formulaPattern = Pattern.compile(this.FORMULA_REGEXP);
      final Pattern commentPattern = Pattern.compile(this.FORMULA_COMMENT_REGEXP);
      final ArrayList<String> comments = new ArrayList<String>();
      Iterable<String> _split = splitter.split(input);
      for (final String line : _split) {
        {
          final Matcher matcher = formulaPattern.matcher(line);
          final Matcher commentMatcher = commentPattern.matcher(line);
          boolean _matches = commentMatcher.matches();
          if (_matches) {
            final String lineComment = commentMatcher.group(1);
            comments.add(lineComment);
          } else {
            boolean _matches_1 = matcher.matches();
            if (_matches_1) {
              String _group = matcher.group(1);
              final FormulaType formulaType = FormulaType.valueOf(_group);
              final String formulaBody = matcher.group(2);
              final String comment = IterableExtensions.join(comments, " ");
              this.parseFormula(formulaType, formulaBody, comment, result);
              comments.clear();
            }
          }
        }
      }
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  private void resolveVariables(final Template template) {
    final List<RuleVariableUse> ruleVars = EcoreUtil2.<RuleVariableUse>getAllContentsOfType(template, RuleVariableUse.class);
    final HashMap<String,VariableDefinition> varName2VarDef = new HashMap<String, VariableDefinition>();
    for (final RuleVariableUse ruleVar : ruleVars) {
      {
        final String varName = ruleVar.getVariable();
        boolean _containsKey = varName2VarDef.containsKey(varName);
        boolean _not = (!_containsKey);
        if (_not) {
          VariableDefinition _createVariableDefinition = this.propFactory.createVariableDefinition();
          final Procedure1<VariableDefinition> _function = new Procedure1<VariableDefinition>() {
            public void apply(final VariableDefinition it) {
              it.setName(varName);
            }
          };
          final VariableDefinition varDef = ObjectExtensions.<VariableDefinition>operator_doubleArrow(_createVariableDefinition, _function);
          varName2VarDef.put(varName, varDef);
          EList<VariableDefinition> _variableDefinitions = template.getVariableDefinitions();
          _variableDefinitions.add(varDef);
        }
        VariableUse _createVariableUse = this.propFactory.createVariableUse();
        final Procedure1<VariableUse> _function_1 = new Procedure1<VariableUse>() {
          public void apply(final VariableUse it) {
            VariableDefinition _get = varName2VarDef.get(varName);
            it.setVariableDefinition(_get);
          }
        };
        final VariableUse varUse = ObjectExtensions.<VariableUse>operator_doubleArrow(_createVariableUse, _function_1);
        EcoreUtil2.replace(ruleVar, varUse);
      }
    }
  }
  
  private void parseFormula(final FormulaType formulaType, final String formulaBody, final String comment, final Template template) {
    AbstractAntlrParser _switchResult = null;
    if (formulaType != null) {
      switch (formulaType) {
        case CTL:
          _switchResult = this.ctlParser;
          break;
        case LTL:
          _switchResult = this.ltlParser;
          break;
        default:
          break;
      }
    }
    final AbstractAntlrParser parser = _switchResult;
    final IParseResult parseResult = parser.doParse(formulaBody);
    EObject _rootASTElement = parseResult.getRootASTElement();
    final Formula formula = ((Formula) _rootASTElement);
    EList<FormulaHolder> _formulaHolders = template.getFormulaHolders();
    FormulaHolder _createFormulaHolder = this.tadlFactory.createFormulaHolder();
    final Procedure1<FormulaHolder> _function = new Procedure1<FormulaHolder>() {
      public void apply(final FormulaHolder it) {
        it.setFormula(formula);
        it.setFormulaType(formulaType);
        it.setComment(comment);
      }
    };
    FormulaHolder _doubleArrow = ObjectExtensions.<FormulaHolder>operator_doubleArrow(_createFormulaHolder, _function);
    _formulaHolders.add(_doubleArrow);
  }
}
