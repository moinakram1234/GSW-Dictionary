package src.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import DataBase.dataBase;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import view.MainSearchScreen;

public class Model {
	

	
	
	List<String> word;
	List<String> meaning;
	dataBase data;
	public Model()
	{
	data=new dataBase();	
	
	}
	public void writeInToTheFiles(String word,String meaning) throws SQLException
	{
		
		data.setData(word,meaning);	
		
	}

	public List<String> getFvrtWords() 
	{
	    
	   
		return word;
	}
	public List<String> getWord()
	{
		data.getData();	
		   word=data.getWord();
		   meaning=data.getitsMeaning();
		   
		return this.word;
		//System.out.print("ok"+word);
		//  for(int i=0;i<word.size(); i++)
		  // {
			//  System.out.print(word.get(i));
		  //}
	
	}
	public List<String> itsMeaning()
	{
		
		return meaning;
	}

}
