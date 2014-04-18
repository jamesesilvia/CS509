package client.view.abuseReport;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import us.monoid.json.JSONException;

/**
 * Edits an outstanding abuse report by fetching the contents from the server and allowing the user to
 * modify these contents.
 * @author Matt Orsini
 *
 */
public class EditReportGUI extends ViewReportGUI {

	
	public EditReportGUI(Long id) throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		setReportEditable(true);
		reportContainer = fetchReportFromServer(id);
		initialize();
	}
	
	public void initialize() {
		super.initialize();
	}
	
}
