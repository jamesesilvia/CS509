package client.view;

import javax.swing.JFrame;

public class DeleteUserFrame extends JFrame {
	
	private DeleteUserPanel currentPanel;
	
	public DeleteUserFrame(){		
		currentPanel = new DeleteUserPanel();
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