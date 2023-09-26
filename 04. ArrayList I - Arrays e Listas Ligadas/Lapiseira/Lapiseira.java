package Lapiseira;

import java.util.LinkedList;

public class Lapiseira{
	private float calibre;
	private Lead tipo;
	private LinkedList<Lead> barrel;

	public Lapiseira(float calibre) {
		super();
		this.calibre = calibre;
		this.tipo = null;
		this.barrel = new LinkedList<>();
	}
	
	// Getters e Setters
	public float getCalibre() {
		return calibre;
	}

	public void setCalibre(float calibre) {
		this.calibre = calibre;
	}

	public Lead getTipo() {
		return tipo;
	}

	public void setTipo(Lead tipo) {
		this.tipo = tipo;
	}

	public boolean hasGrafite(){
		if(tipo != null) {
			return true;
		} else {
			return false;
		}
	}
	
	// Methods
	public void insert(Lead lead) {
		if(getCalibre() == lead.getCalibre()) {
			barrel.addLast(lead);
		} else {
			System.out.println("fail: calibre incompatível");
		}
	}
	
	public void pull() {
		if(!hasGrafite()) {
			if(!barrel.isEmpty()) {
				setTipo(barrel.getFirst());
				barrel.pop();
			} else {
				System.out.println("fail: sem grafites");
			}
		} else {
			System.out.println("fail: ja existe grafite no bico");
		}
	}
	
	public void remove() {
		if(hasGrafite()) {
			setTipo(null);
		}
	}
	
	public void writePage() {
		if(hasGrafite()) {
			if(tipo.getTamanho() > 10) {
				if((tipo.getTamanho() -  tipo.usagePerSheet()) >= 10) {
					tipo.setTamanho(tipo.getTamanho() - tipo.usagePerSheet());
				} else {
				    tipo.setTamanho(10);
					System.out.println("fail: folha incompleta");
				}
			} else {
				System.out.println("fail: tamanho insuficiente");
			}
		} else {
			System.out.println("fail: nao existe grafite no bico");
		}
		
	}

	@Override
	public String toString() {
		String ss = "";
		ss += "calibre: " + calibre + ", bico: ";
		
		if(hasGrafite()) {
			ss += tipo;
		} else {
			ss += "[]";
		}
		
		ss += ", tambor: {";
		for(Lead grafite : barrel) {
			ss += grafite;
		}
		ss += "}";
		
		return ss;
	}
}