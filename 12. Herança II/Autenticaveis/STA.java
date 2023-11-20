package Autenticaveis;

public class STA extends FuncionarioAutenticavel {
	protected int nivel;

	// inicializa nivel e muda maxDiarias para 1
	public STA(String nome, int nivel) {
		super(nome);
		this.nivel = nivel;
		this.maxDiarias = 1;
	}

	public int getNivel() {
		return this.nivel;
	}

	// lógica do salário do sta
	// usa o super.getSalario() para pegar bonus e diarias
	@Override
	public int getSalario() {
		return super.getSalario() + 3000 + 300 * this.getNivel();
	}

	@Override
	public String toString() {
		return "sta:" + this.getNome() + ":" + this.getNivel() + ":" + this.getSalario();
	}
}
