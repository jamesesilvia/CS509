package cs509.grp8.arest.report;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;

/**
 * Controls the flow of Abuse Report creation. This class also commits changes
 * to the report container.
 * @author Matt Orsini
 *
 */
public class CreateReportGUI extends JFrame implements Runnable {

	final private static String REPORTER_PANEL = "Reporter Panel";
	final private static String VICTIM_PANEL   = "Victim Panel";
	final private static String ABUSER_PANEL   = "Abuser Panel";
	final private static String GUARDIAN_PANEL = "Guardian Panel";
	
	private JFrame mFrame;
	private JPanel containerPanel;
	private JPanel mCards;
	private JButton previousButton;
	private JButton cancelButton;
	private JButton nextButton;
	private CardLayout clContainer;
	
	private static ReporterGUI reporterGUI;
	private static VictimGUI   victimGUI;
	
	private static int componentIndex = 0;
	/**
	 * Create the panel.
	 */
	public CreateReportGUI() {
		initialize();	
	}

	/**
	 * Increment the index of the component (ID) only if it's less than the total number
	 * of cards in the layout.
	 */
	private void incrComponentIndex(){
		if(componentIndex == mCards.getComponents().length){
			componentIndex = 1;
		} else {
			componentIndex++;
		}
	}
	
	/**
	 * Initialize components in this Panel
	 */
	public void initialize() {
		mFrame = new JFrame();
		
		containerPanel = new JPanel();
		
		// Create all the cards in this panel.
		reporterGUI = new ReporterGUI();
		reporterGUI.setName(REPORTER_PANEL);
		victimGUI   = new VictimGUI();
		victimGUI.setName(VICTIM_PANEL);
		
		// Create the CardLayout and add the cards
		mCards = new JPanel(new CardLayout());
		mCards.add(reporterGUI, REPORTER_PANEL);
		mCards.add(victimGUI,   VICTIM_PANEL);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		nextButton = new JButton("Next");
		nextButton.setVerticalAlignment(SwingConstants.BOTTOM);
		nextButton.addActionListener(new ActionListener() {
			
			// FIXME: commit changes to report container now
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					boolean validInfo = false;
					if(mCards.getComponent(componentIndex).getName() ==  REPORTER_PANEL) {
						// Check and commit changes to this panel and the model
						validInfo = reporterGUI.isValidInfo();
						if(validInfo){
							// Commit changes to the model.
							reporterGUI.commitInfo();
						}
					}
					
					// Only proceed if the information is valid
					if(validInfo){
						clContainer.next(mCards);
					}
				}
			}
		});

		clContainer = (CardLayout) mCards.getLayout();
		mFrame.getContentPane().add(containerPanel);
		GroupLayout gl_containerPanel = new GroupLayout(containerPanel);
		gl_containerPanel.setHorizontalGroup(
			gl_containerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_containerPanel.createSequentialGroup()
					.addGroup(gl_containerPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(mCards, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_containerPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(previousButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nextButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
		);
		gl_containerPanel.setVerticalGroup(
			gl_containerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_containerPanel.createSequentialGroup()
					.addComponent(mCards, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_containerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(previousButton)
						.addGroup(gl_containerPanel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_containerPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(nextButton)
								.addComponent(cancelButton)))))
		);
		containerPanel.setLayout(gl_containerPanel);
		//mFrame.getContentPane().setLayout(groupLayout);
		mFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		mFrame.pack();
	}
	
	@Override
	public void run() {
		mFrame.setVisible(true);
	}

}
