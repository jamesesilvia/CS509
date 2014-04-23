package client.controller;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;

import client.model.UserContainer;
import client.view.*;
import client.view.abuseReport.*;
import client.view.viewAllReports.*;
import client.view.viewAllUsers.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import us.monoid.json.JSONException;


// The controller class is the Home Screen
public class Controller {

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	
	// AREST Panel's
	private CreateReportGUI createReportGUI;
	private ViewReportGUI viewReportGUI;
	private ViewAllReportsFrame viewAllReportsFrame;
	private ViewAllUsersFrame viewAllUsersFrame;
	private CreateUserFrame createUserFrame;
	private DeleteUserFrame deleteUserFrame;
	private ChangePasswordFrame changePasswordFrame;
	
	
	
	private Controller controller = this;
	public static UserContainer currentUser;

	/**
	 * Create the application.
	 */
	public Controller(UserContainer _currentUser) {
		currentUser = _currentUser;
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

				}
			}
		});
		
		// The following takes us to the view all reports frame
		JButton viewAllReportsButton = new JButton("View All Reports");
		viewAllReportsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					// Pass in reference to the controller to the const
					viewAllReportsFrame = new ViewAllReportsFrame(currentUser);
					
					// displose this frame as we are going to make a new one.
					mframe.dispose();
					
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
					viewAllUsersFrame = new ViewAllUsersFrame(currentUser);
					mframe.dispose();
					viewAllUsersFrame.showFrame();
				
				}
			}
		});
		
		JButton viewReportButton = new JButton("View Report");
		viewReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					viewReportGUI = new ViewReportGUI(2L);
				}
			}
		});
		
		JButton logOffButton = new JButton("Log Off");
		logOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					// simply dispose window and exit applicaiton to log off
					mframe.dispose();
				}
			}
		});
		
		JButton createUserButton = new JButton("Create New User");
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					createUserFrame = new CreateUserFrame(currentUser);
					mframe.dispose();
					createUserFrame.start();
				}
			}
		});
		
		JButton deleteUserButton = new JButton("Delete User");
		deleteUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					deleteUserFrame = new DeleteUserFrame(currentUser);
					mframe.dispose();
					deleteUserFrame.start();
				}
			}
		});
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					changePasswordFrame = new ChangePasswordFrame(currentUser);
					mframe.dispose();
					changePasswordFrame.start();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(mframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(createReportButton, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
						.addComponent(viewAllReportsButton, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
					.addGap(296))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(280)
					.addComponent(viewAllUsersButton, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(302)
					.addComponent(deleteUserButton)
					.addContainerGap(337, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(317)
					.addComponent(logOffButton)
					.addContainerGap(342, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(289)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(changePasswordButton)
						.addComponent(createUserButton))
					.addContainerGap(320, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(306)
					.addComponent(viewReportButton)
					.addContainerGap(331, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(createReportButton)
					.addGap(18)
					.addComponent(viewAllReportsButton)
					.addGap(18)
					.addComponent(viewReportButton)
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addComponent(viewAllUsersButton)
					.addGap(18)
					.addComponent(deleteUserButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(createUserButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(changePasswordButton)
					.addGap(14)
					.addComponent(logOffButton)
					.addContainerGap())
		);
		
		
		mframe.getContentPane().setLayout(groupLayout);
		mframe.pack();
		
		if(!currentUser.isSupervisor)
		{
			viewAllReportsButton.setVisible(false);
			viewAllUsersButton.setVisible(false);
			deleteUserButton.setVisible(false);
			createUserButton.setVisible(false);
		}

		
	}
	
	public void showFrame() {
		mframe.setVisible(true);
	}
}
