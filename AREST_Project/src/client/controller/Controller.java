package client.controller;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.abuse_report.*;
import client.abuse_report.views.abuse_report.CreateReportGUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	private CreateReportGUI createReportGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller window = new Controller();
					window.mframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		mframe = new JFrame();
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// The following code kicks off a create report sequence in another thread.
		JButton createReportButton = new JButton("Create Report");
		createReportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					createReportGUI = new CreateReportGUI();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(mframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(266)
					.addComponent(createReportButton)
					.addContainerGap(283, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(createReportButton)
					.addContainerGap(348, Short.MAX_VALUE))
		);
		mframe.getContentPane().setLayout(groupLayout);
		mframe.pack();
	}
}
