package application;

import java.io.File;
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
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private Label myLabel = new Label(); // Create label to display time left
	@FXML
	private Button myPlayButton, myPauseButton, myResetButton, mySubmitButton;
	@FXML
	private TextField myTextField;
	
	private int timeInSec = 120; // time in sec used for the count down timer.
	
	private ObjectProperty<java.time.Duration> remainingDuration = new SimpleObjectProperty<>(java.time.Duration.ofSeconds(timeInSec));
	
	private Timeline countDownTimeLine = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> 
	remainingDuration.setValue(remainingDuration.get().minus(1, ChronoUnit.SECONDS))));
	
	private File file;
	private Media mediaAlarm;
	private MediaPlayer mediaAlarmPlayer;
	
	private File file2;
	private Media mediaButton;
	private MediaPlayer mediaButtonPlayer;
	
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
		
		// ALarm sound
		//file = new File("C:\\Users\\migue\\eclipse-workspace\\PomodoroFX\\src\\application\\ClassicAlarm.mp3");
		file = new File("ClassicAlarm.mp3");
		mediaAlarm = new Media(file.toURI().toString());
		mediaAlarmPlayer = new MediaPlayer(mediaAlarm);
		
		// Show alert when time is up (optional?)
		countDownTimeLine.setOnFinished(event -> new Alert(Alert.AlertType.INFORMATION).show());
		//countDownTimeLine.setOnFinished(event -> mediaAlarmPlayer.play());
		countDownTimeLine.setOnFinished(event -> {
			mediaAlarmPlayer.play();
			mediaAlarmPlayer.seek(Duration.seconds(0.0));
		});
		
		file2 = new File("Old_Switch_01.wav");
		mediaButton = new Media(file2.toURI().toString());
		mediaButtonPlayer = new MediaPlayer(mediaButton);
		
		// Start the time line
		//countDownTimeLine.play();
		

	}
	
	public void playTimer() {
		if (remainingDuration.get().toMinutesPart() != 0 ) {
			countDownTimeLine.play();
			mediaButtonPlayer.play();
			mediaButtonPlayer.seek(Duration.seconds(0.0));
		} else {
			System.out.println("Reset Time Please.");
		}
		
	}
	
	public void pauseTimer() {
		countDownTimeLine.pause();
		mediaButtonPlayer.play();
		mediaButtonPlayer.seek(Duration.seconds(0.0));
	}
	
	public void resetTimer() {
		countDownTimeLine.stop();
		remainingDuration.set(java.time.Duration.ofSeconds(timeInSec));
		mediaButtonPlayer.play();
		mediaButtonPlayer.seek(Duration.seconds(0.0));
	}
	
	public void submit(ActionEvent event) {
		try {
			int timeInMin = 0;
			timeInMin = Integer.parseInt(myTextField.getText());
			timeInSec = (int) timeInMin * 60;
			remainingDuration.set(java.time.Duration.ofSeconds(timeInSec));
			countDownTimeLine.setCycleCount((int) remainingDuration.get().getSeconds()); // Recalculate the cycle count
			mediaButtonPlayer.play();
			mediaButtonPlayer.seek(Duration.seconds(0.0));
		} 
		catch (NumberFormatException e) {
			System.out.println("Enter a number Please.");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
}