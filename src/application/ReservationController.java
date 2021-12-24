package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReservationController {
	//========================================================Variable Declaration=============================================================//
	Thread_Handler th = new Thread_Handler();
		//Reservation menu
	@FXML
	public Button CheckIn;
	@FXML
	public Button MakeReservation;
	@FXML
	public Button UpdateReservation;
	@FXML
	public Button CancelReservation;
	
			//Customer Data(for reservation)
	@FXML
	public Button ReservationDetails;
	@FXML
	public TextField CustomerName;
	@FXML
	public TextField CustomerContact;
	@FXML
	public Label cusomer_check;
	
			//CheckIn Customer Details
	@FXML
	public TextField time;
	@FXML
	public TextField TableNo;
	@FXML
	public TextField Seats;
	@FXML
	public TextField Discription;
	@FXML
	public Button DisplayDetails;
	
	
			//Reservation Details
	@FXML
	public CheckBox Lunch;
	@FXML
	public CheckBox Dinner;
	@FXML
	public TextField Date;
	@FXML
	public TextField TotalMembers;
	@FXML
	public Button CreateReservation;
	
			//Update Reservation
	@FXML
	public Button ReservationUpdate;
			
			//Cancel Reservation
	@FXML
	public Button ReservationCanceled;

	@FXML
	public Button MenuBack;
	
	private int temp_index;

	private Stage stage;
	private Scene scene;
	private Parent root;
	private int checkIn_count = 0;
	private int update_count = 0;
	private int cancel_count = 0;

	
	//=======================================================Main Menu===============================================================//
	public void MenuBackMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//==========================================================Reservation Menu==============================================================//


	//==============================Check In=============================//
	public void CheckInnMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("CheckIn.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void DisplayReservation(ActionEvent event) throws IOException,ExceptionHandler
	{
		if(checkIn_count != 3) {
			String name = CustomerName.getText();
			String contact = CustomerContact.getText();
			
			temp_index = Singelton.restaurant.check_Customer(name, contact);
			
			if (temp_index==51) {
				cusomer_check.setText("Incorrect Data");
				checkIn_count++;
			}
			else {
				Singelton.restaurant.Verify_setIndex(temp_index);
				
				root = FXMLLoader.load(getClass().getResource("DisplayReservation.fxml"));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		else {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Too many wrong Details.System Terminating!!!\n");
		}
	}
	
	public void Display(ActionEvent event) throws IOException{

		temp_index = Singelton.restaurant.Verify_getIndex();
		Customer temp = Singelton.restaurant.Customer_Check(temp_index);
		
		Date.setText(temp.getDate());
		time.setText(temp.getTime());
		TotalMembers.setText(Integer.toString(temp.getNoOfPpl()));
		time.setText(temp.getTime());
		TableNo.setText(Integer.toString(temp.getTableNo()));
		Seats.setText(Integer.toString(temp.getSeats()));
		Discription.setText(temp.getDiscription());
	}

	//==============================Make Reservation=============================//
	public void CustomerDataMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("CustomerData.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void MakeReservationMain(ActionEvent event) throws IOException
	{
		String name = CustomerName.getText();
		String contact = CustomerContact.getText();
		
		Singelton.restaurant.Customer_Data(name, contact);
		
		root = FXMLLoader.load(getClass().getResource("MakeReservation.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void ReservationCreated(ActionEvent event) throws IOException,ExceptionHandler
	{
		String date = Date.getText();
		int ppl = Integer.parseInt(TotalMembers.getText());
		if(ppl <= 0 ) {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Total members cannot be negative!!!\n");
		}
		else if(ppl > 10 ) {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Total members cannot be negative!!!\n");
		} 
		String time = null;
		if(Lunch.isSelected()) {
			time = "Lunch";
		}
		else if(Dinner.isSelected()) {
			time = "Dinner";
		}
		Singelton.restaurant.Reserve_Table_Data(time, date, ppl);
		
		root = FXMLLoader.load(getClass().getResource("ReservationCreated.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//==============================Update Reservation=============================//
	public void CustomerInformation(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("CustomerInformation.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void UpdateReservationMain(ActionEvent event) throws IOException,ExceptionHandler
	{
		if(update_count !=3) {
			String name = CustomerName.getText();
			String contact = CustomerContact.getText();
			
			temp_index = Singelton.restaurant.check_Customer(name, contact);
			Singelton.restaurant.Verify_setIndex(temp_index);
			if (temp_index==51) {
				cusomer_check.setText("Incorrect Data");
				update_count++;
			}
			else if (temp_index >=0) {
				root = FXMLLoader.load(getClass().getResource("UpdateReservation.fxml"));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		else {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Too many wrong Details.System Terminating!!!\n");
		}
	}
	public void ReservationUpdated(ActionEvent event) throws IOException,ExceptionHandler {
		
		String date = Date.getText();
		int ppl = Integer.parseInt(TotalMembers.getText());
		if(ppl <= 0 ) {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Total members cannot be negative!!!\n");
		}
		else if(ppl > 10 ) {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Total members cannot be negative!!!\n");
		}
		String time = null;
		if(Lunch.isSelected()) {
			time = "Lunch";
		}
		else if(Dinner.isSelected()) {
			time = "Dinner";
		}

		temp_index = Singelton.restaurant.Verify_getIndex();
		Singelton.restaurant.Restaurant_update_Reservation(time, date, ppl, temp_index);
		
		root = FXMLLoader.load(getClass().getResource("ReservationUpdated.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//==============================Cancel Reservation=============================//
	public void CancelReservationMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CancelReservation.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void ReservationCanceled(ActionEvent event) throws IOException , ExceptionHandler {
		if(cancel_count != 3) {
			String name = CustomerName.getText();
			String contact = CustomerContact.getText();
			
			temp_index = Singelton.restaurant.check_Customer(name, contact);
			if (temp_index==51) {
				cusomer_check.setText("Incorrect Data");
				cancel_count++;
			}
			else if (temp_index >=0) {
				
				Singelton.restaurant.Restaurant_Cancel_reservation(name, contact);
				
				root = FXMLLoader.load(getClass().getResource("ReservationCanceled.fxml"));
				stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
		}
		else {
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Too many wrong Details.System Terminating!!!\n");
		}
	}
}
