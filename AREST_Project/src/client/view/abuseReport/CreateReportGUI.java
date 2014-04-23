package client.view.abuseReport;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import us.monoid.web.JSONResource;
import static us.monoid.web.Resty.content;
import us.monoid.web.Resty;
import client.model.*;

/**
 * Controls the flow of Abuse Report creation. This class also commits changes
 * to the report container.
 * @author Matt Orsini
 *
 */
public class CreateReportGUI extends ReportGUI {

	
	public CreateReportGUI() {
		
	}
	
	/**
	 * Create the panel.
	 * @param the user responsbile for the creation of this report.
	 */
	public CreateReportGUI(UserContainer user) {
		setUser(user);
		reportContainer = new Report();
		reportContainer.setUsername(this.getUser().userName);
		componentIndex = 0;
		initialize();	
		setReportEditable(true);
	}
	
	
	/**
	 * Initialize components in this Panel
	 */
	public void initialize() {
		super.initialize();
		
		buttonLeft.setText("Previous");
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event ) {
				if (event.getID() == ActionEvent.ACTION_PERFORMED) {
					if(getCardComponentIndex() != 0) {
						clContainer.previous(mCards);
						buttonRight.setText("Next");
					}
					decrementCardLayoutCounter();
				}
			}
		});
		
		buttonRight.setText("Next");
		buttonRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					boolean validInfo = false;
					if(mCards.getComponent(getCardComponentIndex()).getName() ==  REPORTER_PANEL) {
						// Check and commit changes to this panel and the model
						validInfo = reporterGUI.isValidInfo();
						if(validInfo){
							// Commit changes to the model.
							reportContainer = reporterGUI.updateReport(reportContainer, false);
						}
					} else if (mCards.getComponent(getCardComponentIndex()).getName() == VICTIM_PANEL) {
						validInfo = victimGUI.isValidInfo();
						if(validInfo) {
							reportContainer = victimGUI.updateReport(reportContainer, false);
						}
					} else if (mCards.getComponent(getCardComponentIndex()).getName() == VICTIM_ADD_INFO_PANEL) {
						validInfo = victimAddGUI.isValidInfo();
						if(validInfo) {
							reportContainer = victimAddGUI.updateReport(reportContainer, false);
						}
					} else if(mCards.getComponent(getCardComponentIndex()).getName() == GUARDIAN_PANEL) {
						validInfo = guardianGUI.isValidInfo();
						if(validInfo) {
							reportContainer = guardianGUI.updateReport(reportContainer, false);
						}
					} else if(mCards.getComponent(getCardComponentIndex()).getName() == DESCRIPTION_PANEL) {
						validInfo = descriptionGUI.isValidInfo();
						if(validInfo) {
							boolean resp = false;
							reportContainer = descriptionGUI.updateReport(reportContainer, false);
							try {
								resp = sendReportToServer(reportContainer, serverConnectionType.CREATE);
							} catch (JsonGenerationException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (JsonMappingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
									e.printStackTrace();
							}
							// Successful submission means we can close the window.
							if(resp) {
								mFrame.dispose();
							}
						}
					}
				
					// Only proceed if the information is valid
					if(validInfo){
						if(componentIndex != (mCards.getComponents().length - 1)) {
							clContainer.next(mCards);
							incrementCardLayoutCounter();
						}
						if(componentIndex == (mCards.getComponentCount() -1)) {
							buttonRight.setText("Submit");
						} else {
							buttonRight.setText("Next");
						}
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
	}
	
	
}
