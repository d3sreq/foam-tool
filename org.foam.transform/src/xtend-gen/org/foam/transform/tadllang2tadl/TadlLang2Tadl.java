package org.foam.transform.tadllang2tadl;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.foam.propositionallogic.Formula;
import org.foam.propositionallogic.PropositionallogicFactory;
import org.foam.tadl.FormulaHolder;
import org.foam.tadl.FormulaType;
import org.foam.tadl.TadlFactory;
import org.foam.tadl.Template;

@SuppressWarnings("all")
public class TadlLang2Tadl {
  private final /* CtlXtextParser */Object ctlParser;
  
  private final /* LtlXtextParser */Object ltlParser;
  
  private final TadlFactory tadlFactory = TadlFactory.eINSTANCE;
  
  private final PropositionallogicFactory propFactory = PropositionallogicFactory.eINSTANCE;
  
  private final String FORMULA_COMMENT_REGEXP = "##\\s*(.+)";
  
  private final String FORMULA_REGEXP = "(\\w+) (.+)";
  
  public TadlLang2Tadl() {
    throw new Error("Unresolved compilation problems:"
      + "\nCtlXtextStandaloneSetup cannot be resolved."
      + "\nThe method or field CtlXtextParser is undefined for the type TadlLang2Tadl"
      + "\nLtlXtextStandaloneSetup cannot be resolved."
      + "\nThe method or field LtlXtextParser is undefined for the type TadlLang2Tadl"
      + "\ncreateInjectorAndDoEMFRegistration cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ncreateInjectorAndDoEMFRegistration cannot be resolved"
      + "\ngetInstance cannot be resolved");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field RuleVariableUse is undefined for the type TadlLang2Tadl"
      + "\nThe method variable is undefined for the type TadlLang2Tadl");
  }
  
  private void parseFormula(final FormulaType formulaType, final String formulaBody, final String comment, final Template template) {
    CtlXtextParser _switchResult = null;
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
