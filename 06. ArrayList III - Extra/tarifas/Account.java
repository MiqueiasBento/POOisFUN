package tarifas;

import java.util.*;

public class Account {
	private BalanceManager balanceManager;
	private int id;
	
	public Account(int id) {
		this.id = id;
	}
	
	public Account() {
	}
	
	public void deposit(int value) {
		balanceManager.addOperation(Label.DEPOSIT, value);
	}
	
	public void fee(int value) {
		balanceManager.addOperation(Label.FEE, (-1 * value));
	}
	
	public void reverse(int index) {
		
	}
	
	public void withdraw(int value) {
		
	}
	
	public BalanceManager getBalanceManager() {
		return balanceManager;
	}
	
	public String getExtract(int number) {
		List<Operation> extract = balanceManager.getExtract(number);
		String out = "";
		
		for(Operation op : extract) {
			out += op + "\n";
		}
		
		return out.substring(0, out.length() - 1);
	}
	
	@ Override
	public String toString() {
		return "account:" + this.id + " balance:" + balanceManager.getBalance();
	}
}