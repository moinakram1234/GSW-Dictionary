
package App;

import controller.Flow_Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	private final Flow_Controller flowcontroller = Flow_Controller.getinstance();
    @Override
    public void start(Stage mainWindow) {
    	
        mainWindow.setTitle("Dictiony");
		this.flowcontroller.setStage(mainWindow);
		this.flowcontroller.startApplication();
    }

    public static void main(String[] args) {

        launch();
       
    }

}