package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Menu_controller 

{

	@FXML
	Button button1;
	

	@FXML
	Button button2;


	@FXML
	Button button3;
	

	@FXML
	Button button4;
	

	@FXML
	Button button5;
	

	@FXML
	Button button6;
	
	
	
	
	
	
	@FXML
	 public void Calculator() throws Exception 
		{
		
		
		Stage stage = (Stage) button1.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("Calculator.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }


	

	@FXML
	 public void Age() throws Exception 
		{
		
		
		Stage stage = (Stage) button2.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("Age.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }
	
	
	

	@FXML
	 public void Currency() throws Exception 
		{
		
		
		Stage stage = (Stage) button3.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("Currency.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }
	
	
	@FXML
	 public void Discount() throws Exception 
		{
		
		
		Stage stage = (Stage) button4.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("Discount.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }

	

	@FXML
	 public void Investment() throws Exception 
		{
		
		
		Stage stage = (Stage) button5.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("Investment.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }

	
	

	@FXML
	 public void BMI() throws Exception 
		{
		
		
		Stage stage = (Stage) button6.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("BMI.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }
	
	
}