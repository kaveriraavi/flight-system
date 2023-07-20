package products;


public abstract class Product {
private String pname;
private int quantity;
private int price;
public Product(String pname, int quantity, int price) {
	super();
	this.pname = pname;
	this.quantity = quantity;
	this.price = price;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public void print() {
	System.out.println(this.pname);
	System.out.println(this.quantity);
	System.out.println(this.price);
}
abstract public double getNetPrice();

}
