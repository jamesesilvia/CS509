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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import us.monoid.json.JSONException;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.JTextPane;


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
	
	private Insets mainScreenInsets = new Insets(10, 10, 10, 10);
	
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
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mframe = new JFrame("Home Screen");
		mframe.setTitle("AREST Home Screen");
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {300};
		gridBagLayout.rowHeights = new int[] {0, 50, 50, 50, 50, 50, 50, 50, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		mframe.getContentPane().setLayout(gridBagLayout);
		
		// The following code kicks going to the create report frame
		JButton createReportButton = new JButton("Create Report");		
		createReportButton.setToolTipText("Select this button to create a new Abuse Report.");
		createReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					createReportGUI = new CreateReportGUI(currentUser);

				}
			}
		});
		
		JTextPane welcomeText = new JTextPane();
		welcomeText.setFont(new Font("Calibri", Font.BOLD, 16));
		welcomeText.setOpaque(false);
		welcomeText.setEditable(false);
		GridBagConstraints gbc_welcomeText = new GridBagConstraints();
		gbc_welcomeText.anchor = GridBagConstraints.NORTH;
		gbc_welcomeText.insets = new Insets(10, 10, 10, 10);
		gbc_welcomeText.gridx = 0;
		gbc_welcomeText.gridy = 0;
		welcomeText.setText("Welcome to AREST " + currentUser.firstName + " " + currentUser.lastName);
		mframe.getContentPane().add(welcomeText, gbc_welcomeText);
		GridBagConstraints gbc_createReportButton = new GridBagConstraints();
		gbc_createReportButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_createReportButton.weighty = 0.5;
		gbc_createReportButton.insets = mainScreenInsets;
		gbc_createReportButton.gridx = 0;
		gbc_createReportButton.gridy = 1;
		mframe.getContentPane().add(createReportButton, gbc_createReportButton);
		
		// The following takes us to the view all reports frame
		JButton viewAllReportsButton = new JButton("View All Reports");
		viewAllReportsButton.setToolTipText("Select this button to view all Abuse Reports on the Server. Returned abuse reports depend on your privilege level.");
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
		GridBagConstraints gbc_viewAllReportsButton = new GridBagConstraints();
		gbc_viewAllReportsButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_viewAllReportsButton.weighty = 0.5;
		gbc_viewAllReportsButton.insets = mainScreenInsets;
		gbc_viewAllReportsButton.gridx = 0;
		gbc_viewAllReportsButton.gridy = 2;
		mframe.getContentPane().add(viewAllReportsButton, gbc_viewAllReportsButton);
		
		JButton viewReportButton = new JButton("View Report");
		viewReportButton.setToolTipText("Select this button to view an outstanding abuse report by ID.");
		viewReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					viewReportGUI = new ViewReportGUI(currentUser);
				}
			}
		});
		GridBagConstraints gbc_viewReportButton = new GridBagConstraints();
		gbc_viewReportButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_viewReportButton.weighty = 0.5;
		gbc_viewReportButton.insets = mainScreenInsets;
		gbc_viewReportButton.gridx = 0;
		gbc_viewReportButton.gridy = 3;
		mframe.getContentPane().add(viewReportButton, gbc_viewReportButton);
		
		
		// The following takes us to the view all users frame
		JButton viewAllUsersButton = new JButton("View All Users");
		viewAllUsersButton.setToolTipText("Select this button to view all users registered to the AREST system.");
		viewAllUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					viewAllUsersFrame = new ViewAllUsersFrame(currentUser);
					mframe.dispose();
					viewAllUsersFrame.showFrame();
				
				}
			}
		});
		GridBagConstraints gbc_viewAllUsersButton = new GridBagConstraints();
		gbc_viewAllUsersButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_viewAllUsersButton.weighty = 0.5;
		gbc_viewAllUsersButton.insets = mainScreenInsets;
		gbc_viewAllUsersButton.gridx = 0;
		gbc_viewAllUsersButton.gridy = 4;
		mframe.getContentPane().add(viewAllUsersButton, gbc_viewAllUsersButton);
		
		JButton deleteUserButton = new JButton("Delete User");
		deleteUserButton.setToolTipText("Select this button to delete a specific user.");
		deleteUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					deleteUserFrame = new DeleteUserFrame(currentUser);
					mframe.dispose();
					deleteUserFrame.start();
				}
			}
		});
		GridBagConstraints gbc_deleteUserButton = new GridBagConstraints();
		gbc_deleteUserButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_deleteUserButton.weighty = 0.5;
		gbc_deleteUserButton.insets = mainScreenInsets;
		gbc_deleteUserButton.gridx = 0;
		gbc_deleteUserButton.gridy = 5;
		mframe.getContentPane().add(deleteUserButton, gbc_deleteUserButton);
		
		JButton createUserButton = new JButton("Create New User");
		createUserButton.setToolTipText("Select this button to create a new user.");
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					createUserFrame = new CreateUserFrame(currentUser);
					mframe.dispose();
					createUserFrame.start();
				}
			}
		});
		GridBagConstraints gbc_createUserButton = new GridBagConstraints();
		gbc_createUserButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_createUserButton.weighty = 0.5;
		gbc_createUserButton.insets = mainScreenInsets;
		gbc_createUserButton.gridx = 0;
		gbc_createUserButton.gridy = 6;
		mframe.getContentPane().add(createUserButton, gbc_createUserButton);
		
		JButton changePasswordButton = new JButton("Change Password");
		changePasswordButton.setToolTipText("Select this button to change a password for a user.");
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					changePasswordFrame = new ChangePasswordFrame(currentUser);
					mframe.dispose();
					changePasswordFrame.start();
				}
			}
		});
		GridBagConstraints gbc_changePasswordButton = new GridBagConstraints();
		gbc_changePasswordButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_changePasswordButton.weighty = 0.5;
		gbc_changePasswordButton.insets = mainScreenInsets;
		gbc_changePasswordButton.gridx = 0;
		gbc_changePasswordButton.gridy = 7;
		mframe.getContentPane().add(changePasswordButton, gbc_changePasswordButton);
		
		JButton logOffButton = new JButton("Log Off");
		logOffButton.setToolTipText("Select this button to log off the AREST system.");
		logOffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					// simply dispose window and exit applicaiton to log off
					mframe.dispose();
				}
			}
		});
		GridBagConstraints gbc_logOffButton = new GridBagConstraints();
		gbc_logOffButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_logOffButton.weighty = 0.5;
		gbc_logOffButton.gridx = 0;
		gbc_logOffButton.gridy = 8;
		gbc_logOffButton.insets = mainScreenInsets;
		mframe.getContentPane().add(logOffButton, gbc_logOffButton);
		
		JTextPane txtpnCopyrightJ = new JTextPane();
		txtpnCopyrightJ.setEditable(false);
		txtpnCopyrightJ.setOpaque(false);
		txtpnCopyrightJ.setText("Copyright 2014: J. Silvia, T. Carroll, S. Meas, T. Strott, M. Orsini");
		GridBagConstraints gbc_txtpnCopyrightJ = new GridBagConstraints();
		gbc_txtpnCopyrightJ.anchor = GridBagConstraints.NORTH;
		gbc_txtpnCopyrightJ.gridx = 0;
		gbc_txtpnCopyrightJ.gridy = 9;
		gbc_txtpnCopyrightJ.insets = mainScreenInsets;
		mframe.getContentPane().add(txtpnCopyrightJ, gbc_txtpnCopyrightJ);
		mframe.pack();
		mframe.setResizable(false);
		
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
