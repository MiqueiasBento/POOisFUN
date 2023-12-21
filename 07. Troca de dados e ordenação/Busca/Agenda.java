package Busca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
	private ArrayList<Contact> contacts;
	
	public Agenda() {
		this.contacts = new ArrayList<>();
	}
	
	private int findPosByName(String name){
		int id = 0;
		for(Contact c : contacts) {
			if(c.getName().equals(name)) return id;
			id++;
		}
		
		return -1;
	}
	
	public void addContact(String name, List<Fone> fones) {
		if(findPosByName(name) != -1) {
			for(Fone f : fones)
				this.contacts.get(findPosByName(name)).addFone(f.getId(), f.getNumber());
			return;
		}
		
		this.contacts.add(new Contact(name));
		this.addContact(name, fones);
		this.ordenarAgenda();
	}
	
	// Retorna o contato
	public Contact getContact(String name) {
		return (contacts.get(findPosByName(name)) != null) ? contacts.get(findPosByName(name)) : null;
	}
	
	// Remover um contato
	public void rmContact(String name) {
		if(contacts.get(findPosByName(name)) == null)
			System.out.println("fail: contato não existe");
		
		contacts.remove(findPosByName(name));
	}
	
	// Remover fone de um contato
	public void rmFone(String name, int id) {
		// Contato existe?
		if(contacts.get(findPosByName(name)) == null) {
			System.out.println("fail: contato nao existe");
			return;
		}
		
		// Fone existe?
		if(contacts.get(findPosByName(name)).getFones().size() == 0 || contacts.get(findPosByName(name)).getFones().size() < id) {
			System.out.println("fail: fone não existe");
			return;
		}
		
		// Se existe tudo, então remove
		contacts.get(findPosByName(name)).rmFone(id);
	}
	
	// Procura contatos que possuem certos caracteres, tanto no nome do contato como no numero
	public String search(String key) {
		String out = "";
		
		for(Contact c : this.contacts) {
			if(c.getName().contains(key)) {
				out += "- " + c + "\n";
				continue;
			}
			
			for(Fone f : c.getFones()) {
				if(f.getNumber().contains(key)) {
					out += "- " + c + "\n";
					continue;
				}
			}
		}
		
		return (out.length() == 0) ? out : out.substring(0, out.length() - 1);
	}
	
	// Adiciona um contato aos favoritos
	public void addFav(String name) {
		if(this.contacts.get(this.findPosByName(name)) == null) {
			System.out.println("fail: contato nao existe");
			return;
		}
		
		this.contacts.get(this.findPosByName(name)).toogleFavorited();
	}
	
	
	// Retorna todos os contatos favoritados
	public String favoritos() {
		String out = "";
		
		for(Contact c : contacts) {
			if(c.isFavorit()) out += "@ " + c + "\n";
		}
		
		return (out.length() == 0) ? out : out.substring(0, out.length() - 1);
	}
	
	@ Override
	public String toString() {
		String out = "";
		
		for(Contact c : contacts) {
			out += (c.isFavorit()) ? "@ " : "- ";
			out += c.toString() + "\n";
		}
		
		return out.substring(0, out.length() - 1);
	}
	
	private void ordenarAgenda() {
		Collections.sort(this.contacts, Comparator.comparing(Contact :: getName));
	}
}