package org.foam.cli.tools.report

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.cli.tools.report.utils.FileUtils
import org.osgi.service.log.LogService
import java.net.URL
import java.nio.file.Files
import java.io.BufferedReader
import java.io.InputStreamReader
import org.osgi.framework.FrameworkUtil
import java.util.Collections
import com.google.common.collect.Lists

@Component
class TestResourceLoad implements IExecutableTool {
	
	private LogService logService
	@Reference def void setLogService(LogService logService) {
		this.logService = logService
	}

	def info(CharSequence message) {
		logService.log(LogService.LOG_INFO, message.toString)
	}
	
	override execute(String[] args) {
		'''Trying to copy files from bundle'''.info
		FileUtils.bundleCopy("report/web", "/home/vlx/tmp/testik");
		
		val is = FrameworkUtil.getBundle(class).getResource("/report/dot/OverviewGraphTemplate.xmi").openStream
		val reader = new BufferedReader(new InputStreamReader(is))
		reader.lines.forEach[println(it)]
	}
	
	override getUsage() '''Testik'''
}