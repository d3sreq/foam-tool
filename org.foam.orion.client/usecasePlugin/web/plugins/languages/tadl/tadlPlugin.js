/*eslint-env browser,amd*/
define(['orion/plugin', 'orion/editor/stylers/text_x-tadl/syntax'], function (PluginProvider, mTadl) {

	/**
	 * Plug-in headers
	 */
	var headers = {
		name: "FOAM TADL Support",
		version: "1.0",
		description: "This plugin provides TADL language tools support for Orion."
	};
	var provider = new PluginProvider(headers);

	/**
	 * Register the tadl content type
	 */
	provider.registerServiceProvider("orion.core.contenttype", {}, {
	contentTypes: [
		{
			id: "text/x-tadl",
			name: "tadl",
			extension: ["tadl"],
			"extends": "text/plain"
		}
	]});

	/**
	 * Register syntax styling
	 */
	provider.registerServiceProvider("orion.edit.highlighter", {}, mTadl.grammars[mTadl.grammars.length - 1]);

	provider.connect();
});
