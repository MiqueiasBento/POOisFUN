package Trem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Registro {
	private ArrayList<Passageiro> cadastro;
	private ArrayList<Movimento> movimentacao;
	
	public Registro() {
		cadastro = new ArrayList<>();
		movimentacao = new ArrayList<>();
	}
	
	public void cadastrar(Passageiro pass) {
		if(exist(pass.getId())){
		    return;
		}
		
		this.cadastro.add(pass);
	}
	
	public void addMov(Movimento mov) {
		this.movimentacao.add(mov);
	}
	
	public String getCadastro() {
		// Compara os valores do ArrayList e organiza a partir do getId
		Collections.sort(this.cadastro, Comparator.comparing(Passageiro :: getId));

		String out = "";

		for (Passageiro pass : cadastro) {
			out += pass.getId() + "\n";
		}

		return out.substring(0, out.length() - 1);
	}
	
	public String getMovimento() {
		String out = "";
		
		for(Movimento m : movimentacao) {
			out += m + "\n";
		}
		
		return out;
	}
	
	public boolean exist(String idPass){
	    for(Passageiro p : cadastro){
	        if(p.getId().equals(idPass)){
	            return true;
	        }
	    }
	    return false;
	}
	
	@ Override
	public String toString() {
		return "";
	}
	
}