package controller;

import java.awt.MultipleGradientPaint.CycleMethod;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.stage.Stage;
import javafx.stage.Window;
import src.model.WordsModel;
import view.MainScreen;
import view.MainSearchScreen;
import view.ViewProvider;

public class Flow_Controller {

	private Stage mainwindow;
	private final Stack<Parent> flowhistory = new Stack<Parent>();
	private Scene mainScene;
	private final ViewProvider viewsProvider = new ViewProvider();
	private WordsModel model = new WordsModel();;

	public static final String NO_view_error = "NO such view Exists";
	private static final Flow_Controller self = new Flow_Controller();
	Parent root2 = this.viewsProvider.getView(ViewProvider.HOMESCREEN);
	Parent root3 = this.viewsProvider.getView(ViewProvider.viewFeedback);
	Parent root4 = this.viewsProvider.getView(ViewProvider.giveFeedback);
	Parent root5 = this.viewsProvider.getView(ViewProvider.giveFavrites);
	Parent root6 = this.viewsProvider.getView(ViewProvider.Login);
	Parent root7 = this.viewsProvider.getView(ViewProvider.mainSearchScreen);

	MainSearchScreen mainSearchScreen = new MainSearchScreen();

	public static Flow_Controller getinstance() {
		return self;
	}

	public Flow_Controller() {

	}

	public void navigateTo(String viewName) {
		Parent view = this.viewsProvider.getView(viewName);
		if (view == null) {
			throw new RuntimeException(Flow_Controller.NO_view_error);

		}
		this.flowhistory.add(view);
		this.mainScene.setRoot(view);
	}

	public void goBack() {
		this.flowhistory.pop();
		this.mainScene.setRoot(this.flowhistory.peek());
	}

	MainSearchScreen click = new MainSearchScreen();

	public void startApplication() {

		if (this.mainwindow == null) {
			throw new RuntimeException("NO window Set");
		}

		Parent root = this.viewsProvider.getView(ViewProvider.mainSearchScreen);

		if (root == null) {
			throw new RuntimeException(Flow_Controller.NO_view_error);
		}

		this.flowhistory.add(root);

		this.mainScene = new Scene(root, 700, 600);


		this.mainwindow.setScene(mainScene);
		this.mainwindow.show();
	}

	public void darkMode() {
		mainScene.getStylesheets().add("Styler.css");
	}

	public void lightMode() {

		mainScene.getStylesheets().remove("Styler.css");
	}
       
    public void blueMode()
	{
		mainScene.getStylesheets().add("blueMode.css");
	}
    public void removeblueMode()
   	{
   		mainScene.getStylesheets().remove("blueMode.css");
   	}
	public void setStage(Stage stage) {
		this.mainwindow = stage;
	}

	public Window getStage() {
		return this.mainwindow;
	}

}
