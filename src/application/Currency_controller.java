package application;

//import java.io.IOException;

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

public class Currency_controller {

	@FXML
	Button button1;

	@FXML
	Button back;
	
	@FXML
	Button button2;

	@FXML
	TextField PriceDisp= new TextField();
		
	@FXML
	TextField CurrDisp= new TextField();
	
/*	@FXML
	TextField InvDisp= new TextField();
*/
	double new_price=0;
	
    @FXML
    private void Calculate_Rupees() {
      
    	String price = PriceDisp.getText();

    	double pcal=Double.parseDouble(price);
    	new_price = pcal * 176.97;

    	String str = Double.toString(new_price);
    	CurrDisp.setText((str + " Rupees"));
    	
    }
    @FXML
    private void Calculate_Dollar() {
      
    	String price = PriceDisp.getText();

    	double pcal=Double.parseDouble(price);
    	new_price = pcal / 176.97;
    	String str = Double.toString(new_price);
    	CurrDisp.setText((str + " Dollars"));
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