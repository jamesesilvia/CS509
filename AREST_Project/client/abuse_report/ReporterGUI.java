package cs509.grp8.arest.report;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import cs509.grp8.arest.common.DocumentSizeFilter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ReporterGUI extends JPanel {
	private JTextField hyphon;
	private JTextField firstNameNotSetWarning;
	private JTextField lastNameNotSetWarning;
	private JTextField addrNotSetWarning;
	private JTextField mandatedNotSetWarning;
	private JTextField phoneNotSetWarning;
	private JTextField relationshipNotSetWarning;
	
	private boolean mandated = false;
	private boolean nonmandated = false;
	
	private JLabel reporterLbl;
	private JLabel firstNameLbl;
	private JLabel lastNameLbl;
	private JLabel addrLbl;
	private JLabel relationshipLbl;
	private JLabel telephoneLbl;
	
	private JTextArea addrTextArea;
	
	private JCheckBox mandatedCB;
	private JCheckBox notMandatedCB;
	
	private JFormattedTextField relationshipTextField;
	private JFormattedTextField firstNameTextField;
	private JFormattedTextField lastNameTextField;
	private JFormattedTextField phoneAreaCode, phoneFirstThree, phoneLastFour;
	private DocumentSizeFilter filter;
	
	private Reporter reporter;
	
	/**
	 * Create the panel.
	 */
	public ReporterGUI() {
		// Used for setupTextField
		filter = new DocumentSizeFilter(10);
		
		reporterLbl = new JLabel("Reporter");
		reporterLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		firstNameLbl = new JLabel("Name:");
		
		firstNameTextField = new JFormattedTextField();
		filter.setupTextField(firstNameTextField, DocumentSizeFilter.CHAR, 16);
		
		lastNameLbl = new JLabel("Last Name:");
		
		lastNameTextField = new JFormattedTextField();
		filter.setupTextField(lastNameTextField, DocumentSizeFilter.CHAR, 16);
		
		addrLbl = new JLabel("Address:");
		
		addrTextArea = new JTextArea();
		addrTextArea.setLineWrap(true);
		addrTextArea.setWrapStyleWord(true);
		filter.setupTextField(addrTextArea, DocumentSizeFilter.ANY, 50);
		
		mandatedCB = new JCheckBox("Mandated");
		
		notMandatedCB = new JCheckBox("Not Mandated");
		
		mandatedCB.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
					notMandatedCB.setEnabled(false);
					mandated = true;
				} else {
					mandated = false;
					notMandatedCB.setEnabled(true);
				}
			}
		});;
		
		notMandatedCB.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent event) {
				if(event.getStateChange() == ItemEvent.SELECTED) {
					mandatedCB.setEnabled(false);
					nonmandated = true;
				} else {
					nonmandated = false;
					mandatedCB.setEnabled(true);
				}
			}
		});
		
		relationshipLbl = new JLabel("Relationship to Alleged Victim:");
			
		relationshipTextField = new JFormattedTextField();
		filter.setupTextField(relationshipTextField, DocumentSizeFilter.ANY, 20);
		
		telephoneLbl = new JLabel("Daytime Telephone:");
		
		phoneAreaCode = new JFormattedTextField();
		filter.setupTextField(phoneAreaCode, DocumentSizeFilter.NO, 3);
		
		phoneFirstThree = new JFormattedTextField();
		filter.setupTextField(phoneFirstThree, DocumentSizeFilter.NO, 3);
		
		phoneLastFour = new JFormattedTextField();
		filter.setupTextField(phoneLastFour, DocumentSizeFilter.NO, 4);
		
		hyphon = new JTextField();
		hyphon.setHorizontalAlignment(SwingConstants.CENTER);
		hyphon.setEditable(false);
		hyphon.setText("-");
		hyphon.setColumns(10);
		//FIXME: Add action listener for this
		
		firstNameNotSetWarning = new JTextField();
		firstNameNotSetWarning.setVisible(false);
		firstNameNotSetWarning.setEditable(false);
		firstNameNotSetWarning.setForeground(Color.RED);
		firstNameNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameNotSetWarning.setText("*");
		
		lastNameNotSetWarning = new JTextField();
		lastNameNotSetWarning.setVisible(false);
		lastNameNotSetWarning.setText("*");
		lastNameNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameNotSetWarning.setForeground(Color.RED);
		lastNameNotSetWarning.setEditable(false);
		
		addrNotSetWarning = new JTextField();
		addrNotSetWarning.setVisible(false);
		addrNotSetWarning.setText("*");
		addrNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		addrNotSetWarning.setForeground(Color.RED);
		addrNotSetWarning.setEditable(false);
		
		mandatedNotSetWarning = new JTextField();
		mandatedNotSetWarning.setVisible(false);
		mandatedNotSetWarning.setText("*");
		mandatedNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		mandatedNotSetWarning.setForeground(Color.RED);
		mandatedNotSetWarning.setEditable(false);
		
		phoneNotSetWarning = new JTextField();
		phoneNotSetWarning.setVisible(false);
		phoneNotSetWarning.setText("*");
		phoneNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNotSetWarning.setForeground(Color.RED);
		phoneNotSetWarning.setEditable(false);
		
		relationshipNotSetWarning = new JTextField();
		relationshipNotSetWarning.setVisible(false);
		relationshipNotSetWarning.setText("*");
		relationshipNotSetWarning.setHorizontalAlignment(SwingConstants.CENTER);
		relationshipNotSetWarning.setForeground(Color.RED);
		relationshipNotSetWarning.setEditable(false);

		
		JScrollPane addrTextScrollPane = new JScrollPane(addrTextArea);
		addrTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(firstNameLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(reporterLbl, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(firstNameNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addrLbl, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(addrNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lastNameLbl, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lastNameNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addGap(2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addrTextScrollPane, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
									.addComponent(mandatedNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(notMandatedCB)
								.addComponent(mandatedCB)
								.addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(relationshipLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(relationshipNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addGap(6))
								.addComponent(telephoneLbl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(phoneNotSetWarning, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(hyphon, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addComponent(relationshipTextField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(reporterLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(firstNameLbl)
						.addComponent(firstNameNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(firstNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameLbl)
						.addComponent(lastNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastNameNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(addrLbl)
									.addComponent(addrNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(addrTextScrollPane, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(mandatedCB)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(notMandatedCB)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(mandatedNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(telephoneLbl)
						.addComponent(phoneNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneAreaCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hyphon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneFirstThree, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneLastFour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(relationshipLbl)
						.addComponent(relationshipTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(relationshipNotSetWarning, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(84))
		);
		setLayout(groupLayout);

	}
	
	
	
}
