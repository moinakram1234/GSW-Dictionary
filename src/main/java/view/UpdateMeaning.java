package view;

import java.sql.SQLException;

import controller.Controller;
import controller.Flow_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UpdateMeaning extends Pane{
	
	
	public UpdateMeaning() {
		 Initializer();
	}
void Initializer()
{
	
	
	Button back=new Button();
	back.setText("Back");
	back.prefHeight(43);
	back.prefWidth(90);
	TextField wordtextfield = new TextField();
	wordtextfield.setPromptText("Word");
	wordtextfield.setAlignment(Pos.TOP_LEFT);
	wordtextfield.relocate(90, 250);
	
	wordtextfield.setPrefWidth(500);
	wordtextfield.setPrefHeight(50);
	TextField gridbox = new TextField();
	gridbox.setPromptText("Action");
	gridbox.setAlignment(Pos.TOP_LEFT);
	gridbox.relocate(0, 500);
	
	gridbox.setPrefWidth(700);
	gridbox.setPrefHeight(160);
	TextField meaningtextfield = new TextField();
	meaningtextfield.setPromptText("Meaning");
	meaningtextfield.setAlignment(Pos.TOP_LEFT);
	meaningtextfield.relocate(90, 350);
	meaningtextfield.setPrefWidth(500);
	meaningtextfield.setPrefHeight(50);
	Button updatebtn=new Button();
	updatebtn.setText("Update");
	updatebtn.relocate(280, 450);
	updatebtn.setPrefWidth(100);
	updatebtn.setPrefHeight(50);
	this.getChildren().addAll(wordtextfield,meaningtextfield,back,updatebtn,gridbox);
	back.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			Flow_Controller.getinstance().goBack();;
		}

	});
	
	updatebtn.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent event) {
			Controller controllobj=new Controller();
			String w=wordtextfield.getText();
			String m=meaningtextfield.getText();
			   try {
				String msg=controllobj.updatemeaning(w,m);
				gridbox.setText(msg);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	});
}
}
