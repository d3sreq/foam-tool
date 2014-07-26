package org.foam.cli.launcher

import aQute.bnd.annotation.component.Activate
import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.foam.cli.launcher.api.IExecutableTool
import org.foam.transform.utils.logger.LogServiceExtension
import org.osgi.framework.BundleContext
import org.osgi.service.log.LogService

@Component(
	immediate = true,
	provide = LauncherComponent,
	properties = #[
		"osgi.command.scope:String=foam",
		"osgi.command.function:String=run"
	]
)
class LauncherComponent {

	private extension LogServiceExtension logServiceExtension
	@Reference def void setLogService(LogService logService) {
		logServiceExtension = new LogServiceExtension(logService)
	}

	var String[] args
	
	@Reference(target="(launcher.arguments=*)")
	def void setArgs(Object object, Map<String, Object> map) {
		args = map.get("launcher.arguments") as String[]
	}
	
	/**
	 * The activator is used when the user specifies command line arguments.
	 */
	@Activate def void activate(BundleContext context) {
		if(!args.empty) {
			print("ARGS: ")
			println(args.map['''"«it»"'''].join(", "))
			run(args)
			println("done.")
			context.getBundle(0).stop
		}
	}
	
	// we use a dynamic+optional+multiple reference and therefore multiple threads can access the toolMap
	val toolMap = new ConcurrentHashMap<String, IExecutableTool>

	@Reference(multiple=true, optional=true, dynamic=true)
	def void addTool(IExecutableTool tool) {
		val toolName = tool.class.simpleName
		val previousItem = toolMap.putIfAbsent(toolName, tool)
		if(previousItem != null) {
			'''The tool '«toolName»' has already been registered.'''.debug
		}
	}
	
	def void removeTool(IExecutableTool tool) {
		val toolName = tool.class.simpleName
		toolMap.remove(toolName)
	}
	
	def private showtools() '''
		Available tools are:
		 «FOR toolName:toolMap.keySet»
		 - «toolName»
		 «ENDFOR»
	'''
	
	// GOGO COMMAND
	def void run(String[] args) {
		
		if(args.empty) {
			println("No tool specified")
			println(showtools)
			return
		}
		
		val toolName = args.get(0)
		val toolArgs = args.tail
		val toolInstance = toolMap.get(toolName)
		
		if(toolInstance == null) {
			println('''Unknown tool specified: «toolName»''')
			println(showtools)
			return
		}
		toolInstance.execute(toolArgs)
	}
}
