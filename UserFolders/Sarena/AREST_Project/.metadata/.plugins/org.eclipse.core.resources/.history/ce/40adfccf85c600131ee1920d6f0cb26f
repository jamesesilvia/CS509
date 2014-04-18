package client.abuse_report.views.abuse_report;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import us.monoid.web.AbstractResource;
import static us.monoid.web.Resty.*;
import us.monoid.web.Resty;
import client.abuse_report.models.Report;


/**
 * This class implements methods to connect and send data to the server database for the AREST Project.
 * 
 * @author Matt Orsini
 *
 */
public class ReportToServer {

	private Report        report;
	private ObjectMapper  mapper     = new ObjectMapper();
	private Resty         sendReport = new Resty();
	
	private String json;
	
	private AbstractResource reportResponse;
	
	/**
	 * Empty constructor to create the ReportToServer class.
	 */
	public ReportToServer() {
		
	}
	
	/**
	 * Creates the ReportToServer object and initializes the internal report container.
	 * @param report - the report container
	 */
	public ReportToServer(Report report) {
		this.report = report;
	}
	
	/**
	 * Sends the report to the server by constructing JSON objects.
	 * @param report - the report container.
	 * @return true if the server accepted the data, false otherwise
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public boolean sendToServer(Report report) throws JsonGenerationException, JsonMappingException, IOException {
		// FIXME: need to return success or not...
		json = mapper.writeValueAsString(report);
		sendReport.alwaysSend("Content-Type", "application/json");
		
		reportResponse = sendReport.json("http://cs509-arest.herokuapp.com/report/create", content(json));

		// Got successful response
		if(reportResponse.status(200) == true) {
			System.out.println("Successfully send abuse report!");
		} else {
			System.out.println("Unsuccessful");
		}
		
		return false;
	}
	
	/**
	 * Sends the report to the server by constructing JSON objects.
	 * @return true if the server accepted the data, false otherwise
	 */
	public boolean sendToServer() {
		// FIXME: Need to return success or not...
		if(report == null) {
			
		}
		return false;
	}
	
	
}
