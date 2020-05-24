package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeItem.TreeModificationEvent;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeView.EditEvent;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class Main extends Application {
	
	// Create the TreeView
    private final TreeView treeView = new TreeView();
	 // Create the TextField
    private TextField textField = new TextField();
    // Create the TextArea
    private final TextArea textArea = new TextArea();
   
    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TreeviewHelper helper = new TreeviewHelper();
			ArrayList<TreeItem> rooms = helper.getRooms();
			
			
			//Create the root folder
			TreeItem rootItem = new TreeItem("My House");
			//Add children to the root
			rootItem.getChildren().addAll(rooms);
			//Set the root item.
			treeView.setRoot(rootItem);
			//Make the tree editable
			treeView.setEditable(true);
			// Set a cell factory to use TextFieldTreeCell
	        treeView.setCellFactory(TextFieldTreeCell.forTreeView());
	       
	        
	       
			
			VBox rightPane = getRightPane();
			rightPane.getChildren().add(treeView);
			
			HBox root = new HBox();
			root.setSpacing(20);
			root.getChildren().addAll(treeView,rightPane);
			//BorderPane root = new BorderPane();
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Deliverable 1");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private VBox getRightPane() {
		
		//Create the about button.
		   Button AboutBtn = new Button("About");
	        AboutBtn.setOnAction(new EventHandler()
	        {
	            @Override
	            public void handle(Event event)
	            {
	                aboutButton();
	            }
	        });
	        
		// Create the addItemBtn and its corresponding Event Handler
        Button addItemBtn = new Button("Add new Item");
        addItemBtn.setOnAction(new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                addItem(textField.getText());
            }
        });
 
        // Create the removeItemBtn and its corresponding Event Handler
        Button removeItemBtn = new Button("Remove Selected Item");
        removeItemBtn.setOnAction(new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                removeItem();
            }
        });
 
        // Set the preferred number of text rows
        textArea.setPrefRowCount(15);
        // Set the preferred number of text columns
        textArea.setPrefColumnCount(25);
 
        // Create the HBox
        HBox hbox = new HBox();
        // Add Children to the HBox
        hbox.getChildren().addAll(new Label("Item:"), textField, addItemBtn,AboutBtn);
 
        // Create the VBox
        VBox vbox = new VBox();
        // Add children to the VBox
        vbox.getChildren().addAll(new Label("Select an item to add to or remove."),hbox,removeItemBtn);
        // Set the vertical space between each child in the VBox
        vbox.setSpacing(10);
         
        return vbox;
	}

	private void addItem(String value) {
		if (value == null || value.trim().equals("")){
          return;
        }
 
        TreeItem parent = (TreeItem) treeView.getSelectionModel().getSelectedItem();
 
        if (parent == null){
            return;
        }
 
        TreeItem newItem = new TreeItem(value);
        parent.getChildren().add(newItem);
 
        if (!parent.isExpanded())
        {
            parent.setExpanded(true);
        }
	}
	
	private void removeItem()
    {
        TreeItem item = (TreeItem) treeView.getSelectionModel().getSelectedItem();
 
        if (item == null){
            return;
        }
 
        TreeItem parent = item.getParent();
        if (parent == null ){
        	return;
        }
        else{
            parent.getChildren().remove(item);
        }
    }
	private void aboutButton() {
		final AboutBox mainFrame = new AboutBox();
		mainFrame.start();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
