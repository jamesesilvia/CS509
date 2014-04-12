package client.view;

import javax.swing.JFrame;

public class LogonFrame extends JFrame {
	
	private LogonPanel currentPanel;
	
	public LogonFrame(){		
		currentPanel = new LogonPanel(this);
		setTitle("AREST Logon");		
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
