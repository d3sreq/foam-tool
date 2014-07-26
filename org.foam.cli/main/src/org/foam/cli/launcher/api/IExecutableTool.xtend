package org.foam.cli.launcher.api

public interface IExecutableTool {
	def String getUsage()
	def void execute(String[] args)
}
