package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import interfaces.FabricaWebService;
//import logica.datatypes.DtCuponera;

@WebServlet("/cuponeras")
public class Cuponeras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cuponeras() {
    	super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("pages/403.jsp");
    }
    
	protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,  response);
	}

	/*private DtCuponera buscarCuponera(String pNombre) throws ServletException, IOException {
		DtCuponera dtCuponera = FabricaWebService.getInstance().getICuponeraController().seleccionarCuponera(pNombre);
		return dtCuponera;
	}*/
}
