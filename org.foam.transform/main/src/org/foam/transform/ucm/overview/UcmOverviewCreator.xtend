package org.foam.transform.ucm.overview

import aQute.bnd.annotation.component.Component
import org.eclipse.xtend.lib.annotations.Data
import org.foam.ucm.UseCaseModel

import static extension org.foam.ucm.util.UcmUtils.*

@Data
class UseCaseNode {
	String id
	String name
	Iterable<String> includes
	Iterable<String> precedes
}

@Component(provide = UcmOverviewCreator)
class UcmOverviewCreator {
	def transform(UseCaseModel ucm) {
		ucm.useCases.map[
			new UseCaseNode(id, name, included.map[id], preceeded.map[id])
		].toMap[id]
	}
}