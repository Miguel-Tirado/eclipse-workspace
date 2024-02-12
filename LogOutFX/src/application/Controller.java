package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;
	
	@FXML
	ImageView myImageView;
	@FXML
	Button myButton;
	
	@FXML
	private Label myLabel;
	@FXML
	private TextField myTextField;
	@FXML
	private Button submitButton;
	
	int age;
	
	Image myImage = new Image(getClass().getResourceAsStream("tomatoe1.png"));
	
	Stage stage;
	
	public void displayImage() {
		myImageView.setImage(myImage);
	}
	
	public void logout(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("You're about to logout");
		alert.setContentText("Do you want to save before exiting?: ");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage = (Stage) scenePane.getScene().getWindow();
			System.out.println("you successfully logged out!");
			stage.close();
		}
	
	}
	
	public void submit(ActionEvent event) {
		try {
			age = Integer.parseInt(myTextField.getText());
			System.out.println(age);
			if (age >= 18) {
				myLabel.setText("You are now signed up!");
			} else {
				myLabel.setText("You must be 18+");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Enter only numbers plz");
			myLabel.setText("Enter only numbers plz");
		}
		catch(Exception e) {
			System.out.println(e);
			myLabel.setText("error");
		}
		
	}
	

	
}
