package application;

import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Label myLabel = new Label(); // Create label to display time left
	@FXML
	private Button myPlayButton, myPauseButton, myResetButton;
	
	private ObjectProperty<java.time.Duration> remainingDuration = new SimpleObjectProperty<>(java.time.Duration.ofSeconds(120));
	
	private Timeline countDownTimeLine = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> 
	remainingDuration.setValue(remainingDuration.get().minus(1, ChronoUnit.SECONDS))));
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// Create duration property for time remaining
		//ObjectProperty<java.time.Duration> remainingDuration = new SimpleObjectProperty<>(java.time.Duration.ofSeconds(120));
		
		// Binding with media time format (mm:ss)
		myLabel.textProperty().bind(Bindings.createStringBinding(() -> 
				String.format("%02d:%02d",
						remainingDuration.get().toMinutesPart(),
						remainingDuration.get().toSecondsPart()),
				remainingDuration));
		
		// Create time line to lower remaining duration every second:
		/*Timeline countDownTimeLine = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> 
			remainingDuration.setValue(remainingDuration.get().minus(1, ChronoUnit.SECONDS)))); */
		
		// Set number of cycles (remaining duration in Seconds)
		countDownTimeLine.setCycleCount((int) remainingDuration.get().getSeconds());
		
		// Show alert when time is up (optional?)
		countDownTimeLine.setOnFinished(event -> new Alert(Alert.AlertType.INFORMATION).show());
		
		// Start the time line
		//countDownTimeLine.play();

	}
	
	public void playTimer() {
		countDownTimeLine.play();
	}
	
	public void pauseTimer() {
		countDownTimeLine.pause();
	}
	
	public void resetTimer() {
		countDownTimeLine.stop();
		remainingDuration.set(java.time.Duration.ofSeconds(120));
	}
}