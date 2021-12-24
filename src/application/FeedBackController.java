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
import javafx.stage.Stage;

public class FeedBackController {
	//========================================================Variable Declaration=============================================================//

	@FXML
	public Button MenuBack;
	@FXML
	public CheckBox QualitySat;
	@FXML
	public CheckBox QualityDis;
	@FXML
	public CheckBox EnvironmentSat;
	@FXML
	public CheckBox EnvironmentDis;
	@FXML
	public CheckBox ServiceSat;
	@FXML
	public CheckBox ServiceDis;

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//=======================================================Main Menu===============================================================//
	public void MenuBackMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	//====================================================FeedBack Menu==============================================================//
	public void FeedBackSubmittedMain(ActionEvent event) throws IOException
	{
		String FoodQuality = "Dissatisfied";
		String Environment = "Dissatisfied";
		String Service = "Dissatisfied";
		
		if (QualitySat.isSelected()) {
			FoodQuality = "Satisfied";
		}
		else if (QualityDis.isSelected()) {
			FoodQuality = "Dissatisfied";
		}
		
		if (EnvironmentSat.isSelected()) {
			Environment = "Satisfied";
		}
		else if (EnvironmentDis.isSelected()) {
			Environment = "Dissatisfied";
		}
		
		if (ServiceSat.isSelected()) {
			Service = "Satisfied";
		}
		else if (ServiceDis.isSelected()) {
			Service = "Dissatisfied";
		}
		
		String Feedbk = "";
		Feedbk += FoodQuality;
		Feedbk += ",";
		Feedbk += Environment;
		Feedbk += ",";
		Feedbk += Service;
		
		Singelton.restaurant.StoreFeedback(Feedbk);
		
		root = FXMLLoader.load(getClass().getResource("FeedbackSubmitted.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
