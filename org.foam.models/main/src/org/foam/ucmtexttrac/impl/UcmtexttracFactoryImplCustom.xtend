package org.foam.ucmtexttrac.impl

import org.foam.ucmtexttrac.impl.UcmtexttracFactoryImpl
import org.foam.tracemap.TracemapFactory

class UcmtexttracFactoryImplCustom extends UcmtexttracFactoryImpl {
	
	val traceMapFac = TracemapFactory.eINSTANCE
	
	override createUcmToUcmtextTrace() {
		super.createUcmToUcmtextTrace => [
			annotations = traceMapFac.createTraceMap
			branchingConditions = traceMapFac.createTraceMap
			names = traceMapFac.createTraceMap
			precedenceDef = traceMapFac.createTraceMap
			primaryDef = traceMapFac.createTraceMap
			steps = traceMapFac.createTraceMap
		]		
	}
	
}