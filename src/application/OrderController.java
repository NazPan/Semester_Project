package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

public class OrderController {
	//========================================================Variable Declaration=============================================================//
	Thread_Handler th = new Thread_Handler();
	@FXML
	private Button FoodOrder;
	@FXML
	private Button makeBill;

	@FXML
	private Button MenuBack;
	
					//Take Order
	@FXML
	private Button Proceed;
	@FXML
	private TextField TableNo_Order;
	@FXML
	private Label Incorrect;
	
					//Food Order
	@FXML
	private Button CalculateBill;
	@FXML
	private TextField Quantity_Item1;
	@FXML
	private TextField Quantity_Item2;
	@FXML
	private TextField Quantity_Item3;
	@FXML
	private TextField Quantity_Item4;
	@FXML
	private TextField Quantity_Item5;
	@FXML
	private TextField Quantity_Item6;
	@FXML
	private TextField Quantity_Item7;
	@FXML
	private TextField Quantity_Item8;
	@FXML
	private Label Price_Item1;
	@FXML
	private Label Price_Item2;
	@FXML
	private Label Price_Item3;
	@FXML
	private Label Price_Item4;
	@FXML
	private Label Price_Item5;
	@FXML
	private Label Price_Item6;
	@FXML
	private Label Price_Item7;
	@FXML
	private Label Price_Item8;
	@FXML
	private Label Name_Item1;
	@FXML
	private Label Name_Item2;
	@FXML
	private Label Name_Item3;
	@FXML
	private Label Name_Item4;
	@FXML
	private Label Name_Item5;
	@FXML
	private Label Name_Item6;
	@FXML
	private Label Name_Item7;
	@FXML
	private Label Name_Item8;
	

						//Make Bill
	@FXML
	private Button GenerateBill;
	@FXML
	private Label TableNo_Bill;
	@FXML
	private Label TotalPrice;
	@FXML
	private Label CurrentTime;

	@FXML
	private Label Quantity_Item01;
	@FXML
	private Label Quantity_Item02;
	@FXML
	private Label Quantity_Item03;
	@FXML
	private Label Quantity_Item04;
	@FXML
	private Label Quantity_Item05;
	@FXML
	private Label Quantity_Item06;
	@FXML
	private Label Quantity_Item07;
	@FXML
	private Label Quantity_Item08;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public int Tableno_temp;
	

	//=======================================================Main Menu===============================================================//
	public void MenuBackMain(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	//==========================================================OrderFood Menu==============================================================//

	public void MakeBillMain(ActionEvent event) throws IOException,ExceptionHandler {
		
		Tableno_temp = Singelton.restaurant.Verify_getTableno();
		
		int[] Quantity = new int[8];
		Quantity[0] = Integer.parseInt(Quantity_Item1.getText());
		Quantity[1] = Integer.parseInt(Quantity_Item2.getText());
		Quantity[2] = Integer.parseInt(Quantity_Item3.getText());
		Quantity[3] = Integer.parseInt(Quantity_Item4.getText());
		Quantity[4] = Integer.parseInt(Quantity_Item5.getText());
		Quantity[5] = Integer.parseInt(Quantity_Item6.getText());
		Quantity[6] = Integer.parseInt(Quantity_Item7.getText());
		Quantity[7] = Integer.parseInt(Quantity_Item8.getText());
		
		for (int i=0;i<8;i++) {
			if(Quantity[i] < 0 ) {
				th.run();
				javafx.application.Platform.exit();
				throw new ExceptionHandler ("Quantity of food cannot be negative!!!\n");	
			}
		}
		
		Singelton.restaurant.setQuantity(Quantity, Tableno_temp);
		
		Food[] food = new Food[8];
		for (int i=0;i<8;i++) {
			food[i]=new Food();
		}
		
		food[0].setFoodName(Name_Item1.getText());
		food[0].setPrice(Integer.parseInt(Price_Item1.getText()));
		
		food[1].setFoodName(Name_Item2.getText());
		food[1].setPrice(Integer.parseInt(Price_Item2.getText()));
		
		food[2].setFoodName(Name_Item3.getText());
		food[2].setPrice(Integer.parseInt(Price_Item3.getText()));
		
		food[3].setFoodName(Name_Item4.getText());
		food[3].setPrice(Integer.parseInt(Price_Item4.getText()));
		
		food[4].setFoodName(Name_Item5.getText());
		food[4].setPrice(Integer.parseInt(Price_Item5.getText()));
		
		food[5].setFoodName(Name_Item6.getText());
		food[5].setPrice(Integer.parseInt(Price_Item6.getText()));
		
		food[6].setFoodName(Name_Item7.getText());
		food[6].setPrice(Integer.parseInt(Price_Item7.getText()));
		
		food[7].setFoodName(Name_Item8.getText());
		food[7].setPrice(Integer.parseInt(Price_Item8.getText()));
		
		Singelton.restaurant.SetMenuFood(food, Tableno_temp);
		
		root = FXMLLoader.load(getClass().getResource("MakeBill.fxml"));
		stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void GenerateBill(ActionEvent event) throws IOException {
		Tableno_temp = Singelton.restaurant.Verify_getTableno();
		int price = Singelton.restaurant.CalculateTotalPrice(Tableno_temp);

		TableNo_Bill.setText(Integer.toString(Tableno_temp));
		TotalPrice.setText(Integer.toString(price));
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
		   
		   CurrentTime.setText(timeStamp);
		   
		int[] Quantity = Singelton.restaurant.getQuantity(Tableno_temp);
		
		Quantity_Item01.setText(Integer.toString(Quantity[0]));
		Quantity_Item02.setText(Integer.toString(Quantity[1]));
		Quantity_Item03.setText(Integer.toString(Quantity[2]));
		Quantity_Item04.setText(Integer.toString(Quantity[3]));
		Quantity_Item05.setText(Integer.toString(Quantity[4]));
		Quantity_Item06.setText(Integer.toString(Quantity[5]));
		Quantity_Item07.setText(Integer.toString(Quantity[6]));
		Quantity_Item08.setText(Integer.toString(Quantity[7]));
	}
	public void FoodOrderMain(ActionEvent event) throws IOException,ExceptionHandler {
		Tableno_temp =  Integer.parseInt(TableNo_Order.getText());
		if(Tableno_temp < 0 ) {
			th.run();
			javafx.application.Platform.exit();
			throw new ExceptionHandler ("Table Number cannot be negative!!!\n");	
		}
		Singelton.restaurant.Verify_setTableno(Tableno_temp);
		int status = Singelton.restaurant.CheckTableStatus(Tableno_temp);
		
		//if (status == 1 || status == 2) {
			root = FXMLLoader.load(getClass().getResource("FoodOrder.fxml"));
			stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		//}
//		else {
//			Incorrect.setText("Incorrect Table Number");
//		}
	}
}
