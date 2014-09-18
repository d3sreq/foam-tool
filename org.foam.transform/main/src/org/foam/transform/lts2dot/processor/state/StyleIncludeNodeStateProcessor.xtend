package org.foam.transform.lts2dot.processor.state

import java.util.Map
import org.eclipse.xtend.lib.annotations.Data
import org.foam.dot.DotFactory
import org.foam.dot.Node
import org.foam.lts.State
import org.foam.traceability.UseCaseMappingAnnotation

@Data
class StyleIncludeNodeStateProcessor implements StateProcessor {
	
	val dotFactory = DotFactory.eINSTANCE
	Map<State, Node> state2Node
	
	override process(State state) {
		val useCaseMappingAnnotations = state.annotations.filter(UseCaseMappingAnnotation)
		if (!useCaseMappingAnnotations.empty) {
			val annotation = useCaseMappingAnnotations.head
			
			val node = state2Node.get(state)
			val useCase = annotation.useCase
			val id = useCase.id
			val label =  '''«id» «useCase.name»'''
			node.attributes.put("label", label)
			
			node.attributes.put("URL", '''../«id»/«id».html''')
			node.attributes.put("target", "_top")
			
			node.attributes.put("shape", "box")
			node.attributes.put("height", "0.5")
			
			node.attributes.put("fillcolor", "#fed9a6")
		}
	}
	
}