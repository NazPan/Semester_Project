package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	Thread_Handler th = new Thread_Handler();
	//Thread_Handler th = new Thread_Handler();
	@Override
	public void start(Stage primaryStage) throws IOException {
		th.run_2();
		Parent root= FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		primaryStage.setTitle("Restaurant Managment System");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
