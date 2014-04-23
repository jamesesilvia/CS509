package client.view.abuseReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import client.view.abuseReport.*;
import client.model.*;

public class SetReportStatusGUI extends JPanel implements CreateReportInterface, ViewReportInterface {

	
	protected JTextArea    textArea;
	protected JPanel       panel;
	protected JScrollPane  scrollPane;
	protected JTextPane    statusNotSetWarning;
	protected JLabel       lblNewLabel;
	
	/**
	 * Create the frame.
	 */
	public SetReportStatusGUI() {
	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		setLayout(gbl_contentPane);
		
		lblNewLabel = new JLabel("Set the status of the report.");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(10, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		statusNotSetWarning = new JTextPane();
		statusNotSetWarning.setVisible(false);
		statusNotSetWarning.setEditable(false);
		statusNotSetWarning.setBackground(SystemColor.menu);
		statusNotSetWarning.setForeground(Color.RED);
		statusNotSetWarning.setText("*");
		GridBagConstraints gbc_statusNotSetWarning = new GridBagConstraints();
		gbc_statusNotSetWarning.anchor = GridBagConstraints.SOUTH;
		gbc_statusNotSetWarning.insets = new Insets(0, 0, 5, 0);
		gbc_statusNotSetWarning.fill = GridBagConstraints.HORIZONTAL;
		gbc_statusNotSetWarning.gridx = 1;
		gbc_statusNotSetWarning.gridy = 0;
		add(statusNotSetWarning, gbc_statusNotSetWarning);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 0.5;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		gbc_panel.insets = new Insets(0, 10, 10, 10);
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 0.1;
		gbc_scrollPane.weightx = 0.1;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		
	}
	
	/**
	 * Get the status text area of this class.
	 * @return the textArea
	 */
	public JTextArea getTextArea() {
		return textArea;
	}

	/**
	 * Get the text pane for the status not set warning.
	 * @return the statusNotSetWarning
	 */
	public JTextPane getStatusNotSetWarning() {
		return statusNotSetWarning;
	}

	@Override
	public void updatePanel(Report report, boolean redacted) {
		// Set the status for the selected abuse report.
		textArea.setText(report.getStatus());
	}

	@Override
	public boolean isValidInfo() {
		// Check that some information has been entered.
		if(textArea.getText().equals("")) {
			statusNotSetWarning.setVisible(true);
			return false;
		} else {
			statusNotSetWarning.setVisible(false);
		}
		return true;
	}

	@Override
	public Report updateReport(Report report, boolean redacted) {
		// Set the status of the abuse report.
		report.setStatus(textArea.getText());
		return report;
	}

	/**
	 * Sets the text in the status GUI label.
	 * @param text
	 */
	public void setLabelText(String text) {
		lblNewLabel.setText(text);
	}
	
}
