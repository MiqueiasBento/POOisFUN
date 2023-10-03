package JunkFood;

public class Slot {
	private String name;
	private float price;
	private int quant;
	
	public Slot(String name, int quant, float price) {
		super();
		this.name = name;
		this.price = price;
		this.quant = quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	@Override
	public String toString() {
		return " " + getName() + " : " + getQuant() + " U : " + String.format("%.2f", getPrice()) + " RS";
	}
}