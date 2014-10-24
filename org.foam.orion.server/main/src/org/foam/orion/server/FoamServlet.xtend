package org.foam.orion.server

import aQute.bnd.annotation.component.Component
import javax.servlet.Servlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component(provide=Servlet, properties=#["alias=/"])
public class FoamServlet extends HttpServlet {

	override doGet(HttpServletRequest req, HttpServletResponse resp) {
		resp.writer.append("Hello World!")
	}

}
