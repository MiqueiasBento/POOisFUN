package Bilheteria_II;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Evento {
	private String name;
	private TreeMap<String, Setor> setores;
	
	public Evento(String name) {
		this.name = name;
		this.setores = new TreeMap<>();
	}

	public String getName() {
		return this.name;
	}

	public Setor getSetor(String name) {
		return this.setores.get(name);
	}
	
	public List<Setor> getSetores(){
		List<Setor> setores = new ArrayList<>();
		
		for(Setor s : this.setores.values())
			setores.add(s);
		
		return setores;
	}
	
	public void addSetor(String name, double price) {
		this.setores.put(name, new Setor(this.name, name, price));
	}

	@Override
	public String toString() {
		// samba [pista:35.00, vip:70.00]
		return this.name + " " + getSetores();
	}
}