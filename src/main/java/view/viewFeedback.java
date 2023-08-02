package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.UnaryOperator;

import DataBase.FeedBackConnection;
import controller.FeedbackController;
import controller.Flow_Controller;
import controller.ViewFeedbackController;
import view.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import src.model.ViewFeedbackModel;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class viewFeedback extends Pane {

	// Screen
	private Label viewFeedbackLabel = new Label("View Feedback");
	ArrayList<String> list;
	String str;
	private TextArea display = new TextArea();
	private Button getButton = new Button();
	private Button backButton = new Button();
	
	public viewFeedback() {
		str = "";
		this.initialize();

	}

	private void initialize() {

		viewFeedbackLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 60));
		viewFeedbackLabel.relocate(111, 20);
		//viewFeedbackLabel.setId("Label");
		
		this.backButton.setText("Back");
		this.backButton.relocate(20, 80);
		this.backButton.setPrefHeight(5);
		this.backButton.setPrefWidth(100);
		backButton.setOnAction(event -> {
			Flow_Controller.getinstance().navigateTo(ViewProvider.mainSearchScreen);
		});

		// display.setAlignment(Pos.TOP_LEFT);
		display.relocate(90, 190);
		display.setPrefWidth(500);
		display.setPrefHeight(200);
		display.setPromptText("Given feedback are shown below : ");
        display.setId("TextField");
		// Textfield for feedback display

		getButton.setText("Fetch feedback");
		getButton.relocate(265, 420);
		getButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		// Data fetching event handler 
		getButton.setOnAction(event -> {

			ViewFeedbackModel model = new ViewFeedbackModel();
			ViewFeedbackController controller = new ViewFeedbackController();
			try {
				model.viewfeedbackquery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			list = controller.get(model);

			for (String a : list) {

				str = str + "\n" + a;
				display.setText(str);
			}

		});

		this.getChildren().addAll(viewFeedbackLabel, display, getButton,backButton);

	}

}
