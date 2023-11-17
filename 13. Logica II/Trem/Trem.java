package Trem;

import java.util.*;

public class Trem {
	public int maxVagoes;
	public ArrayList<Vagao> vagoes;

	public Trem(int maxVagoes) {
		this.maxVagoes = maxVagoes;
		this.vagoes = new ArrayList<Vagao>();
	}

	public boolean addVagao(int capacidade) throws Exception {
		if (vagoes.size() == maxVagoes) {
			throw new Exception("fail: limite de vagões atingido");
		}

		vagoes.add(new Vagao(capacidade));
		return true;
	}

	public void embarcar(Passageiro pass) throws Exception {
		// Verificar se está no trem
		if(seach(pass.getId())) {
			throw new Exception("fail: " + pass.getId() + " já está no trem");
		}
		
		Main.registros.cadastrar(pass);
		
		// Colocar no trem
		for(Vagao v : this.vagoes) {
			if(v.embarcar(pass)) {
				Main.registros.addMov(new Movimento(pass.getId(), Direction.IN));
				return;
			}
		}
		
		// Mandar a exceção de trem lotado
		throw new Exception("fail: trem lotado");
	}

	public boolean desembarcar(Passageiro pass) throws Exception {
		if (!seach(pass.getId())) {
			throw new Exception("fail: " + pass.getId() + " nao esta no trem");
		}

		for (Vagao v : vagoes) { // Cada vagao
			v.desembarcar(pass.getId());
		}
		return false;
	}

	public boolean seach(String idPass) {
		for (Vagao v : vagoes) {
			if(v.seach(idPass) != -1) {
				return true;
			}
		}
		
		// Não encontrou
		return false;
	}

	@Override
	public String toString() {
		String out = "Trem ";
		for (Vagao v : vagoes) {
			out += v;
		}

		return out;
	}
}