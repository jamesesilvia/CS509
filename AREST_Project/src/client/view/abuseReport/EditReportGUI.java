package client.view.abuseReport;

import static us.monoid.web.Resty.content;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import client.model.*;
import client.view.*;
import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

/**
 * Edits an outstanding abuse report by fetching the contents from the server and allowing the user to
 * modify these contents.
 * @author Matt Orsini
 *
 */
public class EditReportGUI extends ViewReportGUI {

	
	public EditReportGUI() {
		componentIndex = 0;
	}	
	
	// Override the view report GUI
	@Override
	public void initialize() {
		super.initialize();
		
		// remove the viewreportpanel and pack again
		containerPanel.remove(viewReportPanel);
		mFrame.pack();
		
		ActionListener[] al;
		al = buttonRight.getActionListeners();
		for(int i=0; i<al.length; i++) {
			buttonRight.removeActionListener(al[i]);
		}
		buttonRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					if(action.getID() == ActionEvent.ACTION_PERFORMED) {
						boolean validInfo = false;
						if(mCards.getComponent(getCardComponentIndex()).getName() ==  REPORTER_PANEL) {
							// Check and commit changes to this panel and the model
							validInfo = reporterGUI.isValidInfo();
							if(validInfo){
								// Commit changes to the model.
								reportContainer = reporterGUI.updateReport(reportContainer, true);
							}
						} else if (mCards.getComponent(getCardComponentIndex()).getName() == VICTIM_PANEL) {
							validInfo = victimGUI.isValidInfo();
							if(validInfo) {
								reportContainer = victimGUI.updateReport(reportContainer, true);
							}
						} else if (mCards.getComponent(getCardComponentIndex()).getName() == VICTIM_ADD_INFO_PANEL) {
							validInfo = victimAddGUI.isValidInfo();
							if(validInfo) {
								reportContainer = victimAddGUI.updateReport(reportContainer, true);
							}
						} else if(mCards.getComponent(getCardComponentIndex()).getName() == GUARDIAN_PANEL) {
							validInfo = guardianGUI.isValidInfo();
							if(validInfo) {
								reportContainer = guardianGUI.updateReport(reportContainer, true);
							}
						} else if(mCards.getComponent(getCardComponentIndex()).getName().equals(DESCRIPTION_PANEL)) {
							validInfo = descriptionGUI.isValidInfo();
							if(validInfo) {
								reportContainer = descriptionGUI.updateReport(reportContainer, true);
							}
						} else if(mCards.getComponent(getCardComponentIndex()).getName() == STATUS_PANEL) {
							validInfo = true;
							reportContainer = statusGUI.updateReport(reportContainer, true);
						} else if(mCards.getComponent(getCardComponentIndex()).getName() == RESULTS_PANEL) {
							boolean resp = false;
							reportContainer = resultsGUI.updateReport(reportContainer, true);
							try {
								resp = sendReportToServer(reportContainer, serverConnectionType.EDIT);
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
			}
		});
	}
	
	/**
	 * Sets the report to edit.
	 * @param the report to edit.
	 */
	public void setReportContainer(Report report) {
		this.reportContainer = report;
	}
	
	/**
	 * Gets the report container being edited.
	 * @return the report being edited.
	 */
	public Report getReportContainer() {
		return reportContainer;
	}
	
	
	
}
