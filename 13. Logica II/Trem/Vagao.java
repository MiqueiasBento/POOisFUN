package Trem;

import java.util.*;

public class Vagao {
	public ArrayList<Passageiro> cadeiras;
	public int capacidade;
	
	public Vagao(int capacidade) {
		this.capacidade = capacidade;
		this.cadeiras = new ArrayList<>(Collections.nCopies(capacidade, null));
	}
	
	public boolean embarcar(Passageiro pass) throws Exception{
		for(int i = 0; i < this.capacidade; i++) {
			if(cadeiras.get(i) == null) {
				cadeiras.set(i, pass);
				return true;
			}
		}
		return false;
	}
	
	public void desembarcar(String idPass) throws Exception{
		for(int i = 0; i < this.capacidade; i++) {
			if(cadeiras.get(i) == null) {
				continue;
			}
			if(cadeiras.get(i).getId().equals(idPass)) {
				Main.registros.addMov(new Movimento(cadeiras.get(i).getId(), Direction.OUT));
				cadeiras.set(i, null);
			}
		}
	}
	
	public int seach(String idPass) {
		for(int i = 0; i < this.capacidade; i++) {
			if(cadeiras.get(i) == null) {
				continue;
			}
			if(cadeiras.get(i).getId().equals(idPass)) {
				return i;
			}
		}
		
		return -1;
	}
	
	@ Override
	public String toString() {
	    String out = "[ ";

	    for(int i = 0; i < this.capacidade; i++) {
			if(cadeiras.get(i) != null)	out += cadeiras.get(i).getId() + " ";
			else			out += "- ";
		}
	    
	    return out.substring(0, out.length() -1) + " ]";
	}
	
	// Getters e Setters
	public int getCapacidade() {
		return this.capacidade;
	}
	
	public int ocupadas() {
		return cadeiras.size();
	}
}