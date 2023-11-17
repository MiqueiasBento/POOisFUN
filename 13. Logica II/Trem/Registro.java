package Trem;

import java.util.ArrayList;
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
		cadastro.sort(new Comparator<Passageiro>() {
			@Override
			public int compare(Passageiro pass1, Passageiro pass2) {
				return pass1.getId().compareTo(pass2.getId());
			}
		});

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