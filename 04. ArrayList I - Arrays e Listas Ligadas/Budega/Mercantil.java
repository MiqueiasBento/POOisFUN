import java.util.*;

public class Mercantil {
	ArrayList<Pessoa> caixas;
	LinkedList<Pessoa> esperando;

	public Mercantil(int qtdCaixas) {
		this.caixas = new ArrayList<Pessoa>(qtdCaixas);	// Cria o array Caixa com a capacidade inicial de qtdCaixas
		for (int i = 0; i < qtdCaixas; i++) {			// Para preencher a lista de caixas existente com um valor null
			this.caixas.add(null);
		}
		this.esperando = new LinkedList<>();
	}

	private boolean validarIndice(int indice) {
		if (caixas.get(indice) == null) {
			return true;
		} else {
			return false;
		}
	}

	public void chegar(Pessoa pessoa) {
		esperando.addLast(pessoa); 		// Nova pessoa inserida na fila
	}

	public boolean chamar(int indice) {
		if (validarIndice(indice)) { 	// Se o caixa está vazio
			if (!esperando.isEmpty()) {						// Se ainda tem pessoas na fila
//			if(esperando.getFirst() != null) {	
				caixas.set(indice, esperando.getFirst());	// Caixa na posicao indice recebe a primeira pessoa da fila
				esperando.pop(); 							// Fila reajustada
				return true;
			} else {
				System.out.println("fail: sem clientes");
				return false;
			}
		} else {
			System.out.println("fail: caixa ocupado");
			return false;
		}
	}

	public void finalizar(int indice) {
		if(indice >= 0 && indice < caixas.size()){
			if (caixas.get(indice) != null) {
				caixas.set(indice, null);
			} else {
				System.out.println("fail: caixa vazio");
			}
		} else {
			System.out.println("fail: caixa inexistente");
		}
	}
	
	@Override
	public String toString() {
		String ss = "";

		ss += "[";
		for (Pessoa caixa : caixas) {
			if (caixa == null) {
				ss += "-----, ";
			} else {
				ss += caixa + ", ";
			}
		}
		ss = ss.substring(0, ss.length() - 2);
		ss += "]";

		return "Caixas: " + ss + "\nEspera: " + esperando;
	}
}