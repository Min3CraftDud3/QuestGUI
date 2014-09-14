package com.SinfulPixel.QuestGUI;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;




public class ymlMgr {
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

}
