package servlets;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import interfaces.FabricaWebService;

@WebServlet("/altaActividadDeportiva")
public class AltaActividadDeportiva extends HttpServlet {
	private static IActividadDeportivaController iActividad;

	public AltaActividadDeportiva() {
		super();
		iActividad = FabricaWebService.getInstance().getIActDeportivaController();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}
}