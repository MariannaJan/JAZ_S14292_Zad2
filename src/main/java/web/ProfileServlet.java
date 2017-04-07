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


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginApplicationRepository repo;
	
	public void init(ServletConfig config){
		repo= new DummyLoginApplication();
	}
       
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		String profileUser = repo.getApplicationByUsername((String) session.getAttribute("username")).getUsername();
		String profilePass = repo.getApplicationByUsername((String) session.getAttribute("username")).getPassword();
		String profileEmail = repo.getApplicationByUsername((String) session.getAttribute("username")).getEmail();
		
		
		response.setContentType("text/html");
		response.getWriter().println("<h1>Profile page of:  "+profileUser+"</h1></br>");
		response.getWriter().println("Password:  "+profilePass+"</br>");
		response.getWriter().println("Password:  "+profileEmail+"</br>");
	}

	
	}


