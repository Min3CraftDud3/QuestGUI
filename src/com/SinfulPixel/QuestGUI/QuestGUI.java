package com.SinfulPixel.QuestGUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class QuestGUI {

	private JFrame frmQuestguiV;
	static CompletedQuests cq = new CompletedQuests();
	public static JComboBox<Object> questCombo;
	public static JLabel lblQType;
	public static JTextPane qReq;
	public static JPanel panel;
	public static String dir = null;
	public static JTextPane qDesc;
	public static JTextField qName;
	public static JTextField qID;
	public static void main(String[] args) {
		dir = System.getProperty("user.dir");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ymlMgr.popQuest();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					QuestGUI window = new QuestGUI();
					window.frmQuestguiV.setVisible(true);
					CompletedQuests.frmCompletedQuests.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuestguiV = new JFrame();
		frmQuestguiV.setTitle("QuestGUI v1.0");
		frmQuestguiV.setBounds(100, 100, 543, 416);
		frmQuestguiV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmQuestguiV.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("New");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {ymlMgr.createFile();}catch(IOException e){e.printStackTrace();}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save First?","Warning",dialogButton);
				if(dialogResult==0)
					try{ymlMgr.saveToFile();}catch(Exception e){}
				else
				 System.exit(0);
			}
		});
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{ymlMgr.saveToFile();}catch(Exception ex){}
			}
		});
		mnFile.add(mntmSave);
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,Strings.information,"About QuestGUI",JOptionPane.NO_OPTION);
			}
		});
		mnHelp.add(mntmAbout);
		frmQuestguiV.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(796, 390, -796, -387);
		frmQuestguiV.getContentPane().add(panel);
		
		JLabel lblQuestName = new JLabel("Quest Name:");
		lblQuestName.setBounds(10, 11, 108, 14);
		frmQuestguiV.getContentPane().add(lblQuestName);
		
		qName = new JTextField();
		qName.setBounds(139, 8, 380, 20);
		qName.setBorder(BorderFactory.createLineBorder(Color.black));
		frmQuestguiV.getContentPane().add(qName);
		qName.setColumns(10);
		
		JLabel lblQuestId = new JLabel("Quest ID:");
		lblQuestId.setBounds(10, 36, 108, 14);
		frmQuestguiV.getContentPane().add(lblQuestId);
		
		qID = new JTextField();
		qID.setBounds(139, 33, 380, 20);
		qID.setBorder(BorderFactory.createLineBorder(Color.black));
		frmQuestguiV.getContentPane().add(qID);
		qID.setColumns(10);
		
		JLabel lblQuestRequirements = new JLabel("Quest Requirements:");
		lblQuestRequirements.setBounds(10, 61, 108, 14);
		frmQuestguiV.getContentPane().add(lblQuestRequirements);
		
		JLabel lblQuestDescription = new JLabel("Quest Description:");
		lblQuestDescription.setBounds(10, 133, 108, 14);
		frmQuestguiV.getContentPane().add(lblQuestDescription);
		
		qReq = new JTextPane();
		qReq.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		qReq.setBorder(BorderFactory.createLineBorder(Color.black));
		qReq.setBounds(139, 62, 378, 60);
		frmQuestguiV.getContentPane().add(qReq);
		
		qDesc = new JTextPane();
		qDesc.setBackground(UIManager.getColor("CheckBox.interiorBackground"));
		qDesc.setBorder(BorderFactory.createLineBorder(Color.black));
		qDesc.setBounds(139, 133, 378, 60);
		frmQuestguiV.getContentPane().add(qDesc);
		
		lblQType = new JLabel("Quest Type:");
		lblQType.setBounds(10, 204, 97, 14);
		frmQuestguiV.getContentPane().add(lblQType);
		
		JButton btnCommitToFile = new JButton("Commit To File");
		btnCommitToFile.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				ymlMgr.model.addElement(qID.getText());				
				try{
					if(ymlMgr.saveToFile()){
						qDesc.setText(null);
						qReq.setText(null);
						qName.setText(null);
						qID.setText(null);
					}
				}catch(Exception ex){}
			}
		});
		btnCommitToFile.setBounds(203, 326, 120, 23);
		frmQuestguiV.getContentPane().add(btnCommitToFile);
		
		questCombo = new JComboBox<Object>(Strings.questType);
		questCombo.setToolTipText("Select a Quest Type");
		questCombo.setBounds(139, 201, 378, 20);
		frmQuestguiV.getContentPane().add(questCombo);
	}
}
