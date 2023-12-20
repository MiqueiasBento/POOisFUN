package tarifas;

import java.util.ArrayList;
import java.util.List;

public class BalanceManager {
	private int balance;
	private List<Operation> extract;
	private int nextId;
	
	public BalanceManager() {
		balance = 0;
		nextId = 0;
		extract = new ArrayList<>();
	}
	
	// adiciona value ao balance
	// crie operação e adicione ao vetor de operações
	// incrementa o nextId
	public void addOperation(Label label, int value) {
		setBalance(getBalance() + value);
		extract.add(new Operation(nextId++, label, value, this.balance));
	}
	
	// retorna uma operação com label ERROR caso contrário
	// retorna a operação caso o índice seja válido
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int value) {
		this.balance = value;
	}
	
	// se qtdOp for 0, retorne todas as operações
	// se qtdOp for positivo, retorne as últimas qtdOp operações
	public List<Operation> getExtract(int qtdOp) {
		List<Operation> result = new ArrayList<>();
			
		for(Operation op : extract) {
			result.add(op);
		}
		
		if(qtdOp == 0) {
			return result;
		} else {
			result.subList(result.size() - qtdOp, result.size());
			return result;
		}
	}
}