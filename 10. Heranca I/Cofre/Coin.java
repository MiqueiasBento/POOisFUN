package Cofre;

public enum Coin implements Valuable{
	C10(0.10, 1, "M10"),
	C25(0.25, 2, "M25"),
	C50(0.50, 3, "M50"),
	C100(1.00, 4, "M100");
	
    private String label;
	private double value;
	private int volume;
	
	private Coin(double value, int volume, String label) {
		this.value = value;
		this.volume = volume;
		this.label = label;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	@ Override
	public String toString() {
		// M10:0.10:1
		return getLabel() + ":" + String.format("%.2f", this.value) + ":" + this.volume;
	}
}

interface Valuable{
	public String getLabel();
	public double getValue();
	public int getVolume();
}