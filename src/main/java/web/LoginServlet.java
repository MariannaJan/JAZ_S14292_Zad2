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
  		
  		
  		
  		
  		LoginApplicationRepository repo = new DummyLoginApplication();
  		//HttpSession session = request.getSession();
  		  		
  		if (repo.getSize()>0){
  			
  			repo.login(request, response);			
  			
  		}
  		else
			response.sendRedirect("reg.jsp");
  					
	}

	
}
