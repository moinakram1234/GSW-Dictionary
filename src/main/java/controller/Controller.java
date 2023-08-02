package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import src.model.WordsModel;
import view.MainSearchScreen;

public class Controller {
	WordsModel model;
	private HashMap<String, WordsModel> WordTable;
    public String[] wordAutoCOmpletion;
	public Controller(String searchword) {
		model = new WordsModel();
		try {
			WordTable = model.FetchData(searchword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	

	public void searchdata(String word, MainSearchScreen viewobj) {
		Iterator<String> it_word = WordTable.keySet().iterator();
		while (it_word.hasNext()) {
			String key = it_word.next();
			if (word.equals(key)) {
				WordsModel db = WordTable.get(key);
				viewobj.meaning = db.getWord();
				viewobj.Synonymslist = db.Synonyms;

			}
		}
	}

	public void insertwordmeaning(String word, String meaning) throws SQLException {
		WordsModel modelobj = new WordsModel();
		modelobj.Insertwordmeaning(word, meaning);
	}

	public void insertwordsynonym(String word, String sym) throws SQLException {
		WordsModel modelobj = new WordsModel();
		modelobj.Insertwordsynonym(word, sym);
	}

	public String searchsynonym(String search_sym) throws SQLException {
		WordsModel modelobj = new WordsModel();
		return modelobj.searchsynonym(search_sym);

	}

	public void readfiledata(String path) throws SQLException {
		WordsModel modelobj = new WordsModel();
		modelobj.readfiledata(path);

	}
	 public String updatemeaning(String word ,String meaning) throws SQLException
	   {
		   
		 WordsModel modelobj = new WordsModel();
		String msg= modelobj.updatemeaning(word, meaning);
		return msg;
		   
	   }
	 public void Inserthistory(String word) throws SQLException
	 {
		 WordsModel modelobj = new WordsModel();
			modelobj.Inserthistory(word);
	 }
	 public String CleanHistory() throws SQLException
	 {
			WordsModel modelobj = new WordsModel();
			return modelobj.CleanHistory();
	 }
	 public ArrayList<String> ViewHistory() throws SQLException
	 {
			WordsModel modelobj = new WordsModel();
			return modelobj.ViewHistory();
	 }
}
