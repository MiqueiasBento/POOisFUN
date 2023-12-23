package Bilheteria_II;

public class Setor {
	private String evento;
	private String name;
	private double price;
	
	public Setor(String evento, String name, double price) {
		this.evento = evento;
		this.name = name;
		this.price = price;
	}

	public String getEvento() {
		return evento;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@ Override
	public String toString() {
		// pista:35.00, vip:70.00
		return this.name + ":" + String.format("%.2f", this.price);
	}
}