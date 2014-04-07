package client.abuse_report.views.abuse_report;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import client.abuse_report.interfaces.CreateReportInterface;
import client.abuse_report.models.Abuser;
import client.abuse_report.models.Guardian;
import client.abuse_report.models.Reporter;
import client.abuse_report.models.Victim;
import javax.swing.JTextPane;
import java.awt.SystemColor;


public class GuardianGUI extends JPanel implements CreateReportInterface{

	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	private JTextField clientFirstName;
	private JTextField guardRelationship;
	
	
	/**
	 * Create the panel.
	 */
	public GuardianGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{204, 579, 0};
		gridBagLayout.rowHeights = new int[]{287, 282, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel guardPanel = new JPanel();
		guardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_guardPanel = new GridBagConstraints();
		gbc_guardPanel.insets = new Insets(10, 10, 5, 10);
		gbc_guardPanel.weightx = 0.5;
		gbc_guardPanel.fill = GridBagConstraints.BOTH;
		gbc_guardPanel.gridx = 0;
		gbc_guardPanel.gridy = 0;
		add(guardPanel, gbc_guardPanel);
		GridBagLayout gbl_guardPanel = new GridBagLayout();
		gbl_guardPanel.columnWidths = new int[]{105, 157, 0};
		gbl_guardPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_guardPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_guardPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		guardPanel.setLayout(gbl_guardPanel);
		
		JLabel guardLabel = new JLabel("Client's Guardian(s)  (if applicable):");
		guardLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_guardLabel = new GridBagConstraints();
		gbc_guardLabel.anchor = GridBagConstraints.WEST;
		gbc_guardLabel.gridwidth = 2;
		gbc_guardLabel.gridx = 0;
		gbc_guardLabel.gridy = 0;
		gbc_guardLabel.insets = new Insets(10, 10, 5, 0);
		guardPanel.add(guardLabel, gbc_guardLabel);
		
		JLabel guardFirstNameLabel = new JLabel("First Name:");
		GridBagConstraints gbc_guardFirstNameLabel = new GridBagConstraints();
		gbc_guardFirstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_guardFirstNameLabel.insets = leftInsetBumper;
		gbc_guardFirstNameLabel.gridx = 0;
		gbc_guardFirstNameLabel.gridy = 1;
		guardPanel.add(guardFirstNameLabel, gbc_guardFirstNameLabel);
		
		clientFirstName = new JTextField();
		GridBagConstraints gbc_clientFirstName = new GridBagConstraints();
		gbc_clientFirstName.weightx = 0.7;
		gbc_clientFirstName.insets = new Insets(0, 0, 5, 10);
		gbc_clientFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_clientFirstName.gridx = 1;
		gbc_clientFirstName.gridy = 1;
		guardPanel.add(clientFirstName, gbc_clientFirstName);
		clientFirstName.setColumns(10);
		
		JLabel guardLastNameLabel = new JLabel("Last Name:");
		GridBagConstraints gbc_guardLastNameLabel = new GridBagConstraints();
		gbc_guardLastNameLabel.weightx = 0.3;
		gbc_guardLastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_guardLastNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_guardLastNameLabel.gridx = 0;
		gbc_guardLastNameLabel.gridy = 2;
		guardPanel.add(guardLastNameLabel, gbc_guardLastNameLabel);
		
		JFormattedTextField guardLastName = new JFormattedTextField();
		GridBagConstraints gbc_guardLastName = new GridBagConstraints();
		gbc_guardLastName.weightx = 0.2;
		gbc_guardLastName.insets = new Insets(0, 0, 5, 10);
		gbc_guardLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardLastName.gridx = 1;
		gbc_guardLastName.gridy = 2;
		guardPanel.add(guardLastName, gbc_guardLastName);
		
		JLabel guardAddressLabel = new JLabel("Address:");
		GridBagConstraints gbc_guardAddressLabel = new GridBagConstraints();
		gbc_guardAddressLabel.anchor = GridBagConstraints.EAST;
		gbc_guardAddressLabel.insets = leftInsetBumper;
		gbc_guardAddressLabel.gridx = 0;
		gbc_guardAddressLabel.gridy = 3;
		guardPanel.add(guardAddressLabel, gbc_guardAddressLabel);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		guardPanel.add(scrollPane, gbc_scrollPane);
		
		JTextArea guardianAddress = new JTextArea();
		scrollPane.setViewportView(guardianAddress);
		
		JLabel guardRelationLabel = new JLabel("Relationship to Alleged Victim: ");
		GridBagConstraints gbc_guardRelationLabel = new GridBagConstraints();
		gbc_guardRelationLabel.anchor = GridBagConstraints.EAST;
		gbc_guardRelationLabel.insets = leftInsetBumper;
		gbc_guardRelationLabel.gridx = 0;
		gbc_guardRelationLabel.gridy = 5;
		guardPanel.add(guardRelationLabel, gbc_guardRelationLabel);
		
		guardRelationship = new JTextField();
		GridBagConstraints gbc_guardRelationship = new GridBagConstraints();
		gbc_guardRelationship.insets = new Insets(0, 0, 5, 10);
		gbc_guardRelationship.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardRelationship.gridx = 1;
		gbc_guardRelationship.gridy = 5;
		guardPanel.add(guardRelationship, gbc_guardRelationship);
		guardRelationship.setColumns(10);
		
		JLabel guardTelephone = new JLabel("Telephone:");
		GridBagConstraints gbc_guardTelephone = new GridBagConstraints();
		gbc_guardTelephone.anchor = GridBagConstraints.EAST;
		gbc_guardTelephone.insets = new Insets(5, 10, 0, 5);
		gbc_guardTelephone.gridx = 0;
		gbc_guardTelephone.gridy = 6;
		guardPanel.add(guardTelephone, gbc_guardTelephone);
		
		JPanel guardPhonePanel = new JPanel();
		GridBagConstraints gbc_guardPhonePanel = new GridBagConstraints();
		gbc_guardPhonePanel.fill = GridBagConstraints.BOTH;
		gbc_guardPhonePanel.gridx = 1;
		gbc_guardPhonePanel.gridy = 6;
		gbc_guardPhonePanel.insets = new Insets(0, 0, 0, 10);
		guardPanel.add(guardPhonePanel, gbc_guardPhonePanel);
		GridBagLayout gbl_guardPhonePanel = new GridBagLayout();
		gbl_guardPhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_guardPhonePanel.rowHeights = new int[]{0, 0};
		gbl_guardPhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_guardPhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		guardPhonePanel.setLayout(gbl_guardPhonePanel);
		
		JFormattedTextField guardPhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_guardPhoneAreaCode = new GridBagConstraints();
		gbc_guardPhoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_guardPhoneAreaCode.weightx = 0.3;
		gbc_guardPhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardPhoneAreaCode.gridx = 0;
		gbc_guardPhoneAreaCode.gridy = 0;
		guardPhonePanel.add(guardPhoneAreaCode, gbc_guardPhoneAreaCode);
		
		JFormattedTextField guardPhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_guardPhoneFirstThree = new GridBagConstraints();
		gbc_guardPhoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_guardPhoneFirstThree.weightx = 0.3;
		gbc_guardPhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardPhoneFirstThree.gridx = 1;
		gbc_guardPhoneFirstThree.gridy = 0;
		guardPhonePanel.add(guardPhoneFirstThree, gbc_guardPhoneFirstThree);
		
		JFormattedTextField guardPhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_guardPhoneLastFour = new GridBagConstraints();
		gbc_guardPhoneLastFour.weightx = 0.5;
		gbc_guardPhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_guardPhoneLastFour.gridx = 2;
		gbc_guardPhoneLastFour.gridy = 0;
		guardPhonePanel.add(guardPhoneLastFour, gbc_guardPhoneLastFour);
		
		JPanel collateralContactsPanel = new JPanel();
		collateralContactsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_collateralContactsPanel = new GridBagConstraints();
		gbc_collateralContactsPanel.weightx = 0.5;
		gbc_collateralContactsPanel.fill = GridBagConstraints.BOTH;
		gbc_collateralContactsPanel.gridx = 1;
		gbc_collateralContactsPanel.gridy = 0;
		gbc_collateralContactsPanel.insets = new Insets(10, 10, 5, 10);
		add(collateralContactsPanel, gbc_collateralContactsPanel);
		GridBagLayout gbl_collateralContactsPanel = new GridBagLayout();
		gbl_collateralContactsPanel.columnWidths = new int[]{0, 132, 109, 0};
		gbl_collateralContactsPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_collateralContactsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_collateralContactsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		collateralContactsPanel.setLayout(gbl_collateralContactsPanel);
		
		JLabel collContactLabel = new JLabel("Collateral Contacts:");
		collContactLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_collContactLabel = new GridBagConstraints();
		gbc_collContactLabel.anchor = GridBagConstraints.WEST;
		gbc_collContactLabel.gridwidth = 3;
		gbc_collContactLabel.gridx = 0;
		gbc_collContactLabel.gridy = 0;
		gbc_collContactLabel.insets = new Insets(10, 10, 5, 0);
		collateralContactsPanel.add(collContactLabel, gbc_collContactLabel);
		
		JLabel nameLabel = new JLabel("Name");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.WEST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 1;
		gbc_nameLabel.gridy = 1;
		collateralContactsPanel.add(nameLabel, gbc_nameLabel);
		
		JLabel phoneLabel = new JLabel("Telephone");
		GridBagConstraints gbc_phoneLabel = new GridBagConstraints();
		gbc_phoneLabel.anchor = GridBagConstraints.WEST;
		gbc_phoneLabel.weightx = 0.1;
		gbc_phoneLabel.insets = new Insets(0, 0, 5, 0);
		gbc_phoneLabel.gridx = 2;
		gbc_phoneLabel.gridy = 1;
		collateralContactsPanel.add(phoneLabel, gbc_phoneLabel);
		
		JLabel name1Label = new JLabel("1");
		GridBagConstraints gbc_name1Label = new GridBagConstraints();
		gbc_name1Label.anchor = GridBagConstraints.EAST;
		gbc_name1Label.insets = leftInsetBumper;
		gbc_name1Label.gridx = 0;
		gbc_name1Label.gridy = 2;
		collateralContactsPanel.add(name1Label, gbc_name1Label);
		
		JFormattedTextField collContact1 = new JFormattedTextField();
		GridBagConstraints gbc_collContact1 = new GridBagConstraints();
		gbc_collContact1.weightx = 0.5;
		gbc_collContact1.insets = new Insets(0, 0, 5, 100);
		gbc_collContact1.fill = GridBagConstraints.HORIZONTAL;
		gbc_collContact1.gridx = 1;
		gbc_collContact1.gridy = 2;
		collateralContactsPanel.add(collContact1, gbc_collContact1);
		
		JPanel cc1PhonePanel = new JPanel();
		GridBagConstraints gbc_cc1PhonePanel = new GridBagConstraints();
		gbc_cc1PhonePanel.insets = new Insets(0, 0, 5, 10);
		gbc_cc1PhonePanel.fill = GridBagConstraints.BOTH;
		gbc_cc1PhonePanel.gridx = 2;
		gbc_cc1PhonePanel.gridy = 2;
		collateralContactsPanel.add(cc1PhonePanel, gbc_cc1PhonePanel);
		GridBagLayout gbl_cc1PhonePanel = new GridBagLayout();
		gbl_cc1PhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_cc1PhonePanel.rowHeights = new int[]{0, 0};
		gbl_cc1PhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_cc1PhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		cc1PhonePanel.setLayout(gbl_cc1PhonePanel);
		
		JFormattedTextField ccPhone1AreaCode = new JFormattedTextField();
		GridBagConstraints gbc_ccPhone1AreaCode = new GridBagConstraints();
		gbc_ccPhone1AreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_ccPhone1AreaCode.weightx = 0.3;
		gbc_ccPhone1AreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_ccPhone1AreaCode.gridx = 0;
		gbc_ccPhone1AreaCode.gridy = 0;
		cc1PhonePanel.add(ccPhone1AreaCode, gbc_ccPhone1AreaCode);
		
		JFormattedTextField ccPhone1FirstThree = new JFormattedTextField();
		GridBagConstraints gbc_ccPhone1FirstThree = new GridBagConstraints();
		gbc_ccPhone1FirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_ccPhone1FirstThree.weightx = 0.3;
		gbc_ccPhone1FirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_ccPhone1FirstThree.gridx = 1;
		gbc_ccPhone1FirstThree.gridy = 0;
		cc1PhonePanel.add(ccPhone1FirstThree, gbc_ccPhone1FirstThree);
		
		JFormattedTextField ccPhone1LastFour = new JFormattedTextField();
		GridBagConstraints gbc_ccPhone1LastFour = new GridBagConstraints();
		gbc_ccPhone1LastFour.weightx = 0.5;
		gbc_ccPhone1LastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_ccPhone1LastFour.gridx = 2;
		gbc_ccPhone1LastFour.gridy = 0;
		cc1PhonePanel.add(ccPhone1LastFour, gbc_ccPhone1LastFour);
		
		JLabel name2Label = new JLabel("2");
		GridBagConstraints gbc_name2Label = new GridBagConstraints();
		gbc_name2Label.anchor = GridBagConstraints.EAST;
		gbc_name2Label.insets = leftInsetBumper;
		gbc_name2Label.gridx = 0;
		gbc_name2Label.gridy = 3;
		collateralContactsPanel.add(name2Label, gbc_name2Label);
		
		JFormattedTextField collContact2 = new JFormattedTextField();
		GridBagConstraints gbc_collContact2 = new GridBagConstraints();
		gbc_collContact2.insets = new Insets(0, 0, 5, 100);
		gbc_collContact2.fill = GridBagConstraints.HORIZONTAL;
		gbc_collContact2.gridx = 1;
		gbc_collContact2.gridy = 3;
		collateralContactsPanel.add(collContact2, gbc_collContact2);
		
		JPanel cc2PhonePanel = new JPanel();
		GridBagConstraints gbc_cc2PhonePanel = new GridBagConstraints();
		gbc_cc2PhonePanel.insets = new Insets(0, 0, 5, 10);
		gbc_cc2PhonePanel.fill = GridBagConstraints.BOTH;
		gbc_cc2PhonePanel.gridx = 2;
		gbc_cc2PhonePanel.gridy = 3;
		collateralContactsPanel.add(cc2PhonePanel, gbc_cc2PhonePanel);
		GridBagLayout gbl_cc2PhonePanel = new GridBagLayout();
		gbl_cc2PhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_cc2PhonePanel.rowHeights = new int[]{0, 0};
		gbl_cc2PhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_cc2PhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		cc2PhonePanel.setLayout(gbl_cc2PhonePanel);
		
		JFormattedTextField cc2PhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_cc2PhoneAreaCode = new GridBagConstraints();
		gbc_cc2PhoneAreaCode.weightx = 0.3;
		gbc_cc2PhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc2PhoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_cc2PhoneAreaCode.gridx = 0;
		gbc_cc2PhoneAreaCode.gridy = 0;
		cc2PhonePanel.add(cc2PhoneAreaCode, gbc_cc2PhoneAreaCode);
		
		JFormattedTextField cc2PhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_cc2PhoneFirstThree = new GridBagConstraints();
		gbc_cc2PhoneFirstThree.weightx = 0.3;
		gbc_cc2PhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc2PhoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_cc2PhoneFirstThree.gridx = 1;
		gbc_cc2PhoneFirstThree.gridy = 0;
		cc2PhonePanel.add(cc2PhoneFirstThree, gbc_cc2PhoneFirstThree);
		
		JFormattedTextField cc2PhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_cc2PhoneLastFour = new GridBagConstraints();
		gbc_cc2PhoneLastFour.weightx = 0.5;
		gbc_cc2PhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc2PhoneLastFour.gridx = 2;
		gbc_cc2PhoneLastFour.gridy = 0;
		cc2PhonePanel.add(cc2PhoneLastFour, gbc_cc2PhoneLastFour);
		
		JLabel name3Label = new JLabel("3");
		GridBagConstraints gbc_name3Label = new GridBagConstraints();
		gbc_name3Label.anchor = GridBagConstraints.EAST;
		gbc_name3Label.insets = leftInsetBumper;
		gbc_name3Label.gridx = 0;
		gbc_name3Label.gridy = 4;
		collateralContactsPanel.add(name3Label, gbc_name3Label);
		
		JFormattedTextField collContact3 = new JFormattedTextField();
		GridBagConstraints gbc_collContact3 = new GridBagConstraints();
		gbc_collContact3.insets = new Insets(0, 0, 5, 100);
		gbc_collContact3.fill = GridBagConstraints.HORIZONTAL;
		gbc_collContact3.gridx = 1;
		gbc_collContact3.gridy = 4;
		collateralContactsPanel.add(collContact3, gbc_collContact3);
		
		JPanel cc3PhonePanel = new JPanel();
		GridBagConstraints gbc_cc3PhonePanel = new GridBagConstraints();
		gbc_cc3PhonePanel.insets = new Insets(0, 0, 5, 10);
		gbc_cc3PhonePanel.fill = GridBagConstraints.BOTH;
		gbc_cc3PhonePanel.gridx = 2;
		gbc_cc3PhonePanel.gridy = 4;
		collateralContactsPanel.add(cc3PhonePanel, gbc_cc3PhonePanel);
		GridBagLayout gbl_cc3PhonePanel = new GridBagLayout();
		gbl_cc3PhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_cc3PhonePanel.rowHeights = new int[]{0, 0};
		gbl_cc3PhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_cc3PhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		cc3PhonePanel.setLayout(gbl_cc3PhonePanel);
		
		JFormattedTextField cc3PhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_cc3PhoneAreaCode = new GridBagConstraints();
		gbc_cc3PhoneAreaCode.weightx = 0.3;
		gbc_cc3PhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc3PhoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_cc3PhoneAreaCode.gridx = 0;
		gbc_cc3PhoneAreaCode.gridy = 0;
		cc3PhonePanel.add(cc3PhoneAreaCode, gbc_cc3PhoneAreaCode);
		
		JFormattedTextField cc3PhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_cc3PhoneFirstThree = new GridBagConstraints();
		gbc_cc3PhoneFirstThree.weightx = 0.3;
		gbc_cc3PhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc3PhoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_cc3PhoneFirstThree.gridx = 1;
		gbc_cc3PhoneFirstThree.gridy = 0;
		cc3PhonePanel.add(cc3PhoneFirstThree, gbc_cc3PhoneFirstThree);
		
		JFormattedTextField cc3PhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_cc3PhoneLastFour = new GridBagConstraints();
		gbc_cc3PhoneLastFour.weightx = 0.5;
		gbc_cc3PhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc3PhoneLastFour.gridx = 2;
		gbc_cc3PhoneLastFour.gridy = 0;
		cc3PhonePanel.add(cc3PhoneLastFour, gbc_cc3PhoneLastFour);
		
		JLabel name4Label = new JLabel("4");
		GridBagConstraints gbc_name4Label = new GridBagConstraints();
		gbc_name4Label.anchor = GridBagConstraints.EAST;
		gbc_name4Label.insets = leftInsetBumper;
		gbc_name4Label.gridx = 0;
		gbc_name4Label.gridy = 5;
		collateralContactsPanel.add(name4Label, gbc_name4Label);
		
		JFormattedTextField collContact4 = new JFormattedTextField();
		GridBagConstraints gbc_collContact4 = new GridBagConstraints();
		gbc_collContact4.insets = new Insets(0, 0, 5, 100);
		gbc_collContact4.fill = GridBagConstraints.HORIZONTAL;
		gbc_collContact4.gridx = 1;
		gbc_collContact4.gridy = 5;
		collateralContactsPanel.add(collContact4, gbc_collContact4);
		
		JPanel cc4PhonePanel = new JPanel();
		GridBagConstraints gbc_cc4PhonePanel = new GridBagConstraints();
		gbc_cc4PhonePanel.insets = new Insets(0, 0, 5, 10);
		gbc_cc4PhonePanel.fill = GridBagConstraints.BOTH;
		gbc_cc4PhonePanel.gridx = 2;
		gbc_cc4PhonePanel.gridy = 5;
		collateralContactsPanel.add(cc4PhonePanel, gbc_cc4PhonePanel);
		GridBagLayout gbl_cc4PhonePanel = new GridBagLayout();
		gbl_cc4PhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_cc4PhonePanel.rowHeights = new int[]{0, 0};
		gbl_cc4PhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_cc4PhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		cc4PhonePanel.setLayout(gbl_cc4PhonePanel);
		
		JFormattedTextField cc4PhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_cc4PhoneAreaCode = new GridBagConstraints();
		gbc_cc4PhoneAreaCode.weightx = 0.3;
		gbc_cc4PhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc4PhoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_cc4PhoneAreaCode.gridx = 0;
		gbc_cc4PhoneAreaCode.gridy = 0;
		cc4PhonePanel.add(cc4PhoneAreaCode, gbc_cc4PhoneAreaCode);
		
		JFormattedTextField cc4PhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_cc4PhoneFirstThree = new GridBagConstraints();
		gbc_cc4PhoneFirstThree.weightx = 0.3;
		gbc_cc4PhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc4PhoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_cc4PhoneFirstThree.gridx = 1;
		gbc_cc4PhoneFirstThree.gridy = 0;
		cc4PhonePanel.add(cc4PhoneFirstThree, gbc_cc4PhoneFirstThree);
		
		JFormattedTextField cc4PhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_cc4PhoneLastFour = new GridBagConstraints();
		gbc_cc4PhoneLastFour.weightx = 0.5;
		gbc_cc4PhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc4PhoneLastFour.gridx = 2;
		gbc_cc4PhoneLastFour.gridy = 0;
		cc4PhonePanel.add(cc4PhoneLastFour, gbc_cc4PhoneLastFour);
		
		JLabel name5Label = new JLabel("5");
		GridBagConstraints gbc_name5Label = new GridBagConstraints();
		gbc_name5Label.anchor = GridBagConstraints.EAST;
		gbc_name5Label.insets = new Insets(5, 10, 0, 5);
		gbc_name5Label.gridx = 0;
		gbc_name5Label.gridy = 6;
		collateralContactsPanel.add(name5Label, gbc_name5Label);
		
		JFormattedTextField collContact5 = new JFormattedTextField();
		GridBagConstraints gbc_collContact5 = new GridBagConstraints();
		gbc_collContact5.insets = new Insets(0, 0, 0, 100);
		gbc_collContact5.fill = GridBagConstraints.HORIZONTAL;
		gbc_collContact5.gridx = 1;
		gbc_collContact5.gridy = 6;
		collateralContactsPanel.add(collContact5, gbc_collContact5);
		
		JPanel cc5PhonePanel = new JPanel();
		GridBagConstraints gbc_cc5PhonePanel = new GridBagConstraints();
		gbc_cc5PhonePanel.fill = GridBagConstraints.BOTH;
		gbc_cc5PhonePanel.gridx = 2;
		gbc_cc5PhonePanel.gridy = 6;
		gbc_cc5PhonePanel.insets = new Insets(0, 0, 0, 10);
		collateralContactsPanel.add(cc5PhonePanel, gbc_cc5PhonePanel);
		GridBagLayout gbl_cc5PhonePanel = new GridBagLayout();
		gbl_cc5PhonePanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_cc5PhonePanel.rowHeights = new int[]{0, 0};
		gbl_cc5PhonePanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_cc5PhonePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		cc5PhonePanel.setLayout(gbl_cc5PhonePanel);
		
		JFormattedTextField cc5PhoneAreaCode = new JFormattedTextField();
		GridBagConstraints gbc_cc5PhoneAreaCode = new GridBagConstraints();
		gbc_cc5PhoneAreaCode.weightx = 0.3;
		gbc_cc5PhoneAreaCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc5PhoneAreaCode.insets = new Insets(0, 0, 0, 5);
		gbc_cc5PhoneAreaCode.gridx = 0;
		gbc_cc5PhoneAreaCode.gridy = 0;
		cc5PhonePanel.add(cc5PhoneAreaCode, gbc_cc5PhoneAreaCode);
		
		JFormattedTextField cc5PhoneFirstThree = new JFormattedTextField();
		GridBagConstraints gbc_cc5PhoneFirstThree = new GridBagConstraints();
		gbc_cc5PhoneFirstThree.weightx = 0.3;
		gbc_cc5PhoneFirstThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc5PhoneFirstThree.insets = new Insets(0, 0, 0, 5);
		gbc_cc5PhoneFirstThree.gridx = 1;
		gbc_cc5PhoneFirstThree.gridy = 0;
		cc5PhonePanel.add(cc5PhoneFirstThree, gbc_cc5PhoneFirstThree);
		
		JFormattedTextField cc5PhoneLastFour = new JFormattedTextField();
		GridBagConstraints gbc_cc5PhoneLastFour = new GridBagConstraints();
		gbc_cc5PhoneLastFour.weightx = 0.5;
		gbc_cc5PhoneLastFour.fill = GridBagConstraints.HORIZONTAL;
		gbc_cc5PhoneLastFour.gridx = 2;
		gbc_cc5PhoneLastFour.gridy = 0;
		cc5PhonePanel.add(cc5PhoneLastFour, gbc_cc5PhoneLastFour);
		
		JPanel descriptionPanel = new JPanel();
		GridBagConstraints gbc_descriptionPanel = new GridBagConstraints();
		gbc_descriptionPanel.weighty = 0.1;
		gbc_descriptionPanel.gridwidth = 2;
		gbc_descriptionPanel.insets = new Insets(5, 10, 10, 10);
		gbc_descriptionPanel.fill = GridBagConstraints.BOTH;
		gbc_descriptionPanel.gridx = 0;
		gbc_descriptionPanel.gridy = 1;
		add(descriptionPanel, gbc_descriptionPanel);
		GridBagLayout gbl_descriptionPanel = new GridBagLayout();
		gbl_descriptionPanel.columnWidths = new int[]{0, 0};
		gbl_descriptionPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_descriptionPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_descriptionPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		descriptionPanel.setLayout(gbl_descriptionPanel);
		
		JLabel descriptionLabel = new JLabel("Description - Please complete the following sections.");
		descriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.WEST;
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 0;
		gbc_descriptionLabel.insets = new Insets(10, 10, 5, 0);
		descriptionPanel.add(descriptionLabel, gbc_descriptionLabel);
		
		JPanel abuseDescriptionPanel = new JPanel();
		abuseDescriptionPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_abuseDescriptionPanel = new GridBagConstraints();
		gbc_abuseDescriptionPanel.weighty = 0.3;
		gbc_abuseDescriptionPanel.insets = new Insets(0, 0, 5, 0);
		gbc_abuseDescriptionPanel.fill = GridBagConstraints.BOTH;
		gbc_abuseDescriptionPanel.gridx = 0;
		gbc_abuseDescriptionPanel.gridy = 1;
		descriptionPanel.add(abuseDescriptionPanel, gbc_abuseDescriptionPanel);
		GridBagLayout gbl_abuseDescriptionPanel = new GridBagLayout();
		gbl_abuseDescriptionPanel.columnWidths = new int[]{0, 0, 0};
		gbl_abuseDescriptionPanel.rowHeights = new int[]{0, 0, 0};
		gbl_abuseDescriptionPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_abuseDescriptionPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		abuseDescriptionPanel.setLayout(gbl_abuseDescriptionPanel);
		
		JLabel allegedAbuseDescriptionLabel = new JLabel("1. In narrative form, please describe the alleged abuse: ");
		allegedAbuseDescriptionLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_allegedAbuseDescriptionLabel = new GridBagConstraints();
		gbc_allegedAbuseDescriptionLabel.gridx = 0;
		gbc_allegedAbuseDescriptionLabel.gridy = 0;
		gbc_allegedAbuseDescriptionLabel.insets = new Insets(10, 10, 5, 5);
		abuseDescriptionPanel.add(allegedAbuseDescriptionLabel, gbc_allegedAbuseDescriptionLabel);
		
		JTextPane allegedAbuseDescriptionNotSetWarning = new JTextPane();
		allegedAbuseDescriptionNotSetWarning.setBackground(SystemColor.menu);
		allegedAbuseDescriptionNotSetWarning.setEditable(false);
		allegedAbuseDescriptionNotSetWarning.setForeground(Color.RED);
		allegedAbuseDescriptionNotSetWarning.setText("*");
		GridBagConstraints gbc_allegedAbuseDescriptionNotSetWarning = new GridBagConstraints();
		gbc_allegedAbuseDescriptionNotSetWarning.insets = new Insets(0, 0, 5, 0);
		gbc_allegedAbuseDescriptionNotSetWarning.fill = GridBagConstraints.HORIZONTAL;
		gbc_allegedAbuseDescriptionNotSetWarning.gridx = 1;
		gbc_allegedAbuseDescriptionNotSetWarning.gridy = 0;
		abuseDescriptionPanel.add(allegedAbuseDescriptionNotSetWarning, gbc_allegedAbuseDescriptionNotSetWarning);
		
		JTextPane allegedAbuseDescriptionText = new JTextPane();
		GridBagConstraints gbc_allegedAbuseDescriptionText = new GridBagConstraints();
		gbc_allegedAbuseDescriptionText.weighty = 1.0;
		gbc_allegedAbuseDescriptionText.weightx = 1.0;
		gbc_allegedAbuseDescriptionText.gridwidth = 2;
		gbc_allegedAbuseDescriptionText.insets = new Insets(0, 10, 10, 10);
		gbc_allegedAbuseDescriptionText.fill = GridBagConstraints.BOTH;
		gbc_allegedAbuseDescriptionText.gridx = 0;
		gbc_allegedAbuseDescriptionText.gridy = 1;
		abuseDescriptionPanel.add(allegedAbuseDescriptionText, gbc_allegedAbuseDescriptionText);
		
		JPanel riskPanel = new JPanel();
		riskPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_riskPanel = new GridBagConstraints();
		gbc_riskPanel.weighty = 0.4;
		gbc_riskPanel.fill = GridBagConstraints.BOTH;
		gbc_riskPanel.gridx = 0;
		gbc_riskPanel.gridy = 2;
		descriptionPanel.add(riskPanel, gbc_riskPanel);
		GridBagLayout gbl_riskPanel = new GridBagLayout();
		gbl_riskPanel.columnWidths = new int[]{0, 0, 0};
		gbl_riskPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_riskPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_riskPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		riskPanel.setLayout(gbl_riskPanel);
		
		JLabel riskLabel = new JLabel("2. Please describe the level of risk to the alleged victim, including his/her current physical and emotional state:");
		riskLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_riskLabel = new GridBagConstraints();
		gbc_riskLabel.insets = new Insets(10, 10, 5, 5);
		gbc_riskLabel.gridx = 0;
		gbc_riskLabel.gridy = 0;
		riskPanel.add(riskLabel, gbc_riskLabel);
		
		JTextPane riskNotSetWarning = new JTextPane();
		riskNotSetWarning.setText("*");
		riskNotSetWarning.setForeground(Color.RED);
		riskNotSetWarning.setEditable(false);
		riskNotSetWarning.setBackground(SystemColor.menu);
		GridBagConstraints gbc_riskNotSetWarning = new GridBagConstraints();
		gbc_riskNotSetWarning.fill = GridBagConstraints.HORIZONTAL;
		gbc_riskNotSetWarning.insets = new Insets(0, 0, 5, 0);
		gbc_riskNotSetWarning.gridx = 1;
		gbc_riskNotSetWarning.gridy = 0;
		riskPanel.add(riskNotSetWarning, gbc_riskNotSetWarning);
		
		JTextPane riskText = new JTextPane();
		GridBagConstraints gbc_riskText = new GridBagConstraints();
		gbc_riskText.weighty = 1.0;
		gbc_riskText.weightx = 1.0;
		gbc_riskText.insets = new Insets(0, 10, 10, 10);
		gbc_riskText.fill = GridBagConstraints.BOTH;
		gbc_riskText.gridwidth = 2;
		gbc_riskText.gridx = 0;
		gbc_riskText.gridy = 2;
		riskPanel.add(riskText, gbc_riskText);

	}


	@Override
	public boolean isValidInfo() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Reporter commitReporter(Reporter reporter) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Abuser commitAbuser(Abuser abuser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Victim commitVictim(Victim victim) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Guardian commitGuardian(Guardian guardian) {
		// TODO Auto-generated method stub
		return null;
	}

}
