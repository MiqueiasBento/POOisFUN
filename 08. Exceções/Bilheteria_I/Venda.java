package Bilheteria_I;

public class Venda {
	private Pessoa pessoa;
	private Evento evento;
	private double valor;
	
	public Venda(Pessoa pessoa, Evento evento) {
		this.pessoa = pessoa;
		this.evento = evento;
		this.valor = pessoa.isMeia() ? (evento.getPrice() / 2) : (evento.getPrice());
	}
	
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	
	public Evento getEvento() {
		return this.evento;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	@ Override
	public String toString() {
		// bruno:samba:35.00 - meia
		return this.pessoa.getName() 
				+ ":" + this.evento.getName() 
				+ ":" + String.format("%.2f", valor);
	}
}