package Cofrinho;

public class Item {
	private String label;
	private int volume;

	// Construtor
	public Item(String label, int volume) {
		this.label = label;
		this.volume = volume;
	}

	// Getters e Setters
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	// toString
	public String toString() {
		return label + ":" + volume;
	}
}