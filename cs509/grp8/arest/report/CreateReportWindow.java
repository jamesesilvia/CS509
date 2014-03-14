package cs509.grp8.arest.report;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.GregorianCalendar;

import javax.swing.SpringLayout;

import com.ibm.icu.util.Calendar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CreateReportWindow {

	private JFrame arestFrame;
	private JFormattedTextField reporterNameText;
	private JFormattedTextField phoneAreaCode;
	private JFormattedTextField phoneFirstThree;
	private JFormattedTextField phoneLastFour;
	private JTextField reporterRelationship;
	
	private Calendar myCalendar;
	private JTextField maritalStatusField;
	private JTextField ageField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateReportWindow window = new CreateReportWindow();
					window.arestFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateReportWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		arestFrame = new JFrame();
		arestFrame.setTitle("AREST Abuse Report Creator");
		arestFrame.setForeground(Color.WHITE);
		arestFrame.setBounds(100, 100, 900, 740);
		arestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		arestFrame.setBounds(new Rectangle(new Dimension(1024, 768)));
		
		JPanel reporterPanel = new JPanel();
		reporterPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel victimPanel = new JPanel();
		victimPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		victimPanel.setPreferredSize(new Dimension(100,500));
		
		JPanel victimTitlePanel = new JPanel();
		victimTitlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		victimTitlePanel.setPreferredSize(new Dimension(50,50));
		
		JLabel victimName = new JLabel("Name:");
		
		JFormattedTextField victimNameText = new JFormattedTextField(createFormat("????????????????????????????????"));
		victimNameText.setToolTipText("Enter first 32 characters of your name.");
		victimNameText.setColumns(10);
		
		JLabel victimNameLabel = new JLabel("Address:");
		
		JTextArea victimAddressText = new JTextArea();
		victimAddressText.setToolTipText("Enter your address.");
		victimAddressText.setLineWrap(true);
		
		JLabel label_1 = new JLabel("Daytime Telephone:");
		
		JFormattedTextField victimPhoneAreaCode = new JFormattedTextField(createFormat("###"));;
		victimPhoneAreaCode.setToolTipText("Address code of phone number.");
		victimPhoneAreaCode.setColumns(10);
		
		JFormattedTextField victimPhoneFirstThree = new JFormattedTextField(createFormat("###"));
		victimPhoneFirstThree.setToolTipText("First three digits of phone number.");
		victimPhoneFirstThree.setColumns(10);
		
		JFormattedTextField victimPhoneLastFour = new JFormattedTextField(createFormat("###"));
		victimPhoneLastFour.setToolTipText("Last four digits of phone number.");
		victimPhoneLastFour.setColumns(10);
		
		JLabel victimSex = new JLabel("Sex:");
		
		JComboBox victimSexSelectorBox = new JComboBox();
		victimSexSelectorBox.setModel(new DefaultComboBoxModel(new String[] {"<Select One>", "Male", "Female"}));
		
		JLabel victimDateOfBirth = new JLabel("DOB:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		JComboBox comboBox_2 = new JComboBox(new String[] {"Year"});
		myCalendar.getInstance();
		System.out.println("Year is " + myCalendar.YEAR);
		
		maritalStatusField = new JTextField();
		maritalStatusField.setColumns(10);
		
		JLabel maritalStatusLabel = new JLabel("Marital Status");
		
		ageField = new JFormattedTextField(createFormat("###"));
		ageField.setColumns(10);
		
		JLabel ageLabel = new JLabel("Age:");
//		for(int i=0; i<myCalendar.getInstance();
//			comboBox_2.addItem(i);
//		}
		GroupLayout gl_victimPanel = new GroupLayout(victimPanel);
		gl_victimPanel.setHorizontalGroup(
			gl_victimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_victimPanel.createSequentialGroup()
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(victimTitlePanel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_victimPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_victimPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_victimPanel.createSequentialGroup()
									.addGap(37)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 97, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(victimPhoneAreaCode, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(victimPhoneFirstThree, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(victimPhoneLastFour, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(85))
								.addGroup(gl_victimPanel.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_victimPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_victimPanel.createSequentialGroup()
											.addComponent(victimNameLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(victimAddressText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_victimPanel.createSequentialGroup()
											.addComponent(victimName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(victimNameText, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_victimPanel.createSequentialGroup()
											.addGroup(gl_victimPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(victimSex)
												.addGroup(gl_victimPanel.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(ageLabel)))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_victimPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(victimSexSelectorBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_victimPanel.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_victimPanel.createSequentialGroup()
													.addComponent(victimDateOfBirth)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_victimPanel.createSequentialGroup()
													.addComponent(maritalStatusLabel)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(maritalStatusField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))))))
					.addGap(31))
		);
		gl_victimPanel.setVerticalGroup(
			gl_victimPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_victimPanel.createSequentialGroup()
					.addComponent(victimTitlePanel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(victimName)
						.addComponent(victimNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(victimNameLabel)
						.addComponent(victimAddressText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(victimPhoneAreaCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(victimPhoneLastFour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(victimPhoneFirstThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(victimSex)
						.addComponent(victimSexSelectorBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(victimDateOfBirth)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addGroup(gl_victimPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(maritalStatusField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(maritalStatusLabel)
						.addComponent(ageLabel)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		SpringLayout sl_victimTitlePanel = new SpringLayout();
		victimTitlePanel.setLayout(sl_victimTitlePanel);
		
		JLabel allegedVictimTitle = new JLabel("Alleged Victim:");
		sl_victimTitlePanel.putConstraint(SpringLayout.NORTH, allegedVictimTitle, -29, SpringLayout.SOUTH, victimTitlePanel);
		sl_victimTitlePanel.putConstraint(SpringLayout.WEST, allegedVictimTitle, 10, SpringLayout.WEST, victimTitlePanel);
		sl_victimTitlePanel.putConstraint(SpringLayout.SOUTH, allegedVictimTitle, -2, SpringLayout.SOUTH, victimTitlePanel);
		allegedVictimTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		victimTitlePanel.add(allegedVictimTitle);
		victimPanel.setLayout(gl_victimPanel);
		
		JPanel reporterTitlePanel = new JPanel();
		reporterTitlePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel reporterName = new JLabel("Name:");
		
		// Cut off at 32 characters
		reporterNameText = new JFormattedTextField(createFormat("????????????????????????????????"));
		reporterNameText.setToolTipText("Enter first 32 characters of your name.");
		reporterNameText.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		
		JTextArea reporterAddressText = new JTextArea();
		reporterAddressText.setToolTipText("Enter your address.");
		reporterAddressText.setLineWrap(true);
		
		JLabel reporterDaytimeTelephone = new JLabel("Daytime Telephone:");
		
		// Specify three digits for this field.
		phoneAreaCode = new JFormattedTextField(createFormat("###"));
		phoneAreaCode.setToolTipText("Address code of phone number.");
		phoneAreaCode.setColumns(10);
		
		// Specify three digits for this field.
		phoneFirstThree = new JFormattedTextField(createFormat("###"));
		phoneFirstThree.setToolTipText("First three digits of phone number.");
		phoneFirstThree.setColumns(10);
		
		// Specify four digits for this field.
		phoneLastFour = new JFormattedTextField(createFormat("####"));
		phoneLastFour.setToolTipText("Last four digits of phone number.");
		phoneLastFour.setColumns(10);
		
		JLabel reporterRelationshipToVictim = new JLabel("Relationship to Alleged Victim:");
		
		reporterRelationship = new JTextField();
		reporterRelationship.setColumns(10);
		
		JCheckBox reporterMandated = new JCheckBox("Mandated");
		
		JCheckBox reporterNonMandated = new JCheckBox("Non-Mandated");
		GroupLayout gl_reporterPanel = new GroupLayout(reporterPanel);
		gl_reporterPanel.setHorizontalGroup(
			gl_reporterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reporterPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_reporterPanel.createSequentialGroup()
							.addComponent(reporterName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reporterNameText, GroupLayout.PREFERRED_SIZE, 431, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_reporterPanel.createSequentialGroup()
							.addComponent(lblAddress)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(reporterAddressText, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_reporterPanel.createSequentialGroup()
							.addGroup(gl_reporterPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_reporterPanel.createSequentialGroup()
									.addComponent(reporterDaytimeTelephone)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_reporterPanel.createSequentialGroup()
									.addGroup(gl_reporterPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(reporterMandated)
										.addComponent(reporterRelationshipToVictim, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_reporterPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(reporterNonMandated)
										.addComponent(reporterRelationship, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 55, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
				.addGroup(gl_reporterPanel.createSequentialGroup()
					.addComponent(reporterTitlePanel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(407, Short.MAX_VALUE))
		);
		gl_reporterPanel.setVerticalGroup(
			gl_reporterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_reporterPanel.createSequentialGroup()
					.addComponent(reporterTitlePanel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(reporterName)
						.addComponent(reporterNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(reporterAddressText, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(reporterDaytimeTelephone)
						.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(reporterMandated)
						.addComponent(reporterNonMandated))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_reporterPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(reporterRelationshipToVictim)
						.addComponent(reporterRelationship, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5))
		);
		SpringLayout sl_reporterTitlePanel = new SpringLayout();
		reporterTitlePanel.setLayout(sl_reporterTitlePanel);
		
		JLabel reporterLabel = new JLabel("Reporter:");
		sl_reporterTitlePanel.putConstraint(SpringLayout.NORTH, reporterLabel, 7, SpringLayout.NORTH, reporterTitlePanel);
		sl_reporterTitlePanel.putConstraint(SpringLayout.WEST, reporterLabel, 10, SpringLayout.WEST, reporterTitlePanel);
		reporterLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reporterTitlePanel.add(reporterLabel);
		reporterPanel.setLayout(gl_reporterPanel);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(arestFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(158))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(reporterPanel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(victimPanel, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(7))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(reporterPanel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
						.addComponent(victimPanel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
					.addGap(302))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel abuserNames = new JLabel("Name(s):");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setToolTipText("Enter first 32 characters of your name.");
		formattedTextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(10, Short.MAX_VALUE)
							.addComponent(abuserNames)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(abuserNames)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(146, Short.MAX_VALUE))
		);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblAllegedAbuser = new JLabel("Alleged Abuser");
		lblAllegedAbuser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel_1.putConstraint(SpringLayout.WEST, lblAllegedAbuser, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblAllegedAbuser, -8, SpringLayout.SOUTH, panel_1);
		panel_1.add(lblAllegedAbuser);
		panel.setLayout(gl_panel);
		arestFrame.getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * Create the allowed text for a particular field.
	 * @param s
	 * @return
	 */
	protected MaskFormatter createFormat(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);	
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		
		return formatter;
		
	}
}
