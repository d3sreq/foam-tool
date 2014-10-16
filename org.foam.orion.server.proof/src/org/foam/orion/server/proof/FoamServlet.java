package org.foam.orion.server.proof;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.orion.server.servlets.OrionServlet;

@SuppressWarnings("serial")
public class FoamServlet extends OrionServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String pathInfo = req.getPathInfo();
			IPath path = pathInfo == null ? Path.ROOT : new Path(pathInfo);
//			
			System.out.println(path);
			
//			IFileStore file = NewFileServlet.getFileStore(req, path);
//			
//			// skipping symlink testing
//			
//			IFileInfo fileInfo = file.fetchInfo(EFS.NONE, null);
////			file.delete(options, monitor);
//			
//			String dir = fileInfo.toString();
//			System.out.println(dir);
//			
////			ProcessBuilder builder = new ProcessBuilder("ls", "-l", );
////			builder.redirectErrorStream(true);
////			Process process = builder.start();
////
////			InputStreamReader reader = new InputStreamReader(process.getInputStream());
////			String result = CharStreams.toString(reader);							
////			process.destroy();
//			
			String result = "TODO";
			
			response.getWriter().write("Response from FoamServlet class:\n" + result);
			///
//		} catch (IOException e) {
//			// should not occur
//			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
