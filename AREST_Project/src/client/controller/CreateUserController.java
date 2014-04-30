package client.controller;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import client.model.UserContainer;
import common.Sha1Conversion;

public class CreateUserController{
	public UserContainer user = new UserContainer();
	ObjectMapper mapper = new ObjectMapper();
	Resty sendCreate = new Resty();
	JSONResource sendCreateResponse;
	private Sha1Conversion hashPassword = new Sha1Conversion();
	String hashedPassword;
	
	
	public void createUser(String firstName, String lastName, String username, 
			String password, String email, boolean supervisor, UserContainer _currentUser) throws JsonGenerationException, JsonMappingException, IOException, NoSuchAlgorithmException{
		user.id = null;
		user.firstLogon = true;
		user.firstName = firstName;
		user.lastName = lastName;
		user.userName = username;
		//Hash Password
		hashedPassword = hashPassword.makeSHA1Hash(password);
		user.password = hashedPassword;
		user.email = email;
		user.isSupervisor = supervisor;
		// Use random generator for this value
		user.salt = 1;
		//Map Java Object to json value
		String json = mapper.writeValueAsString(user);
		//POST to Server
		sendCreate.alwaysSend("Content-Type", "application/json");
		sendCreateResponse = sendCreate.json("http://cs509-arest.herokuapp.com/user/create", content(json));
		if (sendCreateResponse.status(200) == true){
			//Successfully created the user!
			System.out.println("Created user!");
			
			Controller homeScreen = new Controller(_currentUser);
			homeScreen.showFrame();
		}
		else{
			JOptionPane.showMessageDialog(null, "Unable to create user!", "Error!", JOptionPane.ERROR_MESSAGE);
			//Where to go from here?
			//Home Screen, or try again? Make option pane a yes/no
			Controller homeScreen = new Controller(_currentUser);
			homeScreen.showFrame();
		}
		
	}
	
	public boolean checkPasswords(String pw_1, String pw_2) {
		if (pw_1.equals(pw_2) == true) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Passwords must be the same.", "Password Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}

}
