package application;

public class Inventory {

	private int Equipment_ID;
	private int Quantity;
	
	public Inventory() {
		Equipment_ID=0;
		Quantity=0;
	}
	public Inventory(int id) {
		Equipment_ID=id;
		Quantity=0;
	}
	public int getEquipment_ID() {
		return Equipment_ID;
	}
	public void setEquipment_ID(int equipment_ID) {
		Equipment_ID = equipment_ID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
