package view;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controller.Flow_Controller;
import controller.addFvrtController;

public class ViewFavourites extends Pane {
	
	public addFvrtController controller=new addFvrtController();  
	private Label pageTitle;
	
	private  List<String>  word=new ArrayList<String>();
	//private  List<String>  word2=new ArrayList<String>();
	private Label label=new Label();
	private Label label2=new Label();	
	private Label label3=new Label();
	private Label label4=new Label();
	
	private static final double Font_size = 20;
	

	public ViewFavourites() {
		  
		
		
		this.initialize();
		this.label.setId("Label");
		this.label2.setId("Label");
		this.label3.setId("Label");
		this.label4.setId("Label");
	}
	
	
	public void setValueWOrd(List<String> list)
	{
	
		this.word=list;
	//	this.initialize(word);
		//this.setFvrtTotables(list);
			//System.out.print(this.word);
		
		
	}
	public void setValueWOrdMeaning(List<String> list)
	{
		//stringValueFeedback=list;
	}
	public void setValueId(List<String> id)
	{
		//stringUsername=id;
		
	}
	public TableView setFvrtTotables() 
	{
		
		System.out.print(controller.word+"ok");	
	
		List<String> stringValueWord =controller.getFvrtValue();
		List<String> stringValueFeedback =  controller.getFvrtMEaning();
		System.out.print(controller.getFvrtMEaning()+"ok");	
		java.util.List<String> stringUsername = Arrays.asList("Sajawal", "Ammad", "Usama", "Ali", "Waleed");
		
		
		TableView<Integer> table = new TableView<>();
		for (int i = 0; i < stringValueWord.size() && i < stringUsername.size(); i++) {
		    table.getItems().add(i);
		}
		
		
		TableColumn<Integer, String> nameColumn = new TableColumn<>("Feedback");
		nameColumn.setCellValueFactory(cellData -> {
		   Integer rowIndex = cellData.getValue();
		   return new ReadOnlyStringWrapper(stringValueFeedback.get(rowIndex));
		});
		
		
		TableColumn<Integer,String > userNameColumn = new TableColumn<>("Username");
		userNameColumn.setCellValueFactory(cellData -> {
		    Integer rowIndex = cellData.getValue();
		    return new ReadOnlyStringWrapper(stringUsername.get(rowIndex));
		});
		
		
		
		TableColumn<Integer, String> wordFor = new TableColumn<>("Word");
		wordFor.setCellValueFactory(cellData -> {
		    Integer rowIndex = cellData.getValue();
		    return new ReadOnlyStringWrapper(stringValueWord.get(rowIndex));
		});

		
		table.getColumns().add(wordFor);
		table.getColumns().add(nameColumn);
		table.getColumns().add(userNameColumn);

		table.setMaxSize(700, 700);
		VBox obj2 = new VBox();
		obj2.setSpacing(15);
	    obj2.setPadding(new Insets(50, 700, 50, 60));
		obj2.getChildren().addAll(table);
		
		table.relocate(250, 200);
		return table;
		
		
	

	}

	private void initialize()  {
		

		
		this.label = new Label("View favourite words");
		this.label.setFont(Font.font("Verdana", FontWeight.BOLD, 45));
		this.label.relocate(60, 50);
		
		this.label2 = new Label("27/7/2021");
		this.label3 = new Label("1/8/2021");
		this.label4 = new Label("17/3/2021");
		
		
		this.label2.relocate(80, 200);
		this.label2.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		

		this.label3.relocate(80, 300);
		this.label3.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		

		this.label4.relocate(80, 400);
		this.label4.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

	
		Button goBack = new Button();
		goBack.setText("Go to Main Screen");
		goBack.setOnAction(event -> {
		Flow_Controller.getinstance().goBack();
		});
		//System.out.print(word2+"ok2");
		TableView table=this.setFvrtTotables();
		this.getChildren().addAll(goBack,table,label,label2,label3,label4);
	}
}