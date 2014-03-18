package cs509.grp8.arest.controller;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cs509.grp8.arest.report.ReporterGUI;

public class Controller {

	private JFrame mframe;
	private JPanel mCards;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller window = new Controller();
					window.mframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Controller() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mframe = new JFrame();
		mframe.setBounds(100, 100, 450, 300);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReporterGUI createReport = new ReporterGUI();
		mCards = new JPanel(new CardLayout());
		mCards.add(createReport, "Create Report");
		
		mframe.add(mCards);
		mframe.pack();
		CardLayout c1 = (CardLayout)(mCards.getLayout());
		c1.show(mCards, "Create Report");
	}

}
