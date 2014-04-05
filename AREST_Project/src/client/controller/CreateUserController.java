package client.controller;
import java.io.IOException;

import javax.swing.JOptionPane;

import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import client.abuse_report.models.UserContainer;

public class CreateUserController{
	public UserContainer user = new UserContainer();
	ObjectMapper mapper = new ObjectMapper();
	Resty u = new Resty();
	
	public void createUser(String firstName, String lastName, String username, 
			String password, String email, boolean supervisor) throws JsonGenerationException, JsonMappingException, IOException{
		user.id = null;
		user.firstName = firstName;
		user.lastName = lastName;
		user.userName = username;
		user.password = password;
		user.email = email;
		user.isSupervisor = supervisor;
		// Use random generator for this value
		user.salt = 1;
		//Map Java Object to json value
		String json = mapper.writeValueAsString(user);
		System.out.println(json);
		//POST to Server
		//Object response = u.json("http://cs509-arest.herokuapp.com/user/create");
		u.alwaysSend("Content-Type", "application/json");
		Object response = u.json("http://cs509-arest.herokuapp.com/user/create", content(json));
		
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
	
	public boolean checkPasswords(String pw_1, String pw_2) {
		if (pw_1.equals(pw_2) == true) {
			System.out.println("Passwords equal");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Passwords must be the same.", "Password Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}

}
