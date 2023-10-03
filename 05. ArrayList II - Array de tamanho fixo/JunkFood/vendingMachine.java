package JunkFood;

import java.util.ArrayList;

public class vendingMachine {
	private ArrayList<Slot> slots;
	private float profit;
	private float cash;
	private int capacity;

	public vendingMachine(int capacity) {
		this.profit = 0f;
		this.cash = 0f;
		this.capacity = capacity;
		this.slots = new ArrayList<>(capacity);
		for(int i = 0; i < capacity; i++) {
			this.slots.add(new Slot("  empty", 0, 0f));	// Slots vazios
		}
	}
	
	public Slot getSlot(int index) {
		return slots.get(index);
	}
	
	public void setSlot(int index, Slot slot) {
		if(index >= 0 && index < slots.size()) {
			slots.set(index, slot);
		} else {
			println("fail: indice nao existe");
		}
	}
	
	public void clearSlot(int index) {
		if(!slots.get(index).getName().equals("empty")) {
			slots.set(index, new Slot("  empty", 0, 0f));
		} else {
			println("fail: sem dados no local");
		}
	}
	
	public float getCash() {
		return cash;
	}
	
	public void setCash(float value){
	    this.cash = value;
	}
	
	public float getProfit() {
		// informe o valor apurado com todas as vendas
		return profit;
	}
	
	public void insertCash(float value) {
		this.cash += value;
	}
	
	public float withdrawCash() {
		float value = getCash();
		this.cash = 0f;
		
		return value;
	}
	
	public void buyItem(int index) {
		if(index >= 0 && index < slots.size()) {
			if(getCash() - slots.get(index).getPrice() >= 0) {		// Se tem saldo
				if(slots.get(index).getQuant() > 0 && !(slots.get(index).getName().equals("  empty"))) {	// Se há produtos
					slots.get(index).setQuant(slots.get(index).getQuant() - 1);
					setCash(getCash() - slots.get(index).getPrice());
					println("voce comprou um " + slots.get(index).getName());
				} else {
					println("fail: espiral sem produtos");
				}
			} else {
				println("fail: saldo insuficiente");
			}
		} else {
			println("fail: indice nao existe");
		}
	}
	
	public String toString() {
		String ss = "";
		
		ss += "saldo: " + String.format("%.2f", getCash()) + "\n";
		for(int i = 0; i < this.capacity; i++) {
			ss  += i + " [" + slots.get(i) + "]\n";
		}
		ss = ss.substring(0, ss.length() -1);
		return ss;
	}
	
	
	public static void println(String str) { System.out.println(str); }
}