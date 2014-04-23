package client.view.abuseReport;

import client.model.Report;

/**
 * This interface describes the desired methods to communicate with the CreateReportGUI.
 * These methods are not required, but recommended.
 * @author Matt Orsini
 *
 */
public interface CreateReportInterface {

	/**
	 * This function should check that the information entered by the user is indeed valid and 
	 * ready to be entered to the ReportContainer.
	 */
	boolean isValidInfo();
	
	/**
	 * Updates the report container during the create report process.
	 * @param report  - the report to update
	 * @param redacted - true if the report is redacted. False otherwise. If redacted, the method must update contents of the redacted fields.
	 * @return
	 */
	public Report updateReport(Report report, boolean redacted);
	
}
