package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception{
		// TODO Auto-generated method stub
		// Stage stage = new Stage();
		// Create a root node to arrange the different nodes that we have 
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		//Group root = new Group();
		// Adding the root node to the scene 
		// Scene scene	= new Scene(root, 600, 600, Color.LIGHTSKYBLUE);
		Scene scene	= new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		//Text text = new Text();
		/*
		text.setText("Hello world!");
		text.setX(50);
		text.setY(50);
		text.setFont(Font.font("sansarif",50));
		text.setFill(Color.LIMEGREEN);
		
		Line line = new Line();
		line.setStartX(200);
		line.setStartY(200);
		line.setEndX(500);
		line.setEndY(200);
		line.setStrokeWidth(5);
		line.setStroke(Color.ORANGE);
		line.setOpacity(0.5);
		line.setRotate(45);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setX(100);
		rectangle.setY(100);
		rectangle.setWidth(100);
		rectangle.setHeight(100);
		rectangle.setFill(Color.BEIGE);
		rectangle.setStrokeWidth(5);
		rectangle.setStroke(Color.BLACK);
		
		Polygon triangle = new Polygon();
		triangle.getPoints().setAll(
				200.0, 200.0,
				300.0, 300.0,
				200.0, 300.0
				);
		
		triangle.setFill(Color.GRAY);
		
		Circle circle = new Circle();
		circle.setCenterX(350);
		circle.setCenterY(350);
		circle.setRadius(50);
		circle.setFill(Color.ORANGE);
		
		Image pizza = new Image("pizza.png");
		ImageView imageView = new ImageView(pizza);
		imageView.setX(400);
		imageView.setY(400);
		
		

		
		root.getChildren().add(text);
		root.getChildren().add(line);
	    root.getChildren().add(rectangle);
	    root.getChildren().add(triangle);
		root.getChildren().add(circle);
		root.getChildren().add(imageView);
		*/
		//Image icon = new Image("pomodoro-technique.png");
		//stage.getIcons().add(icon);
		//stage.setTitle("Stage Demo Program");
		// Adding the scene to the stage 
		//stage.setFullScreen(true);
		stage.setScene(scene);
		stage.show();
	}
}
