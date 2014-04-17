package client.view.abuseReport;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import client.view.abuseReport.CreateReportInterface;
import client.model.*;
import common.DocumentSizeFilter;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class DescriptionGUI extends JPanel implements CreateReportInterface {

	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	
	private JPanel injuryPanel = new JPanel();
	private JLabel injuryLabel = new JLabel("3. Please list any resulting injuries:");
	private JTextArea injuryText = new JTextArea();
	private JPanel witnessPanel = new JPanel();
	private JLabel witnessLabel = new JLabel("4. Please list witnesses, if any, including daytime phone numbers: ");
	private JTextArea witnessText = new JTextArea();
	private JPanel relationshipPanel = new JPanel();
	private JLabel relationshipLabel = new JLabel("5. Please describe the caregiver relationship between the alleged abuser and the alleged victim.");
	private JLabel assistanceLabel = new JLabel("(What assistance, if any, does the alleged abuser provide to the person with the disability?)   ");
	private JTextArea relationshipText = new JTextArea();
	private JPanel dppcHotlinePanel = new JPanel();
	private JLabel dppcHotlineLabel = new JLabel("6. Was an oral report filed with the DPPC Hotline?   ");
	private JCheckBox chckbxDppcYes = new JCheckBox("YES");
	private JLabel dppcCalledTimeLabel = new JLabel("Please note date and time of call:");
	private JLabel dateLabel = new JLabel("Date:");
	private JPanel dppcCalledDatePanel = new JPanel();
	private JFormattedTextField dppcCalledMonth = new JFormattedTextField();
	private JFormattedTextField dppcCalledDay = new JFormattedTextField();
	private JPanel dppcCalledTimePanel = new JPanel();
	private JLabel dppcCalledHourLabel = new JLabel("Hour:");
	private JFormattedTextField dppcCalledHour = new JFormattedTextField();
	private JLabel dppcCalledMinuteLabel = new JLabel("Min:");
	private JFormattedTextField dppcCalledMinute = new JFormattedTextField();
	private JCheckBox chckbxDppcNo = new JCheckBox("NO");
	private JPanel investigatorRiskPanel = new JPanel();
	private JLabel riskLabel = new JLabel("7. Is there any risk to the investigator?   ");
	private JCheckBox chckbxInvestRiskYes = new JCheckBox("YES");
	private JLabel investRiskYesSpecifyLabel = new JLabel("If yes, please specify:");
	private JCheckBox chckbxInvestRiskNo = new JCheckBox("NO");
	private JTextArea investRisk = new JTextArea();
	
	private DocumentSizeFilter filter = new DocumentSizeFilter(10);
	private final JLabel lblIfNotYou = new JLabel("You MUST file an oral report of suspected abuse. Please call 800-426-9009   ");
	private final JTextPane warnOralReportNotSet = new JTextPane();
	private final JTextPane warnInvestRiskNotSet = new JTextPane();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	
	/**
	 * Create the panel.
	 */
	public DescriptionGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		injuryPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_injuryPanel = new GridBagConstraints();
		gbc_injuryPanel.weighty = 0.1;
		gbc_injuryPanel.insets = new Insets(10, 10, 5, 10);
		gbc_injuryPanel.fill = GridBagConstraints.BOTH;
		gbc_injuryPanel.gridx = 0;
		gbc_injuryPanel.gridy = 0;
		add(injuryPanel, gbc_injuryPanel);
		GridBagLayout gbl_injuryPanel = new GridBagLayout();
		gbl_injuryPanel.columnWidths = new int[]{0, 0};
		gbl_injuryPanel.rowHeights = new int[]{0, 0, 0};
		gbl_injuryPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_injuryPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		injuryPanel.setLayout(gbl_injuryPanel);
		
		injuryLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_injuryLabel = new GridBagConstraints();
		gbc_injuryLabel.fill = GridBagConstraints.VERTICAL;
		gbc_injuryLabel.weightx = 0.3;
		gbc_injuryLabel.anchor = GridBagConstraints.WEST;
		gbc_injuryLabel.gridx = 0;
		gbc_injuryLabel.gridy = 0;
		gbc_injuryLabel.insets = new Insets(10, 10, 5, 0);
		injuryPanel.add(injuryLabel, gbc_injuryLabel);
		
		witnessPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_witnessPanel = new GridBagConstraints();
		gbc_witnessPanel.weighty = 0.2;
		gbc_witnessPanel.insets = new Insets(5, 10, 5, 10);
		gbc_witnessPanel.fill = GridBagConstraints.BOTH;
		gbc_witnessPanel.gridx = 0;
		gbc_witnessPanel.gridy = 1;
		add(witnessPanel, gbc_witnessPanel);
		GridBagLayout gbl_witnessPanel = new GridBagLayout();
		gbl_witnessPanel.columnWidths = new int[]{0, 0};
		gbl_witnessPanel.rowHeights = new int[]{0, 0, 0};
		gbl_witnessPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_witnessPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		witnessPanel.setLayout(gbl_witnessPanel);
		
		witnessLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_witnessLabel = new GridBagConstraints();
		gbc_witnessLabel.anchor = GridBagConstraints.WEST;
		gbc_witnessLabel.gridx = 0;
		gbc_witnessLabel.gridy = 0;
		gbc_witnessLabel.insets = new Insets(10, 10, 5, 0);
		witnessPanel.add(witnessLabel, gbc_witnessLabel);
		
		
		relationshipPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_relationshipPanel = new GridBagConstraints();
		gbc_relationshipPanel.weighty = 0.3;
		gbc_relationshipPanel.insets = new Insets(5, 10, 5, 10);
		gbc_relationshipPanel.fill = GridBagConstraints.BOTH;
		gbc_relationshipPanel.gridx = 0;
		gbc_relationshipPanel.gridy = 2;
		add(relationshipPanel, gbc_relationshipPanel);
		GridBagLayout gbl_relationshipPanel = new GridBagLayout();
		gbl_relationshipPanel.columnWidths = new int[]{0, 0};
		gbl_relationshipPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_relationshipPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_relationshipPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		relationshipPanel.setLayout(gbl_relationshipPanel);
		
		
		relationshipLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_relationshipLabel = new GridBagConstraints();
		gbc_relationshipLabel.anchor = GridBagConstraints.WEST;
		gbc_relationshipLabel.gridx = 0;
		gbc_relationshipLabel.gridy = 0;
		gbc_relationshipLabel.insets = new Insets(10, 10, 5, 0);
		relationshipPanel.add(relationshipLabel, gbc_relationshipLabel);
		
		
		assistanceLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_assistanceLabel = new GridBagConstraints();
		gbc_assistanceLabel.anchor = GridBagConstraints.WEST;
		gbc_assistanceLabel.gridx = 0;
		gbc_assistanceLabel.gridy = 1;
		gbc_assistanceLabel.insets = new Insets(0, 25, 5, 0);
		relationshipPanel.add(assistanceLabel, gbc_assistanceLabel);
		
		
		dppcHotlinePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_dppcHotlinePanel = new GridBagConstraints();
		gbc_dppcHotlinePanel.insets = new Insets(5, 10, 5, 10);
		gbc_dppcHotlinePanel.fill = GridBagConstraints.BOTH;
		gbc_dppcHotlinePanel.gridx = 0;
		gbc_dppcHotlinePanel.gridy = 3;
		add(dppcHotlinePanel, gbc_dppcHotlinePanel);
		GridBagLayout gbl_dppcHotlinePanel = new GridBagLayout();
		gbl_dppcHotlinePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_dppcHotlinePanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_dppcHotlinePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcHotlinePanel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		dppcHotlinePanel.setLayout(gbl_dppcHotlinePanel);
		
		
		dppcHotlineLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_dppcHotlineLabel = new GridBagConstraints();
		gbc_dppcHotlineLabel.gridwidth = 2;
		gbc_dppcHotlineLabel.anchor = GridBagConstraints.WEST;
		gbc_dppcHotlineLabel.gridx = 0;
		gbc_dppcHotlineLabel.gridy = 0;
		gbc_dppcHotlineLabel.insets = new Insets(10, 10, 5, 5);
		dppcHotlinePanel.add(dppcHotlineLabel, gbc_dppcHotlineLabel);
		
		GridBagConstraints gbc_warnOralReportNotSet = new GridBagConstraints();
		gbc_warnOralReportNotSet.anchor = GridBagConstraints.SOUTH;
		gbc_warnOralReportNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnOralReportNotSet.fill = GridBagConstraints.HORIZONTAL;
		gbc_warnOralReportNotSet.gridx = 2;
		gbc_warnOralReportNotSet.gridy = 0;
		warnOralReportNotSet.setVisible(false);
		warnOralReportNotSet.setEditable(false);
		warnOralReportNotSet.setBackground(SystemColor.menu);
		warnOralReportNotSet.setForeground(Color.RED);
		warnOralReportNotSet.setText("*");
		dppcHotlinePanel.add(warnOralReportNotSet, gbc_warnOralReportNotSet);
		
		GridBagConstraints gbc_lblIfNotYou = new GridBagConstraints();
		gbc_lblIfNotYou.gridwidth = 5;
		gbc_lblIfNotYou.insets = new Insets(10, 0, 5, 0);
		gbc_lblIfNotYou.gridx = 3;
		gbc_lblIfNotYou.gridy = 0;
		lblIfNotYou.setFont(new Font("Tahoma", Font.ITALIC, 11));
		dppcHotlinePanel.add(lblIfNotYou, gbc_lblIfNotYou);
		
		
		GridBagConstraints gbc_chckbxDppcYes = new GridBagConstraints();
		gbc_chckbxDppcYes.anchor = GridBagConstraints.WEST;
		gbc_chckbxDppcYes.insets = new Insets(0, 100, 5, 5);
		gbc_chckbxDppcYes.gridx = 0;
		gbc_chckbxDppcYes.gridy = 1;
		dppcHotlinePanel.add(chckbxDppcYes, gbc_chckbxDppcYes);
		
		
		GridBagConstraints gbc_dppcCalledTimeLabel = new GridBagConstraints();
		gbc_dppcCalledTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dppcCalledTimeLabel.gridx = 3;
		gbc_dppcCalledTimeLabel.gridy = 1;
		dppcHotlinePanel.add(dppcCalledTimeLabel, gbc_dppcCalledTimeLabel);
		
		
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.EAST;
		gbc_dateLabel.weightx = 0.1;
		gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateLabel.gridx = 4;
		gbc_dateLabel.gridy = 1;
		dppcHotlinePanel.add(dateLabel, gbc_dateLabel);
		
		
		GridBagConstraints gbc_dppcCalledDatePanel = new GridBagConstraints();
		gbc_dppcCalledDatePanel.weightx = 0.1;
		gbc_dppcCalledDatePanel.insets = new Insets(0, 0, 5, 5);
		gbc_dppcCalledDatePanel.fill = GridBagConstraints.BOTH;
		gbc_dppcCalledDatePanel.gridx = 5;
		gbc_dppcCalledDatePanel.gridy = 1;
		dppcCalledDatePanel.setEnabled(false);
		dppcHotlinePanel.add(dppcCalledDatePanel, gbc_dppcCalledDatePanel);
		GridBagLayout gbl_dppcCalledDatePanel = new GridBagLayout();
		gbl_dppcCalledDatePanel.columnWidths = new int[]{0, 0, 0};
		gbl_dppcCalledDatePanel.rowHeights = new int[]{0, 0};
		gbl_dppcCalledDatePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcCalledDatePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dppcCalledDatePanel.setLayout(gbl_dppcCalledDatePanel);
		
		
		GridBagConstraints gbc_dppcCalledMonth = new GridBagConstraints();
		gbc_dppcCalledMonth.weightx = 0.1;
		gbc_dppcCalledMonth.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledMonth.gridx = 0;
		gbc_dppcCalledMonth.gridy = 0;
		dppcCalledMonth.setEnabled(false);
		dppcCalledMonth.setText("MM");
		dppcCalledDatePanel.add(dppcCalledMonth, gbc_dppcCalledMonth);
		
		
		GridBagConstraints gbc_dppcCalledDay = new GridBagConstraints();
		gbc_dppcCalledDay.weightx = 0.1;
		gbc_dppcCalledDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledDay.gridx = 1;
		gbc_dppcCalledDay.gridy = 0;
		dppcCalledDay.setEnabled(false);
		dppcCalledDay.setText("DD");
		dppcCalledDatePanel.add(dppcCalledDay, gbc_dppcCalledDay);
		
		GridBagConstraints gbc_dppcCalledTimePanel = new GridBagConstraints();
		gbc_dppcCalledTimePanel.weightx = 0.1;
		gbc_dppcCalledTimePanel.insets = new Insets(0, 0, 5, 10);
		gbc_dppcCalledTimePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledTimePanel.gridx = 7;
		gbc_dppcCalledTimePanel.gridy = 1;
		dppcCalledTimePanel.setEnabled(false);
		dppcHotlinePanel.add(dppcCalledTimePanel, gbc_dppcCalledTimePanel);
		GridBagLayout gbl_dppcCalledTimePanel = new GridBagLayout();
		gbl_dppcCalledTimePanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_dppcCalledTimePanel.rowHeights = new int[]{0, 0};
		gbl_dppcCalledTimePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcCalledTimePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dppcCalledTimePanel.setLayout(gbl_dppcCalledTimePanel);
		
		
		
		GridBagConstraints gbc_dppcCalledHourLabel = new GridBagConstraints();
		gbc_dppcCalledHourLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledHourLabel.anchor = GridBagConstraints.EAST;
		gbc_dppcCalledHourLabel.gridx = 0;
		gbc_dppcCalledHourLabel.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledHourLabel, gbc_dppcCalledHourLabel);
		
		
		GridBagConstraints gbc_dppcCalledHour = new GridBagConstraints();
		gbc_dppcCalledHour.weightx = 0.1;
		gbc_dppcCalledHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledHour.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledHour.gridx = 1;
		gbc_dppcCalledHour.gridy = 0;
		dppcCalledHour.setEnabled(false);
		dppcCalledHour.setText("HH");
		dppcCalledTimePanel.add(dppcCalledHour, gbc_dppcCalledHour);
		
		
		GridBagConstraints gbc_dppcCalledMinuteLabel = new GridBagConstraints();
		gbc_dppcCalledMinuteLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledMinuteLabel.anchor = GridBagConstraints.EAST;
		gbc_dppcCalledMinuteLabel.gridx = 2;
		gbc_dppcCalledMinuteLabel.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledMinuteLabel, gbc_dppcCalledMinuteLabel);
		
		
		GridBagConstraints gbc_dppcCalledMinute = new GridBagConstraints();
		gbc_dppcCalledMinute.weightx = 0.1;
		gbc_dppcCalledMinute.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledMinute.gridx = 3;
		gbc_dppcCalledMinute.gridy = 0;
		dppcCalledMinute.setEnabled(false);
		dppcCalledMinute.setText("MM");
		dppcCalledTimePanel.add(dppcCalledMinute, gbc_dppcCalledMinute);
		
		
		GridBagConstraints gbc_chckbxDppcNo = new GridBagConstraints();
		gbc_chckbxDppcNo.anchor = GridBagConstraints.WEST;
		gbc_chckbxDppcNo.gridx = 0;
		gbc_chckbxDppcNo.gridy = 2;
		gbc_chckbxDppcNo.insets = new Insets(0, 100, 0, 5);
		dppcHotlinePanel.add(chckbxDppcNo, gbc_chckbxDppcNo);
		
		
		investigatorRiskPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_investigatorRiskPanel = new GridBagConstraints();
		gbc_investigatorRiskPanel.fill = GridBagConstraints.BOTH;
		gbc_investigatorRiskPanel.gridx = 0;
		gbc_investigatorRiskPanel.gridy = 4;
		gbc_investigatorRiskPanel.insets = new Insets(5, 10, 5, 10);
		add(investigatorRiskPanel, gbc_investigatorRiskPanel);
		GridBagLayout gbl_investigatorRiskPanel = new GridBagLayout();
		gbl_investigatorRiskPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_investigatorRiskPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_investigatorRiskPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_investigatorRiskPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		investigatorRiskPanel.setLayout(gbl_investigatorRiskPanel);
		
		riskLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_riskLabel = new GridBagConstraints();
		gbc_riskLabel.gridx = 0;
		gbc_riskLabel.gridy = 0;
		gbc_riskLabel.insets = new Insets(10, 10, 5, 5);
		investigatorRiskPanel.add(riskLabel, gbc_riskLabel);
		
		GridBagConstraints gbc_warnInvestRiskNotSet = new GridBagConstraints();
		gbc_warnInvestRiskNotSet.anchor = GridBagConstraints.SOUTH;
		gbc_warnInvestRiskNotSet.insets = new Insets(0, 0, 5, 5);
		gbc_warnInvestRiskNotSet.fill = GridBagConstraints.HORIZONTAL;
		gbc_warnInvestRiskNotSet.gridx = 1;
		gbc_warnInvestRiskNotSet.gridy = 0;
		warnInvestRiskNotSet.setVisible(false);
		warnInvestRiskNotSet.setEditable(false);
		warnInvestRiskNotSet.setBackground(SystemColor.menu);
		warnInvestRiskNotSet.setForeground(Color.RED);
		warnInvestRiskNotSet.setText("*");
		investigatorRiskPanel.add(warnInvestRiskNotSet, gbc_warnInvestRiskNotSet);
		
		
		GridBagConstraints gbc_chckbxInvestRiskYes = new GridBagConstraints();
		gbc_chckbxInvestRiskYes.anchor = GridBagConstraints.WEST;
		gbc_chckbxInvestRiskYes.insets = new Insets(5, 100, 5, 5);
		gbc_chckbxInvestRiskYes.gridx = 0;
		gbc_chckbxInvestRiskYes.gridy = 1;
		investigatorRiskPanel.add(chckbxInvestRiskYes, gbc_chckbxInvestRiskYes);
		
		
		GridBagConstraints gbc_investRiskYesSpecifyLabel = new GridBagConstraints();
		gbc_investRiskYesSpecifyLabel.anchor = GridBagConstraints.WEST;
		gbc_investRiskYesSpecifyLabel.insets = new Insets(0, 0, 5, 0);
		gbc_investRiskYesSpecifyLabel.gridx = 2;
		gbc_investRiskYesSpecifyLabel.gridy = 1;
		investigatorRiskPanel.add(investRiskYesSpecifyLabel, gbc_investRiskYesSpecifyLabel);
		
		
		
		GridBagConstraints gbc_chckbxInvestRiskNo = new GridBagConstraints();
		gbc_chckbxInvestRiskNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxInvestRiskNo.insets = new Insets(0, 100, 0, 5);
		gbc_chckbxInvestRiskNo.gridx = 0;
		gbc_chckbxInvestRiskNo.gridy = 2;
		investigatorRiskPanel.add(chckbxInvestRiskNo, gbc_chckbxInvestRiskNo);
		
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.weighty = 0.1;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 2;
		gbc_scrollPane_3.gridy = 2;
		gbc_scrollPane_3.insets = new Insets(0, 0, 10, 10);
		investigatorRiskPanel.add(scrollPane_3, gbc_scrollPane_3);
		scrollPane_3.setViewportView(investRisk);
		investRisk.setEnabled(false);
		
		
		investRisk.setWrapStyleWord(true);
		investRisk.setLineWrap(true);
		filter.setupTextField(investRisk, DocumentSizeFilter.ANY, 500);

		filter.setupTextField(dppcCalledDay, DocumentSizeFilter.NO, 2);
		filter.setupTextField(dppcCalledHour, DocumentSizeFilter.NO, 2);
		filter.setupTextField(dppcCalledMinute, DocumentSizeFilter.NO, 2);
		filter.setupTextField(dppcCalledMonth, DocumentSizeFilter.NO, 2);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 0.1;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.insets = new Insets(10,10,10,10);
		injuryPanel.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(injuryText);
		
		
		injuryText.setLineWrap(true);
		filter.setupTextField(injuryText, DocumentSizeFilter.ANY, 500);
		
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.weighty = 0.1;
		gbc_scrollPane_2.weightx = 0.1;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		gbc_scrollPane_2.insets = new Insets(10, 10, 10, 10);
		relationshipPanel.add(scrollPane_2, gbc_scrollPane_2);
		scrollPane_2.setViewportView(relationshipText);
		filter.setupTextField(relationshipText, DocumentSizeFilter.ANY, 500);
		
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weighty = 0.1;
		gbc_scrollPane_1.weightx = 0.1;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		gbc_scrollPane_1.insets = new Insets(10, 10, 10, 10);
		witnessPanel.add(scrollPane_1, gbc_scrollPane_1);
		scrollPane_1.setViewportView(witnessText);
		
		
		witnessText.setLineWrap(true);
		filter.setupTextField(witnessText, DocumentSizeFilter.ANY, 100);
		
		for(int i=0; i< dppcHotlinePanel.getComponentCount(); i++) {
			if(dppcHotlinePanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox)dppcHotlinePanel.getComponent(i);
				myCb.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED || event.getStateChange() == ItemEvent.DESELECTED) {
							toggleAllCheckBoxesInPanel(dppcHotlinePanel, event.getItem());
							if(event.getSource().equals(chckbxDppcYes) && chckbxDppcYes.isSelected()) {
								dppcCalledMonth.setEnabled(true);
								dppcCalledDay.setEnabled(true);
								dppcCalledHour.setEnabled(true);
								dppcCalledMinute.setEnabled(true);
							} else {
								dppcCalledMonth.setEnabled(false);
								dppcCalledDay.setEnabled(false);
								dppcCalledHour.setEnabled(false);
								dppcCalledMinute.setEnabled(false);
							}
						}
					}
				});
			}
		}
		
		for(int i=0; i<investigatorRiskPanel.getComponentCount(); i++) {
			if(investigatorRiskPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox)investigatorRiskPanel.getComponent(i);
				myCb.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange() == ItemEvent.SELECTED || event.getStateChange() == ItemEvent.DESELECTED) {
							toggleAllCheckBoxesInPanel(investigatorRiskPanel, event.getItem());
							if(event.getSource().equals(chckbxInvestRiskYes) && chckbxInvestRiskYes.isSelected()) {
								investRisk.setEnabled(true);
							} else {
								investRisk.setEnabled(false);
							}
						}
					}
				});
			}
		}
		
	}

	/**
	 * Toggle all the checkboxes in the specified container (JPanel)
	 * @param container - the container containing the checkboxes
	 * @param cb - the checkbox selected.
	 */
	public void toggleAllCheckBoxesInPanel(Container container, Object cb){
		for(int i=0; i<container.getComponents().length; i++){
			// Disable all components in this panel.
			if(!container.getComponent(i).equals(cb) && container.getComponent(i) instanceof JCheckBox) {
				container.getComponent(i).setEnabled(!container.getComponent(i).isEnabled());
			}
		}
	}

	@Override
	public boolean isValidInfo() {
		boolean validInfo = true;
		warnOralReportNotSet.setVisible(false);
		warnInvestRiskNotSet.setVisible(false);
		
		if(!chckbxDppcYes.isSelected() && !chckbxDppcNo.isSelected()) {
			warnOralReportNotSet.setVisible(true);
			validInfo = false;
		}
		
		if(!chckbxInvestRiskNo.isSelected() && !chckbxInvestRiskYes.isSelected()) {
			warnInvestRiskNotSet.setVisible(true);
			validInfo = false;
		}
		
		return validInfo;
	}

	@Override
	public Reporter commitReporter(Reporter reporter) {
		return reporter;
	}

	@Override
	public Abuser commitAbuser(Abuser abuser) {
		return abuser;
	}

	@Override
	public Victim commitVictim(Victim victim) {
		return victim;
	}

	@Override
	public Guardian commitGuardian(Guardian guardian) {
		return guardian;
	}
	
	public ReportContainer getReportContainerInfo(ReportContainer reportContainer) {
		reportContainer.setInjuryList(injuryText.getText());
		reportContainer.setWitnesses(witnessText.getText());
		reportContainer.setCaregiverRel(relationshipText.getText());
		
		reportContainer.setOralReportFiled(chckbxDppcYes.isSelected());
		if(reportContainer.isOralReportFiled()) {
			reportContainer.setOralReportFiledTime(dppcCalledMonth.getText().concat(dppcCalledDay.getText().concat(dppcCalledHour.getText().concat(dppcCalledMinute.getText()))));
		}
		
		reportContainer.setRiskToInvestigator(chckbxInvestRiskYes.isSelected());
		if(reportContainer.isRiskToInvestigator()) {
			reportContainer.setRiskDescrToInvestigator(investRisk.getText());
		}
		return reportContainer;
	}
	
}
