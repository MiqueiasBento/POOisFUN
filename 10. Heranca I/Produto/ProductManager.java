package Produto;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	private List<IProduct> products;
	
	public ProductManager() {
		this.products = new ArrayList<>();
	}
	
	public void addProduct(String label, double price) {
		products.add(new Product(label, price));
	}
	
	public void addPackage(List<Integer> indexes) throws Exception{
		List<IProduct> ps = new ArrayList<>();
		
		for(int i : indexes) {
			if(i < 0 || i > this.products.size())
				throw new Exception("fail: index de produto invalido");
			
			ps.add(this.products.get(i));
		}
		
		this.products.add(new Bundle(ps));
	}
	
	public void addDiscount(int index, double discount) throws Exception {
		if(index < 0 || index > this.products.size())
			throw new Exception("fail: index invalido");
		
		this.products.add(new DiscountedProduct(this.products.get(index), discount));
	}
	
	@ Override
	public String toString() {
		// 00:camisa:40.00
		String out = "";
		
		for(int i = 0; i < this.products.size(); i++)
			out += String.format("%02d", i) + ":" + this.products.get(i) + "\n";
		
		return out.substring(0, out.length() - 1);
	}
}