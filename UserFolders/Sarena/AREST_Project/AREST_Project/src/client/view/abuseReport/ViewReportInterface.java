package client.view.abuseReport;

import client.model.Report;

public interface ViewReportInterface {

	/**
	 * Updates the report panel to reflect the appropriate changes in the report container.
	 * This method should populate the view with the abuse report.
	 * @param report - the report container to populate the view with.
	 */
	public void updatePanel(Report report);
	
}
