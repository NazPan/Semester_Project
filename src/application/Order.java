package application;

public class Order {

	private Food[] foodarr;
	private int[] quantity;
	private int totalPrice;
	
	private String ServingTime;
	private int TableNo;
	
	             
	Order(){
		TableNo=0;
		totalPrice=0;

		foodarr = new Food[8];
		for (int i=0;i<8;i++) {
			foodarr[i]=new Food();
		}
		
		quantity = new int[8];
		for (int i=0;i<8;i++) {
			quantity[i]=0;
		}
	}
	public String getServingTime() {
		return ServingTime;
	}
	public void setServingTime(String servingTime) {
		ServingTime = servingTime;
	}
	public int getTableNo() {
		return TableNo;
	}
	public void setTableNo(int tableNo) {
		TableNo = tableNo;
	}
	public Food[] getFoodarr() {
		return foodarr;
	}
	public void setFoodarr(Food[] foodarr) {
		this.foodarr = foodarr;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int CalculateTotalPrice() {
		for (int i=0;i<8;i++) {
			totalPrice += foodarr[i].getPrice()*quantity[i];
		}
		return totalPrice;
		
	}
}
