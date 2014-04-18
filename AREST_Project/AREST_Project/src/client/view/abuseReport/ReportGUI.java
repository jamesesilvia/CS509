package client.view.abuseReport;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import client.model.Report;

/**
 * This class defines all the methods and variables associated with an Abuse Report JFrame.
 * 
 * @author Matt Orsini
 *
 */
public abstract class ReportGUI extends JFrame {
	
	final protected static String REPORTER_PANEL         = "Reporter Panel";
	final protected static String VICTIM_PANEL           = "Victim Panel";
	final protected static String VICTIM_ADD_INFO_PANEL  = "Victim additional info Panel";
	final protected static String GUARDIAN_PANEL         = "Guardian Panel";
	final protected static String DESCRIPTION_PANEL      = "Description Panel";
	
	protected JFrame mFrame;
	protected JPanel containerPanel;
	protected JPanel mCards;
	protected JButton buttonLeft;
	protected JButton buttonCenter;
	protected JButton buttonRight;
	protected CardLayout clContainer;
	
	protected static Report reportContainer;
	
	protected static ReporterGUI reporterGUI;
	protected static VictimGUI   victimGUI;
	protected static VictimAdditionalInfoGUI victimAddGUI;
	protected static GuardianGUI guardianGUI;
	protected static DescriptionGUI descriptionGUI;
	
	protected static int componentIndex = 0;
	
	protected final Object[] option = {"Yes", "No"};
	
	protected boolean reportEditable = true;
	
	public ReportGUI () {
		// FIXME: Turn this off when simulating
		//initialize();
	}
	
	public void initialize() {
		mFrame = new JFrame();
		
		containerPanel = new JPanel();
		mFrame.getContentPane().add(containerPanel);
		GridBagLayout gbl_containerPanel = new GridBagLayout();
		gbl_containerPanel.columnWidths = new int[] {0};
		gbl_containerPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_containerPanel.rowWeights = new double[]{0.0, 0.0};
		containerPanel.setLayout(gbl_containerPanel);
		
		buttonLeft = new JButton("OVERRIDE ME LEFT");
		
		// Create all the cards in this panel.
		reporterGUI = new ReporterGUI();
		reporterGUI.setName(REPORTER_PANEL);
		victimGUI   = new VictimGUI();
		victimGUI.setName(VICTIM_PANEL);
		victimAddGUI = new VictimAdditionalInfoGUI();
		victimAddGUI.setName(VICTIM_ADD_INFO_PANEL);
		guardianGUI = new GuardianGUI();
		guardianGUI.setName(GUARDIAN_PANEL);
		descriptionGUI = new DescriptionGUI();
		descriptionGUI.setName(DESCRIPTION_PANEL);
				
		// Create the CardLayout and add the cards
		CardLayout cl_mCards = new CardLayout();
		mCards = new JPanel(cl_mCards);
		mCards.add(reporterGUI, REPORTER_PANEL);
		mCards.add(victimGUI,   VICTIM_PANEL);
		mCards.add(victimAddGUI, VICTIM_ADD_INFO_PANEL);
		mCards.add(guardianGUI, GUARDIAN_PANEL);
		mCards.add(descriptionGUI, DESCRIPTION_PANEL);
		
		clContainer = (CardLayout) mCards.getLayout();
		GridBagConstraints gbc_mCards = new GridBagConstraints();
		gbc_mCards.anchor = GridBagConstraints.NORTHWEST;
		gbc_mCards.insets = new Insets(0, 5, 5, 0);
		gbc_mCards.gridwidth = 3;
		gbc_mCards.gridx = 0;
		gbc_mCards.gridy = 0;
		containerPanel.add(mCards, gbc_mCards);
		
		GridBagConstraints gbc_buttonLeft = new GridBagConstraints();
		gbc_buttonLeft.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonLeft.insets = new Insets(0, 5, 0, 0);
		gbc_buttonLeft.gridx = 0;
		gbc_buttonLeft.gridy = 1;
		gbc_buttonLeft.weightx = 0.5;
		containerPanel.add(buttonLeft, gbc_buttonLeft);
		
		buttonRight = new JButton("OVERRIDE ME RIGHT");
		buttonRight.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_buttonRight = new GridBagConstraints();
		gbc_buttonRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonRight.insets = new Insets(0, 5, 0, 5);
		gbc_buttonRight.gridx = 2;
		gbc_buttonRight.gridy = 1;
		gbc_buttonRight.weightx = 0.5;
		gbc_buttonRight.weighty = 1;
		containerPanel.add(buttonRight, gbc_buttonRight);
		
		buttonCenter = new JButton("OVERRIDE ME CENTER");
				
		GridBagConstraints gbc_buttonCenter = new GridBagConstraints();
		gbc_buttonCenter.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonCenter.gridx = 1;
		gbc_buttonCenter.gridy = 1;
		gbc_buttonCenter.weightx = 0.5;
		gbc_buttonCenter.insets = new Insets(0, 5, 0, 0);
		containerPanel.add(buttonCenter, gbc_buttonCenter);

		mFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		mFrame.pack();
		mFrame.setResizable(false);
		mFrame.setVisible(true);
		//mFrame.setEnabled(isReportEditable());
		
		mFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				int response = JOptionPane.showOptionDialog(mFrame, "Are you sure you want to exit?\n"
						+ "All changes will be lost.", "Are you sure?", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
				if(response == JOptionPane.YES_OPTION) {
					mFrame.dispose();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
	
	/**
	 * Returns if the report should be editable or not.
	 * @return
	 */
	public boolean isReportEditable() {
		return reportEditable;
	}
	
	/**
	 * Set a configuration parameter to determine if the report is editable or not.
	 * @param reportEditable - true if the report is editable, false otherwise
	 */
	public void setReportEditable(boolean reportEditable) {
		this.reportEditable = reportEditable;
		this.mFrame.setEnabled(reportEditable);
	}
	
	/**
	 * Increment the component index in the cardlayout
	 */
	protected void incrementCardLayoutCounter() {
		if(componentIndex != mCards.getComponentCount()) {
			componentIndex++;
		}
	}
	
	/**
	 * Decrement the component index in the cardlayout
	 */
	protected void decrementCardLayoutCounter() {
		if(componentIndex != 0) {
			componentIndex--;
		}
	}
	
	/**
	 * Get the index of the current card being displayed to the user.
	 * @return - the current component's index in the cardlayout being displayed to the user.
	 */
	protected int getCardComponentIndex() {
		return componentIndex;
	}
	
	
}
