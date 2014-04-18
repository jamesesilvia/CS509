package client.abuse_report.views.abuse_report;

import static us.monoid.web.Resty.content;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import common.RedactionFilter;
import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import client.abuse_report.models.Report;

public class ViewReportGUI extends ReportGUI {
	
	public ViewReportGUI() {
		initialize();
	}
	
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @throws JSONException 
	 */
	public ViewReportGUI(Long id) throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		reportContainer = fetchReportFromServer(id);
		RedactionFilter rFilter = new RedactionFilter();
		reportContainer = rFilter.redactReport(reportContainer);
		initialize();
		setReportEditable(false);
	}

	/**
	 * Fills in the View to contain all the information fetched from the server.
	 */
	public void initialize() {
		super.initialize();
		
		// FIXME: configure GUIs to update now that we have the new report.
		reporterGUI.updatePanel(reportContainer);
		victimGUI.updatePanel(reportContainer);
		
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
		
	}
	
	/**
	 * Connect to the server and grab a report by ID.
	 * @return the report fetched by the server.
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws JSONException
	 */
	public Report fetchReportFromServer(Long id) throws JsonGenerationException, JsonMappingException, IOException, JSONException{
		ObjectMapper mapper = new ObjectMapper();
		Resty rest = new Resty();
		JSONResource getReportResp;
		Report reportToGrab = new Report();
		
		// FIXME: this is hard-coded. Need to pass in the ID.
		id = 21L;
		reportToGrab.setId(id);
		
		String json = mapper.writeValueAsString(reportToGrab);
		
		rest.alwaysSend("Content-Type", "application/json");
		getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/get", content(json));
		
		Report report = mapper.readValue(getReportResp.object().toString(), Report.class);
		
		return report;
	}
	
	public void setReportEditable(boolean reportEditable) {
		setEnabled(mCards, reportEditable);
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
		}
		
		if(component instanceof Container) {
			for(Component child : ((Container) component).getComponents()) {
				setEnabled(child, enabled);
			}
		}
	}
}
