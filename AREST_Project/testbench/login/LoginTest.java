/**
 * 
 */
package login;

import static org.junit.Assert.*;

import org.junit.Test;

import client.AREST_client;
import client.controller.Controller;
import client.controller.LogonController;
import client.view.LogonPanel;

/**
 * Tests the login for AREST.
 * 
 * @author Matt Orsini
 *
 */
public class LoginTest {

	private static final String USERNAME_PASSWORD = "tester";
	private AREST_client client;
	private LogonPanel   logonPanel;
	private LogonController ctrl;
	
	@Test
	public void test() {
		client.main(null);
		
		// Get the logon panel to try to enter some text and connect to the server.
		logonPanel = client.getMainFrame().getCurrentPanel();
		logonPanel.getUserNameField().setText(USERNAME_PASSWORD);
		logonPanel.getPasswordField().setText(USERNAME_PASSWORD);
		
		logonPanel.getBtnSubmit().doClick();
		
	}

}
