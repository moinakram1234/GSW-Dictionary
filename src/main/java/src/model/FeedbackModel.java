package src.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;

import DataBase.FeedBackConnection;

public class FeedbackModel {

	ArrayList Arr = new ArrayList();
	
	
	

	public FeedbackModel() {
		Arr.add("moin");
		Arr.add("saud");
		Arr.add("waleed");
	}

	public void feedquery(String word, String feed) throws SQLException {
		try {
		FeedBackConnection feedbackobj1 = new FeedBackConnection();
		Connection conn = feedbackobj1.feedbackconnection();

		String sql = "INSERT INTO `feedbacktable` (Words,Feed) VALUES (?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, word);
		statement.setString(2, feed);

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user feedback was inserted successfully!");
			
		}
		
		}
		catch(SQLException e){
			 if (e instanceof SQLIntegrityConstraintViolationException) {
			        // Duplicate entry
				 System.out.println("Duplicate entry error");
			    } else {
			        System.out.println("Unexpected database error occured");
			    }
		}
		
	}
	
	

}
