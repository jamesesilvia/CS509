/**
 * 
 */
package common;

import client.abuse_report.models.Abuser;
import client.abuse_report.models.Report;
import client.abuse_report.models.Reporter;

/**
 * Accepts an Abuse Report and produces the redacted abuse report.
 * 
 * @author Matt Orsini
 *
 */
public class RedactionFilter {

	private static final String redacted = "REDACTED";
	
	private Report report;
	private Report redactedReport;
	
	public RedactionFilter () {
		
	}
	
	/**
	 * Redacts the report to the specifications of the AREST project.
	 * @param report the report to redact.
	 * @return the redacted report.
	 */
	public Report redactReport(Report report) {
		redactedReport = report;
		redactedReport.abuser = redactAbuser(redactedReport.abuser);
		return report;
	}
	
	/**
	 * Private function to redact information regarding an abuser.
	 * @param abuser - the abuser to redact information from.
	 * @return the redacted abuser.
	 */
	private Abuser redactAbuser(Abuser abuser) {
		abuser.setFirstName(redacted);
		abuser.setLastName(redacted);
		abuser.setAddress(redacted);
		return abuser;
	}
	
	/**
	 * Private function to redact niformation regarding a reporter.
	 * @param reporter - the reporter to redact information from.
	 * @return the redacted reporter.
	 */
	private Reporter redactReporter(Reporter reporter) {
		reporter.setFirstName(redacted);
		reporter.setLastName(redacted);
		reporter.setAddress(redacted);
		reporter.setPhoneNumber(redacted);
		return reporter;
	}
	
}
