package client;

import client.view.*;


public class AREST_client {
	
	private static LogonFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new LogonFrame();
		mainFrame.start();
	}

	/**
	 * @return the mainFrame
	 */
	public static LogonFrame getMainFrame() {
		return mainFrame;
	}

}
