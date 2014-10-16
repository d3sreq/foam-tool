package org.foam.orion.server.proof;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.orion.server.core.OrionConfiguration;
import org.eclipse.orion.server.core.ServerStatus;
import org.eclipse.orion.server.core.metastore.ProjectInfo;
import org.eclipse.orion.server.servlets.OrionServlet;
import org.eclipse.osgi.util.NLS;

public class FoamServlet extends OrionServlet {

	private static final long serialVersionUID = 5416626682163508012L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String pathInfo = request.getPathInfo();
			IPath path = pathInfo == null ? Path.EMPTY : new Path(pathInfo);
			
			if (path.segmentCount() < 3) {
				String message = NLS.bind("Path must have at least 3 segments : {0}", pathInfo);
				ServerStatus status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_FORBIDDEN, message, null);
				handleException(response, status);
				return;
			}
			
			if (!"file".equals(path.segment(0))) {
				String message = NLS.bind("Path must start with \"file\": {0}", pathInfo);
				ServerStatus status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_FORBIDDEN, message, null);
				handleException(response, status);
				return;
			}
			
			// expected path format is 'file/{workspaceId}/{projectName}/{path}]'
			// for example /file/jiri-OrionContent/CoCoME
			String workspaceId = path.segment(1);
			String projectName = path.segment(2);
			
			ProjectInfo project = OrionConfiguration.getMetaStore().readProject(workspaceId, projectName);
			if (project == null) {
				String message = NLS.bind("Project not found: {0}", pathInfo);
				ServerStatus status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_NOT_FOUND, message, null);
				handleException(response, status);
				return;
			}
			
			String absolutePath = project.getProjectStore().toLocalFile(EFS.NONE, null).getAbsolutePath();
			response.getWriter().write("Response from FoamServlet class:\n" + absolutePath);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
}
