package Bilheteria_I;

public class Evento {
	private String name;
	private double price;
	
	public Evento(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		// forro:50.00, piano:15.00, samba:70.00
		return this.name + ":" + String.format("%.2f", this.price);
	}
}