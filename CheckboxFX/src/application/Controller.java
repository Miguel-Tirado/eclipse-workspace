package application;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller implements Initializable{
	@FXML
	private CheckBox myCheckBox;
	@FXML
	private Label myLabel;
	@FXML
	private ImageView myImageView;
	
	@FXML
	private Label myLabel1;
	@FXML
	private RadioButton rButton1, rButton2, rButton3;
	
	@FXML
	private DatePicker myDatePicker;
	@FXML
	private Label myLabel2;
	
	@FXML
	private Pane myPane;
	@FXML
	private ColorPicker myColorPicker;
	
	@FXML
	private Label myLabel3;
	@FXML
	private Slider mySlider;
	
	int myTemperature;
	
	@FXML
	private ProgressBar myProgressBar;
	
	@FXML
	private Button myButton;
	
	@FXML
	private Label myLabel4;
	
	BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));
	
	Image myImage1 = new Image(getClass().getResourceAsStream("lightbulb0.png"));
	Image myImage2 = new Image(getClass().getResourceAsStream("lightbulb1.png"));
	
	public void change (ActionEvent event) {
		if (myCheckBox.isSelected()) {
			myLabel.setText("ON");
			myImageView.setImage(myImage2);
		} else {
			myLabel.setText("OFF");
			myImageView.setImage(myImage1);
		}
	}
	
	public void getFood(ActionEvent event) {
		if (rButton1.isSelected()) {
			myLabel1.setText(rButton1.getText());
		} else if (rButton2.isSelected()) {
			myLabel1.setText(rButton2.getText());
		} else if (rButton3.isSelected()) {
			myLabel1.setText(rButton3.getText());
		}
	}
	
	public void getDate(ActionEvent event) {
		LocalDate myDate = myDatePicker.getValue();
		String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
		myLabel2.setText(myFormattedDate);
		//System.out.println(myDate.toString());
	}
	
	public void changeColor(ActionEvent event) {
		Color myColor = myColorPicker.getValue();
		myPane.setBackground(new Background(new BackgroundFill(myColor, null, null)));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		myTemperature = (int) mySlider.getValue();
		myLabel3.setText(Integer.toString(myTemperature) + "C");
		mySlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				myTemperature = (int) mySlider.getValue();
				myLabel3.setText(Integer.toString(myTemperature) + "C");
			}
			
		});
		
		myProgressBar.setStyle("-fx-accent: green;");
	}
	
	public void increaseProgress() {
		if (progress.doubleValue() < 1) {
			progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + 0.1));
			myProgressBar.setProgress(progress.doubleValue());
			myLabel4.setText(Integer.toString((int) Math.round(progress.doubleValue() * 100)) + "%");
		}
	}
}
