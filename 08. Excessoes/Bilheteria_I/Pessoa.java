package Bilheteria_I;

public class Pessoa {
	private String name;
	private boolean meia;
	
	public Pessoa(String name, boolean meia) {
		this.name = name;
		this.meia = meia;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isMeia() {
		return this.meia;
	}
	
	@ Override
	public String toString() {
		// aline:inteira
		return this.name + ":" + ((meia) ? "meia" : "inteira");
	}
}