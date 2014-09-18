package org.foam.transform.utils.logger

import org.osgi.service.log.LogService

/**
 * Simplifies logging using the standard OSGi LogService.
 * This way, logged messages will contain reference to the source bundle.
 */
class LogServiceExtension {
	
	org.eclipse.xtext.xbase.lib.Exceptions e
	
	private LogService logService
	new(LogService logService) {
		this.logService = logService
	}
	
	def void info(CharSequence message) {
		logService?.log(LogService.LOG_INFO, message.toString)
	}
	def void error(CharSequence message) {
		logService?.log(LogService.LOG_ERROR, message.toString)
	}

	def void debug(CharSequence message) {
		logService?.log(LogService.LOG_DEBUG, message.toString)
	}
	def void warning(CharSequence message) {
		logService?.log(LogService.LOG_WARNING, message.toString)
	}
}