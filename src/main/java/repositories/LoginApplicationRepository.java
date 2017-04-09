package repositories;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginApplication;

public interface LoginApplicationRepository {

	LoginApplication getApplicationByUsername (String username);
	
	int getSize();
	
	
	void login(HttpServletRequest request, HttpServletResponse response) throws IOException;

	void register(HttpSession session, String registeringUser, HttpServletResponse response) throws IOException;
	
	
}
