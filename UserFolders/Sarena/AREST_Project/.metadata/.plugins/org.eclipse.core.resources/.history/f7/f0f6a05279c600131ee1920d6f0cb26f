package client.view;

import javax.swing.JFrame;

import client.model.UserContainer;

public class CreateUserFrame extends JFrame {
	
	private CreateUserPanel currentPanel;
	
	public CreateUserFrame(UserContainer _currentUser){		
		currentPanel = new CreateUserPanel(_currentUser);
		setTitle("Create New User Account");
		
		setupFrame();
	}
	
	private void setupFrame(){
		setResizable(false);
		this.setContentPane(currentPanel);
		
	}
	
	public void start(){
		this.setSize(400,350);
		this.setVisible(true);
	}

}