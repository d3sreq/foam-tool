/*eslint-env browser,amd*/
define(['orion/plugin', 'orion/editor/stylers/text_x-usecase/syntax'], function (PluginProvider, mUseCase) {

	/**
	 * Plug-in headers
	 */
	var headers = {
		name: "FOAM Use-Case Support",
		version: "1.0",
		description: "This plugin provides use-case language tools support for Orion."
	};
	var provider = new PluginProvider(headers);

	/**
	 * Register the use case content type
	 */
	provider.registerServiceProvider("orion.core.contenttype", {}, {
	contentTypes: [
		{
			id: "text/x-usecase",
			name: "usecase",
			extension: ["uc"],
			"extends": "text/plain"
		}
	]});

	/**
	 * Register syntax styling
	 */
	provider.registerServiceProvider("orion.edit.highlighter", {}, mUseCase.grammars[mUseCase.grammars.length - 1]);

	provider.connect();
});
