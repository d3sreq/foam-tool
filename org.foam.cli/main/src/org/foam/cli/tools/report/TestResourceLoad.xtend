package org.foam.cli.tools.report

import aQute.bnd.annotation.component.Component
import com.google.common.io.CharStreams
import java.io.InputStreamReader
import org.apache.log4j.Logger
import org.foam.bootstrap.FileUtils
import org.foam.cli.launcher.api.IExecutableTool
import org.osgi.framework.FrameworkUtil

@Component
class TestResourceLoad implements IExecutableTool {
	
	static extension Logger = Logger.getLogger(TestResourceLoad)

	override execute(String[] args) {
		'''Trying to copy files from bundle'''.info
		FileUtils.bundleCopy(TestResourceLoad, "report/web", "/home/vlx/tmp/testik");
		
		val is = FrameworkUtil.getBundle(class).getResource("/report/dot/OverviewGraphTemplate.xmi").openStream
		CharStreams.readLines(new InputStreamReader(is)).forEach[println(it)]
	}
	
	override getUsage() '''Testik'''
}