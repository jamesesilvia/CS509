package cs509.grp8.arest.report;

public interface CreateReportInterface {

	/**
	 * This function should check that the information entered by the user is indeed valid and 
	 * ready to be entered to the ReportContainer.
	 */
	boolean isValidInfo();
	
	/**
	 * Write the valid information to the ReportContainer.
	 */
	Object commitInfo();
	
}
