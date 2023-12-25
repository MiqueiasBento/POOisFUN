package Produto;

public class Product implements IProduct{
	private String name;
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}

	public String getLabel() {
		return this.name;
	}
	
	@ Override
	public String toString() {
		// bermuda:30.00
		return this.name + ":" + String.format("%.2f", this.price);
	}
}