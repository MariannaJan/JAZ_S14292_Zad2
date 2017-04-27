package repositories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;

public class DummyLoginApplication implements LoginApplicationRepository {

	private static List<LoginApplication> db = new ArrayList<LoginApplication>();
	
	@Override
	public void register(HttpSession session, String registeringUser, HttpServletResponse response) throws IOException {
		
		
		for(LoginApplication application: db){	
    	if(!(registeringUser.equals("")) && (db.indexOf(registeringUser)==-1)){
    		db.add(application);
    		response.sendRedirect("login.jsp");
    	   	}
    	else if(registeringUser.equals(""))response.sendRedirect("reg.jsp");
    	
    	else {
    		response.sendRedirect("login.jsp");
    	}
		}
	}
	
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		
  		for (LoginApplication la:db){
  			if(username.equals(la.getUsername())&& password.equals(la.getPassword())){
  				response.sendRedirect("profil");
  			}
  		}
  		
	}

	@Override
	public LoginApplication getApplicationByUsername(String username) {
		for(LoginApplication application: db){
			if(application.getUsername().equalsIgnoreCase(username))
				return application;
		}
		return null;
	}

	@Override
	public int getSize() {
		return db.size();
	}


	
	public String profilePage() {
		String profileText="";
		if (!db.isEmpty()){
			profileText+= "<tr>"
					+ "<td>Login</td>"
					+ "<td>Password</td>"
					+ "<td>E-mail</td>"
					+ "<td>Premium</td>"
					+ "<td>Admin</td>"
					+ "</tr>";
		  for (LoginApplication la: db) {
			  profileText+= "<tr>"
						+ "<td>la"
						+ "<td>"+la.getUsername()+"</td>"
						+ "<td>"+la.getPassword()+"</td>"
						+ "<td>"+la.getEmail()+"</td>"
						+ "<td>"+la.getPremium()+"</td>"
						+ "<td>"+la.getAdmin()+"</td>"
						+ "</tr>";
		  }
		  profileText+= "/table";
		}
		return profileText;
	}

	
}
