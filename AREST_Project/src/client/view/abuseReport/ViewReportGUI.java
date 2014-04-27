package client.view.abuseReport;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import us.monoid.json.JSONException;
import client.model.Report;
import client.model.UserContainer;
/**
 * This class retrieves a report from the server by passing an ID (the public log number).
 * The reportGUI is populated based on the report container grabbed from the server.
 * Information is redacted as necessary.
 * 
 * @author Matt Orsini
 *
 */
public class ViewReportGUI extends ReportGUI implements ViewReportInterface {
	
	protected static final String STATUS_PANEL  = "Status Panel";
	protected static final String RESULTS_PANEL = "Results Panel";
	
	
	protected JPanel  viewReportPanel;
	protected JButton printReportButton;
	protected JButton editReportButton;
	
	protected SetReportStatusGUI  statusGUI;
	protected SetReportResultsGUI resultsGUI;
	
	protected Long id; // the report ID
	
	protected boolean isReportValid = false;
	
	private enum reasonEnum { NO_PRIVILEGES, INVALID_ID, VALID };
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws JSONException 
	 */
	public ViewReportGUI(UserContainer user){
		setUser(user);
		preconfigureView();
		initialize();
		postconfigureView();
	}

	/**
	 * This phase checks for the report validity based on an accepted ID from the user. Override
	 * this if you want to change it.
	 */
	protected void preconfigureView() {
		// Check that the ID entered is valid, or credentials are valid.
		setReportValid(pollForID(true, reasonEnum.VALID));
	}
	
	/**
	 * This phase disallows editing of text fields. Override this if you want to change it.
	 */
	protected void postconfigureView() {
		setReportEditable(false);
	}
	
	/**
	 * Fills in the View to contain all the information fetched from the server.
	 */
	public void initialize() {
		if(getReportValid()) {
			
			super.initialize();
			
			viewReportPanel = new JPanel();
			GridBagLayout gbl_viewReportPanel = new GridBagLayout();
			viewReportPanel.setLayout(gbl_viewReportPanel);
			GridBagConstraints gbc_viewReportPanel = new GridBagConstraints();
			gbc_viewReportPanel.gridy = 2;
			gbc_viewReportPanel.gridwidth = 3;
			gbc_viewReportPanel.fill = GridBagConstraints.BOTH;
			gbc_viewReportPanel.insets = new Insets(0, 5, 10, 5);
			
			// FIXME: Call print report.
			printReportButton = new JButton("Print Report");
			GridBagConstraints gbc_printReportButton = new GridBagConstraints();
			gbc_printReportButton.anchor = GridBagConstraints.NORTH;
			gbc_printReportButton.weightx = 0.5;
			gbc_printReportButton.weighty = 0.5;
			gbc_printReportButton.insets = new Insets(0, 0, 10, 5);
			gbc_printReportButton.fill = GridBagConstraints.HORIZONTAL;
			viewReportPanel.add(printReportButton, gbc_printReportButton);
			printReportButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent action) {
					try {
						ReportPrinter printer = new ReportPrinter(reportContainer);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			editReportButton  = new JButton("Edit Report");
			GridBagConstraints gbc_editReportButton = new GridBagConstraints();
			gbc_editReportButton.anchor = GridBagConstraints.NORTH;
			gbc_editReportButton.weightx = 0.5;
			gbc_editReportButton.weighty = 0.5;
			gbc_editReportButton.insets = new Insets(0, 5, 10, 0);
			gbc_editReportButton.fill = GridBagConstraints.HORIZONTAL;
			viewReportPanel.add(editReportButton, gbc_editReportButton);
			// Only enable when the user is a supervisor.
			editReportButton.setEnabled(getUser().isSupervisor);
			editReportButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent action) {
					if (action.getID() == ActionEvent.ACTION_PERFORMED) {
						mFrame.dispose();
						EditReportGUI editReportGUI = new EditReportGUI(getUser());
					}
						
				}
			});
			
			containerPanel.add(viewReportPanel, gbc_viewReportPanel);
		
			statusGUI = new SetReportStatusGUI();
			statusGUI.setName(STATUS_PANEL);
			statusGUI.setLabelText("Report status (if set by supervisor).");
			mCards.add(statusGUI, STATUS_PANEL);
			
			resultsGUI = new SetReportResultsGUI();
			resultsGUI.setName(RESULTS_PANEL);
			resultsGUI.setLabelText("Report results (if set by supervisor).");
			mCards.add(resultsGUI, RESULTS_PANEL);
			
			// Update all panels with information from the report container.
			updatePanel(reportContainer, true);
			
			buttonLeft.setEnabled(false); // Not enabled by default.
			buttonLeft.setText("Previous");
			buttonLeft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event ) {
					if (event.getID() == ActionEvent.ACTION_PERFORMED) {
						buttonRight.setEnabled(true);
						if(getCardComponentIndex() != 0) {
							clContainer.previous(mCards);
						} 
						if(getCardComponentIndex() == 1) {
							buttonLeft.setEnabled(false);
						}
						decrementCardLayoutCounter();
						buttonRight.setText("Next");
					}
				}
			});
			
			buttonRight.setText("Next");
			buttonRight.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent action) {
					// Change to the next view if the right button is pressed.
					if(action.getID() == ActionEvent.ACTION_PERFORMED) {
						buttonLeft.setEnabled(true); // Since we hit the buttonRight, buttonLeft should be good.
						if(getCardComponentIndex() != (mCards.getComponentCount() - 1)) {
							clContainer.next(mCards);
							incrementCardLayoutCounter();
						} 
						if(getCardComponentIndex() == (mCards.getComponentCount() -1)) {
							buttonRight.setEnabled(false);
						} 
					}
				}
			});
			
			buttonCenter.setText("Cancel");
			buttonCenter.addActionListener(new ActionListener() {
				/**
				 * This actionlistener determines if the window should be disposed. We've given the user
				 * A second chance to go back on their decision to exit the createreport. 
				 */
				@Override
				public void actionPerformed(ActionEvent action) {
					dispose();
					if(action.getID() == ActionEvent.ACTION_PERFORMED){
						int response = JOptionPane.showOptionDialog(mFrame, "Are you sure you want to exit?\n"
								+ "All changes will be lost.", "Are you sure?", JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
						if(response == JOptionPane.YES_OPTION) {
							mFrame.dispose();
						} 
					}
				}
			});
			mFrame.pack();
			mFrame.setVisible(true);
			mFrame.setTitle("AREST: View a Report by ID   (ID #" + reportContainer.getId() + ")");
		} 
	}
	
	public void setReportEditable(boolean reportEditable) {
		setEnabled(mCards, reportEditable);
	}
	
	/**
	 * Creates an option dialog to tell the user to enter the appropriate ID for the Report.
	 * If the report ID is not found, polls again.
	 */
	private boolean pollForID(boolean firstTime, reasonEnum reason) {
		Long id = null;
		String myId = null;
		reasonEnum currentReason = reasonEnum.VALID;
		if(firstTime) {
			myId = JOptionPane.showInputDialog(mFrame, "Please enter the ID of the abuse report you wish to view:",
					"Enter ID", JOptionPane.PLAIN_MESSAGE);
		} else {
			switch(reason) {
			case INVALID_ID: 
				myId = JOptionPane.showInputDialog(mFrame, "Invalid ID!\n" 
						+ "Please enter a valid ID of the abuse report you wish to view:",
						"Enter ID", JOptionPane.PLAIN_MESSAGE);
				break;
			case NO_PRIVILEGES:
				myId = JOptionPane.showInputDialog(mFrame, "Sorry! You don't have priviledges to this report.\n"+
						"Please enter a valid ID of the abuse report you wish to view:",
						"Enter ID", JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(myId != null) {
			id = Long.parseLong(myId);
			currentReason = checkValue(id);
			if(currentReason == reasonEnum.VALID) {
				return true;
			} else {
				return pollForID(false, currentReason);
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if the ID specified in the parameters exists on the server.
	 * @param idToFetch - ID to find on the server
	 * @return true is the ID is found (and the report), false otherwise.
	 */
	private reasonEnum checkValue(Long idToFetch) {
		reasonEnum reason = reasonEnum.VALID;
		try {
			reportContainer = fetchReportFromServer(idToFetch);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reason = reasonEnum.VALID;
		if(reportContainer == null) {
			reason = reasonEnum.INVALID_ID;
		} else {
			if(!isSupervisor() && !isCreator()) {
				reason = reasonEnum.NO_PRIVILEGES;
			} else {
				reason = reasonEnum.VALID;
			}
		}
		return reason;
	}
	

	
	
	/**
	 * Search recursively for components that match a textfield or a checkbox. 
	 * Enabled allows us to determine if the fields should be enabled or disabled.
	 * @param component the container to search for children
	 * @param enabled - determines if the components should be enabled or disabled.
	 */
	public void setEnabled(Component component, boolean enabled) {
		if(component instanceof JTextComponent) {
			((JTextComponent)component).setEditable(enabled);
			((JTextComponent)component).setOpaque(enabled);
		} else if (component instanceof JCheckBox) {
			((JCheckBox)component).setEnabled(enabled);
			((JCheckBox)component).setOpaque(enabled);
		} else if (component instanceof JComboBox) {
			((JComboBox)component).setEnabled(enabled);
		} else if (component instanceof JButton) {
			((JButton)component).setEnabled(enabled);
		}
		
		if(component instanceof Container) {
			for(Component child : ((Container) component).getComponents()) {
				setEnabled(child, enabled);
			}
		}
	}

	@Override
	public void updatePanel(Report report, boolean redacted) {
		reporterGUI.updatePanel(reportContainer, redacted);
		victimGUI.updatePanel(reportContainer, redacted);
		victimAddGUI.updatePanel(reportContainer, redacted);
		guardianGUI.updatePanel(reportContainer, redacted);
		descriptionGUI.updatePanel(reportContainer, redacted);
		statusGUI.updatePanel(reportContainer, redacted);
		resultsGUI.updatePanel(reportContainer, redacted);
	}
	
	protected void setReportValid(boolean reportValid) {
		this.isReportValid = reportValid;
	}
	
	protected boolean getReportValid() {
		return isReportValid;
	}
	
}
