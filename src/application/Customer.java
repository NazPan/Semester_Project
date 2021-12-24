package application;

public class Customer {

	private String C_contact;
	private String C_name;
	
	private Reservation C_reserve;
	private Table C_table;
	
	public Customer() {
		C_contact = "";
		C_name = "";
		
		C_reserve = new Reservation();
		C_table = new Table();
	}

										//Code of Customer Class
	public String getC_contact() {
		return C_contact;
	}
	public void setC_contact(String c_contact) {
		C_contact = c_contact;
	}

	public String getC_name() {
		return C_name;
	}
	public void setC_name(String c_name) {
		C_name = c_name;
	}
	
	public void Add_Customer(String n, String c) {
		C_contact = c;
		C_name = n;
	}
	public void Delete_Customer() {
		C_contact = "";
		C_name = "";
	}
	public void Display_Customer(String n, String c) {
		System.out.print("Name: ");
		System.out.println(C_name);
		
		System.out.print("Contact: ");
		System.out.println(C_contact);
	}


										//Code of Table Class

	public Table getC_table() {
		return C_table;
	}
	public void setC_table(Table c_table) {
		C_table = c_table;
	}
	
	public int getTableNo() {
		return C_table.getTableNo();
	}
	public void setTableNo(int tableNo) {
		C_table.setTableNo(tableNo);
	}
	
	public int getSeats() {
		return C_table.getSeats();
	}
	public void setSeats(int seats) {
		C_table.setSeats(seats);
	}
	
	public String getDiscription() {
		return C_table.getDiscription();
	}
	public void setDiscription(String discription) {
		C_table.setDiscription(discription);
	}
	public int getStatus() {
		return C_table.getStatus();
	}
	public void setStatus(int status) {
		C_table.setStatus(status);
	}
	
	public void clear_Table() {
		C_table=null;
	}
	
	public void display_Table() {
		C_table.display_Table();
	}
										//Code of Reservation Class
	public Reservation getReserve() {
		return C_reserve;
	}
	public void setReserve(Reservation reserve) {
		this.C_reserve = reserve;
	}
	
	public String getTime() {
		return C_reserve.getTime();
	}
	public void setTime(String time) {
		C_reserve.setTime(time);
	}
	
	public String getDate() {
		return C_reserve.getDate();
	}
	public void setDate(String date) {
		C_reserve.setDate(date);
	}
	
	public int getNoOfPpl() {
		return C_reserve.getNoOfPpl();
	}
	public void setNoOfPpl(int NoOfPpl) {
		C_reserve.setNoOfPpl(NoOfPpl);
	}
		
	public void BookTable(String t, String d, int p) {
		C_reserve.BookTable(t, d, p);
	}
	
	public void updateReservation(String t, String d, int p) {
		C_reserve.updateReservation(t, d, p);
	}
	
	public void cancelReservation() {
		C_reserve = null;
	}
										//Populating the Objects
	public void CustomerDetails(Customer cust_data) {

		C_contact=cust_data.C_contact;
		C_name=cust_data.C_name;
		
		C_reserve.setDate(cust_data.getDate());
		C_reserve.setTime(cust_data.getTime());
		C_reserve.setNoOfPpl(cust_data.getNoOfPpl());
		
		C_table.setDiscription(cust_data.getDiscription());
		C_table.setTableNo(cust_data.getTableNo());
		C_table.setSeats(cust_data.getSeats());
	}
	public void CustomerDisplay() {

		System.out.println(C_contact);
		System.out.println(C_name);
		
		System.out.println(C_reserve.getDate());
		System.out.println(C_reserve.getTime());
		System.out.println(C_reserve.getNoOfPpl());
		
		System.out.println(C_table.getDiscription());
		System.out.println(C_table.getTableNo());
		System.out.println(C_table.getSeats());
	}
}
