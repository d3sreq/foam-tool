package org.foam.orion.server

import aQute.bnd.annotation.component.Component
import aQute.bnd.annotation.component.Reference
import javax.servlet.Servlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Path
import org.eclipse.orion.server.core.OrionConfiguration
import org.eclipse.orion.server.core.ServerStatus
import org.eclipse.orion.server.servlets.OrionServlet
import org.eclipse.osgi.util.NLS
import org.foam.cli.tools.report.ReportApplication
import org.json.JSONObject

@Component(provide=Servlet, properties=#["alias=/foam"])
public class FoamServlet extends OrionServlet {

//	private ReportApplication reportApplication
//	@Reference def void setReportApplication(ReportApplication reportApplication) {
//		this.reportApplication = reportApplication
//	}

	override doGet(HttpServletRequest req, HttpServletResponse resp) {
		val pathInfo = req.pathInfo
		val Path path = if (pathInfo == null) Path.EMPTY else new Path(pathInfo)
		
		if (path.segmentCount < 3) {
			val message = NLS.bind("Path must have at least 3 segments : {0}", pathInfo)
			val status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_FORBIDDEN, message, null)
			this.handleException(resp, status)
			return
		}
		
		if (path.segment(0) != "file") {
			val message = NLS.bind("Path must start with \"file\": {0}", pathInfo)
			val status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_FORBIDDEN, message, null)
			handleException(resp, status)
			return
		}
		
		// expected path format is 'file/{workspaceId}/{projectName}/{path}]'
		// for example /file/jiri-OrionContent/CoCoME
		val workspaceId = path.segment(1)
		val projectName = path.segment(2)
		
		val project = OrionConfiguration.metaStore.readProject(workspaceId, projectName)
		if (project == null) {
			val message = NLS.bind("Project not found: {0}", pathInfo)
			val status = new ServerStatus(IStatus.ERROR, HttpServletResponse.SC_NOT_FOUND, message, null)
			handleException(resp, status)
			return
		}
		
		System.out.println(">> returning result");
		
		val result = new JSONObject().put("JSON", "Hello, World!")
		
		// TODO - is this safe ?
		resp.setHeader("Access-Control-Allow-Origin", "*")
		
//			String absolutePath = project.getProjectStore().toLocalFile(EFS.NONE, null).getAbsolutePath();
//			response.getWriter().write("Response from FoamServlet class:\n" + absolutePath);
		OrionServlet.writeJSONResponse(req, resp, result)
		
		//		Thread.sleep(2000);
//		resp.writer.append("Current thread: " + Thread.currentThread.id);

		// run verification
		// TODO - refactor cli
	}

}
