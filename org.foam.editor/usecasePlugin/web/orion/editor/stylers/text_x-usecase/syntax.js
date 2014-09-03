/*eslint-env browser, amd*/
define("orion/editor/stylers/text_x-usecase/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
	];

	var grammars = mLib.grammars;
	grammars.push({
		id: "orion.usecase", //$NON-NLS-0$
		contentTypes: ["text/x-usecase"], //$NON-NLS-0$
		patterns: [
			{
				match: "\\bUC\\d+\\b",
				name: "entity.name.label.usecase"
			},
			{
				match: "^(?:Preceding:|Primary:|Extension:|Variation:)",				
				name: "constant.language.block.usecase"
			},
			// matches:			
			//  - branching condition labels (2a, 4b, ...)
			//  - branching step labels (3a2, 4b3, ...)
			//  - main scenario step labels (1, 2, 3, ...) - represented
			//    by number at the start of the line
			{
				match: "\\b(?:(?:\\d+[a-z])+\\d*)\\b|^\\d+",
				name: "support.other.step.label.usecase"
			},
			{
				match: "#\\(\\w+(?::\\w+)*\\)",				
				name: "keyword.control.annotation.usecase"
			}
			
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
