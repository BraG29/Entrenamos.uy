package servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import interfaces.FabricaWebService;

@WebServlet("/actividades")
public class Actividades extends HttpServlet {

	public Actividades() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {

		} catch (Exception e) {
			request.getRequestDispatcher("/pages/404.jsp").forward(request, response);
			return;
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
