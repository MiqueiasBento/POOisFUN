package Trem;

public class Passageiro {
	public String id;
	
	public Passageiro(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	@ Override
	public String toString() {
		return id;
	}
}