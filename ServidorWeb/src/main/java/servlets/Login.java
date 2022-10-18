package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.resource.beans.internal.FallbackBeanInstanceProducer;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String nombreDeUsuario = request.getParameter("loginUserMailInput");
		String contraseña = request.getParameter("loginUserPasswordInput");
		
		try {
			DtUsuarioExt usr = FallbackBeanInstanceProducer.buscarUsuario(nombreDeUsuario);
			if (!usr.getContrasenia().equals(contraseña)) {
			}
			
			else{				
				request.getSession().setAttribute("loggedUser", usr);
				if (usr instanceof DtProfesorExt)
				{
					request.getSession().setAttribute("loggedUser", null);
				}
				
				else {
					if (request.getParameter("loginCheckboxRecordad") != null && request.getParameter("loginCheckboxRecordad").equals("true")) {
						Cookie galleta = new Cookie("nomeolvides", usr.getNickname());
						galleta.setPath(request.getContextPath());
						galleta.setComment("Esta galleta te permite ingresar de forma directa.");
						galleta.setMaxAge(1000);
						response.addCookie(galleta);
					}
					response.sendRedirect(request.getContextPath() + "/home");
					return;
				}
			}
		} catch (Exception ex) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}