package Topic;

import java.util.ArrayList;

public class Topic {
	private ArrayList<Pass> normalSeats;
	private ArrayList<Pass> prioritySeats;

	public Topic(int qtdPriority, int qtdNormal) {
		this.prioritySeats = new ArrayList<>(qtdPriority);
		for (int i = 0; i < qtdPriority; i++) {
			this.prioritySeats.add(null);
		}

		this.normalSeats = new ArrayList<>(qtdNormal);
		for (int i = 0; i < qtdNormal; i++) {
			this.normalSeats.add(null);
		}
	}

	private static int findFree(ArrayList<Pass> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				return i;
			}
		}
		return -1;
	}

	private static int findName(ArrayList<Pass> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null && list.get(i).getId().equals(name)) {
				return i;
			}
		}
		return -1; // Nao encontrou a pessoa
	}

	private static boolean insert(ArrayList<Pass> list, Pass pass) {
		if (findFree(list) != -1) {
			list.set(findFree(list), pass);
			return true;
		}
		return false;
	}

	private static boolean remove(ArrayList<Pass> list, String name) {
		if (findName(list, name) != -1) {
			list.set(findName(list, name), null);
			return true;
		} else {
			println("fail: " + name + " nao esta na topic");
		}
		return false;
	}

	public boolean insert(Pass pass) {
		if (findName(normalSeats, pass.getId()) != -1 || findName(prioritySeats, pass.getId()) != -1) { // User já na topic
			println("fail: " + pass.getId() + " ja esta na topic");
			return true;
		} else {
			if (pass.getAge() <= 64) { 				// Pessoa não idosa
				if (findFree(normalSeats) != -1) { 	// Se encontrar a posição null
					insert(this.normalSeats, pass); // Inserir novo passageiro
					return true;
				} else if (findFree(prioritySeats) != -1) {
					insert(this.prioritySeats, pass); // Inserir novo passageiro
					return true;
				} else {
					println("fail: topic lotada");
				}
			} else { // Pessoa idosa
				if (findFree(prioritySeats) != -1) { 	// Se encontrar a posição null
					insert(this.prioritySeats, pass); 	// Inserir novo passageiro
					return true; 
				} else if (findFree(normalSeats) != -1) {
					insert(this.normalSeats, pass); 	// Inserir novo passageiro
					return true;
				} else {
					println("fail: topic lotada");
				}
			}
		}
		return false;
	}

	public boolean remove(String name) {
		if (findName(normalSeats, name) != -1) {
			remove(normalSeats, name);
			return true;
		} else if (findName(prioritySeats, name) != -1) {
			remove(prioritySeats, name);
			return true;
		} else {
			println("fail: " + name + " nao esta na topic");
			return false;
		}
	}

	@Override
	public String toString() {
		String ss = "";

		if (normalSeats.isEmpty() && prioritySeats.isEmpty()) {
			ss += "[]";
		} else {
			ss += "[";
			for (Pass passageiro : prioritySeats) {
				if (passageiro == null) {
					ss += "@ ";
				} else {
					ss += "@" + passageiro + " ";
				}
			}

			for (Pass passageiro : normalSeats) {
				if (passageiro == null) {
					ss += "= ";
				} else {
					ss += "=" + passageiro + " ";
				}
			}
			ss = ss.substring(0, ss.length() - 1);
			ss += "]";
		}

		return ss;
	}

	public static void println(String str) {
		System.out.println(str);
	}
}