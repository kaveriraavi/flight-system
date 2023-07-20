package products;


public class Test{
public static void main(String[] args) {
	Product p= new DiscountProduct("Tv", 2, 25000, 10);
	p.print();
	System.out.println("========================================");
	p=new TaxedProducts("watch", 1, 50000, 15, 15);
	p.print();
	System.out.println("=========================================");
   p=new ImportedProd("Laptop", 2, 200000, 30,10,20);
   p.print();
}
}
