package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Investment_controller {

	@FXML
	Button button1;
	
	@FXML
	Button back;
	
	@FXML
	TextField tf1= new TextField();
	
	@FXML
	TextField tf2= new TextField();
	
	@FXML
	TextField tf3= new TextField();

	@FXML
	TextField tf4= new TextField();

	@FXML
	TextField tf5= new TextField();
	
/*	@FXML
	TextField InvDisp= new TextField();
*/
	double total = 0;
	double interest = 0;
	
    @FXML
    private void Calculate() {
    	String amount = tf1.getText();
    	String rate = tf2.getText();
    	String duration = tf3.getText();
    	
    	double acal=Double.parseDouble(amount);
    	double rcal=Double.parseDouble(rate);
    	double dcal=Double.parseDouble(duration);    	
    	interest = ((acal)*(rcal/100)*dcal);
    	total = acal + interest;
    	tf4.setText(Double.toString(interest));
    	tf5.setText(Double.toString(total));
    	

    }
	@FXML
	 public void back() throws Exception 
		{
		
		
		Stage stage = (Stage) back.getScene().getWindow();
	     
	    stage.close();
	    
	     Scene quizScene = new Scene(FXMLLoader.load(getClass().
	     getResource("menu.fxml")));
		 Stage primaryStage1 = new Stage();
		 primaryStage1.setScene(quizScene);
		 primaryStage1.show();
	
	    }
   
   
}    
	
/*
total amount
persentage interest
duration

5000
5
3



interest (5000*5)/100
interest*duration
amount+(interest*duration)
*/