package client.controller;

import client.abuse_report.interfaces.ServerAbuseReportInterface;
import client.abuse_report.models.ReportContainer;

/**
 * This class maps the client's abuse report to the server's abuse report models.
 * 
 * @author Matt Orsini
 *
 */
public class MapReportClientToServer implements ServerAbuseReportInterface {

	
	@Override
	public void setReportContainer(ReportContainer clientAbuseReport) {
		
		
	}

}
