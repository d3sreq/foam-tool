package org.foam.cli.tools.report.pages

import org.foam.tadl.Template
import org.foam.transform.lts2nusmvlang.TadlFormulaRenderer
import org.eclipse.xtend.lib.annotations.Data

@Data
class TadlTemplatePage implements Page {

	val Menu menu
	val Template template	
	val renderer = new TadlFormulaRenderer
	
	override getId() {
		template.variableDefinitions.map[name].join("-")
	}
	
	override content() {
		val css = ""
		val printedMenu = menu.printMenu(this)
		val templateContent = printTemplateContent
		new PageTemplate().printPage(css, printedMenu, templateContent) 
	}
	
	def private printTemplateContent() '''
		<div>
			<h1>TADL: «id»</h1>
««« TODO - print variables ?
««« TODO - prettier output ?
			«FOR formulaHolder : template.formulaHolders»
			<p>
			«formulaHolder.comment»:
			<pre>«formulaHolder.formulaType» «renderer.evalFormula(formulaHolder.formula)»</pre>
			</p>
			«ENDFOR»
		</div>
		<div style="padding-top: 20px">
			<h2>Temporal Operators Explained</h2>
			«FOR op : renderer.collectTemporalOperatorDescriptions(template.formulaHolders.map[formula])»
			<pre>«op»</pre>
			«ENDFOR»
		</div>
	'''
	
}