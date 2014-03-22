package client.controller;

public class LogonController {
	
	public void login(String username, char[] password){
		System.out.println("Username: " + username);
		System.out.println("Password: " + new String(password));		
	}

}
