import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author ivans
 * 
 * Example of using the Customer Class of the Line Item Case Study to illustrate Junit.
 *
 */
public class CustomerTest {

	private static Customer john;
	private static Customer jane;
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	
	// Annotating this public static void method will make it run once before
	// any of the test methods in the class.
	
	public static void setUpBeforeClass() throws Exception {

		Product mouse;
		Product keyboard;
		Product hardDrive;
		Product monitor;
		
		mouse = new Product( "A11", "Mouse", 3.50);
		keyboard = new Product( "A12", "Keyboard", 10.20);
		hardDrive = new Product( "A13", "Hard Drive", 99.0);
		monitor = new Product( "A14", "Monitor", 210.0);

		LineItem li1 = new LineItem( mouse, 1);
		LineItem li2 = new LineItem( keyboard, 2);
		LineItem li3 = new LineItem( hardDrive, 2);
		LineItem li4 = new LineItem( monitor, 3);
		
		LineItem[] lia1 = {li1, li2 };
		LineItem[] lia2 = {li2};
		LineItem[] lia3 = {li3, li4};
		LineItem[] lia4 = {li4};
		
		
		Invoice inv1 = new Invoice( 1001, lia1 , "2016-03-02" );
		@SuppressWarnings("unused")
		Invoice inv2 = new Invoice( 1002, lia2 , "2016-04-15" );
		Invoice inv3 = new Invoice( 1003, lia3 , "2016-05-12" );
		Invoice inv4 = new Invoice( 1004, lia4 , "2016-05-12" );	
		
		Invoice[] invoiceHistory1 = new Invoice[] {inv1, inv3}; // This will cover all 4 product types
		Invoice[] invoiceHistory2 = new Invoice[] {inv4}; // This is only the monitor bought.
		
		john = new Customer( "John", "Doe", "CUST001");
		john.setMyInvoice(invoiceHistory1);

		jane = new Customer( "Jane", "Doe", "CUST002");
		jane.setMyInvoice(invoiceHistory2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before 
	
	// Several tests need similar objects created before they can run.
	// @Before will run before each Test Method annotated @Test
	
	public void setUp() throws Exception {

	}

	@Test  
	
	// Test Customer.getProductsBought()
	// Check list of products purchased by John Doe
	public void testJohnDoe() {		
		String[] expected = { "Mouse", "Keyboard", "Hard Drive", "Monitor" };
		System.out.println(john.getProductsBought());
		assertArrayEquals( expected , john.getProductsBought());
		
	}
	
	@Test 
	
	// Test Customer.getProductsBought()
	// Check list of products purchased by Jane Doe
	
	public void testJaneDoe() {	
		String[] expected = { "Monitor" } ;
		assertArrayEquals(  expected , jane.getProductsBought());
	}
	
	@Test
	public void testTrueFalse() {

		assertTrue( john.getId().equals("CUST001"));
		assertFalse(jane.getId().equals(("CUST003")));		
		assertTrue("WARNING! This should be true", jane.getId().equals("CUST002"));
	}
	
	@Test
	// This checks if Customer.getTestClient method is returning a Customer object or not.
	
	public void testGetClient(){
		assertNotNull( new Customer("Xi",  "Cheng", "CUST003"));
	}

	
	@Test
	// This converts a String into a Date object.
	
	public void getProdbyDate() throws ParseException{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		Date bDate = null; 
		bDate = dateFormat.parse("2016-05-12");
		
		String[] expected = { "Monitor" };		
 		assertArrayEquals( expected , jane.getProductsBought(bDate)); 
	}	
	
	@Test
	// A typical example of Test Driven Development approach. I want to add a new Customer method to
	// return boolean (true or false) if the Customer has bought a product.
	// So I make it fail as I start planning this coding work.

		public void getProdByName(){
		
	
		fail("Not started coding yet");
	}
}
