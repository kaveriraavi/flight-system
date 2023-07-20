package products;

public class Interest {
private int amount;
private int rate;
public Interest(int amount, int rate) {
	this.amount = amount;
	this.rate = rate;
}
public Interest(int amount) {
	this.amount=amount;
	rate=10;
}
public int getRate() {
	return this.rate;
}
public void setRate() {
	this.rate=rate;
}
public int getAmount() {
	return this.amount;
}
public void setAmount(int amount) {
	this.amount=amount;
}
public int getInterest() {
	return amount*rate/100;
}


}
