package tarifas;

import java.util.ArrayList;
import java.util.List;

public class BalanceManager {
	private int balance;
	private List<Operation> extract;
	private int nextId;
	
	public BalanceManager() {
	}
	
	public void addOperation(Label label, int value) {
		setBalance(getBalance() + value);
		extract.add(new Operation(nextId(), label, value, this.balance));
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int value) {
		this.balance = value;
	}
	
	public int nextId() {
		int value = nextId;
		nextId++;
		return value;
	}
	
	public List<Operation> getExtract(int qtdOp) {
		List<Operation> result = new ArrayList<>();
			
			for(Operation op : extract) {
				result.add(op);
			}
		if(qtdOp == 0) {
			return result;
		} else {
			result.subList(0, result.size() - qtdOp);
			return result;
		}
	}
	
	@ Override
	public String toString() {
		return "";
	}
}
