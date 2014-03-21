package cs509.grp8.arest.controller;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cs509.grp8.arest.report.CreateReportGUI;
import cs509.grp8.arest.report.ReporterGUI;

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
					Thread t = new Thread(createReportGUI);
					t.start();
					mframe.setVisible(false); // disable this frame for now. Another frame is constructed
					try {
						t.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mframe.setVisible(true);
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
