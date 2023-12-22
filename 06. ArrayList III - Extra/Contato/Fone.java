package Contato;

public class Fone {
	private String id;
	private String number;
	
	public Fone(String id, String number) {
		this.id = id;
		this.number = number;
	}
	
	public boolean isValid(){
		boolean isNumber = true;
		for(char character : number.toCharArray()) {
			if((Character.isDigit(character)) || (character == '(' || character == ')' || character == '.')) {
				isNumber = true;
			} else {
				isNumber = false;
				break;
			}
		}
		
		return isNumber;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String toString() {
		return getId() + ":" + getNumber();
	}
}
