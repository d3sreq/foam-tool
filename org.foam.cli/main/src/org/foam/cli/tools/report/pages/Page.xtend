package org.foam.cli.tools.report.pages

interface Page {
	def String getId()
	def CharSequence content()
}
