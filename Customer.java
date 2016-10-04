import java.util.*;

// Customer knows about Invoice, not really about Line Item

public class Customer {
	private String myGivenName;
	private String myFamilyName;
	private String myID;
	
	private Invoice[] myInvoice = new Invoice[10];
	
	public Customer( String aGivenName, String aFamilyName, String aID ){		
		this.myGivenName = aGivenName;
		this.myFamilyName = aFamilyName;
		setId(aID);		
	}
	public String getName() {
		return myGivenName + " " + myFamilyName;
	}
	public String getId() {
		return myID;
	}
	public void setId(String id) {
		this.myID = id;
	}
	public Invoice[] getMyInvoice() {
		return myInvoice;
	}
	public void setMyInvoice(Invoice[] myInvoice) {
		this.myInvoice = myInvoice;
	}
	
	public String[] getProductsBought(){
		
		List<String> ls = new ArrayList<String>();
		for( Invoice i : myInvoice){
			ls.addAll(i.getProductList()) ;		
		}		
		String[] prods = new String[ls.size()];
		prods = ls.toArray(prods);
		return prods;

	}
	
	public String[] getProductsBought(Date aDate){
		
		List<String> ls = new ArrayList<String>();
		for( Invoice i : myInvoice){
			if( i.getInvDate( ).equals (aDate)  )
				ls.addAll(i.getProductList()) ;		
		}		
		String[] prods = new String[ls.size()];
		prods = ls.toArray(prods);
		return prods;
	}
}
