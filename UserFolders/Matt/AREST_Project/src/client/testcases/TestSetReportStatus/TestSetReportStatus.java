package client.testcases.TestSetReportStatus;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import client.abuse_report.set_report_status.views.SetReportStatusGUI;

/**
 * Tests the set report status use case. This test will check that the report does not continue if the
 * textfield does not contain any information.
 * 
 * @author Matt Orsini
 *
 */
public class TestSetReportStatus {

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This test will check two cases:
	 * 1.) The user did not enter anything and tried to continue.
	 * 2.) The user entered data, which should be reflected on the screen. 
	 * @throws IOException
	 */
	@Test
	public void testSetReportStatusNoData() throws IOException {
		SetReportStatusGUI dut = new SetReportStatusGUI();
		try {
			BufferedReader readerNoData = new BufferedReader(new FileReader("TestSetReportStatusNoData.txt"));			                                                                 
			String line = null;
			while((line = readerNoData.readLine()) != null) {
				 dut.getTextArea().setText(line);
			}
			// Get the action listeners
			ActionListener actions[] = dut.getBtnNewButton().getActionListeners();
			// Invoke them!
			for(int i=0; i<actions.length; i++) {
				actions[i].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
			}
			
			if(!dut.getStatusNotSetWarning().isVisible()) {
				fail("Status not set warning should be set.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			fail("Fatal error occurred. Stack trace dumped.");
		}
	}
	
	@Test
	public void testSetReportStatus() throws IOException {
		SetReportStatusGUI dut = new SetReportStatusGUI();
		
		BufferedReader reader = new BufferedReader(new FileReader("TestSetReportStatus.txt"));
		String line = null;
		while((line = reader.readLine()) != null) {
			dut.getTextArea().setText(line);
		}
		ActionListener actions[] = dut.getBtnNewButton().getActionListeners();
		for(int i=0; i<actions.length; i++) {
			actions[i].actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
		}
		
		// Check if the data is valid. 
		if(!dut.isValidInfo()) {
			fail("Data is not considered valid.");
		}
		
		// Make sure the notsetwarning is not present. Should be valid data.
		if(dut.getStatusNotSetWarning().isVisible()) {
			fail("StatusNotSetWarning should not be present");
		}
	}
}
