package application;

public class Table {

	private int TableNo;
	private int Seats;
	private String Discription;
	private int status;//day(1),night(2),free(0)
	
	public Table() {
		TableNo = 0;
		Seats = 0;
		Discription = "";
		status = 0;
	}
	public int getTableNo() {
		return TableNo;
	}
	public void setTableNo(int tableNo) {
		TableNo = tableNo;
	}
	
	public int getSeats() {
		return Seats;
	}
	public void setSeats(int seats) {
		Seats = seats;
	}
	
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void display_Table() {
		System.out.println("Table No: ");
		System.out.println(TableNo);
		
		System.out.println("Seats: ");
		System.out.println(Seats);
		
		System.out.println("Table Discription: ");
		System.out.println(Discription);
		
		System.out.println("Table Status: ");
		if (status == 1) {
			System.out.println("Free");
		}
		else if (status == 0) {
			System.out.println("Booked");
		}
		
	}
}
