package Produto;

public class DiscountedProduct implements IProduct{
	private IProduct product;
	private double discount;
	
	public DiscountedProduct(IProduct product, double discount) {
		this.product = product;
		this.discount = discount;
	}

	public double getPrice() {
		return this.product.getPrice() - (this.product.getPrice() * this.discount / 100);
	}

	public String getLabel() {
		return this.product.getLabel() + "(" + String.format("%.0f", this.discount) + "% OFF)";
	}
	
	@ Override
	public String toString() {
		// camisa(10% OFF):36.00
		return this.getLabel() + ":" + String.format("%.2f", this.getPrice());
	}
}