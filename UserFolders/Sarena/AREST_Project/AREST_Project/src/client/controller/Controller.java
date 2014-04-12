package client.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import client.view.*;
import client.view.abuseReport.*;
import client.view.viewAllReports.*;
import client.view.viewAllUsers.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// The controller class is the Home Screen
public class Controller {

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	
	// AREST Panel's
	private CreateReportGUI createReportGUI;
	//private HomeScreenPanel homeScreenPanel;
	private ViewAllReportsFrame viewAllReportsFrame;
	private ViewAllUsersFrame viewAllUsersFrame;
	private static LogonPanel logonPanel;
	
	
	private Controller controller = this;
	public static boolean loggedIn = false;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
	//		public void run() {
	//			try {
	//				//logonPanel = new LogonPanel();
	//				//logonPanel.showFrame();
	//				Controller window = new Controller();
	//				window.mframe.setVisible(true);
	//			} catch (Exception e) {
	//				e.printStackTrace();
	//			}
	//		}
	//	});
	//}

	/**
	 * Create the application.
	 */
	public Controller() {
		initialize();
	}

	/**
	 * Some components will need to create their own frames, which will set this invisible.
	 * @param visibility
	 */
	/*public void setMainFrameVisibility(boolean visibility){
		mframe.setVisible(visibility);
	}*/
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mframe = new JFrame("Home Screen");
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// The following code kicks going to the create report frame
		JButton createReportButton = new JButton("Create Report");		
		createReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					createReportGUI = new CreateReportGUI();
					
					mframe.setVisible(false);
					createReportGUI.showFrame();
				}
			}
		});
		
		// The following takes us to the view all reports frame
		JButton viewAllReportsButton = new JButton("View All Reports");
		viewAllReportsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					// Pass in reference to the controller to the const
					viewAllReportsFrame = new ViewAllReportsFrame(controller);
					
					// Set the controller frame invisible
					mframe.setVisible(false);
					
					// Show the view all reports frame
					viewAllReportsFrame.showFrame();
				}
			}
		});
		
		// The following takes us to the view all users frame
		JButton viewAllUsersButton = new JButton("View All Users");
		viewAllUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					viewAllUsersFrame = new ViewAllUsersFrame(controller);
					mframe.setVisible(false);
					viewAllUsersFrame.showFrame();
				
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(mframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(viewAllUsersButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(viewAllReportsButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(createReportButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(283, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(createReportButton)
					.addGap(18)
					.addComponent(viewAllReportsButton)
					.addGap(18)
					.addComponent(viewAllUsersButton)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		mframe.getContentPane().setLayout(groupLayout);
		mframe.pack();
	}
	
	public void showFrame() {
		mframe.setVisible(true);
	}
}
