package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repositories.DummyLoginApplication;
import repositories.LoginApplicationRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		
  		DummyLoginApplication repo = new DummyLoginApplication();
  		  		
  		if (repo.getSize()>0){
  			
  			if (password.equals((repo.getApplicationByUsername(username)).getPassword())){
  				
  				HttpSession session = request.getSession();
  	  	  		
  	  	  		session.setAttribute("username", username);
  	  	  		session.setAttribute("password", password);
  	  	  		
  	  	  	response.sendRedirect("profile");
  	  	  		
  			}
  			else response.sendRedirect("login.jsp");			
  			
  		}
  		else
				response.sendRedirect("reg.jsp");
  					
	}

	
}
