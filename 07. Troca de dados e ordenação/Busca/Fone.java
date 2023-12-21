package Busca;

public class Fone {
	private String id;
	private String number;
	
	public Fone(String id, String number) {
		this.id = id;
		this.number = number;
	}
	
	public boolean isValid() {
		for(char c : this.number.toCharArray()){
			if(!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	
	public String getId() {
		return this.id;
	}
	public String getNumber() {
		return this.number;
	}
	
	@ Override
	public String toString() {
		return this.id + ":" + this.number;
	}
}