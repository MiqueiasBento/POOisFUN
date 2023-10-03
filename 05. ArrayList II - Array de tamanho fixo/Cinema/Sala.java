package Cinema;

import java.util.ArrayList;

public class Sala {
	ArrayList<Client> cadeiras;
	
	public Sala(int qtd) {
		this.cadeiras = new ArrayList<>(qtd);
		for(int i = 0; i < qtd; i++) {
			this.cadeiras.add(null);
		}
	}
	
	private int procurar(String name) {
	    int i = 0;
	    for(Client pessoa : cadeiras) {
	    	if (pessoa != null && pessoa.getName().equals(name)) {
	            return i;
	        }
	    	i++;
	    }
	    return -1; // Não encontrou pessoas com o mesmo nome
	}
	
	private boolean verificarIndice(String id) {
		for(Client pessoa : cadeiras) {
			if(pessoa != null && pessoa.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void reservar(String name, String id, int nCadeira) {
		if(nCadeira >= 0 && nCadeira < cadeiras.size()) {
			if(cadeiras.get(nCadeira) == null) {
				if(!verificarIndice(id)) {
					if(procurar(name) == -1) {
						cadeiras.set(nCadeira, new Client(name, id));
					} else {
						println("fail: cliente ja esta no cinema");
					}
				} else {
					println("fail: id ja usado");
				}
			} else {
				println("fail: cadeira ja esta ocupada");
			}
		} else {
			println("fail: cadeira nao existe");
		}
	}
	
	public void cancelar(String name) {
		if(procurar(name) != -1) {
			cadeiras.set(procurar(name), null);
		} else {
			println("fail: cliente nao esta no cinema");
		}
		
	}
	
	public Client getClient(int indice) {
		return cadeiras.get(indice);
	}
	
	@ Override
	public String toString() {
		String ss = "";
		
		if(cadeiras.isEmpty()) {
			ss += "[]";
		} else {
			ss += "[";
			for(Client pessoa : cadeiras) {
				if(pessoa != null) {
					ss += pessoa + " ";
				} else {
					ss += "- ";
				}
			}
			ss = ss.substring(0, ss.length() - 1);
			ss += "]";
		}
		
		return ss;
	}
	
	public static void println(String str) { System.out.println(str); }
}