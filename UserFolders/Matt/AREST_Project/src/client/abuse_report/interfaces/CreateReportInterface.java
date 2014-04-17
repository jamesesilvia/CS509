package client.abuse_report.interfaces;

import client.abuse_report.models.Report;

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
	 * @param report
	 * @return
	 */
	public Report updateReport(Report report);
	
}
