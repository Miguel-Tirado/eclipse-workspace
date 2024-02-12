package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Controller implements Initializable{
	@FXML
	private ImageView myImage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//translate
		/*
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myImage);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByX(250);
		translate.setByY(-250);
		translate.setAutoReverse(true);
		translate.play(); */
		
		// Rotate
		/*
		RotateTransition rotate = new RotateTransition();
		rotate.setNode(myImage);
		rotate.setDuration(Duration.millis(800));
		rotate.setCycleCount(TranslateTransition.INDEFINITE);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.setByAngle(360);
		rotate.setAxis(Rotate.Z_AXIS);
		rotate.play(); */
		
		// Fade
		/*
		FadeTransition fade = new FadeTransition();
		fade.setNode(myImage);
		fade.setDuration(Duration.millis(1000));
		fade.setCycleCount(TranslateTransition.INDEFINITE);
		fade.setInterpolator(Interpolator.LINEAR);
		fade.setFromValue(0);
		fade.setToValue(1);
		fade.play(); */
		
		// Scale
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(myImage);
		scale.setDuration(Duration.millis(1000));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(2.0);
		scale.setByY(2.0);
		scale.setAutoReverse(true);
		scale.play();
		
		
	}
}
