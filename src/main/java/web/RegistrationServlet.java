package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;
import repositories.DummyLoginApplication;
import repositories.LoginApplicationRepository;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginApplicationRepository repo= new DummyLoginApplication();
		LoginApplication application = retreiveDetailsFromRequest(request);
		repo.register(session,application.getUsername(),response);		
	}

	private LoginApplication retreiveDetailsFromRequest(HttpServletRequest request){
		LoginApplication result = new LoginApplication();
		result.setUsername(request.getParameter("username"));
		result.setPassword(request.getParameter("password"));
		result.setEmail(request.getParameter("email"));
		return result;
	}

}
