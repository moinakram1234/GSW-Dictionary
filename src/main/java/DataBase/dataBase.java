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



public class dataBase {
	
	
	 private List<String>  word=new ArrayList<String>();
	 private List<String> itsMeaning= new ArrayList<String>();;
	 private String id;
	
	public Connection conn = null;
	
	
	public List<String>  getWord()
	{
	   return word;
	}
	public List<String>  getitsMeaning()
	{
	   return itsMeaning;
	}
	
	public void connectDataBase()
	{
		try
        {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/userdatabase";
            Class.forName ("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection (url, userName, password);
            System.out.println ("Database connected");
        
        
         
        }
        catch (Exception e)
        {
            System.err.println ("Cannot connect to database server");
        }
       
	}
	 public void setData(String getWord,String meaning) throws SQLException
	    {
		 this.connectDataBase();
		 this.sendDataToDataBase(getWord,meaning);		
         
	    }
	 public void getData()
	 {
		 
		 this.connectDataBase();
		 try {
			this.getFvrtFrom_dataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	
	 public void sendDataToDataBase(String getWord,String getMeaning) throws SQLException
	 {
		 
		 if(getWord==""||getMeaning=="")
		 {
			 Alert errorAlert = new Alert(AlertType.INFORMATION);
				errorAlert.setContentText("Pease enter any word ");
				errorAlert.showAndWait();
			 
			return; 
		 }
		 
		 try {
			 String query = "INSERT INTO `username`(`word`, `itsMeaning`, `id`) VALUES (?, ?, ?)";
			 PreparedStatement preparedStmt = conn.prepareStatement(query);
			 preparedStmt.setString (1, getWord);
		      preparedStmt.setString (2, getMeaning);
		      preparedStmt.setInt(3, 21);;
		      preparedStmt.execute();  
			} catch (SQLException e) {
			    if (e instanceof SQLIntegrityConstraintViolationException) {
			    	
			    	Alert errorAlert = new Alert(AlertType.INFORMATION);
					errorAlert.setContentText("This word is already added to favourite");
					errorAlert.showAndWait();

			    } else {
			        // Other SQL Exception
			    }
			}
		}
	 
     public void getFvrtFrom_dataBase() throws SQLException 
     {
    	 
    	 
    	 
    	 String sql="SELECT * FROM `username` ORDER BY `username`.`word`";
		 Statement stat=conn.createStatement();
		ResultSet set= stat.executeQuery(sql);
		 
		while(set.next())
		{
			word.add(set.getString("word"));
			itsMeaning.add(set.getString("itsMeaning"));
			//this.id[i++]=set.getString("id");
			
		
		}
		
		
     }
     
    

}
