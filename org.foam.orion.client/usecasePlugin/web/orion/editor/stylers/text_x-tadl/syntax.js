/*eslint-env browser, amd*/
define("orion/editor/stylers/text_x-tadl/syntax", ["orion/editor/stylers/lib/syntax"], function(mLib) { //$NON-NLS-1$ //$NON-NLS-0$
	var keywords = [
		"U", "R", "S", "T",  // LTL
		"G", "F", "X", "H", "O", // LTL
		"AG", "AF", "AX", "EG", "EF", "EX", // CTL
		"A", "E", "U" // CTL
	];

	var grammars = mLib.grammars;
	grammars.push({
		id: "orion.tadl", //$NON-NLS-0$
		contentTypes: ["text/x-tadl"], //$NON-NLS-0$
		patterns: [
			{
				match: "^##.*$",				
				name: "comment.line.hash-hash.tadl"
			},
			{
				match: "^(?:CTL|LTL)\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "support.function.type" //$NON-NLS-0$
			},
			{
				match: "\\b(?:" + keywords.join("|") + ")\\b", //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-0$
				name: "keyword.control.tadl" //$NON-NLS-0$
			}
		]
	});
	return {
		id: grammars[grammars.length - 1].id,
		grammars: grammars,
		keywords: keywords
	};
});
