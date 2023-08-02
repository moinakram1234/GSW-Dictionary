package src.model;

import DataBase.FeedBackConnection;
import controller.ViewFeedbackController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.sql.DriverManager;

public class ViewFeedbackModel {
	
	// Model Query to show fetch feedback and pass to other classes to show on textfield
	 public ArrayList<String> feedarr = new ArrayList<String>();

	public void viewfeedbackquery() throws SQLException {
		FeedBackConnection feedbackobj2 = new FeedBackConnection();
		Connection conn = feedbackobj2.feedbackconnection();

		String sql = "SELECT * FROM `feedbacktable` ";
		Statement statement = conn.prepareStatement(sql);

		statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

		int count = 0;

		while (result.next()) {
			String name = result.getString(1);
			String pass = result.getString(2);
			String w = result.getString("Words");
			String f = result.getString("Feed");

			String output = "User #%d: %s - %s";
			
            
			feedarr.add(String.format(output, ++count, w, f));
			
		}
	}

    public ArrayList<String> show()
    {
    	
		return feedarr;
    }
		

}
