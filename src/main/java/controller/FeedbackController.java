package controller;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import DataBase.FeedBackConnection;
import src.model.FeedbackModel;
import view.GiveFeedback;

public class FeedbackController {

	FeedbackModel model = new FeedbackModel();
    GiveFeedback feedback=new GiveFeedback();
	
	public void getData(String text, String word) throws SQLException {
		model.feedquery(word,text);
	}
	
	
}