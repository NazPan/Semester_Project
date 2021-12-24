package application;

public class Food {

	private String FoodName;
	private int Price;
	
	public Food() {
		FoodName = "";
		Price = 0;
	}
	public String getFoodName() {
		return FoodName;
	}
	public void setFoodName(String foodNam) {
		FoodName = foodNam;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int pric) {
		Price = pric;
	}
	public void FoodData(String name, int p) {
		FoodName = name;
		Price = p;
	}
}
