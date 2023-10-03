public class Account {
	private BalanceManager balanceManager;
	private int id;
	
	public Account(int id) {
		this.id = id;
	}
	
	public void deposit(int value) {
		balanceManager.setBalance(balanceManager.getBalance() + value);
	}
	
	public void fee(int value) {
		balanceManager.setBalance(balanceManager.getBalance() - value);
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
