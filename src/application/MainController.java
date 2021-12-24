package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	//========================================================Variable Declaration=============================================================//
		//Login
	Thread_Handler th = new Thread_Handler();
	@FXML
	public Button LogIn;
	@FXML
	public TextField Username;
	@FXML
	public TextField Password;
	@FXML
	public Label DisplayCorrect;

		//Main Menu
	@FXML
	public Button Reservation;
	@FXML
	public Button Maintenance;
	@FXML
	public Button FeedBack;
	@FXML
	public Button Order;

	@FXML
	public Button MenuBack;
	

	private Stage stage;
	private Scene scene;
	private Parent root;
	private int count = 0;	
	
	private Retaurant restaurant;

	public Retaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Retaurant restaurant) {
		this.restaurant = restaurant;
	}

	
	//====================================================LogIn==========================================================================/
	@FXML
	public void LogIn() throws IOException,ExceptionHandler
	{
		String User=Username.getText();
		String PassWord=Password.getText();
			if(count != 3) {
			if(User.equals("a") && PassWord.equals("1"))
			{
					Stage stage = (Stage) LogIn.getScene().getWindow();
					stage.close();
					
					Scene cal = new Scene(FXMLLoader.load(getClass().
							getResource("MainMenu.fxml")));
							Stage primaryStage1 = new Stage();
							primaryStage1.setScene(cal);
							primaryStage1.show();
			}
			else
			{
				th.run();	
				DisplayCorrect.setText("Incorrect Information.");
				count++;
			}
		}
		else {
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Too many wrong passwords.\nTerminating System!!!!");	
			
		}
		
		Thread_Handler th = new Thread_Handler();
		th.run();
		
	}
	public void ReservationMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void MaintenanceMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("Maintenance.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void FeedBackMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("FeedBack.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void FoodOrderMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("TakeOrder.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
