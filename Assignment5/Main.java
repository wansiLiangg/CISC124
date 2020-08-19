package application;
	
import javafx.application.Application;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			root = FXMLLoader.load(Main.class.getResource("Controller.fxml")); 
			Scene scene = new Scene(root,600,410);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pizza Order System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
