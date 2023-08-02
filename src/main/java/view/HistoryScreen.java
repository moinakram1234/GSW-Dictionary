package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;
import controller.Flow_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class HistoryScreen extends Parent {
	Controller controllerobj=new Controller();
	public HistoryScreen() throws SQLException
	{
		initialize();
	}

	private void initialize() throws SQLException {
		ArrayList<String> historylist=new ArrayList();
		String showhistory="";
		Button clear=new Button("Clear All");
		Button back=new Button("Go back");
		clear.relocate(70,0);
		TextArea historytext=new TextArea();
		historytext.relocate(0, 100);
		historytext.setPrefWidth(600);
		historytext.setPrefHeight(200);
	
		historylist=controllerobj.ViewHistory();
		for (String a : historylist) {

			showhistory = showhistory + "\n" + a;
			historytext.setText(showhistory);
		}
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Flow_Controller.getinstance().goBack();
			}
		});
			clear.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			try {
				historytext.setText(controllerobj.CleanHistory());;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
			this.getChildren().addAll(historytext,clear,back);
		
	}

}
