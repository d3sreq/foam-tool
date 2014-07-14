package org.foam.cli.tools.report

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import com.google.common.io.CharStreams
import java.io.InputStreamReader
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.cli.tools.report.utils.FileUtils
import org.foam.transform.utils.logger.LogServiceExtension
import org.osgi.framework.FrameworkUtil
import org.osgi.service.log.LogService

@Component
class TestResourceLoad implements IExecutableTool {
	
	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	override execute(String[] args) {
		'''Trying to copy files from bundle'''.info
		FileUtils.bundleCopy("report/web", "/home/vlx/tmp/testik");
		
		val is = FrameworkUtil.getBundle(class).getResource("/report/dot/OverviewGraphTemplate.xmi").openStream
		CharStreams.readLines(new InputStreamReader(is)).forEach[println(it)]
	}
	
	override getUsage() '''Testik'''
}