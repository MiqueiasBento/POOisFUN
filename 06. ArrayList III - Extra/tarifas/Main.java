package tarifas;

class Account {
	private BalanceManager balanceManager;
	private int id;
	
	public Account(int id) {
		this.id = id;
	}
	
	public void deposit(int value) {
		balanceManager.addOperation(null, value);
		
	}
	
	public void fee(int value) {
		balanceManager.addOperation(null, (-1 * value));
	}
	
	public void reverse(int index) {
		
	}
	
	public void withdraw(int value) {
		
	}
	
	public String toString() {
		return "";
	}
	
	public BalanceManager getBalanceManager() {
		return 
	}
	
}

public class Main {
	public static void main(String[] args) {
		
	}
}
