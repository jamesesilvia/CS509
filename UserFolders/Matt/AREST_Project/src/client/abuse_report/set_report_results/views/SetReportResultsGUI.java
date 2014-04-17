package client.abuse_report.set_report_results.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextArea;

public class SetReportResultsGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public SetReportResultsGUI() {
		setTitle("AREST: Abuse Report Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel resultsPanel = new JPanel();
		contentPane.add(resultsPanel, BorderLayout.CENTER);
		GridBagLayout gbl_resultsPanel = new GridBagLayout();
		gbl_resultsPanel.columnWidths = new int[]{0, 0};
		gbl_resultsPanel.rowHeights = new int[]{0, 0, 0};
		gbl_resultsPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_resultsPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		resultsPanel.setLayout(gbl_resultsPanel);
		
		JLabel resultsLabel = new JLabel("Set the results of the abuse report:");
		resultsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_resultsLabel = new GridBagConstraints();
		gbc_resultsLabel.weightx = 0.1;
		gbc_resultsLabel.anchor = GridBagConstraints.WEST;
		gbc_resultsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_resultsLabel.gridx = 0;
		gbc_resultsLabel.gridy = 0;
		gbc_resultsLabel.insets = new Insets(10, 10, 5, 10);
		resultsPanel.add(resultsLabel, gbc_resultsLabel);
		
		JScrollPane resultTextScroll = new JScrollPane();
		GridBagConstraints gbc_resultTextScroll = new GridBagConstraints();
		gbc_resultTextScroll.fill = GridBagConstraints.BOTH;
		gbc_resultTextScroll.gridx = 0;
		gbc_resultTextScroll.gridy = 1;
		gbc_resultTextScroll.insets = new Insets(0, 10, 10, 10);
		resultsPanel.add(resultTextScroll, gbc_resultTextScroll);
		
		JTextArea resultText = new JTextArea();
		resultTextScroll.setViewportView(resultText);
		
		setVisible(true);
		
		
		
	}

}
