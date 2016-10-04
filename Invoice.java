import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Invoice  {
	
	private int invNumber;
	private LineItem[] invLineItem = new LineItem[10];
	private Date invDate;
	
	public Invoice( int anInvoiceNumber, LineItem[] aLineItem, String aDate){
		try {
			
		setInvoiceNumber(anInvoiceNumber);
		setLineItem(aLineItem);		
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

			setInvDate(ft.parse(aDate));
		} catch (ParseException e) {
 
			e.printStackTrace();
		}
	}

	public int getInvoiceNumber() {
		return invNumber;
	}

	public void setInvoiceNumber(int myInvoiceNumber) {
		this.invNumber = myInvoiceNumber;
	}

	public LineItem[] getLineItem() {
		return invLineItem;
	}

	public void setLineItem(LineItem[] myLineItem) {
		this.invLineItem = myLineItem;
	}
	
	public List<String> getProductList(){
		/* this way of looping using java generics eg. <String> */
		List <String> al = new ArrayList<String>() ; 
			
		for( LineItem lix : invLineItem)
			al.add( lix.getProductName());
		return al; 
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}
	
	// New method in Invoice class
	public String getInvDateString() {		
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		return ft.format(invDate);
	}
}
