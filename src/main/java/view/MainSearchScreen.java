
package view;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.controlsfx.control.textfield.TextFields;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import src.model.WordsModel;
import controller.Controller;
import controller.Flow_Controller;
import controller.addFvrtController;
import controller.getAllWordsForAuto;

public class MainSearchScreen extends Pane {

	Set<String> possibleWordSet = new HashSet<>();

	public addFvrtController controller;
	public getAllWordsForAuto controllerForAuto = new getAllWordsForAuto();;
	public String meaning, Synonyms;
	public List<String> Synonymslist;
	private MainSearchScreen viewobj;
	public TextField textfield = new TextField();
	public TextField meaningTextfield = new TextField();
	public TextField synonymsTextField = new TextField();
	private Label label = new Label();
	private Label label2 = new Label();
	public Label label3 = new Label();
	private Hyperlink link4 = new Hyperlink();
	private Hyperlink link5 = new Hyperlink();
	private Menu feedBack = new Menu();
	public Menu addToFvrt = new Menu();
	private Button Searchbutton = new Button();
	private Menu loginAsAdmin = new Menu();
	private List<String> wordForAutoComplition = new ArrayList<String>();

	private DropShadow drop = new DropShadow();
	Dialog<String> dialog = new Dialog<String>();
	private static final double Font_size = 20;

	public MainSearchScreen() {
		this.initialize();

		this.controller = new addFvrtController();
		this.label.setId("Label");
		this.label2.setId("Label");
		this.label3.setId("label");
		this.Searchbutton.setId("myButton");

	}

	public void displaymeaningsynonyms(TextField textfieldmeaning, TextField textfieldsynonym,
			MainSearchScreen viewobj) {
		Synonyms = "";
		if (viewobj.meaning == null) {
			textfieldmeaning.setText("Data not found.");
			textfieldsynonym.setText("Data not found.");
		} else {
			textfieldmeaning.setText(viewobj.meaning);
			Iterator<String> it_syn = viewobj.Synonymslist.iterator();
			while (it_syn.hasNext()) {
				Synonyms = it_syn.next() + ", " + Synonyms;
				textfieldsynonym.setText(Synonyms);
			}
		}
	}

	public void textFeildAutoCompletion() {
		ArrayList<String> skr = new ArrayList<String>();
		wordForAutoComplition = controllerForAuto.getAutoCompltionData();
		System.out.print(wordForAutoComplition);
		for (int i = 0; i < this.wordForAutoComplition.size(); i++) {
			skr.add(this.wordForAutoComplition.get(i));
			// skr[i]=this.wordForAutoComplition.get(i);
		}
		TextFields.bindAutoCompletion(textfield, skr);

	}

	// public void setMenu()
	private void initialize() {

		textFeildAutoCompletion();

		MenuBar menuBar = new MenuBar();

		Menu menuFile = new Menu("File");

		Menu menuEdit = new Menu("Edit");

		Menu menuView = new Menu("View");
		this.loginAsAdmin.setText("Admin");
		MenuItem loginAsAdminItem = new MenuItem("login as admin");
		loginAsAdmin.getItems().add(loginAsAdminItem);

		MenuItem addToFvrtItem = new MenuItem("Add To Fvrt");
		this.addToFvrt.getItems().add(addToFvrtItem);

		MenuItem giveFeedback = new MenuItem("Give Feedback");
		this.feedBack.getItems().add(giveFeedback);
		giveFeedback.setOnAction(event -> {
			Flow_Controller.getinstance().navigateTo(ViewProvider.giveFeedback);
		});

		menuBar.getMenus().addAll(menuFile, loginAsAdmin, addToFvrt, feedBack, menuEdit, menuView);

		MenuItem help = new MenuItem("Help");
		MenuItem history = new MenuItem("History");
		MenuItem options = new MenuItem("options");
		MenuItem favourites = new MenuItem("favourites");
		MenuItem darkMode = new MenuItem("DarkMode");
		MenuItem BlueMode = new MenuItem("BlueMode");
		menuView.getItems().add(history);
		menuFile.getItems().add(help);
		menuFile.getItems().add(options);
		menuFile.getItems().add(favourites);
		menuFile.getItems().add(darkMode);
		menuFile.getItems().add(BlueMode);

		help.setOnAction(event -> {

			Flow_Controller.getinstance().navigateTo(ViewProvider.helpView);
		});
		options.setOnAction(event -> {

			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setContentText("This feature is not available yet.");
			errorAlert.showAndWait();
		});
		favourites.setOnAction(event -> {

			Flow_Controller.getinstance().navigateTo(ViewProvider.giveFavrites);
		});
		switchDarkMode(darkMode);
		switchBlueMode(BlueMode);
		ViewHistory(history);
		this.label2 = new Label("");
		this.label2.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
		this.label2.setTextFill(Color.web("WHITE"));
		this.label2.relocate(80, 170);

		this.label3.setFont(Font.font("Verdana", FontWeight.BOLD, 17));
		this.label3.setTextFill(Color.web("WHITE"));
		this.label3.relocate(350, 170);

		this.addToFvrt.setText("Add Favourite");
		/* this.addToFvrt.relocate(450, 170); */

		// Model model=new Model();
		addToFvrtItem.setOnAction(event -> {

			String getFvrt = this.textfield.getText();
			String getFvrtMeaning = this.meaningTextfield.getText();

			try {
				controller.setFvrtWOrd(getFvrt, getFvrtMeaning);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		showMeaningTextField();

		synonymsTextField();

		searchBoxTextField();

		this.link4.relocate(610, 350);
		this.link4.setText("Synonyms");
		this.link4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setContentText("This feature is not available yet.");
				errorAlert.showAndWait();
			}
		});

		this.link5.relocate(437, 400);
		this.link5.setText("View more");
		this.link5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setContentText("This feature is not available yet.");
				errorAlert.showAndWait();
			}
		});

		this.Searchbutton.setText("Search");
		this.Searchbutton.relocate(625, 60);

		this.drop.setBlurType(BlurType.GAUSSIAN);
		this.drop.setColor(Color.GREY);
		this.drop.setHeight(100);
		this.drop.setWidth(150);
		this.drop.setOffsetX(6);
		this.drop.setOffsetY(10);
		this.drop.setSpread(0.12);
		this.drop.setRadius(10);
		label.setEffect(drop);

		this.feedBack.setText("Give Feedback");

		this.getChildren().addAll(menuBar, Searchbutton, textfield, meaningTextfield, synonymsTextField, label, label2,
				link4);

		Searchbutton.setOnAction(event -> {
			String match_word = textfield.getText();
			Controller controllerobj = new Controller(match_word);
			try {
				controllerobj.Inserthistory(match_word);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			viewobj = new MainSearchScreen();
			controllerobj.searchdata(match_word, viewobj);
			viewobj.displaymeaningsynonyms(meaningTextfield, synonymsTextField, viewobj);

		});
		loginAsAdminItem.setOnAction(event -> {
			Flow_Controller.getinstance().navigateTo(ViewProvider.Login);
		});

	}

	public void switchDarkMode(MenuItem darkMode) {
		darkMode.setOnAction(event -> {
			if (darkMode.getText().toString() == "DarkMode") {
				Flow_Controller.getinstance().darkMode();
				darkMode.setText("LightMode");
			} else if (darkMode.getText().toString() == "LightMode") {
				Flow_Controller.getinstance().lightMode();
				darkMode.setText("DarkMode");
			}

		});
	}

	public void switchBlueMode(MenuItem BlueMode) {
		BlueMode.setOnAction(event -> {
			if (BlueMode.getText().toString() == "BlueMode") {
				Flow_Controller.getinstance().blueMode();
				BlueMode.setText("LightMode");
			} else if (BlueMode.getText().toString() == "LightMode") {
				Flow_Controller.getinstance().removeblueMode();
				BlueMode.setText("BlueMode");
			}

		});
	}

	public void searchBoxTextField() {

		this.textfield.setPromptText("Search here");

		this.textfield.relocate(10, 60);
		this.textfield.setPrefWidth(600);
		this.textfield.setAlignment(Pos.TOP_LEFT);
		this.textfield.setId("TextField");
	}

	public void synonymsTextField() {
		this.synonymsTextField.setPromptText("Output for synonyms will be shown here");
		this.synonymsTextField.relocate(8, 400);
		this.synonymsTextField.setPrefWidth(685);
		this.synonymsTextField.setPrefHeight(140);
		this.synonymsTextField.setAlignment(Pos.TOP_LEFT);
		synonymsTextField.setId("TextField");
	}

	public void showMeaningTextField() {
		meaningTextfield.setPromptText("");
		meaningTextfield.relocate(8, 95);
		meaningTextfield.setPrefWidth(685);
		meaningTextfield.setPrefHeight(250);
		meaningTextfield.setAlignment(Pos.TOP_LEFT);
		meaningTextfield.setId("TextField");
	}
	public void ViewHistory( MenuItem history) 
	{    
		history.setOnAction(event -> {
			Flow_Controller.getinstance().navigateTo(ViewProvider.history);
		                   
				});
	}
	

}

//CSS
