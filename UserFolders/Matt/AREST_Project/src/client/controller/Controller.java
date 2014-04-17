package client.controller;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.abuse_report.*;
import client.abuse_report.views.abuse_report.CreateReportGUI;
import client.abuse_report.views.abuse_report.ViewReportGUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import us.monoid.json.JSONException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;

public class Controller {

	private static final String CREATE_REPORT = "CREATE_REPORT";
	
	private JFrame mframe;
	private CreateReportGUI createReportGUI;
	private ViewReportGUI   viewReportGUI;

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
		
		JButton viewReportButton = new JButton("View Report");
		viewReportButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				if(event.getID() == ActionEvent.ACTION_PERFORMED) {
					try {
						// FIXME: This is hard-coded to 2!
						viewReportGUI = new ViewReportGUI(2L);
					} catch (JsonGenerationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 0};
		gridBagLayout.rowHeights = new int[]{23, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		mframe.getContentPane().setLayout(gridBagLayout);
		
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
		GridBagConstraints gbc_createReportButton = new GridBagConstraints();
		gbc_createReportButton.insets = new Insets(0, 0, 5, 0);
		gbc_createReportButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_createReportButton.gridx = 0;
		gbc_createReportButton.gridy = 0;
		
		GridBagConstraints gbc_viewReportButton = new GridBagConstraints();
		gbc_viewReportButton.insets = new Insets(0, 0, 5, 0);
		gbc_viewReportButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_viewReportButton.gridx = 0;
		gbc_viewReportButton.gridy = 1;
		
		mframe.getContentPane().add(createReportButton, gbc_createReportButton);
		mframe.getContentPane().add(viewReportButton, gbc_viewReportButton);
		mframe.pack();
	}
}
