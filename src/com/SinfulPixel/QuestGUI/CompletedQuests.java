package com.SinfulPixel.QuestGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class CompletedQuests {

	public static JFrame frmCompletedQuests;
	public static JList<?> list1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CompletedQuests window = new CompletedQuests();
					window.frmCompletedQuests.setVisible(true);
					frmCompletedQuests.setVisible(true);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmCompletedQuests = new JFrame();
		frmCompletedQuests.setTitle("Completed Quests");
		frmCompletedQuests.setBounds(100, 100, 493, 467);
		frmCompletedQuests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCompletedQuests.getContentPane().setLayout(null);
		
		list1 = new JList(ymlMgr.model);
		list1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String l = list1.getSelectedValue().toString();
				ymlMgr.popForm(l);
			}
		});
		list1.setBounds(10, 36, 457, 381);
		frmCompletedQuests.getContentPane().add(list1);
		
		JLabel lblClickAQuest = new JLabel("Click a quest to load into editor:");
		lblClickAQuest.setBounds(10, 11, 457, 14);
		frmCompletedQuests.getContentPane().add(lblClickAQuest);
	}
}
