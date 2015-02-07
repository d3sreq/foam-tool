package org.foam.cli.tools.report.pages

import org.foam.annotation.Annotation
import org.foam.flowannotation.Abort
import org.foam.flowannotation.Goto
import org.foam.flowannotation.Guard
import org.foam.flowannotation.Include
import org.foam.tadl.TemporalAnnotation
import org.foam.flowannotation.Mark
import org.foam.annotation.UnknownAnnotation
import org.foam.transform.lts2nusmvlang.TadlFormulaRenderer

class FoamCommonAnnotationRenderer {
	
	extension TadlFormulaRenderer = new TadlFormulaRenderer
	
	// fallback (this is not the "unknown" annotation) 
	def dispatch render(Annotation annot) '''?«annot»'''
	
	// unknown annotation - TODO
	def dispatch render(UnknownAnnotation annot) '''<span style="color:violet">#«annot.parts.join(":")»</span>'''

	// flow annotations
	def dispatch render(Abort annot) '''#abort'''
	def dispatch render(Include annot) '''#include:<a href="../«annot.inlinedUseCase.id»/«annot.inlinedUseCase.id».html">«annot.inlinedUseCase.id»</a>'''
	def dispatch render(Goto annot) '''#goto:«annot.target.label»'''	
	def dispatch render(Guard annot) '''#guard:«annot.formula.evalFormula»'''
	def dispatch render(Mark annot)  '''#«IF !annot.value»un«ENDIF»mark:«annot.variableDefinition.name»'''

	// temporal annotations
	def dispatch render(TemporalAnnotation annot) '''#«annot.variableDefinition.name»:«annot.group.qualifier»'''
	
}