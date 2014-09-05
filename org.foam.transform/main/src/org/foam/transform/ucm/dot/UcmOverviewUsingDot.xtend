package org.foam.transform.ucm.dot

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import org.foam.dot.DotFactory
import org.foam.dot.SettingsType
import org.foam.transform.dot2dotlang.Dot2DotLang
import org.foam.transform.ucm.overview.UcmOverviewCreator
import org.foam.transform.utils.logger.LogServiceExtension
import org.foam.transform.utils.modeling.EmfCommons
import org.foam.ucm.UseCaseModel
import org.osgi.service.log.LogService

@Component(provide = UcmOverviewUsingDot)
class UcmOverviewUsingDot {

	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}
	
	private UcmOverviewCreator ucmOverviewCreator
	@Reference def void setUcmOverviewCreator(UcmOverviewCreator ucmOverviewCreator) {
		this.ucmOverviewCreator = ucmOverviewCreator
	}
	
	val dotFactory = DotFactory.eINSTANCE
	
	def transform(UseCaseModel ucm) {
		
		val ucmap = ucmOverviewCreator.transform(ucm)
		
		'''Using hard-coded DOT template'''.debug
		val dotGraph = dotFactory.createGraph => [
		
			id = "usecase"
			
			statements += #[
				"rankdir"   -> "BT",
				"fontcolor" -> "gray",
				"fontname"  -> "Arial",
				"margin"    -> "1",
				"dpi"       -> "70",
				"ranksep"   -> "0.4",
				"nodesep"   -> "0.2",
				"labeljust" -> "l"
			].map[ pair | dotFactory.createAssignment =>[
				key = pair.key
				value = pair.value
			]]
			
			statements +=  dotFactory.createSettings => [
				type = SettingsType.NODE
				attributes.put("stype", "filled")
				attributes.put("fontname", "Arial")
				attributes.put("shape", "oval")
				attributes.put("fillcolor", "#f2f2f2")
				attributes.put("height", "0.1")
			]
			
			statements +=  dotFactory.createSettings => [
				type = SettingsType.EDGE
				attributes.put("fontname", "Arial")
			]
		]
		
		val dotmap = ucmap.values.map[ useCase |
			dotFactory.createNode => [
				id = useCase.id
				attributes.put("URL", '''../«id»/«id».html''')
				attributes.put("tooltip", useCase.name)
				attributes.put("target", "_top")
			]
		].toMap[id]
		
		// use-cases as nodes
		dotGraph.statements += dotmap.values 
		
		// precedes as transitions
		dotGraph.statements += ucmap.values.map[
			val sourceUseCase = id
			precedes.map[ targetUseCase |
				dotFactory.createEdge => [
					source = dotmap.get(sourceUseCase)
					target = dotmap.get(targetUseCase)
				]
			]
		].flatten

		// includes as transitions
		dotGraph.statements += ucmap.values.map[
			val sourceUseCase = id
			includes.map[ targetUseCase |
				dotFactory.createEdge => [
					source = dotmap.get(sourceUseCase)
					target = dotmap.get(targetUseCase)
					attributes.put("style", "dashed")
					attributes.put("arrowhead", "onormal")
				]
			]
		].flatten

		'''Validating overview DOT graph'''.debug
		EmfCommons.basicValidate(dotGraph)

		// TODO: make Dot2DotLang as an OSGi service
		return new Dot2DotLang().transform(dotGraph)
	}
}