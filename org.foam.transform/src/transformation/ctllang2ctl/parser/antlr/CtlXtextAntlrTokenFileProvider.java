/*
* generated by Xtext
*/
package transformation.ctllang2ctl.parser.antlr;

import java.io.InputStream;

import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class CtlXtextAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("transformation/ctllang2ctl/parser/antlr/internal/InternalCtlXtext.tokens");
	}
}
