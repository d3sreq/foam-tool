package lts2dot.processor.state

import lts2dot.processor.state.StateProcessor
import org.foam.lts.State
import org.foam.dot.DotFactory
import org.foam.traceability.UseCaseMappingAnnotation
import org.foam.dot.Graph
import org.foam.dot.Node
import java.util.Map

@Data
class CreateOverviewNodeStateProcessor implements StateProcessor {
	
	private Graph resultDot
	private Map<State, Node> state2Node
	
	val dotFactory = DotFactory::eINSTANCE
	
	override process(State state) {
		val useCase = state.annotations.filter(typeof(UseCaseMappingAnnotation)).head.useCase
		
		val node = dotFactory.createNode => [
			id = useCase.id
			attributes.put("URL", '''../«id»/«id».html''')
			attributes.put("tooltip", useCase.name)
			attributes.put("target", "_top")
		]
		resultDot.statements += node 
		state2Node.put(state, node)
		
		true
	}
	
}