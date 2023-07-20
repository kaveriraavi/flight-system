package products;

public class DiscountProduct extends Product{

private int discountPer;

public DiscountProduct(String pname, int quantity, int price, int discountRate) {
	super(pname, quantity, price);
	this.discountPer = discountRate;
}

public double getDiscountRate() {
	return discountPer;
}

public void setDiscountRate(int discountRate) {
	this.discountPer = discountRate;
}

@Override
public double getNetPrice() {
	int amt=getPrice()*getQuantity();
	double discount=amt*(getDiscountRate()/100);
	return amt-discount;
}
public void print() {
	super.print();
	System.out.println("Discount "+getDiscountRate());
	System.out.println("Net Amt "+getNetPrice());
}

}
