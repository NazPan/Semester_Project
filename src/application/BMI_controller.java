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

public class BMI_controller {

	@FXML
	Button button1;
	
	@FXML
	Button back;
	
	@FXML
	TextField PriceDisp= new TextField();
	
	@FXML
	TextField DisDisp= new TextField();
	
	@FXML
	TextField DiscDisp= new TextField();
	
/*	@FXML
	TextField InvDisp= new TextField();
*/
	double new_price=0;
	
    @FXML
    private void Calculate() {
      
    	String price = PriceDisp.getText();
        String discount = DisDisp.getText();

    	double pcal=Double.parseDouble(price);
    	double dcal=Double.parseDouble(discount);
    	
    	pcal *=pcal;
    	new_price  = dcal/pcal;

    	DiscDisp.setText(Double.toString(new_price));
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