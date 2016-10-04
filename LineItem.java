
public class LineItem {
	
	// Line Item knows about Product, and retrieves product name from a Product method.
	
	Product myProduct;
	int quantity;
	double pricePerItem;
	
	public LineItem( Product aProduct, int number){
		
		myProduct = aProduct;
		quantity = number;
		pricePerItem = aProduct.getPrice();
	}
	
	public String getProductName(){
		
		return myProduct.getName();
		
	}
	
	

}
