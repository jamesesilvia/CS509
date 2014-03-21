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
	
	/**
	 * Create the panel.
	 */
	public CreateReportGUI() {
		initialize();	
	}
	
	/**
	 * Initialize components in this Panel
	 */
	public void initialize() {
		mFrame = new JFrame();
		
		containerPanel = new JPanel();
		
		// Create all the cards in this panel.
		ReporterGUI reporterGUI = new ReporterGUI();
		VictimGUI   victimGUI   = new VictimGUI();
		
		// Create the CardLayout and add the cards
		mCards = new JPanel(new CardLayout());
		mCards.add(reporterGUI, REPORTER_PANEL);
		mCards.add(victimGUI,   VICTIM_PANEL);
		
		containerPanel.add(mCards);
		
		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		cancelButton = new JButton("Cancel");
		
		nextButton = new JButton("Next");
		nextButton.setVerticalAlignment(SwingConstants.BOTTOM);
		nextButton.addActionListener(new ActionListener() {
			
			// FIXME: commit changes to report container now
			@Override
			public void actionPerformed(ActionEvent action) {
				if(action.getID() == ActionEvent.ACTION_PERFORMED) {
					System.out.println("Should change cards");
					clContainer.next(mCards);	
				}
			}
		});

		clContainer = (CardLayout) mCards.getLayout();
		mFrame.getContentPane().add(containerPanel);
		SpringLayout sl_containerPanel = new SpringLayout();
		sl_containerPanel.putConstraint(SpringLayout.WEST, cancelButton, 6, SpringLayout.EAST, previousButton);
		sl_containerPanel.putConstraint(SpringLayout.EAST, cancelButton, -336, SpringLayout.EAST, containerPanel);
		sl_containerPanel.putConstraint(SpringLayout.WEST, previousButton, 10, SpringLayout.WEST, mCards);
		sl_containerPanel.putConstraint(SpringLayout.NORTH, nextButton, 6, SpringLayout.SOUTH, mCards);
		sl_containerPanel.putConstraint(SpringLayout.WEST, nextButton, 6, SpringLayout.EAST, cancelButton);
		sl_containerPanel.putConstraint(SpringLayout.EAST, nextButton, -171, SpringLayout.EAST, containerPanel);
		sl_containerPanel.putConstraint(SpringLayout.EAST, previousButton, -489, SpringLayout.EAST, containerPanel);
		sl_containerPanel.putConstraint(SpringLayout.NORTH, cancelButton, 6, SpringLayout.SOUTH, mCards);
		sl_containerPanel.putConstraint(SpringLayout.NORTH, previousButton, 6, SpringLayout.SOUTH, mCards);
		sl_containerPanel.putConstraint(SpringLayout.NORTH, mCards, 0, SpringLayout.NORTH, containerPanel);
		sl_containerPanel.putConstraint(SpringLayout.WEST, mCards, 22, SpringLayout.WEST, containerPanel);
		containerPanel.setLayout(sl_containerPanel);
		containerPanel.add(mCards);
		containerPanel.add(nextButton);
		containerPanel.add(cancelButton);
		containerPanel.add(previousButton);
		//mFrame.getContentPane().setLayout(groupLayout);
		mFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//mFrame.pack();
	}
	
	@Override
	public void run() {
		mFrame.setVisible(true);
	}

}
