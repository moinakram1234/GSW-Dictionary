package view;

import java.awt.Font;
import java.io.File;
import java.sql.SQLException;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import controller.Controller;
import controller.Flow_Controller;

public class MainScreen extends Pane {
	String word, meaning, synonym;
	private static final int Font_size = 20;
	private Label pageTitle;
	private String checksynonym;

	public MainScreen() {

		this.initialize();
		this.pageTitle.setId("Label");
	}

	private void initialize() {
		Menu selectmeaningsynonym = new Menu("Select");
		MenuItem selectmeaning = new MenuItem("Add Meaning");
		MenuItem selectsynonym = new MenuItem("Add Synonym");
		selectmeaningsynonym.getItems().add(selectmeaning);
		selectmeaningsynonym.getItems().add(selectsynonym);
		MenuBar s_meaning = new MenuBar();
		s_meaning.relocate(100, 270);
		s_meaning.getMenus().add(selectmeaningsynonym);
		// TODO Auto-generated method stub
		this.pageTitle = new Label();
		this.pageTitle.setText("Home screen");
		Button viewfeedaback = new Button();

		Label wlm = new Label();
		wlm.setText("Welcome Admin");
		wlm.relocate(5, 40);
		wlm.setId("Label");

		wlm.setPadding(new Insets(0, 0, 0, 250));
		// buttons
		Button imp_bn = new Button();
		imp_bn.setText("import file");

		imp_bn.relocate(10, 200);
		imp_bn.setPrefWidth(130);
		imp_bn.setPrefHeight(30);
		imp_bn.setId("myButton");

		// update data button
		Button up_bn = new Button();
		up_bn.setText("Update Data");

		up_bn.relocate(180, 200);
		up_bn.setPrefWidth(130);
		up_bn.setPrefHeight(30);
		up_bn.setId("myButton");
		// feedback button
		Button fd_bn = new Button();
		fd_bn.setText("View usersFeedback");

		fd_bn.relocate(350, 200);
		fd_bn.setPrefWidth(130);
		fd_bn.setPrefHeight(30);
		fd_bn.setId("myButton");
		// history button
		Button hs_bn = new Button();
		hs_bn.setText("History");

		hs_bn.relocate(540, 200);
		hs_bn.setPrefWidth(130);
		hs_bn.setPrefHeight(30);
		hs_bn.setId("myButton");
		// save button
		Button s_bn = new Button();
		s_bn.setText("Save");

		s_bn.relocate(200, 500);
		s_bn.setPrefWidth(130);
		s_bn.setPrefHeight(30);
		s_bn.setId("myButton");
		// synonyms button
		Button sym_bn = new Button();
		sym_bn.setText("synonyms");

		sym_bn.relocate(350, 500);
		sym_bn.setPrefWidth(130);
		sym_bn.setPrefHeight(30);
		sym_bn.setId("myButton");
		// searchfield

		TextField wordfield = new TextField();
		wordfield.setPromptText("Add word");

		wordfield.relocate(100, 300);
		wordfield.setPrefWidth(500);
		wordfield.setPrefHeight(30);
		wordfield.setId("TextField");

		// meaningfield
		TextField meaningfield = new TextField();
		meaningfield.setPromptText("Add Meaning");

		meaningfield.relocate(100, 350);
		meaningfield.setPrefWidth(500);
		meaningfield.setPrefHeight(30);
		meaningfield.setId("TextField");
		// synonyms
		TextField synonymfield = new TextField();
		synonymfield.setPromptText("Add Synonym");

		synonymfield.relocate(100, 350);
		synonymfield.setPrefWidth(500);
		synonymfield.setPrefHeight(30);
		synonymfield.setId("TextField");
		//// search word from database
		TextField searchfield = new TextField();
		searchfield.setPromptText("Search Word for add Synonyms");

		searchfield.relocate(300, 100);
		searchfield.setPrefWidth(250);
		searchfield.setPrefHeight(30);
		searchfield.setId("TextField");
		///// search button
		Button search_bn = new Button();
		search_bn.setText("Search");

		search_bn.relocate(560, 100);
		search_bn.setPrefWidth(130);
		search_bn.setPrefHeight(30);
		search_bn.setId("myButton");

		this.getChildren().addAll(s_meaning, wlm, sym_bn, wordfield, s_bn, hs_bn, fd_bn, up_bn, imp_bn, searchfield,
				meaningfield, synonymfield, search_bn);
		synonymfield.setVisible(false);
		meaningfield.setVisible(false);
		Button Goback = new Button();
		Goback.setId("myButton");

		Goback.setText("Go Back");
		
		Goback.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Flow_Controller.getinstance().goBack();

			}
		});
		fd_bn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Flow_Controller.getinstance().navigateTo(ViewProvider.viewFeedback);

			}
		});
		s_bn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Controller controllerobj = new Controller();
				word = wordfield.getText();
				meaning = meaningfield.getText();
				try {
					controllerobj.insertwordmeaning(word, meaning);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		search_bn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String search_sym = searchfield.getText();
				Controller controllerobj = new Controller();
				try {
					checksynonym = controllerobj.searchsynonym(search_sym);
					if (checksynonym != null)
						;
					{
						wordfield.setText(checksynonym);
						word = wordfield.getText();

					}
					if (checksynonym == null) {
						wordfield.setText("Not Found");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		sym_bn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				Controller controllerobj = new Controller();

				synonym = synonymfield.getText();
				try {
					controllerobj.insertwordsynonym(word, synonym);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		selectmeaning.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				synonymfield.setVisible(false);
				meaningfield.setVisible(true);
			}

		});
		selectsynonym.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				meaningfield.setVisible(false);
				synonymfield.setVisible(true);
			}

		});
		imp_bn.setOnAction(new EventHandler<ActionEvent>() {
			final FileChooser fileChooser = new FileChooser();

			@Override
			public void handle(ActionEvent arg0) {
				Controller controllerobj = new Controller();
				Flow_Controller Flow_Controllerobj = new Flow_Controller();
				File file = fileChooser.showOpenDialog(Flow_Controllerobj.getStage());
				if (file != null) {
					try {
						String path = file.toString();
						controllerobj.readfiledata(path);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					System.out.println("path was not found");

			}
		});
		up_bn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Flow_Controller.getinstance().navigateTo(ViewProvider.updatemeaning);
			}

		});

		this.getChildren().add(Goback);

	}

	public void start1(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
