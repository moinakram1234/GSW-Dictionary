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

public class helpView extends Pane {



	
	private Label text = new Label("We are making a dictionary owned by \n"
			+ "\n19F-1001 Muhammad Saud ,\n " + "\n19F-0938 Ghulam Mohay Ud Din,\n" + "\n19F-0953 Waleed Ahmed\n");
	
	public static final String  MainStyle="Styler.css";

	public helpView() {

		this.initialize();
	}

	public void initialize() {

		
		text.setAlignment(Pos.CENTER);
		text.relocate(90, 20);
		text.setPrefWidth(500);
		text.setPrefHeight(500);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
		

		this.getChildren().addAll(text);

	}

}