package org.foam.transform.tadllang2tadl

import com.google.common.base.Splitter
import java.util.ArrayList
import java.util.HashMap
import java.util.regex.Pattern
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser
import org.foam.ctl.CtlPackage
import org.foam.ltl.LtlPackage
import org.foam.propositionallogic.Formula
import org.foam.propositionallogic.PropositionallogicFactory
import org.foam.propositionallogic.VariableDefinition
import org.foam.tadl.FormulaType
import org.foam.tadl.TadlFactory
import org.foam.tadl.Template
import org.foam.xtext.ctl.CtlXtextStandaloneSetup
import org.foam.xtext.ctl.parser.antlr.CtlXtextParser
import org.foam.xtext.ltl.LtlXtextStandaloneSetup
import org.foam.xtext.ltl.parser.antlr.LtlXtextParser
import org.foam.xtext.plogic.propositionalLogicXtext.RuleVariableUse

class TadlLang2Tadl {
	
	val CtlXtextParser ctlParser
	val LtlXtextParser ltlParser
	val TadlFactory tadlFactory = TadlFactory.eINSTANCE
	val PropositionallogicFactory propFactory = PropositionallogicFactory.eINSTANCE
	val FORMULA_COMMENT_REGEXP = "##\\s*(.+)"
	val FORMULA_REGEXP = "(\\w+) (.+)"	
	
	new() {
		// Added to manually register package when running outside the eclipse.
		// In eclipse package is recognized by extension point.
		// Without registration exception with "Unresolved proxy" is thrown
		// when parsing Ctl or LTL formula (propositional logic formula is parsed
		// without errors).
		//
		// Package should be probably registered in GenerateLtlXtext.mwe2 file
		// but wasn't able to figure out how to do it.
		if (!EPackage.Registry.INSTANCE.containsKey(CtlPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(CtlPackage.eNS_URI, CtlPackage.eINSTANCE)
		}
		if (!EPackage.Registry.INSTANCE.containsKey(LtlPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(LtlPackage.eNS_URI, LtlPackage.eINSTANCE)
		}
		
		// TODO - use guice annotations to inject parser instead ?
		val ctlInjector = new CtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration
		ctlParser = ctlInjector.getInstance(CtlXtextParser)
		
		val ltlInjector = new LtlXtextStandaloneSetup().createInjectorAndDoEMFRegistration
		ltlParser = ltlInjector.getInstance(LtlXtextParser)
	}
	
	def public Template parse(CharSequence input) {
		// parse each line with CTL and LTL parser, distinguish by CTL or LTL on start
		// of each line
		val result = input.parseFormulas
		
		// add VariableDefinition and replace RuleVariableUse with VariableUse
		resolveVariables(result)
		
		result
	}
	
	//TODO:reimplement in functional style
	def private Template parseFormulas(CharSequence input) {
		val result = tadlFactory.createTemplate
		val splitter = Splitter.on('\n').trimResults
		
		val formulaPattern = Pattern.compile(FORMULA_REGEXP)
		val commentPattern = Pattern.compile(FORMULA_COMMENT_REGEXP)
		
		val comments = new ArrayList<String>
		
		for (line : splitter.split(input)) {			 
			val matcher = formulaPattern.matcher(line)
			val commentMatcher = commentPattern.matcher(line)
			
			if (commentMatcher.matches) {
				val lineComment = commentMatcher.group(1)
				comments.add(lineComment)
				
			} else if (matcher.matches) {
				val formulaType = FormulaType.valueOf(matcher.group(1))
				val formulaBody = matcher.group(2)
				val comment = comments.join(' ')
				parseFormula(formulaType, formulaBody, comment, result)
				
				comments.clear 
			}
		}
		
		result
	}
	
	def private void resolveVariables(Template template) {
		val ruleVars = EcoreUtil2.getAllContentsOfType(template, RuleVariableUse)
		val varName2VarDef = new HashMap<String, VariableDefinition>
		
		for (ruleVar : ruleVars) {
			// replace RuleVariableUse with VariableUse			
			val varName = ruleVar.variable
			
			if (!varName2VarDef.containsKey(varName)) {
				val varDef = propFactory.createVariableDefinition => [
					name = varName
				]
				varName2VarDef.put(varName, varDef)
				template.variableDefinitions += varDef
			}
			
			val varUse = propFactory.createVariableUse => [
				variableDefinition = varName2VarDef.get(varName)
			]
			
			EcoreUtil2.replace(ruleVar, varUse)
		}
	}
	
	def private void parseFormula(FormulaType formulaType, String formulaBody, String comment, Template template) {
		val AbstractAntlrParser parser = switch formulaType {
			case FormulaType.CTL: ctlParser
			case FormulaType.LTL: ltlParser
		}
		
		val parseResult = parser.doParse(formulaBody)
		// TODO - error handling
		val formula = parseResult.rootASTElement as Formula
		template.formulaHolders.add(tadlFactory.createFormulaHolder => [
			it.formula = formula
			it.formulaType = formulaType
			it.comment = comment
		])
	}
	
}