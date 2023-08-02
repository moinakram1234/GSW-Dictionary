package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import DataBase.DataBaseConnection;

public class WordsModel {
	public List<String> Synonyms = new ArrayList<>();
	HashMap<String, WordsModel> WordTable = new HashMap<>();
	DataBaseConnection connectionobj;

	String wordmeaning;

	public WordsModel(String word, List<String> Synonyms) {
		wordmeaning = word;
		this.Synonyms = Synonyms;

	}

	public WordsModel() {
		connectionobj = new DataBaseConnection();
	}

	public String getWord() {
		return this.wordmeaning;
	}

	public void setWord(String wordmeaning) {
		this.wordmeaning = wordmeaning;
	}

	public HashMap<String, WordsModel> FetchData(String searchdata) throws SQLException {
		String word, meaning, syn;
		Connection conn;
		conn = connectionobj.getconnector();

		WordsModel modelobj;
		String sql = "SELECT `dictionarytable`.Word,`dictionarytable`.Meaning,`synonyms`.synonym FROM `dictionarytable`,`synonyms` where `synonyms`.Word=`dictionarytable`.Word and `synonyms`.Word='"
				+ searchdata + "'";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		while (result.next()) {
			word = result.getString("Word");
			meaning = result.getString("Meaning");
			syn = result.getString("synonym");
			Synonyms.add(syn);
			WordTable.put(word, new WordsModel(meaning, Synonyms));
		}
		conn.close();
		return WordTable;
	}
	

	public void Inserthistory(String word) throws SQLException
	 { Connection conn;
	 conn = connectionobj.getconnector();
	 String sql = "INSERT INTO `historytable` (History) VALUES (?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, word);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new Synonym was inserted successfully!");
		}
		conn.close();
	 }
	public void Insertwordmeaning(String word, String meaning) throws SQLException {

		Connection conn;
		conn = connectionobj.getconnector();

		String sql = "INSERT INTO `dictionarytable` (Word, Meaning) VALUES (?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, word);
		statement.setString(2, meaning);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("new word and meaning  was inserted successfully!");
		}
		conn.close();

	}

	public void Insertwordsynonym(String word, String synonym) throws SQLException {
		Connection conn;
		conn = connectionobj.getconnector();

		String sql = "INSERT INTO `synonyms` (Word,synonym ) VALUES (?, ?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, word);
		statement.setString(2, synonym);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new Synonym was inserted successfully!");
		}
		conn.close();
	}

	public String searchsynonym(String searchword) throws SQLException {
		Connection conn;
		conn = connectionobj.getconnector();
		String searchedword = null;
		String sql = "SELECT Word FROM `dictionarytable` where Word='" + searchword + "'";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {
			searchedword = result.getString("Word");

		}
		conn.close();
		if (searchedword != null)
			return searchedword;
		return null;
	}

	@SuppressWarnings("resource")
	public void readfiledata(String path) throws SQLException {
		String word, meaning;
		try (Scanner input = new Scanner(new File(path))) {
			while (input.hasNextLine()) {
				word = "";
				meaning = "";
				String line;
				line = input.nextLine();
				Scanner data = new Scanner(line);

				while (data.hasNext()) {
					word = data.next();
					meaning = data.next();
					while (data.hasNext()) {
						this.Insertwordsynonym(word, data.next());
					}
				}
				this.Insertwordmeaning(word, meaning);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	 public String updatemeaning(String word ,String meaning) throws SQLException
	   {
	    String msg="";
	    int a=0;
	    Connection conn;
		conn = connectionobj.getconnector();
		Statement stmt = conn.createStatement();
		  String sql = "UPDATE `dictionarytable` " +
		            "SET Meaning ='" + meaning + "' where Word='" + word + "'" ;
		         a=stmt.executeUpdate(sql);
		         if(a==0)
		        	 msg="not update data";
		         else
		        	 {msg="update meaning successfuly";
		        	 System.out.println("update meaning successfuly");
		        	 }
		        	 
		return msg;
		   
	   }
	 public ArrayList<String> ViewHistory() throws SQLException
	 {      ArrayList<String> historylist=new ArrayList<String>();
			Connection conn;
			conn = connectionobj.getconnector();
             String history;
			String sql = "SELECT History FROM `historytable`";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				history = result.getString("History");
				historylist.add(history);
			}
			
			return historylist;
		 
	 }
	 public String CleanHistory() throws SQLException
	 {     int a=0;
		    Connection conn;
			conn = connectionobj.getconnector();
			Statement stmt = conn.createStatement();
			  String sql = "DELETE FROM `historytable`" ;
			         a=stmt.executeUpdate(sql);
			         if(a!=0)
			          return "Successfully cleaned.";
			      
			        	 return "Data not cleaned.";
			         
	 }
}
