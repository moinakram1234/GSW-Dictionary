package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import controller.Flow_Controller;

public class LoginScreen extends Pane {
	private static final int Font_size = 20;
	private Label pageTitle;

	public LoginScreen() {

		this.initialize();
	}

	private void initialize() {

		// TODO Auto-generated method stub
		this.pageTitle = new Label();


		this.getChildren().add(pageTitle);
		Label label = new Label("Welcome Admin");
		label.setId("Label");

		Button button = new Button();
		button.setText("Login");
		button.relocate(280, 450);
		button.setPrefWidth(100);
		button.setPrefHeight(50);
		
		TextField Email = new TextField();
		Email.setPromptText("Enter Email");
		Email.setAlignment(Pos.TOP_LEFT);
		Email.relocate(90, 250);
		
		Email.setPrefWidth(500);
		Email.setPrefHeight(50);
		Email.setId("TextField");
		PasswordField passWord = new PasswordField();
		passWord.setPromptText("Enter Password");
		passWord.setAlignment(Pos.TOP_LEFT);
		passWord.relocate(90, 350);
		passWord.setPrefWidth(500);
		passWord.setPrefHeight(50);
		passWord.setId("TextField");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
		label.relocate(80, 50);
		DropShadow drop = new DropShadow();
		drop.setBlurType(BlurType.GAUSSIAN);
		drop.setColor(Color.GREY);
		drop.setHeight(100);
		drop.setWidth(150);
		drop.setOffsetX(6);
		drop.setOffsetY(10);
		drop.setSpread(0.12);
		drop.setRadius(10);

		Email.setEffect(drop);
		passWord.setEffect(drop);
		label.setEffect(drop);
		button.setEffect(drop);

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (Email.getText().equals("admin") && passWord.getText().equals("admin")) {
					Flow_Controller.getinstance().navigateTo(ViewProvider.HOMESCREEN);
				} else {
					Alert errorAlert = new Alert(AlertType.ERROR);
					errorAlert.setContentText("Your email or Passoword is wrong");
					errorAlert.showAndWait();

				}

			}
		});
		this.getChildren().add(Email);
		this.getChildren().add(passWord);
		this.getChildren().add(button);
		this.getChildren().add(label);
	}

}
