package cs509.grp8.arest.report;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cs509.grp8.arest.common.DocumentSizeFilter;

// FIXME MOrsini: Add in warnings after fixing the reporter warnings

public class VictimGUI extends JPanel implements CreateReportInterface {
	
	private JTextField monthText;
	private JTextField dayText;
	private JTextField yearText;
	private JTextField ageText;
	private JTextField maritalStatusText;
	
	private DocumentSizeFilter filter;
	
	public VictimGUI() {
		// To configure JTextComponents
		filter = new DocumentSizeFilter(10);
		
		JLabel allegedVictimLabel = new JLabel("Alleged Victim");
		allegedVictimLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel firstNameLabel = new JLabel("First Name:");
		
		JFormattedTextField firstNameText = new JFormattedTextField();
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		
		JFormattedTextField lastNameText = new JFormattedTextField();
		
		JLabel addressLabel = new JLabel("Address:");
		
		JTextArea addressTextArea = new JTextArea();
		addressTextArea.setWrapStyleWord(true);
		addressTextArea.setLineWrap(true);
		
		JComboBox sexCombo = new JComboBox();
		sexCombo.setModel(new DefaultComboBoxModel(new String[] {"<Select One>", "Male", "Female"}));
		
		JLabel sexLabel = new JLabel("Sex:");
		
		JLabel dobLabel = new JLabel("DOB: ");
		
		monthText = new JTextField();
		monthText.setText("MM");
		monthText.setColumns(10);
		filter.setupTextField(monthText, DocumentSizeFilter.NO, 2);

		dayText = new JTextField();
		dayText.setText("DD");
		dayText.setColumns(10);
		filter.setupTextField(dayText, DocumentSizeFilter.NO, 2);
		
		yearText = new JTextField();
		yearText.setText("YYYY");
		yearText.setColumns(10);
		filter.setupTextField(yearText, DocumentSizeFilter.NO, 4);
		
		ageText = new JTextField();
		ageText.setColumns(10);
		filter.setupTextField(ageText, DocumentSizeFilter.NO, 3);
		
		JLabel ageLabel = new JLabel("Age:");
		
		JLabel maritalStatusLabel = new JLabel("Marital Status:");
		
		maritalStatusText = new JTextField();
		maritalStatusText.setColumns(10);
		filter.setupTextField(maritalStatusText, DocumentSizeFilter.CHAR, 10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(allegedVictimLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(firstNameLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lastNameLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(addressTextArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(monthText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(dayText, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(yearText, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
													.addComponent(ageLabel)
													.addGap(12)))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(sexCombo, 0, 114, Short.MAX_VALUE)
												.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(sexLabel)
												.addGap(48))))))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dobLabel)
							.addContainerGap(412, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(maritalStatusLabel)
					.addGap(18)
					.addComponent(maritalStatusText, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(allegedVictimLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstNameLabel)
						.addComponent(firstNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameLabel)
						.addComponent(lastNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(addressTextArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(addressLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(sexLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(sexCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(dobLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(monthText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dayText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(yearText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageLabel))))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(maritalStatusLabel)
						.addComponent(maritalStatusText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	@Override
	public boolean isValidInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object commitInfo() {
		// TODO Auto-generated method stub
		return null;
	}
}
