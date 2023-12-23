package Bilheteria_I;

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
	
	public List<Venda> getVendas() {
		return this.repVendas;
	}
	
	public List<Pessoa> getPessoas(){
		List<Pessoa> pessoas = new ArrayList<>();
		
		for(Pessoa p : this.repPessoas.values()) {
			pessoas.add(p);
		}
		
		return pessoas;
	}
	
	public List<Evento> getEventos(){
		List<Evento> eventos = new ArrayList<>();
		
		for(Evento e : this.repEventos.values()) {
			eventos.add(e);
		}
		
		return eventos;
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
	
	public void addEvento(String name, double valor) throws Exception{
		if(this.repEventos.containsKey(name)) {
			throw new Exception("fail: evento " + name + " ja existe");
		}
		
		this.repEventos.put(name, new Evento(name, valor));
	}
	
	public void vender(String name_pessoa, String name_evento) throws Exception{
		if(!this.repEventos.containsKey(name_evento)) {
			throw new Exception("fail: evento " + name_evento + " nao existe");
		}
		
		if(!this.repPessoas.containsKey(name_pessoa)) {
			throw new Exception("fail: pessoa " + name_pessoa + " nao existe");
		}
		
		this.repVendas.add(new Venda(this.repPessoas.get(name_pessoa), this.repEventos.get(name_evento)));
	}
	
	@ Override
	public String toString() {
		return " - " + this.getEventos();
	}
}