package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



public class databaseForAllWords {
	
	
	 private List<String>  word=new ArrayList<String>();
	
	 private String id;
	
	public Connection conn = null;
	
	
	public List<String>  getWord()
	{
	   return word;
	}
	
	
	public void connectDataBase()
	{
		try
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/dictionary";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("Database connected");
        
        
         
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
        }
       
	}
	
	 public void getData()
	 {
		 
		 this.connectDataBase();
		 try {
			this.setAllWords();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	
	 
     public void setAllWords() throws SQLException 
     {
    	 
    	 
    	 
    	 String sql="SELECT * FROM `dictionarytable` ORDER BY `dictionarytable`.`Word`";
		 Statement stat=conn.createStatement();
		ResultSet set= stat.executeQuery(sql);
		 
		while(set.next())
		{
			word.add(set.getString("word"));
			
			//this.id[i++]=set.getString("id");
			
		
		}
		
		
     }
     
    

}
