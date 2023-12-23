package Bilheteria_II;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Bilheteria {
	private ArrayList<Venda> repVendas;
	private TreeMap<String, Pessoa> repPessoas;
	private TreeMap<String, Evento> repEventos;
	
	public Bilheteria() {
		this.repVendas = new ArrayList<>();
		this.repPessoas = new TreeMap<>();
		this.repEventos = new TreeMap<>();
	}
	
	public String getVendas() {
		String out = "";
		
		for(Venda v : this.repVendas)
			out += v + "\n";
		
		return (!out.isEmpty()) ? out.substring(0, out.length() - 1) : out;
	}
	
	public List<Pessoa> getPessoas(){
		List<Pessoa> pessoas = new ArrayList<>();
		
		for(Pessoa p : this.repPessoas.values()) {
			pessoas.add(p);
		}
		
		return pessoas;
	}
	
	public String getEventos(){
		String out = "";
		
		for(Evento e : this.repEventos.values()) {
			out += e + "\n";
		}
		
		return (!out.isEmpty()) ? out.substring(0, out.length() - 1) : out;
	}
	
	public double getCaixa() {
		return 0f;
	}
	
	public Pessoa getPessoa(String name) throws Exception{
		if(!this.repPessoas.containsKey(name)) {
			throw new Exception("fail: pessoa nao existe");
		}
		
		return this.repPessoas.get(name);
	}
	
	public Evento getEvento(String name) throws Exception{
		if(!this.repEventos.containsKey(name)) {
			throw new Exception("fail: evento nao existe");
		}
		
		return this.repEventos.get(name);
	}
	
	public void addPessoa(String name, boolean meia) throws Exception{
		if(this.repPessoas.containsKey(name)) {
			throw new Exception("fail: pessoa " + name + " ja existe");
		}
		
		this.repPessoas.put(name, new Pessoa(name, meia));
	}
	
	public void addEvento(String name) throws Exception{
		if(this.repEventos.containsKey(name)) {
			throw new Exception("fail: evento " + name + " ja existe");
		}
		
		this.repEventos.put(name, new Evento(name));
	}
	
	public void addSetor(String nome_evento, String nome_setor, double price) throws Exception{
		if(this.repEventos.get(nome_evento).getSetor(nome_setor) != null) {
			throw new Exception("fail: setor " + nome_setor + " ja existe");
		}
		
		this.repEventos.get(nome_evento).addSetor(nome_setor, price);
	}
	
	public void vender(String name_pessoa, String name_evento, String name_setor) throws Exception{
		if(!this.repEventos.containsKey(name_evento)) {
			throw new Exception("fail: evento " + name_evento + " nao existe");
		}
		
		if(this.repEventos.get(name_evento).getSetor(name_setor) == null) {
			throw new Exception("fail: setor " + name_setor + " nao existe");
		}
		
		if(!this.repPessoas.containsKey(name_pessoa)) {
			throw new Exception("fail: pessoa " + name_pessoa + " nao existe");
		}
		
		this.repVendas.add(new Venda(this.repPessoas.get(name_pessoa), this.repEventos.get(name_evento).getSetor(name_setor)));
	}
}