package Bilheteria_II;

public class Venda {
	private Pessoa pessoa;
	private Setor setor;
	private double valor;
	
	public Venda(Pessoa pessoa, Setor setor) {
		this.pessoa = pessoa;
		this.setor = setor;
		this.valor = pessoa.isMeia() ? (setor.getPrice() / 2) : (setor.getPrice());
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public Setor getSetor() {
		return this.setor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	@ Override
	public String toString() {
		// bruno:samba:pista:17.50
		return this.pessoa.getName()
				+ ":" + this.setor.getEvento()
				+ ":" + this.setor.getName()
				+ ":" + String.format("%.2f", valor);
	}
}