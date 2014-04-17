package client.view;

import javax.swing.JFrame;

import client.model.UserContainer;

public class DeleteUserFrame extends JFrame {
	
	private DeleteUserPanel currentPanel;
	
	public DeleteUserFrame(UserContainer _currentUser){		
		currentPanel = new DeleteUserPanel(_currentUser);
		setTitle("Delete User");
		
		setupFrame();
	}
	
	private void setupFrame(){
		setResizable(false);
		this.setContentPane(currentPanel);
		
	}
	
	public void start(){
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}