package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectactividaddeportiva")
public class SelectActividadDeportiva extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectActividadDeportiva() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		} catch (Exception e) {
			response.sendRedirect("./../webapp/pages/500.jsp");
			return;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
