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

public class MaintenanceController {
	//========================================================Variable Declaration=============================================================//
	
		
		//Equipment
	@FXML
	public Button OrderEquip;
	@FXML
	public Button CheckEquip;

	@FXML
	public Button MenuBack;
	

		//order equipment
	@FXML
	public TextField Equipment_id;
	@FXML
	public TextField Quantity;
	@FXML
	public Label Incorrect_ID;
		
		//order equipment
	@FXML
	public Button ViewEquipment;
	@FXML
	public Button ViewNextEquipment;
	@FXML
	public Label Quant;
	
	
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

	//==========================================================Maintenance Menu==============================================================//


	//===========================Check Equipment Menu==================================//

	public void CheckEquipmentMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("CheckEquipment.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void ViewEquipment(ActionEvent event) throws IOException,ExceptionHandler {

		int Equip_id = Integer.parseInt(Equipment_id.getText());
		if(Equip_id < 0 ) {
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Equipment ID cannot be negative!!!\n");	
		}
		
		int check = Singelton.restaurant.CheckId(Equip_id);
		if (check==6) {
			Incorrect_ID.setText("Incorrect ID");
		}
		else {
			int quant = Singelton.restaurant.get_EQQuantity(check);
			
			Quant.setText(Integer.toString(quant));
		}
	}

	//===========================Order Equipment Menu==================================//
	public void OrderEquipmentMain(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("OrderEquipment.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void PlaceOrder(ActionEvent event) throws IOException,ExceptionHandler {

		int Equip_id = Integer.parseInt(Equipment_id.getText());
		if(Equip_id < 0 ) {
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Equipment ID cannot be negative!!!\n");	
		}
		
		int quant = Integer.parseInt(Quantity.getText());
		if(quant < 0 ) {
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Equipment quantity cannot be negative!!!\n");	
		}
		
		int check = Singelton.restaurant.CheckId(Equip_id);
		if (check==6) {
			Incorrect_ID.setText("Incorrect ID");
		}
		else {
			Singelton.restaurant.addQuantity(check, quant);
			
			root = FXMLLoader.load(getClass().getResource("EquipmentOrdered.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}

}
