package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import src.model.Model;
import view.ViewFavourites;

public class addFvrtController {
  
	
	//public ViewFavourites fvrt;
	
	public Model model;
	
	public List<String> word;
	public List<String> itsMeaning;
	int id[];
	public addFvrtController() 
	{
     // this.fvrt=new ViewFavourites();
		this.model=new Model();
		this.setFvrtValue();
	
		
	}
		public void setFvrtValue()
		{
			word=model.getWord();
		
			itsMeaning=model.itsMeaning();
		}
		public  List<String> getFvrtValue()
		{
			return word;
		}
		public List<String> getFvrtMEaning()
		{
		return 	itsMeaning;
		}
		public void setFvrtWOrd(String getFvrtWord,String itsMeaning ) throws SQLException
		{
			
			
			model.writeInToTheFiles(getFvrtWord,itsMeaning);
			
		}
		public void functionCalls()
		{
			System.out.print("Called2");
			
			
		}

	}


