package cs509.grp8.arest.report;

import javax.swing.JPanel;
import java.awt.CardLayout;

public class CreateReportGUI extends JPanel {

	final private static String REPORTER_PANEL = "Reporter Panel";
	final private static String VICTIM_PANEL   = "Victim Panel";
	final private static String ABUSER_PANEL   = "Abuser Panel";
	final private static String GUARDIAN_PANEL = "Guardian Panel";
	
	private JPanel mCards;
	
	/**
	 * Create the panel.
	 */
	public CreateReportGUI() {
		ReporterGUI reporterGUI = new ReporterGUI();
		
		mCards = new JPanel(new CardLayout());
		mCards.add(reporterGUI, REPORTER_PANEL);

	}

}
