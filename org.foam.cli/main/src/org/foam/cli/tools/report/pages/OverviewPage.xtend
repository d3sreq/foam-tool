package org.foam.cli.tools.report.pages

import org.eclipse.xtend.lib.annotations.Data

@Data
class OverviewPage implements Page {
	
	val Menu menu
	val String overviewImageLocation
	
	def private getContent() '''
		<div>
			<h1>Overview</h1>
««« according to http://www.w3schools.com/svg/svg_inhtml.asp can svg be embedded also
««« with <embed> tag which supports scripting
			<object data="«overviewImageLocation»" type="image/svg+xml"></object>			
		</div>
	'''
	
	val css = ""
	
	override content() {
		val printedMenu = menu.printMenu(this)
		new PageTemplate().printPage(css, printedMenu, getContent)
	}
	
	override getId() '''overview'''
}