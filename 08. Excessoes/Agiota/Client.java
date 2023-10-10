package Agiota;

import java.util.*;

public class Client {
	private String name;
	private int limite;
	private LinkedList<Operation> operations;
	
	public Client(String name, int limite) {
		this.name = name;
		this.limite = limite;
		
		this.operations = new LinkedList<>();
	}
	
	public int getLimite() {
		return limite;
	}
	
	public String getName() {
		return name;
	}
	
	public void addOp(Operation op) {
		operations.add(op);
	}
	
	public void getOperations() {
		for(Operation operation : operations) {
			System.out.println(operation);
		}
	}
	
	public int getBalance() {
		int out = 0;
		for(Operation op : operations) {
			if(op.getLabel() == Label.GIVE || op.getLabel() == Label.PLUS) {
				out += op.getValue();
			} else if(op.getLabel() == Label.TAKE) {
				out -= op.getValue();
			}
		}
		
		return out;
	}
	
	@ Override
	public String toString() {
		return getName() + " " + getBalance() + "/" + getLimite();
	}
}
