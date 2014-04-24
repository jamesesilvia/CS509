package client.view;

import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import us.monoid.json.JSONException;
import client.controller.LogonController;
import client.model.UserContainer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LogonPanel extends JPanel {
	private UserContainer user;
	private JTextField userNameField;	
	private JLabel lblUsername;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnSubmit;
	private LogonController controller;
	
	
	public LogonPanel(final JFrame mainFrame) {
		user = new UserContainer();
		//Username
		lblUsername = new JLabel("Username:");
		userNameField = new JTextField();
		
		//Password
		lblPassword = new JLabel("Password:");
		passwordField = new JPasswordField();		
		
		//Submit button
		btnSubmit = new JButton("Logon");
		//Button Handle
		controller = new LogonController();
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					user.userName = userNameField.getText();
					user.password = new String (passwordField.getPassword());
					mainFrame.dispose();
					controller.login(user);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//Panel setup
		setupPanel();
		
	}
	
	private void setupPanel(){
		//setBackground(SystemColor.textHighlight);
		setLayout(null);
		
		//Username Label
		lblUsername.setBounds(30, 36, 72, 16);
		lblUsername.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblUsername);
		//Username		
		userNameField.setBounds(107, 30, 149, 28);
		userNameField.setColumns(10);
		userNameField.setText("Enter Username");
		this.add(userNameField);		
		
		//Password Label
		lblPassword.setBounds(30, 69, 72, 16);
		lblPassword.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		this.add(lblPassword);
		//Password		
		passwordField.setBounds(107, 63, 149, 28);
		this.add(passwordField);
		
		//Button		
		btnSubmit.setBounds(107, 114, 88, 29);
		this.add(btnSubmit);				
	}

	/**
	 * @return the userNameField
	 */
	public JTextField getUserNameField() {
		return userNameField;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * @return the btnSubmit
	 */
	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	/**
	 * @return the controller
	 */
	public LogonController getController() {
		return controller;
	}
	
}
