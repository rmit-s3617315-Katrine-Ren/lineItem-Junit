
public class Product {
	
	String productCode;
	String productName;
	double productCost;
	
	public Product(String aCode, String aName, double aCost){
		productCode = aCode;
		productName = aName;
		productCost = aCost;
	}

	public double getPrice() {
		// TODO Auto-generated method stub
		return productCost;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return productName;
	}

}
