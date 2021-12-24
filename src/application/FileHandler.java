package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHandler {

	public Customer[] Customer_Data()
    {
		Customer[] cust = new Customer[1000];
		try {
			
			int index=0;
			String[] word=new String[9];
			int count = 0;
			
			File obj = new File("customer.txt");
			Scanner scanfile = new Scanner(obj);
				
			while (scanfile.hasNextLine()) {
				String line = scanfile.nextLine();
				String[] tokens = line.split("\\,");
				
				count=0;
				for (String w : tokens) {
					  word[count]=w;
					  count++;
					}
				
				cust[index].setC_name(word[0]);
				cust[index].setC_contact(word[1]);
				cust[index].setTime(word[2]);
				cust[index].setDate(word[3]);
				cust[index].setNoOfPpl(Integer.parseInt(word[4]));
				cust[index].setTableNo(Integer.parseInt(word[5]));
				cust[index].setSeats(Integer.parseInt(word[6]));
				cust[index].setDiscription(word[7]);
				cust[index].setStatus(Integer.parseInt(word[8]));
				index++;
			}
			
			scanfile.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return cust;
    }
}