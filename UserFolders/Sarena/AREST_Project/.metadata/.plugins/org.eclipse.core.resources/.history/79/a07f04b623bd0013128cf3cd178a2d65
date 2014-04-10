package client.abuse_report.interfaces;

import client.abuse_report.models.Abuser;
import client.abuse_report.models.Reporter;
import client.abuse_report.models.Victim;

public interface CreateReportInterface {

	/**
	 * This function should check that the information entered by the user is indeed valid and 
	 * ready to be entered to the ReportContainer.
	 */
	boolean isValidInfo();
	
	/**
	 * Commit any changes to the reporter object.
	 * @param reporter - the reporter object to change.
	 * @return - the updated reporter object.
	 */
	Reporter commitReporter(Reporter reporter);
	/**
	 * Commit any changes to the abuser object.
	 * @param abuser - the abuser object to change.
	 * @return - the updated abuser object.
	 */
	Abuser commitAbuser(Abuser abuser);
	/**
	 * Commit any changes to the victim object.
	 * @param victim - the victim object to change.
	 * @return - the updated victim object.
	 */
	Victim commitVictim(Victim victim);
	
}
