package testcases;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import application.Customer;
import application.Food;
import application.Retaurant;
import application.Table;

class JTesT_Case {


	@Test
	void test_1() {
	//	fail("Not yet implemented");
		Customer cust = new Customer();
		cust.Add_Customer("Haider", "123");
		cust.Display_Customer("Haider", "123");
		System.out.println(cust.getC_name());
		assertEquals(cust.getC_name(), "Haider");
	}
	
	@Test
	void test_2() {
		Customer cust = new Customer();
		Table temp_table = new Table();
		temp_table.setTableNo(2);
		temp_table.setSeats(4);
		temp_table.setDiscription("Disc");
		temp_table.setStatus(0);
		cust.setC_table(temp_table);
		assertEquals(cust.getSeats() , temp_table.getSeats() );
		assertSame(cust.getDiscription(),temp_table.getDiscription());
		assertNotEquals(cust.getC_table(),temp_table.getStatus());
	}
	
	@Test 
	void test_3() {
		Customer cust = new Customer();
		Table temp_table = new Table();
		temp_table.setTableNo(2);
		temp_table.setSeats(4);
		temp_table.setDiscription("Disc");
		temp_table.setStatus(0);
		Table temp_table_2 = new Table();
		temp_table_2.setTableNo(3);
		temp_table.setSeats(2);
		temp_table.setDiscription("Disc");
		temp_table.setStatus(0);
		cust.setC_table(temp_table);
		assertTrue(cust.getSeats() > temp_table_2.getSeats());
		assertFalse(cust.getTableNo() > temp_table_2.getTableNo());

	}
	
	@Test
	void test_4() {
		Table temp_table = new Table();
		temp_table.setTableNo(3);
		temp_table.setSeats(2);
		temp_table.setDiscription("Disc");
		temp_table.setStatus(0);
		Table temp_table_2 = new Table();
		temp_table_2.setTableNo(3);
		temp_table.setSeats(1);
		temp_table.setDiscription("Disc");
		temp_table.setStatus(0);
		assertNotEquals(temp_table , temp_table_2);
	}
	
	@Test
	void test_5() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		assertEquals("120",res.getC_contact(0));
	}
	
	@Test
	void test_6() {
		int max = 121;
		int from_class =0;
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);		
		res.Add_Customer("Hamza", "115", 5);	
		assertNotEquals("123",res.getC_contact(0));
		for(int i = 0 ; i<res.customer_count;i++) {
			from_class = Integer.parseInt(res.getC_contact(i)); 
			assertTrue(max > from_class);
		}
	}
	
	@Test
	void test_7() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);		
		Customer res2 = new Customer();
		res2 = res.Customer_Check(3);
		assertEquals(res2.getC_name() , res.getC_name(3));
	}
	
	@Test
	void test_8() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);		
		Customer res2 = new Customer();
		res2 = res.Customer_Check(3);
		assertNotEquals(res2.getC_name() , res.getC_name(2));
		res2 = res.Customer_Check(2);
		assertEquals(res2.getC_name() , res.getC_name(2));	
	}
	
	@Test
	void test_9() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);
		int bef_can = res.customer_count;
		res.Restaurant_Cancel_reservation("Ali" , "120");
		int aft_can = res.customer_count;
		assertNotEquals(bef_can, aft_can);
	}
	
	@Test
	void test_10() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);
		//System.out.println(res.customer_count);
		assertTrue(5 == res.customer_count);
		//int bef_can = res.customer_count;
		res.Restaurant_Cancel_reservation("Ali" , "120");
	//	System.out.println(res.customer_count);
		assertTrue(4 == res.customer_count);
	//	int aft_can = res.customer_count;		
	}
	
	@Test
	void test_11() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);
		int bef_can = res.customer_count;
		res.Restaurant_Cancel_reservation("Ali" , "120");
		int aft_can = res.customer_count;
		assertTrue(bef_can > aft_can);
	}
	
	@Test
	void test_12() {
		Food fd = new Food();
		fd.setFoodName("Biryani");
		assertEquals("Biryani" , fd.getFoodName());
		assertSame("Biryani" , fd.getFoodName());
	}
	
	@Test
	void test_13() {
		Food fd = new Food();
		fd.setPrice(250);
		assertTrue(250 == fd.getPrice());
		assertFalse(250 > fd.getPrice());
	}
	
	@Test
	void test_14() {
	//	fail("Not yet implemented");
		Customer cust = new Customer();
		cust.Add_Customer("Haider", "123");
		//cust.Display_Customer("Haider", "123");
	//	System.out.println(cust.getC_name());
		assertEquals(cust.getC_contact(), "123");
	}
	
	
	@Test
	void test_15() {
	//	fail("Not yet implemented");
		Customer cust = new Customer();
		cust.Add_Customer("Haider", "123");
		//cust.Display_Customer("Haider", "123");
	//	System.out.println(cust.getC_name());
		assertNotEquals(cust.getC_contact(), "121");
	}
	
	@Test
	void test_16() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
		res.Add_Customer("Aveen", "114", 4);		
		res.Add_Customer("Hamza", "115", 5);	
		String [] arr = {"Ali" , "Haider", "ahmad", "Maaz", "Aveen", "Hamza"};
		for(int i = 0 ; i<res.customer_count;i++) {
			assertEquals(arr[i] , res.getC_name(i));
		}
	}
	
	@Test
	void test_17() {
		Retaurant res = new Retaurant();
	//	System.out.println(res.customer_count);
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
	//	System.out.println(res.customer_count);
		res.Restaurant_Cancel_reservation("Ali" , "120");
		assertNotEquals(res.customer_count , res.Deleted_count);
	}
	
	@Test
	void test_18() {
		Retaurant res = new Retaurant();
	//	System.out.println(res.customer_count);
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Haider", "111", 1);		
		res.Add_Customer("ahmad", "112", 2);		
		res.Add_Customer("Maaz", "113", 3);		
	//	System.out.println(res.customer_count);
		res.Restaurant_Cancel_reservation("Ali" , "120");
		assertEquals(3,res.customer_count);
	}
	
	@Test
	void test_19() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer("Ali ", null, 1);
		try 
		{
			assertNull(res.getC_contact(1));
		}
		
		catch(Exception st)
		{
			System.out.println("Exception.");
		}
	}

	@Test
	void test_20() {
		Retaurant res = new Retaurant();
		res.Add_Customer("Ali", "120", 0);
		res.Add_Customer(null, null, 1);
		try 
		{
			assertNull(res.getC_name(1));
		}
		
		catch(Exception st)
		{
			System.out.println("Exception.");
		}
	}
	
}

