package org.foam.cli.launcher.api;

public interface IExecutableTool {
	String getUsage();
	void execute(String[] args);
}
