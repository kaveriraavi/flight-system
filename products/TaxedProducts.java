package products;

public class TaxedProducts extends DiscountProduct {
    private double tax;
	public TaxedProducts(String pname, int quantity, int price, int discountRate,double tax) {
		super(pname, quantity, price, discountRate);
         this.tax=tax;
	}
	public double getTax() {
		return getPrice()*(this.tax/100);
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	
	@Override
	public double getNetPrice() {
		// TODO Auto-generated method stub
		return super.getNetPrice()+getTax();
	}
	public void print() {
		super.print();
		System.out.println("Tax :"+getTax());
	}   
	

}