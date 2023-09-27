package mod06_Tarifas;

import java.util.ArrayList;
import java.util.List;

public class BalanceManager {
	private int balance;
	private List<Operation> extract;
	private int nextId;
	
	public BalanceManager() {
	}
	
	public void addOperation(Label label, int value) {
		
	}
	
	@ Override
	public String toString() {
		return "";
	}
	
	public int getBalance() {
		return balance;
	}
	
	public List<Operation> getExtract(int qtdOp) {
		List<Operation> result = new ArrayList<>();
		
		for(int i = 0; i < qtdOp; i++) {
			result.add(extract.get(i));
		}
		
		return result;
	}
}
