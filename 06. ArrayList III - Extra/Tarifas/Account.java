package Tarifas;

import java.util.*;

public class Account {
	private BalanceManager balanceManager;
	private int id;
	
	public Account(int id) {
		this.id = id;
		this.balanceManager = new BalanceManager();
		this.balanceManager.addOperation(Label.OPENING, id);;
	}
	
	// adiciona valor à conta
	public void deposit(int value) throws Exception{
		if(value < 0) {
			throw new Exception("fail: invalid value");
		}
		this.balanceManager.addOperation(Label.DEPOSIT, value);
	}
	
	// retira o dinheiro, mesmo que o balance fique negativo
	public void fee(int value) {
		this.balanceManager.addOperation(Label.FEE, (-1 * value));
	}
	
	// se o índice for válido e representar uma operação de tarifa
	// adicione o mesmo valor tarifado, mas com label de reverse(extorno)
	public void reverse(int index) throws Exception{
		List<Operation> op = this.balanceManager.getExtract(index);
		
		if(index < 0 || index > op.size()) {
			throw new Exception("fail: index " + index + " invalid");
		}
		if(op.get(index).getLabel() != Label.FEE) {
			throw new Exception("fail: index " + index + " is not a fee");
		}
		
		this.balanceManager.addOperation(Label.REVERSE, (op.get(index).getValue() * -1));
	}
	
	// só realiza a operação se houver dinheiro suficiente na conta
	public void withdraw(int value) throws Exception{
		if(this.balanceManager.getBalance() - value < 0) {
			throw new Exception("fail: insufficient balance");
		}
		
		this.balanceManager.addOperation(Label.WITHDRAW, (-1 * value));
	}
	
	public BalanceManager getBalanceManager() {
		return balanceManager;
	}
	
	public String getExtract(int number) {
		List<Operation> extract = this.balanceManager.getExtract(number);
		String out = "";
		
		if(number == 0) {
			for(Operation op : extract) {
				out += op + "\n";
			}
		} else {
			for(int i = 0; i < extract.size(); i++) {
				if(i >= (extract.size() - number)) out += extract.get(i) + "\n";
				else continue;
			}
		}
		
		return out.substring(0, out.length() - 1);
	}
	
	@ Override
	public String toString() {
		return "account:" + this.id + " balance:" + this.balanceManager.getBalance();
	}
}