package Contato;

import java.util.LinkedList;

public class Contact {
	private boolean favorite;
	private LinkedList<Fone> fones;
	private String name;
	
	public Contact(String name) {
		this.name = name;
		this.fones = new LinkedList<>();
	}
	
	public void addFone(Fone fone) {
		if(fone.isValid()) {
			fones.add(fone);
		} else {
			println("fail: invalid number");
		}
	}
	
	public void removeFone(int index) {
		if(fones.size() >= index) {
			fones.remove(index);
		} else {
			println("fail: indice invalido");
		}
	}
	public boolean isFavorited() {
		if(favorite) {
			return true;
		} else {
			return false;
		}
	}
	
	public void toogleFavorited() {
		if(isFavorited()) {
			this.favorite = false;
		} else {
			this.favorite = true;
		}
	}
	
	public String getFones() {
		if(fones.isEmpty()) {
			return "[]";
		} else {
			String ss = "[";
			for(Fone fone : fones) {
				ss += fone + ", ";
			}
			ss = ss.substring(0, ss.length() - 2);
			ss += "]";
			
			return ss;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ Override
	public String toString() {
		String ss = "";
		
		if(isFavorited()) ss += "@ ";
		else ss += "- ";
		
		ss += getName() + " " + getFones();
		
		return ss;
	}
	
	public void println(String str) { System.out.println(str); }
}
