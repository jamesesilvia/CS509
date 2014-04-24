package client.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import us.monoid.web.AbstractResource;
import us.monoid.web.Resty;
import static us.monoid.web.Resty.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import common.Sha1Conversion;
import client.model.UserContainer;

public class ChangePasswordController {
	UserContainer currentUser;
	String json, hashedPassword;
	ObjectMapper mapper = new ObjectMapper();
	Resty sendLogon = new Resty();
	AbstractResource changePasswordResponse;
	private Sha1Conversion hashPassword = new Sha1Conversion();
	
	public void changePassword( UserContainer user) throws IOException, NoSuchAlgorithmException{
		currentUser = user;
		
		//Hash Password
		hashedPassword = hashPassword.makeSHA1Hash(user.password);
		user.password = hashedPassword;		
		//Map java object to json object
		json = mapper.writeValueAsString(user);
		//Check Passwords
		sendLogon.alwaysSend("Content-Type", "application/json");
		changePasswordResponse = sendLogon.json("http://cs509-arest.herokuapp.com/user/edit", content(json));
		try{
			changePasswordResponse = sendLogon.json("http://cs509-arest.herokuapp.com/user/edit", content(json));
			//If the change password was successful
			if ( changePasswordResponse.status(200) == true ){
				JOptionPane.showMessageDialog(null, "Changed Password!",
						"Success!", JOptionPane.INFORMATION_MESSAGE);			
			}
			else{
				//Something went wrong with server
				//Not sure what to do here, maybe exit
				System.out.println("Something went wrong");
			}
			goBackHome();
		} catch( IOException e1 ){
			JOptionPane.showMessageDialog(null, "Something went wrong.\n"
					+ "Please try again.", "Change Password Error!", JOptionPane.ERROR_MESSAGE);
			goBackHome();
			
		}
	}
	
	public boolean checkPasswords(String pw_1, String pw_2) {
		if (pw_1.equals(pw_2) == true) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "Passwords must be the same, try again.", "Password Error!", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	
	public void goBackHome()
	{
		Controller homeScreen = new Controller(currentUser);
		homeScreen.showFrame();
	}

}
