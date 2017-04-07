package repositories;

import domain.LoginApplication;

public interface LoginApplicationRepository {

	void register (LoginApplication application);
	LoginApplication getApplicationByUsername (String username);
	int getSize();
	
	boolean ifUserExists(String username);
	
}
