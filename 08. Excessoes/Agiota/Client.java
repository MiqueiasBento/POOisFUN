package Agiota;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	
	public List getOperations() {
		ArrayList<Operation> lista = new ArrayList<>();
		
		for(Operation operation : operations) {
			lista.add(operation);
		}
		
		return lista;
	}
	
	
}
