package client.abuse_report.views.abuse_report;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import client.abuse_report.interfaces.CreateReportInterface;
import client.abuse_report.models.Abuser;
import client.abuse_report.models.Guardian;
import client.abuse_report.models.Reporter;
import client.abuse_report.models.Victim;
import common.DocumentSizeFilter;

// FIXME MOrsini: Add in warnings after fixing the reporter warnings

public class VictimGUI extends JPanel implements CreateReportInterface {
	
	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	
	private DocumentSizeFilter filter;
	
	private JTextField monthText;
	private JTextField dayText;
	private JTextField maritalStatusText;
	private JTextArea  addressTextArea;
	private JFormattedTextField disabilityOtherTextField;
	
	private JCheckBox chckbxMentalRetardation;
	private JCheckBox chckbxMobility;	
	private JCheckBox chckbxVisual;
	private JCheckBox chckbxCerebralPalsy;
	private JCheckBox chckbxSeizures;
	private JCheckBox chckbxMentalIllness;
	private JCheckBox chckbxHeadInjury;
	private JCheckBox chckbxDeafHard;
	private JCheckBox chckbxMultipleSclerosis;
	private JCheckBox chckbxOtherspecify;
	
	private JLabel allegedVictimLabel;
	private JLabel firstNameLabel;
	private JLabel addressLabel;
	private JLabel sexLabel;
	private JLabel dobLabel;
	private JLabel ageLabel;
	private JLabel maritalStatusLabel;
	private JLabel disabilityLabel;
	private JLabel ethnicityLabel;
	private JLabel lastNameLabel;
	private JLabel lblTelephone;
	private JLabel communicationNeedsLabel;
	
	private JTextPane firstNameNotSetWarning;
	private JTextPane addrNotSetWarning;
	private JTextPane dobNotSetWarning;
	private JTextPane sexNotSetWarning;
	private JTextPane ageNotSetWarning;
	private JTextPane maritalStatusNotSetWarning;
	private JTextPane disabilityNotSetWarning;
	private JTextPane ethnicityNotSetWarning;
	private JTextField yearText;
	private JTextField ageText;
	private JFormattedTextField firstNameText;
	private JFormattedTextField lastNameText;
	private JFormattedTextField phoneAreaCode;
	private JFormattedTextField phoneFirstThree;
	private JFormattedTextField phoneLastFour;
	private JTextPane lastNameNotSetWarning;
	private JTextPane comNotSetWarning;
	private JFormattedTextField otherEthnicityTextField;
	private JTextPane phoneNotSetWarning;
	private JTextField otherComNeedsTextField;
	
	
	private JPanel DisabilityPanel;
	private JPanel VictimPanel;
	private JPanel ethnicityPanel;
	private JPanel ComNeedsPanel;
	private JPanel comNeedsCbPanel;
	private JPanel ethnicityCbPanel;
	private JPanel disabilityCbPanel;
	
	private JComboBox sexCombo;
	
	private JCheckBox caucasianCheckBox;
	private JCheckBox africanAmericanCheckBox;
	private JCheckBox hispanicCheckBox;
	private JCheckBox nativeAmericanCheckBox;
	private JCheckBox asianCheckBox;
	private JCheckBox otherEthnicityCheckBox;
	private JCheckBox ttyCheckBox;
	private JCheckBox signInterCheckBox;
	private JCheckBox otherComNeedsCheckBox;
	private JPanel panel;
	private JPanel panel_1;

	
	public VictimGUI() {
		setToolTipText("Please enter information regarding the Alleged Victim.");
		// To configure JTextComponents
		filter = new DocumentSizeFilter(10);
		
		

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{800, 0};
		gridBagLayout.rowHeights = new int[]{223, 172, 161, 113, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		VictimPanel = new JPanel();
		VictimPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_VictimPanel = new GridBagConstraints();
		gbc_VictimPanel.weighty = 0.3;
		gbc_VictimPanel.fill = GridBagConstraints.BOTH;
		gbc_VictimPanel.insets = new Insets(10, 10, 5, 10);
		gbc_VictimPanel.gridx = 0;
		gbc_VictimPanel.gridy = 0;
		add(VictimPanel, gbc_VictimPanel);
		GridBagLayout gbl_VictimPanel = new GridBagLayout();
		gbl_VictimPanel.columnWidths = new int[]{55, 0, 301, 109, 30, 302, 0};
		gbl_VictimPanel.rowHeights = new int[]{19, 21, 22, 20, 21, 21, 0};
		gbl_VictimPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_VictimPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		VictimPanel.setLayout(gbl_VictimPanel);
		
		addrNotSetWarning = new JTextPane();
		addrNotSetWarning.setVisible(false);
		
		allegedVictimLabel = new JLabel("Alleged Victim");
		allegedVictimLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_allegedVictimLabel = new GridBagConstraints();
		gbc_allegedVictimLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_allegedVictimLabel.insets = topInsetBumper;
		gbc_allegedVictimLabel.gridx = 0;
		gbc_allegedVictimLabel.gridy = 0;
		VictimPanel.add(allegedVictimLabel, gbc_allegedVictimLabel);
		
		firstNameLabel = new JLabel("First Name:");
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_firstNameLabel.insets = leftInsetBumper;
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 1;
		VictimPanel.add(firstNameLabel, gbc_firstNameLabel);
		
		firstNameNotSetWarning = new JTextPane();
		firstNameNotSetWarning.setVisible(false);
		firstNameNotSetWarning.setEditable(false);
		firstNameNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameNotSetWarning.setForeground(Color.RED);
		firstNameNotSetWarning.setText("*");
		firstNameNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_firstNameNotSetWarning = new GridBagConstraints();
		gbc_firstNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_firstNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameNotSetWarning.gridx = 1;
		gbc_firstNameNotSetWarning.gridy = 1;
		VictimPanel.add(firstNameNotSetWarning, gbc_firstNameNotSetWarning);
		
		firstNameText = new JFormattedTextField();
		filter.setupTextField(firstNameText, DocumentSizeFilter.CHAR, 20);
		filter.setupTextField(firstNameText, DocumentSizeFilter.CHAR, 20);
		GridBagConstraints gbc_firstNameText = new GridBagConstraints();
		gbc_firstNameText.anchor = GridBagConstraints.NORTH;
		gbc_firstNameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameText.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameText.gridx = 2;
		gbc_firstNameText.gridy = 1;
		VictimPanel.add(firstNameText, gbc_firstNameText);
		
		lastNameLabel = new JLabel("Last Name:");
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.weightx = 0.1;
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameLabel.gridx = 3;
		gbc_lastNameLabel.gridy = 1;
		VictimPanel.add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameNotSetWarning = new JTextPane();
		lastNameNotSetWarning.setVisible(false);
		lastNameNotSetWarning.setText("*");
		lastNameNotSetWarning.setForeground(Color.RED);
		lastNameNotSetWarning.setEditable(false);
		lastNameNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_lastNameNotSetWarning = new GridBagConstraints();
		gbc_lastNameNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_lastNameNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameNotSetWarning.gridx = 4;
		gbc_lastNameNotSetWarning.gridy = 1;
		VictimPanel.add(lastNameNotSetWarning, gbc_lastNameNotSetWarning);
		
		lastNameText = new JFormattedTextField();
		GridBagConstraints gbc_lastNameText = new GridBagConstraints();
		gbc_lastNameText.weightx = 0.8;
		gbc_lastNameText.anchor = GridBagConstraints.NORTH;
		gbc_lastNameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameText.insets = new Insets(0, 0, 5, 10);
		gbc_lastNameText.gridx = 5;
		gbc_lastNameText.gridy = 1;
		VictimPanel.add(lastNameText, gbc_lastNameText);
		
		addressLabel = new JLabel("Address:");
		GridBagConstraints gbc_addressLabel = new GridBagConstraints();
		gbc_addressLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_addressLabel.insets = leftInsetBumper;
		gbc_addressLabel.gridx = 0;
		gbc_addressLabel.gridy = 2;
		VictimPanel.add(addressLabel, gbc_addressLabel);
		addrNotSetWarning.setEditable(false);
		addrNotSetWarning.setText("*");
		addrNotSetWarning.setForeground(Color.RED);
		addrNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		addrNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_addrNotSetWarning = new GridBagConstraints();
		gbc_addrNotSetWarning.anchor = GridBagConstraints.SOUTHWEST;
		gbc_addrNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_addrNotSetWarning.gridx = 1;
		gbc_addrNotSetWarning.gridy = 2;
		VictimPanel.add(addrNotSetWarning, gbc_addrNotSetWarning);
		
		addressTextArea = new JTextArea();
		addressTextArea.setWrapStyleWord(true);
		addressTextArea.setLineWrap(true);
		GridBagConstraints gbc_addressTextArea = new GridBagConstraints();
		gbc_addressTextArea.fill = GridBagConstraints.BOTH;
		gbc_addressTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_addressTextArea.gridheight = 2;
		gbc_addressTextArea.gridx = 2;
		gbc_addressTextArea.gridy = 2;
		VictimPanel.add(addressTextArea, gbc_addressTextArea);
		
		sexLabel = new JLabel("Sex:");
		GridBagConstraints gbc_sexLabel = new GridBagConstraints();
		gbc_sexLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_sexLabel.insets = new Insets(0, 0, 5, 5);
		gbc_sexLabel.gridx = 3;
		gbc_sexLabel.gridy = 2;
		VictimPanel.add(sexLabel, gbc_sexLabel);
		
		sexNotSetWarning = new JTextPane();
		sexNotSetWarning.setEditable(false);
		sexNotSetWarning.setVisible(false);
		sexNotSetWarning.setText("*");
		sexNotSetWarning.setForeground(Color.RED);
		sexNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sexNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_sexNotSetWarning = new GridBagConstraints();
		gbc_sexNotSetWarning.anchor = GridBagConstraints.SOUTHWEST;
		gbc_sexNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_sexNotSetWarning.gridx = 4;
		gbc_sexNotSetWarning.gridy = 2;
		VictimPanel.add(sexNotSetWarning, gbc_sexNotSetWarning);
		
				
		sexCombo = new JComboBox();
		sexCombo.setModel(new DefaultComboBoxModel(new String[] {"<Select One>", "Male", "Female"}));
		GridBagConstraints gbc_sexCombo = new GridBagConstraints();
		gbc_sexCombo.anchor = GridBagConstraints.NORTH;
		gbc_sexCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexCombo.insets = new Insets(0, 0, 5, 10);
		gbc_sexCombo.gridx = 5;
		gbc_sexCombo.gridy = 2;
		VictimPanel.add(sexCombo, gbc_sexCombo);
		
		lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 3;
		gbc_lblTelephone.gridy = 3;
		VictimPanel.add(lblTelephone, gbc_lblTelephone);
		
		phoneNotSetWarning = new JTextPane();
		phoneNotSetWarning.setVisible(false);
		phoneNotSetWarning.setForeground(Color.RED);
		phoneNotSetWarning.setEditable(false);
		phoneNotSetWarning.setBackground(SystemColor.menu);
		phoneNotSetWarning.setText("*");
		GridBagConstraints gbc_phoneNotSetWarning = new GridBagConstraints();
		gbc_phoneNotSetWarning.anchor = GridBagConstraints.SOUTHWEST;
		gbc_phoneNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNotSetWarning.gridx = 4;
		gbc_phoneNotSetWarning.gridy = 3;
		VictimPanel.add(phoneNotSetWarning, gbc_phoneNotSetWarning);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 10);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 3;
		VictimPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		phoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_phoneAreaCode = new GridBagConstraints();
		gbc_phoneAreaCode.fill = GridBagConstraints.BOTH;
		gbc_phoneAreaCode.weightx = 0.2;
		gbc_phoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_phoneAreaCode.gridx = 0;
		gbc_phoneAreaCode.gridy = 0;
		panel_1.add(phoneAreaCode, gbc_phoneAreaCode);
		filter.setupTextField(phoneAreaCode, DocumentSizeFilter.NO, 3);
		phoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_phoneFirstThree = new GridBagConstraints();
		gbc_phoneFirstThree.fill = GridBagConstraints.BOTH;
		gbc_phoneFirstThree.weightx = 0.2;
		gbc_phoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_phoneFirstThree.gridx = 1;
		gbc_phoneFirstThree.gridy = 0;
		panel_1.add(phoneFirstThree, gbc_phoneFirstThree);
		filter.setupTextField(phoneFirstThree, DocumentSizeFilter.NO, 3);
		phoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_phoneLastFour = new GridBagConstraints();
		gbc_phoneLastFour.fill = GridBagConstraints.BOTH;
		gbc_phoneLastFour.weightx = 0.4;
		gbc_phoneLastFour.gridx = 2;
		gbc_phoneLastFour.gridy = 0;
		panel_1.add(phoneLastFour, gbc_phoneLastFour);
		filter.setupTextField(phoneLastFour, DocumentSizeFilter.NO, 4);
		
		dobLabel = new JLabel("DOB: ");
		GridBagConstraints gbc_dobLabel = new GridBagConstraints();
		gbc_dobLabel.weighty = 1.0;
		gbc_dobLabel.anchor = GridBagConstraints.EAST;
		gbc_dobLabel.insets = leftInsetBumper;
		gbc_dobLabel.gridx = 0;
		gbc_dobLabel.gridy = 4;
		VictimPanel.add(dobLabel, gbc_dobLabel);
		
		dobNotSetWarning = new JTextPane();
		dobNotSetWarning.setVisible(false);
		dobNotSetWarning.setEditable(false);
		dobNotSetWarning.setText("*");
		dobNotSetWarning.setForeground(Color.RED);
		dobNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dobNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_dobNotSetWarning = new GridBagConstraints();
		gbc_dobNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_dobNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_dobNotSetWarning.gridx = 1;
		gbc_dobNotSetWarning.gridy = 4;
		VictimPanel.add(dobNotSetWarning, gbc_dobNotSetWarning);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 4;
		VictimPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		dayText = new JTextField();
		GridBagConstraints gbc_dayText = new GridBagConstraints();
		gbc_dayText.fill = GridBagConstraints.BOTH;
		gbc_dayText.weightx = 0.2;
		gbc_dayText.insets = new Insets(0, 0, 0, 5);
		gbc_dayText.gridx = 0;
		gbc_dayText.gridy = 0;
		panel.add(dayText, gbc_dayText);
		dayText.setText("DD");
		dayText.setColumns(10);
		filter.setupTextField(dayText, DocumentSizeFilter.NO, 2);
		
		monthText = new JTextField();
		GridBagConstraints gbc_monthText = new GridBagConstraints();
		gbc_monthText.fill = GridBagConstraints.BOTH;
		gbc_monthText.weightx = 0.2;
		gbc_monthText.insets = new Insets(0, 0, 0, 5);
		gbc_monthText.gridx = 1;
		gbc_monthText.gridy = 0;
		panel.add(monthText, gbc_monthText);
		monthText.setText("MM");
		monthText.setColumns(10);
		filter.setupTextField(monthText, DocumentSizeFilter.NO, 2);
		
		yearText = new JTextField();
		GridBagConstraints gbc_yearText = new GridBagConstraints();
		gbc_yearText.fill = GridBagConstraints.BOTH;
		gbc_yearText.weightx = 0.4;
		gbc_yearText.gridx = 2;
		gbc_yearText.gridy = 0;
		panel.add(yearText, gbc_yearText);
		yearText.setText("YYYY");
		yearText.setColumns(10);
		filter.setupTextField(yearText, DocumentSizeFilter.NO, 4);
		
		ageLabel = new JLabel("Age:");
		GridBagConstraints gbc_ageLabel = new GridBagConstraints();
		gbc_ageLabel.anchor = GridBagConstraints.EAST;
		gbc_ageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ageLabel.gridx = 3;
		gbc_ageLabel.gridy = 4;
		VictimPanel.add(ageLabel, gbc_ageLabel);
		
		ageNotSetWarning = new JTextPane();
		ageNotSetWarning.setVisible(false);
		ageNotSetWarning.setEditable(false);
		ageNotSetWarning.setText("*");
		ageNotSetWarning.setForeground(Color.RED);
		ageNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ageNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_ageNotSetWarning = new GridBagConstraints();
		gbc_ageNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_ageNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_ageNotSetWarning.gridx = 4;
		gbc_ageNotSetWarning.gridy = 4;
		VictimPanel.add(ageNotSetWarning, gbc_ageNotSetWarning);
		
		ageText = new JTextField();
		ageText.setColumns(10);
		filter.setupTextField(ageText, DocumentSizeFilter.NO, 3);
		GridBagConstraints gbc_ageText = new GridBagConstraints();
		gbc_ageText.fill = GridBagConstraints.HORIZONTAL;
		gbc_ageText.insets = new Insets(0, 0, 5, 10);
		gbc_ageText.gridx = 5;
		gbc_ageText.gridy = 4;
		VictimPanel.add(ageText, gbc_ageText);
		
		maritalStatusLabel = new JLabel("Marital Status:");
		GridBagConstraints gbc_maritalStatusLabel = new GridBagConstraints();
		gbc_maritalStatusLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_maritalStatusLabel.insets = new Insets(5, 10, 15, 5);
		gbc_maritalStatusLabel.gridx = 0;
		gbc_maritalStatusLabel.gridy = 5;
		VictimPanel.add(maritalStatusLabel, gbc_maritalStatusLabel);
		
		maritalStatusNotSetWarning = new JTextPane();
		maritalStatusNotSetWarning.setEditable(false);
		maritalStatusNotSetWarning.setVisible(false);
		maritalStatusNotSetWarning.setText("*");
		maritalStatusNotSetWarning.setForeground(Color.RED);
		maritalStatusNotSetWarning.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maritalStatusNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_maritalStatusNotSetWarning = new GridBagConstraints();
		gbc_maritalStatusNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_maritalStatusNotSetWarning.insets = new Insets(0, 0, 0, 5);
		gbc_maritalStatusNotSetWarning.gridx = 1;
		gbc_maritalStatusNotSetWarning.gridy = 5;
		VictimPanel.add(maritalStatusNotSetWarning, gbc_maritalStatusNotSetWarning);
		
		maritalStatusText = new JTextField();
		maritalStatusText.setColumns(10);
		filter.setupTextField(maritalStatusText, DocumentSizeFilter.CHAR, 10);
		GridBagConstraints gbc_maritalStatusText = new GridBagConstraints();
		gbc_maritalStatusText.insets = new Insets(0, 0, 0, 5);
		gbc_maritalStatusText.anchor = GridBagConstraints.NORTH;
		gbc_maritalStatusText.fill = GridBagConstraints.HORIZONTAL;
		gbc_maritalStatusText.gridx = 2;
		gbc_maritalStatusText.gridy = 5;
		VictimPanel.add(maritalStatusText, gbc_maritalStatusText);
		
				
				DisabilityPanel = new JPanel();
				DisabilityPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				GridBagConstraints gbc_DisabilityPanel = new GridBagConstraints();
				gbc_DisabilityPanel.weightx = 1.0;
				gbc_DisabilityPanel.weighty = 0.1;
				gbc_DisabilityPanel.fill = GridBagConstraints.BOTH;
				gbc_DisabilityPanel.insets = new Insets(0, 10, 5, 10);
				gbc_DisabilityPanel.gridx = 0;
				gbc_DisabilityPanel.gridy = 1;
				add(DisabilityPanel, gbc_DisabilityPanel);
				GridBagLayout gbl_DisabilityPanel = new GridBagLayout();
				gbl_DisabilityPanel.columnWidths = new int[]{210, 0, 471, 0};
				gbl_DisabilityPanel.rowHeights = new int[]{22, 125, 0};
				gbl_DisabilityPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_DisabilityPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				DisabilityPanel.setLayout(gbl_DisabilityPanel);
				
				disabilityLabel = new JLabel("Disability: (check as apply)");
				disabilityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
				GridBagConstraints gbc_disabilityLabel = new GridBagConstraints();
				gbc_disabilityLabel.anchor = GridBagConstraints.SOUTHWEST;
				gbc_disabilityLabel.insets = topInsetBumper;
				gbc_disabilityLabel.gridx = 0;
				gbc_disabilityLabel.gridy = 0;
				DisabilityPanel.add(disabilityLabel, gbc_disabilityLabel);
				
				disabilityNotSetWarning = new JTextPane();
				disabilityNotSetWarning.setVisible(false);
				disabilityNotSetWarning.setEditable(false);
				disabilityNotSetWarning.setForeground(Color.RED);
				disabilityNotSetWarning.setText("*");
				disabilityNotSetWarning.setBackground(SystemColor.menu);
				GridBagConstraints gbc_disabilityNotSetWarning = new GridBagConstraints();
				gbc_disabilityNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
				gbc_disabilityNotSetWarning.insets = new Insets(0, 0, 5, 5);
				gbc_disabilityNotSetWarning.gridx = 1;
				gbc_disabilityNotSetWarning.gridy = 0;
				DisabilityPanel.add(disabilityNotSetWarning, gbc_disabilityNotSetWarning);
				
				disabilityCbPanel = new JPanel();
				GridBagLayout gbl_disabilityCbPanel = new GridBagLayout();
				gbl_disabilityCbPanel.columnWidths = new int[] {100, 100, 100, 90};
				gbl_disabilityCbPanel.rowHeights = new int[] {20, 20, 20, 20};
				gbl_disabilityCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
				gbl_disabilityCbPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
				disabilityCbPanel.setLayout(gbl_disabilityCbPanel);
				
				chckbxMentalRetardation = new JCheckBox("Mental Retardation");
				GridBagConstraints gbc_chckbxMentalRetardation = new GridBagConstraints();
				gbc_chckbxMentalRetardation.anchor = GridBagConstraints.WEST;
				gbc_chckbxMentalRetardation.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMentalRetardation.gridx = 0;
				gbc_chckbxMentalRetardation.gridy = 0;
				disabilityCbPanel.add(chckbxMentalRetardation, gbc_chckbxMentalRetardation);
				
				chckbxMobility = new JCheckBox("Mobility");
				GridBagConstraints gbc_chckbxMobility = new GridBagConstraints();
				gbc_chckbxMobility.anchor = GridBagConstraints.WEST;
				gbc_chckbxMobility.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxMobility.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMobility.gridx = 2;
				gbc_chckbxMobility.gridy = 0;
				disabilityCbPanel.add(chckbxMobility, gbc_chckbxMobility);
				
				chckbxVisual = new JCheckBox("Visual");
				GridBagConstraints gbc_chckbxVisual = new GridBagConstraints();
				gbc_chckbxVisual.anchor = GridBagConstraints.WEST;
				gbc_chckbxVisual.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxVisual.insets = new Insets(0, 0, 5, 0);
				gbc_chckbxVisual.gridx = 4;
				gbc_chckbxVisual.gridy = 0;
				disabilityCbPanel.add(chckbxVisual, gbc_chckbxVisual);
				chckbxMultipleSclerosis = new JCheckBox("Multiple Sclerosis");
				GridBagConstraints gbc_chckbxMultipleSclerosis = new GridBagConstraints();
				gbc_chckbxMultipleSclerosis.anchor = GridBagConstraints.WEST;
				gbc_chckbxMultipleSclerosis.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMultipleSclerosis.gridx = 0;
				gbc_chckbxMultipleSclerosis.gridy = 1;
				disabilityCbPanel.add(chckbxMultipleSclerosis, gbc_chckbxMultipleSclerosis);
				chckbxMentalIllness = new JCheckBox("Mental Illness");
				GridBagConstraints gbc_chckbxMentalIllness = new GridBagConstraints();
				gbc_chckbxMentalIllness.anchor = GridBagConstraints.WEST;
				gbc_chckbxMentalIllness.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxMentalIllness.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMentalIllness.gridx = 2;
				gbc_chckbxMentalIllness.gridy = 1;
				disabilityCbPanel.add(chckbxMentalIllness, gbc_chckbxMentalIllness);
				chckbxDeafHard = new JCheckBox("Deaf / Hard of Hearing");
				GridBagConstraints gbc_chckbxDeafHard = new GridBagConstraints();
				gbc_chckbxDeafHard.anchor = GridBagConstraints.WEST;
				gbc_chckbxDeafHard.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxDeafHard.insets = new Insets(0, 0, 5, 0);
				gbc_chckbxDeafHard.gridx = 4;
				gbc_chckbxDeafHard.gridy = 1;
				disabilityCbPanel.add(chckbxDeafHard, gbc_chckbxDeafHard);
				chckbxCerebralPalsy = new JCheckBox("Cerebral Palsy");
				GridBagConstraints gbc_chckbxCerebralPalsy = new GridBagConstraints();
				gbc_chckbxCerebralPalsy.anchor = GridBagConstraints.WEST;
				gbc_chckbxCerebralPalsy.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxCerebralPalsy.gridx = 0;
				gbc_chckbxCerebralPalsy.gridy = 2;
				disabilityCbPanel.add(chckbxCerebralPalsy, gbc_chckbxCerebralPalsy);
				chckbxHeadInjury = new JCheckBox("Head Injury");
				GridBagConstraints gbc_chckbxHeadInjury = new GridBagConstraints();
				gbc_chckbxHeadInjury.anchor = GridBagConstraints.WEST;
				gbc_chckbxHeadInjury.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxHeadInjury.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxHeadInjury.gridx = 2;
				gbc_chckbxHeadInjury.gridy = 2;
				disabilityCbPanel.add(chckbxHeadInjury, gbc_chckbxHeadInjury);
				chckbxSeizures = new JCheckBox("Seizures");
				GridBagConstraints gbc_chckbxSeizures = new GridBagConstraints();
				gbc_chckbxSeizures.anchor = GridBagConstraints.WEST;
				gbc_chckbxSeizures.fill = GridBagConstraints.VERTICAL;
				gbc_chckbxSeizures.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxSeizures.gridx = 0;
				gbc_chckbxSeizures.gridy = 3;
				disabilityCbPanel.add(chckbxSeizures, gbc_chckbxSeizures);
				chckbxOtherspecify = new JCheckBox("Other (specify)");
				GridBagConstraints gbc_chckbxOtherspecify = new GridBagConstraints();
				gbc_chckbxOtherspecify.anchor = GridBagConstraints.WEST;
				gbc_chckbxOtherspecify.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxOtherspecify.gridx = 2;
				gbc_chckbxOtherspecify.gridy = 3;
				disabilityCbPanel.add(chckbxOtherspecify, gbc_chckbxOtherspecify);
				
				disabilityOtherTextField = new JFormattedTextField();
				filter.setupTextField(disabilityOtherTextField, DocumentSizeFilter.ANY, 30);
				GridBagConstraints gbc_disabilityOtherTextField = new GridBagConstraints();
				gbc_disabilityOtherTextField.fill = GridBagConstraints.BOTH;
				gbc_disabilityOtherTextField.gridx = 3;
				gbc_disabilityOtherTextField.gridy = 3;
				disabilityCbPanel.add(disabilityOtherTextField, gbc_disabilityOtherTextField);
				GridBagConstraints gbc_disabilityCbPanel = new GridBagConstraints();
				gbc_disabilityCbPanel.weightx = 1.0;
				gbc_disabilityCbPanel.fill = GridBagConstraints.VERTICAL;
				gbc_disabilityCbPanel.gridwidth = 3;
				gbc_disabilityCbPanel.gridx = 0;
				gbc_disabilityCbPanel.gridy = 1;
				DisabilityPanel.add(disabilityCbPanel, gbc_disabilityCbPanel);
		
		ethnicityPanel = new JPanel();
		ethnicityPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_ethnicityPanel = new GridBagConstraints();
		gbc_ethnicityPanel.weightx = 1.0;
		gbc_ethnicityPanel.weighty = 0.1;
		gbc_ethnicityPanel.fill = GridBagConstraints.BOTH;
		gbc_ethnicityPanel.insets = new Insets(0, 10, 5, 10);
		gbc_ethnicityPanel.gridx = 0;
		gbc_ethnicityPanel.gridy = 2;
		add(ethnicityPanel, gbc_ethnicityPanel);
		GridBagLayout gbl_ethnicityPanel = new GridBagLayout();
		gbl_ethnicityPanel.columnWidths = new int[]{126, 0, 46, 0};
		gbl_ethnicityPanel.rowHeights = new int[]{22, 95, 0};
		gbl_ethnicityPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_ethnicityPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		ethnicityPanel.setLayout(gbl_ethnicityPanel);
		
		ethnicityLabel = new JLabel("Client's Ethnicity");
		ethnicityLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_ethnicityLabel = new GridBagConstraints();
		gbc_ethnicityLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_ethnicityLabel.insets = topInsetBumper;
		gbc_ethnicityLabel.gridx = 0;
		gbc_ethnicityLabel.gridy = 0;
		ethnicityPanel.add(ethnicityLabel, gbc_ethnicityLabel);
		
		ethnicityNotSetWarning = new JTextPane();
		ethnicityNotSetWarning.setVisible(false);
		ethnicityNotSetWarning.setText("*");
		ethnicityNotSetWarning.setForeground(Color.RED);
		ethnicityNotSetWarning.setEditable(false);
		ethnicityNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_ethnicityNotSetWarning = new GridBagConstraints();
		gbc_ethnicityNotSetWarning.anchor = GridBagConstraints.NORTHWEST;
		gbc_ethnicityNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_ethnicityNotSetWarning.gridx = 1;
		gbc_ethnicityNotSetWarning.gridy = 0;
		ethnicityPanel.add(ethnicityNotSetWarning, gbc_ethnicityNotSetWarning);
		
		ethnicityCbPanel = new JPanel();
		GridBagLayout gbl_ethnicityCbPanel = new GridBagLayout();
		gbl_ethnicityCbPanel.columnWidths = new int[] {100, 100, 100, 100, 100};
		gbl_ethnicityCbPanel.rowHeights = new int[]{20, 20, 20};
		gbl_ethnicityCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_ethnicityCbPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		ethnicityCbPanel.setLayout(gbl_ethnicityCbPanel);
		
		caucasianCheckBox = new JCheckBox("Caucasian");
		GridBagConstraints gbc_caucasianCheckBox = new GridBagConstraints();
		gbc_caucasianCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_caucasianCheckBox.insets = leftInsetBumper;
		gbc_caucasianCheckBox.gridx = 0;
		gbc_caucasianCheckBox.gridy = 0;
		ethnicityCbPanel.add(caucasianCheckBox, gbc_caucasianCheckBox);
		nativeAmericanCheckBox = new JCheckBox("Native American");
		GridBagConstraints gbc_nativeAmericanCheckBox = new GridBagConstraints();
		gbc_nativeAmericanCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_nativeAmericanCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_nativeAmericanCheckBox.gridx = 2;
		gbc_nativeAmericanCheckBox.gridy = 0;
		ethnicityCbPanel.add(nativeAmericanCheckBox, gbc_nativeAmericanCheckBox);
		africanAmericanCheckBox = new JCheckBox("African American");
		GridBagConstraints gbc_africanAmericanCheckBox = new GridBagConstraints();
		gbc_africanAmericanCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_africanAmericanCheckBox.insets = leftInsetBumper;
		gbc_africanAmericanCheckBox.gridx = 0;
		gbc_africanAmericanCheckBox.gridy = 1;
		ethnicityCbPanel.add(africanAmericanCheckBox, gbc_africanAmericanCheckBox);
		asianCheckBox = new JCheckBox("Asian");
		GridBagConstraints gbc_asianCheckBox = new GridBagConstraints();
		gbc_asianCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_asianCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_asianCheckBox.gridx = 2;
		gbc_asianCheckBox.gridy = 1;
		ethnicityCbPanel.add(asianCheckBox, gbc_asianCheckBox);
		hispanicCheckBox = new JCheckBox("Hispanic");
		GridBagConstraints gbc_hispanicCheckBox = new GridBagConstraints();
		gbc_hispanicCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_hispanicCheckBox.insets = leftInsetBumper;
		gbc_hispanicCheckBox.gridx = 0;
		gbc_hispanicCheckBox.gridy = 2;
		ethnicityCbPanel.add(hispanicCheckBox, gbc_hispanicCheckBox);
		otherEthnicityCheckBox = new JCheckBox("Other (specify)");
		GridBagConstraints gbc_otherEthnicityCheckBox = new GridBagConstraints();
		gbc_otherEthnicityCheckBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_otherEthnicityCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_otherEthnicityCheckBox.gridx = 2;
		gbc_otherEthnicityCheckBox.gridy = 2;
		ethnicityCbPanel.add(otherEthnicityCheckBox, gbc_otherEthnicityCheckBox);
		otherEthnicityTextField = new JFormattedTextField();
		GridBagConstraints gbc_otherEthnicityTextField = new GridBagConstraints();
		gbc_otherEthnicityTextField.gridwidth = 2;
		gbc_otherEthnicityTextField.fill = GridBagConstraints.BOTH;
		gbc_otherEthnicityTextField.gridx = 3;
		gbc_otherEthnicityTextField.gridy = 2;
		ethnicityCbPanel.add(otherEthnicityTextField, gbc_otherEthnicityTextField);
		GridBagConstraints gbc_ethnicityCbPanel = new GridBagConstraints();
		gbc_ethnicityCbPanel.gridwidth = 3;
		gbc_ethnicityCbPanel.insets = new Insets(0, 0, 0, 10);
		gbc_ethnicityCbPanel.weightx = 1.0;
		gbc_ethnicityCbPanel.fill = GridBagConstraints.VERTICAL;
		gbc_ethnicityCbPanel.gridx = 0;
		gbc_ethnicityCbPanel.gridy = 1;
		ethnicityPanel.add(ethnicityCbPanel, gbc_ethnicityCbPanel);
		
		ComNeedsPanel = new JPanel();
		ComNeedsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_ComNeedsPanel = new GridBagConstraints();
		gbc_ComNeedsPanel.weightx = 1.0;
		gbc_ComNeedsPanel.weighty = 0.1;
		gbc_ComNeedsPanel.fill = GridBagConstraints.BOTH;
		gbc_ComNeedsPanel.gridx = 0;
		gbc_ComNeedsPanel.gridy = 3;
		gbc_ComNeedsPanel.insets = new Insets(0, 10, 10, 10);
		add(ComNeedsPanel, gbc_ComNeedsPanel);
		GridBagLayout gbl_ComNeedsPanel = new GridBagLayout();
		gbl_ComNeedsPanel.columnWidths = new int[]{170, 14, 422, 0};
		gbl_ComNeedsPanel.rowHeights = new int[]{29, 57, 0};
		gbl_ComNeedsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_ComNeedsPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		ComNeedsPanel.setLayout(gbl_ComNeedsPanel);
		
		communicationNeedsLabel = new JLabel("Communication Needs:");
		communicationNeedsLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_communicationNeedsLabel = new GridBagConstraints();
		gbc_communicationNeedsLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_communicationNeedsLabel.insets = topInsetBumper;
		gbc_communicationNeedsLabel.gridy = 0;
		ComNeedsPanel.add(communicationNeedsLabel, gbc_communicationNeedsLabel);
		
		comNotSetWarning = new JTextPane();
		comNotSetWarning.setBackground(SystemColor.menu);
		comNotSetWarning.setEditable(false);
		comNotSetWarning.setForeground(Color.RED);
		comNotSetWarning.setText("*");
		comNotSetWarning.setVisible(false);
		GridBagConstraints gbc_comNotSetWarning = new GridBagConstraints();
		gbc_comNotSetWarning.anchor = GridBagConstraints.WEST;
		gbc_comNotSetWarning.fill = GridBagConstraints.VERTICAL;
		gbc_comNotSetWarning.insets = new Insets(0, 0, 5, 5);
		gbc_comNotSetWarning.gridx = 1;
		gbc_comNotSetWarning.gridy = 0;
		ComNeedsPanel.add(comNotSetWarning, gbc_comNotSetWarning);
		
		comNeedsCbPanel = new JPanel();
		GridBagLayout gbl_comNeedsCbPanel = new GridBagLayout();
		gbl_comNeedsCbPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_comNeedsCbPanel.rowHeights = new int[] {30};
		gbl_comNeedsCbPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_comNeedsCbPanel.rowWeights = new double[]{0.0};
		comNeedsCbPanel.setLayout(gbl_comNeedsCbPanel);
		
		ttyCheckBox = new JCheckBox("TTY");
		GridBagConstraints gbc_ttyCheckBox = new GridBagConstraints();
		gbc_ttyCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_ttyCheckBox.gridx = 0;
		gbc_ttyCheckBox.gridy = 0;
		comNeedsCbPanel.add(ttyCheckBox, gbc_ttyCheckBox);
		
		signInterCheckBox = new JCheckBox("Sign Interpreter");
		GridBagConstraints gbc_signInterCheckBox = new GridBagConstraints();
		gbc_signInterCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_signInterCheckBox.gridx = 1;
		gbc_signInterCheckBox.gridy = 0;
		comNeedsCbPanel.add(signInterCheckBox, gbc_signInterCheckBox);
		
		otherComNeedsCheckBox = new JCheckBox("Other (Specify):");
		GridBagConstraints gbc_otherComNeedsCheckBox = new GridBagConstraints();
		gbc_otherComNeedsCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_otherComNeedsCheckBox.gridx = 2;
		gbc_otherComNeedsCheckBox.gridy = 0;
		comNeedsCbPanel.add(otherComNeedsCheckBox, gbc_otherComNeedsCheckBox);
		
		otherComNeedsTextField = new JTextField();
		GridBagConstraints gbc_otherComNeedsTextField = new GridBagConstraints();
		gbc_otherComNeedsTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_otherComNeedsTextField.gridx = 3;
		gbc_otherComNeedsTextField.gridy = 0;
		comNeedsCbPanel.add(otherComNeedsTextField, gbc_otherComNeedsTextField);
		otherComNeedsTextField.setColumns(10);
		filter.setupTextField(otherComNeedsTextField, DocumentSizeFilter.AL_NO, 30);
		GridBagConstraints gbc_comNeedsCbPanel = new GridBagConstraints();
		gbc_comNeedsCbPanel.fill = GridBagConstraints.VERTICAL;
		gbc_comNeedsCbPanel.gridx = 2;
		gbc_comNeedsCbPanel.gridy = 1;
		ComNeedsPanel.add(comNeedsCbPanel, gbc_comNeedsCbPanel);
		
		for(int i=0; i<ethnicityCbPanel.getComponents().length; i++) {
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = new JCheckBox();
				myCb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				myCb.addItemListener(new ItemListener() {
					
					@Override
					public void itemStateChanged(ItemEvent event) {
						if((event.getStateChange() == ItemEvent.SELECTED) || (event.getStateChange() == ItemEvent.DESELECTED)) {
							toggleAllCheckBoxesInPanel(ethnicityCbPanel, event.getItem());
						}
						
					}
				});
			}
		}
		
	}

	/**
	 * Determines if the information entered at this stage (alleged victim input) is indeed
	 * valid and necessary information for the abuse report is not missing.
	 */
	@Override
	public boolean isValidInfo() {
		boolean disabilitySelected = false;
		boolean ethnicitySelected = false;
		boolean comNeedsSelected = false;
		boolean validInfo = true;
		

		int disabilityIndex = 0; // Need to get a sequential spot in the string.
		
		if(firstNameText.getText().equals("")){
			firstNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			firstNameNotSetWarning.setVisible(false);
		}
		if(lastNameText.getText().equals("")){
			lastNameNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			lastNameNotSetWarning.setVisible(false);
		}
		if(addressTextArea.getText().equals("")){
			addrNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			addrNotSetWarning.setVisible(false);
		}
		if(phoneAreaCode.getDocument().getLength() != 3 || phoneFirstThree.getDocument().getLength() != 3 || phoneLastFour.getDocument().getLength() != 4){
			phoneNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			phoneNotSetWarning.setVisible(false);
		}
		if(monthText.getText().equals("") || dayText.getText().equals("") || yearText.getText().equals("")){
			dobNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			dobNotSetWarning.setVisible(false);
		}
		if(sexCombo.getSelectedItem().equals(sexCombo.getItemAt(0))){
			sexNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			sexNotSetWarning.setVisible(false);
		}
		if(maritalStatusText.getText().equals("")){
			maritalStatusNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			maritalStatusNotSetWarning.setVisible(false);
		}
		if(ageText.getText().equals("")) {
			ageNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			ageNotSetWarning.setVisible(false);
		}
		
		// Confirm that a single disability is selected....
		for(int i=0; i<disabilityCbPanel.getComponentCount(); i++){
			if(disabilityCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) disabilityCbPanel.getComponent(i);
				if(cb.isSelected()) {
					disabilitySelected = true;
				}
			}
		}
		if(!disabilitySelected){
			disabilityNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			disabilityNotSetWarning.setVisible(false);
		}
			
		// Confirm that a single ethnicity is selected...
		for(int i=0; i<ethnicityCbPanel.getComponentCount(); i++){
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				if(cb.isSelected()) {
					ethnicitySelected = true;
				}
			}
		}
		if(!ethnicitySelected) {
			ethnicityNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			ethnicityNotSetWarning.setVisible(false);
		}
		
		// Iterate through comneeds panel to determine if something was set.
		// FIXME: How do we handle the textfield in "other?" Same goes for similar
		//        scenarios above.
		for(int i=0; i<comNeedsCbPanel.getComponentCount(); i++) {
			if(comNeedsCbPanel.getComponent(i) instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) comNeedsCbPanel.getComponent(i);
				if(cb.isSelected()) {
					comNeedsSelected = true;
				}
			}
		}
		if(!comNeedsSelected){
			comNotSetWarning.setVisible(true);
			validInfo = false;
		} else {
			comNotSetWarning.setVisible(false);
		}
		
		return validInfo;
	}

	@Override
	public Victim commitVictim(Victim victim) {
		int disabilityIndex  = 0; 
		int comNeedsIndex    = 0;
		
		victim.setFirstName(firstNameText.getText());
		victim.setLastName(lastNameText.getText());
		victim.setAddress(addressTextArea.getText());
		victim.setTelephone(phoneAreaCode.getText().concat(phoneFirstThree.getText().concat(phoneLastFour.getText())));
		victim.setFemale(sexCombo.getSelectedItem() == "Female");
		victim.setMale(sexCombo.getSelectedItem() == "Male");
		victim.setDateOfBirth(dayText.getText().concat("/").concat(monthText.getText().concat("/").concat(yearText.getText())));
		victim.setAge(ageText.getText());
		victim.setMaritalStatus(maritalStatusText.getText());
		
		// Get the names of each checkbox to determine the disability to add to string.
		for(int i=0; i<disabilityCbPanel.getComponentCount(); i++){
			if(disabilityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox) disabilityCbPanel.getComponent(i);
				if(myCb.isSelected()) {
					// Special case for the "other" option.
					if(!myCb.equals(chckbxOtherspecify)) {
						victim.setDisabilities(myCb.getText(), disabilityIndex++);
					} else {
						// Instead of grabbing text from the checkbox, grab it from the text field
						// when "other" is selected.
						victim.setDisabilities(disabilityOtherTextField.getText(), disabilityIndex++);
					}
				}
			}
		}
		
		// Disability and ethnicity are similar. If other is set, must take the other text field.
		for(int i=0; i<ethnicityCbPanel.getComponentCount(); i++){
			if(ethnicityCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox myCb = (JCheckBox) ethnicityCbPanel.getComponent(i);
				if(myCb.isSelected()) {
					// Special case for the "other" option.
					if(!myCb.equals(otherEthnicityCheckBox)) {
						victim.setEthnicity(myCb.getText());
					} else {
						// Instead of grabbing text from the checkbox, grab it from the text field
						// when "other" is selected.
						victim.setEthnicity(otherEthnicityTextField.getText());
					}
				}
			}
		}
		
		for(int i=0; i<comNeedsCbPanel.getComponentCount(); i++) {
			if(comNeedsCbPanel.getComponent(i) instanceof JCheckBox) {
				JCheckBox cb = (JCheckBox) comNeedsCbPanel.getComponent(i);
				if(cb.isSelected()) {
					// Special case for "other" option.
					if(!cb.equals(otherComNeedsCheckBox)) {
						victim.setComNeeds(cb.getText(), comNeedsIndex++);
					} else {
						victim.setComNeeds(otherComNeedsTextField.getText(), comNeedsIndex++);
					}
				}
			}
		}
		
		return victim;
	}

	
	/**
	 * Disables the checkboxes in this panel. First, a search is performed to determine if the textfield
	 * in this JPanel should be saved. If not, then all components are disabled. This forces
	 * the user to only select one checkbox per panel.
	 * @param container  - the panel to search for checkboxes.
	 * @param cb         - the checkbox to leave enabled.
	 */
	public void toggleAllCheckBoxesInPanel(Container container, Object cb){
		boolean enableText = false;
		if(cb.equals((JCheckBox) otherEthnicityCheckBox)){
			enableText = true;
		}
		for(int i=0; i<container.getComponents().length; i++){	
			// Disable all components in this panel.
			if(!container.getComponent(i).equals(cb)) {
				container.getComponent(i).setEnabled(!container.getComponent(i).isEnabled());
				// Check to see if the textfield should be saved and not disabled. This is only true 
				// when "other (please specify)" is selected.
				if((container.getComponent(i) instanceof JTextComponent) && enableText){
					container.getComponent(i).setEnabled(true);
				}
			}
		}
	}

	/**
	 * Not implemented by this class. VictimGUI only sets the victim object. 
	 */
	@Override
	public Reporter commitReporter(Reporter reporter) {

		return null;
	}

	/**
	 * Not implemented by this class. VictimGUI only sets the victim object.
	 */
	@Override
	public Abuser commitAbuser(Abuser abuser) {

		return null;
	}

	@Override
	public Guardian commitGuardian(Guardian guardian) {
		// TODO Auto-generated method stub
		return null;
	}
}
