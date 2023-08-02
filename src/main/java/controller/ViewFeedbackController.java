package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import DataBase.FeedBackConnection;
import src.model.ViewFeedbackModel;

public class ViewFeedbackController {
	
	// Controller
	// Controller is used to deligate the list of feedbacks between classes
	public ArrayList list;
	//ViewFeedbackModel vm=new ViewFeedbackModel();
	public ArrayList<String>get(ViewFeedbackModel vm)
	{ 
		this.list=vm.show();
		return list;
		
	}

	

}