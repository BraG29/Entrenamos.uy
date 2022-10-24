package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUtil;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.jpa.HibernatePersistenceProvider;

import logica.controlador.Fabrica;
import logica.controlador.IControlador;
import logica.datatypes.DtUsrKey;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String nombreDeUsuario = request.getParameter("loginUserMailInput");
//		String contraseña = request.getParameter("loginUserPasswordInput");
//		
//		try {
//			DtUsuarioExt usr = FallbackBeanInstanceProducer.buscarUsuario(nombreDeUsuario);
//			if (!usr.getContrasenia().equals(contraseña)) {
//			}
//			
//			else{				
//				request.getSession().setAttribute("loggedUser", usr);
//				if (usr instanceof DtProfesorExt)
//				{
//					request.getSession().setAttribute("loggedUser", null);
//				}
//				
//				else {
//					if (request.getParameter("loginCheckboxRecordad") != null && request.getParameter("loginCheckboxRecordad").equals("true")) {
//						Cookie galleta = new Cookie("nomeolvides", usr.getNickname());
//						galleta.setPath(request.getContextPath());
//						galleta.setComment("Esta galleta te permite ingresar de forma directa.");
//						galleta.setMaxAge(1000);
//						response.addCookie(galleta);
//					}
//					response.sendRedirect(request.getContextPath() + "/home");
//					return;
//				}
//			}
//		} catch (Exception ex) {
//			response.sendRedirect(request.getContextPath() + "/login");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("PeristenceApp");
		Fabrica fabrica = new Fabrica();
		IControlador sistema = fabrica.getInterface();
		PrintWriter salida = response.getWriter();
		salida.println("<html><body>");
		try {
			sistema.initConnection();
			HttpSession session = request.getSession();
			String credencial = request.getParameter("credencialInput");
			DtUsrKey usrKey = sistema.consultaUsuario(credencial);
			if(usrKey != null) {
				salida.println("<h1 style ='text-align:center'>Funca</h1>");
				salida.println("<br><br>");
				salida.println("Nick de suario en sesion: " + usrKey.nickname);
				salida.println("<br>");
				salida.println("Email de suario en sesion: " + usrKey.email);
				salida.println("</body></html>");
				
			}
			else {
				salida.println("<html><body>");
				salida.println("<h1 style ='text-align:center'>No se encontro al usuario</h1>");
			}
			
		} catch (PersistenceException e) {
			salida.println("<h1 style ='text-align:center'>No anda el hdrp persistence</h1>");
			salida.println("<br><br>");
			salida.println("Error: " + e.getMessage());
		}
		salida.println("</body></html>");
		
		
		
		
	}
}