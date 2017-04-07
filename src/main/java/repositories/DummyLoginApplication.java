package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.LoginApplication;

public class DummyLoginApplication implements LoginApplicationRepository {

	private static List<LoginApplication> db = new ArrayList<LoginApplication>();
	
	@Override
	public void register(LoginApplication application) {
		db.add(application);

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
	@Override
	public boolean ifUserExists(String username){
		int usernameExists = db.indexOf(username);
		if (usernameExists !=-1){return true;}
		else return false;
	}

	
	
	

}
