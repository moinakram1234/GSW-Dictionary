package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
	  Connection conn;
	  public DataBaseConnection() {
		}
	public Connection getconnector() throws SQLException
	{  
	      String dbURL = "jdbc:mysql://localhost:3306/Dictionary";
		String username = "root";
		String password = "";
		 
		try {
		 
		 conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected");
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		return conn;
	}
	
}
