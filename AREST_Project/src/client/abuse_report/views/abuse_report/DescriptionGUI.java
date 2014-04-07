package client.abuse_report.views.abuse_report;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class DescriptionGUI extends JPanel {

	// Bumper on left.
	private Insets leftInsetBumper = new Insets(5, 10, 5, 5);
	
	// Bumper on top.
	private Insets topInsetBumper = new Insets(10, 10, 5, 5); 
	
	
	/**
	 * Create the panel.
	 */
	public DescriptionGUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{242, 149, 283, 102, 138, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel injuryPanel = new JPanel();
		injuryPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_injuryPanel = new GridBagConstraints();
		gbc_injuryPanel.insets = new Insets(10, 10, 5, 10);
		gbc_injuryPanel.fill = GridBagConstraints.BOTH;
		gbc_injuryPanel.gridx = 0;
		gbc_injuryPanel.gridy = 0;
		add(injuryPanel, gbc_injuryPanel);
		GridBagLayout gbl_injuryPanel = new GridBagLayout();
		gbl_injuryPanel.columnWidths = new int[]{0, 0};
		gbl_injuryPanel.rowHeights = new int[]{0, 0, 0};
		gbl_injuryPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_injuryPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		injuryPanel.setLayout(gbl_injuryPanel);
		
		JLabel injuryLabel = new JLabel("3. Please list any resulting injuries:");
		injuryLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_injuryLabel = new GridBagConstraints();
		gbc_injuryLabel.anchor = GridBagConstraints.WEST;
		gbc_injuryLabel.gridx = 0;
		gbc_injuryLabel.gridy = 0;
		gbc_injuryLabel.insets = new Insets(10, 10, 5, 0);
		injuryPanel.add(injuryLabel, gbc_injuryLabel);
		
		JTextArea injuryText = new JTextArea();
		injuryText.setLineWrap(true);
		GridBagConstraints gbc_injuryText = new GridBagConstraints();
		gbc_injuryText.weighty = 0.1;
		gbc_injuryText.weightx = 1.0;
		gbc_injuryText.fill = GridBagConstraints.BOTH;
		gbc_injuryText.gridx = 0;
		gbc_injuryText.gridy = 1;
		gbc_injuryText.insets = new Insets(0, 10, 10, 10);
		injuryPanel.add(injuryText, gbc_injuryText);
		
		JPanel witnessPanel = new JPanel();
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
		
		JLabel witnessLabel = new JLabel("4. Please list witnesses, if any, including daytime phone numbers: ");
		witnessLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_witnessLabel = new GridBagConstraints();
		gbc_witnessLabel.anchor = GridBagConstraints.WEST;
		gbc_witnessLabel.gridx = 0;
		gbc_witnessLabel.gridy = 0;
		gbc_witnessLabel.insets = new Insets(10, 10, 5, 0);
		witnessPanel.add(witnessLabel, gbc_witnessLabel);
		
		JTextArea witnessText = new JTextArea();
		witnessText.setLineWrap(true);
		GridBagConstraints gbc_witnessText = new GridBagConstraints();
		gbc_witnessText.weighty = 0.1;
		gbc_witnessText.weightx = 1.0;
		gbc_witnessText.fill = GridBagConstraints.BOTH;
		gbc_witnessText.gridx = 0;
		gbc_witnessText.gridy = 1;
		gbc_witnessText.insets = new Insets(0, 10, 10, 10);
		witnessPanel.add(witnessText, gbc_witnessText);
		
		JPanel relationshipPanel = new JPanel();
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
		
		JLabel relationshipLabel = new JLabel("5. Please describe the caregiver relationship between the alleged abuser and the alleged victim.");
		relationshipLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_relationshipLabel = new GridBagConstraints();
		gbc_relationshipLabel.anchor = GridBagConstraints.WEST;
		gbc_relationshipLabel.gridx = 0;
		gbc_relationshipLabel.gridy = 0;
		gbc_relationshipLabel.insets = new Insets(10, 10, 5, 0);
		relationshipPanel.add(relationshipLabel, gbc_relationshipLabel);
		
		JLabel assistanceLabel = new JLabel("(What assistance, if any, does the alleged abuser provide to the person with the disability?)   ");
		assistanceLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_assistanceLabel = new GridBagConstraints();
		gbc_assistanceLabel.anchor = GridBagConstraints.WEST;
		gbc_assistanceLabel.gridx = 0;
		gbc_assistanceLabel.gridy = 1;
		gbc_assistanceLabel.insets = new Insets(0, 25, 5, 0);
		relationshipPanel.add(assistanceLabel, gbc_assistanceLabel);
		
		JTextArea relationshipText = new JTextArea();
		GridBagConstraints gbc_relationshipText = new GridBagConstraints();
		gbc_relationshipText.weighty = 0.1;
		gbc_relationshipText.weightx = 1.0;
		gbc_relationshipText.fill = GridBagConstraints.BOTH;
		gbc_relationshipText.gridx = 0;
		gbc_relationshipText.gridy = 2;
		gbc_relationshipText.insets = new Insets(0, 10, 10, 10);
		relationshipPanel.add(relationshipText, gbc_relationshipText);
		
		JPanel dppcHotlinePanel = new JPanel();
		dppcHotlinePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_dppcHotlinePanel = new GridBagConstraints();
		gbc_dppcHotlinePanel.insets = new Insets(5, 10, 5, 10);
		gbc_dppcHotlinePanel.fill = GridBagConstraints.BOTH;
		gbc_dppcHotlinePanel.gridx = 0;
		gbc_dppcHotlinePanel.gridy = 3;
		add(dppcHotlinePanel, gbc_dppcHotlinePanel);
		GridBagLayout gbl_dppcHotlinePanel = new GridBagLayout();
		gbl_dppcHotlinePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_dppcHotlinePanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_dppcHotlinePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcHotlinePanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		dppcHotlinePanel.setLayout(gbl_dppcHotlinePanel);
		
		JLabel dppcHotlineLabel = new JLabel("6. Was an oral report filed with the DPPC Hotline?   ");
		dppcHotlineLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_dppcHotlineLabel = new GridBagConstraints();
		gbc_dppcHotlineLabel.gridwidth = 2;
		gbc_dppcHotlineLabel.anchor = GridBagConstraints.WEST;
		gbc_dppcHotlineLabel.gridx = 0;
		gbc_dppcHotlineLabel.gridy = 0;
		gbc_dppcHotlineLabel.insets = new Insets(10, 10, 5, 5);
		dppcHotlinePanel.add(dppcHotlineLabel, gbc_dppcHotlineLabel);
		
		JCheckBox chckbxDppcYes = new JCheckBox("YES");
		GridBagConstraints gbc_chckbxDppcYes = new GridBagConstraints();
		gbc_chckbxDppcYes.anchor = GridBagConstraints.WEST;
		gbc_chckbxDppcYes.insets = new Insets(0, 100, 5, 5);
		gbc_chckbxDppcYes.gridx = 0;
		gbc_chckbxDppcYes.gridy = 1;
		dppcHotlinePanel.add(chckbxDppcYes, gbc_chckbxDppcYes);
		
		JLabel dppcCalledTimeLabel = new JLabel("Please note date and time of call:");
		GridBagConstraints gbc_dppcCalledTimeLabel = new GridBagConstraints();
		gbc_dppcCalledTimeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dppcCalledTimeLabel.gridx = 2;
		gbc_dppcCalledTimeLabel.gridy = 1;
		dppcHotlinePanel.add(dppcCalledTimeLabel, gbc_dppcCalledTimeLabel);
		
		JLabel dateLabel = new JLabel("Date:");
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.EAST;
		gbc_dateLabel.weightx = 0.1;
		gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateLabel.gridx = 3;
		gbc_dateLabel.gridy = 1;
		dppcHotlinePanel.add(dateLabel, gbc_dateLabel);
		
		JPanel dppcCalledDatePanel = new JPanel();
		GridBagConstraints gbc_dppcCalledDatePanel = new GridBagConstraints();
		gbc_dppcCalledDatePanel.weightx = 0.1;
		gbc_dppcCalledDatePanel.insets = new Insets(0, 0, 5, 5);
		gbc_dppcCalledDatePanel.fill = GridBagConstraints.BOTH;
		gbc_dppcCalledDatePanel.gridx = 4;
		gbc_dppcCalledDatePanel.gridy = 1;
		dppcHotlinePanel.add(dppcCalledDatePanel, gbc_dppcCalledDatePanel);
		GridBagLayout gbl_dppcCalledDatePanel = new GridBagLayout();
		gbl_dppcCalledDatePanel.columnWidths = new int[]{0, 0, 0};
		gbl_dppcCalledDatePanel.rowHeights = new int[]{0, 0};
		gbl_dppcCalledDatePanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcCalledDatePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dppcCalledDatePanel.setLayout(gbl_dppcCalledDatePanel);
		
		JFormattedTextField dppcCalledMonth = new JFormattedTextField();
		GridBagConstraints gbc_dppcCalledMonth = new GridBagConstraints();
		gbc_dppcCalledMonth.weightx = 0.1;
		gbc_dppcCalledMonth.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledMonth.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledMonth.gridx = 0;
		gbc_dppcCalledMonth.gridy = 0;
		dppcCalledDatePanel.add(dppcCalledMonth, gbc_dppcCalledMonth);
		
		JFormattedTextField dppcCalledDay = new JFormattedTextField();
		GridBagConstraints gbc_dppcCalledDay = new GridBagConstraints();
		gbc_dppcCalledDay.weightx = 0.1;
		gbc_dppcCalledDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledDay.gridx = 1;
		gbc_dppcCalledDay.gridy = 0;
		dppcCalledDatePanel.add(dppcCalledDay, gbc_dppcCalledDay);
		
		JPanel dppcCalledTimePanel = new JPanel();
		GridBagConstraints gbc_dppcCalledTimePanel = new GridBagConstraints();
		gbc_dppcCalledTimePanel.weightx = 0.1;
		gbc_dppcCalledTimePanel.insets = new Insets(0, 0, 5, 10);
		gbc_dppcCalledTimePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledTimePanel.gridx = 6;
		gbc_dppcCalledTimePanel.gridy = 1;
		dppcHotlinePanel.add(dppcCalledTimePanel, gbc_dppcCalledTimePanel);
		GridBagLayout gbl_dppcCalledTimePanel = new GridBagLayout();
		gbl_dppcCalledTimePanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_dppcCalledTimePanel.rowHeights = new int[]{0, 0};
		gbl_dppcCalledTimePanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_dppcCalledTimePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		dppcCalledTimePanel.setLayout(gbl_dppcCalledTimePanel);
		
		JLabel dppcCalledHourLabel = new JLabel("Hour:");
		GridBagConstraints gbc_dppcCalledHourLabel = new GridBagConstraints();
		gbc_dppcCalledHourLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledHourLabel.anchor = GridBagConstraints.EAST;
		gbc_dppcCalledHourLabel.gridx = 0;
		gbc_dppcCalledHourLabel.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledHourLabel, gbc_dppcCalledHourLabel);
		
		JFormattedTextField dppcCalledHour = new JFormattedTextField();
		GridBagConstraints gbc_dppcCalledHour = new GridBagConstraints();
		gbc_dppcCalledHour.weightx = 0.1;
		gbc_dppcCalledHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledHour.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledHour.gridx = 1;
		gbc_dppcCalledHour.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledHour, gbc_dppcCalledHour);
		
		JLabel dppcCalledMinuteLabel = new JLabel("Min:");
		GridBagConstraints gbc_dppcCalledMinuteLabel = new GridBagConstraints();
		gbc_dppcCalledMinuteLabel.insets = new Insets(0, 0, 0, 5);
		gbc_dppcCalledMinuteLabel.anchor = GridBagConstraints.EAST;
		gbc_dppcCalledMinuteLabel.gridx = 2;
		gbc_dppcCalledMinuteLabel.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledMinuteLabel, gbc_dppcCalledMinuteLabel);
		
		JFormattedTextField dppcCalledMinute = new JFormattedTextField();
		GridBagConstraints gbc_dppcCalledMinute = new GridBagConstraints();
		gbc_dppcCalledMinute.weightx = 0.1;
		gbc_dppcCalledMinute.fill = GridBagConstraints.HORIZONTAL;
		gbc_dppcCalledMinute.gridx = 3;
		gbc_dppcCalledMinute.gridy = 0;
		dppcCalledTimePanel.add(dppcCalledMinute, gbc_dppcCalledMinute);
		
		JCheckBox chckbxDppcNo = new JCheckBox("NO");
		GridBagConstraints gbc_chckbxDppcNo = new GridBagConstraints();
		gbc_chckbxDppcNo.anchor = GridBagConstraints.WEST;
		gbc_chckbxDppcNo.gridx = 0;
		gbc_chckbxDppcNo.gridy = 2;
		gbc_chckbxDppcNo.insets = new Insets(0, 100, 0, 5);
		dppcHotlinePanel.add(chckbxDppcNo, gbc_chckbxDppcNo);
		
		JPanel investigatorRiskPanel = new JPanel();
		investigatorRiskPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagConstraints gbc_investigatorRiskPanel = new GridBagConstraints();
		gbc_investigatorRiskPanel.fill = GridBagConstraints.BOTH;
		gbc_investigatorRiskPanel.gridx = 0;
		gbc_investigatorRiskPanel.gridy = 4;
		gbc_investigatorRiskPanel.insets = new Insets(5, 10, 5, 10);
		add(investigatorRiskPanel, gbc_investigatorRiskPanel);
		GridBagLayout gbl_investigatorRiskPanel = new GridBagLayout();
		gbl_investigatorRiskPanel.columnWidths = new int[]{0, 0, 0};
		gbl_investigatorRiskPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_investigatorRiskPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_investigatorRiskPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		investigatorRiskPanel.setLayout(gbl_investigatorRiskPanel);
		
		JLabel riskLabel = new JLabel("7. Is there any risk to the investigator?   ");
		riskLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_riskLabel = new GridBagConstraints();
		gbc_riskLabel.gridx = 0;
		gbc_riskLabel.gridy = 0;
		gbc_riskLabel.insets = new Insets(10, 10, 5, 5);
		investigatorRiskPanel.add(riskLabel, gbc_riskLabel);
		
		JCheckBox chckbxInvestRiskYes = new JCheckBox("YES");
		GridBagConstraints gbc_chckbxInvestRiskYes = new GridBagConstraints();
		gbc_chckbxInvestRiskYes.anchor = GridBagConstraints.WEST;
		gbc_chckbxInvestRiskYes.insets = new Insets(5, 100, 5, 5);
		gbc_chckbxInvestRiskYes.gridx = 0;
		gbc_chckbxInvestRiskYes.gridy = 1;
		investigatorRiskPanel.add(chckbxInvestRiskYes, gbc_chckbxInvestRiskYes);
		
		JLabel investRiskYesSpecifyLabel = new JLabel("If yes, please specify:");
		GridBagConstraints gbc_investRiskYesSpecifyLabel = new GridBagConstraints();
		gbc_investRiskYesSpecifyLabel.anchor = GridBagConstraints.WEST;
		gbc_investRiskYesSpecifyLabel.insets = new Insets(0, 0, 5, 0);
		gbc_investRiskYesSpecifyLabel.gridx = 1;
		gbc_investRiskYesSpecifyLabel.gridy = 1;
		investigatorRiskPanel.add(investRiskYesSpecifyLabel, gbc_investRiskYesSpecifyLabel);
		
		JCheckBox chckbxInvestRiskNo = new JCheckBox("NO");
		GridBagConstraints gbc_chckbxInvestRiskNo = new GridBagConstraints();
		gbc_chckbxInvestRiskNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxInvestRiskNo.insets = new Insets(0, 100, 0, 5);
		gbc_chckbxInvestRiskNo.gridx = 0;
		gbc_chckbxInvestRiskNo.gridy = 2;
		investigatorRiskPanel.add(chckbxInvestRiskNo, gbc_chckbxInvestRiskNo);
		
		JTextArea investRisk = new JTextArea();
		investRisk.setWrapStyleWord(true);
		investRisk.setLineWrap(true);
		GridBagConstraints gbc_investRisk = new GridBagConstraints();
		gbc_investRisk.weighty = 0.2;
		gbc_investRisk.weightx = 0.2;
		gbc_investRisk.fill = GridBagConstraints.BOTH;
		gbc_investRisk.gridx = 1;
		gbc_investRisk.gridy = 2;
		gbc_investRisk.insets = new Insets(0, 10, 10, 10);
		investigatorRiskPanel.add(investRisk, gbc_investRisk);

	}

}
