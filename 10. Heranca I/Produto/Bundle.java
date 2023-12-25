package Produto;

import java.util.List;

public class Bundle implements IProduct {
	private List<IProduct> products;

	public Bundle(List<IProduct> products) {
		this.products = products;
	}

	public void addProduct(IProduct product) {
		products.add(product);
	}

	public double getPrice() {
		double totPrice = 0;

		for (IProduct p : products) {
			totPrice += p.getPrice();
		}

		return totPrice;
	}

	public String getLabel() {
		String out = "[";

		for (IProduct p : products) {
			out += p.getLabel() + ", ";
		}

		out = out.substring(0, out.length() - 2) + "]";
		return out;
	}

	@Override
	public String toString() {
		// [camisa, bermuda, bone]:90.00
		return this.getLabel() + ":" + String.format("%.2f", this.getPrice());
	}
}