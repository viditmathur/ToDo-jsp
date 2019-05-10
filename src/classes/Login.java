package classes;

public class Login {
public Login(String username, String password) {
		super();
		this.username = username;
		Password = password;
	}
public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
String username;
String Password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
}
