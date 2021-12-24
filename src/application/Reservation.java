package application;

public class Reservation {

	private String time;
	private String date;
	private int NoOfPpl;
	
	public Reservation(){
		time="";
		date="";
		NoOfPpl=0;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getNoOfPpl() {
		return NoOfPpl;
	}
	public void setNoOfPpl(int NoOfPpl) {
		this.NoOfPpl = NoOfPpl;
	}
		
	public void BookTable(String t, String d, int p) {
		try {
				time = t;
				date = d;
				NoOfPpl = p;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateReservation(String t, String d, int p) {
		try {
				time = t;
				date = d;
				NoOfPpl = p;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void cancelReservation(String t, String d, int p) {
		try {
				time = "";
				date = "";
				NoOfPpl = 0;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
