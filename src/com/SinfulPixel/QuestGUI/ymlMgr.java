package com.SinfulPixel.QuestGUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;




public class ymlMgr {
	@SuppressWarnings("rawtypes")
	public static DefaultListModel model = new DefaultListModel();	
	
	public static void createFile() throws IOException{
		File questFile = new File("Quests.yml");
		if(!questFile.exists()){
			questFile.createNewFile();
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    fc.set("QuestFile", "==== [Quest File] ====");		    
		    fc.save(questFile);			
		}
	}
	public static boolean saveToFile() throws IOException{
		File questFile = new File("Quests.yml");
		String id = null;
		if(!questFile.exists()){
			createFile();
			FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    if(!QuestGUI.qID.getText().equals("")){
		    id = QuestGUI.qID.getText();
		    fc.set("QuestFile."+id+".QuestID",QuestGUI.qID.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "ID cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qName.getText().equals("")){
		    fc.set("QuestFile."+id+".QuestName", QuestGUI.qName.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Name cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qDesc.getText().equals("")){
		    fc.set("QuestFile."+id+".QuestDesc", QuestGUI.qDesc.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Description cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qReq.getText().equals("")){
		    	if(QuestGUI.qReq.getText().contains(",")){
		    		String[] s = QuestGUI.qReq.getText().split(",");
		    		List<String> l = new ArrayList<>();
		    		for(String t : s){
		    			l.add(t);
		    		}
		    		fc.set("QuestFile."+id+".QuestReq", l);
		    	}else{
		    		fc.set("QuestFile."+id+".QuestReq", QuestGUI.qReq.getText());
		    	}
		    }
		    if(QuestGUI.questCombo.getSelectedItem() != null){
		    	fc.set("QuestFile."+id+".QuestType", QuestGUI.questCombo.getSelectedItem().toString());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Quest Type cannot be null.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false; 
		    }
		    fc.save(questFile);
		    return true;
		}else{
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    if(!QuestGUI.qID.getText().equals("")){
		    	id = QuestGUI.qID.getText();
		    fc.set("QuestFile."+id+".QuestID",QuestGUI.qID.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "ID cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qName.getText().equals("")){
		    fc.set("QuestFile."+id+".QuestName", QuestGUI.qName.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Name cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qDesc.getText().equals("")){
		    fc.set("QuestFile."+id+".QuestDesc", QuestGUI.qDesc.getText());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Description cannot be empty.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    if(!QuestGUI.qReq.getText().equals("")){
		    	if(QuestGUI.qReq.getText().contains(",")){
		    		String[] s = QuestGUI.qReq.getText().split(",");
		    		for(String t : s){
		    			fc.set("QuestFile."+id+".QuestReq", t);
		    		}
		    	}else{
		    		fc.set("QuestFile."+id+".QuestReq", QuestGUI.qReq.getText());
		    	}
		    }
		    if(QuestGUI.questCombo.getSelectedItem() != null){
		    	fc.set("QuestFile."+id+".QuestType", QuestGUI.questCombo.getSelectedItem().toString());
		    }else{
		    	JOptionPane.showMessageDialog(null,
		    		    "Quest Type cannot be null.",
		    		    "Save Error",
		    		    JOptionPane.ERROR_MESSAGE);
		    	return false;
		    }
		    fc.save(questFile);
		    return true;
		}
	}
	@SuppressWarnings("unchecked")
	public static void popQuest(){
		File questFile = new File("Quests.yml");
		if(questFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    Set<String> ex = fc.getConfigurationSection("QuestFile").getKeys(false); 
		    String[] s = ex.toArray(new String[ex.size()]);
		    for(String t:s){
		    	model.addElement(t);
		    }
		}
	}
	public static String[] popQuests(){
		File questFile = new File("Quests.yml");
		if(questFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    Set<String> ex = fc.getConfigurationSection("QuestFile").getKeys(false); 
		    String[] s = ex.toArray(new String[ex.size()]); 
		    return s;		    
		}
		return null;
	}
	public static void popForm(String s){
		File questFile = new File("Quests.yml");
		if(questFile.exists()){
		    FileConfiguration fc = YamlConfiguration.loadConfiguration(questFile);
		    String name = fc.getString("QuestFile."+s+".QuestName");
		    String ID = fc.getString("QuestFile."+s+".QuestID");
		    String Desc = fc.getString("QuestFile."+s+".QuestDesc");
		    String Req = fc.getString("QuestFile."+s+".QuestReq");
		    String Type = fc.getString("QuestFile."+s+".QuestType");
		    QuestGUI.qID.setText(ID);
		    QuestGUI.qName.setText(name);
		    QuestGUI.qDesc.setText(Desc);
		    QuestGUI.qReq.setText(Req);
		    QuestGUI.questCombo.setSelectedItem(Type);
		}
	}
}
