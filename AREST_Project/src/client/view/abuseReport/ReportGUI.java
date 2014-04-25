package client.view.abuseReport;

import static us.monoid.web.Resty.content;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import client.model.*;

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
	
	public static enum serverConnectionType {
		CREATE, EDIT, DELETE, VIEW
	};
	
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
	
	protected int componentIndex = 0;
	
	protected final Object[] option = {"Yes", "No"};
	
	protected boolean reportEditable = true;
	
	// Each report is associated with a single user. If someone edits the report, they
	// must be responsible for that report.
	protected UserContainer user;
	
	public ReportGUI () {
		// FIXME: Turn this off when simulating
		//initialize();
	}
	
	public void initialize() {
		mFrame = new JFrame();
		
		containerPanel = new JPanel();
		mFrame.getContentPane().add(containerPanel);
		GridBagLayout gbl_containerPanel = new GridBagLayout();
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
		gbc_buttonLeft.insets = new Insets(0, 5, 10, 0);
		gbc_buttonLeft.gridx = 0;
		gbc_buttonLeft.gridy = 1;
		gbc_buttonLeft.weightx = 0.5;
		containerPanel.add(buttonLeft, gbc_buttonLeft);
		
		buttonRight = new JButton("OVERRIDE ME RIGHT");
		buttonRight.setVerticalAlignment(SwingConstants.BOTTOM);
		
		GridBagConstraints gbc_buttonRight = new GridBagConstraints();
		gbc_buttonRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonRight.insets = new Insets(0, 5, 10, 5);
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
		gbc_buttonCenter.insets = new Insets(0, 5, 10, 0);
		containerPanel.add(buttonCenter, gbc_buttonCenter);

		mFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		mFrame.setResizable(false);
		//mFrame.setVisible(true);
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
	
	/**
	 * Sends the new report to the server.
	 * @param the report to send to the server.
	 * @param serverConnectionType - an enum specifying the type of connection you wish to make with the server.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public boolean sendReportToServer(Report report, serverConnectionType connType) 
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Resty rest = new Resty();
		JSONResource getReportResp = null;
		
		String json = mapper.writeValueAsString(report);
		
		rest.alwaysSend("Content-Type", "application/json");
		
		switch(connType) {
			case CREATE: {
				getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/create", content(json));
				break;
			}
			case DELETE: {
				getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/delete", content(json));
				break;
			}
			case EDIT: {
				getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/edit", content(json));
				break;
			}
			default: {
				System.err.println("Failed to communicate with server. Please check report GUI.");
				break;
			}
			
		}
		//getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/create", content(json));
		Object[] option = {"OK"};
		if(getReportResp.status(200)) {
			JOptionPane.showOptionDialog(mFrame, "Successfully submitted report.", "Success!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[0]);
			return true;
		} else {
			JOptionPane.showOptionDialog(mFrame, "Failed to submit report.", "Failed.", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, option, option[0]);
			return false;
		}
	}
	
	/**
	 * Connect to the server and grab a report by ID.
	 * @return the report fetched by the server.
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws JSONException
	 */
	public Report fetchReportFromServer(Long id) 
			throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		Resty rest = new Resty();
		JSONResource getReportResp;
		JSONArray getReportRespArray;
		
		rest.alwaysSend("Content-Type", "application/json");
		getReportResp = rest.json("http://cs509-arest.herokuapp.com/report/getAll");
		getReportRespArray = getReportResp.array();
		for(int i=0; i<getReportRespArray.length(); i++) {
			Report report = mapper.readValue(getReportRespArray.getString(i), Report.class);
			if(report.getId() == id) {
				return report;
			}
		}
		return null;
	}
	
	
	/**
	 * Sets the user associated with this logged in session.
	 * @param user - the user to set.
	 */
	public void setUser(UserContainer user) {
		this.user = user;
	}
	
	/**
	 * Gets the user associated with this logged in session.
	 * @return the user associated with this session.
	 */
	public UserContainer getUser() {
		return user;
	}
	
	/**
	 * Determines if this user is a supervisor.
	 * @return true if the current user is a supervisor, false otherwise.
	 */
	protected boolean isSupervisor() {
		return user.isSupervisor;
	}
	
	/**
	 * Determines if this user created the report.
	 * @param cUser - the current user logged in to the system.
	 * @return true if the current user is the creator, false otherwise
	 */
	protected boolean isCreator() {
		return user.userName.equals(reportContainer.getUsername());
	}

	/**
	 * Returns the button associated on the left of this screen.
	 * @return the buttonLeft
	 */
	public JButton getButtonLeft() {
		return buttonLeft;
	}

	/**
	 * Returns the button associated with the center of this screen.
	 * @return the buttonCenter
	 */
	public JButton getButtonCenter() {
		return buttonCenter;
	}

	/**
	 * Returns the button associated with the right of this screen.
	 * @return the buttonRight
	 */
	public JButton getButtonRight() {
		return buttonRight;
	}

	
}
