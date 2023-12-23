package Agiota;

import java.util.*;

public class LoanShark {
	private LinkedList<Client> aliveList;
	private LinkedList<Client> deathList;
	private LinkedList<Operation> aliveOper;
	private LinkedList<Operation> deathOper;
	private int id;

	private int seachClient(String name) {
		if (!aliveList.isEmpty()) {
			for (int i = 0; i < aliveList.size(); i++) {
				if (aliveList.get(i).getName().equals(name)) {
					return i;
				}
			}
		} else if (!deathList.isEmpty()) {
			for (int i = 0; i < deathList.size(); i++) {
				if (deathList.get(i).getName().equals(name)) {
					return i;
				}
			}
		}

		return -1;
	}

	private void pushOperation(Client client, String name, Label label, int value) {
		Operation op = new Operation(nextId(), name, label, value);
		aliveOper.add(op);
		aliveList.get(seachClient(name)).addOp(op);
	}

	private int nextId() {
		this.id++;
		return (id - 1);
	}

	public LoanShark() {
		this.aliveList = new LinkedList<>();
		this.deathList = new LinkedList<>();
		this.aliveOper = new LinkedList<>();
		this.deathOper = new LinkedList<>();
	}

	public Client getClient(String name) throws Exception {
		if (seachClient(name) == -1)
	    	throw new Exception("fail: cliente nao existe");
		
		return aliveList.get(seachClient(name));
	}

	public void addClient(String name, int limite) {
		if (seachClient(name) == -1) {
			aliveList.add(new Client(name, limite));
		} else {
			System.out.println("fail: cliente ja existe");
//			throw new Exception(){
//				
//			}
		}
	}

	public void give(String name, int value) {
		if (seachClient(name) != -1) {
			var index = aliveList.get(seachClient(name));
			
			if ((index.getBalance() + value) <= index.getLimite()) {
				pushOperation(aliveList.get(seachClient(name)), name, Label.GIVE, value);
			} else {
				System.out.println("fail: limite excedido");
			}
		} else {
			System.out.println("fail: cliente nao existe");
		}
	}

	public void take(String name, int value) {
		if (seachClient(name) != -1) {
			pushOperation(aliveList.get(seachClient(name)), name, Label.TAKE, value);
		} else {
			System.out.println("fail: cliente nao existe");
		}
	}

	public void kill(String name) {
		if (seachClient(name) != -1) {
			int id = seachClient(name);
			if(id == -1) return;
			deathList.add(aliveList.remove(id));
			
			for(int i = 0; i < aliveOper.size(); i++) {
				if(aliveOper.get(i).getName().equals(name)) {
					deathOper.add(aliveOper.remove(i));
					i--;
				}
			}
		} else {
			System.out.println("fail: cliente nao existe");
		}
	}

	public void plus() {
		for(Client client : aliveList) {
			pushOperation(aliveList.get(seachClient(client.getName())), client.getName(), Label.PLUS, ((int)  Math.ceil(client.getBalance() * 0.1)));
		}
		
		for(int i = 0; i < aliveList.size(); i++) {
			if(aliveList.get(i).getBalance() > aliveList.get(i).getLimite()) {
				kill(aliveList.get(i).getName());
				i--;
			}
		}
	}

	@Override
	public String toString() {
		String out = "";

		if (!aliveList.isEmpty() || !deathList.isEmpty()) {
			// Para ordenar a lista
			Comparator<Client> comp = new Comparator<Client>() {
				@Override
				public int compare(Client c1, Client c2) {
					return c1.getName().compareTo(c2.getName());
				}
			};
			
			// Lista de vivos
			aliveList.sort(comp);
			for (Client client : aliveList) {
				out += ":) " + client + "\n";
			}
			for (Operation op : aliveOper) {
				out += "+ " + op + "\n";
			}
			
			// Lista de mortos
			deathList.sort(comp);
			for (Client client : deathList) {
				out += ":( " + client + "\n";
			}
			for (Operation op : deathOper) {
				out += "- " + op + "\n";
			}
		}

		return out;
	}
}