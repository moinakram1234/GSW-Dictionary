package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeedBackConnection {

	// Database applied successfully
	Connection conn;

	public Connection feedbackconnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/feedbackdb";
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
	 public Connection getConnection(){
		  return conn;
		 }

}