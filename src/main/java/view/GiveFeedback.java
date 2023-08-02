package view;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.UnaryOperator;

import DataBase.FeedBackConnection;
import controller.FeedbackController;
import controller.Flow_Controller;
import view.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
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

public class GiveFeedback extends Pane {

	int max = 1000;

	private Label feedbackLabel = new Label("Feedback");
	private Label maxWordslabel = new Label("1 / 1000");
	private Button submitButton = new Button();
	private Button backButton = new Button();
	private TextArea feedbackTextfield = new TextArea();
	private TextField showFeedback = new TextField();
	private TextField wordTextfield = new TextField();

	public GiveFeedback() {

		this.initialize();
		this.feedbackLabel.setId("Label");
		this.maxWordslabel.setId("Label");
		this.backButton.setId("myButton");
		this.submitButton.setId("myButton");
		this.feedbackTextfield.setId("TextField");
		this.showFeedback.setId("TextField");
		this.wordTextfield.setId("TextField");
		
	}

	public void initialize() {

		feedbackTextfield.setPromptText("Give your feedback here");

		feedbackTextfield.relocate(90, 190);
		feedbackTextfield.setPrefWidth(500);
		feedbackTextfield.setPrefHeight(200);
		
		if(feedbackTextfield.getText()==null)
		{
			feedbackTextfield.setText("No feedback entered");
	
		}


		showFeedback.setAlignment(Pos.TOP_LEFT);
		showFeedback.relocate(90, 470);
		showFeedback.setPrefWidth(500);
		showFeedback.setPrefHeight(200);
		showFeedback.setPromptText("Given feedback will be shown here : ");

		wordTextfield.setAlignment(Pos.TOP_LEFT);
		wordTextfield.relocate(90, 150);
		wordTextfield.setPrefWidth(500);
		wordTextfield.setPrefHeight(30);
		wordTextfield.setPromptText("Enter word on which feedback is to be submitted");
		
		if(wordTextfield.getText()==null)
		{
			wordTextfield.setText("No word entered");
	
		}

		this.backButton.setText("Back");
		this.backButton.relocate(20, 80);
		this.backButton.setPrefHeight(5);
		this.backButton.setPrefWidth(100);
		backButton.setOnAction(event -> {
			Flow_Controller.getinstance().navigateTo(ViewProvider.mainSearchScreen);
		});

		// Words limit functionality
		UnaryOperator<Change> modifyChange = c -> {
			if (c.isContentChange()) {
				int newLength = c.getControlNewText().length();
				if (newLength > max) {

					String tail = c.getControlNewText().substring(newLength - max, newLength);

					c.setText(tail);

					int oldLength = c.getControlText().length();
					c.setRange(0, oldLength);
				}
			}
			return c;
		};
		feedbackTextfield.setTextFormatter(new TextFormatter(modifyChange));

		submitButton.setText("Submit feedback");
		submitButton.relocate(265, 420);
		submitButton.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

		submitButton.setOnAction(event -> {
			// Feedback submission functionality
			FeedbackController ctrl = new FeedbackController();
			String feedback = feedbackTextfield.getText();
			String feedbackword = wordTextfield.getText();

			// System.out.println(check.get(0));

			try {
				ctrl.getData(feedback, feedbackword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

			showFeedback.setText("Submitted feedback  -->    " + feedbackTextfield.getText());
			feedbackTextfield.clear();

		});

		feedbackLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
		feedbackLabel.relocate(130, 20);

		maxWordslabel.relocate(610, 250);
		maxWordslabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

		this.getChildren().addAll(backButton, feedbackLabel, maxWordslabel, feedbackTextfield, showFeedback,
				submitButton, wordTextfield);

	}

}