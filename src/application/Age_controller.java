package application;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
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

public class Age_controller {

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

	@FXML
	TextField tf6= new TextField();
	
/*	@FXML
	TextField InvDisp= new TextField();
*/
	int date , month , year;
	
    @FXML
    private void Calculate_Age() throws ParseException {
    	LocalDate today =LocalDate.now();
    	year = Integer.parseInt(tf1.getText());
    	month = Integer.parseInt(tf2.getText());
    	date = Integer.parseInt(tf3.getText());
    	LocalDate Birthday = LocalDate.of (year , month , date);
    	Period period = Period.between(Birthday, today);
    	tf4.setText(Integer.toString(period.getYears()));
    	tf5.setText(Integer.toString(period.getMonths()));
    	tf6.setText(Integer.toString(period.getDays()));    	

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
   
    
}/*
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