package client.view.abuseReport;

import client.model.Report;

public class SetReportResultsGUI extends SetReportStatusGUI implements CreateReportInterface, ViewReportInterface {

	public SetReportResultsGUI() {
		lblNewLabel.setText("Please set the results of this report (if applicable).");
	}

	@Override
	public void updatePanel(Report report, boolean redacted) {
		// Set the status for the selected abuse report.
		textArea.setText(report.getResult());
	}
	
	// No need to override isValidInfo;

	@Override
	public Report updateReport(Report report, boolean redacted) {
		// Set the status of the abuse report.
		report.setResult(textArea.getText());
		return report;
	}
	
}
