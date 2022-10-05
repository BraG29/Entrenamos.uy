package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.InterfaceConstructor;
import interfaces.FabricaWebService;

@WebServlet("/home")
public class Home extends HttpServlet {
	private IUsuarioController iUsuarioController = FabricaWebService.getInstance().getIUsuarioController();

	public Home() {
		super();
		InterfaceConstructor.getInstance();
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}
}
