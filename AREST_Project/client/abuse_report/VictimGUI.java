package cs509.grp8.arest.report;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import cs509.grp8.arest.common.DocumentSizeFilter;

public class VictimGUI extends JPanel{
	
	private JTextField txtMm;
	private JTextField txtDd;
	private JTextField txtYyyy;
	private JTextField textField;
	private JTextField textField_1;
	
	private DocumentSizeFilter filter;
	
	public VictimGUI() {
		// To configure JTextComponents
		filter = new DocumentSizeFilter(10);
		
		JLabel lblAllegedVictim = new JLabel("Alleged Victim");
		lblAllegedVictim.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel label = new JLabel("Name:");
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		
		JLabel label_1 = new JLabel("Last Name:");
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		
		JLabel label_2 = new JLabel("Address:");
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Select One>", "Male", "Female"}));
		
		JLabel lblSex = new JLabel("Sex:");
		
		JLabel lblDob = new JLabel("DOB: ");
		
		txtMm = new JTextField();
		txtMm.setText("MM");
		txtMm.setColumns(10);
		
		txtDd = new JTextField();
		txtDd.setText("DD");
		txtDd.setColumns(10);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("YYYY");
		txtYyyy.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		
		JLabel lblMaritalStatus = new JLabel("Marital Status:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAllegedVictim)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(txtMm, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(txtDd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(txtYyyy, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
													.addComponent(lblAge)
													.addGap(12)))))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBox, 0, 114, Short.MAX_VALUE)
												.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
											.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
												.addComponent(lblSex)
												.addGap(48))))))
							.addContainerGap(20, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDob)
							.addContainerGap(412, Short.MAX_VALUE))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(lblMaritalStatus)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAllegedVictim)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(lblSex)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(lblDob))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYyyy, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAge))))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMaritalStatus)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
