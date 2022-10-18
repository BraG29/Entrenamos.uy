package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {
		super();
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.getSession().setAttribute("loggedUser", null);
		if (request.getCookies() != null) {
			Cookie[] cookies = request.getCookies();
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				if (cookies[i].getName().equals("cookieNameWithUser")) {
					cookies[i].setValue("");
					cookies[i].setPath(request.getContextPath());
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		} else {
			response.sendRedirect("/home");

		}
		response.sendRedirect("/home");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}