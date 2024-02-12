package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class Controller implements Initializable{
	
	@FXML
	private Spinner<Integer> mySpinner;
	
	@FXML
	private Label myLabel1;
	
	int currentValue;
	// -------------------------------------------
	@FXML
	private ListView<String> myListView;
	
	@FXML
	private Label myLabel2;
	
	String[] food = {"pizza", "sushi", "Ramen"};
	
	String currentFood;
	// ---------------------------------------------
	@FXML
	private TreeView treeView;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
		valueFactory.setValue(1);
		
		mySpinner.setValueFactory(valueFactory);
		
		currentValue = mySpinner.getValue();
		
		myLabel1.setText(Integer.toString(currentValue));
		
		mySpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				// TODO Auto-generated method stub
				currentValue = mySpinner.getValue();
				
				myLabel1.setText(Integer.toString(currentValue));
			}
			
		});
		
		//---------------------------------------
		myListView.getItems().addAll(food);
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				currentFood = myListView.getSelectionModel().getSelectedItem();
				myLabel2.setText(currentFood);
			}
			
		});
		
		//---------------------------------
		TreeItem<String> rootItem = new TreeItem<>("Files");
		
		TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
		TreeItem<String> branchItem2 = new TreeItem<>("Videos");
		TreeItem<String> branchItem3 = new TreeItem<>("Music");
		
		TreeItem<String> leafItem1 = new TreeItem<>("Pictures1");
		TreeItem<String> leafItem2 = new TreeItem<>("Pictures2");
		TreeItem<String> leafItem3 = new TreeItem<>("Video1");
		TreeItem<String> leafItem4 = new TreeItem<>("Video2");
		TreeItem<String> leafItem5 = new TreeItem<>("Music1");
		TreeItem<String> leafItem6 = new TreeItem<>("Music2");
		
		branchItem1.getChildren().addAll(leafItem1, leafItem2);
		branchItem2.getChildren().addAll(leafItem3, leafItem4);
		branchItem3.getChildren().addAll(leafItem5, leafItem6);
		
		rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);
		treeView.setRoot(rootItem);
	}
	
	public void selectItem() {
		TreeItem<String> item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
		if (item != null) {
			System.out.println(item.getValue());
		}
		
	}
	
	public void newMethod() {
		System.out.println("You selected the new Item!");
	}

}
