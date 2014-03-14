package cs509.grp8.arest.report;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextPane;

import cs509.grp8.arest.common.ArestDocumentListener;
import cs509.grp8.arest.common.DocumentSizeFilter;
import cs509.grp8.arest.common.TextFieldFilter;

import java.awt.Color;
import java.awt.TextField;

public class ReporterFrame extends JFrame {

	private Reporter mReporter = new Reporter();
	
	
	// Panes
	private JPanel reporterPane;
	private JLabel telephoneLabel;
	
	// Labels
	private JLabel reporterLabel;
	private JLabel firstNameLabel;
	private JLabel addressLabel;
	private JLabel relationshipToVictimLabel;
	
	// Formatted text fields
	private JFormattedTextField firstNameTextField;
	private JFormattedTextField phoneAreaCode;
	private JFormattedTextField phoneFirstThree;
	private JFormattedTextField phoneLastFour;
	
	// Other text fields
	private JTextField relationshipTextField;
	private JTextArea addressTextArea;
	
	// Check boxes
	private Checkbox mandatedCheckBox; 
	private Checkbox nonmandatedCheckBox;
	
	// Buttons
	private Button submitButton;
	private Button cancelButton;
	
	private JTextPane nameNotEnteredWarning;
	private JTextPane addressNotEnteredWarning;
	private JTextPane phoneNotEnteredWarning;
	private JTextPane mandatedNotSetWarning;
	private boolean mandatedSet = false;
	private JTextPane nonmandatedNotSetWarning;
	private boolean nonmandatedSet = false;
	private JTextPane relationshipNotSetWarning;
	private JLabel lastNameLabel;
	private JFormattedTextField lastNameTextField;
	private JTextPane lastNameNotEnteredWarning;
	
	private ArestDocumentListener firstNameDocListener = new ArestDocumentListener();
	private ArestDocumentListener addressDocListener = new ArestDocumentListener();
	private ArestDocumentListener lastNameDocListener = new ArestDocumentListener();
	private ArestDocumentListener phoneAreaCodeDocListener = new ArestDocumentListener();
	private ArestDocumentListener phoneFirstThreeDocListener = new ArestDocumentListener();
	private ArestDocumentListener phoneLastFourDocListener = new ArestDocumentListener();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporterFrame frame = new ReporterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReporterFrame() {
		AbstractDocument myAbstractDoc;
		DocumentSizeFilter firstNameFilter = new DocumentSizeFilter(16);
		DocumentSizeFilter lastNameFilter  = new DocumentSizeFilter(16);
		DocumentSizeFilter addressFilter   = new DocumentSizeFilter(100);
		DocumentSizeFilter phoneAreaCodeFilter = new DocumentSizeFilter(3);
		DocumentSizeFilter phoneFirstThreeFilter = new DocumentSizeFilter(3);
		DocumentSizeFilter phoneLastFourFilter = new DocumentSizeFilter(4);
		DocumentSizeFilter relationshipFilter = new DocumentSizeFilter(16);
		
		
		setTitle("AREST Abuse Report Creation: Reporter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		reporterPane = new JPanel();
		reporterPane.setToolTipText("Please enter all the information on this page. This is the reporter, or the witness of alleged abuse.");
		reporterPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(reporterPane);
		
		reporterLabel = new JLabel("Reporter");
		reporterLabel.setBounds(10, 10, 67, 19);
		reporterLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		/*
		 * This is the first name area setup. Installing listeners, etc.
		 */
		firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(10, 38, 67, 14);

		firstNameTextField = new JFormattedTextField();
		firstNameTextField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		firstNameTextField.setBounds(94, 35, 119, 20);
		firstNameTextField.setToolTipText("Please enter the name of the reporter who witnessed alleged abuse.");
		firstNameTextField.getDocument().addDocumentListener(firstNameDocListener);
		firstNameTextField.getDocument().putProperty("FirstName", "Text Area");
		if(firstNameTextField.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) firstNameTextField.getDocument();
			firstNameFilter.setAcceptedType(DocumentSizeFilter.CHAR);
			firstNameDocListener.setFilter(firstNameFilter);
			myAbstractDoc.setDocumentFilter(firstNameFilter);
		}
		
		/*
		 * This is the last name textfield setup.
		 */
		lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(223, 38, 67, 14);
		reporterPane.add(lastNameLabel);
		
		lastNameTextField = new JFormattedTextField();
		lastNameTextField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		lastNameTextField.setToolTipText("Please enter the name of the reporter who witnessed alleged abuse.");
		lastNameTextField.setBounds(324, 35, 100, 20);
		reporterPane.add(lastNameTextField);
		lastNameTextField.getDocument().addDocumentListener(lastNameDocListener);
		lastNameTextField.getDocument().putProperty("LastName", "Text Area");
		if(lastNameTextField.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) lastNameTextField.getDocument();
			lastNameFilter.setAcceptedType(DocumentSizeFilter.CHAR);
			lastNameDocListener.setFilter(lastNameFilter);
			myAbstractDoc.setDocumentFilter(lastNameFilter);
		}
		
		
		/*
		 * This is the address area setup. Installing listeners, etc.
		 */
		addressLabel = new JLabel("Address:");
		addressLabel.setBounds(10, 61, 54, 14);
		
		addressTextArea = new JTextArea();
		addressTextArea.setColumns(3);
		addressTextArea.setBounds(94, 61, 330, 67);
		addressTextArea.setLineWrap(true);
		addressTextArea.getDocument().addDocumentListener(addressDocListener);
		addressTextArea.getDocument().putProperty("Address", "Address Area");
		if(addressTextArea.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) addressTextArea.getDocument();
			addressFilter.setAcceptedType(DocumentSizeFilter.ANY);
			addressDocListener.setFilter(addressFilter);
			myAbstractDoc.setDocumentFilter(addressFilter);
		}
		
		
		reporterPane.setLayout(null);
		reporterPane.add(reporterLabel);
		reporterPane.add(firstNameLabel);
		reporterPane.add(firstNameTextField);
		reporterPane.add(addressLabel);
		reporterPane.add(addressTextArea);
		
		telephoneLabel = new JLabel("Daytime Telephone:");
		telephoneLabel.setBounds(10, 139, 126, 14);
		reporterPane.add(telephoneLabel);
		
		phoneAreaCode = new JFormattedTextField();
		phoneAreaCode.setFocusLostBehavior(JFormattedTextField.COMMIT);
		phoneAreaCode.setBounds(169, 139, 43, 20);
		reporterPane.add(phoneAreaCode);
		phoneAreaCode.setColumns(10);
		phoneAreaCode.getDocument().addDocumentListener(phoneAreaCodeDocListener);
		phoneAreaCode.getDocument().putProperty("Phone Area Code", "Area Code");
		if(phoneAreaCode.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) phoneAreaCode.getDocument();
			phoneAreaCodeFilter.setAcceptedType(DocumentSizeFilter.NO);
			phoneAreaCodeDocListener.setFilter(phoneAreaCodeFilter);
			myAbstractDoc.setDocumentFilter(phoneAreaCodeFilter);
		}
		
		phoneFirstThree = new JFormattedTextField();
		phoneFirstThree.setFocusLostBehavior(JFormattedTextField.COMMIT);
		phoneFirstThree.setColumns(10);
		phoneFirstThree.setBounds(222, 139, 43, 20);
		reporterPane.add(phoneFirstThree);
		phoneFirstThree.getDocument().addDocumentListener(phoneFirstThreeDocListener);
		phoneFirstThree.getDocument().putProperty("Phone First Three", "First Three");
		if(phoneFirstThree.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) phoneFirstThree.getDocument();
			phoneFirstThreeFilter.setAcceptedType(DocumentSizeFilter.NO);
			phoneFirstThreeDocListener.setFilter(phoneFirstThreeFilter);
			myAbstractDoc.setDocumentFilter(phoneFirstThreeFilter);
		}
		
		phoneLastFour = new JFormattedTextField();
		phoneLastFour.setFocusLostBehavior(JFormattedTextField.COMMIT);
		phoneLastFour.setColumns(10);
		phoneLastFour.setBounds(275, 139, 43, 20);
		reporterPane.add(phoneLastFour);
		phoneLastFour.getDocument().addDocumentListener(phoneLastFourDocListener);
		phoneLastFour.getDocument().putProperty("Phone First Three", "First Three");
		if(phoneLastFour.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) phoneLastFour.getDocument();
			phoneLastFourFilter.setAcceptedType(DocumentSizeFilter.NO);
			phoneLastFourDocListener.setFilter(phoneLastFourFilter);
			myAbstractDoc.setDocumentFilter(phoneLastFourFilter);
		}
		
		
		mandatedCheckBox = new Checkbox("Mandated");
		mandatedCheckBox.setBounds(57, 165, 119, 22);
		reporterPane.add(mandatedCheckBox);
		mandatedCheckBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					nonmandatedCheckBox.setEnabled(false);
					mandatedSet = true;
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					nonmandatedCheckBox.setEnabled(true);
					mandatedSet = false;
				}
				
			}
		});
		
		nonmandatedCheckBox = new Checkbox("Non-Mandated");
		nonmandatedCheckBox.setBounds(266, 165, 113, 22);
		reporterPane.add(nonmandatedCheckBox);
		nonmandatedCheckBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					mandatedCheckBox.setEnabled(false);
					nonmandatedSet = true;
				} else {
					mandatedCheckBox.setEnabled(true);
					nonmandatedSet = false;
				}
				
			}
		});
		
		relationshipToVictimLabel = new JLabel("Relationship to Alleged Victim:");
		relationshipToVictimLabel.setBounds(10, 193, 180, 14);
		reporterPane.add(relationshipToVictimLabel);
		
		relationshipTextField = new JTextField();
		relationshipTextField.setBounds(215, 193, 209, 20);
		reporterPane.add(relationshipTextField);
		relationshipTextField.setColumns(10);
		if(relationshipTextField.getDocument() instanceof AbstractDocument) {
			myAbstractDoc = (AbstractDocument) relationshipTextField.getDocument();
			relationshipFilter.setAcceptedType(DocumentSizeFilter.CHAR);
			myAbstractDoc.setDocumentFilter(relationshipFilter);
		}
		
		submitButton = new Button("Submit");
		submitButton.setBounds(227, 230, 197, 22);
		reporterPane.add(submitButton);
		
		
		cancelButton = new Button("Cancel");
		cancelButton.setBounds(10, 230, 197, 22);
		reporterPane.add(cancelButton);
		
		nameNotEnteredWarning = new JTextPane();
		nameNotEnteredWarning.setText("*");
		nameNotEnteredWarning.setForeground(Color.RED);
		nameNotEnteredWarning.setEditable(false);
		nameNotEnteredWarning.setEnabled(true);
		nameNotEnteredWarning.setBounds(71, 35, 13, 20);
		reporterPane.add(nameNotEnteredWarning);
		nameNotEnteredWarning.setVisible(false);
		
		addressNotEnteredWarning = new JTextPane();
		addressNotEnteredWarning.setText("*");
		addressNotEnteredWarning.setForeground(Color.RED);
		addressNotEnteredWarning.setEnabled(true);
		addressNotEnteredWarning.setEditable(false);
		addressNotEnteredWarning.setBounds(71, 61, 13, 20);
		reporterPane.add(addressNotEnteredWarning);
		addressNotEnteredWarning.setVisible(false);
		
		phoneNotEnteredWarning = new JTextPane();
		phoneNotEnteredWarning.setText("*");
		phoneNotEnteredWarning.setForeground(Color.RED);
		phoneNotEnteredWarning.setEnabled(true);
		phoneNotEnteredWarning.setEditable(false);
		phoneNotEnteredWarning.setBounds(146, 139, 13, 20);
		reporterPane.add(phoneNotEnteredWarning);
		
		mandatedNotSetWarning = new JTextPane();
		mandatedNotSetWarning.setText("*");
		mandatedNotSetWarning.setForeground(Color.RED);
		mandatedNotSetWarning.setEditable(false);
		mandatedNotSetWarning.setBounds(38, 164, 13, 20);
		reporterPane.add(mandatedNotSetWarning);
		mandatedNotSetWarning.setVisible(false);
		
		nonmandatedNotSetWarning = new JTextPane();
		nonmandatedNotSetWarning.setText("*");
		nonmandatedNotSetWarning.setForeground(Color.RED);
		nonmandatedNotSetWarning.setEditable(false);
		nonmandatedNotSetWarning.setBounds(243, 165, 13, 20);
		reporterPane.add(nonmandatedNotSetWarning);
		
		relationshipNotSetWarning = new JTextPane();
		relationshipNotSetWarning.setText("*");
		relationshipNotSetWarning.setForeground(Color.RED);
		relationshipNotSetWarning.setBounds(184, 193, 13, 20);
		relationshipNotSetWarning.setVisible(false);
		reporterPane.add(relationshipNotSetWarning);
		

		
		lastNameNotEnteredWarning = new JTextPane();
		lastNameNotEnteredWarning.setEditable(false);
		lastNameNotEnteredWarning.setText("*");
		lastNameNotEnteredWarning.setForeground(Color.RED);
		lastNameNotEnteredWarning.setBounds(301, 35, 13, 20);
		lastNameNotEnteredWarning.setVisible(false);
		reporterPane.add(lastNameNotEnteredWarning);
		phoneNotEnteredWarning.setVisible(false);
		nonmandatedNotSetWarning.setVisible(false);
		
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(lastNameTextField.getDocument().getLength() != 0){
					mReporter.setLastName(lastNameTextField.getText());
					lastNameNotEnteredWarning.setVisible(false);
				} else {
					lastNameNotEnteredWarning.setVisible(true);
				}
				
				if(firstNameTextField.getDocument().getLength() != 0){
					mReporter.setFirstName(firstNameTextField.getText());
					nameNotEnteredWarning.setVisible(false);
				} else {
					nameNotEnteredWarning.setVisible(true);
				}
				
				if(relationshipTextField.getDocument().getLength() != 0){
					mReporter.setRelationshipToVictim(relationshipTextField.getText());
					relationshipNotSetWarning.setVisible(false);
				} else {
					relationshipNotSetWarning.setVisible(true);
				}
				
				if(addressTextArea.getDocument().getLength() != 0){
					mReporter.setAddress(addressTextArea.getText());
					addressNotEnteredWarning.setVisible(false);
				} else {
					addressNotEnteredWarning.setVisible(true);
				}
				
				if((phoneAreaCode.getDocument().getLength() != 3) || (phoneFirstThree.getDocument().getLength() != 3) || (phoneLastFour.getDocument().getLength() != 4)){
					phoneNotEnteredWarning.setVisible(true);
				} else {
					phoneNotEnteredWarning.setVisible(false);
					mReporter.setTelephone(phoneAreaCode.getText().concat(phoneFirstThree.getText().concat(phoneLastFour.getText())));
				}
			
				if(!mandatedSet && !nonmandatedSet) {
					nonmandatedNotSetWarning.setVisible(true);
					mandatedNotSetWarning.setVisible(true);
				} else {
					if(!nonmandatedSet) {
						mReporter.setMandated(true); // mandated	
					} else {
						mReporter.setMandated(false); // nonmandated
					}
					nonmandatedNotSetWarning.setVisible(false);
					mandatedNotSetWarning.setVisible(false);
				}
				
			}
		});
		
	}
	
	
	/**
	 * Create the allowed text for a particular field.
	 * @param s
	 * @return
	 */
	protected MaskFormatter createFormat(String s) {
		MaskFormatter formatter = new MaskFormatter();
		try {
			formatter.setMask(s);	
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
		
	}
}
