package domain;

public class LoginApplication {

	String username;
	String email;
	String password;
	Boolean premium;
	Boolean admin;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	
	public Boolean getPremium(){
		return premium;
	}
	
	public void setPremium(Boolean premium){
		this.premium=premium;
	}
	
	public Boolean getAdmin(){
		return admin;
	}
	
	public void setAdmin(Boolean admin){
		this.admin=admin;
	}
}
