package client.view;

import javax.swing.JFrame;

public class CreateUserFrame extends JFrame {
	
	private CreateUserPanel currentPanel;
	
	public CreateUserFrame(){		
		currentPanel = new CreateUserPanel();
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