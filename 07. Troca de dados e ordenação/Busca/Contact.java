package Busca;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	private boolean favorited;
	private ArrayList<Fone> fones;
	private String name;
	
	public Contact(String name) {
		this.name = name;
		this.fones = new ArrayList<>();
		this.favorited = false;
	}
	
	public void addFone(String id, String number) {
		fones.add(new Fone(id, number));
	}
	
	public void rmFone(int index) {
		fones.remove(index);
	}
	
	public void toogleFavorited() {
		this.favorited = !this.favorited;
	}
	
	public List<Fone> getFones(){
		return this.fones;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isFavorit() {
		return (favorited) ? true : false;
	}
	
	@ Override
	public String toString() {
		return this.name + " " + this.getFones();
	}
}