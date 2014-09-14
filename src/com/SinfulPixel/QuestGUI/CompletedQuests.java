package com.SinfulPixel.QuestGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class CompletedQuests {

	private JFrame frmCompletedQuests;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CompletedQuests window = new CompletedQuests();
					window.frmCompletedQuests.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CompletedQuests() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCompletedQuests = new JFrame();
		frmCompletedQuests.setTitle("Completed Quests");
		frmCompletedQuests.setBounds(100, 100, 789, 467);
		frmCompletedQuests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
