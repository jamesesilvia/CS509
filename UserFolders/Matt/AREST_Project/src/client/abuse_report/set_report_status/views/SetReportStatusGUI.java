package client.abuse_report.set_report_status.views;

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

import client.abuse_report.interfaces.CreateReportInterface;
import client.abuse_report.interfaces.ViewReportInterface;
import client.abuse_report.models.Report;

public class SetReportStatusGUI extends JFrame implements CreateReportInterface, ViewReportInterface {

	private JPanel contentPane;
	
	private JTextArea    textArea;
	private JPanel       panel;
	private JScrollPane  scrollPane;
	private JTextPane    statusNotSetWarning;
	private JButton      btnNewButton;
	
	/**
	 * Create the frame.
	 */
	public SetReportStatusGUI() {
		setTitle("AREST: Abuse Report Status");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Set the status of the report.");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(10, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
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
		contentPane.add(statusNotSetWarning, gbc_statusNotSetWarning);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.weighty = 0.5;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		gbc_panel.insets = new Insets(0, 10, 10, 10);
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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
		
		btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(5, 10, 10, 10);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				// FIXME: this should be invoked from an outside source.
				Report report = new Report();
				if(isValidInfo()) {
					updateReport(report);
				}
			}
		});
		
		setVisible(true);
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

	/**
	 * Get the button to submit the status.
	 * @return the btnNewButton
	 */
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	@Override
	public void updatePanel(Report report) {
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
	public Report updateReport(Report report) {
		// Set the status of the abuse report.
		report.setStatus(textArea.getText());
		return report;
	}

}
