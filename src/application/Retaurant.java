package application;

public class Retaurant {

//========================================================Variable Declaration=============================================================//
	
	private String name;
	private String contact;
	private String address;
	
	private Feedback[] feedback;
	int feedback_count;
	
	private Customer[] cust;
	public int customer_count;

	private Customer[] Deleted;
	public int Deleted_count;
	
	private Reservation[] reserve;
	public int reservation_count;
	
	private Table[] table;

	private Food[] food;
	private Order[] order;
	
	private Inventory[] inventory;
	
	private Verification verify; 
	

	//======================================================Constructor Declaration=========================================================//
	public Retaurant() {

		Deleted = new Customer[50];
		for (int i=0;i<50;i++) {
			Deleted[i]=new Customer();
		}
		cust = new Customer[50];
		for (int i=0;i<50;i++) {
			cust[i]=new Customer();
		}
		
		reserve = new Reservation[50];
		for (int i=0;i<50;i++) {
			reserve[i]=new Reservation();
		}
		
		table = new Table[50];
		for (int i=0;i<50;i++) {
			table[i]=new Table();
		}
		
		food = new Food[8];
		for (int i=0;i<8;i++) {
			food[i]=new Food();
		}
		
		order = new Order[50];
		for (int i=0;i<50;i++) {
			order[i]=new Order();
		}
		
		inventory = new Inventory[5];
		for (int i=0;i<5;i++) {
			inventory[i]=new Inventory(i+1);
		}
		
		feedback = new Feedback[50];
		for (int i=0;i<50;i++) {
			feedback[i]=new Feedback();
		}
		
		verify = new Verification();
		
		customer_count=0;
		Deleted_count=0;
		reservation_count=0;
		feedback_count=0;
	}
	//====================================================Make Reservation==============================================================//
	public void Customer_Data(String nam, String cont) {
		Add_Customer(nam, cont, customer_count);
	}
	public void Add_Customer(String n, String c, int index) {
		cust[index].Add_Customer(n, c);
		customer_count+=1;
	}
	
	public void Reserve_Table_Data(String time, String date, int ppl) {
		int temp = customer_count;
		temp-=1;
		
		C_BookTable(time, date, ppl, temp);
		BookTable(time, date, ppl, reservation_count);
		
		int status = 0;
		if (time.equals("Lunch")) {
			status=1;
		}
		else if (time.equals("Dinner")) {
			status=2;
		}
		
		C_reserve_Table(ppl, status, temp);
		reservation_count+=1;
	}

	public void C_BookTable(String t, String d, int p, int index) {
		cust[index].BookTable(t, d, p);
	}

	public void BookTable(String t, String d, int p, int index) {
		reserve[index].BookTable(t, d, p);
	}
	public void C_reserve_Table(int ppl, int s, int index) {
		if(ppl%2!=0) {
			ppl+=1;
		}
		for(int i=0;i<table.length;i++) {
			if(ppl==table[i].getSeats()) {
				table[i].setStatus(s);
				cust[index].setC_table(table[i]);
				break;
			}
		}
	}

	//==========================================================Check In==============================================================//
	public Customer Customer_Check(int index) {
		if (index>=0 && index<=49) {
				return cust[index];
		}
		return null;
	}
	

	//==================================================Cancel Reservation==============================================================//
	public void Restaurant_Cancel_reservation(String nam, String cont) {
		for (int i=0;i<customer_count;i++) {
			if(cust[i].getC_name().equals(nam) && cust[i].getC_contact().equals(cont)) {
				C_cancelReservation(i);
				cancelReservation(i);
				
				setStatus(0, i);
			}
		}
	}

	public void C_cancelReservation(int i) {
		int temp1 = customer_count;
		temp1-=1;
		for (int j=i;j<temp1;j++) {
			Customer temp;
			temp=cust[j];
			cust[j]=cust[j+1];
			cust[j+1]=temp;
		}
		Deleted[Deleted_count] = cust[customer_count];
		customer_count-=1;
		Deleted_count+=1;
	}
	public void cancelReservation(int i) {
		int temp1 = reservation_count;
		temp1-=1;
		for (int j=i;j<temp1;j++) {
			Reservation temp;
			temp=reserve[j];
			reserve[j]=reserve[j+1];
			reserve[j+1]=temp;
		}
		reserve[reservation_count]=null;
		reservation_count-=1;
	}
	public void clear_Table(int index) {
		table[index].setStatus(0);
	}
	
	


	//================================================Update Reservation==============================================================//
	public int check_Customer(String nam, String cont) {
		for (int i=0;i<customer_count;i++) {
			if (cust[i].getC_name().equals(nam) && cust[i].getC_contact().equals(cont)) {
				return i;
			}
		}
		return 51;
	}
	public void Restaurant_update_Reservation(String time, String date, int ppl, int index) {
		
		cust[index].updateReservation(time, date, ppl);
		reserve[index].updateReservation(time, date, ppl);
		
		for (int j=0;j<table.length;j++) {
			if (table[j].getTableNo() == cust[index].getTableNo()) {
				table[j].setStatus(0);
				break;
			}
		}
		cust[index].clear_Table();
		C_reserve_Table(ppl, 0, index);
	}

	//========================================Getter Setter for  Restaurant============================================================//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//============================================Getter Setter for  CUSTOMER OBJ============================================================//
										//Getter Setter for  Customer Class
	public String getC_contact(int index) {
		return cust[index].getC_contact();
	}
	public void setC_contact(String c_contact,int index) {
		cust[index].setC_contact(c_contact);
	}
	public String getC_name(int index) {
		return cust[index].getC_name();
	}
	public void setC_name(String c_name,int index) {
		cust[index].setC_name(c_name);
	}
										//Getter Setter for  Table Class
	public Table getC_table(int index) {
		return cust[index].getC_table();
	}
	public void setC_table(Table c_table,int index) {
		cust[index].setC_table(c_table);
	}
	public int getC_TableNo(int index) {
		return cust[index].getTableNo();
	}
	public void setC_TableNo(int tableNo,int index) {
		cust[index].setTableNo(tableNo);
	}
	public int getC_Seats(int index) {
		return cust[index].getSeats();
	}
	public void setC_Seats(int seats,int index) {
		cust[index].setSeats(seats);
	}
	public String getC_Discription(int index) {
		return cust[index].getDiscription();
	}
	public void setC_Discription(String discription,int index) {
		cust[index].setDiscription(discription);
	}
	public int getC_Status(int index) {
		return cust[index].getStatus();
	}
	public void setC_Status(int status, int index) {
		cust[index].setStatus(status);
	}
										//Getter Setter for  Reservation Class
	public Reservation getC_Reserve(int index) {
		return cust[index].getReserve();
	}
	public void setC_Reserve(Reservation reserve, int index) {
		cust[index].setReserve(reserve);
	}
	public String getC_Time(int index) {
		return cust[index].getTime();
	}
	public void setCTime(String time, int index) {
		cust[index].setTime(time);
	}
	public String getC_Date(int index) {
		return cust[index].getDate();
	}
	public void setC_Date(String date, int index) {
		cust[index].setDate(date);
	}
	public int getC_NoOfPpl(int index) {
		return cust[index].getNoOfPpl();
	}
	public void setC_NoOfPpl(int NoOfPpl, int index) {
		cust[index].setNoOfPpl(NoOfPpl);
	}
	//==============================================Getter Setter for RESRVATION OBJ======================================================//
	public Reservation getReserve(int index) {
		return reserve[index];
	}
	public void setReserve(Reservation reserve, int index) {
		this.reserve[index] = reserve;
	}
	public String getTime(int index) {
		return reserve[index].getTime();
	}
	public void setTime(String time, int index) {
		reserve[index].setTime(time);
	}
	public String getDate(int index) {
		return reserve[index].getDate();
	}
	public void setDate(String date, int index) {
		reserve[index].setDate(date);
	}
	public int getNoOfPpl(int index) {
		return reserve[index].getNoOfPpl();
	}
	public void setNoOfPpl(int NoOfPpl, int index) {
		reserve[index].setNoOfPpl(NoOfPpl);
	}
	//===============================================Getter Setter for TABLE OBJ======================================================//
	public Table gettable(int index) {
		return table[index];
	}
	public void settable(Table t, int index) {
		table[index] = t;
	}
	public int getTableNo(int index) {
		return table[index].getTableNo();
	}
	public void setTableNo(int tableNo, int index) {
		table[index].setTableNo(tableNo);
	}
	public int getSeats(int index) {
		return table[index].getSeats();
	}
	public void setSeats(int seats, int index) {
		table[index].setSeats(seats);
	}
	public String getDiscription(int index) {
		return table[index].getDiscription();
	}
	public void setDiscription(String discription, int index) {
		table[index].setDiscription(discription);
	}
	public int getStatus(int index) {
		return table[index].getStatus();
	}
	public void setStatus(int status, int index) {
		table[index].setStatus(status);
	}
	//==============================================CODE FOR FeedBack OBJ=============================================================//
	public String getFeedback(int index) {
		return feedback[index].getFeedback();
	}
	public void setFeedback(String Feedback, int index) {
		feedback[index].setFeedback(Feedback);
	}
	public void StoreFeedback(String feedbk) {
		setFeedback(feedbk, feedback_count);
		feedback_count+=1;
	}
	//===================================================CODE FOR FOOD OBJ============================================================//
	public Food[] getFood() {
		return food;
	}
	public void setFood(Food[] food) {
		this.food = food;
	}
	public String getFoodName(int index) {
		return food[index].getFoodName();
	}
	public void setFoodName(String foodName, int index) {
		food[index].setFoodName(foodName);
	}
	public int getPrice(int index) {
		return food[index].getPrice();
	}
	public void setPrice(int price, int index) {
		food[index].setPrice(price);
	}
	
	
	
	public void FoodData(String name, int p, int index) {
		food[index].setFoodName(name);
		food[index].setPrice(p);
	}

	//===================================================CODE FOR Ordering============================================================//
	public int CheckTableStatus(int Tableno) {
		
		for (int i=0;i<50;i++) {
			if (table[i].getTableNo() == Tableno) {
				return table[i].getStatus();
			}
		}
		return 0;
	}
	public int CalculateTotalPrice(int index) {
		int totalPrice = order[index].CalculateTotalPrice();
		return totalPrice;
	}
	public void SetMenuFood(Food[] fd, int index) {
		setFood(fd);
		setFoodarr(fd, index);
	}
	//===================================================CODE FOR ORDER OBJ============================================================//
	public String getServingTime(int index) {
		return order[index].getServingTime();
	}
	public void setServingTime(String servingTime, int index) {
		order[index].setServingTime(servingTime);
	}
	public int getTableNo_Order(int index) {
		return order[index].getTableNo();
	}
	public void setTableNo_Order(int tableNo, int index) {
		order[index].setTableNo(tableNo);
	}
	public Food[] getFoodarr(int index) {
		return order[index].getFoodarr();
	}
	public void setFoodarr(Food[] foodarr, int index) {
		order[index].setFoodarr(foodarr);
	}
	public int[] getQuantity(int index) {
		return order[index].getQuantity();
	}
	public void setQuantity(int[] quantity, int index) {
		order[index].setQuantity(quantity);
	}
	public int getTotalPrice(int index) {
		return order[index].getTotalPrice();
	}
	public void setTotalPrice(int totalPrice, int index) {
		order[index].setTotalPrice(totalPrice);
	}
	//===================================================CODE FOR Inventory OBJ============================================================//

	public Inventory[] getInventory() {
		return inventory;
	}
	public void setInventory(Inventory[] inventory) {
		this.inventory = inventory;
	}

	public int getEquipment_ID(int index) {
		return inventory[index].getEquipment_ID();
	}
	public void setEquipment_ID(int equipment_ID, int index) {
		inventory[index].setEquipment_ID(equipment_ID);
	}
	public int get_EQQuantity(int index) {
		return inventory[index].getQuantity();
	}
	public void set_EQQuantity(int quantity, int index) {
		inventory[index].setQuantity(quantity);
	}
	public int CheckId(int id) {
		for (int i=0;i<5;i++) {
			if (inventory[i].getEquipment_ID() == id) {
				return i;
			}
		}
		return 6;
	}
	public void addQuantity(int check, int quant) {
		int temp = inventory[check].getQuantity();
		temp += quant;
		inventory[check].setQuantity(temp);
	}
	//===================================================CODE FOR Verify OBJ============================================================//
	public Verification getVerify() {
		return verify;
	}
	public void setVerify(Verification verify) {
		this.verify = verify;
	}
	public int Verify_getTableno() {
		return verify.getTableno();
	}
	public void Verify_setTableno(int tableno) {
		verify.setTableno(tableno);
	}
	public int Verify_getIndex() {
		return verify.getIndex();
	}
	public void Verify_setIndex(int index) {
		verify.setIndex(index);
	}
	
}
