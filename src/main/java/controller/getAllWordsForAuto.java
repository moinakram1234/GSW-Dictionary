package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import src.model.Model;
import src.model.modelForAutoComplition;
import view.ViewFavourites;

public class getAllWordsForAuto {
  
	
	//public ViewFavourites fvrt;
	
	public modelForAutoComplition model;
	
	public List<String> word;
	public List<String> itsMeaning;
	int id[];
	public getAllWordsForAuto() 
	{
     // this.fvrt=new ViewFavourites();
		this.model=new modelForAutoComplition();
		this.setWordsValue();
		
	
		
	}
		public void setWordsValue()
		{
			
			word=model.getALlword();
		
			itsMeaning=model.itsMeaning();
		}
		public  List<String> getAutoCompltionData()
		{
			
			return word;
		}
		
		
		

	}


