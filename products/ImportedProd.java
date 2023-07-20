package products;

public class ImportedProd extends TaxedProducts{
	
	private double importTax;
	
	public ImportedProd(String pname, int quantity, int price, int discountRate, int tax, double importTax) {
		super(pname, quantity, price, discountRate, tax);
		this.importTax=importTax;
	}

	public double getImportTax() {
		return getPrice()*(this.importTax/100);
	}

	public void setImportTax(int importTax) {
		this.importTax = importTax;
	}
	
	
	@Override
	public double getNetPrice() {
		
		return super.getNetPrice()+getImportTax();
	}
	public void printProduct() {
		super.print();
		System.out.println("Imported Tax : "+getImportTax());
	}
}