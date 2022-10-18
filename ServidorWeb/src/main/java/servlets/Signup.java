package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/signup")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter salida = response.getWriter();
//		
//		salida.println("<html><body>");
//		salida.println("<h1 style ='text-align:center'>Prueba servlet</h1>");
//		salida.print("<br><br><br>");
//		salida.println("La fecha actual es: "+ new Date());
//		salida.println("</body></html>");
		
		
		//processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		Part filePart = request.getPart("imagenInput");
		String nombreImg = filePart.getSubmittedFileName();
		for(Part p : request.getParts()) {
			p.write("/home/progappvm/Desktop/imagenes/"+ nombreImg);
		}
		salida.println("<html><body>");
		salida.println("<h1 style ='text-align:center'>Prueba Alta Usuario</h1>");
		salida.print("<br><br><br>");
		salida.println("Nickname: "+ request.getParameter("nicknameInput"));
		salida.print("<br>");
		salida.println("Email: "+ request.getParameter("emailInput"));
		salida.print("<br>");
		salida.println("Nombre: "+ request.getParameter("nombreInput"));
		salida.print("<br>");
		salida.println("Apellido: "+ request.getParameter("apellidoInput"));
		salida.print("<br>");
		salida.println("Contraseña: "+ request.getParameter("passwordInput"));
		salida.print("<br>");
		salida.println("Fecha: "+ request.getParameter("fechaInput"));
		salida.print("<br>");
		
		salida.println("</body></html>");
		
		
//		processRequest(request, response);
	}
}
