package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.FabricaWebService;
import interfaces.IActividadDeportivaController;

@WebServlet("/altaActividadDeportiva")
public class AltaActividadDeportiva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IActividadDeportivaController iActividad;

	public AltaActividadDeportiva() {
		super();
		iActividad = FabricaWebService.getInstance().getIActDeportivaController();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}