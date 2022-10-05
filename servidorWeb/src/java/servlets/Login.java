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

@WebServlet ("/login")
public class Login extends HttpServlet {

	public Login() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response) {
    	
    } 

	protected void doPost(HttpServletRequest request,  HttpServletResponse response) {
        processRequest(request,  response);
	}

}