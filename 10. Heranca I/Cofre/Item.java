package Cofre;

public class Item implements Valuable{
	private String label;
	private double value;
	private int volume;
	
	public Item(String label, double value, int volume) {
		this.label = label;
		this.value = value;
		this.volume = volume;
	}
	
	public String getLabel() {
		return this.label;
	}

	public double getValue() {
		return this.value;
	}

	public int getVolume() {
		return this.volume;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	@ Override
	public String toString() {
		// ouro:50.00:3
		return this.getLabel() + ":" + String.format("%.2f", getValue()) + ":" + getVolume();
	}
}